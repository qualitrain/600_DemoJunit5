package qtx.servicios;

public class ServicioException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServicioException(String message) {
		super(message);
	}

	public ServicioException(Throwable cause) {
		super(cause);
	}

}
