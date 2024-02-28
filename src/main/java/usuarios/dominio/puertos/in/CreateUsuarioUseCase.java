package usuarios.dominio.puertos.in;

import usuarios.dominio.modelos.Usuario;

public interface CreateUsuarioUseCase {

	Usuario createUsuario(Usuario usuario);
	
}
