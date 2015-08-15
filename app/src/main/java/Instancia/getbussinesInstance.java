package Instancia;

import Negocio.Negocio;

/**
 * Created by macaco on 08/07/2015.
 */

/* Patron singleton**/
public class getbussinesInstance {

    private static Negocio n;


    public static Negocio ObtenerNegocio(){
        if(n==null){
            n= new Negocio();
            return n;

        }else{
            return n;
        }
    }
}
