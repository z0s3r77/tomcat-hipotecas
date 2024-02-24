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
	private int plazoMensual;
	
	public Prestamo() {
		
	}
	
	public Prestamo(double capital, double interes, int plazoMensual) {
		this.capital = capital;
		this.interes = interes;
		this.plazoMensual = plazoMensual;
	}
	
	public double getCapital() {
		return this.capital;
	}
	
	public double getInteres() {
		return this.interes;
	}
	
	public int getPlazoMensual() {
		return this.plazoMensual;
	}
	
	
	public void setCapital(double capital) {
		this.capital = capital;
	}
	
	public void setInteres(double interes) {
		this.interes = interes;
	}
	
	public void setPlazoMensual(int plazoMensual) {
		this.plazoMensual = plazoMensual;
	}
}
