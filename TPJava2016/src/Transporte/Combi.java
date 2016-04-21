package transporte;

public class Combi extends Transporte{

	private static final int CANTIDAD_PASAJEROS = 16;
	private static final float PRECIO_BASE = 1000;
	private static final float PRECIO_KM = 25;
	private int ocupado;
	
	public Combi(String patente, int capacidad, float velocidad, int ocupado) {
		super(patente,velocidad);
		this.ocupado = ocupado;
	}

	/*GETTERS & SETTERS*/
	
	public static int getCantidadPasajeros() {
		return CANTIDAD_PASAJEROS;
	}
	
	public float getPrecioKm() {
		return PRECIO_KM*ocupado;
	}

	public int getOcupado() {
		return ocupado;
	}

	public void setOcupado(int ocupado) {
		this.ocupado = ocupado;
	}

	public static float getPrecioBase() {
		return PRECIO_BASE;
	}
	
	public float getCosto(){
		return PRECIO_BASE;
	}
}
