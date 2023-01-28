
/**
 * Ejercicio23.java
 *
 * @version: 27/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

/*
 * En ajedrez, el valor de las piezas se mide en peones. Una dama vale 9 peones,
 * una torre 5 peones, un alfil 3, un caballo 2 y un péon vale, lógicamente,
 * 1 peón. Realiza un programa que genere al azar las capturas que ha hecho
 * un jugador durante una partida. El número de capturas será un valor aleatorio
 * entre 0 y 15. Hay que tener en cuenta que cada jugador tiene la posibilidad
 * de capturar algunas de las siguientes piezas (no más): 1 dama, 2 torres, 2
 * alfiles, 2 caballos y 8 peones. Al final debe aparecer la puntuación total.
 * Ejemplo:
 * Fichas capturadas por el jugador:
 * Alfil (3 peones)
 * Caballo (2 peones)
 * Peón (1 peones)
 * Torre (5 peones)
 * Peón (1 peones)
 * Puntos totales: 12 peones
 */

import Ejercicio23.*;

public class Ejercicio23 {
	public static void main(String[] args) {
		Ajedrez tablero = new Ajedrez();
		int piezasASacar = (int) (Math.random() * 16);
		int puntos = 0;

		for (int i = 0; i < piezasASacar; i++) {
			int pieza = (int) ((Math.random()) * tablero.ajedrez.size());
			Pieza p;
			p = tablero.sacaPieza(tablero.ajedrez.get(pieza));
			System.out.println(p);
			puntos += p.getValor();
		}
		System.out.println("Puntos totales: " + puntos + " peones.");
	}
}