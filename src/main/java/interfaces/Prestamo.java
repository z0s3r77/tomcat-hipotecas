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
	private int plazoDeAmortizacionEnAnnos; 
	private Usuario usuario;
	
	public Prestamo() {
		
	}
	
	public Prestamo(double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnAnnos, Usuario usuario) {
		this.capital = capital;
		this.interes = interes;
		this.frecuenciaDePagoEnMeses = frecuenciaDePagoEnMeses;
		this.plazoDeAmortizacionEnAnnos = plazoDeAmortizacionEnAnnos;
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
	
	public int getPlazoDeAmortizacionEnAnnos() {
		return this.plazoDeAmortizacionEnAnnos;
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
	
	public void setPlazoDeAmortizacionEnAnnos(int plazoDeAmortizacionEnAnnos) {
		this.plazoDeAmortizacionEnAnnos = plazoDeAmortizacionEnAnnos;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
