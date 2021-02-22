package gui.aka;

import core.jugadores.Jugador;

public class GuiConsolaJugadores {
	
	private GuiConsolaJugador guiNeg;
	private GuiConsolaJugador guiBlan;
	
	public GuiConsolaJugadores(Jugador negras, Jugador blancas) {
		this.guiNeg = new GuiConsolaJugador(negras);
		this.guiBlan = new GuiConsolaJugador(blancas);
	}
	
	public void actualizar() {
		guiNeg.actualizar();
		guiBlan.actualizar();
	}
}
