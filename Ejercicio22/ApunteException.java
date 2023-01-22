
 

public class ApunteException extends Exception {

	public int code;
	public String msg;

	ApunteException() {
		this.code = 100;
		this.msg = "No es posible realizar un apunte con un importe negativo";
	}

	@Override
	public String toString() {
		return "Message: " + this.msg + " Code:" + this.code;
	}
}
