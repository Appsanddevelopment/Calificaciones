package Logica;

import java.util.ArrayList;

/**
 * Created by macaco on 08/07/2015.
 */

public class CalculoM {

    public CalculoM(){

    }
/*Calcular lo que falta para pasar:
metodo que me va a permitir obtener en un arreglo de dos posciones la nota que lleva y la nota que le falta
[0]ira la nota que lleva
[1]ira la nota falta (osea lo que debe sacar en el final si ya paso o si no alcanza a pasar sacando  5.0 , el resultado sera 0.0 ya que la validacion se hace
hasta 5)
*
* **/
    public ArrayList<Float> calcularNotafalta(float n1,float n2,float n3){
        ArrayList<Float>arreglo1= new ArrayList<Float>();
        float notat1=n1*0.23f;
        float notat2=n2*0.23f;
        float notat3=n3*0.23f;

        float suma=(n1*0.23f)+(n2*0.23f)+(n3*0.23f);


            arreglo1.add(suma);//primer posición lo que lleva y la segunda lo que necesita
            arreglo1.add(notaPasar(suma));


        return arreglo1;
    }

    /*
    *me dice la nota que necesito para pasar en terminos  generales ejemplo
    * (0.2 , 0.3 , 0.9 , 1.5)
    * **/

    public float notaPasar(float suma){

        for(float i=0.0f;i<5.0f;i=i+0.01f){
            float nota=(i*0.3f);
            float sumanota=0.0f;
            sumanota=nota+suma;

            if(sumanota>=2.95f){
                return  hallarnumero(nota);
            }

        }

        return 0.0f;
    }
/*hallar numero
 le envio lo que necesito para pasar en terminos generales ejemplo(0. 2, 1, 0.9) y hallo la nota que multiplicada por 0.3 me da ese resultaodo se acerca mas a ese
 resultado
*
* **/
    public float hallarnumero(float n){
        float n2=0.0f;
        for (float i=0.0f;i<=5.0f;i=i+0.1f){
             n2=i*3;
float n3=n2*0.3f;

            if(n3>=n){
                return n2;
            }
        }

        return 0.0f;
    }
/*
* me calcula la nota final poniendo todas las notas que ha sacado , incluyendo la del final (obligatoria)
* **/
    public float calcularnotafinal(float n1,float n2,float n3,float Nfinal){
        float nota1=n1*0.23f;
        float nota2=n2*0.23f;
        float nota3=n3*0.23f;
        float nfinal=Nfinal*0.30f;

        return nota1+nota2+nota3+nfinal;
    }
}
