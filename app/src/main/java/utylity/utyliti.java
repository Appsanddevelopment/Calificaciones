package utylity;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Clase utilizada para pasar todas las notas de float a String
 *
 * @author Jairo Castañeda
 * @author Emanuel Martínez Pinzón
 * @version 1.0
 */

public class utyliti {

    /**
     * Convierte la nota que lleva y la nota que necesita guardados en un ArrayList como float's en String
     * y los guarda en otro ArrayList de tipo String
     * @param n ArrayList de tipo float con las notas
     * @return Retorna un ArrayList de tipo String con las notas
     */
    public static  ArrayList<String> converTonfalta(ArrayList<Float> n){
        ArrayList<String >arreglo = new ArrayList<>();

        for(int i=0;i<n.size();i++){
            String nfinal = converToString(n.get(i));
            arreglo.add(nfinal);
        }

        return arreglo;
    }

    /**
     * Convierte a String un float
     * @param n Valor en float a convertir
     * @return Retorna un String con el valor convertido
     */
    public static String converToString(float n){
      return String.valueOf(n);
    }
}
