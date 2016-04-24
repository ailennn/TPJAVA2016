package simulacion;

import java.util.*;
import agencia.Agencia;
import viaje.*;

public class IniciarSimulacion implements Runnable {
	private Viaje viaje;
	private Agencia agencia;
	private long initialTime;
	
	public IniciarSimulacion (Viaje viaje, Agencia agencia, long initialTime){
		this.agencia = agencia;
		this.viaje = viaje;
		this.initialTime = initialTime;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Agencia agencia = new Agencia();
		agencia.setListaViajesPendientes();
		ListIterator<Viaje> iterador=agencia.getListaViajesPendientes().listIterator();
		Viaje v=null;
		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		
		while(iterador.hasNext()){
			v=iterador.next();
			Runnable proceso = new IniciarSimulacion(v,agencia,initialTime);
			new Thread(proceso).start();
		}

	}

	@Override
	public void run() {
		this.agencia.iniciarViajePendiente(this.viaje,this.initialTime);
	}


}
