package archivos;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import agencia.Agencia;;

/**
 *  Clase que implementa la serializacion (XML)
**/
public class Xml {
	public static void almacenar(String path, Agencia agen )/* throws FileNotFoundException*/ {
		
        XStream xs = new XStream();
        FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(path);
			xs.toXML(agen, fileWriter);
		} catch (IOException e) {
			e.printStackTrace();
		} 

}

public static Agencia cargar(String path) throws FileNotFoundException {
            XStream xs = new XStream(new DomDriver());

FileReader fileReader = new FileReader(path);
Agencia agen = (Agencia) xs.fromXML(fileReader);
return agen;


}

}