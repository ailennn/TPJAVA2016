package agencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
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
	
	public void cargaLista (){
		Destino aux = new Destino("Mar del Plata",15);
		listaDestino.add(aux);
		aux.setCiudad("Tandil");
		listaDestino.add(aux);
	}
	
	/*
	 * Destinos, transportes y viajes creados para agregar a la lista de viajes
	 * pendientes, y asi probar la simulacion. Despues hay que borrarlos
	 */
	/*Destino d1= new Destino("Los Toldos",600);
	Destino d2= new Destino("Balcarce",60);
	Transporte t1= new Auto("AAA000", 100);
	Transporte t2= new Combi("AAA001", 90);
	Transporte t3= new SemiCama("AAA002",88);
	Transporte t4= new Cama("AAA003",88);
	Viaje v1=new CortaDistancia("hola",t1,d2, 2,estadoViaje.PENDIENTE);
	Viaje v2=new LargaDistancia("hola2",t2,d1, 5,estadoViaje.PENDIENTE,null);
	Viaje v3=new LargaDistancia("hola3",t4,d1, 8,estadoViaje.PENDIENTE,null);
	
	
	public void setListaViajesPendientes(){
		if(this.listaViajesPendientes==null)
			this.listaViajesPendientes=new LinkedList<Viaje>();
		v1.setKmsRecorridos(0);
		v2.setKmsRecorridos(0);
		v3.setKmsRecorridos(0);
		this.listaViajesPendientes.add(v1);
		this.listaViajesPendientes.add(v2);
		this.listaViajesPendientes.add(v3);
	}*/
	
	public LinkedList<Viaje> getListaViajesPendientes() {
		return listaViajesPendientes;
	}

	/**
	 * Recorre las listas de viajes pendientes y terminados.
	 * Si el transporte no está en ninguna de las listas, esta disponible
	 * para hacer modificarlo o eliminarlo.
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
	 * Recorre las listas de viajes pendientes y terminados.
	 * Si el responsable no está en ninguna de las listas, esta disponible
	 * para modificarlo o eliminarlo.
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
	
	/**
	 * Metodo que verifica que el transporte no esta en viaje (pendiente o en curso)
	 * @param patente
	 * @return
	 */
	public boolean estaEnViajeTransporte(String patente){
		boolean esta=false;
		Viaje nodoViaje=null;
		/**
		 * Verifica que el transporte no este en la lista de viajes pendientes
		 */
		if(listaViajesPendientes!=null){
			ListIterator <Viaje>iterador2=listaViajesPendientes.listIterator();
			while(iterador2.hasNext()&&!esta){
				nodoViaje=iterador2.next();
				if(nodoViaje.getTransporte().getPatente().equals(patente))
					esta=true;
			}
		}
		return esta;
	}
	
	/**
	 * Metodo que verifica que el responsable no esta en viaje (pendiente o en curso)
	 * @param dni
	 * @return
	 */
	public boolean estaEnViajeResponsable(long dni){
		boolean esta=false;
		Viaje nodoViaje=null;
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
		return esta;
	}
	
	/**
	 * Metodo para crear un auto
	 * @param pat
	 * @param veloc
	 */
	public void altaAuto(String pat, int veloc){
		Auto nuevo = new Auto (pat,veloc);
		nuevo.setCapacidad();
		if(this.listaTransporte==null) // si no tiene elementos
			this.listaTransporte= new LinkedList<Transporte>(); 
		listaTransporte.add(nuevo);
	}
	
	/**
	 * Metodo para crear una combi
	 * @param pat
	 * @param veloc
	 */
	public void altaCombi(String pat, int veloc){
		Combi nuevo = new Combi (pat, veloc);
		nuevo.setCapacidad();
		if(this.listaTransporte==null) // si no tiene elementos
			this.listaTransporte= new LinkedList<Transporte>(); 
		listaTransporte.add(nuevo);
	}
	
	/**
	 * Metodo para crear un coche semi cama
	 * @param pat
	 * @param veloc
	 */
	public void altaSemiCama (String pat, int veloc){
		SemiCama nuevo = new SemiCama (pat, veloc);
		nuevo.setCapacidad();
		if(this.listaTransporte==null) // si no tiene elementos
			this.listaTransporte= new LinkedList<Transporte>(); 
		listaTransporte.add(nuevo);
	}
	
	/**
	 * Metodo para crear un coche cama
	 * @param pat
	 * @param veloc
	 */
	public void altaCama (String pat, int veloc){
		Cama nuevo = new Cama (pat, veloc);
		nuevo.setCapacidad();
		if(this.listaTransporte==null) // si no tiene elementos
			this.listaTransporte= new LinkedList<Transporte>(); 
		listaTransporte.add(nuevo);
	}

	/**
	 * Si el transporte que se quiere modificar no estaba en ninguna lista de viajes,
	 * se puede modificar de la lista de transportes
	 */
	public void modificaTransporte(String patente, String patModif, int velModif){
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
	/**
	 * Metodo para crear un responsable
	 * @param nomb
	 * @param DNI
	 * @param sueldo
	 */
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
	/**
	 * Crea un viaje de corta distancia
	 * @param d
	 * @param cantPasajeros
	 * @param t
	 */
	/*
	 * La lista que se elige el transporte, ya van a estar solo los transportes
	 * que no esten en viaje (llamando al metodo estaEnViajeTransporte)
	 */
	public void crearViaje(Destino d, int cantPasajeros, Transporte t){
			/**
			 * Controla que el transporte no sea colectivo cama, y que la cantidad de pasajeros sea menor que la capacidad
			 */
			if((t instanceof Auto) || (t instanceof Combi) || (t instanceof SemiCama)){
				if(cantPasajeros<=t.getCapacidad()){
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
	
	/**
	 * Crea un viaje de larga distancia, cuyo transporte es Combi o Colectivo Semi Cama
	 * @param d
	 * @param cantPasajeros
	 * @param t
	 * @param lista
	 */
	/*
	 * La lista que se elige el transporte, ya van a estar solo los transportes
	 * que no esten en viaje (llamando al metodo estaEnViajeTransporte) y lo
	 * mismo para responsable (llamando al metodo estaEnViajeResponsable)
	 */
	public void crearViaje(Destino d, int cantPasajeros, Transporte t,LinkedList<Responsable> lista){
			/**
			 * Controla que el transporte no sea auto, y que la cantidad de pasajeros sea menor que la capacidad
			 */
			if((t instanceof Combi) || (t instanceof SemiCama)){
				if(cantPasajeros<=t.getCapacidad()){
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
	
	/**
	 * Crea un viaje de larga distancia, cuyo transporte es un Colectivo Cama
	 * @param d
	 * @param cantPasajeros
	 * @param ocupadoCama
	 * @param t
	 * @param lista
	 */
	/*
	 * La lista que se elige el transporte, ya van a estar solo los transportes
	 * que no esten en viaje (llamando al metodo estaEnViajeTransporte) y lo
	 * mismo para responsable (llamando al metodo estaEnViajeResponsable)
	 */
	public void crearViaje(Destino d, int cantPasajeros,int ocupadoCama, Transporte t,LinkedList<Responsable> lista){
				/**
				 * Controla que el transporte sea cama, y que la cantidad de pasajeros sea menor que la capacidad
				 */
					if(t instanceof Cama && cantPasajeros<=t.getCapacidad()){
						if(ocupadoCama<=26 && ocupadoCama<=cantPasajeros){
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
	
	/**
	 * Finaliza un viaje, lo elimina de la lista de viajes pendientes y lo agrega a
	 * la lista de viajes terminados, liberando los recursos transporte y responsable
	 * en caso que lo haya, para poder usarlo en otro viaje
	 * @param v
	 */
	
	public void finalizarViaje(Viaje v){
		if(v.getKmsRecorridos()==v.getDestino().getKilometros()){
			this.listaViajesPendientes.remove(v);
			v.setEstado(estadoViaje.FINALIZADO);
			if(this.listaViajesTerminados==null) // si no tiene elementos
			{
				this.listaViajesTerminados= new LinkedList<Viaje>(); 
			}
			listaViajesTerminados.add(v);
		}
		
	}
	
	/**
	 * iniciar la simulación, inicia todos los viajes de la lista
	 */
	public void iniciarViajePendiente(Viaje v,long timeStamp){
		int i=0;
		for(v.getKmsRecorridos();v.getKmsRecorridos()<v.getDestino().getKilometros();v.setKmsRecorridos(i*(v.getTransporte().getVelocidad()))){
			i++;
			delaySegundos();
			v.setEstado(estadoViaje.EN_CURSO);
			System.out.println("Nombre Viaje: "+v.getNombre()+" KMs totales: "+v.getDestino().getKilometros()+" Cant. Pasajeros: "+v.getCantPasajeros()+
					" Transporte: "+v.getTransporte().getPatente()+ /*" Valor: "+v.Costo()+*/" KMs recorridos: "+v.getKmsRecorridos()+
					" Porcentaje: "+v.getKmsRecorridos()*100/v.getDestino().getKilometros()+" Estado: "+v.getEstado());
		}
		if(v.getKmsRecorridos()>v.getDestino().getKilometros()){
			v.setKmsRecorridos(v.getDestino().getKilometros());
			finalizarViaje(v);
		}
	}
	
	private static void delaySegundos(){
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){}
	}
	
	/**
	 * pausar la simulación, detiene todos los viajes de la lista
	 */
	public void detenerViajePendiente(Viaje v,long timeStamp){
		v.setEstado(estadoViaje.PENDIENTE);
		System.out.println("Nombre Viaje: "+v.getNombre()+" KMs totales: "+v.getDestino().getKilometros()+" Cant. Pasajeros: "+v.getCantPasajeros()+
				" Transporte: "+v.getTransporte().getPatente()+ /*" Valor: "+v.Costo()+*/" KMs recorridos: "+v.getKmsRecorridos()+
				" Porcentaje: "+v.getKmsRecorridos()*100/v.getDestino().getKilometros()+" Estado: "+v.getEstado());
		if(v.getKmsRecorridos()==v.getDestino().getKilometros()){
			finalizarViaje(v);
		}
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
	
				escribir.write("DNI \t \t");
				escribir.write("Nombre \t \t");
				escribir.write("Kilometros recorridos\n");
				Responsable resp=null;
				ListIterator <Responsable> itera= listaAux2.listIterator();
				while(itera.hasNext()) {
					resp=itera.next();
					escribir.write(resp.getNombre()+"\t \t");
					escribir.write(resp.getDni()+"\t \t");
					escribir.write(resp.getSueldoFijo()+"\n");
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
public ArrayList<String> getListaDestino (){
	ArrayList<String> aux = null;
	ListIterator <Destino> iterador = listaDestino.listIterator();
	Destino nodoDestino=iterador.next();
		aux.add(nodoDestino.getCiudad());
	return aux;
		}




} 
