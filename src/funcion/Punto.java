package funcion;

public class Punto 
{
	private double x;
	private double y;
	public double getX() {
		return x;
	}
	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public Punto(double x) {
		super();
		this.x = x;
	}
}
