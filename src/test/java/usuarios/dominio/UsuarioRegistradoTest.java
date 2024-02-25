package usuarios.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import prestamos.dominio.Prestamo;
import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.modelos.UsuarioRegistrado;

class UsuarioRegistradoTest {


	final String ip = "IP";
	final String email = "usuario@example.com";
	final String nombre = "Usuario Ejemplo";
	final List<Prestamo> prestamos = new ArrayList<>();

	@Test
	void testUsuarioRegistradoEmptyConstructor() {
		UsuarioRegistrado usuario = new UsuarioRegistrado();
		assertNotNull(usuario);
	}

	@Test
	void testUsuariRegistradoEsUnUsuario() {
		UsuarioRegistrado usuario = new UsuarioRegistrado();
		assertTrue(usuario instanceof Usuario);
	}
	
	@Test
	void testUsuarioRegistradoIpConstructor() {
		UsuarioRegistrado usuario = new UsuarioRegistrado(ip);
		assertNotNull(usuario);
	}

	@Test
	void testUsuarioRegistradoConstructor() {
		UsuarioRegistrado usuario = new UsuarioRegistrado(email, nombre, prestamos);
		assertNotNull(usuario);
	}

	@Test
	void testUsuarioRegistradoGettersSetters() {

		UsuarioRegistrado usuario = new UsuarioRegistrado();

		usuario.setEmail(email);
		usuario.setNombre(nombre);
		usuario.setPrestamos(prestamos);

		assertEquals(usuario.getEmail(), email);
		assertEquals(usuario.getNombre(), nombre);
		assertEquals(usuario.getPrestamos(), prestamos);
	}
}
