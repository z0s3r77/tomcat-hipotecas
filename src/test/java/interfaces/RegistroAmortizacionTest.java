package interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import prestamos.dominio.RegistroAmortizacion;

class RegistroAmortizacionTest {

	final int numeroDePago = 1;
	final double cantidadPendiente = 1200.12;
	final double cantidadAmortizada = 32000.12;
	final double intereses = 432.5;
	final double cuota = 432.4;
	
	
	@Test
	void testRegistroAmortizacionEmptyConstructor() {
		
		RegistroAmortizacion registroAmortizacion = new RegistroAmortizacion();
		assertNotNull(registroAmortizacion);
	}
	
	@Test
	void testRegistroAmortizacionConstructor(){
		
		RegistroAmortizacion registroAmortizacion = new RegistroAmortizacion(numeroDePago,cantidadPendiente, cantidadAmortizada, intereses, cuota );
		assertNotNull(registroAmortizacion);

	}
	
    @Test
    void testRegistroAmortizacionGetterSetter() {
        RegistroAmortizacion registroAmortizacion = new RegistroAmortizacion();

        registroAmortizacion.setNumeroDePago(numeroDePago);
        registroAmortizacion.setCantidadPendiente(cantidadPendiente);
        registroAmortizacion.setCantidadAmortizada(cantidadAmortizada);
        registroAmortizacion.setIntereses(intereses);
        registroAmortizacion.setCuota(cuota);

        assertEquals(numeroDePago, registroAmortizacion.getNumeroDePago());
        assertEquals(cantidadPendiente, registroAmortizacion.getCantidadPendiente());
        assertEquals(cantidadAmortizada, registroAmortizacion.getCantidadAmortizada());
        assertEquals(intereses, registroAmortizacion.getIntereses());
        assertEquals(cuota, registroAmortizacion.getCuota());
    }

}
