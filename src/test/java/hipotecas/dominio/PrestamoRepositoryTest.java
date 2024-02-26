package hipotecas.dominio;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import prestamos.dominio.modelos.Hipoteca;
import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.PrestamoRepository;


public class PrestamoRepositoryTest {
	
	
	private PrestamoRepository prestamoRepositoryMock;
	
	@BeforeEach
	void setUp() {
		prestamoRepositoryMock = mock(PrestamoRepository.class);
	}
	
	
	@Test
	void testGuardarPrestamo() {
		
		Prestamo prestamo = new Hipoteca();
		
		doNothing().when(prestamoRepositoryMock).guardarPrestamo(prestamo);
        prestamoRepositoryMock.guardarPrestamo(prestamo);
      
        verify(prestamoRepositoryMock, times(1)).guardarPrestamo(prestamo);
	}
	
	@Test
	void testEliminarPrestamo() {
		
		Prestamo prestamo = new Hipoteca();

        doNothing().when(prestamoRepositoryMock).eliminarPrestamo(prestamo);
	
        prestamoRepositoryMock.eliminarPrestamo(prestamo);
        
        verify(prestamoRepositoryMock, times(1)).eliminarPrestamo(prestamo);
        
	}
	
	
	@Test
	void testObtenerTodosLosPrestamosDeUnUsuario() {
		
		String usuarioEmail = "email"; 
		List<Prestamo> prestamosDeUnUsuario = new ArrayList<Prestamo>();
    
		when(prestamoRepositoryMock.obtenerTodosLosPrestamosDeUnUsuario(usuarioEmail)).thenReturn(prestamosDeUnUsuario);
        
		List<Prestamo> prestamos = prestamoRepositoryMock.obtenerTodosLosPrestamosDeUnUsuario(usuarioEmail);
        verify(prestamoRepositoryMock, times(1)).obtenerTodosLosPrestamosDeUnUsuario(usuarioEmail);
        
        assertNotNull(prestamos);
        
	}
	

}
