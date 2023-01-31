package cuentacorriente;

public class Cargo extends Movimiento{
    public Cargo(float importe, String cuenta, float saldo){
        super(importe, cuenta, saldo);
    }

    @Override
    public String toString(){
        return String.format("Cargo de %.2f € Saldo: %.2f €", this.importe, this.saldo);
    }
    
}