package Ejercicio18;

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
		boolean rep = false;
		for (Elemento elementoEnCarrito : carrito) {
			if (elementoEnCarrito.getProducto().equals(elemento.getProducto())) {
				elementoEnCarrito.setCantidad(elementoEnCarrito.getCantidad() + elemento.getCantidad());
				rep = true;
			}
		}
		if (!rep) {
			this.carrito.add(elemento);
		}
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
