/**
 * Ejercicio16.java
 *
 * @version: 21/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * Realiza un programa que sepa decir la capital de un país (en caso de conocer
 * la respuesta) y que, además, sea capaz de aprender nuevas capitales. En
 * principio, el programa solo conoce las capitales de España, Portugal y
 * Francia.
 * Estos datos deberán estar almacenados en un diccionario. Los datos sobre
 * capitales que vaya aprendiendo el programa se deben almacenar en el mismo
 * diccionario. El usuario sale del programa escribiendo la palabra “salir”.
 * Ejemplo:
 * Escribe el nombre de un país y te diré su capital: España
 * La capital de España es Madrid
 * Escribe el nombre de un país y te diré su capital: Alemania
 * No conozco la respuesta ¿cuál es la capital de Alemania?: Berlín
 * Gracias por enseñarme nuevas capitales
 * Escribe el nombre de un país y te diré su capital: Portugal
 * La capital de Portugal es Lisboa
 * Escribe el nombre de un país y te diré su capital: Alemania
 * La capital de Alemania es Berlín
 * Escribe el nombre de un país y te diré su capital: Francia
 * La capital de Francia es París
 * Escribe el nombre de un país y te diré su capital: salir
 */

import java.util.Scanner;
import java.util.HashMap;

public class Ejercicio16 {
	public static void main(String[] args) {
		// Var declarations
		HashMap<String, String> dicc = new HashMap<String, String>();
		String option;
		String capital;

		// Scanner class
		Scanner sc = new Scanner(System.in);

		// Var init
		dicc.put("España", "Madrid");
		dicc.put("Portugal", "Lisboa");
		dicc.put("Francia", "París");

		do {
			System.out.print("Escribe el nombre de un país y te diré su capital: ");
			option = sc.nextLine();
			if (dicc.containsKey(option))
				System.out.println("La capital de " + option + " es " + dicc.get(option));
			else {
				System.out.println("No conozco la respuesta ¿cuál es la capital de " + option + "?");
				capital = sc.nextLine();
				dicc.put(option, capital);
				System.out.println("Gracias por enseñarme nuevas capitales");
			}
		} while (option != "salir");

		// Close scanner
		sc.close();
	}
}
