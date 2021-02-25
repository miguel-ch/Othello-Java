package gui.swing.tablero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.swing.SwingControlador;
import gui.swing.casilla.CasillaComponente;

public class TableroControlador implements ActionListener, SwingControlador {

	private final TableroComponente tablero;
	private final TableroGUI modelo;

	// Constructor
	public TableroControlador(TableroComponente vista, TableroGUI modelo) {
		this.tablero = vista;
		this.modelo = modelo;
		agregarListeners();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Listener de las casillas
		if (e.getSource() instanceof CasillaComponente) {
			CasillaComponente c = (CasillaComponente) e.getSource();
			modelo.colocarFicha(c.getFila(), c.getColumna());
		}
	}

	public void agregarListeners() {
		CasillaComponente[][] casillas = tablero.getCasillas();
		for (CasillaComponente[] filaCasillas : casillas) {
			for (CasillaComponente c : filaCasillas) {
				c.addActionListener(this);
			}
		}
	}
}
