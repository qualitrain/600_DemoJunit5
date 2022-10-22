package qtx.test.jupiter.negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import qtx.negocio.Util;

class UtilJupTest {
	private static int nTest = 0;

	@Test
	@Tag("Humo")
	@Timeout(value = 5,unit = TimeUnit.MICROSECONDS)
	@DisplayName("testEvaluarUtilidad con assertAll")
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
	
	// Se alimenta un test con UN SOLO parametro
	@ParameterizedTest(name = "No. {index} - Se ejecuta la prueba con precio = {0}")
	@ValueSource(floats = { 50f, 60f, 99f, 100f })
	@DisplayName("testEvaluarUtilidad_ValueSource con un solo parametro")
	void testEvaluarUtilidad_ValueSource(float precio) {
		System.out.println("testEvaluarUtilidad_ValueSource");
		assertEquals("Perdida", Util.evaluarUtilidad(100, precio, 0.2, 0.5));
	}
		
	//================== Pruebas parametrizadas de varios parámetros ==================
	
	@ParameterizedTest(name = "No. {index} - Se ejecuta la prueba con costo = {0}, precio = {1} y resultado esperado = {2}")
	@MethodSource("getParamsTestEvaluarUtilidad")
	@DisplayName("testEvaluarUtilidad con 3 parametros y @MethodSource + Stream<Arguments>")
	public void testEvaluarUtilidad(double costo, double precio, String resul) {
		System.out.println("testEvaluarUtilidad_param_multi");
		assertEquals(resul,Util.evaluarUtilidad(costo, precio, 0.2, 0.5));
	}
	
	public static Stream<Arguments> getParamsTestEvaluarUtilidad(){
		//dados
		double costo = 100.0f;
		
		return Stream.of(
					Arguments.arguments(costo, costo * 0.99, "Perdida"),
					Arguments.arguments(costo, costo * 1.0, "Perdida"),
					Arguments.arguments(costo, costo * 1.15, "UtilidadBaja"),
					Arguments.arguments(costo, costo * 1.20, "UtilidadBaja"),
					Arguments.arguments(costo, costo * 1.21, "UtilidadMedia"),
					Arguments.arguments(costo, costo * 1.50, "UtilidadMedia"),
					Arguments.arguments(costo, costo * 1.51, "UtilidadAlta"),
					Arguments.arguments(costo, costo * 2.0, "UtilidadAlta")
				);
	}
	
	//-----------------------------------------------------------------------------------
	
	@ParameterizedTest(name = "No. {index} - Se ejecuta la prueba con costo = {0}, precio = {1} y utilidadEsperada = {2}")
	@CsvSource({
		"200, 199, Perdida",
		"200, 200, Perdida",
		"200, 220, UtilidadBaja",
		"200, 240, UtilidadBaja"
	})
	@DisplayName("testEvaluarUtilidad con 3 parametros y @CsvSource")
	public void testEvaluarUtilidad02(float costo, float precio, String resul) {
		System.out.println("testEvaluarUtilidad_param_multi_02");
		assertEquals(resul,Util.evaluarUtilidad(costo, precio, 0.2, 0.5));
	}

	//-----------------------------------------------------------------------------------
	
	@ParameterizedTest(name = "No. {index} - Se ejecuta la prueba con costo = {0}, precio = {1} y utilidadEsperada = {2}")
	@CsvFileSource(resources="/paramTestEvaluarUtilidad03.csv")
	@DisplayName("testEvaluarUtilidad con 3 parametros y @CsvFileSource")
	public void testEvaluarUtilidad03(float costo, float precio, String resul) {
		System.out.println("testEvaluarUtilidad_param_multi_02");
		assertEquals(resul,Util.evaluarUtilidad(costo, precio, 0.2, 0.5));
	}

	//===================================================================================================
	
	
	@BeforeEach
	@Timeout(value = 85,unit = TimeUnit.MICROSECONDS)
	void preProcesarTest() {
		nTest++;
		System.out.println("Antes del test " + nTest);
	}
	
	@AfterEach
	void postProcesarTest() {
		System.out.println("Despues del test " + nTest + "\n");
	}

}
