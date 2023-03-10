package Ejercicio13;
/**
 * Item.java
 *
 * @version: 26/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

public class Item {
	private int code;
	private String name;
	private double price;
	private int stock;
	private int unitSell;
	private double total;

	public Item() {
		this.stock = 0;
	}

	public Item(int code, String name, double price, int units) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.stock += units;
	}

	public String toString() {
		String ret = "";
		ret += String.format("%-7d ", code);
		ret += String.format("%-53s ", name);
		ret += String.format("%7.2f ", price);
		ret += String.format("%6d", stock);
		return (ret);
	}

	public String printListHeader() {
		String ret = "";
		ret += String.format("%-7s ", "Código");
		ret += String.format("%-53s ", "Nombre del artículo");
		ret += String.format("%7s ", "Precio");
		ret += String.format("%6s\n", "Stock");
		ret += "============================================================================";
		return (ret);
	}

	public String printSellListHeader() {
		String ret = "";
		ret += String.format("%-7s ", "Código");
		ret += String.format("%-43s ", "Nombre del artículo");
		ret += String.format("%7s ", "Precio");
		ret += String.format("%6s", "Unidad");
		ret += String.format("%10s\n", "Total");
		ret += "============================================================================";
		return (ret);
	}

	public String sellLine() {
		String ret = "";
		ret += String.format("%-7d ", code);
		ret += String.format("%-43s ", name);
		ret += String.format("%7.2f ", price);
		ret += String.format("%6d", unitSell);
		ret += String.format("%10.2f", total);
		return (ret);
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setUnits(int units) {
		this.stock += units;
	}

	public int getStock() {
		return this.stock;
	}

	public int getUnitSell() {
		return this.unitSell;
	}

	public void setUnitSell(int units) {
		this.unitSell = units;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return this.total;
	}
}
