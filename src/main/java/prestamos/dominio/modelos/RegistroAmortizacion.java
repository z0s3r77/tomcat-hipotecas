/**
 * Clase que representa un registro en el cuadro de amortización de un préstamo en la capa de dominio del sistema.
 * Contiene información detallada sobre un pago específico, incluyendo el número de pago, cantidad pendiente, cantidad amortizada,
 * intereses y cuota.
 *
 * Esta clase proporciona métodos para acceder y modificar la información de cada atributo del registro de amortización.
 * También sobrescribe el método toString para obtener una representación en cadena del objeto.
 *
 * @author z0s3r
 *
 */
package prestamos.dominio.modelos;

/**
 * Clase que representa un registro en el cuadro de amortización de un préstamo en la capa de dominio del sistema.
 * Contiene información detallada sobre un pago específico, incluyendo el número de pago, cantidad pendiente, cantidad amortizada,
 * intereses y cuota.
 *
 * Esta clase proporciona métodos para acceder y modificar la información de cada atributo del registro de amortización.
 * También sobrescribe el método toString para obtener una representación en cadena del objeto.
 *
 * @author z0s3r
 *
 */
public class RegistroAmortizacion {

    private int numeroDePago;
    private double cantidadPendiente;
    private double cantidadAmortizada;
    private double intereses;
    private double cuota;

    /**
     * Constructor por defecto de la clase RegistroAmortizacion.
     *
     * Inicializa todos los atributos a sus valores por defecto.
     */
    public RegistroAmortizacion() {}

    /**
     * Constructor que inicializa los atributos del registro de amortización con los valores proporcionados.
     * Redondea hacia arriba al euro más cercano para los campos de cantidad pendiente, cantidad amortizada e intereses.
     *
     * @param numeroDePago       El número de pago.
     * @param cantidadPendiente  La cantidad pendiente.
     * @param cantidadAmortizada La cantidad amortizada.
     * @param intereses          Los intereses.
     * @param cuota              La cuota.
     */
    public RegistroAmortizacion(int numeroDePago, double cantidadPendiente, double cantidadAmortizada, double intereses, double cuota) {
        this.numeroDePago = numeroDePago;
        this.cantidadPendiente = Math.floor(cantidadPendiente * 100.0) / 100.0; // Redondear hacia arriba al euro más cercano
        this.cantidadAmortizada = Math.floor(cantidadAmortizada * 100.0) / 100.0; // Redondear hacia arriba al euro más cercano
        this.intereses = Math.floor(intereses * 100.0) / 100.0; // Redondear hacia arriba al euro más cercano
        this.cuota = cuota;
    }

    /**
     * Obtiene el número de pago.
     *
     * @return El número de pago.
     */
    public int getNumeroDePago() {
        return numeroDePago;
    }

    /**
     * Establece el número de pago.
     *
     * @param numeroDePago El número de pago.
     */
    public void setNumeroDePago(int numeroDePago) {
        this.numeroDePago = numeroDePago;
    }

    /**
     * Obtiene la cantidad pendiente.
     *
     * @return La cantidad pendiente.
     */
    public double getCantidadPendiente() {
        return cantidadPendiente;
    }

    /**
     * Establece la cantidad pendiente.
     *
     * @param cantidadPendiente La cantidad pendiente.
     */
    public void setCantidadPendiente(double cantidadPendiente) {
        this.cantidadPendiente = cantidadPendiente;
    }

    /**
     * Obtiene la cantidad amortizada.
     *
     * @return La cantidad amortizada.
     */
    public double getCantidadAmortizada() {
        return cantidadAmortizada;
    }

    /**
     * Establece la cantidad amortizada.
     *
     * @param cantidadAmortizada La cantidad amortizada.
     */
    public void setCantidadAmortizada(double cantidadAmortizada) {
        this.cantidadAmortizada = cantidadAmortizada;
    }

    /**
     * Obtiene los intereses.
     *
     * @return Los intereses.
     */
    public double getIntereses() {
        return intereses;
    }

    /**
     * Establece los intereses.
     *
     * @param intereses Los intereses.
     */
    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }

    /**
     * Obtiene la cuota.
     *
     * @return La cuota.
     */
    public double getCuota() {
        return cuota;
    }

    /**
     * Establece la cuota.
     *
     * @param cuota La cuota.
     */
    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    /**
     * Representación en cadena del objeto RegistroAmortizacion.
     *
     * @return Una cadena que representa el objeto RegistroAmortizacion.
     */
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
