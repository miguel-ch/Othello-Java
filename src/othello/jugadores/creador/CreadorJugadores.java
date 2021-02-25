package othello.jugadores.creador;

import java.util.Random;

import othello.fichas.Ficha;
import othello.fichas.FichaColor;
import othello.jugadores.Jugador;
import othello.jugadores.Maquina;
import othello.jugadores.Persona;

public class CreadorJugadores {

	private Jugador negras;
	private Jugador blancas;

	private PlantillaJugador jugadorUno;
	private PlantillaJugador jugadorDos;

	public CreadorJugadores(PlantillaJugador uno, PlantillaJugador dos) {
		this.jugadorUno = uno;
		this.jugadorDos = dos;
	}

	public boolean crear() {

		if (jugadorUno.esValida() && jugadorDos.esValida()) {

			OpcionFichas uno = jugadorUno.getOpcion();
			OpcionFichas dos = jugadorDos.getOpcion();

			// Posibles casos recibidos
			if (uno == OpcionFichas.ALEATORIO && dos == OpcionFichas.ALEATORIO) {

				Random r = new Random();
				int num = r.nextInt(10) + 1;
				uno = num < 5 ? OpcionFichas.NEGRAS : OpcionFichas.BLANCAS;
				dos = uno == OpcionFichas.NEGRAS ? OpcionFichas.BLANCAS : OpcionFichas.NEGRAS;

			} else if (uno == OpcionFichas.ALEATORIO) {
				uno = dos == OpcionFichas.NEGRAS ? OpcionFichas.BLANCAS : OpcionFichas.NEGRAS;
			} else if (dos == OpcionFichas.ALEATORIO) {
				dos = uno == OpcionFichas.NEGRAS ? OpcionFichas.BLANCAS : OpcionFichas.NEGRAS;
			} else if (uno == dos) {
				dos = uno == OpcionFichas.NEGRAS ? OpcionFichas.BLANCAS : OpcionFichas.NEGRAS;
			}
			return crearJugadores(uno, dos);
		}
		return false;
	}

	private boolean crearJugadores(OpcionFichas uno, OpcionFichas dos) {

		// Finalmente verifica las opciones para crear los jugadores
		if (uno != OpcionFichas.ALEATORIO && dos != OpcionFichas.ALEATORIO && uno != dos) {

			PlantillaJugador jugaNegras = jugadorUno;
			PlantillaJugador jugaBlancas = jugadorDos;

			if (uno == OpcionFichas.BLANCAS) {
				jugaNegras = jugadorDos;
				jugaBlancas = jugadorUno;
			}

			// Fichas para los jugadores
			Ficha negra = new Ficha(FichaColor.NEGRA);
			Ficha blanca = new Ficha(FichaColor.BLANCA);

			// Dependiendo de la opcion leida crea el jugador o maquina
			negras = jugaNegras.isEsMaquina() ? new Maquina(jugaNegras.getNombre(), negra)
					: new Persona(jugaNegras.getNombre(), negra);
			blancas = jugaBlancas.isEsMaquina() ? new Maquina(jugaBlancas.getNombre(), blanca)
					: new Persona(jugaBlancas.getNombre(), blanca);
			return true;
		}
		return false;
	}

	public Jugador getNegras() {
		return negras;
	}

	public Jugador getBlancas() {
		return blancas;
	}
}
