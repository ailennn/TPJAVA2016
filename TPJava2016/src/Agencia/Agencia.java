package agencia;

import java.io.File;
import java.io.PrintWriter;
import java.lang.Exception;
import java.util.*;

import misc.*;
import transporte.*;
import viaje.*;

public class Agencia {
/**Contiene las listas de transportes, destinos, y resposables
 * 	para poder armar los viajes, hacer los ABM de destino, viajes terminados, responsables
 */

	private LinkedList<Transporte> listaTransporte;
	private LinkedList<Destino> listaDestino;
	private LinkedList<Responsable> listaResponsable;
	private LinkedList<Viaje> listaViajesTerminados;
	private LinkedList<Viaje> listaViajesEnCurso;
	private LinkedList<Viaje> listaViajesPendientes;
	
	
	
	public Agencia() {
		listaTransporte = null;
		listaDestino = null;
		listaResponsable = null;
		listaViajesTerminados = null;
		listaViajesEnCurso = null;
		listaViajesPendientes = null;
	}
	
	
	/**
	 * Recorre las listas de viajes en curso, pendients y ocupados.
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
		ListIterator <Viaje>iterador=listaViajesTerminados.listIterator();
		while(iterador.hasNext()&&!esta){
			nodoViaje=iterador.next();
			if(nodoViaje.getTransporte().getPatente().equals(patente))
				esta=true;
		}
		/**
		 * Verifica que el transporte no este en la lista de viajes en curso si no estaba
		 * en la lista anterior
		 */
		if(!esta){
			ListIterator <Viaje>iterador2=listaViajesEnCurso.listIterator();
			while(iterador2.hasNext()&&!esta){
				nodoViaje=iterador2.next();
				if(nodoViaje.getTransporte().getPatente().equals(patente))
					esta=true;
			}
			/**
			 * Verifica que el transporte no este en la lista de viajes pendientes si no
			 * estaba en las listas anteriores
			 */
			if(!esta){
				ListIterator <Viaje>iterador3=listaViajesPendientes.listIterator();
				while(iterador3.hasNext()&&!esta){
					nodoViaje=iterador3.next();
					if(nodoViaje.getTransporte().getPatente().equals(patente))
						esta=true;
				}
			}
		}
		return esta;
	}
	
	/**
	 * Recorre las listas de viajes en curso, pendients y ocupados.
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
		ListIterator <Viaje>iterador=listaViajesTerminados.listIterator();
		while(iterador.hasNext()&&!esta){
			nodoViaje=iterador.next();
			if(nodoViaje.getResponsable().getDni()==dni)
				esta=true;
		}
		/**
		 * Verifica que el responsable no este en la lista de viajes en curso si no estaba en la lista anterior
		 */
		if(!esta){
			ListIterator <Viaje>iterador2=listaViajesEnCurso.listIterator();
			while(iterador2.hasNext()&&!esta){
				nodoViaje=iterador2.next();
				if(nodoViaje.getResponsable().getDni()==dni)
					esta=true;
			}
			/**
			 * Verifica que el responsable no este en la lista de viajes pendientes si no estaba en las listas anteriores
			 */
			if(!esta){
				ListIterator <Viaje>iterador3=listaViajesPendientes.listIterator();
				while(iterador3.hasNext()&&!esta){
					nodoViaje=iterador3.next();
					if(nodoViaje.getResponsable().getDni()==dni)
						esta=true;
				}
			}
		}
		return esta;
	}
	
	public void altaTransporte(){
		
	}
	
	public void modificaTransporte(String patente, String patModif, float velModif){
		if(!estaOcupadoTransporte(patente)){
			/**
			 * Si el transporte que se quiere modificar no estaba en ninguna lista de viajes,
			 * se puede modificar de la lista de transportes
			 */
			boolean encontro=false;
			Transporte nodoTransporte=null;
			ListIterator<Transporte> iterador4=listaTransporte.listIterator();
			while(iterador4.hasNext() && !encontro){
				nodoTransporte=iterador4.next();
				if(nodoTransporte.getPatente().equals(patente)){
					nodoTransporte.setPatente(patModif);
					nodoTransporte.setVelocidad(velModif);
					encontro=true;
				}
			}
		}
	}
	
	public void bajaTransporte(String patente){
		if(!estaOcupadoTransporte(patente)){
			/**
			 * Si el transporte que se quiere eliminar no estaba en ninguna lista de viajes, 
			 * se puede eliminar de la lista de transportes
			 */
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
	
	public void altaResponsable(){
		
	}
	
	public void modificaResponsable(){
		
	}
	
	public void bajaResponsable(long dni){
		if(!estaOcupadoResponsable(dni)){
			/**
			 * Si el responsable que se quiere eliminar no estaba en ninguna lista de viajes, 
			 * se puede eliminar de la lista de responsables
			 */
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
	
	public void crearViaje(){
		
	}
	
	public void finalizarViaje(){
		
	}
	
	public void iniciarViajePendiente(){
		
	}
	
	public void detenerViaje(){
		
	}
	
	public void OrdenarPorResponsables(LinkedList<Viaje> listaTerminados){
		Collections.sort(listaTerminados, new Comparator<Viaje>()
        {
            public int compare(Viaje v1, Viaje v2){   
         	   
         	   if(v1.getResponsable().getDni()>(v2.getResponsable().getDni()))
         		   return 1;
         	   else
         		   if(v1.getResponsable().getDni()<(v2.getResponsable().getDni()))
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
		OrdenarPorResponsables(listaViajesTerminados);
		Viaje v=null;
		int suma=0;
		/**
		 * La lista auxiliar se usa para almacenar cada responsable(sin que esten repetidos)
		 * con la cantidad total de kms recorridos, que se suman en la variable suma
		 */
		LinkedList<Responsable> listaAux=null;
		ListIterator<Viaje>iterador=listaViajesTerminados.listIterator();
		if(iterador.hasNext()){
			v=iterador.next();
			long dni=v.getResponsable().getDni();
			suma+=v.getDestino().getKilometros();
			while(iterador.hasNext()){
				v=iterador.next();
				if(v.getResponsable().getDni()==dni){
					suma+=v.getDestino().getKilometros();
				}
				else{
					dni=v.getResponsable().getDni();
					v=iterador.previous();
					if(listaAux==null)
						listaAux=new LinkedList<Responsable>();
					v.getResponsable().setSueldoFijo(suma);
					listaAux.add(v.getResponsable());
					suma=0;
				}
			}
			if(listaAux==null)
				listaAux=new LinkedList<Responsable>();
			/**
			 * En el atributo sueldoFijo de Responsable se almacena la cantidad
			 * total de kilometros recorridos por ese Responsable
			 */
			v.getResponsable().setSueldoFijo(suma);
			listaAux.add(v.getResponsable());
			
			OrdenarPorKilometrosRecorridos(listaAux);
			
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
				Responsable r=null;
				ListIterator <Responsable> itr= listaAux.listIterator();
				while(itr.hasNext()) {
					r=itr.next();
					escribir.format("%20s\t%d\t%d\n",v.getResponsable().getNombre(),v.getResponsable().getDni(),v.getResponsable().getSueldoFijo());
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
	
}
