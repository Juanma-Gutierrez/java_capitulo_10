
/**
 * Ejercicio22.java
 *
 * @version: 22/01/2023
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

/*
 * Amplía el ejercicio 13 del capítulo anterior que implementaba cuentas
 * corrientes de un banco de tal forma que cada cuenta lleve un registro de
 * todos los movimientos realizados: ingresos, cargos y transferencias (tanto
 * enviadas como recibidas).
 *
 * Contenido del main
 * CuentaCorriente cuenta1 = new CuentaCorriente();
 * CuentaCorriente cuenta2 = new CuentaCorriente(1500);
 * CuentaCorriente cuenta3 = new CuentaCorriente(6000);
 * cuenta1.ingreso(2000);
 * cuenta1.cargo(600);
 * cuenta3.ingreso(75);
 * cuenta1.cargo(55);
 * cuenta2.transferencia(cuenta1, 100);
 * cuenta1.transferencia(cuenta3, 250);
 * cuenta3.transferencia(cuenta1, 22);
 * cuenta1.movimientos();
 * Salida
 * Movimientos de la cuenta 1654432813
 * -----------------------------------
 * Ingreso de 2000 € Saldo: 2000,00 €
 * Cargo de 600 € Saldo: 1400,00 €
 * Cargo de 55 € Saldo: 1345,00 €
 * Transf. recibida de 100 € de la cuenta 1654432813 Saldo 1445,00 €
 * Transf. emitida de 250 € a la cuenta 6546817008 Saldo 1195,00 €
 * Transf. recibida de 22 € de la cuenta 1654432813 Saldo 1217,00 €
 * 
 */

public class Ejercicio22 {
	public static void main(String[] args) throws ApunteException {
		System.out.println("empieza");
		CuentaCorriente cuenta1 = new CuentaCorriente();
		CuentaCorriente cuenta2 = new CuentaCorriente(1500);
		CuentaCorriente cuenta3 = new CuentaCorriente(6000);
		try {

			cuenta1.ingreso(2000);
			cuenta1.cargo(600);
			cuenta3.ingreso(75);
			cuenta1.cargo(55);
			cuenta2.transferencia(cuenta1, 100);
			cuenta1.transferencia(cuenta3, 250);
			cuenta3.transferencia(cuenta1, 22);
			cuenta1.movimientos();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
