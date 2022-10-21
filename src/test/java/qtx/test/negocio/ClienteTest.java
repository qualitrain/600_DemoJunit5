package qtx.test.negocio;


import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import qtx.negocio.Cliente;

public class ClienteTest {

	@Test
	public void testCrearCliente() {
		
		//Dados
		String nomCte = "Jorge Ramirez Bedolla";
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(GregorianCalendar.DAY_OF_MONTH, 26);
		gc.set(GregorianCalendar.MONTH, 4);
		gc.set(GregorianCalendar.YEAR, 1999);
		
		//Cuando		
		Cliente cte = new Cliente(nomCte, gc.getTime(), 10001);
		
		
		//Entonces
		assertTrue(cte.getNombre().equals(nomCte));
		
		gc.setTime( cte.getFecNac() );
		int dia = gc.get(GregorianCalendar.DAY_OF_MONTH);
		int mes = gc.get(GregorianCalendar.MONTH);
		int anio = gc.get(GregorianCalendar.YEAR);
		
		assertEquals(26, dia);
		assertEquals(4, mes);
		assertEquals(1999, anio);
		
		System.out.println("testCrearCliente OK");
	}

}
