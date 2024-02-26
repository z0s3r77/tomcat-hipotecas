package prestamos.dominio.puerto.in;

import prestamos.dominio.modelos.Prestamo;

import java.util.List;

public interface RetrivePrestamosUseCase {

    List<Prestamo> getPrestamosFromUsuario(String usuarioEmail);

}
