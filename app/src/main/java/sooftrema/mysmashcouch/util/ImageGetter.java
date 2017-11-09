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
        mapa.put("Bowser Jr.", R.drawable.stock_90_koopajr_01);
        mapa.put("Wario", R.drawable.stock_90_wario_01);
        mapa.put("Donkey Kong", R.drawable.stock_90_donkey_01);
        mapa.put("Diddy Kong", R.drawable.stock_90_diddy_01);
        mapa.put("Mr. Game&Watch", R.drawable.stock_90_gamewatch_01);
        mapa.put("Little Mac", R.drawable.stock_90_littlemac_01);
        mapa.put("Link", R.drawable.stock_90_link_01);
        mapa.put("Zelda", R.drawable.stock_90_zelda_01);
        mapa.put("Sheik", R.drawable.stock_90_sheik_01);
        mapa.put("Ganondorf", R.drawable.stock_90_ganon_01);
        mapa.put("Toon Link", R.drawable.stock_90_toonlink_01);
        mapa.put("Samus", R.drawable.stock_90_samus_01);
        mapa.put("Zero Suit Samus", R.drawable.stock_90_szerosuit_01);
        mapa.put("Pit", R.drawable.stock_90_pit_01);
        mapa.put("Palutena", R.drawable.stock_90_palutena_01);
        mapa.put("Marth", R.drawable.stock_90_marth_01);
        mapa.put("Ike", R.drawable.stock_90_ike_01);
        mapa.put("Robin", R.drawable.stock_90_reflet_01);
        mapa.put("Duck Hunt Duo", R.drawable.stock_90_duckhunt_01);
        mapa.put("Kirby", R.drawable.stock_90_kirby_01);
        mapa.put("King Dedede", R.drawable.stock_90_dedede_01);
        mapa.put("Meta Knight", R.drawable.stock_90_metaknight_01);
        mapa.put("Fox", R.drawable.stock_90_fox_01);
        mapa.put("Falco", R.drawable.stock_90_falco_01);
        mapa.put("Pikachu", R.drawable.stock_90_pikachu_01);
        mapa.put("Charizard", R.drawable.stock_90_lizardon_01);
        mapa.put("Lucario", R.drawable.stock_90_lucario_01);
        mapa.put("Jigglypuff", R.drawable.stock_90_purin_01);
        mapa.put("Greninja", R.drawable.stock_90_gekkouga_01);
        mapa.put("R.O.B", R.drawable.stock_90_robot_01);
        mapa.put("Ness", R.drawable.stock_90_ness_01);
        mapa.put("Captain Falcon", R.drawable.stock_90_captain_01);
        mapa.put("Villager", R.drawable.stock_90_murabito_01);
        mapa.put("Olimar", R.drawable.stock_90_pikmin_01);
        mapa.put("Wii Fit Trainer", R.drawable.stock_90_wiifit_01);
        mapa.put("Shulk", R.drawable.stock_90_shulk_01);
        mapa.put("Dr. Mario", R.drawable.stock_90_drmario_01);
        mapa.put("Dark Pit", R.drawable.stock_90_pitb_01);
        mapa.put("Lucina", R.drawable.stock_90_lucina_01);
        mapa.put("Pac-Man", R.drawable.stock_90_pacman_01);
        mapa.put("Mega Man", R.drawable.stock_90_rockman_01);
        mapa.put("Sonic", R.drawable.stock_90_sonic_01);
        mapa.put("Mewtwo", R.drawable.stock_90_mewtwo_01);
        mapa.put("Lucas", R.drawable.stock_90_lucas_01);
        mapa.put("Roy", R.drawable.stock_90_roy_01);
        mapa.put("Ryu", R.drawable.stock_90_ryu_01);
        mapa.put("Cloud", R.drawable.stock_90_cloud_01);
        mapa.put("Corrin", R.drawable.stock_90_kamui_01);
        mapa.put("Bayonetta", R.drawable.stock_90_bayonetta_01);
        mapa.put("Mii", R.drawable.stock_90_miiall_01);
        mapa.put("Mii Fighter", R.drawable.stock_90_miifighter_01);
        mapa.put("Mii Swordsman", R.drawable.stock_90_miiswordsman_01);
        mapa.put("Mii Gunner", R.drawable.stock_90_miigunner_01);
        return mapa;
    }

    public static int GetFromNombre(String nombre){
        if(db.containsKey(nombre)){
            return db.get(nombre);
        }else return db.get("Random");

    }
}
