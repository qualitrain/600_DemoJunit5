package qtx.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {
	private int numVenta;
	private Date fecVta;
	private long idCte;
	private List<DetalleVenta> dets = new ArrayList<>();
	
	public int getNumVenta() {
		return numVenta;
	}
	public void setNumVenta(int numVenta) {
		this.numVenta = numVenta;
	}
	public Date getFecVta() {
		return fecVta;
	}
	public void setFecVta(Date fecVta) {
		this.fecVta = fecVta;
	}
	public long getIdCte() {
		return idCte;
	}
	public void setIdCte(long idCte) {
		this.idCte = idCte;
	}
	@Override
	public String toString() {
		return "Venta [numVenta=" + numVenta + ", fecVta=" + fecVta + ", idCte=" + idCte + ", dets=" + dets + "]";
	}

	public void agregarDetalle(DetalleVenta detI) {
		this.dets.add(detI);
	}
	
	public DetalleVenta getDetalleVenta(int i) {
		if (i >= this.dets.size())
			throw new NegocioException("Intentando acceder a un detalle de venta "
					                 + "inexistente: " + i + " de " + this.dets.size() );
		return this.dets.get(i);
	}
	
	public int getNumDetalles() {
		return this.dets.size();
	}

	
}
