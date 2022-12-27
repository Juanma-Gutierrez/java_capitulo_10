/**
 * Ejercicio4.java
 *
 * @version: 27/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * Realiza un programa equivalente al anterior pero en esta ocasión, el programa
 * debe ordenar palabras en lugar de números.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        // Var declaration
        ArrayList<String> list;
        String word;

        // Var init
        list = new ArrayList<String>();

        // Scanner class
        Scanner sc = new Scanner(System.in);

        // Process
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce la palabra " + (i + 1) + ": ");
            word = sc.nextLine();
            list.add(word);
        }

        // Output data
        System.out.print("Lista inicial: ");
        for (String n : list)
            System.out.print(n + " ");
        Collections.sort(list);
        System.out.print("\nLista ordenada: ");
        for (String n : list)
            System.out.print(n + " ");

        // Close scanner
        sc.close();
    }
}
