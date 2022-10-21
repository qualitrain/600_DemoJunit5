package qtx.negocio;

import java.math.BigDecimal;

public class DetalleVenta {
   private int numVenta;
   private int numDetalle;
   private int cantidad;
   private String cveArticulo;
   private BigDecimal precioUnitario;
   
	public DetalleVenta(int numVenta, int numDetalle, int cantidad, String cveArticulo, BigDecimal precioUnitario) {
		super();
		this.numVenta = numVenta;
		this.numDetalle = numDetalle;
		this.cantidad = cantidad;
		this.cveArticulo = cveArticulo;
		this.precioUnitario = precioUnitario;
	}

	public int getNumVenta() {
		return numVenta;
	}

	public void setNumVenta(int numVenta) {
		this.numVenta = numVenta;
	}

	public int getNumDetalle() {
		return numDetalle;
	}

	public void setNumDetalle(int numDetalle) {
		this.numDetalle = numDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getCveArticulo() {
		return cveArticulo;
	}

	public void setCveArticulo(String cveArticulo) {
		this.cveArticulo = cveArticulo;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "DetalleVenta [numVenta=" + numVenta + ", numDetalle=" + numDetalle + ", cantidad=" + cantidad
				+ ", cveArticulo=" + cveArticulo + ", precioUnitario=" + precioUnitario + "]";
	}
   
}
