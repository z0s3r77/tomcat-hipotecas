package usuarios.infraestructura.entities;

import org.junit.jupiter.api.Test;
import prestamos.dominio.modelos.Prestamo;
import usuarios.dominio.modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioEntityTest {

    @Test
    void testEmptyConstructor() {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        assertNotNull(usuarioEntity);
    }

    @Test
    void testSetters() {
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setId(1);
        usuarioEntity.setPassword("password");
        usuarioEntity.setEmail("test@test.com");
        usuarioEntity.setNombre("Test");
        List<Prestamo> prestamos = new ArrayList<>();
        usuarioEntity.setPrestamos(prestamos);

        assertEquals(1, usuarioEntity.getId());
        assertEquals("password", usuarioEntity.getPassword());
        assertEquals("test@test.com", usuarioEntity.getEmail());
        assertEquals("Test", usuarioEntity.getNombre());
        assertEquals(prestamos, usuarioEntity.getPrestamos());
    }

    @Test
    void testFromDomainModel() {
        Usuario usuario = new Usuario(1, "test@test.com", "Test", "password", new ArrayList<>());
        UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(usuario);

        assertEquals(usuario.getId(), usuarioEntity.getId());
        assertEquals(usuario.getEmail(), usuarioEntity.getEmail());
        assertEquals(usuario.getNombre(), usuarioEntity.getNombre());
        assertEquals(usuario.getPassword(), usuarioEntity.getPassword());
        assertEquals(usuario.getPrestamos(), usuarioEntity.getPrestamos());
    }

    @Test
    void testToDomainModel() {
        List<Prestamo> prestamos = new ArrayList<>();
        UsuarioEntity usuarioEntity = new UsuarioEntity(1, "password", "test@test.com", "Test", prestamos);
        Usuario usuario = usuarioEntity.toDomainModel();

        assertEquals(usuarioEntity.getId(), usuario.getId());
        assertEquals(usuarioEntity.getEmail(), usuario.getEmail());
        assertEquals(usuarioEntity.getNombre(), usuario.getNombre());
        assertEquals(usuarioEntity.getPassword(), usuario.getPassword());
        assertEquals(usuarioEntity.getPrestamos(), usuario.getPrestamos());
    }
}