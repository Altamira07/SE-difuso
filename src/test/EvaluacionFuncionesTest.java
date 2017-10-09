package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import funcion.EvaluacionFunciones;
import funcion.Funcion;
import funcion.Punto;

public class EvaluacionFuncionesTest {

	@Test
	public void testEvaluacion() {
		//Preparacion
		double x [] =  {80.0,85.0,90.0,95.0,100.0};
		double fxEsperado [] =  {0,0.5,1,0.5,0};
		ArrayList<Punto> puntos = new ArrayList<>();
		puntos.add(new Punto(80, 0));
		puntos.add(new Punto(90, 1));
		puntos.add(new Punto(100, 0));
		Funcion funcion = new Funcion(puntos);
		
		EvaluacionFunciones ef = new EvaluacionFunciones(funcion, x);
		double []fxReal = ef.evaluar();
		
		assertArrayEquals(fxEsperado,fxReal,0.0);	
	}

}
