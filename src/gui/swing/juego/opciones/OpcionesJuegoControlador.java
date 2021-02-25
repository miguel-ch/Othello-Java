package gui.swing.juego.opciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.swing.SwingControlador;

public class OpcionesJuegoControlador implements ActionListener, SwingControlador {

	private OpcionesJuegoGUI opciones;
	private OpcionesJuegoComponente componente;

	public OpcionesJuegoControlador(OpcionesJuegoGUI opciones, OpcionesJuegoComponente componente) {
		this.opciones = opciones;
		this.componente = componente;
		agregarListeners();
	}

	public void agregarListeners() {
		componente.getBotonSalir().addActionListener(this);
		componente.getBotonReset().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == componente.getBotonSalir()) {
			opciones.salir();
		}
		if (e.getSource() == componente.getBotonReset()) {
			opciones.reiniciar();
		}
	}
}
