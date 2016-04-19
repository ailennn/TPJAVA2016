package viaje;

import misc.*;
import transporte.Transporte;

public class Viaje {

	private Transporte transporte;
	private Responsable responsable;
	private Destino destino;
	
	
	
	public Viaje() {
		transporte=null;
		responsable=null;
		destino=null;
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
	public float Costo(){
		float suma=0;
		if (destino.getKilometros()<=100)
			suma+=transporte.getPrecioKm();
			
	}
}
