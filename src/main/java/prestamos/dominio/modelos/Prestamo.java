package prestamos.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa un préstamo en la capa de dominio del sistema.
 * Contiene atributos y métodos comunes para todos los tipos de préstamos.
 *
 * @author zoser
 */
public abstract class Prestamo {

	protected int id;
	protected double capital;
	protected double interes;
	protected int frecuenciaDePagoEnMeses;
	protected int plazoDeAmortizacionEnMeses;
	protected double cuotaMensual;
	protected String tipoPrestamo;
	protected List<RegistroAmortizacion> cuadroDeAmortizacion = new ArrayList<RegistroAmortizacion>();
	protected int usuarioId;

	/**
	 * Constructor por defecto de la clase abstracta Prestamo.
	 */
	public Prestamo() {}

	/**
	 * Constructor que inicializa los atributos del préstamo con los valores proporcionados.
	 *
	 * @param id                           El identificador único del préstamo.
	 * @param capital                      El monto del préstamo.
	 * @param interes                      La tasa de interés del préstamo.
	 * @param frecuenciaDePagoEnMeses      La frecuencia de pago del préstamo en meses.
	 * @param plazoDeAmortizacionEnMeses   El plazo de amortización del préstamo en meses.
	 * @param tipoPrestamo                 El tipo de préstamo.
	 * @param usuarioId                      El usuario asociado al préstamo.
	 */
	public Prestamo(int id, double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnMeses, String tipoPrestamo, int usuarioId) {
		this.id = id;
		this.capital = capital;
		this.interes = interes;
		this.frecuenciaDePagoEnMeses = frecuenciaDePagoEnMeses;
		this.plazoDeAmortizacionEnMeses = plazoDeAmortizacionEnMeses;
		this.tipoPrestamo = tipoPrestamo;
		this.usuarioId = usuarioId;
	}

	/**
	 * Constructor que inicializa los atributos del préstamo con los valores proporcionados.
	 *
	 * @param capital                      El monto del préstamo.
	 * @param interes                      La tasa de interés del préstamo.
	 * @param frecuenciaDePagoEnMeses      La frecuencia de pago del préstamo en meses.
	 * @param plazoDeAmortizacionEnMeses   El plazo de amortización del préstamo en meses.
	 * @param usuarioId                      El usuario asociado al préstamo.
	 */
	public Prestamo(double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnMeses, int usuarioId) {
		this.capital = capital;
		this.interes = interes;
		this.frecuenciaDePagoEnMeses = frecuenciaDePagoEnMeses;
		this.plazoDeAmortizacionEnMeses = plazoDeAmortizacionEnMeses;
		this.usuarioId = usuarioId;
	}

	/**
	 * Obtiene el identificador único del préstamo.
	 *
	 * @return El identificador único del préstamo.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador único del préstamo.
	 *
	 * @param id El identificador único del préstamo.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Establece la cuota mensual del préstamo.
	 *
	 * @param cuotaMensual La cuota mensual del préstamo.
	 */
	public void setCuotaMensual(double cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}

	/**
	 * Establece el cuadro de amortización del préstamo.
	 *
	 * @param cuadroDeAmortizacion El cuadro de amortización del préstamo.
	 */
	public void setCuadroDeAmortizacion(List<RegistroAmortizacion> cuadroDeAmortizacion) {
		this.cuadroDeAmortizacion = cuadroDeAmortizacion;
	}

	/**
	 * Obtiene el monto del préstamo.
	 *
	 * @return El monto del préstamo.
	 */
	public double getCapital() {
		return this.capital;
	}

	/**
	 * Obtiene la tasa de interés del préstamo.
	 *
	 * @return La tasa de interés del préstamo.
	 */
	public double getInteres() {
		return this.interes;
	}

	/**
	 * Obtiene la frecuencia de pago del préstamo en meses.
	 *
	 * @return La frecuencia de pago del préstamo en meses.
	 */
	public int getFrecuenciaDePagoEnMeses() {
		return this.frecuenciaDePagoEnMeses;
	}

	/**
	 * Obtiene el plazo de amortización del préstamo en meses.
	 *
	 * @return El plazo de amortización del préstamo en meses.
	 */
	public int getPlazoDeAmortizacionEnMeses() {
		return this.plazoDeAmortizacionEnMeses;
	}

	/**
	 * Obtiene la cuota mensual del préstamo.
	 *
	 * @return La cuota mensual del préstamo.
	 */
	public double getCuotaMensual() {
		return this.cuotaMensual;
	}

	/**
	 * Obtiene el cuadro de amortización del préstamo.
	 *
	 * @return El cuadro de amortización del préstamo.
	 */
	public List<RegistroAmortizacion> getCuadroDeAmortizacion(){
		return this.cuadroDeAmortizacion;
	}

	/**
	 * Obtiene el usuario asociado al préstamo.
	 *
	 * @return El usuario asociado al préstamo.
	 */
	public int getUsuarioId() {
		return this.usuarioId;
	}

	/**
	 * Obtiene el tipo de préstamo.
	 *
	 * @return El tipo de préstamo.
	 */
	public String getTipoPrestamo() {
		return tipoPrestamo;
	}

	/**
	 * Establece el monto del préstamo.
	 *
	 * @param capital El monto del préstamo.
	 */
	public void setCapital(double capital) {
		this.capital = capital;
	}

	/**
	 * Establece la tasa de interés del préstamo.
	 *
	 * @param interes La tasa de interés del préstamo.
	 */
	public void setInteres(double interes) {
		this.interes = interes;
	}

	/**
	 * Establece la frecuencia de pago del préstamo en meses.
	 *
	 * @param frecuenciaDePagoEnMeses La frecuencia de pago del préstamo en meses.
	 */
	public void setFrecuenciaDePagoEnMeses(int frecuenciaDePagoEnMeses) {
		this.frecuenciaDePagoEnMeses = frecuenciaDePagoEnMeses;
	}

	/**
	 * Establece el plazo de amortización del préstamo en meses.
	 *
	 * @param plazoDeAmortizacionEnMeses El plazo de amortización del préstamo en meses.
	 */
	public void setPlazoDeAmortizacionEnMeses(int plazoDeAmortizacionEnMeses) {
		this.plazoDeAmortizacionEnMeses = plazoDeAmortizacionEnMeses;
	}

	/**
	 * Establece el usuario asociado al préstamo.
	 *
	 * @param usuarioId El usuario asociado al préstamo.
	 */
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	/**
	 * Establece el tipo de préstamo.
	 *
	 * @param tipoPrestamo El tipo de préstamo.
	 */
	public void setTipoPrestamo(String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}

	/**
	 * Método abstracto para calcular el cuadro de amortización del préstamo.
	 */
	public abstract void calcularCuadroAmortizacion();

	/**
	 * Método abstracto para calcular la cuota mensual del préstamo.
	 */
	public abstract void calcularCuotaMensual();

	/**
	 * Representación en cadena del objeto Prestamo.
	 *
	 * @return Una cadena que representa el objeto Prestamo.
	 */
	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", capital=" + capital + ", interes=" + interes + ", frecuenciaDePagoEnMeses="
				+ frecuenciaDePagoEnMeses + ", plazoDeAmortizacionEnMeses=" + plazoDeAmortizacionEnMeses
				+ ", tipoPrestamo=" + tipoPrestamo + ", usuarioId=" + usuarioId + "]";
	}

}
