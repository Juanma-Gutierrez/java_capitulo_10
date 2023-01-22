
/**
 * Ejercicio20.java
 *
 * @version: 22/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
Amplía el programa anterior de tal forma que sea capaz de aprender palabras y
sinónimos. Cuando una palabra no tiene sinónimos, es decir, cuando aparece la
palabra en español con su traducción y esa traducción no la tiene ninguna otra
palabra española, se le preguntará al usuario si quiere añadir uno (un sinónimo)
y, en caso afirmativo, se pedirá la palabra y se añadirá al diccionario. Se
puede dar la circunstancia de que el usuario introduzca una palabra en español
que no está en el diccionario; en tal caso, se mostrará el consiguiente mensaje
y se dará la posibilidad al usuario de añadir la entrada correspondiente en el
diccionario pidiendo, claro está, la palabra en inglés.

Ejemplo:
Introduzca una palabra y le daré los sinónimos: caliente
Sinónimos de caliente: ardiente, abrasador
Introduzca una palabra y le daré los sinónimos: rojo
No conozco sinónimos de esa palabra ¿quiere añadir alguno? (s/n): s
Introduzca un sinónimo de rojo: colorado
Gracias por enseñarme nuevos sinónimos.
Introduzca una palabra y le daré los sinónimos: blanco
No conozco esa palabra ¿quiere añadirla al diccionario? (s/n): s
Introduzca la traducción de blanco en inglés: white
Introduzca una palabra y le daré los sinónimos: rojo
Sinónimos de rojo: colorado
Introduzca una palabra y le daré los sinónimos: blanco
No conozco sinónimos de esa palabra ¿quiere añadir alguno? (s/n): s
Introduzca un sinónimo de blanco: albino
Gracias por enseñarme nuevos sinónimos.
Introduzca una palabra y le daré los sinónimos: blanco
Sinónimos de blanco: albino
Introduzca una palabra y le daré los sinónimos: salir
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio20 {
	public static void main(String[] args) {
		// Var declarations
		HashMap<String, String> dicc = new HashMap<String, String>();
		String opcion;

		// Var init
		dicc = insertaDatos();

		// Scanner class
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("\nIntroduzca una palabra y le daré los sinónimos: ");
			opcion = sc.nextLine();
			if (dicc.containsKey(opcion)) {
				String traduccion = dicc.get(opcion);
				boolean sinonimo = false;
				boolean impreso = false;
				for (Map.Entry<String, String> palabra : dicc.entrySet()) {
					if (palabra.getValue().equals(traduccion) && !palabra.getKey().equals(opcion)) {
						sinonimo = true;
						if (sinonimo && !impreso) {
							System.out.print("Sinónimos de " + opcion + ": ");
							impreso = true;
						}
						System.out.print(palabra.getKey() + ", ");
					}
				}
				if (!sinonimo) {
					System.out.print("No conozco sinónimos de esa palabra");
					System.out.print(" ¿quiere añadir alguno? (s/n): ");
					if (sc.nextLine().equals("s")) {
						System.out.print("Introduzca un sinónimo de " + opcion + ": ");
						String nuevoSinonimo = sc.nextLine();
						dicc.put(nuevoSinonimo, traduccion);
						System.out.print("Gracias por enseñarme nuevos sinónimos");
					}
				}
			} else if (!opcion.equals("salir")) {
				System.out.print("No conozco esa palabra ¿quiere añadirla al diccionario? (s/n):");
				if (sc.nextLine().equals("s")) {
					System.out.print("Introduzca la traducción de " + opcion + " en inglés: ");
					String traduccion = sc.nextLine();
					dicc.put(opcion, traduccion);
				}
			}
		} while (!opcion.equals("salir"));

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
