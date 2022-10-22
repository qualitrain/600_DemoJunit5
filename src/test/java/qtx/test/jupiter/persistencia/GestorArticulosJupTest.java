package qtx.test.jupiter.persistencia;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import qtx.negocio.Articulo;
import qtx.persistencia.GestorArticulosFake;
import qtx.persistencia.GestorArticulosMemoria;
import qtx.persistencia.PersistenciaException;
import qtx.servicios.IGestorArticulos;

class GestorArticulosJupTest {
	private static IGestorArticulos gestorArticulos;
	private String nomTest = ""; 
	private static int nTest = 0;

	@BeforeAll
	public static void prepararTests() {
//		gestorArticulos = new GestorArticulosFake();
		gestorArticulos = new GestorArticulosMemoria();
		gestorArticulos.borrarUno("JG-1");
		gestorArticulos.borrarUno("JG-2");
		System.out.println("================================================");
		System.out.println("      Pruebas (Jupiter) GestorArticulos...      ");
		System.out.println("================================================\n");
	}
	@AfterAll
	public static void finalizarTests() {
		System.out.println("\n========= Fin pruebas Gestor Articulos =========\n");		
	}
	@Test
	@Tag("Humo")
	void testGetIdsTodos() {
		nomTest+="testGetIdsTodos... ";
		
		//Dados
		assumeTrue(gestorArticulos != null);
		
		assumingThat(gestorArticulos instanceof GestorArticulosMemoria,
		()->{
		
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
		});
		nomTest += "OK";
	}
	@Nested
	@DisplayName("Operaciones CRUD sobre Articulo")
	class CrudTest {
		
		public CrudTest() {
			System.out.println("CrudTest()");
		}
		
		@Test
		@DisplayName("Insercion Simple")
		@Tag("UpdateBD")
		@Tag("Humo")
		public void testInsertarUno() {
			nomTest += "insertarTest";
			String idArt = "BC-CC";
			assumeTrue(gestorArticulos != null);
			Articulo art = new Articulo(idArt, "Block carta", "75 Hjs, carta, cuadro chico", 35f, 70f);
			assumeTrue(gestorArticulos.getXId(idArt)==null);
			gestorArticulos.insertarUno(art);
			Articulo artRec = gestorArticulos.getXId(idArt);
			assertEquals(art, artRec);
			nomTest += "... OK";
		}
		@Test
		@DisplayName("Lectura X ID")
		public void testGetXid() {
			nomTest += "leerXidTest";
			String idArt = "BC-CG";
			assumeTrue(gestorArticulos != null);
			Articulo art = new Articulo(idArt, "Block carta", "75 Hjs, carta, cuadro grande", 34.99f, 70.50f);
			assumeTrue(gestorArticulos.getXId(idArt)==null);
			gestorArticulos.insertarUno(art);
			Articulo artRec = gestorArticulos.getXId(idArt);
			assertEquals(art, artRec);			
			nomTest += "... OK";
		}
		@Test
		@DisplayName("Actualizacion de objeto pre-existente")
		@Tag("UpdateBD")
		public void actualizarTest() {
			nomTest += "testActualizarUno";
			String idArt = "BC-R";
			assumeTrue(gestorArticulos != null);
			Articulo art = new Articulo(idArt, "Block carta", "75 Hjs, carta, rayado", 33.99f, 71.50f);
			assumeTrue(gestorArticulos.getXId(idArt)==null);
			gestorArticulos.insertarUno(art);
			Articulo artModif = new Articulo(idArt, "Block carta", "75 Hjs, carta, rayado", 34.00f, 71.50f);
			Articulo artAnt = gestorArticulos.actualizarUno(artModif);
			assertTrue(artAnt != null);
			assertNotEquals(artModif, artAnt);		
			nomTest += "... OK";
		}
		@Test
		@DisplayName("Eliminacion de objeto pre-existente")
		@Tag("UpdateBD")
		public void testBorrarUno() {
			nomTest += "eliminarTest";
			String idArt = "BC-B";
			assumeTrue(gestorArticulos != null);
			Articulo art = new Articulo(idArt, "Block carta", "75 Hjs, carta, blanco", 30.99f, 66.50f);
			assumeTrue(gestorArticulos.getXId(idArt)==null);
			gestorArticulos.insertarUno(art);
			art = gestorArticulos.getXId(idArt);
			assumeTrue(art!=null);
			int n = gestorArticulos.borrarUno(idArt);
			assertEquals(1, n);
			art = gestorArticulos.getXId(idArt);
			assertNull(art);
			nomTest += "... OK";
		}
		@Test
		@DisplayName("Insercion de duplicados")
		@Tag("UpdateBD")
		public void testInsertarUno_duplicado() {
			nomTest += "testInsertarUno_duplicado";
			
			assumeTrue(gestorArticulos != null);
			
			Articulo art = new Articulo("JG-2", "Juego Geometr�a","Juego Geometria profesional",160.5f,401.10f);
			gestorArticulos.insertarUno(art);
			Executable funInsertarDuplicado = () -> gestorArticulos.insertarUno(art);
			assertThrows(PersistenciaException.class, funInsertarDuplicado, "No lanza la excepcion esperada");
			nomTest += "... OK";
		}
		@Test
		@Tag("UpdateBD")
		@DisplayName("Insercion de varios objetos")
		@Disabled("Deshabilitada hasta que sea implementada por todas las implementaciones de IGestorArticulos")
		public void testInsertarMuchos() {
			nomTest += "testInsertarMuchos";
			
			assumeTrue(gestorArticulos != null);
			
			Articulo art1 = new Articulo("GM-B", "Goma Bicolor","Goma de borrar para lapiz y tinta",14.5f,35f);
			Articulo art2 = new Articulo("GM-M", "Goma Migajon","Goma de borrar profesional para dibujo",12.5f,25f);
			Articulo art3 = new Articulo("GM-BC", "Goma Blanca","Goma de borrar est�ndar blanca",10.3f,20.25f);
			Map<Articulo, Integer> res = gestorArticulos.insertarMuchos(Arrays.asList(new Articulo[] {art1, art2, art3}));
			assertEquals(3, res.size());
			nomTest += "... OK";
		}

		// ==== Pruebas parametrizadas ====
		
		@ParameterizedTest(name = "Num {index} - {0}" )
//		@EmptySource
//		@NullSource
		@NullAndEmptySource
		@ValueSource(strings = {" "})
		@DisplayName("Lectura X ID con llave nula o vacia")
		public void testGetXid(String idArt) {
			nomTest += "testGetXid_null_vacio " + "idArt=[" + idArt + "]";
			
			//Dados 
			assumeTrue(gestorArticulos != null);
			//Cuando
			Articulo artRec = gestorArticulos.getXId(idArt);
			//Entonces
			assertNull(artRec);			
			nomTest += "... OK";
		}
				
	}
	
	static Stream<String> getLLavesTest(){
		return gestorArticulos.getIdsTodos().stream();
	}
	@ParameterizedTest(name="Num {index} - Prueba con id = {0}")
    @MethodSource("getLLavesTest")
	@DisplayName("Leemos todos los ids")
	public void testGetXid_todos(String idArt) {
		nomTest += "testGetXid_todos";
		
		//Dados
		assumeTrue(gestorArticulos != null);
		//Cuando
		Articulo artRec = gestorArticulos.getXId(idArt);
		//Entonces
		assertNotNull(artRec);			
		nomTest += "... OK";		
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
