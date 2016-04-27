package misc;
import java.io.*;
import java.lang.Exception;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import transporte.*;
import agencia.Agencia;
import viaje.*;
import misc.*;

import org.junit.Test; 

/**
 * Clase utilizada para probar el funcionamiento de todos los metodos por consola (sin interfaz grafica).  
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

		
		Transporte t1= new Auto("AAA000", 100);
		t1.setCapacidad();
		Transporte t2= new Combi("AAA001", 90);
		t2.setCapacidad();
		Transporte t3= new SemiCama("AAA002",88);
		t3.setCapacidad();
		Transporte t4= new Cama("AAA003",88);
		Responsable r1= new Responsable("Flor", 35797200, 500.5);
		Responsable r2= new Responsable("Giu", 33333333, 555.2);
		Responsable r3= new Responsable("Ailen", 34444444, 580.7);
		Responsable r4= new Responsable("Jeje", 22222222, 450.5);
		Responsable r5= new Responsable("Jaja", 30303030, 4100.4);
		
		Destino d1= new Destino("Los Toldos",600);
		Destino d2= new Destino("Balcarce",60);
		
		LinkedList<Responsable>listaResponsable2=new LinkedList<Responsable>();
		listaResponsable2.add(r1);
		LinkedList<Responsable>listaResponsable3=new LinkedList<Responsable>();
		listaResponsable3.add(r3);
		listaResponsable3.add(r1);
		
		
		Viaje v1=new CortaDistancia("hola",t1,d2, 2);
		Viaje v2=new LargaDistancia("hola2",t2,d1, 5,listaResponsable2);
		Viaje v3=new LargaDistancia("hola3",t4,d1, 8,listaResponsable3);
		
		v1.setKmsRecorridos(v1.getDestino().getKilometros());
		v2.setKmsRecorridos(v2.getDestino().getKilometros());
		v3.setKmsRecorridos(v3.getDestino().getKilometros());
		
		listaViajesTerminados.add(v2);
		listaViajesTerminados.add(v1);
		
		listaViajesTerminados.add(v3);
		listaViajesPendientes=null;
		//listaViajesTerminados=null;
		
		listaDestino.add(d1);
		listaDestino.add(d2);
			
/* ******************************************************************************************************************************************/ 

/*		
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
		
		//ranking(listaViajesTerminados);
		if(esNumeroMayorCero("-1"))
			System.out.println("bien");
		else
			JOptionPane.showMessageDialog(null, "Error, no ingrese numeros negativos");
			
		
		
}
	

	
 // ********************************************************************************************************************************************/
	
	public static boolean esNumeroMayorCero(String cadena) {
        cadena = cadena.trim();
        try {
            Integer.parseUnsignedInt(cadena);
	    return true;} 
        catch (NumberFormatException nfe) {
	            return false;
	        }
    }
	
	public void recorreListaTransporte(LinkedList<Transporte> listaTransporte) {
 		
		Transporte nodoTransporte= null;
		ListIterator <Transporte> iterador= listaTransporte.listIterator();
		while(iterador.hasNext()){
			nodoTransporte=iterador.next();
			System.out.println(nodoTransporte.getPatente());
		}					 
	}
	
	public void modificaTransporte(String patente, String patModif, int velModif,LinkedList<Transporte> listaTransporte,LinkedList<Viaje> listaViajesTerminados,LinkedList<Viaje> listaViajesPendientes){
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
			System.out.println("DNI");
			System.out.println(nodoResponsable.getDni());
			System.out.println("Nombre");
			System.out.println(nodoResponsable.getNombre());
			System.out.println("KMs recorridos");
			System.out.println(nodoResponsable.getSueldoFijo());
		}					 
	}

public void recorreListaViajesPendientes(LinkedList<Viaje> listaViajesPendientes) {
		
	if(listaViajesPendientes!=null){
		Viaje nodoViaje= null;
		ListIterator <Viaje> iterador= listaViajesPendientes.listIterator();
		while(iterador.hasNext()){
			nodoViaje=iterador.next();
			System.out.println("Nombre viaje");
			System.out.println(nodoViaje.getNombre());
			System.out.println("cant pasajeros");
			System.out.println(nodoViaje.getCantPasajeros());
			System.out.println("estado");
			System.out.println(nodoViaje.getEstado());
			System.out.println("destino");
			System.out.println(nodoViaje.getDestino().getCiudad());
			System.out.println("ocupado");
			System.out.println(nodoViaje.getTransporte().getOcupado());
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
 * En la listaAux, se reus� la clase responsable, en donde se almacena los 
 * kilometros totales recorridos por ese responsable en el atributo sueldoFijo
 * @param listaAux
 */
public void OrdenarPorKilometrosRecorridos(LinkedList<Responsable> listaAux){
	Collections.sort(listaAux, new Comparator<Responsable>()
    {
        public int compare(Responsable r1, Responsable r2){   
     	   
     	   if(r1.getSueldoFijo()<(r2.getSueldoFijo()))
     		   return 1;
     	   else
     		   if(r1.getSueldoFijo()>(r2.getSueldoFijo()))
     			   return -1;
            else
         	   return 0;
        }
    }
	);
}

/**
 * Ranking de responsables a bordo ordenado de mayor a menor por 
 * cantidad de kil�metros recorridos en los viajes terminados.
 * Genera archivo de texto
 */

public void ranking(LinkedList<Viaje>listaViajesTerminados){
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

	ListIterator<Responsable>itr2=listaAux.listIterator();
	Responsable re=null;
	if(itr2.hasNext()){
		re=itr2.next();
		long dni=re.getDni();
		while(itr2.hasNext()){
			if(re.getDni()==dni){
				suma+=re.getSueldoFijo();
				if(!itr2.hasNext() || itr2.next().getDni()!=dni){
					if(listaAux2==null)
						listaAux2=new LinkedList<Responsable>();
					/**
					 * En el atributo sueldoFijo de Responsable se almacena la cantidad
					 * total de kilometros recorridos por ese Responsable
					 */
					re.setSueldoFijo(suma);
					listaAux2.add(re);
				}
				re=itr2.next();
			}
			else{
				dni=re.getDni();
				suma=0;
			}
		}
		if(listaAux2==null)
			listaAux2=new LinkedList<Responsable>();
		re.setSueldoFijo(suma+re.getSueldoFijo());
		listaAux2.add(re);
		
		OrdenarPorKilometrosRecorridos(listaAux2);
		
		recorreListaResponsable(listaAux2);
		
		File arctxt=new File("src//archivos//ranking.txt"); 
		Writer escribir;
		if(!arctxt.exists()){
			try {
				arctxt.createNewFile();
			} catch (Exception e) {
				
			}
		}	
		
		try {
			escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arctxt), "UTF-8"));

			//escribir = new PrintWriter(arctxt,"utf-8");
			escribir.write("DNI \t \t");
			escribir.write("Nombre \t \t");
			escribir.write("Kilometros recorridos\n");
			Responsable resp=null;
			ListIterator <Responsable> itera= listaAux2.listIterator();
			while(itera.hasNext()) {
				resp=itera.next();
				System.out.print("DNI a escribir");
				System.out.println(resp.getDni());
				escribir.write(resp.getNombre()+"\t \t");
				escribir.write(resp.getDni()+"\t \t");
				escribir.write(resp.getSueldoFijo()+"\n");
				//escribir.format("%s \t %d \t %d \n",resp.getNombre(),resp.getDni(),resp.getSueldoFijo());
			}
			escribir.close();
			} catch (Exception e) {}
	}
}




}
