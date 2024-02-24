/**
 * 
 */
package prestamos.dominio;

import java.util.ArrayList;
import java.util.List;

import usuarios.dominio.Usuario;

/**
 * @author zoser
 *
 */
public abstract class Prestamo {
	
	protected double capital;
	protected double interes;
	protected int frecuenciaDePagoEnMeses; 
	protected int plazoDeAmortizacionEnMeses; 
	protected double cuotaMensual;
	protected List<RegistroAmortizacion> cuadroDeAmortizacion = new ArrayList<RegistroAmortizacion>();
	protected Usuario usuario;

	
	public Prestamo() {}
	
	
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
	
	public double getCuotaMensual() {
		return this.cuotaMensual;
	}
	
	public List<RegistroAmortizacion> getCuadroDeAmortizacion(){
		return this.cuadroDeAmortizacion;
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
	
	
    public abstract void calcularCuadroAmortizacion();
    public abstract void calcularCuotaMensual();
}
