package transporte;
public class Auto extends Transporte{

	private static final int CANTIDAD_PASAJEROS = 4;
	private static final double PRECIO_BASE = 800;
	private static final double PRECIO_KM = 12;
	private int ocupado;

	//La capacidad, no deberia heredarla de transporte, deberia ser la cantidad_pasajeros
	public Auto(String patente, double velocidad, int ocupado) {
		super(patente, velocidad);
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

	public double getPrecioKm() {
		return PRECIO_KM;
	}
	
	public double getCosto(){
		return PRECIO_BASE;
	}

}
