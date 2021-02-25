package othello.jugadores.creador;

public class PlantillaJugador {

	private String nombre;
	private OpcionFichas opcion;
	private boolean esMaquina;

	public PlantillaJugador(String nombre, OpcionFichas opcion, boolean esMaquina) {
		this.nombre = nombre;
		this.opcion = opcion;
		this.esMaquina = esMaquina;
	}

	public PlantillaJugador(String nombre, OpcionFichas opcion) {
		this(nombre, opcion, false);
	}

	public boolean esValida() {
		return nombre != null && opcion != null && !nombre.isEmpty();
	}

	public String getNombre() {
		return nombre;
	}

	public OpcionFichas getOpcion() {
		return opcion;
	}

	public void setOpcion(OpcionFichas opcion) {
		this.opcion = opcion;
	}

	public boolean isEsMaquina() {
		return esMaquina;
	}
}
