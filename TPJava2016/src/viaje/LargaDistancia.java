package viaje;

import misc.*;
import transporte.Transporte;
import java.util.*;

public class LargaDistancia extends Viaje{



	public LargaDistancia() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LargaDistancia(Transporte transporte,Destino destino, int cantPasajeros,LinkedList<Responsable> listaResponsable) {
		super(transporte, destino, cantPasajeros);
		this.listaResponsable=listaResponsable;
	}



	public void setListaResponsable(LinkedList<Responsable> listaResponsable) {
		this.listaResponsable = listaResponsable;
	}


	/*CREAR EXCEPCION EN CASO DE QUE EL DESTINO SEA MENOR A 100 KM*/
	/*CHEQUEAR QUE EL TRANSPORTE SEA SOLO COLECTIVO O COMBI*/
	
	public double Costo(){
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
