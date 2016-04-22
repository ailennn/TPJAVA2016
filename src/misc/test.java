package misc;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.Test; //GIU Y AILEN: IMPORTANTE! HAY QUE AGREGAR EL JUNIT.JAR QUE AGREGO EN GITHUB. EN EL PROYECTO PONEN PROPERTIES,JAVA BUILD PATH, LIBRARIES, ADD EXTERNAL JAR, Y AHI BUSCAN EL JUNIT

/**
 * Clase utilizada para probar el funcionamiento de todos los metodos por consola (sin interfaz grafica)  
 */

public class test {
	@Test
	public void test() throws FileNotFoundException{
		
	//GIU Y AILEN: ESTA COMENTADO PARA TENERLO POR LAS DUDAS DE EJEMPLO
		
				
	// ******************  Armado de la estructura para prueba com albumes, subalbumes y Archivos para EJEMPLO **********************/
		
		/*LinkedList<Album> Lgestor= new LinkedList<Album>();

	
		GestorDeArchivo obG = new GestorDeArchivo(); 
		Calendar fecha = new GregorianCalendar(2015,01,03);
		
		System.out.println("Armado de la estructura de arbol. Contenido de obG");
		ewrwer
		
		obG.crearAudio("RockNacional3958",35.6,fecha2,fecha3,32,"ubicacion", "#Abuelos Opera",0,1515,192);
		obG.crearImagen("FotoViaje2014-05",2.5,fecha,fecha1,15,"ubicacion","#Rafting en #Mendoza", 1,5,320,110,5);
		obG.crearVideo("Noti20130910",153,fecha4,fecha5,5,"ubicacion", "Entrevista a #TomasCoca",2,480,720,30); //duracion va en segundos
		obG.agregarAlbum("Futbol");
		obG.agregarAlbum("Viajes");
		obG.agregarAlbum("Musica");
		obG.agregarAlbum("Fotos 2014");
		obG.agregarAlbum("NuevoAlbum");
		obG.agregarAlbum("Infantiles");
		
		ArchivoMultimedia Arc1= new Audio("RockNacional3958",35.6,fecha2,fecha3,32,"0", "0",0,1515,192);
		ArchivoMultimedia Arc2= new Imagen("FotoViaje2014-05",2.5,fecha,fecha1,15,"5","0", 1,5,320,110,5);
		ArchivoMultimedia Arc3= new Video("Noti20130910",153,fecha4,fecha5,5,"50", "10",2,480,720,30);
		
		LinkedList<ArchivoMultimedia> LArchivo=new LinkedList<ArchivoMultimedia>();
		LArchivo.add(Arc1);
		LArchivo.add(Arc2);
		LArchivo.add(Arc3);
		
		if(obG.getLAlbum().isEmpty()) System.out.println("Arbol está vacio") ;*/
		
		
			/* **** arma la estructura de arbol *** */
		
/*			Album nodoAux= new Album(); 
			Iterator <Album> itr= obG.getLAlbum().iterator();
			while(itr.hasNext()){
				nodoAux=itr.next();*/
				/* ** inserto dento del album raiz viajes**/ 
				/*if(nodoAux.equals(obG.getLAlbum().get(1))){ 
					
						System.out.println(nodoAux.getNombre()+" "+ obG.getLAlbum().get(1).getNombre());
						
						nodoAux.agregarAlbum("SubALbViajes",nodoAux);
						nodoAux.agregarArchivoAAlbum(obG.getLArchivoMultimedia().get(2), nodoAux);
						nodoAux.agregarArchivoAAlbum(obG.getLArchivoMultimedia().get(0), nodoAux);

				}*/
				
				/* ** inserto dento del album raiz musica**/
				/*if(nodoAux.equals(obG.getLAlbum().get(2))){ //System.out.println("Obj2" );
					System.out.println(nodoAux.getNombre()+" "+ obG.getLAlbum().get(2).getNombre());*/
					
					/*nodoAux.agregarArchivoAAlbum(obG.getLArchivoMultimedia().get(0), nodoAux);
					nodoAux.agregarArchivoAAlbum(obG.getLArchivoMultimedia().get(1), nodoAux);
					
				}
				*/
				/* ** inserto dento del album raiz Fotos2014**/
				/*if(nodoAux.equals(obG.getLAlbum().get(3))){ //System.out.println("Obj4" );
					System.out.println(nodoAux.getNombre()+" "+ obG.getLAlbum().get(4).getNombre());
					
					nodoAux.agregarAlbum("SubALbFotos1",nodoAux);
					nodoAux.agregarAlbum("SubALbFotos2",nodoAux);
					nodoAux.agregarAlbum("SubALbFotos3",nodoAux);

					Album nodoAux1= new Album(); 
					Iterator <Album> itr1= nodoAux.getLAlbum().iterator();
					while(itr1.hasNext()){
						nodoAux1=itr1.next();
						System.out.println("SubObjetos de: "+nodoAux1.getNombre());
						if(nodoAux1.getNombre() == "SubALbFotos2"){ 
							nodoAux1.agregarArchivoAAlbum(obG.getLArchivoMultimedia().get(0), nodoAux1);
							nodoAux1.agregarAlbum("SubSubAlbFotos2", nodoAux1);
							
						}	
						if(nodoAux1.getNombre() == "SubALbFotos1") {
								nodoAux1.agregarAlbum("SubSubALbFotos1", nodoAux1);
								nodoAux1.agregarArchivoAAlbum(obG.getLArchivoMultimedia().get(1), nodoAux1);
								nodoAux1.agregarArchivoAAlbum(obG.getLArchivoMultimedia().get(2), nodoAux1);
						}
					}
				}
			}*/
			
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
		System.out.printf("\n Tamaño: %f",nodoAux.getTamaño());
		// Primero muestra los archivos sueltos de este album
	}				
		 
}*/


/* ********************************************** */
//Reproduccion de archivos, mostrando duracion total y atributos
/*public void reproducir(LinkedList <ArchivoMultimedia> ListaReproduccion,LinkedList <ArchivoMultimedia> listaCompleta ){


	System.out.printf("\n NOMBRE \t     DURACIÓN  \t INICIO \t FIN  \t ANCHO \t ALTO \t RESOLUCION \t CANT. DE CUADROS");
	
	
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
	        int año = fechaHoy.get(Calendar.YEAR);
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
	        int año = fechaHoy.get(Calendar.YEAR);
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
		        int año = fechaHoy.get(Calendar.YEAR);
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
