package qtx.persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qtx.negocio.Articulo;
import qtx.servicios.IGestorArticulos;

public class GestorArticulosMemoria implements IGestorArticulos{
	Map<String,Articulo> bd = getBD();
	
	public List<Articulo> getTodos(){
		List<Articulo> listArts = new ArrayList<Articulo>(bd.values());
		return listArts;
	}

	private static Map<String, Articulo> getBD() {
		Map<String,Articulo> bdMem = new HashMap<String,Articulo>();
		Articulo artI = new Articulo("L-1","Lapiz","Lapiz mediano num 2 Mirado", 2.50f, 5.25f);
		bdMem.put(artI.getCve(), artI);
		artI = new Articulo("CPB-100","Cuaderno profesional","Cuaderno profesionall 100 hjs Blanco", 12.50f, 25.25f);
		bdMem.put(artI.getCve(), artI);
		artI = new Articulo("CPCG-200","Cuaderno profesional","Cuaderno profesionall 200 hjs Cuadro grande ", 22.90f, 47.30f);
		bdMem.put(artI.getCve(), artI);
		artI = new Articulo("CPCC-100","Cuaderno profesional","Cuaderno profesionall 100 hjs Cuadro chico", 12.90f, 26.25f);
		bdMem.put(artI.getCve(), artI);
		artI = new Articulo("JC-24","Juego Colores","Juego 24 L�pices de colores", 45.20f, 97.95f);
		bdMem.put(artI.getCve(), artI);
		return bdMem;
	}
	public Articulo getXId(String cve) {
		return this.bd.get(cve);
	}
	public Articulo insertarUno(Articulo art) {
		Articulo artBD = this.bd.get(art.getCve());
		if (artBD != null) {
			throw new InsercionDuplicadoException(artBD.toString(),"Articulo");
		}
		this.bd.put(art.getCve(), art);
		return art;
	}
	public Articulo actualizarUno(Articulo art) {
		Articulo artBD = this.bd.get(art.getCve());
		if (artBD == null) {
			return this.insertarUno(art);
		}
		
		Articulo artAnt  = this.bd.put(art.getCve(), art);
		return artAnt;
	}
	public int borrarUno(String cve) {
		Articulo artBorrado = this.bd.remove(cve);
		if (artBorrado == null)
			return 0;
		else
			return 1;
	}
	public List<String> getIdsTodos(){
		return new ArrayList<String>(bd.keySet());
	}
}
