package core.man;

public class Cursor {

	// Atributos
	private int x = 0;
	private int y = 0;
	private Direccion dir;
	
	//Constructor
	public Cursor(int fila, int columna, Direccion dir) {
		this.y = fila;
		this.x = columna;
		this.dir = dir;
	}

	//Incrementa las coordenadas de la direccion en 1
	public void incrementar(int limite) {

		int nuevoX = x;
		int nuevoY = y;

		//Cambia las coordenadas dependiendo la direccion que este almacenada
		switch (dir) {
		case ARRIBA:
			nuevoY--;
			break;
		case DERECHA:
			nuevoX++;
			break;
		case ABAJO:
			nuevoY++;
			break;
		case IZQUIERDA:
			nuevoX--;
			break;
		case DIAGONAL_IZQUIERDA_ARRIBA:
			nuevoX--;
			nuevoY--;
			break;
		case DIAGONAL_IZQUIERDA_ABAJO:
			nuevoX--;
			nuevoY++;
			break;
		case DIAGONAL_DERECHA_ARRIBA:
			nuevoX++;
			nuevoY--;
			break;
		case DIAGONAL_DERECHA_ABAJO:
			nuevoX++;
			nuevoY++;
			break;
		default:
			nuevoX = x;
			nuevoY = y;
		}
			
		//Verifica que no exceda los limites establecidos
		if(nuevoX >= limite || nuevoY >= limite || nuevoX < 0 || nuevoY < 0) {
			nuevoX = x;
			nuevoY = y;
			dir = Direccion.CENTRO;
		}
		
		//Reemplaza las coordenadas con las nuevas
		this.x = nuevoX;
		this.y = nuevoY;
	}

	//Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direccion getDir() {
		return dir;
	}
}
