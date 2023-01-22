
/**
 * Ejercicio19.java
 *
 * @version: 22/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/**
 * Realiza un buscador de sinónimos. Utiliza el diccionario español-inglés que
 * se proporciona a continuación. El programa preguntará una palabra y dará una
 * lista de sinónimos (palabras que tienen el mismo significado). Por ejemplo,
 * si se introduce la palabra “caliente”, el programa dará como resultado:
 * ardiente, candente, abrasador. ¿Cómo sabe el programa cuáles son los
 * sinónimos de “caliente”? Muy fácil, en el diccionario debe existir la entrada
 * (“caliente”, “hot”), por tanto solo tendrá que buscar las palabras en español
 * que también signifiquen “hot”; esta información estará en las entradas
 * (“ardiente”, “hot”) y (“abrasador”, “hot”). Cuando una palabra existe en el
 * diccionario pero no tiene sinónimos, debe mostrar el mensaje “No conozco
 * sinónimos de esa palabra”. Si una palabra no está en el diccionario se
 * mostrará el mensaje “No conozco esa palabra”. El usuario sale del programa
 * escribiendo la palabra “salir”.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio19 {
	public static void main(String[] args) {
		// Var declarations
		HashMap<String, String> dicc = new HashMap<String, String>();
		String option;

		// Var init
		dicc = insertaDatos();

		// Scanner class
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Introduzca una palabra y le daré los sinónimos: ");
			option = sc.nextLine();
			if (dicc.containsKey(option)) {
				String traduccion = dicc.get(option);
				boolean sinonimo = false;
				boolean impreso = false;
				for (Map.Entry<String, String> palabra : dicc.entrySet()) {
					if (palabra.getValue().equals(traduccion) && !palabra.getKey().equals(option)) {
						sinonimo = true;
						if (sinonimo && !impreso) {
							System.out.print("Sinónimos de " + option + ": ");
							impreso = true;
						}
						System.out.print(palabra.getKey() + ", ");
					}
				}
				if (!sinonimo)
					System.out.print("No conozco sinónimos de esa palabra");
			} else if (!option.equals("salir"))
				System.out.print("No conozco esa palabra");
			System.out.println();
		} while (!option.equals("salir"));

		// Close scanner
		sc.close();
	}

	public static HashMap<String, String> insertaDatos() {
		HashMap<String, String> dicc = new HashMap<String, String>();
		dicc.put("caliente", "hot");
		dicc.put("rojo", "red");
		dicc.put("ardiente", "hot");
		dicc.put("verde", "green");
		dicc.put("agujetas", "stiff");
		dicc.put("abrasador", "hot");
		dicc.put("hierro", "iron");
		dicc.put("grande", "big");
		return dicc;

	}
}
