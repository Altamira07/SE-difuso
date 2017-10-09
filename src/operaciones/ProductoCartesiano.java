package operaciones;


public class ProductoCartesiano 
{
	private double[] a;
	private double[] b;
	private double[][]axb;
	
	public ProductoCartesiano(double []a,double[]b)
	{
		this.a = a;
		this.b = b;
		axb = new double[a.length][b.length];
	}
	
	public double[][] prodCartesiano()
	{
		double aTemp, bTemp;
		double valor;
		for(int i = 0 ; i< a.length; i++)
		{
			aTemp = a[i];
			for(int j = 0; j< b.length; j++)
			{
				bTemp = b[j];
				if(aTemp < bTemp)
					valor = aTemp;
				else
					valor = bTemp;
				axb[i][j] = valor;
			}
		}
		return axb;
	}
	
}
