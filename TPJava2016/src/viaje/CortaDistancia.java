package viaje;

import misc.*;
import transporte.Transporte;

public class CortaDistancia extends Viaje{
	private static final double COSTO_BASE = 300;
	


	public CortaDistancia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CortaDistancia(String nombre, Transporte transporte, Destino destino, int cantPasajeros,
			estadoViaje estado) {
		super(nombre, transporte, destino,cantPasajeros,estado);

		// TODO Auto-generated constructor stub
	}

	public static double getCostoBase() {
		return COSTO_BASE;
	}
	
	/*CREAR EXCEPCION EN CASO DE QUE EL DESTINO SEA MAYOR A 100 KM*/
	/*CHEQUEAR QUE TRANSPORTE SEA SOLO AUTO O COMBI O COLECTIVO SEMI CAMA*/
	public double Costo(){
		float sum=0;
		sum+=COSTO_BASE+getTransporte().getCosto()+getTransporte().getPrecioKM()*getDestino().getKilometros();
		return sum;
	}
}
