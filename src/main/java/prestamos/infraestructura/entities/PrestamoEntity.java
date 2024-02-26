package prestamos.infraestructura.entities;

import prestamos.dominio.modelos.Hipoteca;
import prestamos.dominio.modelos.Prestamo;
import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.modelos.UsuarioRegistrado;
import usuarios.infraestructura.entities.UsuarioRegistradoEntity;

import java.util.Objects;

public class PrestamoEntity {

    private int id;
    private double capital;
    private double interes;
    private int frecuenciaDePagoEnMeses;
    private int plazoDeAmortizacionEnMeses;
    private String tipoDePrestamo;
    private UsuarioRegistradoEntity usuarioRegistradoEntity;

    public PrestamoEntity(){}

    public PrestamoEntity(int id, double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnMeses, String tipoDePrestamo, UsuarioRegistradoEntity usuarioRegistradoEntity) {
        this.id = id;
        this.capital = capital;
        this.interes = interes;
        this.frecuenciaDePagoEnMeses = frecuenciaDePagoEnMeses;
        this.plazoDeAmortizacionEnMeses = plazoDeAmortizacionEnMeses;
        this.tipoDePrestamo = tipoDePrestamo;
        this.usuarioRegistradoEntity = usuarioRegistradoEntity;
    }

    public static PrestamoEntity fromDomainModel(Prestamo prestamo){

        UsuarioRegistradoEntity usuarioRegistrado = UsuarioRegistradoEntity.fromDomainModel((UsuarioRegistrado) prestamo.getUsuario());
        return new PrestamoEntity(prestamo.getId(), prestamo.getCapital(), prestamo.getInteres(), prestamo.getFrecuenciaDePagoEnMeses(), prestamo.getFrecuenciaDePagoEnMeses(), prestamo.getTipoPrestamo(),  usuarioRegistrado);

    }

    public Prestamo toDomainModel(Prestamo prestamo){
        if (prestamo instanceof Hipoteca) {
            return new Hipoteca(this.id, this.capital, this.interes, this.frecuenciaDePagoEnMeses, this.plazoDeAmortizacionEnMeses, this.tipoDePrestamo, this.usuarioRegistradoEntity.toDomainModel());
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

    public UsuarioRegistradoEntity getUsuario() {
        return usuarioRegistradoEntity;
    }

    public void setUsuario(UsuarioRegistradoEntity usuarioRegistradoEntity) {
        this.usuarioRegistradoEntity = usuarioRegistradoEntity;
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
                ", usuarioRegistradoEntity=" + usuarioRegistradoEntity +
                '}';
    }
}
