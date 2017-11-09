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
        mapa.put("Random", R.drawable.stock_90_omakase_01);
        mapa.put("Mario", R.drawable.stock_90_mario_01);
        mapa.put("Luigi", R.drawable.stock_90_luigi_01);
        mapa.put("Peach", R.drawable.stock_90_peach_01);
        mapa.put("Bowser", R.drawable.stock_90_koopa_01);
        mapa.put("Yoshi", R.drawable.stock_90_yoshi_01);
        mapa.put("Rosalina&Luma", R.drawable.stock_90_rosetta_01);
        mapa.put("Fox", R.drawable.stock_90_fox_01);
        return mapa;
    }

    public static int GetFromNombre(String nombre){
        if(db.containsKey(nombre)){
            return db.get(nombre);
        }else return db.get("Random");

    }
}
