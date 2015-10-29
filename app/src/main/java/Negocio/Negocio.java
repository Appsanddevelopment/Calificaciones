package Negocio;

import java.util.ArrayList;
import Logica.CalculoM;

/**
 * Clase negocio del proyecto
 *
 * @author Jairo Castañeda
 * @author Emanuel Martínez Pinzón
 * @version 1.0
 */


public class Negocio {

    private CalculoM c;

    public Negocio(){
        c= new CalculoM();
    }

    /**
     * Calcula la nota que lleva en la materia y la calificación que necesita para aprobar.
     * @param n1 La nota correspondiente al corte 1
     * @param n2 La nota correspondiente al corte 2
     * @param n3 La nota correspondiente al corte 3
     * @return Retorna un ArrayList con dos cadenas de texto,
     * en la posición 1 se guarda la nota que lleva y en la posición 2 la nota que necesita.
     */
    public ArrayList<Float> CalcularNotaFalta(float n1,float n2,float n3){
        return c.calcularNotafalta(n1,n2,n3);
    }

    /**
     * Calcula la nota final de la materia tomando todas las notas de los cortes y el examen final.
     * @param n1 La nota correspondiente al corte 1
     * @param n2 La nota correspondiente al corte 2
     * @param n3 La nota correspondiente al corte 3
     * @param nfinal La nota correspondiente al examen final.
     * @return Retorna una cadena con la nota final de la materia.
     */
    public float calcularNotaf(float n1,float n2,float n3,float nfinal){
        return c.calcularnotafinal(n1, n2, n3, nfinal);
    }
}
