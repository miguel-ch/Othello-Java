package othello.jugadores;

import othello.fichas.Ficha;

public abstract class Jugador {

	// Atributos
	protected final Ficha ficha;
	protected String nombre;
	protected int fichasEnTablero;
	protected int movsRealizados;

	// Constructor
	public Jugador(String nombre, Ficha ficha) {
		this.nombre = nombre;
		this.ficha = ficha;
		this.fichasEnTablero = 0;
		this.movsRealizados = 0;
	}

	// Funciones
	public void sumaFichas(int fichas) {
		if (fichas > 0) {
			this.fichasEnTablero += fichas;
		}
	}

	public void restarFichas(int fichas) {
		if (fichas > 0) {
			this.fichasEnTablero -= fichas;
		}
	}

	public void sumaMovs(int movs) {
		if (movs > 0) {
			this.movsRealizados += movs;
		}
	}

	public void limpiarInformacion() {
		this.fichasEnTablero = 0;
		this.movsRealizados = 0;
	}

	public Ficha fichaJugador() {
		return ficha.clone();
	}

	// Getters
	public String getNombre() {
		return nombre;
	}

	public int getFichasEnTablero() {
		return fichasEnTablero;
	}

	public int getMovsRealizados() {
		return movsRealizados;
	}
}
