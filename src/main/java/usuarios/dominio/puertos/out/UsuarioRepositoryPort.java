package usuarios.dominio.puertos.out;

import java.util.List;
import java.util.Optional;

import usuarios.dominio.modelos.Usuario;

public interface UsuarioRepositoryPort {

	
	Usuario save(Usuario usuario);
	Optional<Usuario> findById(int id);
	List<Usuario> findAll();
	Optional<Usuario> update(Usuario usuario);
	boolean deleteById(int id);
	Optional<Usuario> findByEmail(String email);
}
