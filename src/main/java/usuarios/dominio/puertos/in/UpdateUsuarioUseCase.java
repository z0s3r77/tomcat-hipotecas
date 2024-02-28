package usuarios.dominio.puertos.in;

import java.util.Optional;

import usuarios.dominio.modelos.Usuario;

public interface UpdateUsuarioUseCase {

	
	Optional<Usuario> updatesUsuario(Long id, Usuario usuarioActualizado);
	
}

