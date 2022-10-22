package qtx.servicios;

import java.util.List;

import qtx.negocio.Articulo;

public interface IGestorArticulos {
	List<Articulo> getTodos();
	Articulo getXId(String cve);
	Articulo insertarUno(Articulo art);
	Articulo actualizarUno(Articulo art);
	int borrarUno(String cve);
	List<String> getIdsTodos();
}
