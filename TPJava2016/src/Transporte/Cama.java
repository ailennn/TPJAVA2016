package transporte;

public class Cama extends Colectivo{

	private static final int CAMA = 26;
	private static final int COMUN = 6;
	//COSTO ADICIONAL POR ELEGIR CAMA
	private static final double ADICIONAL_CAMA = 100;
	private int ocupadoComun;
	
	public Cama(String patente, double velocidad, int ocupado) {
		super(patente, velocidad, ocupado);
		// TODO Auto-generated constructor stub
	}
	
	/*GETTERS & SETTERS*/



	public int getOcupadoComun() {
		return ocupadoComun;
	}

	public void setOcupadoComun(int ocupadoComun) {
		this.ocupadoComun = ocupadoComun;
	}

	public static int getCama() {
		return CAMA;
	}

	public static int getComun() {
		return COMUN;
	}

	public static double getAdicionalCama() {
		return ADICIONAL_CAMA;
	}
	public double getCosto(){
		return 0;
	}

	public double getPrecioKM(){
		return (getOcupado()+ocupadoComun)*getPrecio()+getOcupado()*ADICIONAL_CAMA*getPrecio();
	}
}
