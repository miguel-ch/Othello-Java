package othello.tablero.auxiliar.direccion;

public enum CursorDireccion {

	CENTRO, ARRIBA, DERECHA, ABAJO, IZQUIERDA, DIAGONAL_IZQUIERDA_ARRIBA, DIAGONAL_IZQUIERDA_ABAJO,
	DIAGONAL_DERECHA_ARRIBA, DIAGONAL_DERECHA_ABAJO;

	public static CursorDireccion convertirDireccion(int celda) {
		// Direccion dependiendo de la cuadricula 9x9
		// |1|2|3|
		// |4|5|6|
		// |7|8|9|

		CursorDireccion direccion = CENTRO;

		switch (celda) {
		case 1:
			direccion = DIAGONAL_IZQUIERDA_ARRIBA;
			break;
		case 2:
			direccion = ARRIBA;
			break;
		case 3:
			direccion = DIAGONAL_DERECHA_ARRIBA;
			break;
		case 4:
			direccion = IZQUIERDA;
			break;
		case 5:
			direccion = CENTRO;
			break;
		case 6:
			direccion = DERECHA;
			break;
		case 7:
			direccion = DIAGONAL_IZQUIERDA_ABAJO;
			break;
		case 8:
			direccion = ABAJO;
			break;
		case 9:
			direccion = DIAGONAL_DERECHA_ABAJO;
			break;
		}
		return direccion;
	}
}
