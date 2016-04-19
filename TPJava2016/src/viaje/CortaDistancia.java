package viaje;

import misc.Destino;
import misc.Responsable;
import transporte.Transporte;

public class CortaDistancia extends Viaje{
	private static final float COSTO_BASE = 300;
	

	public CortaDistancia(Transporte transporte, Responsable responsable, Destino destino) {
		super(transporte, responsable, destino);
	}

	public static float getCostoBase() {
		return COSTO_BASE;
	}
	/**OBTIENE EL COSTO DEL VIAJE= COSTO BASE + PRECIO X KM*/
	public float Costo(){
		float sum=0;
		sum+=COSTO_BASE+getTransporte().getPrecioKM();
		return sum;
	}
}
