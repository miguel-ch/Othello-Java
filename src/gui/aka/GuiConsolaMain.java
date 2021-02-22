package gui.aka;

import java.util.Scanner;

public class GuiConsolaMain {

	GuiConsolaJuego consola;

	public GuiConsolaMain() {
		this.consola = new GuiConsolaJuego(this);
	}

	public void iniciar() {

		Scanner in = new Scanner(System.in);
		int opcion = 0;

		do {
			System.out.println("|----- Menu Principal ----|\n" + "1) Iniciar juego\n" + "2) Instrucciones\n"
					+ "3) Acerca de\n" + "0) Salir\n");
			System.out.print("Ingrese una opcion del menu: ");
			try {
				opcion = Integer.parseInt(in.nextLine().trim());
			} catch (Exception e) {
				opcion = -1;
			}

			if (opcion < 0 || opcion > 3) {
				System.out.println("La opcion ingresada no es valida!\n");
			}
		} while (opcion < 0 || opcion > 3);
		ejecutarOpcion(opcion);

	}

	private void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			consola.iniciar();
			// iniciar();
			break;
		case 2:
			System.out.println("Proximamente...\n");
			iniciar();
			break;
		case 3:
			System.out.println("Proximamente...\n");
			iniciar();
			break;
		}
	}
}
