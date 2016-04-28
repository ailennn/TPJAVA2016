package reportes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.ListIterator;
import transporte.Transporte;
import viaje.Viaje;

public class Recaudacion {
	
	/**
	 * Recaudación de los viajes realizados por la empresa, 
	 * permitiendo ver la información total.
	 * Genera archivo de texto
	 */

	public void recaudacion(LinkedList<Viaje>listaViajesTerminados) throws Exception{
		Viaje v=null;
		int suma=0;
		
		LinkedList<Viaje>listaTerminados=listaViajesTerminados;
		ListIterator<Viaje>iterador=listaTerminados.listIterator();
		while(iterador.hasNext()){
			v=iterador.next();	
			suma+=v.Costo();
		}	
	
		File arctxt=new File("src//archivos//recaudacion.txt"); 
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
	
			escribir.write("Recaudacion Total: \t \t");
			escribir.write(suma+"\n");
			escribir.close();
			} catch (Exception e) {
				throw new Exception("No se puede escribir el archivo");
			}
	}
	
	/**
	 * Recaudación de los viajes realizados por la empresa, 
	 * permitiendo ver la información por cada transporte y/o cada destino.
	 * Genera archivo de texto
	 */
	
	public void recaudacion(LinkedList<Viaje>listaViajesTerminados,LinkedList<Transporte>listaTransporte) throws Exception{
		Viaje v=null;
		int suma=0;
		
		LinkedList<Viaje>listaTerminados=listaViajesTerminados;
		ListIterator<Viaje>iterador=listaTerminados.listIterator();
		while(iterador.hasNext()){
			v=iterador.next();	
			suma+=v.Costo();
		}	
	
		File arctxt=new File("src//archivos//Recaudacion.txt"); 
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
	
			escribir.write("Recaudacion Total: \t \t");
			escribir.write(suma+"\n");
			escribir.close();
			} catch (Exception e) {
				throw new Exception("No se puede escribir el archivo");
			}
	}
	
	/**
	 * Recaudación de los viajes realizados por la empresa, 
	 * permitiendo ver la información por cada destino.
	 * Genera archivo de texto
	 */
	/*
	public void recaudacion(LinkedList<Viaje>listaViajesTerminados,LinkedList<Destino>listaDestino) throws Exception{
		Viaje v=null;
		int suma=0;
		
		LinkedList<Viaje>listaTerminados=listaViajesTerminados;
		ListIterator<Viaje>iterador=listaTerminados.listIterator();
		while(iterador.hasNext()){
			v=iterador.next();	
			suma+=v.Costo();
		}	
	
		File arctxt=new File("src//archivos//Recaudacion.txt"); 
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
	
			escribir.write("Recaudacion Total: \t \t");
			escribir.write(suma+"\n");
			escribir.close();
			} catch (Exception e) {
				throw new Exception("No se puede escribir el archivo");
			}
	}
*/
}
