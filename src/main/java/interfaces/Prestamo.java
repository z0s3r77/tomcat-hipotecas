/**
 * 
 */
package interfaces;

/**
 * @author zoser
 *
 */
public abstract class Prestamo {
	
	private double capital;
	private double interes;
	private int frecuenciaDePagoEnMeses; 
	private int plazoDeAmortizacionEnMeses; 
	private Usuario usuario;
	
	public Prestamo() {
		
	}
	
	public Prestamo(double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnMeses, Usuario usuario) {
		this.capital = capital;
		this.interes = interes;
		this.frecuenciaDePagoEnMeses = frecuenciaDePagoEnMeses;
		this.plazoDeAmortizacionEnMeses = plazoDeAmortizacionEnMeses;
		this.usuario = usuario;
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
	
	public Usuario getUsuario() {
		return this.usuario;
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
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
