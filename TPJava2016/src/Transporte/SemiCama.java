package Transporte;

public class SemiCama extends Transporte{

	private static final int CANTIDAD_PASAJEROS = 40;
	
	public SemiCama(String patente, int capacidad, float velocidad) {
		super(patente, capacidad, velocidad);
		// TODO Auto-generated constructor stub
	}

	public static int getCantidadPasajeros() {
		return CANTIDAD_PASAJEROS;
	}
	
}
