package qtx.persistencia;

public class InsercionDuplicadoException extends PersistenciaException {

	public InsercionDuplicadoException(String message, String entidad) {
		super(message, entidad);
	}

}
