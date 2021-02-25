package gui.swing.tablero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import gui.swing.SwingComponente;
import gui.swing.casilla.CasillaComponente;

public class TableroComponente extends JPanel implements SwingComponente {

	// Estatico
	public static final String VERDE_FONDO = "#32a852";
	public static final String COLOR_BORDE = "#222222";
	public static final int TAMANO_BORDE = 40;

	// Informacion del modelo
	private final TableroGUI modelo;
	private final TableroControlador controlador;

	// Componentes
	private JPanel contenedorFichas;
	private CasillaComponente[][] casillas;

	public TableroComponente(TableroGUI m) {

		// Prepara los componentes
		iniciarComponentes();

		// Crea el modelo y controlador
		this.modelo = m;
		this.controlador = new TableroControlador(this, modelo);
	}

	public void iniciarComponentes() {

		// Añade las casillas
		contenedorFichas = new JPanel();
		casillas = new CasillaComponente[8][8];

		// Ajusta el panel de las fichas
		contenedorFichas.setBorder(null);
		contenedorFichas.setLayout(new GridLayout(8, 8));
		contenedorFichas.setBackground(Color.decode(VERDE_FONDO));

		// Crea las casillas
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				CasillaComponente c = new CasillaComponente(i, j);
				casillas[i][j] = c;
				contenedorFichas.add(casillas[i][j]);
			}
		}

		int tam = (CasillaComponente.TAMANO * 8) + (TAMANO_BORDE * 2); // Tamaño calculado con el borde y casillas
		setPreferredSize(new Dimension(tam, tam));
		setBackground(Color.decode(COLOR_BORDE));
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(TAMANO_BORDE, TAMANO_BORDE, TAMANO_BORDE, TAMANO_BORDE));

		add(contenedorFichas, BorderLayout.CENTER);
	}

	public CasillaComponente[][] getCasillas() {
		return casillas;
	}

	public CasillaComponente getCasilla(int fila, int columna) {
		return casillas[fila][columna];
	}
}
