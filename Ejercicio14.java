import java.util.HashMap;

/**
 * Ejercicio14.java
 *
 * @version: 10/01/2023
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
import java.util.HashMap;
import java.util.ArrayList;

public class Ejercicio14 {
    public static void main(String[] args) {
        // Var declarations
        HashMap<String, Integer> product;
        ArrayList <LineaCompra> line;

        // Var init;
        line = new LineaCompra<String, double, int>();

    }
}
