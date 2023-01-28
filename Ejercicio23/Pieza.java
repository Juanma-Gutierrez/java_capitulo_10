package Ejercicio23;

public class Pieza {
	private NombresPiezas nombre;
	private int valor;

	public Pieza(NombresPiezas nombre) {
		this.nombre = nombre;
		this.valor = switch (nombre) {
			case Dama -> 9;
			case Torre -> 5;
			case Alfil -> 3;
			case Caballo -> 2;
			case Peón -> 1;
		};
	}

	public NombresPiezas getNombre() {
		return nombre;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public String toString() {
		String res = "";
		res += this.nombre + " (" + this.valor + (this.valor == 1 ? " peón)" : " peones)");
		return res;
	}

}
