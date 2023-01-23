package Ejercicio9;

/**
 * Carta.java
 *
 * @version: 29/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

public class Carta implements Comparable<Carta> {
    private static String[] numberList = { "As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Sota", "Caballo",
            "Rey" };
    private static String[] suitList = { "bastos", "copas", "espadas", "oros" };
    private Integer number;
    private String suit;
    private String order;

    public Carta() {
        this.number = (int) (Math.random() * 10);
        this.suit = suitList[(int) (Math.random() * 4)];
    }

    public String toString() {
        return this.number + " de " + this.suit;
    }

    public String getNumber() {
        return numberList[this.number];
    }

    public int getNumberValue() {
        return this.number;
    }
    public String getSuit() {
        return this.suit;
    }

    public String getOrder() {
        return this.order;
    }

    /**
     * Ordena el ArrayList por palo y por número de forma alfabética
     *
     * @param card Carta con la que se compara
     * @return posición a devolver
     */
    @Override
    public int compareTo(Carta card) {
        if (suit.equals(card.getSuit())) {
            return (this.number).compareTo(card.getNumberValue());
        } else {
            return suit.compareTo(card.getSuit());
        }
    }

}
