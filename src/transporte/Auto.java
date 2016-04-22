package transporte;
public class Auto extends Transporte{

	private static final int CANTIDAD_PASAJEROS = 4;
	private static final float PRECIO_BASE = 800;
	private static final float PRECIO_KM = 12;
	private int ocupado;

	//La capacidad, no deberia heredarla de transporte, deberia ser la cantidad_pasajeros
	public Auto(String patente, int capacidad, float velocidad, int ocupado) {
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

	public float getPrecioKm() {
		return PRECIO_KM;
	}
	
	public float getCosto(){
		return PRECIO_BASE;
	}

}
