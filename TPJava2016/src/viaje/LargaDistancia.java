package viaje;

import misc.Destino;
import misc.Responsable;
import transporte.Transporte;
import java.util.*;

public class LargaDistancia extends Viaje{

	public LargaDistancia(String nombre, estadoViaje estado, int kmsRecorridos, Transporte transporte,
			 Destino destino, int cantPasajeros, LinkedList<Responsable> listaResponsable) {
		super(nombre, estado, kmsRecorridos, transporte, destino, cantPasajeros,listaResponsable);
		this.listaResponsable = listaResponsable;

	}

	public void setListaResponsable(LinkedList<Responsable> listaResponsable) {
		this.listaResponsable = listaResponsable;
	}


	/*CREAR EXCEPCION EN CASO DE QUE EL DESTINO SEA MENOR A 100 KM*/
	/*CHEQUEAR QUE EL TRANSPORTE SEA SOLO COLECTIVO O COMBI*/
	
	public float Costo(){
		Responsable nodo = null;
		float sum=0;
		float sumaSueldo = 0;
		ListIterator <Responsable> iterador= listaResponsable.listIterator();
		while (iterador.hasNext()){
			nodo=iterador.next();
			sumaSueldo+=nodo.getSueldoFijo();
		}
		sum+=getTransporte().getCosto()+getTransporte().getPrecioKM()*getDestino().getKilometros()+sumaSueldo;
		return sum;
	}
}
