package reportes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.ListIterator;

import misc.Responsable;
import agencia.Agencia;
import transporte.Transporte;
import viaje.LargaDistancia;
import viaje.Viaje;

public class Ranking {
	
	public Ranking() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Ranking de responsables a bordo ordenado de mayor a menor por 
	 * cantidad de kilómetros recorridos en los viajes terminados.
	 * Genera archivo de texto
	 */
	
	public void ranking(Agencia agencia, LinkedList<Responsable>listaResponsable, LinkedList<Viaje>listaViajesTerminados) throws Exception{
		Viaje v=null;
		int suma=0;
		/**
		 * La lista auxiliar se usa para almacenar cada responsable(sin que esten repetidos)
		 * con la cantidad total de kms recorridos, que se suman en la variable suma
		 */
		LinkedList<Responsable> listaAux=null;
		LinkedList<Responsable>listaAux2=null;
		LinkedList<Viaje>listaTerminados=listaViajesTerminados;
		ListIterator<Viaje>iterador=listaTerminados.listIterator();
		while(iterador.hasNext()){
			v=iterador.next();
			if(v instanceof LargaDistancia){
				ListIterator<Responsable>itr=v.getListaResponsable().listIterator();
				Responsable r=null;
				while(itr.hasNext()){
					r=itr.next();
					if(listaAux==null)
						listaAux=new LinkedList<Responsable>();
					r.setSueldoFijo(v.getDestino().getKilometros());
					listaAux.add(r);
				}
			}	
		}
		agencia.OrdenarPorResponsables(listaAux);

		ListIterator<Responsable>itr2=listaAux.listIterator();
		Responsable re=null;
		if(itr2.hasNext()){
			re=itr2.next();
			long dni=re.getDni();
			while(itr2.hasNext()){
				if(re.getDni()==dni){
					suma+=re.getSueldoFijo();
					if(!itr2.hasNext() || itr2.next().getDni()!=dni){
						if(listaAux2==null)
							listaAux2=new LinkedList<Responsable>();
						/**
						 * En el atributo sueldoFijo de Responsable se almacena la cantidad
						 * total de kilometros recorridos por ese Responsable
						 */
						re.setSueldoFijo(suma);
						listaAux2.add(re);
					}
					re=itr2.next();
				}
				else{
					dni=re.getDni();
					suma=0;
				}
			}
			if(listaAux2==null)
				listaAux2=new LinkedList<Responsable>();
			re.setSueldoFijo(suma+re.getSueldoFijo());
			listaAux2.add(re);
			
			agencia.OrdenarPorKilometrosRecorridos(listaAux2);
			
			File arctxt=new File("src//archivos//Ranking.txt"); 
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
	
				escribir.write("DNI \t \t");
				escribir.write("Nombre \t \t");
				escribir.write("Kilometros recorridos\n");
				Responsable resp=null;
				ListIterator <Responsable> itera= listaAux2.listIterator();
				while(itera.hasNext()) {
					resp=itera.next();
					escribir.write(resp.getDni()+"\t \t");
					escribir.write(resp.getNombre()+"\t \t");
					escribir.write(resp.getSueldoFijo()+"\n");
				}
				escribir.close();
				} catch (Exception e) {throw new Exception("No se puede escribir el archivo");}
		}
	}
}