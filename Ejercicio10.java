/**
 * Ejercicio10.java
 *
 * @version: 02/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * Crea un mini-diccionario español-inglés que contenga, al menos, 20 palabras
 * (con su correspondiente traducción). Utiliza un objeto de la clase HashMap
 * para almacenar las parejas de palabras. El programa pedirá una palabra en
 * español y dará la correspondiente traducción en inglés.
 */

import java.util.Scanner;
import java.util.HashMap;

public class Ejercicio10 {
    public static void main(String[] args) {
        // Var declarations
        HashMap<String, String> dicc = new HashMap<String, String>();
        String option;

        // Var init
        dicc = loadData(dicc);

        // Scanner class
        Scanner sc = new Scanner(System.in);

        // Process
        do {
            System.out.println("Introduzca un animal en español para traducir a inglés ('s' para salir del programa): ");
            option = sc.nextLine();
            if (!option.equals("s")) {
                if (dicc.containsKey(option))
                    System.out.println("Traducción de " + option + " al inglés: " + dicc.get(option));
                else
                    System.out.println("No tengo esa palabra en mi diccionario");
            }
        } while (!option.equals("s"));
        System.out.println("Gracias por usar nuestro diccionario");

        // Close scanner
        sc.close();
    }

    public static HashMap<String, String> loadData(HashMap<String, String> dicc) {
        dicc.put("abeja", "bee");
        dicc.put("araña", "spider");
        dicc.put("ballena", "whale");
        dicc.put("caballito de mar", "seahorse");
        dicc.put("caballo", "horse");
        dicc.put("cabra", "goat");
        dicc.put("cordero", "lamb");
        dicc.put("delfin", "dolphin");
        dicc.put("gato", "cat");
        dicc.put("hormiga", "ant");
        dicc.put("mariposa", "butterfly");
        dicc.put("murcielago", "bat");
        dicc.put("oveja", "sheep");
        dicc.put("perro", "dog");
        dicc.put("pez", "fish");
        dicc.put("polilla", "moth");
        dicc.put("pollo", "chicken");
        dicc.put("rana", "frog");
        dicc.put("serpiente", "snake");
        dicc.put("tiburon", "shark");
        dicc.put("toro", "bull");
        dicc.put("vaca", "cow");
        return dicc;
    }
}
