package gui.aka;

import java.util.Scanner;

public class GuiMovs {

	private final GuiConsolaJuego cons;
	private final GuiConsolaJuegoOpciones opc;

	public GuiMovs(GuiConsolaJuego cons, GuiConsolaJuegoOpciones opc) {
		this.cons = cons;
		this.opc = opc;
	}

	public void actualizar() {

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
				opc.inciar();
			}

			nums = tmp.split(" ");

			if (nums != null && nums.length >= 2 && nums[0] != null && nums[1] != null) {

				// Convierte la fila y columna en enteros
				try {
					fila = Integer.parseInt(nums[0].trim());
					columna = Integer.parseInt(nums[1].trim());

					if (fila >= 1 && fila <= 8 && columna >= 1 && columna <= 8) {
						lecturaValida = true;
						cons.colocarFicha(fila, columna);
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
