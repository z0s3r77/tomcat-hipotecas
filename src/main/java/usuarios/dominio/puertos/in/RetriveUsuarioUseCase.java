package usuarios.dominio.puertos.in;

import java.util.List;
import java.util.Optional;

import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.modelos.UsuarioComportamiento;

public interface RetriveUsuarioUseCase {
	
	Optional<Usuario> getUsuarioById(int id);
	List<Usuario> getAllUsuario();
	Optional<Usuario> getUsuarioByEmail(String email);


}
