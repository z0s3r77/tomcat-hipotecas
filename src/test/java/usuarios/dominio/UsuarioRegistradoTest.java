package usuarios.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.Prestamo;
import usuarios.aplicacion.UsuarioRegistrado;

class UsuarioRegistradoTest {

 final String email = "usuario@example.com";
 final String nombre = "Usuario Ejemplo";
 final List<Prestamo> prestamos = new ArrayList<>();

 @Test
 void testUsuarioRegistradoEmptyConstructor() {

     UsuarioRegistrado usuario = new UsuarioRegistrado();

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
