package core.fichas;

public class Ficha implements Cloneable {
	
	//Atributos
	private final FichaColor color;
	
	//Constructor
	public Ficha(FichaColor color) {
		this.color = color;
	}
	
	//Getter
	public FichaColor getColor() {
		return color;
	}
	
	public boolean equals(Ficha f) {
		return f.color == color;
	}
	
	@Override
	public Ficha clone() {
		return new Ficha(color);
	}
}
