/**
 * Ejercicio3.java
 *
 * @version: 27/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * Escribe un programa que ordene 10 números enteros introducidos por teclado y
 * almacenados en un objeto de la clase ArrayList.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        // Var declaration
        ArrayList<Integer> list;
        int num;

        // Var init
        list = new ArrayList<Integer>();

        // Scanner class
        Scanner sc = new Scanner(System.in);

        // Process
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce el valor " + (i + 1) + ": ");
            num = sc.nextInt();
            list.add(num);
        }

        // Output data
        System.out.print("Lista inicial: ");
        for (int n : list)
            System.out.print(n + " ");
        Collections.sort(list);
        System.out.print("\nLista ordenada: ");
        for (int n : list)
            System.out.print(n + " ");

        // Close scanner
        sc.close();
    }
}
