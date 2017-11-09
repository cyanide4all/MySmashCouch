package sooftrema.mysmashcouch.util;

import java.lang.reflect.Array;
import java.util.ArrayList;

import sooftrema.mysmashcouch.core.Jugador;
import sooftrema.mysmashcouch.core.Personaje;

/**
 * Created by cya on 11/7/17.
 */

public class SharedData {

    public static String[] nombresPersonajes = { "Random", "Mario", "Luigi", "Peach", "Bowser", "Yoshi",
            "Rosalina&Luma", "Bowser Jr.", "Wario", "Donkey Kong", "Diddy Kong", "Mr. Game&Watch",
            "Little Mac", "Link", "Zelda", "Sheik", "Ganondorf", "Toon Link", "Samus",
            "Zero Suit Samus", "Pit", "Palutena", "Marth", "Ike", "Robin", "Duck Hunt Duo", "Kirby",
            "King Dedede", "Meta Knight", "Fox", "Falco", "Pikachu", "Charizard", "Lucario",
            "Jigglypuff", "Greninja", "R.O.B", "Ness", "Captain Falcon", "Villager", "Olimar",
            "Wii Fit Trainer", "Shulk", "Dr. Mario", "Dark Pit", "Lucina", "Pac-Man", "Mega Man",
            "Sonic", "Mewtwo", "Lucas", "Roy", "Ryu", "Cloud", "Corrin", "Bayonetta",
            "Mii", "Mii Fighter", "Mii Swordsman", "Mii Gunner"
    };
    private static SharedData instance = null;

    public ArrayList<Jugador> jugadores;
    public ArrayList<Personaje> personajes;


    protected SharedData() {
        // Exists only to defeat instantiation.
    }
    public static SharedData getInstance() {
        if(instance == null) {
            instance = new SharedData();
            instance.jugadores = new ArrayList<>();
            instance.personajes = new ArrayList<>();
            instance.initializePersonajesArray();
        }
        return instance;
    }

    private void initializePersonajesArray() {
        for (String s : SharedData.nombresPersonajes) {
            this.personajes.add(new Personaje(s));
        }
    }


}
