
/**
 * Ejercicio6.java
 *
 * @version: 29/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Ejercicio6 {
    public static void main(String[] args) {
        // Var declarations
        HashMap<String, String> bbdd = new HashMap<String, String>();
        String name;
        String passw;
        int c = 3;
        boolean access = false;

        // Var init
        bbdd.put("JuMaGu", "123456");
        bbdd.put("MaRuAr", "111222");
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
            for (Map.Entry<String, String> pair : bbdd.entrySet()) {
                if (pair.getKey().equals(name) && pair.getValue().equals(passw))
                    access = true;
            }
            c--;
            if (!access)
                System.out.println("Error en los datos introducidos");
        } while (c > 0 && !access);

        // Output data
        if (access)
            System.out.println("Acceso concedido, bienvenido " + name);
        else
            System.out.println("Ha superado el máximo de reintentos.\nAcceso restringido");

        // Close scanner
        sc.close();
    }
}
