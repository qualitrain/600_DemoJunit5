package qtx.util;

import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
	public static Date getDateDDMMAAAA(int dia, int mes, int anio) {
		GregorianCalendar gc = new GregorianCalendar(anio, mes - 1, dia);
		return gc.getTime();
	}
}
