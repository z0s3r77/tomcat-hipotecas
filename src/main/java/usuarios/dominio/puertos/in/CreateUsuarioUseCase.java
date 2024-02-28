package usuarios.dominio.puertos.in;

import usuarios.dominio.modelos.UsuarioComportamiento;

public interface CreateUsuarioUseCase {

	UsuarioComportamiento createUsuario(UsuarioComportamiento usuario);
	
}
