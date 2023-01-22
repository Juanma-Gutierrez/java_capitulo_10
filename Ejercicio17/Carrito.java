package Ejercicio17;

import java.util.ArrayList;

public class Carrito {
	private int numProductos;
	private ArrayList<Elemento> carrito = new ArrayList<Elemento>();

	public Carrito() {
	}

	public Carrito(Elemento elemento) {
		numProductos++;
		this.carrito.add(elemento);
	}

	public void agrega(Elemento elemento) {
		numProductos++;
		this.carrito.add(elemento);
	}

	public int numeroDeElementos() {
		return this.numProductos;
	}

	public float importeTotal() {
		float res = 0;
		for (Elemento elemento : carrito) {
			res += elemento.getPrecio() * elemento.getCantidad();
		}
		return res;
	}

	@Override
	public String toString() {
		String res = "";
		res += "Contenido del carrito\n";
		res += "=====================\n";
		for (Elemento elemento : carrito) {
			res += elemento + "\n";
		}
		return res;
	}
}
