package Controlador;

import Negocio.Negocio;
import Instancia.getbussinesInstance;
import utylity.utyliti;

/**
 * Created by macaco on 08/07/2015.
 */
public class Controlador {


    public Controlador(){

    }

    public String calcularNotaFalta(){
        Negocio n=getbussinesInstance.ObtenerNegocio();

        float nfalta=n.calcularNotaf();
String nfinal=utyliti.converTonfalta(nfalta);

        return nfinal;

    }

}
