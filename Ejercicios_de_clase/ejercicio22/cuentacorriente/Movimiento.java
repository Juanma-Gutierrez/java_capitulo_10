package cuentacorriente;
import java.util.Date;
public class Movimiento {
    protected Date fecha;
    protected float importe;
    protected String cuenta;
    protected float saldo;

    protected Movimiento(float importe, String cuenta, float saldo){
        this.importe = importe;
        this.cuenta = cuenta;
        this.saldo = saldo;
        this.fecha = new Date();
    }

    public Date getFecha(){
        return this.fecha;
    }

    public float getImporte(){
        return this.importe;
    }

    public String getCuenta(){
        return this.cuenta;
    }

    public float getSaldo(){
        return this.saldo;
    }
}
