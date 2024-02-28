package usuarios.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import prestamos.dominio.modelos.Prestamo;
import usuarios.dominio.modelos.UsuarioComportamiento;
import usuarios.dominio.modelos.Usuario;

class VisitanteInterfazRegistradoTest {


	final String ip = "IP";
	final String email = "usuario@example.com";
	final String nombre = "Usuario Ejemplo";
	final List<Prestamo> prestamos = new ArrayList<>();

	@Test
	void testUsuarioRegistradoEmptyConstructor() {
		Usuario usuario = new Usuario();
		assertNotNull(usuario);
	}

	@Test
	void testUsuariRegistradoEsUnUsuario() {
		Usuario usuario = new Usuario();
		assertTrue(usuario instanceof UsuarioComportamiento);
	}
	
	@Test
	void testUsuarioRegistradoIpConstructor() {
		Usuario usuario = new Usuario(ip);
		assertNotNull(usuario);
	}

	@Test
	void testUsuarioRegistradoConstructor() {
		Usuario usuario = new Usuario(email, nombre, prestamos);
		assertNotNull(usuario);
	}

	@Test
	void testUsuarioRegistradoGettersSetters() {

		Usuario usuario = new Usuario();

		usuario.setEmail(email);
		usuario.setNombre(nombre);
		usuario.setPrestamos(prestamos);

		assertEquals(usuario.getEmail(), email);
		assertEquals(usuario.getNombre(), nombre);
		assertEquals(usuario.getPrestamos(), prestamos);
	}
}
