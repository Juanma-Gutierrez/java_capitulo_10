package cuentacorriente;

public class TransferenciaRecibida extends Transferencia {
    public TransferenciaRecibida(float importe, String cuenta, float saldo){
        super(importe, cuenta, saldo);
    }

    @Override
    public String toString(){
        return String.format("Transf. recibida de %.2f € de la cuenta %s Saldo %.2f €", this.importe, this.cuenta, this.saldo);
    }

}
