/**
 * Apunte.java
 *
 * @version: 22/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

 

public class Apunte {
	private String tipoOperacion;
	private float importe;
	private float saldo;
	private String cuentaOrigen;

	public Apunte(String tipoOperacion, float importe, float saldo, String cuentaOrigen) {
		this.tipoOperacion = tipoOperacion;
		this.importe = importe;
		this.saldo = saldo;
		this.cuentaOrigen = cuentaOrigen;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public float getImporte() {
		return importe;
	}

	public float getSaldo() {
		return saldo;
	}

	public String getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void setCuentaOrigen(String cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	@Override
	public String toString() {
		String res = "";
		String tipo = this.getTipoOperacion().charAt(0) + "";
		if (tipo.equals("T")) {
			res = this.getTipoOperacion() + " de " + this.getImporte() + " euros de la cuenta " + this.getCuentaOrigen()
					+ "  Saldo " + this.getSaldo() + " euros";
		} else
			res = this.getTipoOperacion() + " de " + this.getImporte() + " euros  Saldo: " + this.getSaldo() + " euros";
		return res;
	}
}
