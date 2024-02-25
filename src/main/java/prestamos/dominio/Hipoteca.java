/**
 * 
 */
package prestamos.dominio;

import usuarios.dominio.modelos.Usuario;

import java.text.DecimalFormat;

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

	@Override
	public void calcularCuadroAmortizacion() {
		
	    calcularCuotaMensual();
	    
	    this.cuadroDeAmortizacion.clear(); 

	    double tasaInteresMensual = interes / 100 / 12;
	    int cuotasTotales = plazoDeAmortizacionEnMeses;

	    double saldoPendiente = capital;

	    for (int numeroDePago = 1; numeroDePago <= cuotasTotales; numeroDePago++) {
	        double interesesPendientes = saldoPendiente * tasaInteresMensual;
	        double amortizacion = this.cuotaMensual - interesesPendientes;

	        // Añadir el registro al cuadro de amortización
	        cuadroDeAmortizacion.add(new RegistroAmortizacion(numeroDePago, saldoPendiente, amortizacion, interesesPendientes, this.cuotaMensual));

	        saldoPendiente -= amortizacion;
	    }       
	}

	@Override
	public void calcularCuotaMensual() {
		double tasaInteresMensual = interes / 100 / 12;
		double factor = Math.pow(1 + tasaInteresMensual, -plazoDeAmortizacionEnMeses);
		this.cuotaMensual = Math.round(capital * tasaInteresMensual / (1 - factor) * 100.0) / 100.0;
	}

}
