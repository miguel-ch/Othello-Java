package core.fichas;

public class FichaBlanca extends Ficha{

	public FichaBlanca() {
		super("BLANCO");
	}
	
	@Override
	public Ficha clone() {
		return new FichaBlanca();
	}
}
