package qtx.servicios;

import java.util.List;

import qtx.negocio.Cliente;
import qtx.negocio.StatusCte;
import qtx.negocio.Venta;

public class ServicioComercial {
	private IGestorClientes gCtes;

	public ServicioComercial(IGestorClientes gCtes) {
		this.gCtes = gCtes;
	}
	
	public Venta generarVenta(long idCte, List<String> cvesArt, List<Integer> cants, int idVend) {
		Cliente cte = gCtes.getXId(idCte);
		if (cte == null) {
			throw new ServicioException("No existe cliente con id [" + idCte + "]");
		}
		if (cte.getStatus() == StatusCte.SUSPENDIDO) {
			throw new ClienteSuspendidoException("No es posible venderle a un cliente suspendido", 
		                                          cte.getId(), cte.getNombre());
		}
		
		// ToDo: Validar Vendedor, cves de articulos, cantidades vs existencias
		
		Venta vta = new Venta();
		vta.setIdCte(idCte);

		// ToDo: Generar detallesVta		
		
		return vta;
	}
	
}
