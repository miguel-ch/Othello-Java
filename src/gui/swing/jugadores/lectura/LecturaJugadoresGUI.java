package gui.swing.jugadores.lectura;

import javax.swing.JOptionPane;

import gui.GUILecturaJugadores;
import gui.swing.juego.JuegoGUI;
import gui.swing.jugadores.lectura.opciones.OpcionesFichasGUI;
import othello.jugadores.creador.CreadorJugadores;
import othello.jugadores.creador.OpcionFichas;
import othello.jugadores.creador.PlantillaJugador;

public class LecturaJugadoresGUI extends GUILecturaJugadores {

	private LecturaJugadoresPanel componente;

	public LecturaJugadoresGUI(JuegoGUI j) {
		super(j);
		this.componente = new LecturaJugadoresPanel(this);
	}

	public LecturaJugadoresPanel getComponente() {
		return componente;
	}

	@Override
	public void cargar() {
		componente.getTxtNombreUno().setText("");
		componente.getTxtNombreDos().setText("");
	}

	@Override
	public void cargarJugadoresAJuego() {

		String nombreJugadorUno = componente.getTxtNombreUno().getText().trim();
		String nombreJugadorDos = componente.getTxtNombreDos().getText().trim();

		int opcionJugadorUno = componente.getFichasUno().getOpcionSeleccionada();
		int opcionJugadorDos = componente.getFichasDos().getOpcionSeleccionada();

		boolean esMaquina = componente.getChkMaquina().isSelected();

		OpcionFichas opcionUno = OpcionFichas.ALEATORIO;
		OpcionFichas opcionDos = OpcionFichas.ALEATORIO;

		switch (opcionJugadorUno) {
		case 1:
			opcionUno = OpcionFichas.NEGRAS;
			break;
		case 2:
			opcionUno = OpcionFichas.BLANCAS;
			break;
		}

		switch (opcionJugadorDos) {
		case 1:
			opcionDos = OpcionFichas.NEGRAS;
			break;
		case 2:
			opcionDos = OpcionFichas.BLANCAS;
			break;
		}

		this.jugadorUno = new PlantillaJugador(nombreJugadorUno, opcionUno);
		this.jugadorDos = new PlantillaJugador(nombreJugadorDos, opcionDos, esMaquina);

		CreadorJugadores crea = new CreadorJugadores(jugadorUno, jugadorDos);
		if (crea.crear()) {
			juego.iniciarJuego(crea.getNegras(), crea.getBlancas());
		} else {
			JOptionPane.showMessageDialog(null,
					"Hay informacion incompleta de alguno de los jugadores\nPor favor verifique la informacion antes de continuar.",
					"Error al crear los jugadores", JOptionPane.ERROR_MESSAGE);
		}
	}
}
