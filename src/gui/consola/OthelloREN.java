package gui.consola;

import core.tablero.Tablero;

public class OthelloREN {

	public void imprimirTablero(Tablero t) {

		System.out.println("    0   1   2   3   4   5   6   7");
		System.out.println("  +---+---+---+---+---+---+---+---+");
		for (int i = 0; i < Tablero.TAMANO_TABLERO; i++) {

			for (int j = 0; j < Tablero.TAMANO_TABLERO; j++) {

				if (j == 0) {
					System.out.print(i + " | ");
				}

				// FICHA
				if (t.hayFicha(i, j)) {

					if (t.obtenerFicha(i, j).getColor() == "NEGRA") {
						System.out.print("N | ");
					} else {
						System.out.print("B | ");
					}
				} else {
					System.out.print("  | ");
				}
			}
			System.out.println("\n  +---+---+---+---+---+---+---+---+");
		}
	}
}
