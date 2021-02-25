package gui.swing.juego.opciones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.swing.SwingComponente;

public class OpcionesJuegoComponente extends JPanel implements SwingComponente {

	public static final String COLOR_RESET = "#0092FF";
	public static final String COLOR_SALIR = "#FF4D5C";

	// Controlador
	private OpcionesJuegoGUI opciones;
	private OpcionesJuegoControlador controlador;

	// Componentes
	private JButton botonReset;
	private JButton botonSalir;

	public OpcionesJuegoComponente(OpcionesJuegoGUI opciones) {
		iniciarComponentes();

		this.opciones = opciones;
		this.controlador = new OpcionesJuegoControlador(opciones, this);
	}

	public void iniciarComponentes() {

		// Crea los botones
		botonReset = new JButton("REINICIAR JUEGO");
		botonSalir = new JButton("SALIR AL MENU");

		botonReset.setForeground(Color.WHITE);
		botonReset.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		botonReset.setPreferredSize(new Dimension(100, 60));
		botonReset.setBorder(null);
		botonReset.setBackground(Color.decode(COLOR_RESET));

		botonSalir.setForeground(Color.WHITE);
		botonSalir.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		botonSalir.setPreferredSize(new Dimension(100, 60));
		botonSalir.setBorder(null);
		botonSalir.setBackground(Color.decode(COLOR_SALIR));

		// Configuracion
		setLayout(new GridLayout());

		// Añade componentes
		add(botonReset);
		add(botonSalir);
	}

	public JButton getBotonReset() {
		return botonReset;
	}

	public JButton getBotonSalir() {
		return botonSalir;
	}
}
