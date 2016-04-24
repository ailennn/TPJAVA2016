package transporte;
public class Auto extends Transporte{

	private static final double PRECIO_BASE = 800;
	private static final double PRECIO_KM = 12;
	

	public Auto(String patente, double velocidad) {
		super(patente, velocidad);
		// TODO Auto-generated constructor stub
	}

	public double getPrecioKm() {
		return PRECIO_KM;
	}
	
	public double getCosto(){
		return PRECIO_BASE;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public void setCapacidad() {
		this.capacidad = 4;
	}

}
