package usuarios.dominio.puertos.in;

import java.util.List;
import java.util.Optional;

import usuarios.dominio.modelos.UsuarioComportamiento;

public interface RetriveUsuarioUseCase {
	
	Optional<UsuarioComportamiento> getUsuarioById(int id);
	List<UsuarioComportamiento> getAllUsuario();
	Optional<UsuarioComportamiento> getUsuarioByEmail(String email);

}
