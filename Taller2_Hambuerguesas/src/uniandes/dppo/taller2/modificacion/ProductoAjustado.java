package uniandes.dppo.taller2.modificacion;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase ProductoAjustado representa un producto que se ajustó cuando se agregó a un pedido: un
ProductoAjustado tiene un producto base y una serie de ingredientes que se agregan o se eliminan a
este producto.
 */
public class ProductoAjustado implements Producto
{
	/**
	 * Lista de los ingredientes agredados.
	 */
	public ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();;
	
	/**
	 * Lista de los ingredientes eliminados.
	 */
	public ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();;
	
	/**
	 * base el producto ajustado
	 */
	private ProductoMenu base;
	
	private double precio;
	
	public static String nombre;
	
	// ************************************************************************
	// Constructores
	// ************************************************************************
	/**
	 * Construye un nuevo Producto Ajustado e incializa los atributos a partir de los
	 * parámetros.
	 * 
	 * @param base 	 La base del producto ajustado
	 */
	public ProductoAjustado(ProductoMenu base)
	{
		this.agregados = new ArrayList<Ingrediente>();
		this.eliminados = new ArrayList<Ingrediente>();
		this.base = base;
		precio = base.getPrecio();
		nombre = base.getNombre();
	}
	
	// ************************************************************************
			// Otros métodos
			// ************************************************************************

			/**
			 * Registra los productso que van a ser agregados a los ingredientes.
			 * 
			 * @param nuevoagredados Los nuevos productos agregados.
			 */
			public void agregarIngrediente(Ingrediente nuevoagredados)
			{
				agregados.add(nuevoagredados);
			}
			
			/**
			 * Registra los productso que van a ser eliminados a los ingredientes.
			 * 
			 * @param nuevoeliminados Los nuevos productos eliminados.
			 */
			public void eliminarIngrediente(Ingrediente nuevoeliminados)
			{
				eliminados.add(nuevoeliminados);
			}
			

			public double getPrecio() 
			{
				for (int i = 0; i < agregados.size(); i++) 
				{
					precio += agregados.get(i).getCostoAdicional();
				}
				return precio;
			}
			
			public String getNombre() 
			{
				return nombre;
				
			}
			
			public String generarTextoFactura() 
			{
				return " ";
			}
}
