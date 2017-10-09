package test;

import static org.junit.Assert.*;

import org.junit.Test;

import operaciones.ProductoCartesiano;

public class ProducetoCartesianoTest {

	@Test
	public void test() {
		//Preaparacion
		double[]a = {0,0.5,1,0.5,0};
		double []b = {0,1,1,1,1};
		ProductoCartesiano pc = new ProductoCartesiano(a, b);
		double [][]axbEsperado = 
			{
					{0,0,0,0,0},
					{0,0.5,0.5,0.5,0.5},
					{0,1,1,1,1},
					{0,0.5,0.5,0.5,0.5},
					{0,0,0,0,0},
			};
		double axbReal[][] = pc.prodCartesiano();
		boolean prueba = true;
		//Ejecutando prueba
		for(int i = 0; i<a.length;i++)
			for(int j  = 0; j < b.length; j++)
				if(axbEsperado[i][j] != axbReal[i][j])
					prueba = false;
		
		//Salida de la prueba
		if(!prueba)
			fail("No son iguales");
	}

}
