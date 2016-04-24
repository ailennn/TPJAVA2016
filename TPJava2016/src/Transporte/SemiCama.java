package transporte;

public class SemiCama extends Colectivo{

	public SemiCama(String patente, double velocidad) {
		super(patente, velocidad);
		// TODO Auto-generated constructor stub
	}


	/*GETTERS & SETTERS*/
	public void setCapacidad() {
		this.capacidad = 40;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public double getCosto(){
		return 0;
	}
	
	public double getPrecioKm() {
		return getOcupado()*getPrecio();
	}
}
