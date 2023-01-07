
/**
 * Ejercicio12.java
 *
 * @version: 07/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * Escribe un programa que genere una secuencia de 5 cartas de la baraja
 * española y que sume los puntos según el juego de la brisca. El valor de las
 * cartas se debe guardar en una estructura HashMap que debe contener parejas
 * (figura, valor), por ejemplo (“caballo”, 3). La secuencia de cartas debe ser
 * una estructura de la clase ArrayList que contiene objetos de la clase Carta.
 * El valor de las cartas es el siguiente: as → 11, tres → 10, sota → 2, caballo
 * → 3, rey → 4;el resto de cartas no vale nada.
 */
import java.util.HashMap;
import java.util.ArrayList;

public class Ejercicio12 {
	public static void main(String[] args) {
		// Var declarations
		HashMap<String, Integer> sec = new HashMap<String, Integer>();
		ArrayList<Carta> play = new ArrayList<Carta>();
		int points = 0;

		// Var init
		sec = loadData(sec);

		// Process
		Carta card = new Carta();
		for (int i = 0; i < 5; i++) {
			do {
				card = new Carta();
			} while (play.contains(card));
			play.add(card);
		}

		for (Carta myCard : play) {
			int cardPoints = sec.get(myCard.getNumber());
			System.out.println(myCard + " - " + cardPoints + " puntos");
			points += cardPoints;
		}
		System.out.println("------------------------------------");
		System.out.println("Total puntos en la jugada: " + points + " puntos.");
	}

	public static HashMap<String, Integer> loadData(HashMap<String, Integer> sec) {
		sec.put("As", 11);
		sec.put("Dos", 0);
		sec.put("Tres", 10);
		sec.put("Cuatro", 0);
		sec.put("Cinco", 0);
		sec.put("Seis", 0);
		sec.put("Siete", 0);
		sec.put("Sota", 2);
		sec.put("Caballo", 3);
		sec.put("Rey", 4);
		return sec;
	}
}
