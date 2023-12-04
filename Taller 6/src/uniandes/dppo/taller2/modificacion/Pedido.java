package uniandes.dppo.taller2.modificacion;

import java.util.ArrayList;

/** La clase Pedido representa a un pedido de un cliente.
*/
public class Pedido 
{
	// ************************************************************************
			// Atributos
			// ************************************************************************

		/**
		 * El numero del pedido
		 */
		private int numeroPedidos;

		/**
		 * El numero id del pedido
		 */
		public static int idPedido;

		/**
		 * El nombre del cliente
		 */
		private String nombreCliente;

		/**
		 * La direccion del cliente
		 */
		private String direccionCliente;
		
		
		
		/**
		 * Lista de los productos del pedido.
		 */
		private ArrayList<String> listaProductos = new ArrayList<String>();
		
		
		/**
		 * El precio final
		 */
		public double precioFinal;
		
		
		// ************************************************************************
				// Constructores
				// ************************************************************************
		/**
		 * Construye un nuevo pedido e incializa los atributos a partir de los
		 * parámetros.
		 * 
		 * @param nombreCliente    El nombre del cliente
		 * @param direccionCliente La direccion del cliente
		 */
		public Pedido(String nombreCliente, String direccionCliente)
		{

			this.nombreCliente = nombreCliente;
			this.direccionCliente = direccionCliente;
			ArrayList<String> nombre = new ArrayList<String>();
			ArrayList<String> direccion = new ArrayList<String>();
			nombre.add(nombreCliente);
			direccion.add(direccionCliente);
		}
		
		// ************************************************************************
				// Otros métodos
				// ************************************************************************

				public int getIdPedido() 
				{
					return idPedido;
				}
				
				/**
				 * Registra los items del pedido en el producto.
				 * 
				 * @param nuevoitemsPedido Los nuevos items que se van a registrar.
				 */
				public void agregarProducto(Producto nuevoProducto)
				{
					listaProductos.add(nuevoProducto.getNombre());
					double precioProductoNuevo = nuevoProducto.getPrecio();
					this.precioFinal += precioProductoNuevo;
				}
				
				public String getNombre() 
				{
					return nombreCliente;
				}

				public String getDireccion() 
				{
					return direccionCliente;
				}
				
				public int getNumeroPedidos() 
				{
					return numeroPedidos;
				}
				private double getPrecioNetoPedido() 
				{
					return precioFinal;
				}
				
				private double getPrecioTotalPedido() 
				{
					
					double precioFinal = (getPrecioNetoPedido() * 0.19) + getPrecioNetoPedido();
					return precioFinal;
				}

				private double getPrecioIVAPedido() 
				{
					
					
					double precioIva = getPrecioNetoPedido() * 0.19;
					return precioIva;
				}
		
				private String generarTextoFactura() 
				
				{
					double precioneto = getPrecioNetoPedido();
					double preciofinal = getPrecioTotalPedido();
					double precioiva = getPrecioIVAPedido();
					String textoFactura = "Valor neto: $" + precioneto + "   "
							+ "Valor final: $" + preciofinal + "    "
									+ " Precio del IVA: $" + precioiva;
					
					return textoFactura;
				}

				public String guardarFactura() 
				{
					String textoFactura = generarTextoFactura();
					return textoFactura; 
				}
}
