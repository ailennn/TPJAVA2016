package transporte;

public class SemiCama extends Colectivo{

	private static final int CANTIDAD_PASAJEROS = 40;
	private int ocupado;

	public SemiCama(String patente, int capacidad, float velocidad, int ocupado) {
		super(patente, capacidad, velocidad);
		this.ocupado = ocupado;
	}

	/*GETTERS & SETTERS*/
	public static int getCantidadPasajeros() {
		return CANTIDAD_PASAJEROS;
	}

	public int getOcupado() {
		return ocupado;
	}

	public void setOcupado(int ocupado) {
		this.ocupado = ocupado;
	}
	
	public float getCosto(){
		return 0;
	}
	
	public float getPrecioKm() {
		return ocupado*getPrecio();
	}
}
