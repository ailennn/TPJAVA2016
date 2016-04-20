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
	/*CREAR EXCEPCION EN CASO DE QUE EL DESTINO SEA MAYOR A 100 KM*/
	/*CHEQUEAR QUE TRANSPORTE SEA SOLO AUTO O COMBI O COLECTIVO SEMI CAMA*/
	public float Costo(){
		float sum=0;
		sum+=COSTO_BASE+getTransporte().getCosto()*getDestino().getKilometros();
		return sum;
	}
}
