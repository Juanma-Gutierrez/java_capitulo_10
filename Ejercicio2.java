/**
 * Ejercicio2.java
 *
 * @version: 27/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

/*
 * Realiza un programa que introduzca valores aleatorios (entre 0 y 100) en un
 * ArrayList y que luego calcule la suma, la media, el máximo y el mínimo de
 * esos números. El tamaño de la lista también será aleatorio y podrá oscilar
 * entre 10 y 20 elementos ambos inclusive.
 */

import java.util.ArrayList;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Var declarations
        ArrayList<Integer> list;
        int max;
        int min;
        int sum;
        int num;
        int len;

        // Var init
        len = ((int) (Math.random() * 11) + 10);
        list = new ArrayList<Integer>();
        max = 0;
        min = 100;
        sum = 0;

        // Process
        for (int i = 0; i < len; i++) {
            num = (int) (Math.random() * 101);
            list.add(num);
            if (num > max)
                max = num;
            if (num < min)
                min = num;
            sum += num;
        }
        System.out.println("lista:          " + list);
        list.sort(null);
        System.out.println("lista ordenada: " + list);
        System.out.println("Valor máximo: " + max);
        System.out.println("Valor mínimo: " + min);
        System.out.println("Suma de los valores: " + sum);
        System.out.println("Media de los valores: " + String.format("%.2f", (float) sum / len));
    }
}
