package transporte;

public class Combi extends Transporte{

	private static final double PRECIO_BASE = 1000;
	private static final double PRECIO_KM = 25;
	


	
	public Combi(String patente, int velocidad) {
		super(patente, velocidad);
		// TODO Auto-generated constructor stub
	}

	public void setCapacidad() {
		this.capacidad = 16;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public double getPrecioKm() {
		return PRECIO_KM*getOcupado();
	}

	public static double getPrecioBase() {
		return PRECIO_BASE;
	}
	
	public double getCosto(){
		return PRECIO_BASE;
	}
}
