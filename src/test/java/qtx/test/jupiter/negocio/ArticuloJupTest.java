package qtx.test.jupiter.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import qtx.negocio.Articulo;

class ArticuloJupTest {

	@Test
	void testCrearArticulo() {
		String testI = "testCrearArticulo...";
		System.out.println(testI);
		Articulo art = null;
		art = new Articulo("X-25","Block","Block Carta 75 hjs Rayado",23.50f, 70.15f);
		
		assertEquals(23.5, art.getCosto(), 0.0001, "costo distinto del esperado");
		assertEquals(70.15, art.getPrecio(), 0.0001, "precio distinto del esperado" );
		testI += "OK";
		System.out.println(testI);
	}
	

}
