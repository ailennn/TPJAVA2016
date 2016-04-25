package simulacion;

import java.util.*;
import agencia.Agencia;
import viaje.*;

public class Simulacion implements Runnable {
	private Viaje viaje;
	private Agencia agencia;
	private long initialTime;
	private static boolean pausa=false;
	
	public Simulacion (Viaje viaje, Agencia agencia, long initialTime){
		this.agencia = agencia;
		this.viaje = viaje;
		this.initialTime = initialTime;
	}
	
	public static void inicio(Viaje v, Agencia agencia, long initialTime) {
		// TODO Auto-generated method stub
		//agencia.setListaViajesPendientes();
		ListIterator<Viaje> iterador=agencia.getListaViajesPendientes().listIterator();
		// Tiempo inicial de referencia
		initialTime = System.currentTimeMillis();
		
		while(iterador.hasNext()){
			v=iterador.next();
			Runnable proceso = new Simulacion(v,agencia,initialTime);
			if(pausa==false)
				new Thread(proceso).start();
			else{
				new Thread(proceso).notifyAll();
				pausa=false;
			}
		}

	}

	@Override
	public void run() {
		this.agencia.iniciarViajePendiente(this.viaje,this.initialTime);
	}
	
	/*
	public static void detener(Viaje v, Agencia agencia, long finalTime) {
		// TODO Auto-generated method stub
		//agencia.setListaViajesPendientes();
		ListIterator<Viaje> iterador=agencia.getListaViajesPendientes().listIterator();
		// Tiempo inicial de referencia
		finalTime = System.currentTimeMillis();
		
		while(iterador.hasNext()){
			v=iterador.next();
			Runnable proceso = new Simulacion(v,agencia,finalTime);
			try {
				new Thread(proceso).wait();
				pausa=true;
				agencia.detenerViajePendiente(v,finalTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/

}
