package gui.aka;

import java.util.List;

import core.fichas.FichaColor;
import core.tablero.Tablero;
import core.tablero.ubicacion.Coordenadas;

public class GuiConsolaTablero {

	private Tablero tablero;

	public GuiConsolaTablero(Tablero t) {
		this.tablero = t;
	}
	
	public void render() {
		render(null);
	}

	public void render(List<Coordenadas> movs) {

		// Imprime el tablero
		System.out.println("    1   2   3   4   5   6   7   8");
		System.out.println("  +---+---+---+---+---+---+---+---+");
		for (int i = Tablero.INICIO_TABLERO; i <= Tablero.FINAL_TABLERO; i++) {

			for (int j = Tablero.INICIO_TABLERO; j <= Tablero.FINAL_TABLERO; j++) {

				String casilla = "  | ";

				//Borde del inicio del tablero
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
					if (movs != null && movs.size() > 0) {

						// Recorre el arreglo de movimientos en busca del posible moviemento
						for (Coordenadas c : movs) {
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
}
