/**
 * Diccionario.java
 *
 * @version: 02/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

public class Diccionario {
    private String ing;
    private String esp;

    public Diccionario() {
    }

    public Diccionario(String ing, String esp) {
        this.ing = ing;
        this.esp = esp;
    }

    public String toString() {
        return (this.getIng() + "\t" + this.getEsp());
    }

    public String getIng() {
        return this.ing;
    }

    public String getEsp() {
        return this.esp;
    }
}
