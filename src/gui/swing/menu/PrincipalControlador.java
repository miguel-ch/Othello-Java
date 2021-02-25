package gui.swing.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.swing.SwingControlador;

public class PrincipalControlador implements ActionListener, SwingControlador {

	// Referencias
	private final PrincipalPanel panel;
	private final PrincipalGUI principal;

	public PrincipalControlador(PrincipalGUI p, PrincipalPanel c) {
		this.principal = p;
		this.panel = c;
		agregarListeners();
	}

	public void agregarListeners() {
		panel.getBtnJugar().addActionListener(this);
		panel.getBtnAcerca().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == panel.getBtnJugar()) {
			principal.iniciarJuego();
		}
		if (e.getSource() == panel.getBtnAcerca()) {
			principal.acercaDe();
		}
	}
}
