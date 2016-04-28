package agencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import GUI.Validaciones;
import misc.Destino;
import misc.Responsable;
import transporte.Auto;
import transporte.Cama;
import transporte.Combi;
import transporte.SemiCama;
import transporte.Transporte;
import viaje.CortaDistancia;
import viaje.LargaDistancia;
import viaje.Viaje;
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
		/*else
			if(Validaciones."lo de la patente"(pat)){
				JOptionPane.showMessageDialog(null, "Error en el ingreso de la patente");
				return false;
			}*/
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
		if(!Validaciones.esNumero(Integer.toString(cantPasajeros)) && !Validaciones.esNumeroMayorCero(Integer.toString(cantPasajeros))){
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
					Viaje v= new CortaDistancia("",t,d,cantPasajeros);
					setListaViajesPendientes(v);
				}
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Error en el ingreso de datos");
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
		if(!Validaciones.esNumero(Integer.toString(cantPasajeros)) && !Validaciones.esNumeroMayorCero(Integer.toString(cantPasajeros))){
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
					Viaje v=new LargaDistancia("",t,d,cantPasajeros,lista);
					setListaViajesPendientes(v);
				}
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Error en el ingreso de datos");
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
		if(!Validaciones.esNumero(Integer.toString(cantPasajeros)) && !Validaciones.esNumeroMayorCero(Integer.toString(cantPasajeros))){
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
							Viaje v=new LargaDistancia("",t,d,cantPasajeros,lista);
							setListaViajesPendientes(v);
						}
					}
		}
		else
			JOptionPane.showMessageDialog(null, "Error en el ingreso de datos");
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
	
	/**
	 * Ordena la lista por dni de responsables
	 * @param listaAux
	 */
	private void OrdenarPorResponsables(LinkedList<Responsable> listaAux){
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
	 * Ordena la lista por kilometros recorridos, de mayor a menor
	 * @param listaAux
	 */
	private void OrdenarPorKilometrosRecorridos(LinkedList<Responsable> listaAux){
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
	
	public void ranking() throws Exception{
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
					throw new Exception("No se puede crear el archivo");
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
					escribir.write(resp.getDni()+"\t \t");
					escribir.write(resp.getNombre()+"\t \t");
					escribir.write(resp.getSueldoFijo()+"\n");
				}
				escribir.close();
				} catch (Exception e) {throw new Exception("No se puede escribir el archivo");}
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

/**
 * Recorre la lista de responsables, pasa el objeto para usar como DLM en un Jlist
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

}//LLAVE FIN CLASE 
