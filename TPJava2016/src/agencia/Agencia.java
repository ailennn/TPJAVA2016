package agencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.Exception;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import control.Validaciones;
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
	private DefaultListModel<Responsable> aux; 
	private DefaultListModel <Transporte> aux2; 

	
	
	
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
		
	public LinkedList<Viaje> getListaViajesPendientes() {
		return listaViajesPendientes;
	}

	/**
	 * Si el transporte no esta en la lista de viajes pendientes
  	 * Recorre las listas de viajes terminados.
	 * Si el transporte no está en ninguna de las listas, esta disponible
	 * para hacer modificarlo o eliminarlo.
	 * @param patente
	 * @return
	 */
	public boolean estaOcupadoTransporte(String patente){
		boolean esta=false;
		if(!estaEnViajeTransporte(patente)){
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
		}
		else
			esta=true;
		return esta;
	}
	
	/**
	 * Si el responsable no esta en la lista de viajes pendientes
 	 * recorre las listas de viajes terminados.
	 * Si el responsable no está en ninguna de las listas, esta disponible
	 * para modificarlo o eliminarlo.
	 * @param patente
	 * @return
	 */
	public boolean estaOcupadoResponsable(long dni){
		boolean esta=false;
		if(!estaEnViajeResponsable(dni)){
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
		}
		else
			esta=true;
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
	 * Crea la lista de transportes en caso de que sea null 
	 */ 
	 public void setListaTransporte(Transporte nuevo) throws Exception{ 
	 	if(this.listaTransporte==null) // si no tiene elementos 
	 		this.listaTransporte= new LinkedList<Transporte>(); 
	 	if(listaTransporte.contains(nuevo)) 
	 		throw new Exception("Transporte existente"); 
	 	else{ 
	 		nuevo.setCapacidad(); 
	 		listaTransporte.add(nuevo); 
	 	} 
	 } 
	 	 
	 /** 
		* Validar la patente y la velocidad promedio de un transporte 
	  * @param pat 
	  * @param veloc 
	  * @return 
	  */ 
	 public boolean validarPatenteVelocidad(String pat, int veloc){ 
	 	if(!Validaciones.esNumero(Integer.toString(veloc)) || !Validaciones.esNumeroMayorCero(Integer.toString(veloc))){ 
	 		JOptionPane.showMessageDialog(null, "Error en el ingreso de velocidad"); 
	 		return false; 
	 	} 
	 	else 
			if(Validaciones.formatoPatenteOk(pat)){ 
				JOptionPane.showMessageDialog(null, "Error en el ingreso de la patente"); 
	 			return false; 
	 		} 
	 		else
	 			return true; 
	 } 

	
	/**
	 * Metodo para crear un auto
	 * @param pat
	 * @param veloc
	 */
	 public void altaAuto(String pat, int veloc) throws Exception{ 
	 	if(validarPatenteVelocidad(pat,veloc)){ 
	 		Auto nuevo = new Auto (pat,veloc); 
	 		setListaTransporte(nuevo); 
	 	} 
	} 

	
	/**
	 * Metodo para crear una combi
	 * @param pat
	 * @param veloc
	 */
	 public void altaCombi(String pat, int veloc) throws Exception{ 
		if(validarPatenteVelocidad(pat,veloc)){ 
		 	Combi nuevo = new Combi (pat, veloc); 
		 	setListaTransporte(nuevo); 
		 } 
	} 

	
	/**
	 * Metodo para crear un coche semi cama
	 * @param pat
	 * @param veloc
	 */
	 public void altaSemiCama (String pat, int veloc) throws Exception{ 
		if(validarPatenteVelocidad(pat,veloc)){ 
			SemiCama nuevo = new SemiCama (pat, veloc); 
			setListaTransporte(nuevo); 
		} 
 	} 

	
	/**
	 * Metodo para crear un coche cama
	 * @param pat
	 * @param veloc
	 */
	 public void altaCama (String pat, int veloc) throws Exception{ 
 		if(validarPatenteVelocidad(pat,veloc)){ 
			Cama nuevo = new Cama (pat, veloc); 
			setListaTransporte(nuevo); 
 		} 
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
					if(validarPatenteVelocidad(patModif,velModif)){ 
						nodoTransporte.setPatente(patModif); 
						nodoTransporte.setVelocidad(velModif); 
						iterador4.set(nodoTransporte); 
 						encontro=true; 
					} 
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
	 * Validar los datos de un responsable, que se pasan por parametro 
	 * @param nomb 
	 * @param DNI 
	 * @param sueldo 
	 * @return 
	 */ 
	public boolean validarDatosResponsable(String nomb, long DNI, double sueldo){ 
		if(!Validaciones.sonLetras(nomb)){ 
			JOptionPane.showMessageDialog(null, "Error en el ingreso del nombre"); 
			return false; 
		} 
		if(Validaciones.esReal(Long.toString(DNI)) || Validaciones.sonLetras(Long.toString(DNI)) || !Validaciones.esNumeroMayorCero(Long.toString(DNI))){ 
			JOptionPane.showMessageDialog(null, "Error en el ingreso del dni"); 
			return false; 
		} 
		else 
			if(Validaciones.sonLetras(Double.toString(sueldo)) || !Validaciones.esNumeroMayorCero(Double.toString(sueldo))){ 
				JOptionPane.showMessageDialog(null, "Error en el ingreso del sueldo"); 
				return false; 
			} 
			else 
				return true; 
	} 

	
	
	/**
	 * Metodo para crear un responsable
	 * @param nomb
	 * @param DNI
	 * @param sueldo
	 */
	public void altaResponsable (String nomb, long DNI, double sueldo) throws Exception{ 
			if(validarDatosResponsable(nomb, DNI, sueldo)){ 
				Responsable nuevo = new Responsable (nomb, DNI, sueldo); 
				if(this.listaResponsable==null) // si no tiene elementos 
					this.listaResponsable= new LinkedList<Responsable>();  
				if(listaTransporte.contains(nuevo)) 
					throw new Exception("Responsable existente"); 
				else 
					listaResponsable.add(nuevo); 
			}			 
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
					if(validarDatosResponsable(nombreModif, dniModif, sueldoModif)){ 
						nodoResponsable.setDni(dniModif); 
						nodoResponsable.setSueldoFijo(sueldoModif); 
						nodoResponsable.setNombre(nombreModif); 
						iterador4.set(nodoResponsable); 
						encontro=true; 
					}
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
	
	/** 
	 * Settea el nombre del viaje, si la lista de viajes pendientes es nula la crea 
	 * y agrega el viaje a la lista 
	 * @param v 
	 */ 
	public void setListaViajesPendientes(Viaje v){ 
		v.setNombre(); 
		if(this.listaViajesPendientes==null) // si no tiene elementos 
		{ 
			this.listaViajesPendientes= new LinkedList<Viaje>();  
		} 
		listaViajesPendientes.add(v);  
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
		if(Validaciones.esNumero(Integer.toString(cantPasajeros)) && Validaciones.esNumeroMayorCero(Integer.toString(cantPasajeros))){ 
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
					Viaje v= new CortaDistancia(t,d,cantPasajeros); 
					setListaViajesPendientes(v); 
				} 
				else 
					JOptionPane.showMessageDialog(null, "Error en el ingreso de la cantidad de pasajeros"); 
			} 
			else 
				JOptionPane.showMessageDialog(null, "Error en el ingreso de transporte"); 
		} 
		else 
			JOptionPane.showMessageDialog(null, "Error en el ingreso de la cantidad de pasajeros"); 
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
		if(Validaciones.esNumero(Integer.toString(cantPasajeros)) && Validaciones.esNumeroMayorCero(Integer.toString(cantPasajeros))){ 
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
					Viaje v=new LargaDistancia(t,d,cantPasajeros,lista); 
					setListaViajesPendientes(v); 
				} 
				else 
					JOptionPane.showMessageDialog(null, "Error en el ingreso de la cantidad de pasajeros"); 
			} 
			else 
				JOptionPane.showMessageDialog(null, "Error en el ingreso de transporte"); 
		} 
		else 
			JOptionPane.showMessageDialog(null, "Error en el ingreso de  la cantidad de pasajeros"); 
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
		if(Validaciones.esNumero(Integer.toString(cantPasajeros)) && Validaciones.esNumeroMayorCero(Integer.toString(cantPasajeros))){ 
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
					Viaje v=new LargaDistancia(t,d,cantPasajeros,lista); 
					setListaViajesPendientes(v); 
				} 
				else 
					JOptionPane.showMessageDialog(null, "Error en el ingreso de la cantidad de asientos tipo cama"); 
			} 
			else 
				JOptionPane.showMessageDialog(null, "Error en el ingreso de transporte o la cantidad de pasajeros"); 
		} 
		else 
			JOptionPane.showMessageDialog(null, "Error en el ingreso de la cantidad de pasajeros"); 
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
					" Transporte: "+v.getTransporte().getClass().getName()+ " Valor: "+v.Costo()+" KMs recorridos: "+v.getKmsRecorridos()+
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
				" Transporte: "+v.getTransporte().getClass().getName()+ " Valor: "+v.Costo()+" KMs recorridos: "+v.getKmsRecorridos()+
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
	
	 /** Para recorrer la lista en la clase test, y ver si los métodos funcionan bien  
	 * @param listaViajesPendientes  
	  */  
	 public void recorreListaViaje(LinkedList<Viaje> listaViajesPendietes) {  
	 		  
	 	Viaje nodoViaje= null;  
	 	ListIterator <Viaje> iterador= listaViajesPendientes.listIterator();  
	 	while(iterador.hasNext()){  
	 		nodoViaje=iterador.next();  
	 		System.out.println(nodoViaje.getNombre());  
	 	}					   
	 }  

	
	/** Recorre la lista de responsables, pasa el objeto para usar como DLM en un Jlist 
	 * @return 
	 */ 
	public DefaultListModel<Responsable> getListaResponsable (){ 
		aux = null; 
		ListIterator <Responsable> iterador = listaResponsable.listIterator(); 
		Responsable nodoResponsable=iterador.next(); 
		while (iterador.hasNext()){ 
	 		aux.addElement(nodoResponsable); 
	 		nodoResponsable=iterador.next(); 
	 	} 
	 		 
	 	return aux; 
	 } 
	
	 /** 
	  * Recorre la lista de transportes, pasa el objeto para usar como DLM en un Jlist 
	  */ 
	public DefaultListModel<Transporte> getListaTransporte () { 
		aux2 = null; 
		ListIterator <Transporte> iterador = listaTransporte.listIterator(); 
	 	Transporte nodoTransporte = iterador.next(); 
	 	while (iterador.hasNext()){ 
	 		aux2.addElement(nodoTransporte); 
			nodoTransporte=iterador.next(); 
	 	}	 
	 	return aux2; 
	 } 

	
	
	public ArrayList<String> getListaDestino (){
		ArrayList<String> aux = null;
		ListIterator <Destino> iterador = listaDestino.listIterator();
		Destino nodoDestino=iterador.next();
			aux.add(nodoDestino.getCiudad());
		return aux;
	}

} 
