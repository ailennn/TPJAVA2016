package transporte;

public class Combi extends Transporte{

	private static final int CANTIDAD_PASAJEROS = 16;
	private static final double PRECIO_BASE = 1000;
	private static final double PRECIO_KM = 25;
	


	/*GETTERS & SETTERS*/
	
	public Combi(String patente, double velocidad, int ocupado) {
		super(patente, velocidad, ocupado);
		// TODO Auto-generated constructor stub
	}

	public static int getCantidadPasajeros() {
		return CANTIDAD_PASAJEROS;
	}
	
	public double getPrecioKm() {
		return PRECIO_KM*getOcupado();
	}

	public static double getPrecioBase() {
		return PRECIO_BASE;
	}
	
	public double getCosto(){
		return PRECIO_BASE;
	}
}
