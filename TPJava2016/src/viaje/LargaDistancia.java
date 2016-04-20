package viaje;

import misc.Destino;
import misc.Responsable;
import transporte.Transporte;
import java.util.*;

public class LargaDistancia extends Viaje{

	private LinkedList<Responsable> listaResponsable;
	private float precioPorResponsable;
	
	public LargaDistancia(String nombre, estadoViaje estado, int kmsRecorridos, Transporte transporte,
			 Destino destino, int cantPasajeros, LinkedList<Responsable> listaResponsable, float precioPorResponsable) {
		super(nombre, estado, kmsRecorridos, transporte, destino, cantPasajeros);
		this.listaResponsable = listaResponsable;
		this.precioPorResponsable = precioPorResponsable;
	}
	
	public LinkedList<Responsable> getListaResponsable() {
		return listaResponsable;
	}

	public void setListaResponsable(LinkedList<Responsable> listaResponsable) {
		this.listaResponsable = listaResponsable;
	}

	public float getPrecioPorResponsable() {
		return precioPorResponsable;
	}

	public void setPrecioPorResponsable(float precioPorResponsable) {
		this.precioPorResponsable = precioPorResponsable;
	}


	/*CREAR EXCEPCION EN CASO DE QUE EL DESTINO SEA MENOR A 100 KM*/
	/*CHEQUEAR QUE EL TRANSPORTE SEA SOLO COLECTIVO O COMBI*/
	
	public float Costo(){
		float sum=0;
		sum+=getTransporte().getCosto()+getTransporte().getPrecioKM()*getDestino().getKilometros()+listaResponsable.size()*precioPorResponsable;
		return sum;
	}
}
