package gui.swing.juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.swing.SwingComponente;
import gui.swing.juego.opciones.OpcionesJuegoGUI;
import gui.swing.jugadores.JugadoresGUI;
import gui.swing.tablero.TableroGUI;

public class JuegoPanel extends JPanel implements SwingComponente {

	public static final String ESTADO_TURNO = "#2956b2";
	public static final String ESTADO_GANADOR = "#009900";
	public static final String ESTADO_EMPATE = "#E87300";

	private JuegoGUI modelo;

	// Componentes
	private TableroGUI tablero;
	private JugadoresGUI jugadores;
	private OpcionesJuegoGUI opciones;

	private JPanel estadoContenedor;
	private JLabel estado;

	public JuegoPanel(JuegoGUI m, TableroGUI t, JugadoresGUI j) {
		this.modelo = m;
		this.tablero = t;
		this.jugadores = j;
		this.opciones = new OpcionesJuegoGUI(m);
		iniciarComponentes();
	}

	public void iniciarComponentes() {

		// Inicia componentes
		this.estado = new JLabel("ESTADO");
		this.estadoContenedor = new JPanel();

		// Ajusta el panel
		estadoContenedor.setLayout(new BorderLayout());
		estadoContenedor.setBackground(Color.decode(ESTADO_TURNO));
		estadoContenedor.add(estado, BorderLayout.CENTER);

		estado.setHorizontalAlignment(SwingConstants.CENTER);
		estado.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
		estado.setForeground(Color.WHITE);
		estado.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Añade los componentes
		add(jugadores.getComponente());
		add(estadoContenedor);
		add(tablero.getComponente());
		add(opciones.getComponente());
	}

	public JLabel getEstado() {
		return estado;
	}

	public JPanel getEstadoPanel() {
		return estadoContenedor;
	}
}
