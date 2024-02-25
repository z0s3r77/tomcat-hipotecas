package prestamos.dominio;

public class RegistroAmortizacion {
	
	private int numeroDePago;
	private double cantidadPendiente;
	private double cantidadAmortizada;
	private double intereses;
	private double cuota;
	
	public RegistroAmortizacion(){}
	
	public RegistroAmortizacion(int numeroDePago, double cantidadPendiente, double cantidadAmortizada, double intereses, double cuota){

        this.numeroDePago = numeroDePago;
        this.cantidadPendiente = Math.floor(cantidadPendiente * 100.0) / 100.0; // Redondear hacia arriba al euro más cercano
        this.cantidadAmortizada = Math.floor(cantidadAmortizada * 100.0) / 100.0; // Redondear hacia arriba al euro más cercano
        this.intereses = Math.floor(intereses * 100.0) / 100.0; // Redondear hacia arriba al euro más cercano
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

    @Override
    public String toString() {
        return "RegistroAmortizacion{" +
                "numeroDePago=" + numeroDePago +
                ", cantidadPendiente=" + cantidadPendiente +
                ", cantidadAmortizada=" + cantidadAmortizada +
                ", intereses=" + intereses +
                ", cuota=" + cuota +
                '}';
    }
}
