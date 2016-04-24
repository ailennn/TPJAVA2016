package misc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class  Excepciones{
	private File f;
	public void creaArchivo()
	{
		try{
			f=new File("Exceps//Excepciones.txt");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void escribirArchivo(String exception)
	{
		try{
			BufferedWriter bw=new BufferedWriter(new FileWriter(f,true));
			bw.write(exception);
			bw.newLine();
			bw.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
