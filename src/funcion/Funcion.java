package funcion;

import java.util.ArrayList;

public class Funcion {
	private ArrayList<Punto> puntos;
	private String nombre;

	public ArrayList<Punto> getPuntos() {
		return puntos;
	}

	public void setPuntos(ArrayList<Punto> puntos) {
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Funcion(ArrayList<Punto> puntos) {
		this.puntos = puntos;
	}

	public Funcion() {

	}
}
