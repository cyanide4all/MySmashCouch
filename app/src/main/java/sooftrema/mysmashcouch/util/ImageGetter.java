package sooftrema.mysmashcouch.util;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import sooftrema.mysmashcouch.R;

/**
 * Created by cya on 11/7/17.
 */

public class ImageGetter {

    private static final Map<String, Integer> db = createMap();
    private static Map<String, Integer> createMap()
    {
        Map<String,Integer> mapa = new HashMap<String,Integer>();
        mapa.put("Random", R.drawable.random);
        mapa.put("Fox", R.drawable.fox);
        return mapa;
    }

    public static int GetFromNombre(String nombre){
        if(db.containsKey(nombre)){
            return db.get(nombre);
        }else return db.get("Random");

    }
}
