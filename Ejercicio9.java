/**
 * Ejercicio9.java
 *
 * @version: 29/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

/*
Modifica el programa anterior de tal forma que las cartas se muestren ordenadas.
Primero se ordenarán por palo: bastos, copas, espadas, oros. Cuando
coincida el palo, se ordenará por número: as, 2, 3, 4, 5, 6, 7, sota, caballo, rey.
 */

import java.util.ArrayList;
import java.util.Collections;

import Ejercicio9.Carta;

public class Ejercicio9 {
    public static void main(String[] args) {
        // Var declarations
        ArrayList<Carta> cards = new ArrayList<Carta>();
        int numCards = 10;
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
