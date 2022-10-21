package qtx.test.jupiter.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import qtx.negocio.Util;

class UtilJupTest {
	private static int nTest = 0;

	@Test
	@Tag("Humo")
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
	
	@RepeatedTest(5)
	@DisplayName("testEvaluarUtilidad con @Repeated")
	void testEvaluarUtilidad(RepetitionInfo repInfo) {
		System.out.println("testEvaluarUtilidad_rep " + repInfo.getCurrentRepetition() + "/" 
	                                                  + repInfo.getTotalRepetitions()); 
		float precio = 100 * repInfo.getCurrentRepetition();
		float costo = 99 * repInfo.getCurrentRepetition();
		
		assertEquals("Perdida", Util.evaluarUtilidad(precio, costo, 0.2, 0.5));
	}
	
	@BeforeEach
	void preProcesarTest() {
		nTest++;
		System.out.println("Antes del test " + nTest);
	}
	
	@AfterEach
	void postProcesarTest() {
		System.out.println("Despues del test " + nTest + "\n");
	}

}
