/**
 * Ejercicio9.java
 *
 * @version: 29/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

/*
 * Realiza un programa que escoja al azar 10 cartas de la baraja española
 * (10 objetos de la clase Carta). Emplea un objeto de la clase ArrayList para
 * almacenarlas y asegúrate de que no se repite ninguna.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio9 {
    public static void main(String[] args) {
        // Var declarations
        ArrayList<Carta> cards = new ArrayList<Carta>();
        int numCards = 40;
        for (int i = 0; i < numCards; i++) {
            Carta card;
            boolean ok;
            do {
                ok = true;
                card = new Carta();
                for (Carta c : cards) {
                    if (c.getNumber().equals(card.getNumber()) && c.getSuit().equals(card.getSuit()))
                        ok = false;
                }
            } while (!ok);
            cards.add(card);
        }
        Collections.sort(cards);
        for (Carta c : cards) {
            System.out.println(c);
        }
    }
}
