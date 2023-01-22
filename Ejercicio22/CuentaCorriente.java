
/**
 * CuentaCorriente.java
 *
 * @version: 22/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

import java.util.ArrayList;

public class CuentaCorriente {
	private String numCuenta;
	private float saldo;
	private ArrayList<Apunte> apuntes = new ArrayList<Apunte>();

	private String generaCuenta() {
		String numCuenta = "";
		for (int i = 0; i < 10; i++)
			numCuenta += (int) (Math.random() * 10);
		return numCuenta;
	}

	public CuentaCorriente(int saldo) {
		this.numCuenta = this.generaCuenta();
		this.saldo = saldo;
	}

	public CuentaCorriente() {
		this(0);
	}

	public String getCuentaCorriente() {
		return this.numCuenta;
	}

	/**
	 * setSaldo: Asigna el parámetro como saldo de la cuenta
	 *
	 * @param saldo Saldo a asignar en la cuenta
	 */
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	/**
	 * getSaldo: Devuelve el saldo de la cuenta
	 *
	 * @return saldo
	 */
	public float getSaldo() {
		return this.saldo;
	}

	@Override
	public String toString() {
		return "Número de cta: " + this.numCuenta + " Saldo: " + this.saldo + " Euros";
	}

	/**
	 * ingreso: Ingresa una cantidad en la cuenta
	 *
	 * @param cantidad Cantidad a ingresar en la cuenta
	 * @throws ApunteException
	 */
	public void ingreso(float cantidad) throws ApunteException {
		if (cantidad < 0)
			throw new ApunteException();
		else {
			this.saldo += cantidad;
			Apunte nuevoApunte = new Apunte("Ingreso", cantidad, this.saldo, "");
			this.apuntes.add(nuevoApunte);
		}
	}

	/**
	 * ingresoTransferencia: Ingresa una cantidad en la cuenta
	 *
	 * @param cantidad Cantidad a ingresar en la cuenta
	 * @throws ApunteException
	 */
	public void ingresoTransferencia(float cantidad, String cuenta) throws ApunteException {
		if (cantidad < 0)
			throw new ApunteException();
		else {
			this.saldo += cantidad;
			Apunte nuevoApunte = new Apunte("Transf. recibida", cantidad, this.saldo, cuenta);
			this.apuntes.add(nuevoApunte);
		}
	}

	/**
	 * cargo: Carga una cantidad en la cuenta
	 *
	 * @param cantidad Cantidad a cargar en la cuenta
	 * @throws ApunteException
	 */
	public void cargo(float cantidad) throws ApunteException {
		if (cantidad < 0)
			throw new ApunteException();
		else {
			this.saldo -= cantidad;
			Apunte nuevoApunte = new Apunte("Cargo", cantidad, this.saldo, "");
			this.apuntes.add(nuevoApunte);
		}
	}

	/**
	 * transferencia: Realiza una transferencia de this a la cuenta pasada por
	 * parámetro de la cantidad pasada por parámetro
	 *
	 * @param cuenta   Cuenta destino de la transferencia
	 * @param cantidad Cantidad a transferir
	 * @throws ApunteException
	 */
	public void transferencia(CuentaCorriente cuenta, float cantidad) throws ApunteException {
		cuenta.ingresoTransferencia(cantidad, this.getCuentaCorriente());
		this.saldo -= cantidad;
		Apunte nuevoApunte = new Apunte("Transf. emitida", cantidad, this.saldo, cuenta.getCuentaCorriente());
		this.apuntes.add(nuevoApunte);
	}

	public void movimientos() {
		System.out.println("Movimientos de la cuenta " + this.getCuentaCorriente());
		System.out.println("-----------------------------------");
		for (Apunte apunte : apuntes)
			System.out.println(apunte.toString());
	}
}
