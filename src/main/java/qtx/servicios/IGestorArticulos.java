package qtx.servicios;

import java.util.List;
import java.util.Map;

import qtx.negocio.Articulo;

public interface IGestorArticulos {
	List<Articulo> getTodos();
	Articulo getXId(String cve);
	Articulo insertarUno(Articulo art);
	Articulo actualizarUno(Articulo art);
	int borrarUno(String cve);
	List<String> getIdsTodos();
	Map<Articulo,Integer> insertarMuchos(List<Articulo> arts);
}
