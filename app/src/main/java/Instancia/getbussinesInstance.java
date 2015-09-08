package Instancia;

import Negocio.Negocio;

/**
 * @author Jairo Castañeda
 * @author Emanuel Martínez
 * @version 1.0
 */

//Patron singleton
public class getbussinesInstance {

    private static Negocio n;

    public static Negocio ObtenerNegocio(){
        if(n==null){
            n= new Negocio();
            return n;
        }else
            return n;
    }
}
