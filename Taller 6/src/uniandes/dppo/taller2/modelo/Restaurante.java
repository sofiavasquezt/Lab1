package uniandes.dppo.taller2.modelo;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * La clase Restaurante es el corazón de la lógica de la aplicación y sirve principalmente para agrupar el
resto de las cosas que maneja la aplicación
 */
public class Restaurante 
{
	/**
	 * Lista de los ingredientes.
	 */
	ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	
	/**
	 * Lista de los combos.
	 */
	ArrayList<Combo> combos = new ArrayList<Combo>();
	
	/**
	 * Lista de los pedidos.
	 */
	private List<Pedido> pedidos;
	
	/**
	 * Los pedido en curso.
	 */
	private Pedido pedidoEnCurso;
	
	/**
	 * Lista con el menu base.
	 */
	ArrayList<ProductoMenu> productosMenu = new ArrayList<ProductoMenu>();
	
	// ************************************************************************
				// Otros métodos
				// ************************************************************************


	public Pedido iniciarPedido(String nombreCliente, String direccionCliente) 
	{
		return this.pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
	}
	
	public String cerrarYGuardarPedido() 
	{
		return pedidoEnCurso.guardarFactura();
	}
	
	public ArrayList<ProductoMenu> getMenuBase() 
	{
		return productosMenu;
	}

	public ArrayList<Ingrediente> getIngredientes() 
	{
		return ingredientes;
	}
	
	public ArrayList<Combo> getCombos() 
	{
		return combos;
	}
	
	
	public void cargarInformacionRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos)	throws IOException 
	{

		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}
	
	/**
	 * Construye un nuevo Restaurate e incializa los atributos a partir de los
	 * parámetros.
	 * 
	 * @param elPedidoenCurso 	 EL pedido en curso
	 */

	
	public Restaurante(Pedido PedidoenCurso)
	{
		this.pedidoEnCurso = PedidoenCurso;
				
	}
	
			/**
			 * Registra los ingredientes.
			 * 
			 * @param nuevosingredientes Los nuevos ingredientes que se van a registrar.
			 */
			public void agregarIngredientes(Ingrediente nuevosingredientes)
			{
				ingredientes.add(nuevosingredientes);
			}
			
			/**
			 * Registra el menu base.
			 * 
			 * @param nuevoMenuBase El menu base que se van a registrar.
			 */
			public void agregarProductoMenu(ProductoMenu nuevoMenuBase)
			{
				productosMenu.add(nuevoMenuBase);
			}
			
			/**
			 * Registra el pedido.
			 * 
			 * @param nuevopedido El nuevo pedido que se van a registrar.
			 */
			public void agregarPedido(Pedido nuevopedido)
			{
				pedidos.add(nuevopedido);
			}
			
			/**
			 * Registra los combos.
			 * 
			 * @param nuevoscombos El combo que se van a registrar.
			 */
			public void agregarCombo(Combo nuevoscombos)
			{
				combos.add(nuevoscombos);
			}
			
			
			private void cargarIngredientes(String archivoIngredientes) throws IOException 
			{

				File file = new File(archivoIngredientes);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;

				while ((line = br.readLine()) != null) 
				{
					String[] partes = line.split(";");
					String nombreIngrediente = partes[0];
					int costoAdicional = Integer.parseInt(partes[1]);
					Ingrediente nuevoIngrediente = new Ingrediente(nombreIngrediente, costoAdicional);
					ingredientes.add(nuevoIngrediente);
				}
			
			}
			
			private void cargarMenu(String archivoMenu) throws IOException 
			{

				File file = new File(archivoMenu);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;

				while ((line = br.readLine()) != null) 
				{
					String[] partes = line.split(";");
					String nombreProducto = partes[0];
					int precioBase = Integer.parseInt(partes[1]);
					ProductoMenu nuevoProductoMenu = new ProductoMenu(nombreProducto, precioBase);
					productosMenu.add(nuevoProductoMenu);
				}
			
			}

			private void cargarCombos(String archivoCombos) throws IOException 
			{

				File file = new File(archivoCombos);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line;

				while ((line = br.readLine()) != null) 
				{
					String[] partes = line.split(";");
					String nombreCombo = partes[0]+" ("+partes[2]+", "+partes[3]+", "+partes[4]+")";
					
					String descuentoStr = partes[1];
					descuentoStr = descuentoStr.replace("%", "");
					double descuento = Double.parseDouble(descuentoStr) / 100;
					String productoMenu1 = partes[2];
					String productoMenu2 = partes[3];
					String productoMenu3 = partes[4];
					
					double precio = 0;

					for (int i = 0; i < productosMenu.size(); i++) 
					{
						ProductoMenu valor = productosMenu.get(i);
						
						if (valor.getNombre().equals(productoMenu1)) 
						{
							precio += valor.getPrecio();
						} else if (valor.getNombre().equals(productoMenu2)) 
						{
							precio += valor.getPrecio();
						} else if (valor.getNombre().equals(productoMenu3)) 
						{
							precio += valor.getPrecio();
						}
					}

					descuento = descuento * precio;
					descuento = precio - descuento;
					Combo combo_descuento = new Combo(descuento, nombreCombo);
					combos.add(combo_descuento);
				}
			}
			
	}

