package othello.tablero.auxiliar.direccion;

public class Cursor {

	// Atributos
	private int fila = 0;
	private int columna = 0;

	private int limInferior = 0;
	private int limSuperior = 0;

	private CursorDireccion direccion = CursorDireccion.CENTRO;

	// Constructor
	public Cursor(int fila, int columna, int limiteInferior, int limiteSuperior, CursorDireccion direccion) {
		this.fila = fila;
		this.columna = columna;
		this.limInferior = limiteInferior;
		this.limSuperior = limiteSuperior;
		this.direccion = direccion;
	}

	// Incrementa las coordenadas de la direccion en 1
	public void incrementar() {

		int nuevaFila = fila;
		int nuevaColumna = columna;

		// Cambia las coordenadas dependiendo la direccion que este almacenada
		switch (direccion) {
		case ARRIBA:
			nuevaFila--;
			break;
		case DERECHA:
			nuevaColumna++;
			break;
		case ABAJO:
			nuevaFila++;
			break;
		case IZQUIERDA:
			nuevaColumna--;
			break;
		case DIAGONAL_IZQUIERDA_ARRIBA:
			nuevaColumna--;
			nuevaFila--;
			break;
		case DIAGONAL_IZQUIERDA_ABAJO:
			nuevaColumna--;
			nuevaFila++;
			break;
		case DIAGONAL_DERECHA_ARRIBA:
			nuevaColumna++;
			nuevaFila--;
			break;
		case DIAGONAL_DERECHA_ABAJO:
			nuevaColumna++;
			nuevaFila++;
			break;
		default:
			nuevaColumna = columna;
			nuevaFila = fila;
		}

		// Verifica que no exceda los limites establecidos
		if (nuevaColumna > limSuperior || nuevaFila > limSuperior || nuevaColumna < limInferior
				|| nuevaFila < limInferior) {
			nuevaFila = fila;
			nuevaColumna = columna;
			direccion = CursorDireccion.CENTRO;
		}

		// Reemplaza las coordenadas con las nuevas
		this.fila = nuevaFila;
		this.columna = nuevaColumna;
	}

	// Getters
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public CursorDireccion getDireccion() {
		return direccion;
	}
}
