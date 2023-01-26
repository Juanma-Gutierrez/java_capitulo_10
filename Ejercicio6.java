/**
 * Ejercicio6.java
 *
 * @version: 29/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * Implementa el control de acceso al área restringida de un programa. Se debe
 * pedir un nombre de usuario y una contraseña. Si el usuario introduce los
 * datos correctamente, el programa dirá “Ha accedido al área restringida”. El
 * usuario tendrá un máximo de 3 oportunidades. Si se agotan las oportunidades
 * el programa dirá “Lo siento, no tiene acceso al área restringida”. Los
 * nombres de usuario con sus correspondientes contraseñas deben estar
 * almacenados en una estructura de la clase HashMap.
 */

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        // Var declarations
        HashMap<String, String> bbdd = new HashMap<String, String>();
        String name;
        String passw;
        int intentos = 3;
        boolean access = false;

        // Var init
        bbdd.put("JuaGut", "123456");
        bbdd.put("MarRui", "111222");
        bbdd.put("MarVal", "111111");
        bbdd.put("NurRue", "000000");
        bbdd.put("AleGir", "999999");

        // Scanner class
        Scanner sc = new Scanner(System.in);

        // System.out.println(bbdd.entrySet());
        // Process
        do {
            System.out.print("Introduce nombre de usuario: ");
            name = sc.nextLine();
            System.out.print("Introduce contraseña: ");
            passw = sc.nextLine();

            if (bbdd.containsKey(name)){
                if (passw.equals(bbdd.get(name))){
                    access = true;
                }
            }
            intentos--;
            if (!access)
                System.out.println("Error en los datos introducidos");
        } while (intentos > 0 && !access);

        // Output data
        if (access)
            System.out.println("Ha accedido al área restringida, bienvenido: " + name);
        else
            System.out.println("Lo siento, no tiene acceso al área restringida");

        // Close scanner
        sc.close();
    }
}
