package gui.swing.jugadores.informacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.swing.SwingComponente;
import gui.swing.casilla.CasillaComponente;

public class InformacionJugadorComponente extends JPanel implements SwingComponente {

	public static final String COLOR_FONDO = "#303030";
	public static final String COLOR_FONDO_NOMBRE = "#5691FE";

	// Componentes
	private CasillaComponente ficha;
	private JLabel cantidadFichas;
	private JLabel nombre;

	public InformacionJugadorComponente() {
		iniciarComponentes();
	}

	public void iniciarComponentes() {

		// Inicializa los componentes
		this.ficha = new CasillaComponente(0, 0, 70);
		this.cantidadFichas = new JLabel("0");
		this.nombre = new JLabel("NOMBRE_JUGADOR");

		// Ajusta el panel de la ficha
		ficha.cambiarCasilla(CasillaComponente.TipoCasilla.FICHA_NEGRA);
		ficha.setBorder(null);

		cantidadFichas.setBackground(Color.decode(COLOR_FONDO));
		cantidadFichas.setOpaque(true);
		cantidadFichas.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadFichas.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		cantidadFichas.setForeground(Color.WHITE);

		nombre.setPreferredSize(new Dimension(200, 30));
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		nombre.setBackground(Color.decode(COLOR_FONDO_NOMBRE));
		nombre.setForeground(Color.WHITE);
		nombre.setOpaque(true);

		setBackground(Color.decode(COLOR_FONDO));
		setLayout(new BorderLayout());

		add(ficha, BorderLayout.WEST);
		add(cantidadFichas, BorderLayout.CENTER);
		add(nombre, BorderLayout.SOUTH);
	}

	public CasillaComponente getFicha() {
		return ficha;
	}

	public JLabel getCantidadFichas() {
		return cantidadFichas;
	}

	public JLabel getNombre() {
		return nombre;
	}
}
