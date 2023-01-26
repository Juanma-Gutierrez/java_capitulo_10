package Ejercicio7;
/**
 * Moneda.java
 *
 * @version: 29/12/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

public class Moneda {
    private double value;
    private String head;

    public Moneda() {
        int coin;
        int head;

        coin = (int) (Math.random() * 8);
        switch (coin) {
            case 0:
                this.value = 0.01;
                break;
            case 1:
                this.value = 0.02;
                break;
            case 2:
                this.value = 0.05;
                break;
            case 3:
                this.value = 0.10;
                break;
            case 4:
                this.value = 0.20;
                break;
            case 5:
                this.value = 0.50;
                break;
            case 6:
                this.value = 1;
                break;
            case 7:
                this.value = 2;
                break;
        }
        head = (int) (Math.random() * 2);
        switch (head) {
            case 0:
                this.head = "cara";
                break;
            case 1:
                this.head = "cruz";
                break;
        }
    }

    public String toString() {
        String res;
        double value = this.value;
        if (value < 1)
            res = this.value + " céntimos - ";
        else
            res = this.value + " euro - ";
        res += this.head;
        return (res);
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getHead() {
        return this.head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
