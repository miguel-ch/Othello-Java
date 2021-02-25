package gui.consola;

import java.util.Scanner;

import gui.GUIJuego;
import gui.GUILecturaJugadores;
import othello.jugadores.creador.CreadorJugadores;
import othello.jugadores.creador.OpcionFichas;
import othello.jugadores.creador.PlantillaJugador;

public class ConsolaLecturaJugadores extends GUILecturaJugadores {

	public ConsolaLecturaJugadores(GUIJuego j) {
		super(j);
	}

	@Override
	public void cargar() {
		System.out.println("\n|-----INFORMACION PARA EL JUGADOR UNO-----|");
		this.jugadorUno = leerJugador();
		System.out.println("\n|-----INFORMACION PARA EL JUGADOR DOS-----|");
		this.jugadorDos = leerJugador();
		cargarJugadoresAJuego();
	}

	@Override
	public void cargarJugadoresAJuego() {

		if (jugadorUno != null && jugadorDos != null) {

			CreadorJugadores creador = new CreadorJugadores(jugadorUno, jugadorDos);
			if (creador.crear()) {
				juego.iniciarJuego(creador.getNegras(), creador.getBlancas());
			} else {
				System.out.println("Hay datos invalidos para la creacion de jugadores, por favor intente de nuevo.");
				cargar();
			}
		}
	}

	private OpcionFichas leerOpcionFichas() {
		OpcionFichas opcion = null;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("\n|-----Opciones de fichas-----|" + "\n1) Fichas negras" + "\n2) Fichas blancas"
					+ "\n3) Aleatoriamente");
			System.out.print("\nElija un color de ficha para el juego: ");

			// Lee la opcion y la convierte a opciones fichas
			try {
				int num = Integer.parseInt(in.nextLine().trim());
				if (num > 0 && num <= 3) {
					switch (num) {
					case 1:
						opcion = OpcionFichas.NEGRAS;
						break;
					case 2:
						opcion = OpcionFichas.BLANCAS;
						break;
					case 3:
						opcion = OpcionFichas.ALEATORIO;
					}
				}
			} catch (Exception ex) {
				opcion = null;
			}

			if (opcion == null) {
				System.out.println("Debe ingresar una opcion valida para las fichas!");
			}
		} while (opcion == null);
		return opcion;
	}

	private PlantillaJugador leerJugador(boolean esMaquina) {

		String nombre = "";
		OpcionFichas opcion = null;
		Scanner in = new Scanner(System.in);
		do {

			System.out.print("Ingrese el nombre del jugador: ");
			nombre = in.nextLine().trim();
			opcion = leerOpcionFichas();

			// Envia un mensaje en caso de que no se haya recolectado la informacion
			if (nombre.isEmpty() || opcion == null) {
				System.out.println("Datos no validos! Ingrese la informacion nuevamente.");
			}

		} while (nombre.isEmpty() || opcion == null);

		// Verifica la informacion y crea la plantilla
		if (!nombre.isEmpty() && opcion != null) {
			return new PlantillaJugador(nombre, opcion, esMaquina);
		}
		return null;
	}

	private PlantillaJugador leerJugador() {
		return leerJugador(false);
	}
}
