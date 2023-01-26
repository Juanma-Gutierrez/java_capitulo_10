
/**
 * Ejercicio13.java
 *
 * @version: 08/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * Modifica el programa Gestisimal realizado anteriormente añadiendo las
 * siguientes mejoras:
 * - Utiliza una lista en lugar de un array para el almacenamiento de los datos.
 * - Comprueba la existencia del código en el alta, la baja y la modificación de
 *   artículos para evitar errores.
 * - Cambia la opción “Salida de stock” por “Venta”. Esta nueva opción permitirá
 *   hacer una venta de varios artículos y emitir la factura correspondiente.
 * - Se debe preguntar por los códigos y las cantidades de cada artículo que se
 *   quiere comprar. Aplica un 21% de IVA.
 */

import java.util.Scanner;
import Ejercicio13.Item;
import java.util.ArrayList;

public class Ejercicio13 {
	public static void main(String[] args) {
		// Var declarations
		int option;
		ArrayList<Item> store;

		// Var init
		store = new ArrayList<Item>();

		// Scanner class
		Scanner sc = new Scanner(System.in);

		// Process
		initialData(store);

		do {
			printMenu();
			option = sc.nextInt();
			switch (option) {
				case 1:
					listItems(store, sc);
					break;
				case 2:
					newItem(store, sc);
					break;
				case 3:
					deleteItem(store, sc);
					break;
				case 4:
					modifyItem(store, sc);
					break;
				case 5:
					introItem(store, sc);
					break;
				case 6:
					sellItem(store, sc);
					break;
			}
		} while (option != 7);

		// Close scanner
		sc.close();
	}

	public static void listItems(ArrayList<Item> store, Scanner sc) {
		clearScreen();
		System.out.println("****************************************************************************");
		System.out.println("*                            Listado de artículos                          *");
		System.out.println("****************************************************************************");
		for (Item item : store)
			System.out.println(item);
		sc.nextLine();
		pause("", sc);
	}

	public static void initialData(ArrayList<Item> store) {
		Item i;
		i = new Item(1001, "Martillo", 12.25, 4);
		store.add(i);
		i = new Item(1002, "Destornillador de estrella", 3.75, 2);
		store.add(i);
		i = new Item(1003, "Sierra de calar 350W", 24.95, 4);
		store.add(i);
		i = new Item(1004, "Amoladora 750W 7500rpm", 125.25, 1);
		store.add(i);
	}

	public static void printMenu() {
		clearScreen();
		System.out.println("***************************");
		System.out.println("*   G E S T I S I M A L   *");
		System.out.println("***************************");
		System.out.println("* 1. Listado              *");
		System.out.println("* 2. Alta                 *");
		System.out.println("* 3. Baja                 *");
		System.out.println("* 4. Modificación         *");
		System.out.println("* 5. Entrada de mercancía *");
		System.out.println("* 6. Venta de mercancía   *");
		System.out.println("* 7. Salir                *");
		System.out.println("***************************");
	}

	public static ArrayList<Item> newItem(ArrayList<Item> store, Scanner sc) {
		int code;
		String name;
		double price;
		int units;
		Item item;

		clearScreen();
		System.out.println("***************************");
		System.out.println("*    Alta de artículos    *");
		System.out.println("***************************");
		System.out.println();
		do {
			System.out.print("Introduce el código: ");
			code = sc.nextInt();
			if (position(code, store) != -1)
				System.out.println("Ese código ya existe, introduzca otro código");
		} while (position(code, store) != -1);
		System.out.print("Introduce el nombre: ");
		sc.nextLine();
		name = sc.nextLine();
		System.out.print("Introduce el precio: ");
		price = sc.nextFloat();
		System.out.print("Introduce el stock actual: ");
		units = sc.nextInt();
		item = new Item();
		// item.setCode(code);
		item.setCode(code);
		item.setName(name);
		item.setPrice(price);
		item.setStock(units);
		store.add(item);
		sc.nextLine();
		pause("Artículo dado de alta correctamente", sc);
		return store;
	}

	public static ArrayList<Item> deleteItem(ArrayList<Item> store, Scanner sc) {
		int code;
		String option;
		Item item;
		int pos;

		item = new Item();
		clearScreen();
		System.out.println("***************************");
		System.out.println("*    Baja de artículos    *");
		System.out.println("***************************");
		System.out.println();
		System.out.print("Introduce el código: ");
		code = sc.nextInt();
		item.setCode(code);
		pos = position(code, store);
		if (pos == -1) {
			sc.nextLine();
			pause("No se encuentra ningún artículo con ese código", sc);
		} else {
			item = store.get(pos);
			System.out.println("\n" + item.printListHeader());
			System.out.println("\n" + item);
			System.out.print("\n¿Desea eliminar este artículo? (s/n): ");
			sc.nextLine();
			option = sc.nextLine();
			if (option.equals("s") || option.equals("S")) {
				store.remove(item);
				pause("Artículo eliminado correctamente", sc);
			} else {
				pause("Eliminación cancelada", sc);
			}
		}
		return store;
	}

	public static ArrayList<Item> modifyItem(ArrayList<Item> store, Scanner sc) {
		int code;
		String name;
		double price;
		int units;
		String option;
		Item item;
		int pos;

		clearScreen();
		System.out.println("*****************************");
		System.out.println("* Modificación de artículos *");
		System.out.println("*****************************");
		System.out.println();
		System.out.print("Introduce el código: ");
		code = sc.nextInt();
		item = new Item();
		item.setCode(code);
		pos = position(code, store);
		if (pos == -1) {
			sc.nextLine();
			pause("No se encuentra ningún artículo con ese código", sc);
		} else {
			item = store.get(pos);
			System.out.println("\n" + item.printListHeader());
			System.out.println(item);
			System.out.print("\n¿Desea modificar este artículo? (s/n): ");
			sc.nextLine();
			option = sc.nextLine();
			if (option.equals("s") || option.equals("S")) {
				store.remove(pos);
				do {
					System.out.print("Introduce el código: ");
					code = sc.nextInt();
					if (position(code, store) != -1)
						System.out.println("Ese código ya existe, introduzca otro código");
				} while (position(code, store) != -1);
				System.out.print("Introduce el nombre: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.print("Introduce el precio: ");
				price = sc.nextFloat();
				System.out.print("Introduce el stock actual: ");
				units = sc.nextInt();
				item.setCode(code);
				item.setName(name);
				item.setPrice(price);
				item.setStock(units);
				store.add(pos, item);
				sc.nextLine();
				pause("Artículo modificado correctamente", sc);
			} else {
				pause("Modificación cancelada", sc);
			}
		}
		return store;
	}

	public static ArrayList<Item> introItem(ArrayList<Item> store, Scanner sc) {
		int code;
		int units;
		String option;
		int pos;
		Item item;

		clearScreen();
		System.out.println("*****************************");
		System.out.println("*   Entrada de artículos    *");
		System.out.println("*****************************");
		System.out.println();
		System.out.print("Introduce el código: ");
		code = sc.nextInt();
		pos = position(code, store);

		if (pos == -1) {
			sc.nextLine();
			pause("No se ha encontrado el artículo", sc);
		} else {
			item = new Item();
			item = store.get(pos);
			System.out.println("\n" + item.printListHeader());
			System.out.println(item);
			System.out.print("\n¿Desea introducir unidades para este artículo? (s/n): ");
			sc.nextLine();
			option = sc.nextLine();
			if (option.equals("s") || option.equals("S")) {
				System.out.print("Introduce las unidades de entrada: ");
				units = sc.nextInt();
				item.setUnits(units);
				store.set(pos, item);
				sc.nextLine();
				pause("Entrada de unidades dadas de alta correctamente", sc);
			} else {
				pause("Entrada de unidades cancelada", sc);
			}
		}
		return store;
	}

	public static ArrayList<Item> sellItem(ArrayList<Item> store, Scanner sc) {
		int code;
		int units;
		Item item;
		int pos;
		ArrayList<Item> sellList;
		final double margin = 1.2;

		sellList = new ArrayList<Item>();
		clearScreen();
		System.out.println("*****************************");
		System.out.println("*     Venta de artículos    *");
		System.out.println("*****************************");
		System.out.println();
		do {
			System.out.print("Introduce el código (0 para salir): ");
			code = sc.nextInt();
			pos = position(code, store);
			if (pos == -1) {
				if (code != 0) {
					sc.nextLine();
					pause("No se ha encontrado el artículo", sc);
				}
			} else {
				item = new Item();
				item = store.get(pos);
				System.out.println("\n" + item.printListHeader());
				System.out.println(item);
				System.out.print("\n¿Cuántas unidades desea vender?: ");
				units = sc.nextInt();
				if (units > item.getStock()) {
					pause("Hay un total de " + item.getStock() + " unidades en stock.\nNo puedes sacar " + units
							+ " unidades.", sc);
				} else {
					item.setUnits(-units);
					store.set(pos, item);
					item.setUnitSell(units);
					item.setPrice(item.getPrice() * margin);
					item.setTotal(item.getPrice() * units);
					sellList.add(item);
				}
			}
		} while (code != 0);
		printTicket(sellList, sc);
		return store;
	}

	/**
	 * Imprime el ticket de venta por pantalla
	 * 
	 * @param sellList ArrayList con la lista de artículos vendidos
	 * @param sc       Scanner
	 */
	public static void printTicket(ArrayList<Item> sellList, Scanner sc) {
		double total;
		total = 0;
		System.out.println("\n" + sellList.get(0).printSellListHeader());
		for (Item aux : sellList) {
			total += aux.getTotal();
			System.out.println(aux.sellLine());
		}
		System.out.println("============================================================================\n");
		double base = total / 1.21;
		System.out.printf("%50sBase Imponible: %10.2f\n", "", base);
		System.out.printf("%50s           IVA: %10.2f\n", "", (total-base));
		System.out.printf("%50s  TOTAL COMPRA: %10.2f\n", "", total);
		sc.nextLine();
		pause("", sc);
	}

	/**
	 * Devuelve la posición de un elemento en un ArrayList
	 * 
	 * @param code  Código a buscar
	 * @param store ArrayList donde buscar
	 * @return int con la posición (-1 si no se encuentra)
	 */
	public static int position(int code, ArrayList<Item> store) {
		int i = -1;
		for (Item s : store) {
			i++;
			if (s.getCode() == code)
				return i;
		}
		return -1;
	}

	/**
	 * Limpia toda la pantalla
	 */
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	/**
	 * Realiza una pausa y muestra el mensaje pasado por parámetro
	 * 
	 * @param phrase Frase a mostrar
	 * @param sc     Scanner
	 */
	private static void pause(String phrase, Scanner sc) {
		String y = "\033[0;33m";
		String r = "\033[0m";
		System.out.println("\n" + phrase);
		System.out.println(y + "\nPulse una tecla para continuar" + r);
		sc.nextLine();
	}
}
