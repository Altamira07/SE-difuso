package funcion;

import java.util.ArrayList;

public class Membresia {
	
	private Funcion funMembresia;
	
	public Membresia()
	{
		funMembresia = null;
	}
	
	public Membresia(Funcion funMembresia)
	{
		this.funMembresia = funMembresia;
	}
	public double calcMembresia(double x) {
		ArrayList<Punto> puntos = funMembresia.getPuntos();
		Punto a,b;
		a = puntos.get(0);
		for(int i = 1; i < puntos.size(); i++)
		{
			b = puntos.get(i);
			if(a.getX()<= x && b.getX() >= x )
			{
				return f(x,a,b);
			}
			a = b;
			b= null;
		}
		return 0;
	}
	
	

	public double calcMembresia (double x, Funcion funMembresia)
	{
		this.funMembresia = funMembresia;
		return calcMembresia(x);
	}
	/*
	 *  y = mx + B
	 */
	public double f(double  x,Punto a,Punto b)
	{
		double m = calcM(a, b);
		double B = calcB(a, m);
		return (m*x + B);	
	}
	public double calcM(Punto a, Punto b) {
		return (b.getY() - a.getY()) / (b.getX() - a.getX());
	}
	public double calcB(Punto x, double m){
		return x.getY() - (m*x.getX());
	}
	
	
	public Funcion getFunMembresia() {
		return funMembresia;
	}

	public void setFunMembresia(Funcion funMembresia) {
		this.funMembresia = funMembresia;
	}

}
