package qtx.test.jupiter.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import qtx.negocio.Util;

class UtilJupTest {

	@Test
	void testEvaluarUtilidad() {
		//dados 
		double costo = 100;
		double limSupUtilBaja = 0.2; 
		double limSupUtilMedia = 0.5;
		 
		//cuando, entonces
		assertAll(
				()->assertEquals("Perdida",       Util.evaluarUtilidad(costo, costo * 0.99, limSupUtilBaja, limSupUtilMedia)),
				()->assertEquals("Perdida",       Util.evaluarUtilidad(costo, costo       , limSupUtilBaja, limSupUtilMedia)),
				()->assertEquals("UtilidadBaja",  Util.evaluarUtilidad(costo, costo * 1.15, limSupUtilBaja, limSupUtilMedia)),
				()->assertEquals("UtilidadBaja",  Util.evaluarUtilidad(costo, costo * 1.20, limSupUtilBaja, limSupUtilMedia)),
				()->assertEquals("UtilidadMedia", Util.evaluarUtilidad(costo, costo * 1.21, limSupUtilBaja, limSupUtilMedia)),
				()->assertEquals("UtilidadMedia", Util.evaluarUtilidad(costo, costo * 1.50, limSupUtilBaja, limSupUtilMedia)),
				()->assertEquals("UtilidadAlta",  Util.evaluarUtilidad(costo, costo * 1.51, limSupUtilBaja, limSupUtilMedia)),
				()->assertEquals("UtilidadAlta",  Util.evaluarUtilidad(costo, costo * 2,    limSupUtilBaja, limSupUtilMedia))
				);
		System.out.println("testEvaluarUtilidad...OK");
    }

}
