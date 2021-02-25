package gui.swing.casilla;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CasillaComponente extends JButton{

	public static final String COLOR_FICHA_NEGRA = "#131A18";
	public static final String COLOR_FICHA_BLANCA = "#F4FAFD";
	public static final int TAMANO = 50;

	public enum TipoCasilla {
		VACIA, FICHA_NEGRA, FICHA_BLANCA, POSIBLE_MOVIMIENTO,
	}

	private final int fila;
	private final int columna;
	private final int tamano;
	private TipoCasilla tipo;

	public CasillaComponente(int fila, int columna, int tamano, TipoCasilla tipo) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.tamano = tamano;
		this.tipo = tipo;
		iniciarCasilla();
	}

	public CasillaComponente(int fila, int columna, int tamano) {
		this(fila, columna, tamano, TipoCasilla.VACIA);
	}

	public CasillaComponente(int tamano, TipoCasilla tipo) {
		this(0, 0, tamano, tipo);
	}

	public CasillaComponente(int fila, int columna) {
		this(fila, columna, TAMANO);
	}

	public void iniciarCasilla() {
		setPreferredSize(new Dimension(tamano, tamano));
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setBorder(new LineBorder(Color.BLACK, 1));
		setContentAreaFilled(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Graphics para dibujar los ciruculos
		Graphics2D grap = (Graphics2D) g;
		grap.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Dibujar el circulo
		if (tipo != TipoCasilla.VACIA) {
			Ellipse2D.Double circulo = new Ellipse2D.Double(4, 4, getWidth() - 8, getHeight() - 8);
			switch (tipo) {
			case FICHA_NEGRA:
				grap.setColor(Color.decode(COLOR_FICHA_NEGRA));
				grap.fill(circulo);
				break;
			case FICHA_BLANCA:
				grap.setColor(Color.decode(COLOR_FICHA_BLANCA));
				grap.fill(circulo);
				break;
			case POSIBLE_MOVIMIENTO:
				grap.setColor(Color.decode(COLOR_FICHA_NEGRA));
				grap.draw(circulo);
				break;
			}
		}
	}

	public void cambiarCasilla(TipoCasilla t) {
		this.tipo = t;
		this.repaint();
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public TipoCasilla getTipo() {
		return tipo;
	}
}
