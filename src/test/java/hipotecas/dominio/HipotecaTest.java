package hipotecas.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


import interfaces.Prestamo;

class HipotecaTest {
	
	final double capital = 120.000;
	final double interes = 4.5;
	final int plazoMensual = 12;
	

	@Test
	void testHipotecaEmptyConstructor() {
		
		Hipoteca hipoteca = new Hipoteca();
		
		assertNotNull(hipoteca);
	}
	
	@Test
	void testHipotecaEsUnPrestamo() {
		
		Hipoteca hipoteca = new Hipoteca();
		assertTrue(hipoteca instanceof Prestamo);
	
	}
	
	@Test
	void testHipotecaConstructor() {
		
		Hipoteca hipoteca = new Hipoteca(capital, interes, plazoMensual);
		
		assertNotNull(hipoteca);
	}
	
	@Test
	void testHipotecaGetterSetter(){
		
		Hipoteca hipoteca = new Hipoteca();
		
		hipoteca.setCapital(capital);
		hipoteca.setInteres(interes);
		hipoteca.setPlazoMensual(plazoMensual);
		
		assertEquals(hipoteca.getCapital(), 0 ,capital);
		assertEquals(hipoteca.getInteres(),0 , interes);
		assertEquals(hipoteca.getPlazoMensual(), plazoMensual);
		
	}
	
	
}
