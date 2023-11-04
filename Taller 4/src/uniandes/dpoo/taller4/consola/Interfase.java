package uniandes.dpoo.taller4.consola;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

import uniandes.dpoo.taller4.modelo.Tablero;

public class Interfase extends JFrame{
	private PanelDificultadTamanio DifTam;
	private static PanelTablero Grid; 
	private Paneliniciar Inicio;
	private PanelinfoJugador Info;
	
	public static Tablero tab;
	static int tamano = PanelDificultadTamanio.darTamano();
	static String dif;
	
	

	public static void main (String[ ] args) {
		Interfase interfaz = new Interfase();
		interfaz.setLocationRelativeTo( null );
	    interfaz.getContentPane().setBackground(new Color (244,238,226));
	    interfaz.setVisible( true );
	    
	}
	public Interfase() {
		setSize(1400, 500);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setTitle( "Lights Out" );
        setLayout( new BorderLayout( ) );
        
        DifTam = new PanelDificultadTamanio(this);
        add(DifTam, BorderLayout.NORTH);
        
        Inicio = new Paneliniciar(this);
        add(Inicio,BorderLayout.EAST);
        
        Info = new PanelinfoJugador(this);
        add(Info, BorderLayout.SOUTH);
        
       nuevoTablero();
       Grid = new PanelTablero(this);
        //add(Grid,BorderLayout.CENTER);
       
	}
	
	public static void nuevoTablero() 
	{
		int tamano = PanelDificultadTamanio.darTamano();
        tab = new Tablero(tamano);
        dif = "Facil";
        
		if (dif.equals("Facil"))
		{
			tab.desordenar(1);
		}
		else if (dif.equals("Medio"))
		{
			tab.desordenar(3);
		}
		else if (dif.equals("Dificil"))
		{
			tab.desordenar(5);
		}	
	}
	
	public static void reiniciarTablero()
	{

		tab.reiniciar();

	}
}
