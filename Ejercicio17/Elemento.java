package Ejercicio17;

public class Elemento {
	private String producto;
	private double precio;
	private int cantidad;

	public Elemento() {
	}

	public Elemento(String producto, double precio, int cantidad) {
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public String getProducto() {
		return producto;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		String res = "";
		res += producto + " ";
		res += "PVP: " + precio + " ";
		res += "Unidades: " + cantidad + " ";
		res += "Subtotal: " + String.format("%.2f", (precio * cantidad));
		return res;
	}
}
