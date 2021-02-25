package gui.consola;

import java.util.Scanner;

import gui.GUIPrincipal;

public class OthelloConsola extends GUIPrincipal {

	public OthelloConsola() {
		this.ventanaJuego = new ConsolaJuego(this);
	}

	@Override
	public void cargar() {
		Scanner in = new Scanner(System.in);
		int opcion = 0;

		do {
			System.out
					.println("|----- Menu Principal ----|\n" + "1) Iniciar juego\n" + "2) Acerca de\n" + "0) Salir\n");
			System.out.print("Ingrese una opcion del menu: ");
			try {
				opcion = Integer.parseInt(in.nextLine().trim());
			} catch (Exception e) {
				opcion = -1;
			}

			if (opcion < 0 || opcion > 2) {
				System.out.println("La opcion ingresada no es valida!\n");
			}
		} while (opcion < 0 || opcion > 2);
		ejecutarOpcion(opcion);
	}

	// Ejecuta la opcion
	private void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			ventanaJuego.cargar();
			break;
		case 2:
			System.out.println("Othello 2021\n");
			cargar();
			break;
		}
	}
}
