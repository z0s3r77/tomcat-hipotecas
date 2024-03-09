package prestamos.dominio.modelos;

import java.sql.Date;

/**
 * Clase que representa una hipoteca, que es un tipo específico de préstamo, en la capa de dominio del sistema.
 * Extiende la clase abstracta Prestamo.
 *
 * @author zoser
 * @see Prestamo
 */
public class Hipoteca extends Prestamo {

	/**
	 * Constructor por defecto de la clase Hipoteca.
	 */
	public Hipoteca() {
		super();
	}

	/**
	 * Constructor que inicializa los atributos de la hipoteca con los valores proporcionados.
	 *
	 * @param capital                     El monto del préstamo.
	 * @param interes                     La tasa de interés del préstamo.
	 * @param frecuenciaDePagoEnMeses     La frecuencia de pago del préstamo en meses.
	 * @param plazoDeAmortizacionEnAnnos  El plazo de amortización del préstamo en años.
	 * @param usuarioId                     El usuario asociado al préstamo.
	 */
	public Hipoteca(double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnAnnos, int usuarioId) {
		super(capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnAnnos, usuarioId);
	}

	/**
	 * Constructor que inicializa los atributos de la hipoteca con los valores proporcionados, incluyendo un identificador.
	 *
	 * @param id                           El identificador único de la hipoteca.
	 * @param capital                      El monto del préstamo.
	 * @param interes                      La tasa de interés del préstamo.
	 * @param frecuenciaDePagoEnMeses      La frecuencia de pago del préstamo en meses.
	 * @param plazoDeAmortizacionEnMeses   El plazo de amortización del préstamo en meses.
	 * @param tipoDePrestamo               El tipo de préstamo.
	 * @param usuarioId                      El usuario asociado al préstamo.
	 */
	public Hipoteca(int id, double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnMeses, String tipoDePrestamo, int usuarioId, Date fechaCreacion) {
		super(id, capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnMeses, tipoDePrestamo, usuarioId, fechaCreacion);
	}

	/**
	 * Calcula el cuadro de amortización para la hipoteca y lo almacena en el atributo cuadroDeAmortizacion.
	 * Utiliza la fórmula de amortización constante.
	 *
	 * @see RegistroAmortizacion
	 */
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

	/**
	 * Calcula la cuota mensual para la hipoteca utilizando la fórmula de amortización constante.
	 */
	@Override
	public void calcularCuotaMensual() {
		double tasaInteresMensual = interes / 100 / 12;
		double factor = Math.pow(1 + tasaInteresMensual, -plazoDeAmortizacionEnMeses);
		this.cuotaMensual = Math.round(capital * tasaInteresMensual / (1 - factor) * 100.0) / 100.0;
	}

}