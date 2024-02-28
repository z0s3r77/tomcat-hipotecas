package usuarios.dominio.puertos.in;

import java.util.Optional;

import usuarios.dominio.modelos.UsuarioComportamiento;

public interface UpdateUsuarioUseCase {

	
	Optional<UsuarioComportamiento> updatesUsuario(Long id, UsuarioComportamiento usuarioActualizado);
	
}

