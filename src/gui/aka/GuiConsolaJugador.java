package gui.aka;

import core.jugadores.Jugador;

public class GuiConsolaJugador {

	private Jugador jug;
	
	public GuiConsolaJugador(Jugador j) {
		this.jug = j;
	}
	
	public void actualizar() {
		
		System.out.println("\n| Jugador: " + jug.getNombre() + "\t |");
		System.out.println("| Ficha: " + jug.fichaJugador().getColor() + "\t\t |");
		System.out.println("| Fichas en tablero: " + jug.getFichasEnTablero() + "\t |");
		System.out.println("| Movs. realizados: " + jug.getMovsRealizados() + "\t |\n");
	}
}
