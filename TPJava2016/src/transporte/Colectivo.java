package transporte;

public abstract class Colectivo extends Transporte{
	
	private static final double PRECIO_KM = 35;

	public Colectivo(String patente, double velocidad, int ocupado) {
		super(patente, velocidad, ocupado);
		// TODO Auto-generated constructor stub
	}

	public double getPrecio() {
		return PRECIO_KM;
	}
	
	
}
