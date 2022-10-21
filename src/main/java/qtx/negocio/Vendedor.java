package qtx.negocio;

public class Vendedor {
	private int id;
	private String nombres;
	private String apPaterno;
	private String apMaterno;
	private float cuotaMes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public String getNombreCompleto() {
		return this.nombres + " " + this.apPaterno + " " + this.apMaterno;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public float getCuotaMes() {
		return cuotaMes;
	}
	public void setCuotaMes(float cuotaMes) {
		this.cuotaMes = cuotaMes;
	}
	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nombres=" + nombres + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno
				+ ", cuotaMes=" + cuotaMes + ", NombreCompleto=" + getNombreCompleto() + "]";
	}

}
