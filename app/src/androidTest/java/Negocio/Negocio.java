package Negocio;


import Logica.CalculoM;

/**
 * Created by macaco on 08/07/2015.
 */
public class Negocio {

    private CalculoM c;

    public Negocio(){
        c= new CalculoM();
    }


    public float CalcularNotaFalta(float n1,float n2,float n3){
        return c.calcularNotafalta(n1,n2,3);
    }


    public float calcularNotaf(){
        return 0.0f;
    }
}
