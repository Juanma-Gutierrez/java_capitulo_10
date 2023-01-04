
/**
 * Ejercicio11.java
 *
 * @version: 04/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * Realiza un programa que escoja al azar 5 palabras en español del
 * minidiccionario del ejercicio anterior. El programa irá pidiendo que el
 * usuario teclee la traducción al inglés de cada una de las palabras y
 * comprobará si son correctas. Al final, el programa deberá mostrar cuántas
 * espuestas son válidas y cuántas erróneas.
 */
import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        // Var declarations
        HashMap<String, String> dicc = new HashMap<String, String>();
        String translate;
        final int tries;
        int valid;

        // Var init
        dicc = loadData(dicc);
        tries = 5;
        valid = 0;

        // Scanner class
        Scanner sc = new Scanner(System.in);

        // Process
        for (int i = 0; i < tries; i++) {
            String[] auxKey = dicc.keySet().toArray(new String[0]);
            String[] auxValue = dicc.values().toArray(new String[0]);
            int nWord = (int) (Math.random() * 20);
            System.out.print("Palabra nº " + (i + 1) + ", " + auxKey[nWord] + ": ");
            translate = sc.nextLine();
            if (translate.equals(auxValue[nWord])) {
                System.out.println("Correcto!!");
                valid++;
            } else
                System.out.println("Incorrecto, la traducción correcta es: " + auxValue[nWord]);
        }

        System.out.println("\nHas acertado " + valid + " palabras y has fallado " + (tries - valid) + " palabras");
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
