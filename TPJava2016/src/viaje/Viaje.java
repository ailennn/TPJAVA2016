package viaje;

import java.util.LinkedList;

import misc.*;
import transporte.Transporte;

public abstract class Viaje {
	private String nombre;
	//En internet los enum estan public, y asi pude hacer bien el constructor de corta distancia
	//pero no entiendo mucho como usar los estados (ponerlo en curso, pendiente, etc), hay que investigar
	public enum estadoViaje{
		PENDIENTE, EN_CURSO, FINALIZADO
	}
	
	private int kmsRecorridos;
	private Transporte transporte;
	private Destino destino;
	private int cantPasajeros;
	private estadoViaje estado;
	protected LinkedList<Responsable> listaResponsable=null;
	
	/**
	 * Siempre que se crea un viaje, se crea con estado PENDIENTE. 
	 * Al iniciarlo y detenerlo (simulacion) se pasa a estado EN_CURSO y PENDIENTE
	 * segun corresponda. Cuando finaliza el viaje, se pasa a estado FINALIZADO
	 * @param nombre
	 * @param transporte
	 * @param destino
	 * @param cantPasajeros
	 */
	public Viaje(Transporte transporte, Destino destino, int cantPasajeros){
		super();
		this.transporte = transporte;
		this.destino = destino;
		this.cantPasajeros = cantPasajeros;
		this.estado=estadoViaje.PENDIENTE;
	}

	public Viaje() {
		nombre=null;
		estado=estadoViaje.PENDIENTE;
		transporte=null;
		destino=null;
		kmsRecorridos=0;
		cantPasajeros=0;
	}
	
	public estadoViaje getEstado() {
		return estado;
	}

	public void setEstado(estadoViaje estado) {
		this.estado = estado;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LinkedList<Responsable> getListaResponsable() {
		return listaResponsable;
	}

	public void setListaResponsable(LinkedList<Responsable> listaResponsable) {
		this.listaResponsable = null;
	}
	
	public int getCantPasajeros() {
		return cantPasajeros;
	}

	public void setCantPasajeros(int cantPasajeros) {
		this.cantPasajeros = cantPasajeros;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre() {
		this.nombre = destino.getCiudad()+Integer.toString(destino.getContador());
	}

	public int getKmsRecorridos() {
		return kmsRecorridos;
	}

	public void setKmsRecorridos(int kmsRecorridos) {
		this.kmsRecorridos = kmsRecorridos;
	}

	public Transporte getTransporte() {
		return transporte;
	}
	
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	public Destino getDestino() {
		return destino;
	}
	
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
	/**CALCULAR COSTO VIAJE*/
	public double Costo(){return 0;}
}
