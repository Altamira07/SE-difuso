package gui;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import funcion.Funcion;
import funcion.Membresia;
import funcion.Punto;
import gui.graficar.Graficar;

public class Principal extends JFrame 
{
	Funcion estTrabajo,resultados;
	
	public Principal()
	{
		super("Graficos IA");
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		estTrabajo = estTrabajo();
		resultados = resultados();
		JPanel funciones = new JPanel();
		funciones.setLayout(new BoxLayout(funciones, BoxLayout.X_AXIS));
		funciones.add(new Graficar(estTrabajo));
		funciones.add(new Graficar(resultados));
		setSize(720,520);
		setResizable(false);
		add(funciones);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	private Funcion estTrabajo()
	{
		ArrayList<Punto> puntos = new ArrayList<Punto>();
		puntos.add(new Punto(80,0));
		puntos.add(new Punto(90,1));
		puntos.add(new Punto(100,0));
		Funcion funcion = new Funcion(puntos);
		funcion.setNombre("Estrategias de trabajo");
		return funcion;
	}
	
	private Funcion resultados()
	{
		ArrayList<Punto> puntos = new ArrayList<Punto>();
		puntos.add(new Punto(80,0));
		puntos.add(new Punto(85,1));
		puntos.add(new Punto(100,1));
		Funcion funcion = new Funcion(puntos);
		funcion.setNombre("Resultados");
		return funcion;
	}
}
