package Negocio;


import java.util.ArrayList;

import Logica.CalculoM;

/**
 * Created by macaco on 08/07/2015.
 */
public class Negocio {

    private CalculoM c;

    public Negocio(){
        c= new CalculoM();
    }


    public ArrayList<Float> CalcularNotaFalta(float n1,float n2,float n3){
        return c.calcularNotafalta(n1,n2,n3);
    }


    public float calcularNotaf(float n1,float n2,float n3,float nfinal){
        return c.calcularnotafinal(n1, n2, n3, nfinal);
    }


}
