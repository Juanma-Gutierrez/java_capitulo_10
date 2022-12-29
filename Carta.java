
/**
 * Carta.java
 *
 * @version: 29/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

public class Carta {
    private static String[] numberList = { "As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Sota", "Caballo",
            "Rey" };
    private static String[] suitList = { "bastos", "copas", "espadas", "oros" };
    private String number;
    private String suit;

    public Carta() {
        this.number = numberList[(int) (Math.random() * 10)];
        this.suit = suitList[(int) (Math.random() * 4)];
    }

    public String toString() {
        return this.number + " de " + this.suit;
    }

    public String getNumber() {
        return this.number;
    }

    public String getSuit() {
        return this.suit;
    }

}
