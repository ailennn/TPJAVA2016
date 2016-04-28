package misc;
import java.io.*;
import java.lang.Exception;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import transporte.*;
import agencia.Agencia;
import viaje.*;
import misc.*;

import org.junit.Test; 

/**
 * Clase utilizada para probar el funcionamiento de todos los metodos por consola (sin interfaz grafica).  
 */

public class test {
	@Test
	public void test() throws Exception{
				
		//******************  Armado de las listas **********************
		
		LinkedList<Transporte> listaTransporte= new LinkedList<Transporte>();
		LinkedList<Responsable> listaResponsable= new LinkedList<Responsable>();
		LinkedList<Viaje> listaViajesTerminados= new LinkedList<Viaje>();
		LinkedList<Viaje> listaViajesPendientes= new LinkedList<Viaje>();
		LinkedList<Destino> listaDestino =new LinkedList<Destino>();

		
		Transporte t1= new Auto("AAA000", 100);
		t1.setCapacidad();
		Transporte t2= new Combi("AAA001", 90);
		t2.setCapacidad();
		Transporte t3= new SemiCama("AAA002",88);
		t3.setCapacidad();
		Transporte t4= new Cama("AAA003",88);
		Responsable r1= new Responsable("Flor", 35797200, 500.5);
		Responsable r2= new Responsable("Giu", 33333333, 555.2);
		Responsable r3= new Responsable("Ailen", 34444444, 580.7);
		Responsable r4= new Responsable("Jeje", 22222222, 450.5);
		Responsable r5= new Responsable("Jaja", 30303030, 4100.4);
		
		Destino d1= new Destino("Los Toldos",600);
		Destino d2= new Destino("Balcarce",60);
		
		LinkedList<Responsable>listaResponsable2=new LinkedList<Responsable>();
		listaResponsable2.add(r1);
		LinkedList<Responsable>listaResponsable3=new LinkedList<Responsable>();
		listaResponsable3.add(r3);
		listaResponsable3.add(r1);
		
		
		Viaje v1=new CortaDistancia(t1,d2, 2);
		Viaje v2=new LargaDistancia(t2,d1, 5,listaResponsable2);
		Viaje v3=new LargaDistancia(t4,d1, 8,listaResponsable3);
		
		v1.setNombre();
		v2.setNombre();
		v3.setNombre();
		
		v1.setKmsRecorridos(v1.getDestino().getKilometros());
		v2.setKmsRecorridos(v2.getDestino().getKilometros());
		v3.setKmsRecorridos(v3.getDestino().getKilometros());
		
		listaViajesTerminados.add(v2);
		listaViajesTerminados.add(v1);
		
		listaViajesTerminados.add(v3);
		listaViajesPendientes=null;
		//listaViajesTerminados=null;
		
		listaDestino.add(d1);
		listaDestino.add(d2);
		
		Agencia a=new Agencia();
		/*
		a.altaAuto("AAA000", 100);
		a.altaCombi("AAA001", 80);
		a.modificaTransporte("AAA000", "AAB000", 90);
		a.bajaTransporte("AAA001");
		//a.recorreListaTransporte(a.obtListaTransporte());
		
		a.crearViaje(d1, 2, t1);
		System.out.println("lista: ");
		a.recorreListaViaje(listaViajesPendientes);
		
/* ******************************************************************************************************************************************/ 

		recaudacion(listaViajesTerminados);
		/*if(esNumeroMayorCero("-1"))
			System.out.println("bien");
		else
			JOptionPane.showMessageDialog(null, "Error, no ingrese numeros negativos");
			
		*/
		
}
	

	
 // ********************************************************************************************************************************************/
	
	public static boolean esNumeroMayorCero(String cadena) {
        cadena = cadena.trim();
        try {
            Integer.parseUnsignedInt(cadena);
	    return true;} 
        catch (NumberFormatException nfe) {
	            return false;
	        }
    }
	
	public void recaudacion(LinkedList<Viaje>listaViajesTerminados) throws Exception{
		Viaje v=null;
		int suma=0;
		LinkedList<Viaje>listaTerminados=listaViajesTerminados;
		ListIterator<Viaje>iterador=listaTerminados.listIterator();
		while(iterador.hasNext()){
			v=iterador.next();	
			suma+=v.Costo();
		}
		System.out.println(v.Costo());
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
	
}
