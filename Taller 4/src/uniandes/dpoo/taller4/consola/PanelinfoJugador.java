package uniandes.dpoo.taller4.consola;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelinfoJugador extends JPanel implements ActionListener{
	JButton boton;
	JTextField jugador;
	int jugadas =0;
	static JPanel base;
	PanelTablero Tablero;
	private Interfase principal;
	
	public PanelinfoJugador(Interfase interfaz) {
		base = new JPanel();
		base.setLayout(new FlowLayout());
		base.setBackground(Color.LIGHT_GRAY);
		base.setVisible(true);
		
		JLabel nombreJugadas = new JLabel("Jugadas:");
		base.add(nombreJugadas);
		JLabel numeroJugadas = new JLabel();
		numeroJugadas.setText(Integer.toString(PanelTablero.jugadas()));
		numeroJugadas.setVisible(true);
		base.add(numeroJugadas);
		
		boton = new JButton("Jugador:");
		boton.addActionListener(this);
		boton.setVisible(true);
		base.add(boton);
		jugador = new JTextField();
		jugador.setPreferredSize(new Dimension (150,20));
		boton.setPreferredSize(new Dimension (200,20));
		base.add(jugador);
		this.add(base);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton)
		{
			jugador.setEditable(false);
			boton.setEnabled(false);
		}
		
	}

}
