package qtx.test.jupiter.persistencia;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import qtx.negocio.Articulo;
import qtx.persistencia.GestorArticulos;
import qtx.persistencia.PersistenciaException;

class GestorArticulosJupTest {
	private static GestorArticulos gestorArticulos;
	private String nomTest = ""; 
	private static int nTest = 0;

	@AfterAll
	public static void finalizarTests() {
		System.out.println("\n========= Fin pruebas Gestor Articulos =========\n");		
	}
	@Test
	void testGetIdsTodos() {
		nomTest+="testGetIdsTodos... ";
		
		//Dados
		assumeTrue(gestorArticulos != null);
		
		List<String> llavesEsp = Arrays.asList(new String[] {"CPB-100","CPCG-200","CPCC-100","JC-24","L-1"})
				                       .stream()
				                       .sorted()
				                       .collect(Collectors.toList());
		//Cuando
		List<String> llaves = gestorArticulos.getIdsTodos()
				                             .stream()
				                             .sorted()
						                     .collect(Collectors.toList());
		//Entonces
		assertIterableEquals(llavesEsp, llaves, "Las llaves no son las esperadas");
		nomTest += "OK";
	}
	@Test
	@DisplayName("Probando la insercion de duplicados en GestorArticulos")
	public void testInsertarUno_duplicado() {
		this.nomTest += "testInsertarUno_duplicado";
		
		//Dados
		assumeTrue(gestorArticulos != null);
		Articulo art = new Articulo("JG-2", "Juego Geometria","Juego Geometria profesional",160.5f,401.10f);
		gestorArticulos.insertarUno(art);
		
		//Cuando
		Executable funInsertarDuplicado = () -> gestorArticulos.insertarUno(art);
		
		
		//Entonces
		assertThrows(PersistenciaException.class, funInsertarDuplicado, "No lanza la excepcion esperada");
		
		this.nomTest += "... OK";
	}
	
	@AfterEach
	public void mostrarFinTestI() {
		System.out.println(this.nomTest);
	}
	@BeforeEach
	public void inicioTest() {
		nTest++;
		this.nomTest = nTest + ". ";
	}

}
