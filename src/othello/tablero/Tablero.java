package othello.tablero;

import java.util.List;

import othello.fichas.Ficha;
import othello.tablero.auxiliar.AuxiliarFichas;
import othello.tablero.auxiliar.AuxiliarMovimientos;
import othello.tablero.ubicacion.Coordenadas;

public class Tablero {

	// Global
	public static final int TAMANO_TABLERO = 10;

	public static final int INICIO_TABLERO = 1;
	public static final int FINAL_TABLERO = 8;

	public static final int ESPACIOS_DISPONIBLES = 64;

	// Atributos
	private final Ficha fichas[][];
	private final AuxiliarMovimientos auxMovimientos;
	private final AuxiliarFichas auxFichas;

	public Tablero() {
		this.fichas = new Ficha[TAMANO_TABLERO][TAMANO_TABLERO];
		this.auxMovimientos = new AuxiliarMovimientos(this);
		this.auxFichas = new AuxiliarFichas(this);
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

	public void limpiar() {
		for (int i = INICIO_TABLERO; i <= FINAL_TABLERO; i++) {
			for (int j = INICIO_TABLERO; j <= FINAL_TABLERO; j++) {
				fichas[i][j] = null;
			}
		}
	}

	public List<Coordenadas> movimientosPosibles(Ficha f) {
		return auxMovimientos.movimientosPosibles(f);
	}

	public List<Coordenadas> coordenadasFichasOpuestas(Ficha f, Coordenadas c) {
		return auxFichas.coordenadasFichasOpuestas(f, c.getFila(), c.getColumna());
	}

	public int darVueltaFichasOpuestas(Ficha f, Coordenadas c) {
		return auxFichas.darVueltaFichasOpuestas(f, c);
	}
}
