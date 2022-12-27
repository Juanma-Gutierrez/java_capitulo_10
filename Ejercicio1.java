/**
 * Ejercicio1.java
 *
 * @version: 27/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * Crea un ArrayList con los nombres de 6 compañeros de clase. A continuación,
 * muestra esos nombres por pantalla. Utiliza para ello un bucle for que recorra
 * todo el ArrayList sin usar ningún índice.
 */

import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Var declarations
        ArrayList<String> alumnos;

        // Var init
        alumnos = new ArrayList<String>();

        // Process
        alumnos.add("Marina");
        alumnos.add("Antonio");
        alumnos.add("Nuria");
        alumnos.add("Marco");
        alumnos.add("Denisa");
        alumnos.add("Adrián");
        for (String n : alumnos) {
            System.out.println(n);
        }
    }

}
