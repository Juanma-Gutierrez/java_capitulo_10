
/**
 * Ejercicio7.java
 *
 * @version: 29/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * La máquina Eurocoin genera una moneda de curso legal cada vez que se pulsa
 * un botón siguiendo la siguiente pauta: o bien coincide el valor con la moneda
 * anteriormente generada - 1 céntimo, 2 céntimos, 5 céntimos, 10 céntimos, 25
 * céntimos, 50 céntimos, 1 euro o 2 euros - o bien coincide la posición – cara
 * o cruz. Simula, mediante un programa, la generación de 6 monedas aleatorias
 * siguiendo la pauta correcta. Cada moneda generada debe ser una instancia de
 * la clase Moneda y la secuencia se debe ir almacenando en una lista.
 */
import java.util.ArrayList;
import Ejercicio7.Moneda;

public class Ejercicio7 {
    public static void main(String[] args) {
        // Var declarations
        ArrayList<Moneda> list = new ArrayList<Moneda>();
        Moneda coin;
        int tries = 10;

        // Var init
        coin = new Moneda();

        list.add(coin);

        do {
            coin = new Moneda();
            if (list.get(list.size() - 1).getValue() == coin.getValue() ||
                    list.get(list.size() - 1).getHead().equals(coin.getHead())) {
                list.add(coin);
                tries--;
            }
        } while (tries > 0);

        for (Moneda coinAux : list) {
            System.out.println(coinAux);
        }
    }
}
