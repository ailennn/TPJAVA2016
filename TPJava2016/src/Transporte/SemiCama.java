package transporte;

public class SemiCama extends Colectivo{

	private static final int CANTIDAD_PASAJEROS = 40;



	public SemiCama(String patente, double velocidad, int ocupado) {
		super(patente, velocidad, ocupado);
		// TODO Auto-generated constructor stub
	}


	/*GETTERS & SETTERS*/
	public static int getCantidadPasajeros() {
		return CANTIDAD_PASAJEROS;
	}

	
	public double getCosto(){
		return 0;
	}
	
	public double getPrecioKm() {
		return getOcupado()*getPrecio();
	}
}
