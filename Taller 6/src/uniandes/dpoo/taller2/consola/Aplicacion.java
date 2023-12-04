package uniandes.dpoo.taller2.consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStreamReader;

import uniandes.dppo.taller2.modelo.Combo;
import uniandes.dppo.taller2.modelo.HamburguesaException;
import uniandes.dppo.taller2.modelo.Ingrediente;
import uniandes.dppo.taller2.modelo.IngredienteRepetidoException;
import uniandes.dppo.taller2.modelo.Pedido;
import uniandes.dppo.taller2.modelo.ProductoAjustado;
import uniandes.dppo.taller2.modelo.ProductoMenu;
import uniandes.dppo.taller2.modelo.ProductoRepetidoException;
import uniandes.dppo.taller2.modelo.Restaurante;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Aplicacion 
{
	public void mostrarMenu() 
	{
		System.out.println("Menú: ");
		System.out.println("1. Inicializar un nuevo pedido ");
		System.out.println("2. Agregar un elemento al pedido");
		System.out.println("3. Cerrar el pedido y mostrar la factura correspondiente");
		System.out.println("4. Consultar el pedido con el Id ");
		System.out.println("5. Salir del programa");	
	}
	
	public static ArrayList<String> listaPedidos = new ArrayList<String>();
	private Pedido pedido;
	private Restaurante restaurante = new Restaurante(pedido);

	
	public static void main(String[] args) throws IOException, HamburguesaException 
	{
		
		Aplicacion consola = new Aplicacion();
		System.out.println("\n Bienvenido a el restaurante de las hamburguesas, para iniciar un nuevo pedido ingresa 1 ");
		consola.cargarArchivos();
		consola.ejecutarOpcion();
		
	}
	
	public void cargarArchivos() throws IOException, HamburguesaException,IngredienteRepetidoException,ProductoRepetidoException  {
	    try {
	        restaurante.cargarInformacionRestaurante(
	                "./data/ingredientes.txt",
	                "./data/menu.txt",
	                "./data/combos.txt"
	        );
	    } catch (IngredienteRepetidoException e) {
	        System.out.println("Error al cargar archivos: " + e.getMessage());
	    } catch (ProductoRepetidoException e) {
	        System.out.println("Error al cargar archivos: " + e.getMessage());
	    }
	}

	public void ejecutarOpcion() throws NumberFormatException, IOException, HamburguesaException
	{
		boolean inicio = false;
		boolean agregado = false;
		boolean fin = false;
		boolean seguir = true;
		int pedidoAbierto = 0;
		while (seguir) 
		{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("\nSeleciona una opcion"));
				if (opcion_seleccionada == 1) 
				{
					if (pedidoAbierto == 1) 
					{
						System.out.print("\n No puedes iniciar con  tu pedido si tienes otro en curso");
					}
					else 
					{
						inicio = true;
						pedidoAbierto = 1;
						iniciar_pedido();
					}
				}
				else if (opcion_seleccionada == 2) 
				{
					if (inicio)
					{
						agregar_elemento();
						agregado = true;
					}
					else
						System.out.print("\n Debes iniciar un pedido antes de volver el menu.");
				}
				else if (opcion_seleccionada == 3) 
				{
					if (inicio)
					{
						if (agregado) 
						{	
							finalizar_pedido();
							fin = true;
							inicio = false;
							agregado = false;
						}
						else
							System.out.print("\n Debes ver el menu y ordenar algun producto antes de finalizar tu pedido.");
					}
					else
						System.out.print("\n No puedes finalizar tu pedido antes de iniciarlo.");
				}				
				else if (opcion_seleccionada == 4)
					
					if (fin)
					{
							consultar_pedido();
					}
					else
					{
							System.out.print("\n Debes finalizar tu pedido antes de poder consultarlo.");
					}
				else if (opcion_seleccionada == 5) 
				{
					System.out.println("\nSalir de la aplicacion...");
					seguir = false;
				} 
				else {
					System.out.println("\n El numero que seleccionaste no esta en  las opciones");
			
			}
		}
		throw new HamburguesaException("NO");
	}
	
	private void iniciar_pedido() throws IOException 
	{
		String nombreCliente = input("\nIngresa tu nombre");
		listaPedidos.add(nombreCliente);
		String direccionCliente = input("Ingresa la direccion a la que se enviara el pedido");
		listaPedidos.add(direccionCliente);
		Pedido.idPedido += 1;
		
		this.pedido = restaurante.iniciarPedido(nombreCliente, direccionCliente);
		System.out.println("\n" + nombreCliente + ", el ID de tu pedido es: " + Pedido.idPedido + ".");
	}
	private void agregar_elemento() throws NumberFormatException, IOException 
	{
		boolean seguir = true;
		while (seguir) 
		{
			int menu = Integer.parseInt(input("Ingresa 1 si deseas ver los Productos y 2 si deseas ver los Combos"));
			if (menu == 1) 
			{
				seguir = false;
				System.out.println("\n LOS PRODUCTOS: \n");
				ArrayList<ProductoMenu> productosMenu = restaurante.getMenuBase();
				for (int i = 0; i < productosMenu.size(); i++) 
				{
					ProductoMenu valorP = productosMenu.get(i);
					System.out.println((i+1) + ". " + valorP.getNombre() + " por un valor de $" + valorP.getPrecio());
				}
				
				int numProducto = Integer.parseInt(input("\nIngresa el numero del producto que deseas agregar"));
				ProductoMenu valorProducto = productosMenu.get(numProducto-1);
				pedido.agregarProducto(valorProducto);
				int modificar = Integer.parseInt(input("\nPara agregar o quitar algun ingrediente ingresa 1. Si no quieres hacer nada ingresa 0"));
				if (modificar == 1)
				{
					ProductoAjustado valorProductoAjustado = new ProductoAjustado(valorProducto);
					System.out.println("\n LOS INGREDIENTES:  \n");
					ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
					for (int i = 0; i < ingredientes.size(); i++) 
					{
						Ingrediente valor = ingredientes.get(i);
						System.out.println((i+1) + ". " + valor.getNombre() + " por un valor de $" + valor.getCostoAdicional());
					}
				
					int numIngrediente = Integer.parseInt(input("\nIngresa el numero del ingrediente que deseas agregar o quitar"));
					if (numIngrediente > ingredientes.size())
					{
						System.out.println("\nPor favor ingresa una numero valido \n");
					}
					else 
					{
						Ingrediente valor = ingredientes.get(numIngrediente-1);
						int realizarIngrediente = Integer.parseInt(input("\nIngresa 1 si deseas agregar el ingrediente o 0 si deseas quitarlo"));
						if (realizarIngrediente == 1) 
						{
							ProductoAjustado.nombre += " con " + valor.getNombre();
							valorProductoAjustado.agregados.add(valor);
						}
						else if (realizarIngrediente == 0) 
						{
							ProductoAjustado.nombre += " sin " + valor.getNombre();
						
						}
						else
							System.out.println("\nPor favor ingresa una opcion valida.\n");
					}
					
					int mas = Integer.parseInt(input("Para seguir modificando los ingredientes del producto " + valorProducto.getNombre() + " ingresa 1. De lo contrario ingresa 0"));
					if (mas == 1)
					{
						seguir = false;
					}
					else if (mas == 0) 
					{
						pedido.agregarProducto(valorProductoAjustado);
						String modificacion = "";
						System.out.println("\nEl producto " + valorProductoAjustado.getNombre() + modificacion + " se agrego correctamente a tu pedido.");
						System.out.println("\nTotal: $" + pedido.precioFinal);
						System.out.println("Para seguir agregando elementos selecciona la opcion 2.");
						seguir = false;
					}
		
				else if (modificar == 0) 
					{
						seguir = false;
						pedido.agregarProducto(valorProducto);
						System.out.println("\nEl producto " + valorProducto.getNombre() + " se agrego a tu pedido.");
						System.out.println("\nEl total de tu compra es de: $" + pedido.precioFinal);
					}
				}
			}
			else if (menu == 2)
			{
				seguir = false;
				System.out.println("\n LOS COMBOS: \n");
				ArrayList<Combo> combos = restaurante.getCombos();
				for (int i = 0; i < combos.size(); i++) 
				{
					Combo valorCombos = combos.get(i);
					System.out.println((i+1) + ". " + valorCombos.getNombre() + " $" + valorCombos.getPrecio());
				}
					int numCombo = Integer.parseInt(input("\nIngresa el numero del combo que deseas agregar"));
					if (numCombo > combos.size())
						System.out.println("\nPor favor ingresa una opcion valida.\n");
					else 
					{
						Combo valorCombos = combos.get(numCombo-1);
						pedido.agregarProducto(valorCombos);
						System.out.println("\nEl " + valorCombos.getNombre() + " se agrego  a tu pedido.");
						System.out.println("\nTotal: $" + pedido.precioFinal);
					}
				}
				
			else
			{
				System.out.println("\nPor favor ingresa una opcion valida.\n");
			}
		}
	}

	private void finalizar_pedido() throws FileNotFoundException, UnsupportedEncodingException {
		System.out.println("Su pedido se ha cerrado ");
		System.out.println("Su factura es: ");
		System.out.println(restaurante.cerrarYGuardarPedido());
		int id = pedido.getIdPedido();
		PrintWriter writer = new PrintWriter(String.valueOf(id)+ ".txt","UTF-8");
		writer.close();
	}
	
	private void consultar_pedido() throws NumberFormatException, IOException 
	{
		int id = Integer.parseInt(input("Ingrese el ID de su pedido"));
		if (id == 1) 
		{
			System.out.println("EL pedido es: ");
			System.out.println("Nombre: " + listaPedidos.get(0));
			System.out.println("Dirección: " + listaPedidos.get(1));
			System.out.println("Factura: " + restaurante.cerrarYGuardarPedido());
		}
		else {
			System.out.println("\nPor favor ingresa una opcion valida.\n");
		 	}
	}
	
	
	public String input(String textoFactura) throws IOException
	{
			System.out.print(textoFactura + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
	}
}

