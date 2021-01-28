package core.fichas;

public class FichaNegra extends Ficha{

	public FichaNegra() {
		super("NEGRA");
	}
	
	@Override
	public Ficha clone() {
		return new FichaNegra();
	}
}
