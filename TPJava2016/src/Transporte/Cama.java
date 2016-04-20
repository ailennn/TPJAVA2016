package transporte;

public class Cama extends Colectivo{

	private static final int CAMA = 26;
	private static final int COMUN = 6;
	//COSTO ADICIONAL POR ELEGIR CAMA
	private static final float ADICIONAL_CAMA = 100;
	private int ocupadoCama;
	private int ocupadoComun;
	

	public Cama(String patente, int capacidad, float velocidad, int ocupadoCama, int ocupadoComun) {
		super(patente, capacidad, velocidad);
		this.ocupadoCama = ocupadoCama;
		this.ocupadoComun = ocupadoComun;
	}
	
	/*GETTERS & SETTERS*/
	
	public int getOcupadoCama() {
		return ocupadoCama;
	}

	public void setOcupadoCama(int ocupadoCama) {
		this.ocupadoCama = ocupadoCama;
	}

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

	public static float getAdicionalCama() {
		return ADICIONAL_CAMA;
	}
	public float getCosto(){
		return 0;
	}

	public float getPrecioKM(){
		return (ocupadoCama+ocupadoComun)*getPrecio()+ocupadoCama*ADICIONAL_CAMA*getPrecio();
	}
}
