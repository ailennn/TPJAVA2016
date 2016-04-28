package control;

/**
 * Clase que contiene las validaciones necesarias para todos los input.
 */

public class Validaciones {
	
	public static boolean formatoPatenteOk(String cadena){
		boolean formato = false; 
        int i = 0;
        if(cadena.length()==6){
        	if(Character.isLetter(cadena.charAt(0)))
        		if(Character.isLetter(cadena.charAt(1)))
        			if(Character.isLetter(cadena.charAt(2)))
        				if(Character.isDigit(cadena.charAt(3)))
        					if(Character.isDigit(cadena.charAt(4)))
        						if(Character.isDigit(cadena.charAt(5)))
        							formato=true;
        }
        return (formato);
	}

	public static boolean esNumeroMayorCero(String cadena) {
        cadena = cadena.trim();
        try {
            Integer.parseUnsignedInt(cadena);
	    return true;} 
        catch (NumberFormatException nfe) {
	            return false;
	        }
    }
	
	public static boolean esNumero(String cadena) {
        cadena = cadena.trim();
        try {
            Integer.parseInt(cadena);
	    return true;} 
        catch (NumberFormatException nfe) {
	            return false;
	        }
    }
    
    public static boolean sonLetras(String cadena){
        boolean algunDigito = false; 
        int i = 0;
        for (i = 0; i < cadena.length(); i++)
            if (Character.isDigit(cadena.charAt(i))){  
                algunDigito = true; 
            }
        return (!algunDigito && i>0);
    }

    
    public static boolean esReal(String cadena) {
        cadena = cadena.trim();
        try {
            Float.parseFloat(cadena);
	    return true;} 
        catch (NumberFormatException nfe) {
	            return false;
	        }
    }
}
