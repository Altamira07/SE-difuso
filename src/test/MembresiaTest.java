package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import funcion.Funcion;
import funcion.Membresia;
import funcion.Punto;

public class MembresiaTest {

	@Test
	public void testM() {

		Punto a = new Punto(80, 0);
		Punto b = new Punto(90, 1);
		Membresia f = new Membresia();

		double mEsperado = 0.1;
		double mReal = f.calcM(a, b);

		assertEquals(mEsperado, mReal, 0);

	}

	@Test
	public void testB() {
		Punto a = new Punto(80, 0);
		Membresia f = new Membresia();
		double m = 0.1;

		double bEsperado = -8;
		double bReal = f.calcB(a, 0.1);

		assertEquals(bEsperado, bReal, 0);

	}

	@Test
	public void testBCaso2() {
		Punto b = new Punto(90, 1);
		Membresia f = new Membresia();

		double m = 0.1;
		double bEsperado = -8;
		double bReal = f.calcB(b, m);

		assertEquals(bEsperado, bReal, 0);

	}
	
	@Test
	public void testMembresiaF()
	{
		Punto a = new Punto(80, 0);
		Punto b = new Punto(90, 1);
		Membresia f = new Membresia();
		
		double membReal =  f.f(85, a, b);
		double membEsperada = 0.5;
		
		assertEquals(membEsperada, membReal,0);
	}
	
	@Test
	public void testMembresiaFCaso2()
	{
		Punto a = new Punto(90, 1);
		Punto b = new Punto(100, 0);
		Membresia f = new Membresia();
		
		double membReal =  f.f(95, a, b);
		double membEsperada = 0.5;
		
		assertEquals(membEsperada, membReal,0);
	}
	
	@Test
	public void testMembresiaFCaso3()
	{
		Punto a = new Punto(80, 0);
		Punto b = new Punto(90, 1);
		Membresia f = new Membresia();
		
		double membReal =  f.f(90, a, b);
		double membEsperada = 1;
		
		assertEquals(membEsperada, membReal,0);
	}
	
	@Test
	public void testMembresia() {
		ArrayList<Punto> puntos = new ArrayList<>();
		puntos.add(new Punto(80, 0));
		puntos.add(new Punto(85, 1));
		Funcion f = new Funcion(puntos);
		
		Membresia m = new Membresia();
		double mReal = m.calcMembresia(85, f);
		double mEsperado = 1;
		
		assertEquals(mEsperado, mReal,0);
	}
	/*
	 * Caso Resutlados
	 */
	@Test
	public void testMembresiaCaso2() {
		ArrayList<Punto> puntos = new ArrayList<>();
		puntos.add(new Punto(80, 0));
		puntos.add(new Punto(85, 1));
		puntos.add(new Punto(100, 1));
		Funcion f = new Funcion(puntos);
		
		Membresia m = new Membresia();
		double mReal = m.calcMembresia(90, f);
		double mEsperado = 1;
		
		assertEquals(mEsperado, mReal,0);
	}
	/*
	 * Caso Estrategias de trabajo
	 */
	@Test
	public void testMembresiaCaso3() {
		ArrayList<Punto> puntos = new ArrayList<>();
		puntos.add(new Punto(80, 0));
		puntos.add(new Punto(90, 1));
		puntos.add(new Punto(100, 0));
		Funcion f = new Funcion(puntos);
		
		Membresia m = new Membresia();
		double mReal = m.calcMembresia(85, f);
		double mEsperado = 0.5;
		
		assertEquals(mEsperado, mReal,0);
	}
	
}
