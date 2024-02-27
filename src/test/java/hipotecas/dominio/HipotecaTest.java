package hipotecas.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import prestamos.dominio.modelos.Hipoteca;
import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.modelos.RegistroAmortizacion;
import usuarios.dominio.modelos.Usuario;

class HipotecaTest {
	
	final double capital = 120.000;
	final double interes = 4.5;
	final int frecuenciaDePagoEnMeses = 1;
	final int plazoAmortizacionEnMeses = 12;
	final int usuario = 0;

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
		
		Hipoteca hipoteca = new Hipoteca(capital, interes, frecuenciaDePagoEnMeses, plazoAmortizacionEnMeses, usuario);
		
		assertNotNull(hipoteca);
	}
	
	@Test
	void testHipotecaGetterSetter(){
		
		Hipoteca hipoteca = new Hipoteca();
		
		hipoteca.setCapital(capital);
		hipoteca.setInteres(interes);
		hipoteca.setFrecuenciaDePagoEnMeses(frecuenciaDePagoEnMeses);
		hipoteca.setPlazoDeAmortizacionEnMeses(plazoAmortizacionEnMeses);

		assertEquals(hipoteca.getCapital(), 0 ,capital);
		assertEquals(hipoteca.getInteres(),0 , interes);
		assertEquals(hipoteca.getFrecuenciaDePagoEnMeses(), frecuenciaDePagoEnMeses);
		assertEquals(hipoteca.getPlazoDeAmortizacionEnMeses(), plazoAmortizacionEnMeses);

	}
	
	
	@Test
	void testCalcularCuotaMensual() {
		
		// El resultado no está formateado, pero está bien, sería 1243.66: 
		double resultadoCuotaMensual = 10.245422590364855;
		
		Hipoteca hipoteca = new Hipoteca(capital, interes, frecuenciaDePagoEnMeses, plazoAmortizacionEnMeses, usuario);
		hipoteca.calcularCuotaMensual();
		
		assertEquals(hipoteca.getCuotaMensual(),resultadoCuotaMensual, 0.01);
		
	}
	

	@Test
	void testCalcularPrimerRegistroCuadroAmortizacion() {
		
		 Hipoteca hipoteca = new Hipoteca(capital, interes, frecuenciaDePagoEnMeses, plazoAmortizacionEnMeses, usuario);
		    
		    // Supongamos un resultado de prueba para la primera cuota
		    double saldoInicialEsperado = capital;
		    double amortizacionEsperada = 9.795422590364856;  
		    double interesesEsperados = 0.44999999999999996;      
		    double cuotaEsperada = 10.245422590364855;         

		    hipoteca.calcularCuadroAmortizacion();

		    List<RegistroAmortizacion> cuadroAmortizacion = hipoteca.getCuadroDeAmortizacion();

		    // Verificar que el cuadro de amortización tiene al menos una entrada
		    assertFalse(cuadroAmortizacion.isEmpty());

		    // Verificar los valores de la primera cuota
		    RegistroAmortizacion primeraCuota = cuadroAmortizacion.get(0);
		    assertEquals(primeraCuota.getNumeroDePago(), 1);
		    assertEquals(primeraCuota.getCantidadPendiente(), saldoInicialEsperado, 0);
		    assertEquals(primeraCuota.getCantidadAmortizada(), amortizacionEsperada, 0);
		    assertEquals(primeraCuota.getIntereses(), interesesEsperados, 0);
		    assertEquals(primeraCuota.getCuota(), cuotaEsperada, 0.01);
		
	}

	@Test
	void testCalcularUltimoRegistroCuadroAmortizacion() {
		
		 Hipoteca hipoteca = new Hipoteca(capital, interes, frecuenciaDePagoEnMeses, plazoAmortizacionEnMeses, usuario);
		    
		    // Resultado de prueba para la última cuota (12 meses)
		    double ultimoSaldoEsperado = 10.20714579363616;
		    double amortizacionEsperada = 10.20714579363872;  
		    double interesesEsperados = 0.0382767967261356;      
		    double cuotaEsperada = 10.245422590364855;         

		    hipoteca.calcularCuadroAmortizacion();

		   
		    List<RegistroAmortizacion> cuadroAmortizacion = hipoteca.getCuadroDeAmortizacion();

		    // Verificar que el cuadro de amortización tiene al menos una entrada
		    assertFalse(cuadroAmortizacion.isEmpty());

		    // Verificar los valores de la última cuota
		    RegistroAmortizacion primeraCuota = cuadroAmortizacion.get(11);
		    assertEquals(primeraCuota.getNumeroDePago(), this.plazoAmortizacionEnMeses);
		    assertEquals(primeraCuota.getCantidadPendiente(), ultimoSaldoEsperado, 0);
		    assertEquals(primeraCuota.getCantidadAmortizada(), amortizacionEsperada, 0);
		    assertEquals(primeraCuota.getIntereses(), interesesEsperados, 0);
		    assertEquals(primeraCuota.getCuota(), cuotaEsperada, 0.01);
		
	}

	
	
	
}
