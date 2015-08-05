package utylity;

import java.util.ArrayList;

/**
 * Created by macaco on 08/07/2015.
 */
public class utyliti {

    public static  ArrayList<String> converTonfalta(ArrayList<Float> n){
        ArrayList<String >arreglo=new ArrayList<>();

        for(int i=0;i<n.size();i++){
            String nfinal=converToString(n.get(i));
            arreglo.add(nfinal);
        }

        return arreglo;
    }

    protected static  String converToString(float n){
      return String.valueOf(n);
    }

    public static String convertostringnotafinal(float n){
        return String.valueOf(n);
    }

}
