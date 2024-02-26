package hipotecas.dominio;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import prestamos.dominio.modelos.Hipoteca;
import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.out.PrestamoRepositoryPort;


public class PrestamoRepositoryPortTest {
	
	
	private PrestamoRepositoryPort prestamoRepositoryPortMock;
	
	@BeforeEach
	void setUp() {
		prestamoRepositoryPortMock = mock(PrestamoRepositoryPort.class);
	}
	
	
	@Test
	void testGuardarPrestamo() {
		
		Prestamo prestamo = new Hipoteca();
		
		doNothing().when(prestamoRepositoryPortMock).save(prestamo);
        prestamoRepositoryPortMock.save(prestamo);
      
        verify(prestamoRepositoryPortMock, times(1)).save(prestamo);
	}
	
	@Test
	void testEliminarPrestamo() {
		
		Prestamo prestamo = new Hipoteca();

        doNothing().when(prestamoRepositoryPortMock).deletePrestamo(prestamo);
	
        prestamoRepositoryPortMock.deletePrestamo(prestamo);
        
        verify(prestamoRepositoryPortMock, times(1)).deletePrestamo(prestamo);
        
	}
	
	
	@Test
	void testObtenerTodosLosPrestamosDeUnUsuario() {
		
		String usuarioEmail = "email"; 
		List<Prestamo> prestamosDeUnUsuario = new ArrayList<Prestamo>();
    
		when(prestamoRepositoryPortMock.getAllPrestamosfromUsuario(usuarioEmail)).thenReturn(prestamosDeUnUsuario);
        
		List<Prestamo> prestamos = prestamoRepositoryPortMock.getAllPrestamosfromUsuario(usuarioEmail);
        verify(prestamoRepositoryPortMock, times(1)).getAllPrestamosfromUsuario(usuarioEmail);
        
        assertNotNull(prestamos);
        
	}
	

}
