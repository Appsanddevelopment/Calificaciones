package Logica;

import java.util.ArrayList;

/**
 * Esta clase realiza los calculos de la aplicación.
 *
 * @author Jairo Castañeda
 * @author Emanuel Martínez Pinzón
 * @version 1.0
 */

public class CalculoM {

    public CalculoM(){}

    /**
     * Calcula lo que falta para pasar, el método permite obtener en un arreglo de dos posiciones la
     * nota que lleva y la nota que le falta para pasar.
     *
     * En la posición 0 se espera la nota que lleva en la materia.
     * En la posición 1 se espera la nota que falta para pasar la materia.
     * Si la nota que lleva es mayor a 3.0 o no alcanza a pasar sacando 5.0 en el examen final el
     * resultado será 0.0 para la posición 1.
     * @param n1 La nota correspondiente al corte 1.
     * @param n2 La nota correspondiente al corte 2.
     * @param n3 La nota correspondiente al corte 3.
     * @return Retorna un ArrayList con la nota que lleva [0] y la nota que falta [1].
     */
    public ArrayList<Float> calcularNotafalta(float n1,float n2,float n3){
        ArrayList<Float> arreglo1= new ArrayList<>();

        float suma=(n1*0.23333333333f)+(n2*0.23333333333f)+(n3*0.23333333333f);

        arreglo1.add(suma);
        arreglo1.add(notaPasar(suma));

        return arreglo1;
    }

    /**
     * Me dice la nota que necesito para pasar en terminos generales.
     *
     * Ejemplo: 0.2, 0.3, 1.5, 4.9, 5.0.
     * @param suma El parametro a sumar
     * @return Retorna un float con la nota que necesita para pasar.
     */
    public float notaPasar(float suma){
        for(float i = 0.0f; i <= 5.0f; i = i+0.001f){
            float nota = (i*0.3f);
            float sumanota;
            sumanota = nota + suma;

            if(sumanota >= 3f)
                return  hallarnumero(nota);
        }

        return 0.0f;
    }

    /**
     * le envio lo que necesito para pasar en terminos generales y hallo la nota que multiplicada por 0.3 se acerca mas a ese resultado
     * @param n Valor con la nota para pasar.
     * @return Retorna un float
     */
    public float hallarnumero(float n){
        float n2;
        for (float i = 0.0f; i <= 5.0f; i = i+0.001f){
            n2 = i*3;
            float n3 = n2*0.3f;

            if(n3 >= n)
                return n2;
        }

        return 0.0f;
    }

    /**
     * Calcula la nota final de la materia usando todas las notas de los cortes y el examen final.
     * @param n1 La nota correspondiente al corte 1.
     * @param n2 La nota correspondiente al corte 2.
     * @param n3 La nota correspondiente al corte 3.
     * @param Nfinal La nota correspondiente al examen final.
     * @return Retorna la nota definitiva de la materia.
     */
    public float calcularnotafinal(float n1,float n2,float n3,float Nfinal){
        float nota1 = n1*0.23333333333f;
        float nota2 = n2*0.23333333333f;
        float nota3 = n3*0.23333333333f;
        float nfinal = Nfinal*0.30f;

        return nota1 + nota2 + nota3 + nfinal;
    }
}