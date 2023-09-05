package uniandes.dppo.taller2.modelo;



/**
 * La interfaz Producto abstrae el comportamiento de todos los elementos que pueden hacer parte de un
pedido.
 */

public interface Producto 
{
	public double getPrecio();
	public String getNombre();
	public String generarTextoFactura();
	
}
