/**
 * LineaCompra.java
 *
 * @version: 10/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

public class LineaCompra {
    private String product;
    private double price;
    private int cant;

    public LineaCompra(String product, double price, int cant) {
        this.product = product;
        this.price = price;
        this.cant = cant;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCant() {
        return this.cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    @Override
    public String toString() {
        return String.format("%-20s%10.2f%10d%10.2f",
                getProduct(),
                getPrice(),
                getCant(),
                (getPrice() * getCant()));
    }

}
