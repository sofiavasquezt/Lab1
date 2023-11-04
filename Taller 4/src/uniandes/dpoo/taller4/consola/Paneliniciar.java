package uniandes.dpoo.taller4.consola;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class Paneliniciar extends JPanel implements ActionListener
	{

	private static final String NUEVO="NUEVO";
	private static final String REINICIAR="REINICIAR";
	private static final String TOP10 ="TOP-10";
	private static final String JUGADOR="JUGADOR";
	
	public Paneliniciar(Interfase interfaz) {
		JPanel base = new JPanel();
		base.setBackground(Color.CYAN);
		base.setPreferredSize(new Dimension (300,300));
		base.setLayout(new GridLayout(4,1));
		base.setVisible(true);
		
		
		JButton nuevo = new JButton("NUEVO");
		nuevo.addActionListener(this);
		nuevo.setActionCommand(NUEVO);
		nuevo.setVisible(true);
		base.add(nuevo);
		
		JButton Reiniciar = new JButton("REINICIAR");
		Reiniciar.addActionListener(this);
		Reiniciar.setActionCommand(REINICIAR);
		Reiniciar.setVisible(true);
		base.add(Reiniciar);
		
		JButton Top = new JButton("TOP-10");
		Top.addActionListener(this);
		Top.setActionCommand(TOP10);
		Top.setVisible(true);
		base.add(Top);
		
		JButton Cambiar = new JButton("CAMBIAR JUGADOR");
		Cambiar.addActionListener(this);
		Cambiar.setActionCommand(JUGADOR);
		Cambiar.setVisible(true);
		base.add(Cambiar);
		
		this.add(base);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String opcion = e.getActionCommand();
		if(opcion.equals(NUEVO))
		{
			
			Interfase.nuevoTablero();
		}
		if(opcion.equals(REINICIAR))
		{
			Interfase.reiniciarTablero();

		}
		if(opcion.equals(TOP10))
		{
			PanelTablero.mostrarTop();
		} 
		if(opcion.equals(JUGADOR))
		{
			PanelTablero.cambiarJugador();
		}
		
	}
}

