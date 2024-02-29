package usuarios.dominio.puertos.in;

import java.util.List;
import java.util.Optional;

import usuarios.dominio.modelos.Usuario;

public interface RetriveUsuarioUseCase {
	
	Optional<Usuario> getUsuarioById(int id);
	List<Usuario> getAllUsuario();
	Optional<Usuario> getUsuarioByEmail(String email);

	Optional<Usuario> getUsuarioByEmailAndPassword(String email, String password);
}
