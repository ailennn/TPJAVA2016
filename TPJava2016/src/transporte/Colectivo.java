package transporte;

public abstract class Colectivo extends Transporte{
	
	private static final float PRECIO_KM = 35;

	
	public Colectivo(String patente, int capacidad, float velocidad) {
		super(patente, velocidad);
		// TODO Auto-generated constructor stub
	}

	public float getPrecio() {
		return PRECIO_KM;
	}
	
	
}
