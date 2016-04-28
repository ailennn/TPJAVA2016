package transporte;

/**
 * Clase abstracta derivada de transporte, que representa los colectivos
 * @author Usuario
 *
 */
public abstract class Colectivo extends Transporte{
	
	private static final double PRECIO_KM = 6;

	public Colectivo(String patente, int velocidad) {
		super(patente, velocidad);
		// TODO Auto-generated constructor stub
	}

	public double getPrecio() {
		return PRECIO_KM;
	}
	
	
}
