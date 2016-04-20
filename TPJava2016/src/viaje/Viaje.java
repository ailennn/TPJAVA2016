package viaje;

import misc.*;
import transporte.Transporte;

public abstract class Viaje {
	private String nombre;
	//En internet los enum estan public, y asi pude hacer bien el constructor de corta distancia
	//pero no entiendo mucho como usar los estados (ponerlo en curso, pendiente, etc), hay que investigar
	public enum estadoViaje{
		PENDIENTE, EN_CURSO, FINALIZADO
	}
	private estadoViaje estado;
	private int kmsRecorridos;
	private Transporte transporte;
	private Destino destino;
	private int cantPasajeros;
	
	
	public Viaje(String nombre, estadoViaje estado, int kmsRecorridos, Transporte transporte,
			Destino destino,int cantPasajeros) {
		super();
		this.nombre = nombre;
		this.estado = estado;
		this.kmsRecorridos = kmsRecorridos;
		this.transporte = transporte;
		this.destino = destino;
		this.cantPasajeros = cantPasajeros;
	}

	public Viaje() {
		nombre=null;
		estado=null;
		transporte=null;
		destino=null;
		kmsRecorridos=0;
		cantPasajeros=0;
	}
	
	public int getCantPasajeros() {
		return cantPasajeros;
	}

	public void setCantPasajeros(int cantPasajeros) {
		this.cantPasajeros = cantPasajeros;
	}

	public estadoViaje getEstado(){
		return estado;
	}
	
	public void setEstado(estadoViaje estado){
		this.estado=estado;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre() {
		this.nombre = destino.toString()+Integer.toString(destino.getContador());
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
	public float Costo(){return 0;}
}
