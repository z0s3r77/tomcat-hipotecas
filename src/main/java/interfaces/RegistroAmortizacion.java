package interfaces;

public class RegistroAmortizacion {
	
	private int numeroDePago;
	private double cantidadPendiente;
	private double cantidadAmortizada;
	private double intereses;
	private double cuota;
	
	public RegistroAmortizacion(){}
	
	public RegistroAmortizacion(int numeroDePago, double cantidadPendiente, double cantidadAmortizada, double intereses, double cuota){
		
		this.numeroDePago = numeroDePago;
		this.cantidadPendiente = cantidadPendiente;
		this.cantidadAmortizada = cantidadAmortizada;
		this.intereses = intereses;
		this.cuota = cuota;
	}
	
    public int getNumeroDePago() {
        return numeroDePago;
    }

    public void setNumeroDePago(int numeroDePago) {
        this.numeroDePago = numeroDePago;
    }

    public double getCantidadPendiente() {
        return cantidadPendiente;
    }

    public void setCantidadPendiente(double cantidadPendiente) {
        this.cantidadPendiente = cantidadPendiente;
    }

    public double getCantidadAmortizada() {
        return cantidadAmortizada;
    }

    public void setCantidadAmortizada(double cantidadAmortizada) {
        this.cantidadAmortizada = cantidadAmortizada;
    }

    public double getIntereses() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }
}
