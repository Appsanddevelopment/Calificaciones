package Controlador;

import Negocio.Negocio;
import Instancia.getbussinesInstance;
import utylity.utyliti;
import java.util.ArrayList;

/**
 * Created by macaco on 08/07/2015.
 */
public class Controlador {


    public Controlador(){

    }

    //YA DEBERIA FUNCIONAR AL LLAMAR LOS METODOS.
    /*
    ARREGLO
        1)Posición lo que lleva
        2)Posición lo que necesita
    */
    public ArrayList<String> calcularNotaFalta(float n1,float n2,float n3){
        Negocio n=getbussinesInstance.ObtenerNegocio();

        ArrayList<Float> nfalta=n.CalcularNotaFalta(n1,n2,n3);
        ArrayList<String> nfinal=utyliti.converTonfalta(nfalta);

        return nfinal;
    }

    public String calcularNotafinal(float n1,float n2,float n3,float Nfinal){
        Negocio n=getbussinesInstance.ObtenerNegocio();
        float total= n.calcularNotaf(n1,n2,n3,Nfinal);
        String nofinal=utyliti.convertostringnotafinal(total);

        return nofinal;
    }
}
