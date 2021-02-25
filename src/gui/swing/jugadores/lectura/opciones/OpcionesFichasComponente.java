package gui.swing.jugadores.lectura.opciones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import gui.swing.SwingComponente;
import gui.swing.casilla.CasillaComponente;

public class OpcionesFichasComponente extends JPanel implements SwingComponente {

	// public static final String COLOR_FONDO = "#5691FE";
	public static final String COLOR_FONDO = "#5691FE";

	private OpcionesFichasGUI opciones;
	private OpcionesFichasControlador controlador;

	// Componentes
	private CasillaComponente negra;
	private CasillaComponente blanca;
	private CasillaComponente aleatorio;

	private LineBorder bordeSeleccion;

	public OpcionesFichasComponente(OpcionesFichasGUI o) {

		iniciarComponentes();
		this.opciones = o;
		this.controlador = new OpcionesFichasControlador(o, this);
	}

	public void iniciarComponentes() {

		// Inicia componentes
		this.negra = new CasillaComponente(70, CasillaComponente.TipoCasilla.FICHA_NEGRA);
		this.blanca = new CasillaComponente(70, CasillaComponente.TipoCasilla.FICHA_BLANCA);
		this.aleatorio = new CasillaComponente(70, CasillaComponente.TipoCasilla.POSIBLE_MOVIMIENTO);

		negra.setBorder(null);
		blanca.setBorder(null);
		aleatorio.setBorder(null);

		this.bordeSeleccion = new LineBorder(Color.yellow, 2);

		// Configura el panel
		setPreferredSize(new Dimension(270, 90));
		setLayout(new GridLayout(1, 3, 20, 0));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setBackground(Color.decode(COLOR_FONDO));

		// Añade las fichas
		add(negra);
		add(blanca);
		add(aleatorio);
	}

	public CasillaComponente getNegra() {
		return negra;
	}

	public CasillaComponente getBlanca() {
		return blanca;
	}

	public CasillaComponente getAleatorio() {
		return aleatorio;
	}

	public LineBorder getBordeSeleccion() {
		return bordeSeleccion;
	}
}
