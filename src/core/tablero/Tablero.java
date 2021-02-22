package core.tablero;

import core.fichas.Ficha;
import core.tablero.ubicacion.Coordenadas;

public class Tablero {

	// Global
	public static final int TAMANO_TABLERO = 10;

	public static final int INICIO_TABLERO = 1;
	public static final int FINAL_TABLERO = 8;

	public static final int ESPACIOS_DISPONIBLES = 64;
	
		// Atributos
	private final Ficha fichas[][];

	public Tablero() {
		this.fichas = new Ficha[TAMANO_TABLERO][TAMANO_TABLERO];
	}

	public boolean asignarFicha(Ficha ficha, int fila, int columna) {
		if (fila >= INICIO_TABLERO && fila <= FINAL_TABLERO && columna >= INICIO_TABLERO && columna <= FINAL_TABLERO) {
			fichas[fila][columna] = ficha;
			return true;
		}
		return false;
	}

	public boolean asignarFicha(Ficha ficha, Coordenadas coords) {
		return asignarFicha(ficha, coords.getFila(), coords.getColumna());
	}

	public boolean hayFicha(int fila, int columna) {
		return fichas[fila][columna] != null;
	}

	public Ficha obtenerFicha(int fila, int columna) {
		return fichas[fila][columna];
	}

	public int espaciosLlenos() {
		
		int llenos = 0;
		for (int i = INICIO_TABLERO; i <= FINAL_TABLERO; i++) {
			for (int j = INICIO_TABLERO; j <= FINAL_TABLERO; j++) {
				if (fichas[i][j] != null) {
					llenos++;
				}
			}
		}
		return llenos;
	}
}
