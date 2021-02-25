package gui.swing.juego;

import java.awt.Color;
import java.util.List;

import javax.swing.JOptionPane;

import gui.GUIJuego;
import gui.swing.jugadores.JugadoresGUI;
import gui.swing.jugadores.lectura.LecturaJugadoresGUI;
import gui.swing.menu.PrincipalGUI;
import gui.swing.tablero.TableroGUI;
import othello.Othello;
import othello.OthelloEstado;
import othello.jugadores.Jugador;
import othello.tablero.ubicacion.Coordenadas;

public class JuegoGUI extends GUIJuego {

	private JuegoPanel juegoPanel;
	private LecturaJugadoresGUI lectura;

	public JuegoGUI(PrincipalGUI p) {
		super(p);
		this.lectura = new LecturaJugadoresGUI(this);
	}

	public JuegoPanel getJuego() {
		return juegoPanel;
	}

	@Override
	public void cargar() {
		((PrincipalGUI) principal).cargarPanel(lectura.getComponente());
	}

	@Override
	public void iniciarJuego(Jugador jugadorNegras, Jugador jugadorBlancas) {

		this.juego = new Othello(jugadorNegras, jugadorBlancas);
		this.tablero = new TableroGUI(this, juego.getTablero());
		this.jugadores = new JugadoresGUI(jugadorNegras, jugadorBlancas);
		this.juegoPanel = new JuegoPanel(this, (TableroGUI) tablero, (JugadoresGUI) jugadores);

		juego.iniciar();
		tablero.cargar();
		jugadores.cargar();
		actualizarJuego();

		((PrincipalGUI) principal).cargarPanel(juegoPanel);
	}

	@Override
	public void actualizarJuego() {

		tablero.actualizarPosiblesMovimientos(null);
		jugadores.actualizar();
		tablero.actualizar();

		// Verifica que el juego no haya terminado
		if (juego.getEstado() == OthelloEstado.TERMINO) {
			terminarJuego(false);	
		} else {

			// Verifica que el posible jugador tenga movimientos
			List<Coordenadas> movs = juego.getPosiblesMovs();
			if (movs.size() <= 0) {
				JOptionPane.showMessageDialog(null,
						"El jugador '" + juego.getJugadorActual().getNombre()
								+ "' no tiene movimientos posibles!\nEl turno es del siguiente jugador.",
						"Jugador sin posibles movimientos", JOptionPane.INFORMATION_MESSAGE);

				// Si no hay movimientos para el jugador actual, se cambia el jugador y se
				// vuelve a actualizar
				juego.cambiarJugador();
				actualizarJuego(); // Reincia la funcion actual con el nuevo jugador
			} else {

				jugadores.actualizar();
				tablero.actualizarPosiblesMovimientos(movs);
				tablero.actualizar();
				juegoPanel.getEstado().setText("ES EL TURNO DE " + juego.getJugadorActual().getNombre());
			}
		}

	}

	@Override
	public void terminarJuego(boolean volverAlMenu) {
		if (juego != null) {
			// Si termino, busca el ganador, y si no existe es porque existe un empate
			Jugador ganador = juego.ganador();
			if (ganador != null) {

				// Actualiza el panel de estado
				juegoPanel.getEstado().setText("El JUGADOR " + ganador.getNombre() + " ES EL GANADOR");
				juegoPanel.getEstadoPanel().setBackground(Color.decode(JuegoPanel.ESTADO_GANADOR));
			} else {

				// Actualiza el panel de estado
				juegoPanel.getEstado().setText("El JUEGO TERMINO EN UN EMPATE");
				juegoPanel.getEstadoPanel().setBackground(Color.decode(JuegoPanel.ESTADO_EMPATE));
			}
		}

		if (volverAlMenu) {
			principal.cargar(); // Vuelve al menu principal
		}
	}

	// Vuelve a cargar la ventana con posibilidad de cambiar la informacion de los
	// jugadores
	@Override
	public void reiniciarJuego(boolean leerJugadores) {
		if (leerJugadores) {
			cargar();
		} else {
			// Limpia la info de los jugadores
			juego.reiniciar();
			actualizarJuego();
		}
	}

	// Coloca una ficha y si el movimiento fue valido actualiza la ventana
	@Override
	public void colocarFicha(int fila, int columna) {
		if (juego.colocarFichaJugadorActual(fila + 1, columna + 1)) {
			juego.cambiarJugador();
			actualizarJuego();
			// MAQUINA
			/*
			 * Jugador tmp = juego.getJugadorActual(); if (tmp instanceof Maquina) {
			 * 
			 * //tablero.actualizar(); try { Thread.sleep(2000); } catch
			 * (InterruptedException e) { e.printStackTrace(); } juego.cambiarJugador();
			 * actualizarJuego(); }
			 */
		}
	}
}
