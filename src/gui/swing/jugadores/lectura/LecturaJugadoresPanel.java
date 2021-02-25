package gui.swing.jugadores.lectura;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import gui.swing.SwingComponente;
import gui.swing.jugadores.lectura.opciones.OpcionesFichasGUI;

public class LecturaJugadoresPanel extends JPanel implements SwingComponente {

	// Colores
	public static final String COLOR_FONDO = "#303030";
	public static final String COLOR_TITULO = "#5691FE";
	public static final String COLOR_BOTON = "#2956b2";
	public static final String COLOR_TEXTFIELD = "#222222";
	public static final String COLOR_INPUT = "#cccccc";

	private LecturaJugadoresControlador controlador;
	private LecturaJugadoresGUI lectura;

	// Componentes
	private JLabel lblJugadorUno;
	private JLabel lblJugadorDos;

	private JLabel lblTextNombreUno;
	private JLabel lblTextNombreDos;

	private JLabel lblOpcionFichasUno;
	private JLabel lblOpcionFichasDos;

	private JTextField txtNombreUno;
	private JTextField txtNombreDos;

	private OpcionesFichasGUI fichasUno;
	private OpcionesFichasGUI fichasDos;

	private JCheckBox chkMaquina;

	private JButton btnContinuar;

	public LecturaJugadoresPanel(LecturaJugadoresGUI lectura) {
		iniciarComponentes();
		this.lectura = lectura;
		this.controlador = new LecturaJugadoresControlador(lectura, this);
	}

	public void iniciarComponentes() {

		// Crea componentes
		lblJugadorUno = new JLabel("Jugador 1");
		lblJugadorDos = new JLabel("Jugador 2");

		lblTextNombreUno = new JLabel("Nombre del jugador:");
		lblTextNombreDos = new JLabel("Nombre del jugador:");

		lblOpcionFichasUno = new JLabel("Seleccione una ficha para el juego");
		lblOpcionFichasDos = new JLabel("Seleccione una ficha para el juego");

		txtNombreUno = new JTextField();
		txtNombreDos = new JTextField();

		fichasUno = new OpcionesFichasGUI();
		fichasDos = new OpcionesFichasGUI();

		chkMaquina = new JCheckBox("Es maquina?");

		btnContinuar = new JButton("CONTINUAR");

		// Jugador UNO
		lblJugadorUno.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		lblJugadorUno.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadorUno.setFont(new Font("Trebuchet MS", 1, 24));
		lblJugadorUno.setForeground(Color.decode(COLOR_TITULO));

		lblTextNombreUno.setFont(new Font("Trebuchet MS", 0, 18));
		lblTextNombreUno.setForeground(Color.WHITE);

		txtNombreUno.setBackground(Color.decode(COLOR_TEXTFIELD));
		txtNombreUno.setForeground(Color.decode(COLOR_INPUT));
		txtNombreUno.setCaretColor(Color.WHITE);
		txtNombreUno.setFont(new Font("Trebuchet MS", 0, 14));

		lblOpcionFichasUno.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpcionFichasUno.setForeground(Color.WHITE);
		lblOpcionFichasUno.setFont(new Font("Trebuchet MS", 0, 18));

		// Jugador DOS
		lblJugadorDos.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		lblJugadorDos.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadorDos.setFont(new Font("Trebuchet MS", 1, 24));
		lblJugadorDos.setForeground(Color.decode(COLOR_TITULO));

		lblTextNombreDos.setFont(new Font("Trebuchet MS", 0, 18));
		lblTextNombreDos.setForeground(Color.WHITE);

		txtNombreDos.setBackground(Color.decode(COLOR_TEXTFIELD));
		txtNombreDos.setForeground(Color.decode(COLOR_INPUT));
		txtNombreDos.setCaretColor(Color.WHITE);
		txtNombreDos.setFont(new Font("Trebuchet MS", 0, 14));

		lblOpcionFichasDos.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpcionFichasDos.setForeground(Color.WHITE);
		lblOpcionFichasDos.setFont(new Font("Trebuchet MS", 0, 18));

		// Botones
		chkMaquina.setHorizontalAlignment(SwingConstants.CENTER);
		chkMaquina.setFont(new Font("Trebuchet MS", 0, 18));
		chkMaquina.setForeground(Color.WHITE);
		chkMaquina.setOpaque(false);

		btnContinuar.setFont(new Font("Trebuchet MS", 1, 18));
		btnContinuar.setBackground(Color.decode(COLOR_BOTON));
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setBorder(null);
		// btnContinuar.setBorder(BorderFactory.createLineBorder(Color.decode(COLOR_TITULO),
		// 2));

		// Configura el panel
		setBackground(Color.decode(COLOR_FONDO));
		setMaximumSize(new Dimension(480, 660));
		setMinimumSize(new Dimension(480, 660));
		setPreferredSize(new Dimension(480, 660));
		setLayout(null);

		add(lblJugadorUno);
		add(lblTextNombreUno);
		add(txtNombreUno);
		add(lblOpcionFichasUno);
		add(fichasUno.getComponente());

		add(lblJugadorDos);
		add(lblTextNombreDos);
		add(txtNombreDos);
		add(lblOpcionFichasDos);
		add(fichasDos.getComponente());

		add(chkMaquina);
		add(btnContinuar);

		lblJugadorUno.setBounds(20, 10, 430, 50);
		lblTextNombreUno.setBounds(20, 70, 170, 21);
		txtNombreUno.setBounds(20, 100, 430, 30);
		lblOpcionFichasUno.setBounds(23, 140, 430, 21);
		fichasUno.getComponente().setBounds(100, 170, 270, 90);

		lblJugadorDos.setBounds(20, 280, 430, 50);
		lblTextNombreDos.setBounds(20, 340, 170, 21);
		txtNombreDos.setBounds(20, 370, 420, 30);
		lblOpcionFichasDos.setBounds(20, 410, 430, 21);
		fichasDos.getComponente().setBounds(100, 440, 270, 90);

		chkMaquina.setBounds(280, 340, 170, 20);
		btnContinuar.setBounds(20, 560, 430, 50);
	}

	public JTextField getTxtNombreUno() {
		return txtNombreUno;
	}

	public JTextField getTxtNombreDos() {
		return txtNombreDos;
	}

	public OpcionesFichasGUI getFichasUno() {
		return fichasUno;
	}

	public OpcionesFichasGUI getFichasDos() {
		return fichasDos;
	}

	public JCheckBox getChkMaquina() {
		return chkMaquina;
	}

	public JButton getBtnContinuar() {
		return btnContinuar;
	}
}
