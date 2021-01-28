package core.fichas;

public abstract class Ficha implements Cloneable {
	
	//Atributos
	private final String color;
	
	//Constructor
	public Ficha(String color) {
		this.color = color;
	}
	
	//Getter
	public String getColor() {
		return color;
	}
	
	public abstract Ficha clone();
}