package viaje;

import misc.*;
import misc.Responsable;
import transporte.Transporte;

public class CortaDistancia extends Viaje{
	private static final double COSTO_BASE = 300;
	

	public CortaDistancia(String nombre, String estado, int kmsRecorridos,Transporte transporte, Destino destino, int cantPasajeros) {
		super(nombre, estado, kmsRecorridos,transporte, destino,cantPasajeros,null);
	}


	public static double getCostoBase() {
		return COSTO_BASE;
	}
	/**OBTIENE EL COSTO DEL VIAJE= COSTO BASE + PRECIO X KM*/
	/*CREAR EXCEPCION EN CASO DE QUE EL DESTINO SEA MAYOR A 100 KM*/
	/*CHEQUEAR QUE TRANSPORTE SEA SOLO AUTO O COMBI O COLECTIVO SEMI CAMA*/
	public double Costo(){
		float sum=0;
		sum+=COSTO_BASE+getTransporte().getCosto()+getTransporte().getPrecioKM()*getDestino().getKilometros();
		return sum;
	}
}
