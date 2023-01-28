package Ejercicio23;

import java.util.ArrayList;
import java.util.HashMap;

public class Ajedrez {
	public ArrayList<Pieza> ajedrez = new ArrayList<>();
	public HashMap<NombresPiezas, Integer> disponibles = new HashMap<>();
	{
		disponibles.put(NombresPiezas.Dama, 1);
		disponibles.put(NombresPiezas.Torre, 2);
		disponibles.put(NombresPiezas.Alfil, 2);
		disponibles.put(NombresPiezas.Caballo, 3);
		disponibles.put(NombresPiezas.Peón, 8);
	};

	public Ajedrez() {
		NombresPiezas[] nombres = NombresPiezas.values();
		for (NombresPiezas n : nombres) {
			Pieza p = new Pieza(n);
			while (disponibles.get(n) > 0) {
				ajedrez.add(p);
				disponibles.put(n, disponibles.get(n) - 1);
			}
		}
	}

	public Pieza sacaPieza(Pieza p) {
		if (ajedrez.contains(p)) {
			ajedrez.remove(p);
		}
		return p;
	}

	@Override
	public String toString() {
		return this.ajedrez.toString();
	}
}
