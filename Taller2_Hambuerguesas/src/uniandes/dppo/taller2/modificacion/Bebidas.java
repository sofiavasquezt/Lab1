package uniandes.dppo.taller2.modificacion;


public class Bebidas implements Producto
{
	// ************************************************************************
				// Atributos
				// ************************************************************************

			/**
			 * El nombre del producto del menu
			 */
		private String nombre;
		
		/**
		 * El precio base
		 */
		private int precioBase;
		
		// ************************************************************************
			// Constructores
			// ************************************************************************
			/**
			 * Construye un nuevo producto para el menu e incializa los atributos a partir de los
			 * parámetros.
			 * 
			 * @param nombre 	 El nombre del nuevo producto
			 * @param precioBase  El precio base del nuevo producto
			 */
		public Bebidas(String nombre, int precioBase)
		{
			this.nombre = nombre;
			this.precioBase = precioBase;
			
		}
		
		public String getNombre() 
		{
			return nombre;
		}
		
		public double getPrecio() 
		{
			return precioBase;
		}
		
		public String generarTextoFactura() 
		{
			return "";
		}
	}