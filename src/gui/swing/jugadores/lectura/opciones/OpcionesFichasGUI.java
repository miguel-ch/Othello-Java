package gui.swing.jugadores.lectura.opciones;

import gui.swing.casilla.CasillaComponente;

public class OpcionesFichasGUI {

	private OpcionesFichasComponente componente;
	private CasillaComponente seleccionada;
	private int opcionSeleccionada = 0;

	public OpcionesFichasGUI() {
		this.componente = new OpcionesFichasComponente(this);
		cambiarFichaSeleccionada(componente.getAleatorio(), 3);
	}

	public void cambiarFichaSeleccionada(CasillaComponente c, int seleccion) {
		opcionSeleccionada = seleccion;
		if (seleccionada != null) {
			seleccionada.setBorder(null);
		}
		seleccionada = c;
		seleccionada.setBorder(componente.getBordeSeleccion());
	}

	public OpcionesFichasComponente getComponente() {
		return componente;
	}

	public int getOpcionSeleccionada() {
		return opcionSeleccionada;
	}
}
