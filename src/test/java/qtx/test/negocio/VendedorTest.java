package qtx.test.negocio;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import qtx.negocio.Vendedor;

public class VendedorTest {
	private Vendedor vend;
	private String testI = "";
	
	@BeforeEach
	public void prepararTests() {
		vend = new Vendedor();
		vend.setId(678);
		vend.setApPaterno("Dominguez");
		vend.setApMaterno("Romano");
		vend.setNombres("Jorge Alberto");
		vend.setCuotaMes(50000);
	}
	
	@AfterEach
	public void mostrarResultadoTest() {
		System.out.println(this.testI);
	}

	@Test
	public void testCrearVendedor() {
		this.testI = "testCrearVendedor...";
		assertEquals(vend.getNombreCompleto(),"Jorge Alberto Dominguez Romano"); // invoca a equals
		this.testI += " OK";
	}

}
