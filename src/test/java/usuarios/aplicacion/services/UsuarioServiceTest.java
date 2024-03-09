package usuarios.aplicacion.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.puertos.in.CreateUsuarioUseCase;
import usuarios.dominio.puertos.in.DeleteUsuarioUseCase;
import usuarios.dominio.puertos.in.RetriveUsuarioUseCase;
import usuarios.dominio.puertos.in.UpdateUsuarioUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


class UsuarioServiceTest {

    private UsuarioService usuarioService;
    private CreateUsuarioUseCase createUsuarioUseCase;
    private DeleteUsuarioUseCase deleteUsuarioUseCase;
    private RetriveUsuarioUseCase retriveUsuarioUseCase;
    private UpdateUsuarioUseCase updateUsuarioUseCase;

    @BeforeEach
    void setUp() {
        createUsuarioUseCase = Mockito.mock(CreateUsuarioUseCase.class);
        deleteUsuarioUseCase = Mockito.mock(DeleteUsuarioUseCase.class);
        retriveUsuarioUseCase = Mockito.mock(RetriveUsuarioUseCase.class);
        updateUsuarioUseCase = Mockito.mock(UpdateUsuarioUseCase.class);

        usuarioService = new UsuarioService(createUsuarioUseCase, deleteUsuarioUseCase, retriveUsuarioUseCase, updateUsuarioUseCase);
    }

    @Test
    void testCreateUsuario() {
        Usuario usuario = new Usuario();
        when(createUsuarioUseCase.createUsuario(usuario)).thenReturn(usuario);

        Usuario result = usuarioService.createUsuario(usuario);

        assertEquals(usuario, result);
    }

    @Test
    void testUpdatesUsuario() {
        Long id = 1L;
        Usuario usuarioActualizado = new Usuario();
        when(updateUsuarioUseCase.updatesUsuario(id, usuarioActualizado)).thenReturn(Optional.of(usuarioActualizado));

        Optional<Usuario> result = usuarioService.updatesUsuario(id, usuarioActualizado);

        assertTrue(result.isPresent());
        assertEquals(usuarioActualizado, result.get());
    }

    @Test
    void testGetUsuarioById() {
        int id = 1;
        Usuario usuario = new Usuario();
        when(retriveUsuarioUseCase.getUsuarioById(id)).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = usuarioService.getUsuarioById(id);

        assertTrue(result.isPresent());
        assertEquals(usuario, result.get());
    }

    @Test
    void testGetAllUsuario() {
        List<Usuario> usuarios = new ArrayList<>();
        when(retriveUsuarioUseCase.getAllUsuario()).thenReturn(usuarios);

        List<Usuario> result = usuarioService.getAllUsuario();

        assertEquals(usuarios, result);
    }

    @Test
    void testDeleteUsuario() {
        int id = 1;
        when(deleteUsuarioUseCase.deleteUsuario(id)).thenReturn(true);

        boolean result = usuarioService.deleteUsuario(id);

        assertTrue(result);
    }

    @Test
    void testGetUsuarioByEmail() {
        String email = "test@test.com";
        Usuario usuario = new Usuario();
        when(retriveUsuarioUseCase.getUsuarioByEmail(email)).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = usuarioService.getUsuarioByEmail(email);

        assertTrue(result.isPresent());
        assertEquals(usuario, result.get());
    }
}