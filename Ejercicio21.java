/**
 * Ejercicio21.java
 *
 * @version: 22/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * La asociación “Amigos de los anfibios” nos ha encargado una aplicación
 * educativa sobre estos animalitos. Crea un programa que pida al usuario el
 * tipo de anfibio y que, a continuación, nos muestre su hábitat y su
 * alimentación.
 * Si el tipo de anfibio introducido no existe, se debe mostrar el mensaje “Ese
 * tipo de anfibio no existe”.
 * Ejemplo 1:
 * Introduzca el tipo de anfibio: salamandra
 * Hábitat: Ecosistemas húmedos.
 * Alimentación: Pequeños crustáceos e insectos.
 * Ejemplo 2:
 * Introduzca el tipo de anfibio: gato
 * Ese tipo de anfibio no existe.
 * La información se debe guardar en dos diccionarios (dos HashMap).
 * Uno de ellos tendrá parejas clave-valor del tipo (tipo de anfibio,
 * hábitat) y otro (tipo de anfibio, alimentación).
 */

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio21 {
	public static void main(String[] args) {
		// Var declarations
		HashMap<String, String> habitat = new HashMap<String, String>();
		HashMap<String, String> alimentacion = new HashMap<String, String>();
		String opcion;

		// Var init
		habitat = rellenaHabitat(habitat);
		alimentacion = rellenaAlimentacion(alimentacion);

		// Scanner init
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Introduzca el tipo de anfibio (s para salir): ");
			opcion = sc.nextLine();
			if (habitat.containsKey(opcion)) {
				System.out.println("Hábitat: " + habitat.get(opcion));
				System.out.println("Alimentación: " + alimentacion.get(opcion));
			} else {
				if (!opcion.equals("s"))
					System.out.println("Ese tipo de anfibio no existe.");
			}
		} while (!opcion.equals("s"));

		// Close scanner
		sc.close();
	}

	public static HashMap<String, String> rellenaHabitat(HashMap<String, String> habitat) {
		habitat.put("rana", "En los trópicos y cerca de las zonas húmedas y acuáticas");
		habitat.put("salamandra", "Ecosistemas húmedos");
		habitat.put("sapo", "En cualquier sitio salvo el desierto y la Antártida");
		habitat.put("tritón", "América y África");
		return habitat;
	}

	public static HashMap<String, String> rellenaAlimentacion(HashMap<String, String> alimentacion) {
		alimentacion.put("rana", "Larvas e insectos");
		alimentacion.put("salamandra", "Pequeños crustáceos e insectos");
		alimentacion.put("sapo", "Insectos, lombrices y pequeños roedores");
		alimentacion.put("tritón", "Insectos");
		return alimentacion;
	}
}
