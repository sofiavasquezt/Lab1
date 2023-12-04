package uniandes.dppo.taller2.modelo;

public class PedidoExcedeMontoException extends Exception{
	public PedidoExcedeMontoException() {
        super("Error: El pedido excede el monto máximo permitido de $150,000.");
    }
}
