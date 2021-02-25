package gui.consola;

import java.util.List;

import gui.GUIJuego;
import gui.GUIPrincipal;
import othello.Othello;
import othello.OthelloEstado;
import othello.jugadores.Jugador;
import othello.tablero.ubicacion.Coordenadas;

public class ConsolaJuego extends GUIJuego {

	public ConsolaJuego(GUIPrincipal principal) {
		super(principal);
		this.opciones = new ConsolaJuegoOpciones(this);
		this.lecturaJugadores = new ConsolaLecturaJugadores(this);
	}

	@Override
	public void cargar() {
		lecturaJugadores.cargar();
	}

	@Override
	public void iniciarJuego(Jugador jugadorNegras, Jugador jugadorBlancas) {
		this.juego = new Othello(jugadorNegras, jugadorBlancas);
		this.jugadores = new ConsolaJugadores(jugadorNegras, jugadorBlancas);
		this.tablero = new ConsolaTablero(this, juego.getTablero(), (ConsolaJuegoOpciones) opciones);

		// Inicia primero el juego y despues carga la interfaz
		juego.iniciar();
		actualizarJuego();
	}

	@Override
	public void actualizarJuego() {

		// Verifica que el juego no haya terminado
		if (juego.getEstado() == OthelloEstado.TERMINO) {
			terminarJuego(false);
		} else {

			// Verifica que el posible jugador tenga movimientos
			List<Coordenadas> movs = juego.getPosiblesMovs();
			if (movs.size() <= 0) {
				System.out.println("El jugador " + juego.getJugadorActual().getNombre()
						+ " no puede realizar moviemientos, se continua con el proximo jugador");

				// Si no hay movimientos para el jugador actual, se cambia el jugador y se
				// vuelve a actualizar
				juego.cambiarJugador();
				actualizarJuego(); // Reincia la funcion actual con el nuevo jugador
			} else {

				// Se imprime el tablero y luego se espera a la entrada del usuario
				jugadores.actualizar();
				tablero.actualizarPosiblesMovimientos(movs);
				tablero.cargar();
				System.out.println("Es el turno del jugador " + juego.getJugadorActual().getNombre() + " | ...");
				((ConsolaTablero) tablero).leerMovimiento();
			}
		}
	}

	@Override
	public void terminarJuego(boolean volverAlMenu) {
		if (juego != null) {
			System.out.println();
			// Si termino, busca el ganador, y si no existe es porque existe un empate
			Jugador ganador = juego.ganador();
			if (ganador != null) {
				System.out.println("El jugador " + ganador.getNombre() + " gano el juego!");
			} else {
				System.out.println("El juego termino en un empate.");
			}
			System.out.println();
		}
		principal.cargar(); // Vuelve al menu principal
	}

	@Override
	public void reiniciarJuego(boolean leerJugadores) {
		if (juego != null) {
			if (leerJugadores) {
				cargar();	
			} else {
				juego.reiniciar();
				actualizarJuego();
			}
		}
	}

	@Override
	public void colocarFicha(int fila, int columna) {
		if (juego.colocarFichaJugadorActual(fila, columna)) {
			juego.cambiarJugador();
			actualizarJuego();
		} else {
			System.out.println("El movimiento no es valido!");
			((ConsolaTablero) tablero).leerMovimiento();
		}
	}
}
