package othello.jugadores;

import java.util.List;

import othello.fichas.Ficha;
import othello.tablero.Tablero;
import othello.tablero.ubicacion.Coordenadas;

public class Maquina extends Jugador {

	public Maquina(String nombre, Ficha ficha) {
		super("Maquina: " + nombre, ficha);
	}

	public Coordenadas movimientoEnTablero(Tablero t) {

		int coordsMayoresFichas = 0;
		int ultimaMayorCantidad = 0;
		List<Coordenadas> coords = t.movimientosPosibles(ficha);

		// Existen movimientos posibles
		if (coords.size() > 0) {

			// Verifica cuantas fichas se voltean por cada posible movimiento y devuelve la
			// mayor
			for (Coordenadas c : coords) {

				// Actualiza la cantidad a la mayor y la posicion en la lista de las coordenadas
				int tmpTamano = t.coordenadasFichasOpuestas(ficha, c).size();
				if (tmpTamano > ultimaMayorCantidad) {
					ultimaMayorCantidad = tmpTamano;
					coordsMayoresFichas = coords.indexOf(c);
				}
			}
			return coords.get(coordsMayoresFichas);
		}
		return null;
	}
}
