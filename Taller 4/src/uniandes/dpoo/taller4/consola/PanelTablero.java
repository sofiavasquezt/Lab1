package uniandes.dpoo.taller4.consola;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelTablero extends JPanel implements MouseListener{
	private boolean[][] tablero; 
	private static int filas;
	private static int columnas;
    private Interfase interfase; 
    private static Tablero tab;
	private int ultima_fila;
	private int ultima_columna;
		
		
	public PanelTablero(Interfase interfaz)
{
		interfase = interfaz;
		//tablero = tab.darTablero();
		//filas = tablero[0].length;
    	//columnas = tablero.length;
        setPreferredSize(new Dimension(100, 100)); 
        addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		int click_y = e.getY() ;
	    int click_x = e.getX();
		int ancho = getWidth();
        int alto = getHeight();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        int[][] cantidades = null;
		cantidades[casilla[0]][casilla[1]]++;
		tab.jugar(casilla[0], casilla[1]);
        this.ultima_fila = casilla[0];
        this.ultima_columna = casilla[1];
        repaint();
	}
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
		int ladoTablero = tablero.length;
		int altoPanelTablero = getHeight();
		int anchoPanelTablero = getWidth();
		int altoCasilla = altoPanelTablero / ladoTablero;
		int anchoCasilla = anchoPanelTablero / ladoTablero;
		int fila = (int) (y / altoCasilla);
		int columna = (int) (x / anchoCasilla);
		return new int[] { fila, columna };
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static int jugadas() {
		//int jug =tab.darJugadas();
		return 0;
		
	}
	
	public static void mostrarTop() {
		// TODO Auto-generated method stub
		
	}
	public static void cambiarJugador() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void paintComponent(Graphics grid)
	{
		super.paintComponent(grid);
		Graphics2D  g2d = (Graphics2D) grid;
		int tamanioRec = Math.min(getWidth() / columnas, getHeight() / filas);
		
		for (int fil = 0; fil < filas; fil++) 
        {
            for (int col = 0; col < columnas; col++) 
            {
                int lado1 = col * tamanioRec;
                int lado2 = fil * tamanioRec;
                
                Rectangle rectangulo = new Rectangle(lado1, lado2, tamanioRec, tamanioRec);
                
                if (tablero[fil][col])
                {
                    g2d.setColor(Color.YELLOW); 
                    g2d.fill(rectangulo);

                    g2d.setColor(Color.BLACK); 
                    g2d.draw(rectangulo);
                }
                else
                {
                    g2d.setColor(Color.BLACK); 
                    g2d.fill(rectangulo);

                    g2d.setColor(Color.YELLOW);
                    g2d.draw(rectangulo);
                }               	
            }
        }
		
  
	}

}
