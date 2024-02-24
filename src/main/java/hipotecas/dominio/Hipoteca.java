/**
 * 
 */
package hipotecas.dominio;

import interfaces.Prestamo;

/**
 * @author zoser
 *
 */
public class Hipoteca extends Prestamo {

	public Hipoteca() {
		super();
	}

	public Hipoteca(double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnAnnos) {

		super(capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnAnnos);
	}

}
