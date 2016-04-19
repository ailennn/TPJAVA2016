package transporte;
public class Auto extends Transporte{

	private static final int CANTIDAD_PASAJEROS = 4;
	private static final float PRECIO_BASE = 800;
	private int ocupado;

	public Auto(String patente, int capacidad, float velocidad, int ocupado) {
		super(patente, capacidad, velocidad);
		this.ocupado = ocupado;
	}

	public static int getCantidadPasajeros() {
		return CANTIDAD_PASAJEROS;
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


}
