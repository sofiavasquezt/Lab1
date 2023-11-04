package uniandes.dpoo.taller4.consola;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelDificultadTamanio extends JPanel implements ActionListener{
	static int tamanio =5;
	static String dificultad;
	JRadioButton Facil;
	JRadioButton Medio;
	JRadioButton Dificil;
	JComboBox opciones;

	public PanelDificultadTamanio(Interfase interfaz) {
		this.setBackground(Color.CYAN);
		String[] Tamanios = {"5X5","9X9"};
		opciones = new JComboBox(Tamanios);
		opciones.addActionListener(this);
		opciones.setVisible(true);
		this.add(opciones);
		ButtonGroup grupo = new ButtonGroup();
		Facil = new JRadioButton("Facil");
		Facil.addActionListener(this);
		grupo.add(Facil);
		this.add(Facil);
		Medio = new JRadioButton("Medio");
		Medio.addActionListener(this);
		grupo.add(Medio);
		this.add(Medio);
		Dificil = new JRadioButton("Dificil");
		Dificil.addActionListener(this);
		grupo.add(Dificil);
		this.add(Dificil);
		
		this.setVisible(true);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==Facil)
		{
			 dificultad = "Facil";
		}
		if (e.getSource()==Medio)
		{
			dificultad ="Medio";
		
		}
		if (e.getSource()==Dificil)
		{
			dificultad ="Dificil";
		}
		if (e.getSource()==opciones)
		{
			tamanio= Integer.parseInt(opciones.getSelectedItem().toString().substring(0,1));
			System.out.println(tamanio);
		}
		
		}
		

	public static int darTamano() {
		return tamanio;
	}

}
