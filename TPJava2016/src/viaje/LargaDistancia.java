package viaje;

public class LargaDistancia extends Viaje{

	/*CREAR EXCEPCION EN CASO DE QUE EL DESTINO SEA MENOR A 100 KM*/
	/*CHEQUEAR QUE EL TRANSPORTE SEA SOLO COLECTIVO O COMBI*/
	public float Costo(){
		float sum=0;
		sum+=getTransporte().getCosto()*getDestino().getKilometros();
		return sum;
	}
}
