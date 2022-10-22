package qtx.servicios;

public class ClienteSuspendidoException extends ServicioException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idCte;
	private String nombre;
	
	public ClienteSuspendidoException(String message, long idCte, String nombre) {
		super(message);
		this.idCte = idCte;
		this.nombre = nombre;
	}

	public long getIdCte() {
		return idCte;
	}

	public String getNombre() {
		return nombre;
	}

}
