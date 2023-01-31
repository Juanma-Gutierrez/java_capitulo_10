import cuentacorriente.CuentaCorriente;
import cuentacorriente.NotEnoughBalance;

public class Ejercicio22 {
    public static void main(String[] args){
        CuentaCorriente cuenta1 = new CuentaCorriente();
        CuentaCorriente cuenta2 = new CuentaCorriente(1500);
        CuentaCorriente cuenta3 = new CuentaCorriente(6000);
        cuenta1.ingreso(2000);
        cuenta1.cargo(600);
        cuenta3.ingreso(75);
        cuenta1.cargo(55);
        try {
            cuenta2.transferencia(cuenta1, 100);
            cuenta1.transferencia(cuenta3, 250);
            cuenta3.transferencia(cuenta1, 22);    
        } catch (NotEnoughBalance e) {
            System.out.println("No hay suficiente saldo");
        }
        
        cuenta1.imprimirMovimientos();
    }
}
