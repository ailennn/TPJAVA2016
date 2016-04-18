package transporte;
public class Auto extends Transporte{

	private static final int CANTIDAD_PASAJEROS = 4;
	
	public Auto(String patente, int capacidad, float velocidad) {
		super(patente, capacidad, velocidad);
		// TODO Auto-generated constructor stub
	}

	public static int getCantidadPasajeros() {
		return CANTIDAD_PASAJEROS;
	}


}
