package core.tablero;

import core.fichas.Ficha;

public class Tablero {

	// Global
	public static final int FILAS_TABLERO = 8;
	public static final int COLUMNAS_TABLERO = 8;
	
	public static final int TAMANO_TABLERO = 8;

	// Atributos
	private final Ficha fichas[][];

	public Tablero() {
		this.fichas = new Ficha[FILAS_TABLERO][COLUMNAS_TABLERO];
	}

	public void asignarFicha(Ficha ficha, int fila, int columna) {
		try {
			fichas[fila][columna] = ficha;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ocurrio un error al asignar una ficha en [" + fila + "][" + columna + "].\n");
		}
	}
	
	public boolean hayFicha(int fila, int columna) {
		return fichas[fila][columna] != null;
	}
	
	public Ficha obtenerFicha(int fila, int columna) {
		return fichas[fila][columna];
	}
}
