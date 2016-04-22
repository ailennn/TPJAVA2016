package misc;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import transporte.*;
import agencia.Agencia;
import viaje.*;
import misc.*;

import org.junit.Test; 

/**
 * Clase utilizada para probar el funcionamiento de todos los metodos por consola (sin interfaz grafica)  
 */

public class test {
	@Test
	public void test() throws FileNotFoundException{
				
		//******************  Armado de las listas **********************
		
		LinkedList<Transporte> listaTransporte= new LinkedList<Transporte>();
		LinkedList<Responsable> listaResponsable= new LinkedList<Responsable>();
		LinkedList<Viaje> listaViajesTerminados= new LinkedList<Viaje>();
		LinkedList<Viaje> listaViajesPendientes= new LinkedList<Viaje>();
		
		
		Agencia obA = new Agencia(); 
		
		System.out.println("Armado de las listas de la agencia obA");
		
		/*obA.altaTransporte();
		obA.altaTransporte();
		obA.altaTransporte();
		obA.altaTransporte();
		obA.altaResponsable();
		obA.altaResponsable();
		obA.altaResponsable();
		obA.altaResponsable();
		obA.altaResponsable();*/
		
		Transporte t1= new Auto("AAA000", 100.1, 2);
		Transporte t2= new Combi("AAA001", 90.5, 8);
		Transporte t3= new SemiCama("AAA002", 95.6, 30);
		Transporte t4= new Cama("AAA003",88.3,20,2);
		Responsable r1= new Responsable("Flor", 35797200, 500.5);
		Responsable r2= new Responsable("Giu", 33333333, 555.2);
		Responsable r3= new Responsable("Ailen", 34444444, 599.7);
		Responsable r4= new Responsable("Jeje", 22222222, 450.5);
		Responsable r5= new Responsable("Jaja", 30303030, 4100.4);
		
		listaTransporte.add(t1);
		listaTransporte.add(t2);
		listaTransporte.add(t3);
		listaTransporte.add(t4);
		
		listaResponsable.add(r1);
		listaResponsable.add(r2);
		listaResponsable.add(r3);
		listaResponsable.add(r4);
		listaResponsable.add(r5);
			
			
/* ******************************************************************************************************************************************/ 
		//RecorreLista(obG.getLAlbum());
		//obG.listado();
		//reproducir(LArchivo,obG.getLArchivoMultimedia() );
		
}
	

	
 // ********************************************************************************************************************************************/
	
/*public void RecorreLista(LinkedList<Album> Lgestor) {
		 
		
		Album nodoAlbAux= new Album();
		ListIterator <Album> iterador= Lgestor.listIterator();
		while(iterador.hasNext()){
			nodoAlbAux=iterador.next();
			
			System.out.println(nodoAlbAux.getNombre());	// Primero muestra los archivos sueltos de este album
		
			if(nodoAlbAux.getLArchivoMultimedia()!=null) 
			{
				ArchivoMultimedia nodoArcAux = null; 
				ListIterator <ArchivoMultimedia> itrArchivo= nodoAlbAux.getLArchivoMultimedia().listIterator();
				while(itrArchivo.hasNext()){
					nodoArcAux=itrArchivo.next();
					System.out.println(nodoArcAux.getNombre()); 	// Muestra los Subalbumes 
				}				
			}
			// Luego continua recorriendo los subnodos si los tuviera			
			if(nodoAlbAux.getLAlbum()!=null) {
					RecorreLista(nodoAlbAux.getLAlbum());
			}
		}				
			 
}

public void RecorreListaArch(LinkedList<ArchivoMultimedia> LArchi) {
	ArchivoMultimedia nodoAux= null;
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	ListIterator <ArchivoMultimedia> iteradorA= LArchi.listIterator();
	while(iteradorA.hasNext()){
		nodoAux=iteradorA.next();
		System.out.println(nodoAux.getTipo()+" "+nodoAux.getNombre()+" 	"+formato.format(nodoAux.getUltimaReproduccion().getTime()));
		System.out.printf("\n Tama�o: %f",nodoAux.getTama�o());
		// Primero muestra los archivos sueltos de este album
	}				
		 
}*/


/* ********************************************** */
//Reproduccion de archivos, mostrando duracion total y atributos
/*public void reproducir(LinkedList <ArchivoMultimedia> ListaReproduccion,LinkedList <ArchivoMultimedia> listaCompleta ){


	System.out.printf("\n NOMBRE \t     DURACI�N  \t INICIO \t FIN  \t ANCHO \t ALTO \t RESOLUCION \t CANT. DE CUADROS");
	
	
	ArchivoMultimedia nodoAux=null;
	ArchivoMultimedia nodoAux2=null;
	ListIterator<ArchivoMultimedia> it= ListaReproduccion.listIterator();
	ListIterator<ArchivoMultimedia> it2= listaCompleta.listIterator();
	boolean encontro=false;
	//INICIO=etiquetas, FIN=ubicacion, DURACION=ubicacion-etiquetas, ZOOM=reproduccion
	while(it.hasNext()){
		nodoAux=it.next();
		int inicio=Integer.parseInt(nodoAux.getEtiquetas());
		int fin=Integer.parseInt(nodoAux.getUbicacion());
		if(nodoAux.getTipo()==0){//Si es audio
			String alto="No";
			String ancho="No";
			String resolucion="No";
			String cuadros="No";
			nodoAux.setReproducciones(nodoAux.getReproducciones()+1);
			Calendar fechaHoy = new GregorianCalendar();
	        int a�o = fechaHoy.get(Calendar.YEAR);
	        int mes = fechaHoy.get(Calendar.MONTH);
	        int dia = fechaHoy.get(Calendar.DAY_OF_MONTH);
			nodoAux.setUltimaReproduccion(fechaHoy);
			if(fin==0){
				while(it2.hasNext() && !encontro){
					nodoAux2=it2.next();
					if(nodoAux2.getTipo()==nodoAux.getTipo() && nodoAux2.getNombre()==nodoAux.getNombre()){
						encontro=true;
						fin=nodoAux2.getDuracion();
					}
				}
			}
			System.out.printf("\n %s \t %d \t %d \t \t %d \t %s \t %s \t %s \t \t %s",nodoAux.getNombre(), fin-inicio, inicio, fin, alto, ancho, resolucion, cuadros);
		}
		else{
			if(nodoAux.getTipo()==1){ //Si es imagen 
			int alto=0;
			int ancho=0;
			String cuadros="No";
			encontro=false;
			nodoAux.setReproducciones(nodoAux.getReproducciones()+1);
			Calendar fechaHoy = new GregorianCalendar();
	        int a�o = fechaHoy.get(Calendar.YEAR);
	        int mes = fechaHoy.get(Calendar.MONTH);
	        int dia = fechaHoy.get(Calendar.DAY_OF_MONTH);
			nodoAux.setUltimaReproduccion(fechaHoy);
				while(it2.hasNext() && !encontro){
						nodoAux2=it2.next();
						if(nodoAux2.getTipo()==nodoAux.getTipo() && nodoAux2.getNombre()==nodoAux.getNombre()){
							encontro=true;
							if(nodoAux.getReproducciones()!=0){
								ancho=nodoAux2.getAncho()*nodoAux.getReproducciones();
								alto=nodoAux2.getAlto()*nodoAux.getReproducciones();
							}
							else{
								ancho=nodoAux2.getAncho();
								alto=nodoAux2.getAlto();
						}
						if (fin==0){
							fin=nodoAux2.getDuracion();
						}
					}
				}
						String resolucion="No";
						System.out.printf("\n %s \t %d \t %d \t \t %d \t %d \t %d \t %s \t \t %s",nodoAux.getNombre(), fin-inicio, inicio, fin, ancho, alto, resolucion, cuadros);
				}
			if(nodoAux.getTipo()==2){ //Si es video
				int resolucion=0;
				String alto="No";
				String ancho="No";
				encontro=false;
				nodoAux.setReproducciones(nodoAux.getReproducciones()+1);
				Calendar fechaHoy = new GregorianCalendar();
		        int a�o = fechaHoy.get(Calendar.YEAR);
		        int mes = fechaHoy.get(Calendar.MONTH);
		        int dia = fechaHoy.get(Calendar.DAY_OF_MONTH);
				nodoAux.setUltimaReproduccion(fechaHoy);
					while(it2.hasNext() && !encontro){
							nodoAux2=it2.next();
							if(nodoAux2.getTipo()==nodoAux.getTipo() && nodoAux2.getNombre()==nodoAux.getNombre()){
								encontro=true;
								if(nodoAux.getReproducciones()!=0){
									resolucion=nodoAux2.getResolucion()*nodoAux.getReproducciones();
								}
								else{
									resolucion=nodoAux2.getResolucion();
							}
							if (fin==0){
								fin=nodoAux2.getDuracion();
							}
						}
					}
							
							System.out.printf("\n %s \t \t %d \t %d \t \t %d \t %s \t %s \t %d \t \t %d",nodoAux.getNombre(), fin-inicio, inicio, fin, ancho, alto, resolucion, nodoAux.getCuadros());
			}
			}
			}
	}*/
}
