package prestamos.infraestructura.dtos;

public class PrestamoDto {

    private double capital;
    private double interes;
    private int frecuenciaDePagoEnMeses;
    private int plazoDeAmortizacionEnMeses;
    private String tipoDePrestamo;
    private int usuarioId;

    public PrestamoDto() {
    }

    public PrestamoDto(double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnMeses, String tipoDePrestamo) {
        this.capital = capital;
        this.interes = interes;
        this.frecuenciaDePagoEnMeses = frecuenciaDePagoEnMeses;
        this.plazoDeAmortizacionEnMeses = plazoDeAmortizacionEnMeses;
        this.tipoDePrestamo = tipoDePrestamo;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getFrecuenciaDePagoEnMeses() {
        return frecuenciaDePagoEnMeses;
    }

    public void setFrecuenciaDePagoEnMeses(int frecuenciaDePagoEnMeses) {
        this.frecuenciaDePagoEnMeses = frecuenciaDePagoEnMeses;
    }

    public int getPlazoDeAmortizacionEnMeses() {
        return plazoDeAmortizacionEnMeses;
    }

    public void setPlazoDeAmortizacionEnMeses(int plazoDeAmortizacionEnMeses) {
        this.plazoDeAmortizacionEnMeses = plazoDeAmortizacionEnMeses;
    }

    public String getTipoDePrestamo() {
        return tipoDePrestamo;
    }

    public void setTipoDePrestamo(String tipoDePrestamo) {
        this.tipoDePrestamo = tipoDePrestamo;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
