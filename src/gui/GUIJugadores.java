package gui;

public abstract class GUIJugadores implements GUI, GUIInformacion {

	protected GUIJugadorInformacion jugadorFichasNegras;
	protected GUIJugadorInformacion jugadorFichasBlancas;

	public void actualizar() {
		if (jugadorFichasNegras != null && jugadorFichasBlancas != null) {
			jugadorFichasNegras.actualizar();
			jugadorFichasBlancas.actualizar();
		}
	}

	public void cargar() {
		if (jugadorFichasNegras != null && jugadorFichasBlancas != null) {
			jugadorFichasNegras.cargar();
			jugadorFichasBlancas.cargar();
		}
	}
}
