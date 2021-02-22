package gui.aka;

import java.util.Scanner;

public class GuiConsolaJuegoOpciones {

	private final GuiConsolaJuego con;

	public GuiConsolaJuegoOpciones(GuiConsolaJuego con) {
		this.con = con;
	}

	public void inciar() {
		mostarOpciones();
	}

	private void mostarOpciones() {

		int opcion = 0;
		Scanner in = new Scanner(System.in);
		do {

			System.out.println("\n|-----Opciones de juego-----|\n" + "1) Reiniciar juego\n" + "2) Salir del juego\n"
					+ "0) Salir del menu\n");

			System.out.print("Ingrese una opcion del menu: ");
			try {
				opcion = Integer.parseInt(in.nextLine().trim());
			} catch (Exception e) {
				opcion = -1;
			}

			if (opcion < 0 || opcion > 2) {
				System.out.println("Debe ingresar una opcion valida!");
			}
		} while (opcion < 0 || opcion > 2);
		ejecutarOpcion(opcion);
	}

	private void ejecutarOpcion(int opcion) {

		switch (opcion) {
		case 1:
			con.reiniciarJuego(true);
			break;
		case 2:
			con.terminarJuego();
			break;
		default:
			con.actualizarJuego();
		}
	}
}
