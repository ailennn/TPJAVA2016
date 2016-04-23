package transporte;
public class Auto extends Transporte{

	private static final int CANTIDAD_PASAJEROS = 4;
	private static final double PRECIO_BASE = 800;
	private static final double PRECIO_KM = 12;
	

	//La capacidad, no deberia heredarla de transporte, deberia ser la cantidad_pasajeros
	public Auto(String patente, double velocidad) {
		super(patente, velocidad);
	}

	public static int getCantidadPasajeros() {
		return CANTIDAD_PASAJEROS;
	}

	public double getPrecioKm() {
		return PRECIO_KM;
	}
	
	public double getCosto(){
		return PRECIO_BASE;
	}

}
