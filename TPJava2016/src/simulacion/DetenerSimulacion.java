package simulacion;

import java.util.ListIterator;

import agencia.Agencia;
import viaje.Viaje;

public class DetenerSimulacion implements Runnable {
	private Viaje viaje;
	private Agencia agencia;
	private long finalTime;
	
	public DetenerSimulacion (Viaje viaje, Agencia agencia, long finalTime){
		this.agencia = agencia;
		this.viaje = viaje;
		this.finalTime = finalTime;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Agencia agencia = new Agencia();
		agencia.setListaViajesPendientes();
		ListIterator<Viaje> iterador=agencia.getListaViajesPendientes().listIterator();
		Viaje v=null;
		// Tiempo inicial de referencia
		long finalTime = System.currentTimeMillis();
		
		while(iterador.hasNext()){
			v=iterador.next();
			Runnable proceso = new DetenerSimulacion(v,agencia,finalTime);
			new Thread(proceso).interrupt();
		}

	}

	@Override
	public void run() {
		this.agencia.detenerViajePendiente(this.viaje,this.finalTime);
	}
}
