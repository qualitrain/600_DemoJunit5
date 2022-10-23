package qtx.test.jupiter.servicios;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import qtx.negocio.Cliente;
import qtx.negocio.StatusCte;
import qtx.servicios.ClienteSuspendidoException;
import qtx.servicios.IGestorClientes;
import qtx.servicios.ServicioComercial;
import qtx.util.Fecha;

@ExtendWith(MockitoExtension.class)
public class ServicioComercialTest {
	@Mock
	private IGestorClientes gCtes;
	@InjectMocks
	private ServicioComercial sComercial;
	
	@BeforeEach
	public void prepararTestI() {
	}
	
	@Test
	public void testGenerarVenta_CteSuspendido() {
		Cliente cte = 
				new Cliente("Jorge Valle De la Cruz", Fecha.getDateDDMMAAAA(5, 2, 1999), 
						     3, StatusCte.SUSPENDIDO);
		
		when(gCtes.getXId(cte.getId()))
		    .thenReturn(cte);

		
		List<String> cvesArt = Arrays.asList( new String[]{"C-1","C-2"} );
		List<Integer> cants = Arrays.asList( new Integer[] {4,2} );
		
		assertThrows(ClienteSuspendidoException.class, ()-> {
			this.sComercial.generarVenta(cte.getId(), cvesArt, cants, 5);			
		});
		
		// Probando que hace verify: Checa que se haya llamado al mock gCtes una vez con el argumento dado. Si no es así lanza una excepción
		verify(gCtes).getXId(cte.getId());
		verify(gCtes).getXId(anyLong());
		// Probando que hace verify
		// verify(gCtes).insertarUno(cte);
	}
	
	
}
