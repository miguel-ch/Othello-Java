package gui.swing.juego.opciones;

import javax.swing.JOptionPane;

import gui.GUIOpciones;
import gui.swing.juego.JuegoGUI;

public class OpcionesJuegoGUI extends GUIOpciones {

	private OpcionesJuegoComponente componente;

	public OpcionesJuegoGUI(JuegoGUI j) {
		super(j);
		this.componente = new OpcionesJuegoComponente(this);
	}

	public void reiniciar() {

		boolean reiniciarJugadores = JOptionPane.showConfirmDialog(null,
				"Desea reiniciar el juego cambiando los jugadores?", "Reiniciar juego",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ? true : false;
		juego.reiniciarJuego(reiniciarJugadores);
	}

	public void salir() {
		boolean terminarJuego = JOptionPane.showConfirmDialog(null,
				"Desea terminar el juego y volver al menu princiapal?", "Terminar juego",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ? true : false;
		if (terminarJuego) {
			juego.terminarJuego(true);
		}
	}

	public OpcionesJuegoComponente getComponente() {
		return componente;
	}

	@Override
	public void cargar() {
		this.componente = new OpcionesJuegoComponente(this);
	}
}
