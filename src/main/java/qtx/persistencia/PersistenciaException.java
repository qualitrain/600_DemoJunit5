package qtx.persistencia;

public class PersistenciaException extends RuntimeException {
	private String entidad;

	public PersistenciaException(String message, String entidad) {
		super(message);
		this.entidad = entidad;
	}

}
