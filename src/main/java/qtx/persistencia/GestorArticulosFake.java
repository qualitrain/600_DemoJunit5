package qtx.persistencia;

import java.util.List;
import java.util.Map;

import qtx.negocio.Articulo;
import qtx.servicios.IGestorArticulos;

public class GestorArticulosFake implements IGestorArticulos{

	@Override
	public List<Articulo> getTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articulo getXId(String cve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articulo insertarUno(Articulo art) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articulo actualizarUno(Articulo art) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int borrarUno(String cve) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getIdsTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Articulo, Integer> insertarMuchos(List<Articulo> arts) {
		// TODO Auto-generated method stub
		return null;
	}

}
