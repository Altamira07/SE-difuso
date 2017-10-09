package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import operaciones.Composicion;

public class ComposicionTest {

	@Test
	public void testNumeroMayor() {
		ArrayList<Double> numeros = new ArrayList<>();
		numeros.add(10.0);
		numeros.add(11.0);
		numeros.add(15.0);
		numeros.add(1.0);
		numeros.add(99.0);
		double valEsperado  = 99.0;
		Composicion c = new Composicion();
		double valReal =  c.obtNumMayor(numeros);
		assertEquals(valEsperado, valReal,0);	
	}
	@Test
	public void testComposicionCaso1()
	{
		double m1[][] = {
				{0,0.5,1,0.5,0}
		};
		double m2[][] = {
				{0,0,0,0,0},
				{0,0.5,0.5,0.5,0.5},
				{0,1,1,1,1},
				{0,0.5,0.5,0.5,0.5},
				{0,0,0,0,0},
		};
		Composicion c = new Composicion(m1,m2);
		double compEsperada[][] = {{0,1,1,1,1}};
		double compReal [][]  = c.composicion();
		
		if(compReal[0].length != compEsperada[0].length && compReal.length != compEsperada.length )
			fail("No son iguales las matrices");
	}
	
	@Test
	public void testComposicionCaso2()
	{
		double m1[][] = {
				{0,0.5,1,0.5,0}
		};
		double m2[][] = {
				{0,0,0,0,0},
				{0,0.5,0.5,0.5,0.5},
				{0,1,1,1,1},
				{0,0.5,0.5,0.5,0.5},
				{0,0,0,0,0},
		};
		Composicion c = new Composicion(m1,m2);
		double compEsperada[][] = {{0,1,1,1,1}};
		double compReal [][]  = c.composicion();
		boolean prueba = true;
		for(int i = 0 ; i < compEsperada.length; i++)
			for(int j = 0; j<compEsperada[i].length;j++)
				if(compEsperada[i][j] != compReal[i][j])
					prueba = false;
		
		if(!prueba)
			fail("No son iguales");	
	}
	
	@Test
	public void testComposicionCaso3()
	{
		double m1[] =
				{0,0.5,1,0.5,0};
		double m2[][] = {
				{0,0,0,0,0},
				{0,0.5,0.5,0.5,0.5},
				{0,1,1,1,1},
				{0,0.5,0.5,0.5,0.5},
				{0,0,0,0,0},
		};
		Composicion c = new Composicion(m1,m2);
		double compEsperada[][] = {{0,1,1,1,1}};
		double compReal [][]  = c.composicion();
		boolean prueba = true;
		for(int i = 0 ; i < compEsperada.length; i++)
			for(int j = 0; j<compEsperada[i].length;j++)
				if(compEsperada[i][j] != compReal[i][j])
					prueba = false;
		
		if(!prueba)
			fail("No son iguales");	
	}

}
