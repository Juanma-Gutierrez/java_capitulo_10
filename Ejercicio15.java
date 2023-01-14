import java.util.HashMap;

/**
 * Ejercicio15.java
 *
 * @version: 14/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

/**
 * Un supermercado de productos ecológicos nos ha pedido hacer un programa
 * para vender su mercancía. En esta primera versión del programa se tendrán
 * en cuenta los productos que se indican en la tabla junto con su precio. Los
 * productos se venden en bote, brick, etc. Cuando se realiza la compra, hay que
 * indicar el producto y el número de unidades que se compran, por ejemplo
 * “guisantes” si se quiere comprar un bote de guisantes y la cantidad, por
 * ejemplo “3” si se quieren comprar 3 botes. La compra se termina con la
 * palabra “fin. Suponemos que el usuario no va a intentar comprar un producto
 * que no existe. Utiliza un diccionario para almacenar los nombres y precios de
 * los productos y una o varias listas para almacenar la compra que realiza el
 * usuario.
 * A continuación se muestra una tabla con los productos disponibles y sus
 * respectivos precios:
 * avena garbanzos tomate jengibre quinoa guisantes
 * 2,21 2,39 1,59 3,13 4,50 1,60
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio15 {
	public static void main(String[] args) {
		// Var declarations
		HashMap<String, Double> products;
		ArrayList<LineaCompra> line;
		String item;
		int cant;
		String dto;

		// Scanner class
		Scanner sc = new Scanner(System.in);

		// Var init;
		line = new ArrayList<LineaCompra>();
		products = new HashMap<String, Double>();
		products = loadData(products);
		cant = 0;

		System.out.println("*************************");
		System.out.println("* T I E N D A   P E P E *");
		System.out.println("*************************");
		System.out.println();
		System.out.println("Artículos disponibles:");
		System.out.println("avena");
		System.out.println("garbanzos");
		System.out.println("tomate");
		System.out.println("jengibre");
		System.out.println("quinoa");
		System.out.println("guisantes");
		System.out.println("fin: salir");
		System.out.println();
		do {
			do {
				System.out.print("Producto: ");
				item = sc.nextLine();
			} while (!products.containsKey(item) && !item.equals("fin"));
			if (!item.equals("fin")) {
				System.out.print("Cantidad: ");
				cant = sc.nextInt();
				sc.nextLine();

				boolean find = false;
				int pos = 0;
				int i = 0;
				for (LineaCompra lineAux : line) {
					if (lineAux.getProduct().equals(item)) {
						if (!find)
							pos = i;
						cant += lineAux.getCant();
						find = true;
					}
					i++;
				}
				LineaCompra aux = new LineaCompra(item, products.get(item), cant);
				if (find) {
					line.set(pos, aux);
				} else
					line.add(aux);
			}
		} while (!item.equals("fin"));
		System.out.println("Introduzca código de descuento (INTRO si no tiene ninguno):");
		dto = sc.nextLine();

		printTicket(line, dto);

		// Close scanner
		sc.close();
	}

	public static void printTicket(ArrayList<LineaCompra> line, String dto) {
		double dtoInPurchase = 0;
		double total = 0;
		System.out.printf("%-20s%10s%10s%10s\n", "Producto", "Precio", "Cantidad", "Subtotal");
		System.out.println("---------------------------------------------------------");
		for (LineaCompra aux : line) {
			System.out.println(aux);
			total += aux.getPrice() * aux.getCant();
		}
		if (dto.equals("ECODTO")) {
			System.out.println("---------------------------------------------------------");
			dtoInPurchase = total * 0.1;
			System.out.printf("Descuento: %.2f\n", dtoInPurchase);
		}
		System.out.println("---------------------------------------------------------");
		System.out.printf("TOTAL: %.2f\n", (total - dtoInPurchase));
	}

	public static HashMap<String, Double> loadData(HashMap<String, Double> products) {
		products.put("avena", 2.21);
		products.put("garbanzos", 2.39);
		products.put("tomate", 1.59);
		products.put("jengibre", 3.13);
		products.put("quinoa", 4.50);
		products.put("guisantes", 1.60);
		return products;
	}

	public static ArrayList<LineaCompra> checkPurchase(ArrayList<LineaCompra> lines, HashMap<String, Double> products) {
		// Var declarations
		ArrayList<LineaCompra> res;
		res = new ArrayList<LineaCompra>();

		return res;
	}
}
