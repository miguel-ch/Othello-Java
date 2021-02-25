package gui.consola;

import gui.GUIJugadorInformacion;
import othello.jugadores.Jugador;

public class ConsolaJugador extends GUIJugadorInformacion {

	public ConsolaJugador(Jugador j) {
		super(j);
	}

	@Override
	public void cargar() {
		System.out.println("\n| Jugador: " + jugador.getNombre() + "\t |");
		System.out.println("| Ficha: " + jugador.fichaJugador().getColor() + "\t\t |");
		System.out.println("| Fichas en tablero: " + jugador.getFichasEnTablero() + "\t |");
		System.out.println("| Movs. realizados: " + jugador.getMovsRealizados() + "\t |\n");
	}
	
	@Override
	public void actualizar() {
		cargar();
	}
}
