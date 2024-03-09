package usuarios.dominio.modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import prestamos.dominio.modelos.Prestamo;

class UsuarioTest {

    private Usuario usuario;
    private List<Prestamo> prestamos;

    @BeforeEach
    void setUp() {
        prestamos = new ArrayList<Prestamo>();
        usuario = new Usuario("test@test.com", "Test", "password", prestamos);
    }

    @Test
    void testSetEmail() {
        usuario.setEmail("test@test.com");
        assertEquals("test@test.com", usuario.getEmail());
    }

    @Test
    void testGetNombre() {
        assertEquals("Test", usuario.getNombre());
    }

    @Test
    void testSetNombre() {
        usuario.setNombre("Test");
        assertEquals("Test", usuario.getNombre());
    }

    @Test
    void testGetPrestamos() {
        assertEquals(prestamos, usuario.getPrestamos());
    }

    @Test
    void testSetPrestamos() {
        List<Prestamo> newPrestamos = new ArrayList<Prestamo>();
        usuario.setPrestamos(newPrestamos);
        assertEquals(newPrestamos, usuario.getPrestamos());
    }

    @Test
    void testGetContraseña() {
        assertEquals("password", usuario.getPassword());
    }

    @Test
    void testSetContraseña() {
        usuario.setPassword("newPassword");
        assertEquals("newPassword", usuario.getPassword());
    }

    @Test
    void testGetId() {
        assertEquals(0, usuario.getId()); // Assuming the id is 0 by default
    }

    @Test
    void testSetId() {
        usuario.setId(1);
        assertEquals(1, usuario.getId());
    }

    @Test
    void testToString() {
        String expected = "Usuario [ id=0, contraseña=password, email=test@test.com, nombre=Test, prestamos=[]]";
        assertEquals(expected, usuario.toString());
    }
}