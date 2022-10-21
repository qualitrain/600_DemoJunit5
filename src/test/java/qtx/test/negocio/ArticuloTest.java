package qtx.test.negocio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import qtx.negocio.Articulo;

public class ArticuloTest {
	
	//Dados		
	private Articulo art = null;
	private String testI = "";

	@BeforeEach
	public void preTest() {
		System.out.println();
		System.out.println("Antes...");
		//Cuando
		art = new Articulo("X-1","Buje","Buje Ford F-150 2004",782.76f, 1500);
	}
	@AfterEach
	public void postTest() {
		System.out.println("Despues...");
		System.out.println(testI);
	}
	
	@Test
	public void testCrearArticulo() {
		testI = "testCrearArticulo...";
		
		//Entonces
		assertEquals(782.76, art.getCosto(), 0.0001);
		assertEquals(1500, art.getPrecio(), 0.0001);
		
		System.out.println(art);		
		testI += " OK";
	}
	
	@Test
	public void testPropCosto() {
		testI = "testPropCosto...";

		//Cuando
		art.setCosto(535.99f);
		
		//Entonces
		assertEquals(535.99, art.getCosto(), 0.0001);
		
		System.out.println(art);
		testI += " OK";
	}

	@Test
	public void testPropPrecio() {
		testI = "testPropPrecio...";

		//Cuando
		art.setPrecio(955.99f);	
		
		//Entonces
		assertEquals(955.99, art.getPrecio(), 0.0001);
		
		System.out.println(art);
		testI += " OK";
	}

}
