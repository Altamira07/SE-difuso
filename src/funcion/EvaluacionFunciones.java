package funcion;

public class EvaluacionFunciones {

	private double x[];
	// Valores f(x)
	private double[] fx;
	// Funcion
	protected Membresia membresia;

	public EvaluacionFunciones(Funcion funcion, double[] x) {
		this.x = x;
		this.fx = new double[x.length];
		membresia = new Membresia(funcion);
	}
	
	public double[] evaluar()
	{
		for(int i = 0; i<x.length; i++)
			fx[i] = membresia.calcMembresia(x[i]);
		return fx;
	}
	
	public double[] evaluar(double[]x)
	{
		this.x = x;
		return evaluar();
	}
	public double[] evaluar(double[]x,Funcion funcion)
	{
		this.x = x;
		membresia.setFunMembresia(funcion);
		return evaluar();
	}

}
