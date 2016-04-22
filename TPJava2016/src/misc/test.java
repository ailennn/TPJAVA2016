package misc;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import transporte.*;
import agencia.Agencia;
import viaje.*;
import misc.*;

import org.junit.Test; 

/**
 * Clase utilizada para probar el funcionamiento de todos los metodos por consola (sin interfaz grafica)  
 */

public class test {
	@Test
	public void test() throws FileNotFoundException{
				
		//******************  Armado de las listas **********************
		
		LinkedList<Transporte> listaTransporte= new LinkedList<Transporte>();
		LinkedList<Responsable> listaResponsable= new LinkedList<Responsable>();
		LinkedList<Viaje> listaViajesTerminados= new LinkedList<Viaje>();
		LinkedList<Viaje> listaViajesPendientes= new LinkedList<Viaje>();
		
		Agencia obA = new Agencia(); 
		
		System.out.println("Armado de las listas de la agencia obA");
		
		/*obA.altaAuto("AAA000", 100.1);
		obA.altaCombi("AAA001", 90.5);
		obA.altaSemiCama("AAA002", 95.6);
		obA.altaCama("AAA003", 88.3);
		obA.altaResponsable("Flor", 35797200, 500.5);
		obA.altaResponsable("Giu", 33333333, 555.2);
		obA.altaResponsable("Ailen", 34444444, 599.7);
		obA.altaResponsable("Jeje", 22222222, 450.5);
		obA.altaResponsable("Jaja", 30303030, 4100.4);*/
		
		Transporte t1= new Auto("AAA000", 100.1, 2);
		Transporte t2= new Combi("AAA001", 90.5, 8);
		Transporte t3= new SemiCama("AAA002", 95.6, 30);
		Transporte t4= new Cama("AAA003",88.3,20,2);
		Responsable r1= new Responsable("Flor", 35797200, 500.5);
		Responsable r2= new Responsable("Giu", 33333333, 555.2);
		Responsable r3= new Responsable("Ailen", 34444444, 599.7);
		Responsable r4= new Responsable("Jeje", 22222222, 450.5);
		Responsable r5= new Responsable("Jaja", 30303030, 4100.4);
		
		listaTransporte.add(t1);
		listaTransporte.add(t2);
		listaTransporte.add(t3);
		listaTransporte.add(t4);
		
		listaResponsable.add(r1);
		listaResponsable.add(r2);
		listaResponsable.add(r3);
		listaResponsable.add(r4);
		listaResponsable.add(r5);
		
		listaViajesTerminados=null;
		listaViajesPendientes=null;
		
			
			
/* ******************************************************************************************************************************************/ 
		System.out.println("Lista de transportes");
		recorreListaTransporte(listaTransporte);
		bajaTransporte("AAA001",listaTransporte,listaViajesTerminados,listaViajesPendientes);
		System.out.println("Se da de baja");
		recorreListaTransporte(listaTransporte);
		System.out.println("Se modifica");
		modificaTransporte("AAA003", "AAB003", 50.2,listaTransporte, listaViajesTerminados,listaViajesPendientes);
		recorreListaTransporte(listaTransporte);
		recorreListaResponsable(listaResponsable);
		System.out.println("Lista de responsables");
		bajaResponsable(35797200,listaResponsable);
		System.out.println("Se modifica");
		modificaResponsable(33333333, 33444444, 20.2,"Nombre",listaResponsable);
		recorreListaResponsable(listaResponsable);
		System.out.println("Se da de baja");
		recorreListaResponsable(listaResponsable);
}
	

	
 // ********************************************************************************************************************************************/
	
	public void recorreListaTransporte(LinkedList<Transporte> listaTransporte) {
 		
		Transporte nodoTransporte= null;
		ListIterator <Transporte> iterador= listaTransporte.listIterator();
		while(iterador.hasNext()){
			nodoTransporte=iterador.next();
			System.out.println(nodoTransporte.getPatente());
		}					 
	}
	
	public void modificaTransporte(String patente, String patModif, double velModif,LinkedList<Transporte> listaTransporte,LinkedList<Viaje> listaViajesTerminados,LinkedList<Viaje> listaViajesPendientes){
		//if(!estaOcupadoTransporte(patente)){

			boolean encontro=false;
			Transporte nodoTransporte=null;
			ListIterator<Transporte> iterador4=listaTransporte.listIterator();
			while(iterador4.hasNext() && !encontro){
				nodoTransporte=iterador4.next();
				if(nodoTransporte.getPatente().equals(patente)){
					nodoTransporte.setPatente(patModif);
					nodoTransporte.setVelocidad(velModif);
					iterador4.set(nodoTransporte);
					encontro=true;
				}
			}
		//}
	}
	
	public void bajaTransporte(String patente,LinkedList<Transporte> listaTransporte,LinkedList<Viaje> listaViajesTerminados,LinkedList<Viaje> listaViajesPendientes){
		//if(!estaOcupadoTransporte(patente,listaViajesTerminados,listaViajesPendientes)){

			boolean encontro=false;
			Transporte nodoTransporte=null;
			ListIterator<Transporte> iterador4=listaTransporte.listIterator();
			while(iterador4.hasNext() && !encontro){
				nodoTransporte=iterador4.next();
				if(nodoTransporte.getPatente().equals(patente)){
					iterador4.remove();
					//listaTrasporte.remove(nodoTransporte);
					encontro=true;
				}
			}
		//}
	}
	
	public boolean estaOcupadoTransporte(String patente,LinkedList<Viaje> listaViajesTerminados,LinkedList<Viaje> listaViajesPendientes){
		boolean esta=false;
		Viaje nodoViaje=null;
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
		 * Verifica que el transporte no este en la lista de viajes pendiente si no estaba
		 * en la lista anterior
		 */
		if(!esta){
			ListIterator <Viaje>iterador2=listaViajesPendientes.listIterator();
			while(iterador2.hasNext()&&!esta){
				nodoViaje=iterador2.next();
				if(nodoViaje.getTransporte().getPatente().equals(patente))
					esta=true;
			}
		}
		return esta;
	}

	public void modificaResponsable(long dni, long dniModif, double sueldoModif,String nombreModif,LinkedList<Responsable> listaResponsable){
		//if(!estaOcupadoResponsable(dni)){

			boolean encontro=false;
			Responsable nodoResponsable=null;
			ListIterator<Responsable> iterador4=listaResponsable.listIterator();
			while(iterador4.hasNext() && !encontro){
				nodoResponsable=iterador4.next();
				if(nodoResponsable.getDni()== dni){
					nodoResponsable.setDni(dniModif);
					nodoResponsable.setSueldoFijo(sueldoModif);
					nodoResponsable.setNombre(nombreModif);
					iterador4.set(nodoResponsable);
					encontro=true;
				}
			}
		//}
	}
	
	public void bajaResponsable(long dni,LinkedList<Responsable> listaResponsable){
		//if(!estaOcupadoResponsable(dni)){

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
		//}
	}
	
public void recorreListaResponsable(LinkedList<Responsable> listaResponsable) {
 		
		Responsable nodoResponsable= null;
		ListIterator <Responsable> iterador= listaResponsable.listIterator();
		while(iterador.hasNext()){
			nodoResponsable=iterador.next();
			System.out.println(nodoResponsable.getDni());
			System.out.println(nodoResponsable.getNombre());
			System.out.println(nodoResponsable.getSueldoFijo());
		}					 
	}
	
}
