package gui.swing.jugadores.lectura.opciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.swing.SwingControlador;
import gui.swing.casilla.CasillaComponente;

public class OpcionesFichasControlador implements ActionListener, SwingControlador {

	private OpcionesFichasGUI opciones;
	private OpcionesFichasComponente componente;

	public OpcionesFichasControlador(OpcionesFichasGUI o, OpcionesFichasComponente c) {
		this.opciones = o;
		this.componente = c;
		agregarListeners();
	}

	public void agregarListeners() {
		componente.getNegra().addActionListener(this);
		componente.getBlanca().addActionListener(this);
		componente.getAleatorio().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == componente.getNegra()) {
			opciones.cambiarFichaSeleccionada((CasillaComponente) e.getSource(), 1);
		}

		if (e.getSource() == componente.getBlanca()) {
			opciones.cambiarFichaSeleccionada((CasillaComponente) e.getSource(), 2);
		}

		if (e.getSource() == componente.getAleatorio()) {
			opciones.cambiarFichaSeleccionada((CasillaComponente) e.getSource(), 3);
		}
	}
}
