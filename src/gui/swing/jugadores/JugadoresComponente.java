package gui.swing.jugadores;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import gui.swing.SwingComponente;
import gui.swing.jugadores.informacion.InformacionJugadorComponente;

public class JugadoresComponente extends JPanel implements SwingComponente{
	
	public static final String COLOR_FONDO = "#222222";
	
    private InformacionJugadorComponente negras;
    private InformacionJugadorComponente blancas;
    
    public JugadoresComponente(InformacionJugadorComponente negras, InformacionJugadorComponente blancas){
        this.negras = negras;
        this.blancas = blancas;
        iniciarComponentes();
    }	
    
    public void iniciarComponentes(){
    	setBackground(Color.decode(COLOR_FONDO));
        setLayout(new GridLayout(1, 2, 2, 0));
        setPreferredSize(new Dimension(400,100));
        add(negras);
        add(blancas);
    }
}
