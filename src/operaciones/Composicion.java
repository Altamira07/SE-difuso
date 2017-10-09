package operaciones;

import java.util.ArrayList;

public class Composicion {
	private double[][] m1;
	private double[][] m2;
	private double[][] composicion = null;

	public Composicion(double[][] m1, double m2[][]) {
		this.m1 = m1;
		this.m2 = m2;
	}

	public Composicion(double[] m1, double m2[][]) {
		this.m1 = new double[1][];
		this.m1[0] = m1;
		this.m2 = m2;
	}

	public double[][] composicion() {
		ArrayList<Double> minimos = new ArrayList<>();
		if (m1[0].length == m2.length) {
			composicion = new double[m1.length][m2[0].length];
			for (int i = 0; i < composicion.length; i++)
				for (int j = 0; j < composicion[i].length; j++) {
					for (int k = 0; k < m1[0].length; k++) {
						if (m1[i][k] < m2[k][j]) {
							minimos.add(m1[i][k]);
						} else {
							minimos.add(m2[k][j]);
						}

					}
					double maximo = obtNumMayor(minimos);
					composicion[i][j] = maximo;
					minimos.clear();
				}

		} else
			throw new RuntimeException("No se puede realizar (a,b),(c,d) - b!= c");
		return composicion;
	}

	public Composicion() {
		super();
	}

	public double obtNumMayor(ArrayList<Double> numeros) {
		double numeroActual;
		numeroActual = numeros.get(0);
		for (double numero : numeros) {
			if (numeroActual < numero)
				numeroActual = numero;
		}

		return numeroActual;
	}
}
