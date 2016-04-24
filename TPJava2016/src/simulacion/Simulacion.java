package simulacion;

import java.util.*;
import agencia.Agencia;
import viaje.*;

public class Simulacion implements Runnable {
	private Viaje viaje;
	private Agencia agencia;
	private long initialTime;
	
	/* chicas:
	 * Descomentar el public static void main(String[] args) { y el agencia.setListaViajesPendientes();
	 * y comentar el public IniciarSimulacion (Viaje viaje, Agencia agencia, long initialTime){
	 * si quieren ver como funciona la simulacion
	 */
	//public static void main(String[] args) {
	public Simulacion (Viaje viaje, Agencia agencia, long initialTime){
		this.agencia = agencia;
		this.viaje = viaje;
		this.initialTime = initialTime;
	}
	
	public static void inicio() {
		// TODO Auto-generated method stub
		Agencia agencia = new Agencia();
		//agencia.setListaViajesPendientes();
		ListIterator<Viaje> iterador=agencia.getListaViajesPendientes().listIterator();
		Viaje v=null;
		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		
		while(iterador.hasNext()){
			v=iterador.next();
			Runnable proceso = new Simulacion(v,agencia,initialTime);
			new Thread(proceso).start();
		}

	}

	@Override
	public void run() {
		this.agencia.iniciarViajePendiente(this.viaje,this.initialTime);
	}
	
	public static void detener() {
		// TODO Auto-generated method stub
		Agencia agencia = new Agencia();
		//agencia.setListaViajesPendientes();
		ListIterator<Viaje> iterador=agencia.getListaViajesPendientes().listIterator();
		Viaje v=null;
		// Tiempo inicial de referencia
		long finalTime = System.currentTimeMillis();
		
		while(iterador.hasNext()){
			v=iterador.next();
			Runnable proceso = new Simulacion(v,agencia,finalTime);
			new Thread(proceso).interrupt(); 
		}
	}

}
