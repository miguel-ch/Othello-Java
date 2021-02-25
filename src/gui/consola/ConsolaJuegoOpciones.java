package gui.consola;

import java.util.Scanner;

import gui.GUIJuego;
import gui.GUIOpciones;

public class ConsolaJuegoOpciones extends GUIOpciones {

	public ConsolaJuegoOpciones(GUIJuego j) {
		super(j);
	}

	@Override
	public void cargar() {
		mostarOpciones();
	}

	private void mostarOpciones() {

		int opcion = 0;
		Scanner in = new Scanner(System.in);
		do {

			// Imprime opciones
			System.out.println("\n|-----Opciones de juego-----|\n" + "1) Reiniciar juego\n" + "2) Salir del juego\n"
					+ "0) Salir del menu\n");

			System.out.print("Ingrese una opcion del menu: ");

			// Lee la opcion
			try {
				opcion = Integer.parseInt(in.nextLine().trim());
			} catch (Exception e) {
				opcion = -1;
			}

			// Verifica opcion para enviar un mensaje
			if (opcion < 0 || opcion > 2) {
				System.out.println("Debe ingresar una opcion valida!");
			}
		} while (opcion < 0 || opcion > 2);
		ejecutarOpcion(opcion);
	}

	private void ejecutarOpcion(int opcion) {

		switch (opcion) {
		case 1:
			juego.reiniciarJuego(true);
			break;
		case 2:
			juego.terminarJuego(true);
			break;
		default:
			juego.actualizarJuego();
		}
	}
}
