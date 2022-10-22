package qtx.negocio;

import java.util.Date;

public class Cliente {
	private String nombre;
	private Date fecNac;
	private long id;
	private StatusCte status;

	
	public Cliente(String nombre, Date fecNac, long id) {
		super();
		this.nombre = nombre;
		this.fecNac = fecNac;
		this.id = id;
		this.status = StatusCte.NORMAL;
	}
	
	public Cliente(String nombre, Date fecNac, long id, StatusCte status) {
		super();
		this.nombre = nombre;
		this.fecNac = fecNac;
		this.id = id;
		this.status = status;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecNac() {
		return fecNac;
	}
	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public StatusCte getStatus() {
		return status;
	}
	public void setStatus(StatusCte status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", fecNac=" + fecNac + ", id=" + id + "]";
	}
	
}
