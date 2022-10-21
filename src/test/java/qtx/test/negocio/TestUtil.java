package qtx.test.negocio;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import qtx.negocio.Util;

public class TestUtil {

	@Test
	public void testEvaluarUtilidad() {
		String eval = Util.evaluarUtilidad(100, 200, 0.10, 0.5);
		assertEquals("UtilidadAlta", eval);
		System.out.println("testEvaluarUtilidad...OK");
	}

}
