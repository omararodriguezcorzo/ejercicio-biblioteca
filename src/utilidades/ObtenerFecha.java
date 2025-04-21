package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObtenerFecha {
    public static Date formatearFecha(String fechaEntrada){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try{
            return formato.parse(fechaEntrada);
        } catch (ParseException e) {
            System.out.println("Error. No está en el formato correcto dd/MM/yyyy");
            return null;
        }
    }
}
