package gui.swing.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.swing.SwingComponente;

public class PrincipalPanel extends JPanel implements SwingComponente {

	public static final String COLOR_FONDO = "#303030";
	public static final String COLOR_BOTON_JUGAR = "#005FC5";
	public static final String COLOR_BOTON_ACERCA = "#005FC5";

	private final PrincipalGUI principal;
	private final PrincipalControlador controlador;

	// Componentes
	private JPanel botones;
	private JLabel titulo;
	private JButton btnJugar;
	private JButton btnAcerca;

	public PrincipalPanel(PrincipalGUI p) {	
		iniciarComponentes();
		this.principal = p;
		this.controlador = new PrincipalControlador(p, this);
	}

	public void iniciarComponentes() {

		// Inicializa los componentes
		botones = new JPanel();
		titulo = new JLabel();
		btnJugar = new JButton("JUGAR");
		btnAcerca = new JButton("ACERCA DE");

		// Configuracion botones
		btnJugar.setBackground(Color.decode(COLOR_BOTON_JUGAR));
		btnJugar.setBorder(null);

		btnJugar.setFont(new Font("Trebuchet MS", 1, 24));
		btnJugar.setForeground(Color.WHITE);

		btnAcerca.setBackground(Color.decode(COLOR_BOTON_ACERCA));
		btnAcerca.setBorder(null);

		btnAcerca.setFont(new Font("Trebuchet MS", 1, 24));
		btnAcerca.setForeground(Color.WHITE);

		// Configuracion componentes
		botones.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		botones.setBackground(Color.decode(COLOR_FONDO));
		botones.setOpaque(false);
		botones.setLayout(new GridLayout(2, 1, 0, 30));

		botones.add(btnJugar);
		botones.add(btnAcerca);

		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Trebuchet MS", 0, 120));
		titulo.setForeground(Color.WHITE);

		// Configuracion panel
		setPreferredSize(new Dimension(480, 660));
		setBackground(Color.decode(COLOR_FONDO));
		setOpaque(false);
		setLayout(new GridLayout(2, 1));

		// Agrega componentes
		add(titulo);
		add(botones);

		botones.setBounds(50, 20, 150, 300);
	}

	public JButton getBtnJugar() {
		return btnJugar;
	}

	public JButton getBtnAcerca() {
		return btnAcerca;
	}
}
