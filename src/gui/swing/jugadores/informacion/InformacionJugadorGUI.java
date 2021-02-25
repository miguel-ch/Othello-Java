package gui.swing.jugadores.informacion;

import gui.GUIJugadorInformacion;
import gui.swing.casilla.CasillaComponente.TipoCasilla;
import othello.fichas.FichaColor;
import othello.jugadores.Jugador;

public class InformacionJugadorGUI extends GUIJugadorInformacion {

	private InformacionJugadorComponente componente;

	public InformacionJugadorGUI(Jugador j) {
		super(j);
		this.componente = new InformacionJugadorComponente();
	}

	public InformacionJugadorComponente getComponente() {
		return componente;
	}

	@Override
	public void cargar() {
		this.componente.getNombre().setText(jugador.getNombre());
		if (jugador.fichaJugador().getColor() == FichaColor.NEGRA) {
			this.componente.getFicha().cambiarCasilla(TipoCasilla.FICHA_NEGRA);
		} else {
			this.componente.getFicha().cambiarCasilla(TipoCasilla.FICHA_BLANCA);
		}
		actualizar();
	}

	@Override
	public void actualizar() {
		this.componente.getCantidadFichas().setText(String.valueOf(jugador.getFichasEnTablero()));
	}
}
