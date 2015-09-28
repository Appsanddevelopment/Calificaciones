package Controlador;

import java.util.ArrayList;
import Instancia.getbussinesInstance;
import Negocio.Negocio;
import utylity.utyliti;

/**
 * Esta clase sirve de conector entre la lógica de la aplicación y las clases encargadas del diseño
 * de la aplicación y que se conectan con los 'layouts' de la misma.
 *
 * @author Jairo Castañeda
 * @author Emanuel Martínez Pinzón
 * @version 1.0
 */
public class Controlador {

    /**
     * Constructor de la clase
     */
    public Controlador(){}

    /**
     * Calcula la nota que lleva en la materia y la calificación que necesita para aprobar.
     * @param n1 La nota correspondiente al corte 1
     * @param n2 La nota correspondiente al corte 2
     * @param n3 La nota correspondiente al corte 3
     * @return Retorna un ArrayList con dos cadenas de texto,
     * en la posición 1 se guarda la nota que lleva y en la posición 2 la nota que necesita.
     */
    public ArrayList<String> calcularNotaFalta(float n1,float n2,float n3){
        Negocio n = getbussinesInstance.ObtenerNegocio();

        ArrayList<Float> nfalta = n.CalcularNotaFalta(n1,n2,n3);
        ArrayList<String> nfinal = utyliti.converTonfalta(nfalta);

        return nfinal;
    }

    /**
     * Calcula la nota final de la materia tomando todas las notas de los cortes y el examen final.
     * @param n1 La nota correspondiente al corte 1
     * @param n2 La nota correspondiente al corte 2
     * @param n3 La nota correspondiente al corte 3
     * @param Nfinal La nota correspondiente al examen final.
     * @return Retorna una cadena con la nota final de la materia.
     */
    public String calcularNotafinal(float n1, float n2, float n3, float Nfinal){
        Negocio n = getbussinesInstance.ObtenerNegocio();

        float total = n.calcularNotaf(n1,n2,n3,Nfinal);
        String notaFinal = utyliti.convertostringnotafinal(total);

        return notaFinal;
    }
}
