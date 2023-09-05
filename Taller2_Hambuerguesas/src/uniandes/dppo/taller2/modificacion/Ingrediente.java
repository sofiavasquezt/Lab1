package uniandes.dppo.taller2.modificacion;
/** La clase Ingrediente representa a un ingrediente que se puede agregar o eliminar de algún elemento en
un pedido.
*/

public class Ingrediente 

{
	// ************************************************************************
		// Atributos
		// ************************************************************************

	/**
	 * El nombre del ingrediente
	 */
	private String nombre;
	
	/**
	 * El costo adicional del ingrediente
	 */
	private int costoAdicional;
	
	// ************************************************************************
		// Constructores
		// ************************************************************************
		/**
		 * Construye un nuevo Combo e incializa los atributos a partir de los
		 * parámetros.
		 * 
		 * @param nombre 	 El nombre del ingrediente
		 * @param costoAdicional  El costo adicional del ingrediente
		 */
		public Ingrediente(String nombre, int costoAdicional)
		{
			this.nombre = nombre;
			this.costoAdicional = costoAdicional;
		}
		
		public String getNombre()
		{
			return nombre;
		}
		
		public int getCostoAdicional() 
		{
			return costoAdicional;
		}
}
