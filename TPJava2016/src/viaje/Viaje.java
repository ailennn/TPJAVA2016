package viaje;

import java.util.LinkedList;

import misc.*;
import transporte.Transporte;

public abstract class Viaje {
	private String nombre;
	//En internet los enum estan public, y asi pude hacer bien el constructor de corta distancia
	//pero no entiendo mucho como usar los estados (ponerlo en curso, pendiente, etc), hay que investigar
	/*public enum estadoViaje{
		PENDIENTE, EN_CURSO, FINALIZADO
	}*/
	private String estado;
	private int kmsRecorridos;
	private Transporte transporte;
	private Destino destino;
	private int cantPasajeros;
	protected LinkedList<Responsable> listaResponsable=null;
	
	public enum EstadoViaje {
		PENDIENTE("pendiente"), EN_CURSO("enCurso"), FINALIZADO ("finalizado");

		private EstadoViaje(String name) {
		}
	}
	
	public Viaje(String nombre, String estado, int kmsRecorridos, Transporte transporte,
			Destino destino,int cantPasajeros,LinkedList<Responsable> listaResponsable) {
		super();
		this.nombre = nombre;
		this.estado = estado;
		this.kmsRecorridos = kmsRecorridos;
		this.transporte = transporte;
		this.destino = destino;
		this.cantPasajeros = cantPasajeros;
		this.listaResponsable = null;
	}

	public Viaje() {
		nombre=null;
		estado=null;
		transporte=null;
		destino=null;
		kmsRecorridos=0;
		cantPasajeros=0;
		listaResponsable = null;
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

	public String getEstado(){
		return estado;
	}
	
	public void setEstado(String estado){
		this.estado=estado;
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
