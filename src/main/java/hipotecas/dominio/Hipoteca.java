/**
 * 
 */
package hipotecas.dominio;

import interfaces.Prestamo;
import interfaces.Usuario;

/**
 * @author zoser
 *
 */
public class Hipoteca extends Prestamo {

	public Hipoteca() {
		super();
	}

	public Hipoteca(double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnAnnos, Usuario usuario) {

		super(capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnAnnos, usuario);
	}

}
