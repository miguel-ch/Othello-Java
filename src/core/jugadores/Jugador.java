package core.jugadores;

import core.fichas.Ficha;

public abstract class Jugador {

	// Atributos
	private final Ficha ficha;
	private String nombre;
	private int fichasEnTablero;
	private int movsRealizados;
	private int puntaje;

	// Constructor
	public Jugador(String nombre, Ficha ficha) {
		this.nombre = nombre;
		this.ficha = ficha;
		this.fichasEnTablero = 0;
		this.movsRealizados = 0;
		this.puntaje = 0;
	}

	// Funciones
	public void sumaFichas(int fichas) {
		if (fichas > 0) {
			this.fichasEnTablero += fichas;
		}
	}
	
	public void restarFichas(int fichas) {
		if(fichas > 0) {
			this.fichasEnTablero -= fichas;
		}
	}

	public void sumaMovs(int movs) {
		if (movs > 0) {
			this.movsRealizados += movs;
		}
	}
	
	public void actualizaPuntaje(int puntos) {
		if(puntaje + puntos > 0) {
			this.puntaje += puntos;
		}else {
			this.puntaje = 0;
		}
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

	public int getPuntaje() {
		return puntaje;
	}
}
