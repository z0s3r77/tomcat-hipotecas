package usuarios.dominio.puertos.out;

import java.util.List;
import java.util.Optional;

import usuarios.dominio.modelos.UsuarioComportamiento;

public interface UsuarioRepositoryPort {

	
	UsuarioComportamiento save(UsuarioComportamiento usuario);
	Optional<UsuarioComportamiento> findById(int id);
	List<UsuarioComportamiento> findAll();
	Optional<UsuarioComportamiento> update(UsuarioComportamiento usuario);
	boolean deleteById(int id);
	Optional<UsuarioComportamiento> findByEmail(String email);
}
