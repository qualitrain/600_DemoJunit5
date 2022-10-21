package qtx.negocio;

import java.math.BigDecimal;

public class Articulo {
	private String cve;
	private String nombre;
	private String descripcion;
	private BigDecimal costo;
	private BigDecimal precio;

	public Articulo(String cve, String nombre, String descripcion, float costo, float precio) {
		super();
		
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = new BigDecimal(costo);
		this.precio = new BigDecimal(precio);
	}

	public String getCve() {
		return cve;
	}

	public void setCve(String cve) {
		this.cve = cve;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getCosto() {
		return this.costo.floatValue();
	}

	public void setCosto(float costo) {
		this.costo = new BigDecimal(costo);
	}

	public float getPrecio() {
		return precio.floatValue();
	}

	public void setPrecio(float precio) {
		this.precio = new BigDecimal(precio);
	}
	public double getMargen() {
		return (this.getPrecio() - this.getCosto())/ this.getCosto();
	}

	@Override
	public String toString() {
		return "Articulo [cve=" + cve + ", nombre=" + nombre + ", descripcion=" + descripcion 
				+ ", costo=" + String.format("%6.2f", costo)
				+ ", precio=" + String.format("%6.2f", precio) + "]";
	}

	

}
