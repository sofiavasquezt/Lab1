package uniandes.dppo.taller2.modificacion;

import java.util.ArrayList;
import java.util.List;

/** La clase Combo agrupa un conjunto de productos que tienen un descuento al comprarse en combo.
 * 
 */
public class Combo implements Producto
{
	// ************************************************************************
		// Atributos
		// ************************************************************************

	/**
	 * El descuento del pedido
	 */
	private double descuento;
	
	/**
	 * El nombre del combo
	 */
	private String nombreCombo;
	
	/**
	 * Lista de los items del combo.
	 */
	private ArrayList<String> itemsCombo = new ArrayList<String>();
	
	// ************************************************************************
	// Constructores
	// ************************************************************************
	/**
	 * Construye un nuevo Combo e incializa los atributos a partir de los
	 * parámetros.
	 * 
	 * @param descuento 	 El descuento
	 * @param nombreCombo  El nombre del combo
	 */
	public Combo(double descuento, String nombreCombo)
	{
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
	}
	
	// ************************************************************************
		// Otros métodos
		// ************************************************************************
	

		public String getNombre() 
		{
			return nombreCombo;
		}
		
		public String generarTextoFactura() 
		{
			return nombreCombo;
		}
		
		public double getPrecio() 
		{
			return descuento;
		}
		

		public void setDescuento(double descuento) 
		{
			this.descuento = descuento;
		}
}
