package Logica;

import java.util.ArrayList;

/**
 * Created by macaco on 08/07/2015.
 */

public class CalculoM {

    public CalculoM(){

    }

    public ArrayList<Float> calcularNotafalta(float n1,float n2,float n3){
        ArrayList<Float>arreglo1= new ArrayList<Float>();
        float notat1=n1*0.23f;
        float notat2=n2*0.23f;
        float notat3=n3*0.23f;

        float suma=notat1+notat2+notat3;


            arreglo1.add(suma);//primer posición lo que lleva y la segunda lo que necesita
            arreglo1.add(notaPasar(suma));


        return arreglo1;
    }

    public float notaPasar(float suma){

        for(float i=0.0f;i<5.0f;i=i+0.01f){
            float nota=(i*0.3f);
            float sumanota=0.f;
            sumanota=nota+suma;

            if(sumanota>=2.95f){
                return  hallarnumero(nota);
            }
        }

        return 0.0f;
    }

    public float hallarnumero(float n){

        for (float i=0.0f;i<5.0f;i=i+0.1f){
            float n2=i*3;
float n3=n2*0.3f;

            if(n3>=n){
                return n2;
            }
        }

        return 0.0f;
    }

    public float calcularnotafinal(float n1,float n2,float n3,float Nfinal){
        float nota1=n1*0.23f;
        float nota2=n2*0.23f;
        float nota3=n3*0.23f;
        float nfinal=Nfinal*0.30f;

        return nota1+nota2+nota3+nfinal;
    }
}
