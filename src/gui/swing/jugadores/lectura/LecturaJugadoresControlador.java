package gui.swing.jugadores.lectura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.swing.SwingComponente;
import gui.swing.SwingControlador;

public class LecturaJugadoresControlador implements ActionListener, SwingControlador{
	
	private LecturaJugadoresPanel componente;	
    private LecturaJugadoresGUI lectura;

    public LecturaJugadoresControlador(LecturaJugadoresGUI lectura, LecturaJugadoresPanel componente) {
        this.componente = componente;
        this.lectura = lectura;

        agregarListeners();
    }

    public void agregarListeners() {
    	componente.getBtnContinuar().addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == componente.getBtnContinuar()) {
			lectura.cargarJugadoresAJuego();
		}
	}
}
