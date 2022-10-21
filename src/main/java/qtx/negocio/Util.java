package qtx.negocio;

public class Util {

	public static String evaluarUtilidad(double costo, double precio, double limSupBajo, double limSupMedio) {
		double margen = (precio - costo) / costo;
		if (margen <= 0)
			return "Perdida";
		if (margen <= limSupBajo)
			return "UtilidadBaja";
		if (margen <= limSupMedio)
			return "UtilidadMedia";		
		return "UtilidadAlta";
	}
}
