package gui.swing.menu;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.GUIPrincipal;
import gui.swing.juego.JuegoGUI;

public class PrincipalGUI extends GUIPrincipal {

	// Componentes
	private JFrame ventana;
	private PrincipalPanel panel;

	// Ventanas

	public PrincipalGUI(JFrame ventana) {
		this.ventana = ventana;
		this.panel = new PrincipalPanel(this);
	}

	public void iniciarJuego() {
		new JuegoGUI(this).cargar();
	}

	public void acercaDe() {
		JOptionPane.showMessageDialog(null, "Othello - 2021\nProyecto final\nProgramacion orientada a objetos",
				"Acerca de.", JOptionPane.INFORMATION_MESSAGE);
	}

	public PrincipalPanel getPanel() {
		return panel;
	}

	@Override
	public void cargar() {
		// ventana.removeAll();
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panel);
		ventana.getContentPane().revalidate();
		ventana.getContentPane().repaint();
		ventana.pack();
		ventana.setVisible(true);
	}

	public void cargarPanel(JPanel panel) {
		// ventana.removeAll();
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panel);
		ventana.getContentPane().revalidate();
		ventana.getContentPane().repaint();
		ventana.pack();
		ventana.setVisible(true);
	}

	public JFrame getVentana() {
		return ventana;
	}
}
