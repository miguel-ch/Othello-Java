package othello;

import java.util.List;

import othello.fichas.Ficha;
import othello.jugadores.Jugador;
import othello.jugadores.Maquina;
import othello.tablero.Tablero;
import othello.tablero.ubicacion.Coordenadas;

public class Othello {

	// Estado
	private OthelloEstado estado;

	// Jugadores
	private Jugador jugBlancas;
	private Jugador jugNegras;

	// Jugador actual
	private Jugador jugadorActual;
	private List<Coordenadas> posiblesMovs;

	// Tablero
	private final Tablero tablero;

	// Constructor
	public Othello(Jugador negras, Jugador blancas) {
		this.tablero = new Tablero();
		this.estado = OthelloEstado.SIN_INICIAR;

		// Agrega los jugadores
		this.jugNegras = negras;
		this.jugBlancas = blancas;
	}

	// Inicia el tablero y el juego
	public void iniciar() {

		// Actualiza el estado del juego
		this.estado = OthelloEstado.EN_CURSO;

		// Fichas iniciales
		this.tablero.asignarFicha(jugBlancas.fichaJugador(), 4, 4);
		this.tablero.asignarFicha(jugBlancas.fichaJugador(), 5, 5);
		this.tablero.asignarFicha(jugNegras.fichaJugador(), 4, 5);
		this.tablero.asignarFicha(jugNegras.fichaJugador(), 5, 4);

		// Actualiza el jugador
		cambiarJugador();

		// Actualiza las fichas de los jugadores
		this.jugBlancas.sumaFichas(2);
		this.jugNegras.sumaFichas(2);
	}

	public void cambiarJugador() {

		// Actualiza el jugador dependiendo del ultimo
		if (jugadorActual == null) {
			this.jugadorActual = jugNegras;
		} else {
			this.jugadorActual = jugadorActual == jugNegras ? jugBlancas : jugNegras;
		}

		// Carga los posibles movimentos
		this.posiblesMovs = tablero.movimientosPosibles(jugadorActual.fichaJugador());

		// Si es maquina, ejecuta el movimiento
		if (jugadorActual instanceof Maquina) {
			Coordenadas coords = ((Maquina) jugadorActual).movimientoEnTablero(tablero);
			if (coords != null) {
				colocarFichaJugadorActual(coords.getFila(), coords.getColumna());
				cambiarJugador();
			}
		}

	}

	public boolean colocarFichaJugadorActual(int fila, int columna) {

		// Informacion temporal
		boolean coloco = false; // Se asigno la ficha en tablero

		// Verifica que el jugador que coloca la ficha sea el que se encuentra jugando
		if (estado == OthelloEstado.EN_CURSO && jugadorActual != null) {

			Ficha tmpFicha = jugadorActual.fichaJugador();
			Coordenadas tmpCoords = new Coordenadas(fila, columna);

			// Verifica si el movimiento es posible
			for (Coordenadas c : posiblesMovs) {
				if (tmpCoords.equals(c)) {
					coloco = tablero.asignarFicha(tmpFicha, tmpCoords);
					break;
				}
			}

			// Si coloco la ficha, da vuelta a las fichas opuestas posibles
			if (coloco) {
				voltearFichas(tmpFicha, tmpCoords);
				jugadorActual.sumaFichas(1); // Ficha que coloco
				jugadorActual.sumaMovs(1); // Movimiento valido
				posiblesMovs.clear();
			}
			actualizarEstadoJuego(); // Verifica si el juego termina o sigue
		}
		return coloco;
	}

	private void voltearFichas(Ficha f, Coordenadas coords) {

		Jugador opuesto = jugadorActual == jugNegras ? jugBlancas : jugNegras;
		int volteadas = tablero.darVueltaFichasOpuestas(f, coords);
		jugadorActual.sumaFichas(volteadas);
		opuesto.restarFichas(volteadas);
	}

	// Verifica si el juego ya acabo
	public void actualizarEstadoJuego() {

		// Verifica si estan llenos todos los espacios disponibles en el tablero
		if (tablero.espaciosLlenos() >= Tablero.ESPACIOS_DISPONIBLES) {
			this.estado = OthelloEstado.TERMINO;
			return;
		}

		// Verifica si los jugadores ya no tienen posibles movimientos
		List<Coordenadas> movsBlanco = tablero.movimientosPosibles(jugBlancas.fichaJugador());
		List<Coordenadas> movsNegro = tablero.movimientosPosibles(jugBlancas.fichaJugador());

		// No tienen posibles movimientos
		if (movsBlanco.size() <= 0 && movsNegro.size() <= 0) {
			this.estado = OthelloEstado.TERMINO;
			return;
		}
	}

	// Retorna el jugador que gano
	public Jugador ganador() {
		Jugador ganador = null;
		if (jugNegras.getFichasEnTablero() > jugBlancas.getFichasEnTablero()) {
			ganador = jugNegras;
		} else if (jugNegras.getFichasEnTablero() < jugBlancas.getFichasEnTablero()) {
			ganador = jugBlancas;
		}
		return ganador;
	}

	// Reinicia el juego
	public void reiniciar() {
		this.tablero.limpiar();
		this.jugNegras.limpiarInformacion();
		this.jugBlancas.limpiarInformacion();
		iniciar();
	}

	public Tablero getTablero() {
		return tablero;
	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}

	public Jugador getJugBlancas() {
		return jugBlancas;
	}

	public Jugador getJugNegras() {
		return jugNegras;
	}

	public List<Coordenadas> getPosiblesMovs() {
		return posiblesMovs;
	}

	public OthelloEstado getEstado() {
		return estado;
	}
}
