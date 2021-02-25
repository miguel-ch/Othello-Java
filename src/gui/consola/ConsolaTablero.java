package gui.consola;

import java.util.List;
import java.util.Scanner;

import gui.GUIJuego;
import gui.GUITablero;
import othello.fichas.FichaColor;
import othello.tablero.Tablero;
import othello.tablero.ubicacion.Coordenadas;

public class ConsolaTablero extends GUITablero {

	private final ConsolaJuegoOpciones opciones;

	public ConsolaTablero(GUIJuego j, Tablero t, ConsolaJuegoOpciones opciones) {
		super(j, t);
		this.opciones = opciones;
	}

	@Override	
	public void cargar() {

		// Imprime el tablero
		System.out.println("    1   2   3   4   5   6   7   8");
		System.out.println("  +---+---+---+---+---+---+---+---+");
		for (int i = Tablero.INICIO_TABLERO; i <= Tablero.FINAL_TABLERO; i++) {

			for (int j = Tablero.INICIO_TABLERO; j <= Tablero.FINAL_TABLERO; j++) {

				String casilla = "  | ";

				// Borde del inicio del tablero
				if (j == Tablero.INICIO_TABLERO) {
					System.out.print(i + " | ");
				}

				// Ficha en el tablero
				if (tablero.hayFicha(i, j)) {
					if (tablero.obtenerFicha(i, j).getColor() == FichaColor.NEGRA) {
						casilla = "○ | ";
					} else {
						casilla = "● | ";
					}
				} else {

					// Si se recibieron posibles movimientos, busca el que coincida
					if (posiblesMovimientos != null && posiblesMovimientos.size() > 0) {

						// Recorre el arreglo de movimientos en busca del posible moviemento
						for (Coordenadas c : posiblesMovimientos) {
							if (c.getFila() == i && c.getColumna() == j) {
								casilla = "* | ";
								break;
							}
						}
					}
				}
				System.out.print(casilla);
			}
			System.out.println("\n  +---+---+---+---+---+---+---+---+");
		}
	}

	@Override
	public void actualizar() {
		cargar();
	}

	@Override
	public void actualizarPosiblesMovimientos(List<Coordenadas> movimientos) {
		this.posiblesMovimientos = movimientos;
	}

	public void leerMovimiento() {
		Scanner in = new Scanner(System.in);
		String nums[] = null;

		int fila;
		int columna;

		boolean lecturaValida = false;

		// Lee en consola hasta que la linea sea valida
		do {
			System.out.print(
					"Ingrese la fila y columna separadas por un espacio o '0' para abrir el menu de opciones.\n> ");

			String tmp = in.nextLine().trim();
			if (tmp.equals("0")) {
				lecturaValida = true;
				opciones.cargar();
			}

			nums = tmp.split(" ");

			if (nums != null && nums.length >= 2 && nums[0] != null && nums[1] != null) {

				// Convierte la fila y columna en enteros
				try {
					fila = Integer.parseInt(nums[0].trim());
					columna = Integer.parseInt(nums[1].trim());

					if (fila >= 1 && fila <= 8 && columna >= 1 && columna <= 8) {
						lecturaValida = true;
						juego.colocarFicha(fila, columna);
					} else {
						System.out.println(
								"\nLa fila y/o columna deben encontrarse entre los espacios del tablero! (1-8)");
					}
				} catch (Exception e) {
					System.out.println("\nLos valores de las coordenadas no son validos!");
				}
			}

		} while (!lecturaValida);
	}
}
