package GUI;

/**
 * Clase que contiene las validaciones necesarias para todos los input 
 */

public class Validaciones {

	public static boolean sonNumeros(String cadena) {
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

    
    public static boolean sonReales(String cadena) {
        cadena = cadena.trim();
        try {
            Float.parseFloat(cadena);
	    return true;} 
        catch (NumberFormatException nfe) {
	            return false;
	        }
    }
}