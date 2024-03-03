package usuarios.aplicacion.services;

import java.util.List;
import java.util.Optional;

import usuarios.aplicacion.usecases.CreateUsuarioUseCaseImpl;
import usuarios.aplicacion.usecases.DeleteUsuarioUseCaseImpl;
import usuarios.aplicacion.usecases.RetriveUsuarioUseCaseImpl;
import usuarios.aplicacion.usecases.UpdateUsuarioUseCaseImpl;
import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.puertos.in.CreateUsuarioUseCase;
import usuarios.dominio.puertos.in.DeleteUsuarioUseCase;
import usuarios.dominio.puertos.in.RetriveUsuarioUseCase;
import usuarios.dominio.puertos.in.UpdateUsuarioUseCase;

/**
 * Servicio de usuario que implementa los casos de uso de creación, eliminación, recuperación y actualización de un usuario.
 * Este servicio encapsula la lógica de negocio y delega las operaciones de persistencia a los casos de uso concretos.
 */
public class UsuarioService
		implements CreateUsuarioUseCase, DeleteUsuarioUseCase, RetriveUsuarioUseCase, UpdateUsuarioUseCase {

	private final CreateUsuarioUseCase createUsuarioUseCase;
	private final DeleteUsuarioUseCase deleteUsuarioUseCase;
	private final RetriveUsuarioUseCase retriveUsuarioUseCase;
	private final UpdateUsuarioUseCase updateUsuarioUseCase;

	/**
	 * Constructor del servicio de usuario.
	 * Inicializa las implementaciones concretas de los casos de uso.
	 */
    public UsuarioService() {

        this.createUsuarioUseCase = new CreateUsuarioUseCaseImpl();
        this.deleteUsuarioUseCase = new DeleteUsuarioUseCaseImpl();
        this.retriveUsuarioUseCase = new RetriveUsuarioUseCaseImpl();
        this.updateUsuarioUseCase = new UpdateUsuarioUseCaseImpl();
    }



	@Override
	public Usuario createUsuario(Usuario usuario) {
		
		return createUsuarioUseCase.createUsuario(usuario);
	}

	@Override
	public Optional<Usuario> updatesUsuario(Long id, Usuario usuarioActualizado) {
		
		return updateUsuarioUseCase.updatesUsuario(id, usuarioActualizado);
	}

	@Override
	public Optional<Usuario> getUsuarioById(int id) {

		return retriveUsuarioUseCase.getUsuarioById(id);
	}

	@Override
	public List<Usuario> getAllUsuario() {

		return retriveUsuarioUseCase.getAllUsuario();
	}

	@Override
	public boolean deleteUsuario(int id) {

		return deleteUsuarioUseCase.deleteUsuario(id);
	}

	@Override
	public Optional<Usuario> getUsuarioByEmail(String email) {

		return retriveUsuarioUseCase.getUsuarioByEmail(email);
	}


	@Override
	public Optional<Usuario> getUsuarioByEmailAndPassword(String email, String password) {

		return retriveUsuarioUseCase.getUsuarioByEmailAndPassword(email, password);
	}

}
