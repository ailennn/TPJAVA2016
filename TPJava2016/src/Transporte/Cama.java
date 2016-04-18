package Transporte;

public class Cama extends Transporte{


	private static final int CAMA = 26;
	private static final int COMUN = 6;
	
	public Cama(String patente, int capacidad, float velocidad) {
		super(patente, capacidad, velocidad);
		// TODO Auto-generated constructor stub
	}

	public static int getCama() {
		return CAMA;
	}

	public static int getComun() {
		return COMUN;
	}
	

}
