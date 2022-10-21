package qtx.test.negocio;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import qtx.negocio.DetalleVenta;
import qtx.negocio.NegocioException;
import qtx.negocio.Venta;

public class VentaTest {
	private String precioUnitarioDet1 = "795.50";
	private String precioUnitarioDet2 = "1200.75";
	private String nombreTest = "";

	private Venta getVentaTest() {
		Venta venta10 = new Venta();
		venta10.setNumVenta(10);
		venta10.setNumCte(501);
		venta10.setFecVta(new Date());
		
		DetalleVenta detI = new DetalleVenta(10,1,2,"X-4",new BigDecimal(precioUnitarioDet1));
		venta10.agregarDetalle(detI);
		
		detI = new DetalleVenta(10,2,1,"YF1231",new BigDecimal(precioUnitarioDet2));
		venta10.agregarDetalle(detI);
		 return venta10;
	}
	
	@AfterEach
	public void mostrarResultadoTest() {
		System.out.println(this.nombreTest);
	}
	@BeforeEach
	public void saltarLinea() {
		System.out.println(this.nombreTest);
	}
	
	@Test
	public void testCrearVenta() {
		this.nombreTest = "testCrearVenta";
		Venta venta10 = getVentaTest();
		if (venta10.getDetalleVenta(0).getCantidad() != 2)
			fail("La cantidad de DetalleVenta[0] no corresponde con la asignada en la creaci�n");
		
		if (!venta10.getDetalleVenta(1).getPrecioUnitario().toString().equals(precioUnitarioDet2))
			fail("El precio unitario de DetalleVenta[1] es "
					+ "inconsistente con el asignado en la creaci�n: "
					+ venta10.getDetalleVenta(1).getPrecioUnitario().toString() 
					+ " VS " + precioUnitarioDet2);

		if (venta10.getNumDetalles() != 2)
			fail("La cantidad de instancias de DetalleVenta es "
					+ "inconsistente con las creadas: "
					+ venta10.getNumDetalles() 
					+ " VS " + 2);

		System.out.println(venta10);
		this.nombreTest += "... OK";
	}

	@Test
	public void testCrearDetalleVenta() {
		this.nombreTest = "testCrearDetalleVenta";
		
		String cveArtTest = "X-4";
		String precioTest = "795.50";
		DetalleVenta detI = new DetalleVenta(101,1,2,cveArtTest,new BigDecimal(precioTest));
		if(detI.getNumVenta() != 101)
			fail("Propiedad NumVenta err�nea: getter vs constructor");
		if(detI.getNumDetalle() != 1)
			fail("Propiedad NumDetalle err�nea: getter vs constructor");
		if(detI.getCantidad() != 2)
			fail("Propiedad Cantidad err�nea: getter vs constructor");
		if(!detI.getCveArticulo().equals(cveArtTest))
			fail("Propiedad CveArticulo err�nea: getter vs constructor");
		if(!detI.getPrecioUnitario().toString().equals(precioTest))
			fail("Propiedad PrecioUnitario err�nea: getter vs constructor");
		System.out.println(detI);
		this.nombreTest += "... OK";
	}
	
	@Test
	public void testGetDetalleVenta_Inexistente() {
		this.nombreTest = "testGetDetalleVenta_Inexistente";
		
		//dado
		Venta venta10 = getVentaTest();
		assumeTrue(venta10.getNumDetalles() < 20);
		
		//cuando
		Executable funConsultaDetalleInexistente = () ->  { 
			   DetalleVenta detVta20 = venta10.getDetalleVenta(19);
			   System.out.println(detVta20);
			};
				
		//entonces
		assertThrows(NegocioException.class, funConsultaDetalleInexistente);
		
		this.nombreTest += "... OK";
	}
	
	
}
