package cuentacorriente;

public class Ingreso extends Movimiento{
    public Ingreso(float importe, String cuenta, float saldo){
        super(importe, cuenta, saldo);
    }

    @Override
    public String toString(){
        return String.format("Ingreso de %.2f € Saldo: %.2f €", this.importe, this.saldo);
    }
    
}
