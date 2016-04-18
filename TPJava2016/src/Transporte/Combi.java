package transporte;

public class Combi extends Transporte{

	private static final int CANTIDAD_PASAJEROS = 16;

	public Combi(String patente, int capacidad, float velocidad) {
		super(patente, capacidad, velocidad);
		// TODO Auto-generated constructor stub
	}

	public static int getCantidadPasajeros() {
		return CANTIDAD_PASAJEROS;
	}

}
