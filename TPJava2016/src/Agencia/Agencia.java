package agencia;

import java.io.File;
import java.io.PrintWriter;
import java.lang.Exception;
import java.util.*;

import misc.*;
import transporte.*;
import viaje.*;
import viaje.Viaje.estadoViaje;

public class Agencia {
/**Contiene las listas de transportes, destinos, y resposables
 * 	para poder armar los viajes, hacer los ABM viajes, responsables
 */

	private LinkedList<Transporte> listaTransporte;
	private LinkedList<Destino> listaDestino;
	private LinkedList<Responsable> listaResponsable;
	private LinkedList<Viaje> listaViajesTerminados;
	private LinkedList<Viaje> listaViajesPendientes;
	
	
	
	public Agencia() {
		listaTransporte = null;
		listaDestino = null;
		listaResponsable = null;
		listaViajesTerminados = null;
		listaViajesPendientes = null;
	}
	
	
	/**
	 * Recorre las listas de viajes pendientes y ocupados.
	 * Si el transporte no está en ninguna de las listas, esta disponible
	 * para hacer lo que se necesite.
	 * @param patente
	 * @return
	 */
	public boolean estaOcupadoTransporte(String patente){
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
	
	/**
	 * Recorre las listas de viajes pendientes y ocupados.
	 * Si el responsable no está en ninguna de las listas, esta disponible
	 * para hacer lo que se necesite.
	 * @param patente
	 * @return
	 */
	public boolean estaOcupadoResponsable(long dni){
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
	
	public void altaAuto(String pat, double veloc){
		Auto nuevo = new Auto (pat,veloc);
		if(this.listaTransporte==null) // si no tiene elementos
			this.listaTransporte= new LinkedList<Transporte>(); 
		listaTransporte.add(nuevo);
	}
	
	public void altaCombi(String pat, double veloc){
		Combi nuevo = new Combi (pat, veloc);
		if(this.listaTransporte==null) // si no tiene elementos
			this.listaTransporte= new LinkedList<Transporte>(); 
		listaTransporte.add(nuevo);
	}
	
	public void altaSemiCama (String pat, double veloc){
		SemiCama nuevo = new SemiCama (pat, veloc);
		if(this.listaTransporte==null) // si no tiene elementos
			this.listaTransporte= new LinkedList<Transporte>(); 
		listaTransporte.add(nuevo);
	}
	
	public void altaCama (String pat, double veloc){
		Cama nuevo = new Cama (pat, veloc);
		if(this.listaTransporte==null) // si no tiene elementos
			this.listaTransporte= new LinkedList<Transporte>(); 
		listaTransporte.add(nuevo);
	}

	/**
	 * Si el transporte que se quiere modificar no estaba en ninguna lista de viajes,
	 * se puede modificar de la lista de transportes
	 */
	public void modificaTransporte(String patente, String patModif, double velModif){
		if(!estaOcupadoTransporte(patente)){

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
	/**
	 * Si el transporte que se quiere eliminar no estaba en ninguna lista de viajes, 
	 * se puede eliminar de la lista de transportes
	 */
	public void bajaTransporte(String patente){
		if(!estaOcupadoTransporte(patente)){

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
	
	public void altaResponsable (String nomb, long DNI, double sueldo){
		Responsable nuevo = new Responsable (nomb, DNI, sueldo);
		if(this.listaResponsable==null) // si no tiene elementos
			this.listaResponsable= new LinkedList<Responsable>(); 
		listaResponsable.add(nuevo);
	}
	
	/**
	 * Si el responsable que se quiere modificar no estaba en ninguna lista de viajes,
	 * se puede modificar de la lista de responsables
	 */
	public void modificaResponsable(long dni, long dniModif, double sueldoModif,String nombreModif){
		if(!estaOcupadoResponsable(dni)){

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
	/**
	 * Si el responsable que se quiere eliminar no estaba en ninguna lista de viajes, 
	 * se puede eliminar de la lista de responsables
	 */
	public void bajaResponsable(long dni){
		if(!estaOcupadoResponsable(dni)){

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
	
	
	/*
	 * El método crearViaje esta sobrecargado, dependiendo los parametros que se les pase
	 * Hay que hacer un if(destino.getKilometros()<=100) llamar al metodo de corta distancia
	 * else if(transporte instanceof Cama) llamar al metodo de larga distancia y de cama
	 * else llamar al metodo larga distancia y de los demas transportes.
	 */
	public void crearViaje(Destino d, int cantPasajeros, Transporte t){
		/**
		 * Si el tranporte no esta ocupado, lo puedo usar
		 */
		if(!estaOcupadoTransporte(t.getPatente())){
			/**
			 * Controla que el transporte no sea colectivo cama, y que la cantidad de pasajeros sea menor que la capacidad
			 */
			//Ver si se puede usar el atributo CANTIDAD_PASAJEROS de las clases auto, combi y semiCama
			if((t instanceof Auto && cantPasajeros<=4) || (t instanceof Combi && cantPasajeros<=16) || (t instanceof SemiCama && cantPasajeros<=40)){
				/**
				 * Crea el viaje y lo agrega a la lista de viajes pendientes
				 */
				d.setContador();
				t.setOcupado(cantPasajeros);
				Viaje v= new CortaDistancia("",t,d,cantPasajeros,estadoViaje.PENDIENTE);
				v.setNombre();
				if(this.listaViajesPendientes==null) // si no tiene elementos
				{
					this.listaViajesPendientes= new LinkedList<Viaje>(); 
				}
				listaViajesPendientes.add(v); 
			}
		}
	}
	
	public void crearViaje(Destino d, int cantPasajeros, Transporte t,LinkedList<Responsable> lista){
		/**
		 * Si el tranporte no esta ocupado, lo puedo usar
		 */
		if(!estaOcupadoTransporte(t.getPatente())){
			/**
			 * Controla que el transporte no sea auto, y que la cantidad de pasajeros sea menor que la capacidad
			 */
			//Ver si se puede usar el atributo CANTIDAD_PASAJEROS de las clases combi y semiCama
			if((t instanceof Combi && cantPasajeros<=16) || (t instanceof SemiCama && cantPasajeros<=40)){
				/**
				 * Crea el viaje y lo agrega a la lista de viajes pendientes
				 */
				d.setContador();
				t.setOcupado(cantPasajeros);
				Viaje v=new LargaDistancia("",t,d,cantPasajeros,estadoViaje.PENDIENTE,lista);
				v.setNombre();
				if(this.listaViajesPendientes==null) // si no tiene elementos
				{
					this.listaViajesPendientes= new LinkedList<Viaje>(); 
				}
				listaViajesPendientes.add(v); 
			}
		}
	}
	
	public void crearViaje(Destino d, int cantPasajeros,int ocupadoCama, Transporte t,LinkedList<Responsable> lista){
		
			/**
			 * Si el tranporte no esta ocupado, lo puedo usar
			 */
			if(!estaOcupadoTransporte(t.getPatente())){
				/**
				 * Controla que el transporte sea cama, y que la cantidad de pasajeros sea menor que la capacidad
				 */
				//Ver si se puede usar el atributo CANTIDAD_PASAJEROS de la clase cocheCama
					if(t instanceof Cama && cantPasajeros<=32){
						if(ocupadoCama<=26){
							d.setContador();
							t.setOcupado(ocupadoCama);
							t.setOcupadoComun(cantPasajeros-ocupadoCama);
							/**
							 * Crea el viaje y lo agrega a la lista de viajes pendientes
							 */
							Viaje v=new LargaDistancia("",t,d,cantPasajeros,estadoViaje.PENDIENTE,lista);
							v.setNombre();
							if(this.listaViajesPendientes==null) // si no tiene elementos
							{
								this.listaViajesPendientes= new LinkedList<Viaje>(); 
							}
							listaViajesPendientes.add(v);
						}
					}
			}
		
	}
	
	public void finalizarViaje(){
		
	}
	
	/**
	 * iniciar la simulación, inicia todos los viajes de la lista
	 */
	public void iniciarViajePendiente(){
		
	}
	
	/**
	 * pausar la simulación, detiene todos los viajes de la lista
	 */
	public void detenerViajePendiente(){
		
	}
	
	public void OrdenarPorResponsables(LinkedList<Responsable> listaAux){
		Collections.sort(listaAux, new Comparator<Responsable>()
        {
            public int compare(Responsable r1, Responsable r2){   
         	   
         	   if(r1.getDni()>(r2.getDni()))
         		   return 1;
         	   else
         		   if(r1.getDni()<(r2.getDni()))
         			   return -1;
                else
             	   return 0;
            }
        }
 	);
	}
	
	/**
	 * En la listaAux, se reusó la clase responsable, en donde se almacena los 
	 * kilometros totales recorridos por ese responsable en el atributo sueldoFijo
	 * @param listaAux
	 */
	public void OrdenarPorKilometrosRecorridos(LinkedList<Responsable> listaAux){
		Collections.sort(listaAux, new Comparator<Responsable>()
        {
            public int compare(Responsable r1, Responsable r2){   
         	   
         	   if(r1.getSueldoFijo()>(r2.getSueldoFijo()))
         		   return 1;
         	   else
         		   if(r1.getSueldoFijo()<(r2.getSueldoFijo()))
         			   return -1;
                else
             	   return 0;
            }
        }
 	);
	}
	
	/**
	 * Ranking de responsables a bordo ordenado de mayor a menor por 
	 * cantidad de kilómetros recorridos en los viajes terminados.
	 * Genera archivo de texto
	 */
	
	public void ranking(){
		Viaje v=null;
		int suma=0;
		/**
		 * La lista auxiliar se usa para almacenar cada responsable(sin que esten repetidos)
		 * con la cantidad total de kms recorridos, que se suman en la variable suma
		 */
		LinkedList<Responsable> listaAux=null;
		LinkedList<Responsable>listaAux2=null;
		LinkedList<Viaje>listaTerminados=listaViajesTerminados;
		ListIterator<Viaje>iterador=listaTerminados.listIterator();
		while(iterador.hasNext()){
			v=iterador.next();
			if(v instanceof LargaDistancia){
				ListIterator<Responsable>itr=v.getListaResponsable().listIterator();
				Responsable r=null;
				while(itr.hasNext()){
					r=itr.next();
					if(listaAux==null)
						listaAux=new LinkedList<Responsable>();
					r.setSueldoFijo(v.getDestino().getKilometros());
					listaAux.add(r);
				}
			}	
		}
		OrdenarPorResponsables(listaAux);
		ListIterator<Responsable>itr=listaAux.listIterator();
		Responsable r=null;
		if(itr.hasNext()){
			r=itr.next();
			long dni=r.getDni();
			suma+=r.getSueldoFijo();
			while(itr.hasNext()){
				r=itr.next();
				if(r.getDni()==dni){
					suma+=r.getSueldoFijo();
				}
				else{
					dni=r.getDni();
					r=itr.previous();
					if(listaAux2==null)
						listaAux2=new LinkedList<Responsable>();
					r.setSueldoFijo(suma);
					listaAux2.add(r);
					suma=0;
				}
			}
			if(listaAux2==null)
				listaAux2=new LinkedList<Responsable>();
			/**
			 * En el atributo sueldoFijo de Responsable se almacena la cantidad
			 * total de kilometros recorridos por ese Responsable
			 */
			r.setSueldoFijo(suma);
			listaAux2.add(r);
			
			OrdenarPorKilometrosRecorridos(listaAux2);
			
			File arctxt=new File("src//archivos//ranking.txt"); 
			PrintWriter escribir;
			if(!arctxt.exists()){
				try {
					arctxt.createNewFile();
				} catch (Exception e) {
					
				}
			}	
			
			try {

				escribir = new PrintWriter(arctxt,"utf-8");	
				Responsable resp=null;
				ListIterator <Responsable> itera= listaAux2.listIterator();
				while(itera.hasNext()) {
					resp=itera.next();
					escribir.format("%20s\t%d\t%d\n",r.getNombre(),r.getDni(),r.getSueldoFijo());
				}
			 
				escribir.close();
				} catch (Exception e) {}
		}
	}
	
	/**
	 * Recaudación de los viajes realizados por la empresa, 
	 * permitiendo ver la información total o bien 
	 * visualizarla por cada transporte y/o cada destino.
	 * Genera archivo de texto
	 */
	
	public void recaudacion(){
		
	}

	
	/**
	 * Para recorrer la lista en la clase test, y ver si los métodos funcionan bien
	 * @param listaTransporte
	 */
	public void recorreListaTransporte(LinkedList<Transporte> listaTransporte) {
 		
		Transporte nodoTransporte= null;
		ListIterator <Transporte> iterador= listaTransporte.listIterator();
		while(iterador.hasNext()){
			nodoTransporte=iterador.next();
			System.out.println(nodoTransporte.getPatente());
		}					 
	}
	
	/**
	 * Para recorrer la lista en la clase test, y ver si los métodos funcionan bien
	 * @param listaResponsable
	 */
public void recorreListaResponsable(LinkedList<Responsable> listaResponsable) {
 		
		Responsable nodoResponsable= null;
		ListIterator <Responsable> iterador= listaResponsable.listIterator();
		while(iterador.hasNext()){
			nodoResponsable=iterador.next();
			System.out.println(nodoResponsable.getDni());
		}					 
	}
	
}
