package gui.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.GUI;
import gui.swing.menu.PrincipalGUI;

public class OthelloSwing extends JFrame implements GUI {

	private static final long serialVersionUID = 1L;

	@Override	
	public void cargar() {
		iniciarComponentes();
		new PrincipalGUI(this).cargar();
	}
	
	private void iniciarComponentes() {
		setTitle("Othello");
		
		ImageIcon ico = new ImageIcon(getClass().getResource("/Othello.png"));
		
		setResizable(false);
		setIconImage(ico.getImage());
        setPreferredSize(new Dimension(480, 662));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.red);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("/OthelloFondo.png"))));
        getContentPane().setLayout(new GridLayout(1,1));
	}
}
