package Logica;

/**
 * Created by macaco on 08/07/2015.
 */
public class CalculoM {

    public CalculoM(){

    }



    public float calcularNotafalta(float n1,float n2,float n3){

        float notat1=n1*0.23f;
        float notat2=n2*0.23f;
        float notat3=n3*0.23f;

        float suma=notat1+notat2+notat3;


        if(suma<3.0f){
            return notaPasar(suma);

        }
        return 0.0f;
    }

    public float notaPasar(float suma){
        for(float i=0.0f;i<5.0f;i=i+0.1f){
            float nota=i*0.3f;
            float sumanota=0.f;
            sumanota=nota+suma;
            if(nota>=2.95f){
                return  nota;
            }


        }
        return 0.0f;
    }


}
