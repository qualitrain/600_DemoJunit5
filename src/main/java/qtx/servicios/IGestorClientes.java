package qtx.servicios;

import qtx.negocio.Cliente;

public interface IGestorClientes {
	Cliente getXId(long id);
	Cliente insertarUno(Cliente cte);
}
