package othello.tablero.ubicacion;

public class Coordenadas {

	// Coordenadas en el tablero
	private final int fila;
	private final int columna;

	// Constructor
	public Coordenadas(int f, int c) {
		this.fila = f;
		this.columna = c;
	}

	// Override del metodo equals
	@Override
	public boolean equals(Object obj) {

		// Verifica que el objeto exista y corresponda a una instancia la clase
		if (obj == null || !(obj instanceof Coordenadas)) {
			return false;
		}

		// Casting del objeto para comparar la fila y columna
		final Coordenadas c = (Coordenadas) obj;
		return fila == c.fila && columna == c.columna;
	}

	// Getters
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}
}
