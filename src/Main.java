import gui.GUI;
import gui.consola.OthelloConsola;
import gui.swing.OthelloSwing;

public class Main {

	public static void main(String[] args) {
		
		//GUI othello = new OthelloConsola(); //Consola
		GUI othello =  new OthelloSwing(); //Swing
		othello.cargar();
	}
}
