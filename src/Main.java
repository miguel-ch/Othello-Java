import core.Othello;
import gui.consola.OthelloREN;

public class Main {

	public static void main(String[] args) {
		
		//OBJ
		Othello ot = new Othello();
		OthelloREN p = new OthelloREN();
		
		//COR
		System.out.println("Othello N1\n");
		
		p.imprimirTablero(ot.getTablero());
		ot.tests();
	}
}
