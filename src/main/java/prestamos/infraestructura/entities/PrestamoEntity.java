package prestamos.infraestructura.entities;

import prestamos.dominio.modelos.Hipoteca;
import prestamos.dominio.modelos.Prestamo;
import usuarios.infraestructura.entities.UsuarioEntity;

import java.util.Objects;

/**
 * Entidad que representa un préstamo en el contexto de persistencia.
 *
 *
 * Esta clase mapea la información de un préstamo desde la capa de dominio al formato adecuado para su almacenamiento
 * en la capa de infraestructura de persistencia, como una base de datos. También proporciona métodos para convertir
 * entre el modelo de dominio y la representación en la capa de infraestructura.
 *
 *
 * @see Prestamo
 * @see UsuarioEntity
 *
 */
public class PrestamoEntity {

    private int id;
    private double capital;
    private double interes;
    private int frecuenciaDePagoEnMeses;
    private int plazoDeAmortizacionEnMeses;
    private String tipoDePrestamo;
    private int usuarioId;

    public PrestamoEntity(){}

    public PrestamoEntity(int id, double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnMeses, String tipoDePrestamo, int usuarioId) {
        this.id = id;
        this.capital = capital;
        this.interes = interes;
        this.frecuenciaDePagoEnMeses = frecuenciaDePagoEnMeses;
        this.plazoDeAmortizacionEnMeses = plazoDeAmortizacionEnMeses;
        this.tipoDePrestamo = tipoDePrestamo;
        this.usuarioId = usuarioId;
    }

    /**
     * Convierte un objeto de dominio {@link Prestamo} a una entidad {@link PrestamoEntity}.
     *
     * @param prestamo El objeto de dominio {@link Prestamo} a convertir.
     * @return La entidad {@link PrestamoEntity} creada a partir del objeto de dominio.
     */
    public static PrestamoEntity fromDomainModel(Prestamo prestamo){

        return new PrestamoEntity(prestamo.getId(), prestamo.getCapital(), prestamo.getInteres(), prestamo.getFrecuenciaDePagoEnMeses(), prestamo.getFrecuenciaDePagoEnMeses(), prestamo.getTipoPrestamo(),  prestamo.getUsuarioId());

    }


    /**
     * Convierte la entidad {@link PrestamoEntity} a un objeto de dominio {@link Prestamo}.
     *
     * @param prestamo La instancia de {@link Prestamo} que se actualizará con los valores de la entidad.
     * @return El objeto de dominio {@link Prestamo} actualizado.
     */
    public Prestamo toDomainModel(Prestamo prestamo){
        if (prestamo instanceof Hipoteca) {
            return new Hipoteca(this.id, this.capital, this.interes, this.frecuenciaDePagoEnMeses, this.plazoDeAmortizacionEnMeses, this.tipoDePrestamo, this.usuarioId);
        }
        return new Hipoteca();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUsuario() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrestamoEntity)) return false;
        PrestamoEntity that = (PrestamoEntity) o;
        return getId() == that.getId() && Double.compare(getCapital(), that.getCapital()) == 0 && Double.compare(getInteres(), that.getInteres()) == 0 && getFrecuenciaDePagoEnMeses() == that.getFrecuenciaDePagoEnMeses() && getPlazoDeAmortizacionEnMeses() == that.getPlazoDeAmortizacionEnMeses() && Objects.equals(getTipoDePrestamo(), that.getTipoDePrestamo()) && Objects.equals(getUsuario(), that.getUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCapital(), getInteres(), getFrecuenciaDePagoEnMeses(), getPlazoDeAmortizacionEnMeses(), getTipoDePrestamo(), getUsuario());
    }

    @Override
    public String toString() {
        return "PrestamoEntity{" +
                "id=" + id +
                ", capital=" + capital +
                ", interes=" + interes +
                ", frecuenciaDePagoEnMeses=" + frecuenciaDePagoEnMeses +
                ", plazoDeAmortizacionEnMeses=" + plazoDeAmortizacionEnMeses +
                ", tipoDePrestamo='" + tipoDePrestamo + '\'' +
                ", usuarioRegistradoId=" + usuarioId +
                '}';
    }
}
