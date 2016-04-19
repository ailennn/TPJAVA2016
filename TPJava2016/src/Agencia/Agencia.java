package agencia;

import java.util.*;

import misc.*;
import transporte.*;
import viaje.Viaje;

public class Agencia {
/**Contiene las listas de transportes, destinos, y resposables
 * 	para poder armar los viajes, hacer los ABM de destino, viajes terminados, responsables
 */

	private LinkedList<Transporte> listaTrasporte;
	private LinkedList<Destino> listaDestino;
	private LinkedList<Responsable> listaResponsable;
	private LinkedList<Viaje> listaViajesTerminados;
	private LinkedList<Viaje> listaViajesEnCurso;
	private LinkedList<Viaje> listaViajesPendientes;
	
	
	
	public Agencia() {
		listaTrasporte = null;
		listaDestino = null;
		listaResponsable = null;
		listaViajesTerminados = null;
		listaViajesEnCurso = null;
		listaViajesPendientes = null;
	}
	
/*	public void eliminaVehiculo(Transporte t){
		this.listaTrasporte.remove(t);
	}*/
	
	public void bajaVehiculo(String patente){
		boolean esta=false;
		Viaje nodoViaje=new Viaje();
		/**
		 * Verifica que el transporte no este en la lista de viajes terminados
		 */
		ListIterator <Viaje>iterador=listaViajesTerminados.listIterator();
		while(iterador.hasNext()&&!esta){
			nodoViaje=iterador.next();
			if(nodoViaje.getTransporte().getPatente().equals(patente))
				esta=true;
		}
		/**
		 * Verifica que el transporte no este en la lista de viajes en curso
		 */
		ListIterator <Viaje>iterador2=listaViajesEnCurso.listIterator();
		while(iterador2.hasNext()&&!esta){
			nodoViaje=iterador2.next();
			if(nodoViaje.getTransporte().getPatente().equals(patente))
				esta=true;
		}
		/**
		 * Verifica que el transporte no este en la lista de viajes pendientes
		 */
		ListIterator <Viaje>iterador3=listaViajesPendientes.listIterator();
		while(iterador3.hasNext()&&!esta){
			nodoViaje=iterador3.next();
			if(nodoViaje.getTransporte().getPatente().equals(patente))
				esta=true;
		}
		/**
		 * Si el transporte que se quiere eliminar no estaba en ninguna lista de viajes, se puede eliminar de la lista de transportes
		 */
		if(!esta){
			boolean encontro=false;
			Transporte nodoTransporte=null;
			ListIterator<Transporte> iterador4=listaTrasporte.listIterator();
			while(iterador4.hasNext() && !encontro){
				nodoTransporte=iterador4.next();
				if(nodoTransporte.getPatente().equals(patente)){
					iterador4.remove();
					//listaTrasporte.remove(nodoTransporte);
					encontro=true;
				}
			}
		}
	}
	
/*	public void eliminaResponsable(Responsable r){
		this.listaResponsable.remove(r);
	}*/
	
	public void bajaResponsable(long dni){
		boolean esta=false;
		Viaje nodoViaje=new Viaje();
		/**
		 * Verifica que el responsable no este en la lista de viajes terminados
		 */
		ListIterator <Viaje>iterador=listaViajesTerminados.listIterator();
		while(iterador.hasNext()&&!esta){
			nodoViaje=iterador.next();
			if(nodoViaje.getResponsable().getDni()==dni)
				esta=true;
		}
		/**
		 * Verifica que el responsable no este en la lista de viajes en curso
		 */
		ListIterator <Viaje>iterador2=listaViajesEnCurso.listIterator();
		while(iterador2.hasNext()&&!esta){
			nodoViaje=iterador2.next();
			if(nodoViaje.getResponsable().getDni()==dni)
				esta=true;
		}
		/**
		 * Verifica que el responsable no este en la lista de viajes pendientes
		 */
		ListIterator <Viaje>iterador3=listaViajesPendientes.listIterator();
		while(iterador3.hasNext()&&!esta){
			nodoViaje=iterador3.next();
			if(nodoViaje.getResponsable().getDni()==dni)
				esta=true;
		}
		/**
		 * Si el responsable que se quiere eliminar no estaba en ninguna lista de viajes, se puede eliminar de la lista de responsables
		 */
		if(!esta){
			boolean encontro=false;
			Responsable nodoResponsable=null;
			ListIterator<Responsable> iterador4=listaResponsable.listIterator();
			while(iterador4.hasNext() && !encontro){
				nodoResponsable=iterador4.next();
				if(nodoResponsable.getDni()==dni){
					iterador4.remove();
					//listaResponsable.remove(nodoResponsable);
					encontro=true;
				}
			}
		}
	}
	
}
