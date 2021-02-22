package gui.aka;

import java.util.List;

import core.Othello;
import core.OthelloEstado;
import core.jugadores.Jugador;
import core.tablero.ubicacion.Coordenadas;

public class GuiConsolaJuego {

	Othello ot;
	
	//Otras guis
	GuiConsolaTablero tab;
	GuiMovs movs;
	GuiConsolaJugadores jug;
	GuiConsolaLecturaJugadores lec;
	GuiConsolaMain main;
	GuiConsolaJuegoOpciones opc;

	public GuiConsolaJuego(GuiConsolaMain main) {
		this.main = main;
		this.lec = new GuiConsolaLecturaJugadores(this);
		this.opc = new GuiConsolaJuegoOpciones(this);
	}

	public void iniciar() {
		lec.iniciar();
	}

	public void iniciarJuego(Jugador negras, Jugador blancas) {

		this.ot = new Othello(negras, blancas);
		this.movs = new GuiMovs(this, opc);
		this.tab = new GuiConsolaTablero(ot.getTablero());
		this.jug = new GuiConsolaJugadores(negras, blancas);

		ot.iniciar();
		actualizarJuego();
	}

	public void actualizarJuego() {

		// Verifica que el juego no haya terminado
		if (ot.getEstado() == OthelloEstado.TERMINO) {
			terminarJuego();
		} else {

			// Verifica que el posible jugador tenga movimientos
			List<Coordenadas> movs = ot.getPosiblesMovs();
			if (movs.size() <= 0) {
				System.out.println("El jugador " + ot.getJugadorActual().getNombre()
						+ " no puede realizar moviemientos, se continua con el proximo jugador");

				// Si no hay movimientos para el jugador actual, se cambia el jugador y se
				// vuelve a actualizar
				ot.cambiarJugador();
				actualizarJuego(); // Reincia la funcion actual con el nuevo jugador
			} else {

				// Se imprime el tablero y luego se espera a la entrada del usuario
				jug.actualizar();
				tab.render(movs);
				actualizarMovimientos();
			}
		}
	}

	// Se supone que este metodo actualiza los botones que se podrian clickear en el
	// gui, en consola, lee la posicion
	public void actualizarMovimientos() {
		System.out.println("\nEs turno del jugador: " + ot.getJugadorActual().getNombre());
		movs.actualizar();
	}

	public void colocarFicha(int fila, int columna) {
		if (ot.colocarFicha(ot.getJugadorActual(), fila, columna)) {
			ot.cambiarJugador();
			actualizarJuego();
		} else {
			System.out.println("El movimiento no es valido!");
			movs.actualizar();
		}
	}

	public void terminarJuego() {

		if (ot != null) {
			System.out.println();
			// Si termino, busca el ganador, y si no existe es porque existe un empate
			Jugador ganador = ot.ganador();
			if (ganador != null) {
				System.out.println("El jugador " + ganador.getNombre() + " gano el juego!");
			} else {
				System.out.println("El juego termino en un empate.");
			}
			System.out.println();
		}
		main.iniciar(); // Vuelve al menu principal
	}

	public void reiniciarJuego(boolean leerJugadores) {

		if (ot != null) {
			if (leerJugadores) {
				this.iniciar();
			} else {
				iniciarJuego(ot.getJugNegras(), ot.getJugBlancas());
			}
		}
	}
}
