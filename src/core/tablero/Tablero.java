package core.tablero;

import core.fichas.Ficha;

public class Tablero {

	// Global
	public static final int TAMANO_TABLERO = 10;
	
	public static final int INICIO_TABLERO = 1;
	public static final int FINAL_TABLERO = 8;

	// Atributos
	private final Ficha fichas[][];

	public Tablero() {
		this.fichas = new Ficha[TAMANO_TABLERO][TAMANO_TABLERO];
	}

	public void asignarFicha(Ficha ficha, int fila, int columna) {
		if(fila >= INICIO_TABLERO && fila <= FINAL_TABLERO && columna >= INICIO_TABLERO && columna <= FINAL_TABLERO) {
			fichas[fila][columna] = ficha;
		}
	}
	
	public boolean hayFicha(int fila, int columna) {
		return fichas[fila][columna] != null;
	}
	
	public Ficha obtenerFicha(int fila, int columna) {
		return fichas[fila][columna];
	}
}
