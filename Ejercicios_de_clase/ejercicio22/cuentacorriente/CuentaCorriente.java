package cuentacorriente;

import java.util.ArrayList;
import java.util.HashMap;

public class CuentaCorriente {
    private String cuenta;
    private float saldo;
    ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();

    private static HashMap<String, Long> cuentas = new HashMap<String, Long>();

    private static String generarCuenta(){
        String _cuenta="";
        do {
            int valor = 0; 
            _cuenta = ""; 
            do {
                valor = (int)(Math.random()*9);
            } while (valor==0);
            _cuenta+=valor;
            for(int i = 0; i < 9; i++){
                _cuenta += (int)(Math.random()*9);
            }    
        } while (cuentas.containsKey(_cuenta));
        
        return _cuenta;
    }

    public CuentaCorriente(){
        this.cuenta = generarCuenta();
        cuentas.put(cuenta, Long.parseLong(cuenta));
        this.saldo = 0;
    }

    public CuentaCorriente(float saldo){
        this();
        this.saldo = saldo;
    }

    public void ingreso(float importe){
        this.saldo+=importe;
        this.movimientos.add(new Ingreso(importe, this.cuenta, this.saldo));
    }

    public void cargo(float importe){
        this.saldo-=importe;
        this.movimientos.add(new Ingreso(importe, this.cuenta, this.saldo));
    }

    public void transferencia(CuentaCorriente cuenta, float importe ) throws NotEnoughBalance {
        if(importe > this.saldo)
            throw new NotEnoughBalance();
        else{
            this.saldo-=importe;
            cuenta.saldo+=importe;
            this.movimientos.add(new TransferenciaEmitida(importe, this.cuenta, this.saldo, cuenta.cuenta));
            cuenta.movimientos.add(new TransferenciaRecibida(importe, this.cuenta, this.saldo));

        }
    }

    @Override
    public String toString(){
        return String.format("Cuenta: %s Saldo: %.2f", this.cuenta, this.saldo);
    }

    public void imprimirMovimientos(){
        System.out.printf("Movimientos de la cuenta %s\n", this.cuenta);
        for(Movimiento m:movimientos){
            System.out.println(m.toString());
        }
    }
}
