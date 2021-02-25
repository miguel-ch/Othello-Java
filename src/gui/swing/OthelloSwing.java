package gui.swing;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.GUI;
import gui.swing.menu.PrincipalGUI;

public class OthelloSwing extends JFrame implements GUI {

	@Override
	public void cargar() {
		iniciarComponentes();
		new PrincipalGUI(this).cargar();
	}
	
	private void iniciarComponentes() {
		setTitle("Othello");
		setResizable(false);
        setPreferredSize(new Dimension(480, 662));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.red);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("/gui/swing/imagenes/OthelloFondo.png"))));
        getContentPane().setLayout(new GridLayout(1,1));
        add(new JLabel());
	}
}
