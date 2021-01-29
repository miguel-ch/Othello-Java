package core.man;

public enum Direccion {

	CENTRO, ARRIBA, DERECHA, ABAJO, IZQUIERDA, DIAGONAL_IZQUIERDA_ARRIBA, DIAGONAL_IZQUIERDA_ABAJO,
	DIAGONAL_DERECHA_ARRIBA, DIAGONAL_DERECHA_ABAJO;

	public static Direccion convertirDireccion(int celda) {
		// Direccion dependiendo de la cuadricula 9x9
		// |1|2|3|
		// |4|5|6|
		// |7|8|9|

		Direccion dir = CENTRO;

		switch (celda) {
		case 1:
			dir = DIAGONAL_IZQUIERDA_ARRIBA;
			break;
		case 2:
			dir = ARRIBA;
			break;
		case 3:
			dir = DIAGONAL_DERECHA_ARRIBA;
			break;
		case 4:
			dir = IZQUIERDA;
			break;
		case 5:
			dir = CENTRO;
			break;
		case 6:
			dir = DERECHA;
			break;
		case 7:
			dir = DIAGONAL_IZQUIERDA_ABAJO;
			break;
		case 8:
			dir = ABAJO;
			break;
		case 9:
			dir = DIAGONAL_DERECHA_ABAJO;
			break;
		}
		return dir;
	}
}
