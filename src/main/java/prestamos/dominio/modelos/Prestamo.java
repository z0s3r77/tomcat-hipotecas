package prestamos.dominio.modelos;

import java.sql.Date;
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
	protected Date fechaCreacion;
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
	 * @param usuarioId                    El usuario asociado al préstamo.
	 * @param fechaCreacion				   La fecha de creación del préstamo.
	 */
	public Prestamo(int id, double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnMeses, String tipoPrestamo, int usuarioId, Date fechaCreacion) {
		this.id = id;
		this.capital = capital;
		this.interes = interes;
		this.frecuenciaDePagoEnMeses = frecuenciaDePagoEnMeses;
		this.plazoDeAmortizacionEnMeses = plazoDeAmortizacionEnMeses;
		this.tipoPrestamo = tipoPrestamo;
		this.usuarioId = usuarioId;
		this.fechaCreacion = fechaCreacion;
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


	public int getId() {
		return id;
	}
	public double getCapital() {
		return this.capital;
	}
	public double getInteres() {
		return this.interes;
	}
	public int getFrecuenciaDePagoEnMeses() {
		return this.frecuenciaDePagoEnMeses;
	}
	public int getPlazoDeAmortizacionEnMeses() {
		return this.plazoDeAmortizacionEnMeses;
	}
	public double getCuotaMensual() {
		return this.cuotaMensual;
	}
	public List<RegistroAmortizacion> getCuadroDeAmortizacion(){
		return this.cuadroDeAmortizacion;
	}
	public int getUsuarioId() {
		return this.usuarioId;
	}
	public String getTipoPrestamo() {
		return tipoPrestamo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setCapital(double capital) {
		this.capital = capital;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public void setFrecuenciaDePagoEnMeses(int frecuenciaDePagoEnMeses) {
		this.frecuenciaDePagoEnMeses = frecuenciaDePagoEnMeses;
	}
	public void setPlazoDeAmortizacionEnMeses(int plazoDeAmortizacionEnMeses) {
		this.plazoDeAmortizacionEnMeses = plazoDeAmortizacionEnMeses;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public void setTipoPrestamo(String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public void setCuotaMensual(double cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}
	public void setCuadroDeAmortizacion(List<RegistroAmortizacion> cuadroDeAmortizacion) {
		this.cuadroDeAmortizacion = cuadroDeAmortizacion;
	}
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * Método que devuelve la frecuencia de amortización en String
	 * 
	 * @return String
	 */
	public String getFrecuenciaAmortizacion() {
		
		if (this.frecuenciaDePagoEnMeses == 1) {
			return "mensual";
		}
		
		if (this.frecuenciaDePagoEnMeses == 3) {
			return "trimestral";
		}
		
		
		if (this.frecuenciaDePagoEnMeses == 12) {
			return "anual";
		}
		
		return null;
	}
	
	/**
	 * Método abstracto para calcular el cuadro de amortización del préstamo.
	 */
	public abstract void calcularCuadroAmortizacion();

	/**
	 * Método abstracto para calcular la cuota mensual del préstamo.
	 */
	public abstract void calcularCuotaMensual();


	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", capital=" + capital + ", interes=" + interes + ", frecuenciaDePagoEnMeses="
				+ frecuenciaDePagoEnMeses + ", plazoDeAmortizacionEnMeses=" + plazoDeAmortizacionEnMeses
				+ ", tipoPrestamo=" + tipoPrestamo + ",fecha de creacion " + fechaCreacion + ", usuarioId=" + usuarioId + "]";
	}

}
