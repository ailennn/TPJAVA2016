package viaje;

import misc.*;
import transporte.Transporte;

public abstract class Viaje {
	private String nombre;
	private enum estadoViaje{
		PENDIENTE, EN_CURSO, FINALIZADO
	}
	private int kmsRecorridos;
	private Transporte transporte;
	private Responsable responsable;
	private Destino destino;
	
	public Viaje() {
		nombre=null;
		transporte=null;
		responsable=null;
		destino=null;
		kmsRecorridos=0;
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
	public Responsable getResponsable() {
		return responsable;
	}
	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	public Viaje(Transporte transporte, Responsable responsable, Destino destino) {
		super();
		this.transporte = transporte;
		this.responsable = responsable;
		this.destino = destino;
	}
	
	/**CALCULAR COSTO VIAJE*/
	public float Costo(){return 0;}
}
