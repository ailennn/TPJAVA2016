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
		LinkedList<Destino> listaDestino =new LinkedList<Destino>();
		
		Agencia obA = new Agencia(); 
		
		System.out.println("Armado de las listas de la agencia obA");
		
		obA.altaAuto("AAA000", 100.1);
		obA.altaCombi("AAA001", 90.5);
		obA.altaSemiCama("AAA002", 95.6);
		obA.altaCama("AAA003", 88.3);
		obA.altaResponsable("Flor", 35797200, 500.5);
		obA.altaResponsable("Giu", 33333333, 555.2);
		obA.altaResponsable("Ailen", 34444444, 599.7);
		obA.altaResponsable("Jeje", 22222222, 450.5);
		obA.altaResponsable("Jaja", 30303030, 4100.4);
		
		Transporte t1= new Auto("AAA000", 100.1);
		Transporte t2= new Combi("AAA001", 90.5);
		Transporte t3= new SemiCama("AAA002", 95.6);
		Transporte t4= new Cama("AAA003",88.3,20);
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
		
		Destino d1= new Destino("Los Toldos",600);
		Destino d2= new Destino("Balcarce",60);
			
		listaDestino.add(d1);
		listaDestino.add(d2);
			
/* ******************************************************************************************************************************************/ 
		/*obA.recorreListaTransporte(listaTransporte);
		obA.recorreListaResponsable(listaResponsable);
		
		System.out.println("Lista de transportes");
		recorreListaTransporte(listaTransporte);
		bajaTransporte("AAA001",listaTransporte,listaViajesTerminados,listaViajesPendientes);
		System.out.println("Se da de baja");
		recorreListaTransporte(listaTransporte);
		System.out.println("Se modifica");
		modificaTransporte("AAA003", "AAB003", 50.2,listaTransporte, listaViajesTerminados,listaViajesPendientes);
		recorreListaTransporte(listaTransporte);
		System.out.println("Lista de responsables");
		recorreListaResponsable(listaResponsable);
		System.out.println("Se da de baja");
		bajaResponsable(35797200,listaResponsable,listaViajesTerminados,listaViajesPendientes);
		recorreListaResponsable(listaResponsable);
		System.out.println("Se modifica");
		modificaResponsable(33333333, 33444444, 20.2,"Nombre",listaResponsable,listaViajesTerminados,listaViajesPendientes);
		recorreListaResponsable(listaResponsable);
		
		recorreListaDestino(listaDestino);*/
		crearViaje(d2, 2, t1,listaViajesPendientes, listaViajesTerminados, listaDestino);
		crearViaje(d1, 5, t2, listaResponsable,listaViajesPendientes,listaViajesTerminados,listaDestino);
		crearViaje(d2, 22,20, t4,listaResponsable,listaViajesPendientes,listaViajesTerminados, listaDestino);
		
		crearViaje(d1, 3,0, t4,listaResponsable,listaViajesPendientes,listaViajesTerminados,listaDestino);
		crearViaje(d1, 3,0, t2,listaResponsable,listaViajesPendientes,listaViajesTerminados,listaDestino);
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
		if(!estaOcupadoTransporte(patente,listaViajesTerminados,listaViajesPendientes)){

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
		}
	}
	
	public void bajaTransporte(String patente,LinkedList<Transporte> listaTransporte,LinkedList<Viaje> listaViajesTerminados,LinkedList<Viaje> listaViajesPendientes){
		if(!estaOcupadoTransporte(patente,listaViajesTerminados,listaViajesPendientes)){

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
		}
	}
	
	public boolean estaOcupadoTransporte(String patente,LinkedList<Viaje> listaViajesTerminados,LinkedList<Viaje> listaViajesPendientes){
		boolean esta=false;
		Viaje nodoViaje=null;
		/**
		 * Verifica que el transporte no este en la lista de viajes terminados
		 */
		if(listaViajesTerminados!=null){
			ListIterator <Viaje>iterador=listaViajesTerminados.listIterator();
			while(iterador.hasNext()&&!esta){
				nodoViaje=iterador.next();
				if(nodoViaje.getTransporte().getPatente().equals(patente))
					esta=true;
			}
		}
		
		/**
		 * Verifica que el transporte no este en la lista de viajes pendiente si no estaba
		 * en la lista anterior
		 */
		if(!esta){
			if(listaViajesPendientes!=null){
				ListIterator <Viaje>iterador2=listaViajesPendientes.listIterator();
				while(iterador2.hasNext()&&!esta){
					nodoViaje=iterador2.next();
					if(nodoViaje.getTransporte().getPatente().equals(patente))
						esta=true;
				}
			}
		}
		return esta;
	}

	
	public boolean estaOcupadoResponsable(long dni,LinkedList<Viaje> listaViajesTerminados,LinkedList<Viaje> listaViajesPendientes){
		boolean esta=false;
		Viaje nodoViaje=null;
		/**
		 * Verifica que el responsable no este en la lista de viajes terminados
		 */
		if(listaViajesTerminados!=null){
			ListIterator <Viaje>iterador=listaViajesTerminados.listIterator();
			while(iterador.hasNext()&&!esta){
				nodoViaje=iterador.next();
				if(nodoViaje instanceof LargaDistancia){
					Responsable r=null;
					ListIterator<Responsable> itr=nodoViaje.getListaResponsable().listIterator();
					while(itr.hasNext()&&!esta){
						r=itr.next();
						if(r.getDni()==dni)
							esta=true;
					}
				}
			}
		}
		/**
		 * Verifica que el responsable no este en la lista de viajes pendiente si no estaba en la lista anterior
		 */
		if(!esta){
			if(listaViajesPendientes!=null){
				ListIterator <Viaje>iterador2=listaViajesPendientes.listIterator();
				while(iterador2.hasNext()&&!esta){
					nodoViaje=iterador2.next();
					if(nodoViaje instanceof LargaDistancia){
						Responsable r=null;
						ListIterator<Responsable> itr2=nodoViaje.getListaResponsable().listIterator();
						while(itr2.hasNext()&&!esta){
							r=itr2.next();
							if(r.getDni()==dni)
								esta=true;
						}
					}
				}
			}
		}
		return esta;
	}
	
	public void modificaResponsable(long dni, long dniModif, double sueldoModif,String nombreModif,LinkedList<Responsable> listaResponsable,LinkedList<Viaje> listaViajesTerminados,LinkedList<Viaje> listaViajesPendientes){
		if(!estaOcupadoResponsable(dni,listaViajesTerminados, listaViajesPendientes)){

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
		}
	}
	
	public void bajaResponsable(long dni,LinkedList<Responsable> listaResponsable,LinkedList<Viaje> listaViajesTerminados,LinkedList<Viaje> listaViajesPendientes){
		if(!estaOcupadoResponsable(dni,listaViajesTerminados, listaViajesPendientes)){

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

public void recorreListaViajesPendientes(LinkedList<Viaje> listaViajesPendientes) {
		
	if(listaViajesPendientes!=null){
		Viaje nodoViaje= null;
		ListIterator <Viaje> iterador= listaViajesPendientes.listIterator();
		while(iterador.hasNext()){
			nodoViaje=iterador.next();
			System.out.println(nodoViaje.getNombre());
			System.out.println(nodoViaje.getCantPasajeros());
			System.out.println(nodoViaje.getEstado());
			System.out.println(nodoViaje.getDestino());
			System.out.println(nodoViaje.getTransporte().getOcupado());
			System.out.println(nodoViaje.getTransporte().getOcupadoComun());
		}	
	}
	else
		System.out.println("Lista vacia");
					 
}


public void recorreListaDestino(LinkedList<Destino> listaDestino) {
	
	if(listaDestino!=null){
		Destino nodoDestino= null;
		ListIterator <Destino> iterador= listaDestino.listIterator();
		while(iterador.hasNext()){
			nodoDestino=iterador.next();
			System.out.println(nodoDestino.getCiudad());
		}	
	}
	else
		System.out.println("Lista vacia");
					 
}


public void crearViaje(Destino d, int cantPasajeros, Transporte t,LinkedList<Viaje>listaViajesPendientes,LinkedList<Viaje> listaViajesTerminados,LinkedList<Destino> listaDestino){
			/**
			 * Si el tranporte no esta ocupado, lo puedo usar
			 */
			if(!estaOcupadoTransporte(t.getPatente(),listaViajesTerminados,listaViajesPendientes)){
				Destino nodoDestino=null;
				ListIterator <Destino> iterador=listaDestino.listIterator();
				boolean encontro=false;
				/**
				 * Recorre la lista de destinos, para aumentar el contador
				 */
				while(iterador.hasNext() && !encontro){
					nodoDestino=iterador.next();
					if(nodoDestino.getCiudad()==(d.getCiudad())){
						nodoDestino.setContador();
						d=nodoDestino;
						encontro=true;
					}
				}
				/**
				 * Controla que el transporte no sea colectivo cama, y que la cantidad de pasajeros sea menor que la capacidad
				 */
				//Ver si se puede usar el atributo CANTIDAD_PASAJEROS de las clases auto, combi y semiCama
				if((t instanceof Auto && cantPasajeros<=4) || (t instanceof Combi && cantPasajeros<=16) || (t instanceof SemiCama && cantPasajeros<=40)){
					/**
					 * Crea el viaje y lo agrega a la lista de viajes pendientes
					 */
					//ver como usar el enum para el estado viaje
					t.setOcupado(cantPasajeros);
					Viaje v=null;
					v= new CortaDistancia("","pendiente",0,t,d,cantPasajeros);
					v.setNombre();
					if(listaViajesPendientes==null) // si no tiene elementos
					{
						listaViajesPendientes= new LinkedList<Viaje>(); 
					}
					listaViajesPendientes.add(v); 
				}
			}
			recorreListaViajesPendientes(listaViajesPendientes);
		}
		
		public void crearViaje(Destino d, int cantPasajeros, Transporte t,LinkedList<Responsable> lista,LinkedList<Viaje>listaViajesPendientes,LinkedList<Viaje> listaViajesTerminados,LinkedList<Destino> listaDestino){
			/**
			 * Si el tranporte no esta ocupado, lo puedo usar
			 */
			if(!estaOcupadoTransporte(t.getPatente(),listaViajesTerminados,listaViajesPendientes)){
				t.setOcupado(cantPasajeros);
				Destino nodoDestino=null;
				ListIterator <Destino> iterador=listaDestino.listIterator();
				boolean encontro=false;
				/**
				 * Recorre la lista de destinos, para aumentar el contador
				 */
				while(iterador.hasNext() && !encontro){
					nodoDestino=iterador.next();
					if(nodoDestino.getCiudad()==(d.getCiudad())){
						nodoDestino.setContador();
						d=nodoDestino;
						encontro=true;
					}
				}
				
				/**
				 * Controla que el transporte no sea auto, y que la cantidad de pasajeros sea menor que la capacidad
				 */
				//Ver si se puede usar el atributo CANTIDAD_PASAJEROS de las clases combi y semiCama
				if((t instanceof Combi && cantPasajeros<=16) || (t instanceof SemiCama && cantPasajeros<=40)){
					/**
					 * Crea el viaje y lo agrega a la lista de viajes pendientes
					 */
					//ver como usar el enum para el estado viaje
					Viaje v=null;
					v= new LargaDistancia("","pendiente",0,t,d,cantPasajeros,lista);
					v.setNombre();
					if(listaViajesPendientes==null) // si no tiene elementos
					{
						listaViajesPendientes= new LinkedList<Viaje>(); 
					}
					listaViajesPendientes.add(v); 
				}
			}
			recorreListaViajesPendientes(listaViajesPendientes);
		}
		
		public void crearViaje(Destino d, int cantPasajeros,int ocupadoCama, Transporte t,LinkedList<Responsable> lista,LinkedList<Viaje>listaViajesPendientes,LinkedList<Viaje> listaViajesTerminados,LinkedList<Destino> listaDestino){
			
				/**
				 * Si el tranporte no esta ocupado, lo puedo usar
				 */
				if(!estaOcupadoTransporte(t.getPatente(),listaViajesTerminados,listaViajesPendientes)){
					Destino nodoDestino=null;
					ListIterator <Destino> iterador=listaDestino.listIterator();
					boolean encontro=false;
					/**
					 * Recorre la lista de destinos, para aumentar el contador
					 */
					while(iterador.hasNext() && !encontro){
						nodoDestino=iterador.next();
						if(nodoDestino.getCiudad()==(d.getCiudad())){
							nodoDestino.setContador();
							d=nodoDestino;
							encontro=true;
						}
					}
					
					/**
					 * Controla que el transporte sea cama, y que la cantidad de pasajeros sea menor que la capacidad
					 */
					//Ver si se puede usar el atributo CANTIDAD_PASAJEROS de la clase cocheCama
						if(t instanceof Cama && cantPasajeros<=32){
							if(ocupadoCama<=26){
								t.setOcupado(ocupadoCama);
								t.setOcupadoComun(cantPasajeros-ocupadoCama);
								/**
								 * Crea el viaje y lo agrega a la lista de viajes pendientes
								 */
								//ver como usar el enum para el estado viaje
								Viaje v=null;
								v= new LargaDistancia("","pendiente",0,t,d,cantPasajeros,lista);
								v.setNombre();
								if(listaViajesPendientes==null) // si no tiene elementos
								{
									listaViajesPendientes= new LinkedList<Viaje>(); 
								}
								listaViajesPendientes.add(v);
							}
						}
				}
				recorreListaViajesPendientes(listaViajesPendientes);
		}



}
