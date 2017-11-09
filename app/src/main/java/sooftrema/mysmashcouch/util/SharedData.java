package sooftrema.mysmashcouch.util;

import java.lang.reflect.Array;
import java.util.ArrayList;

import sooftrema.mysmashcouch.core.Jugador;
import sooftrema.mysmashcouch.core.Personaje;

/**
 * Created by cya on 11/7/17.
 */

public class SharedData {

    public static String[] nombresPersonajes = { "Mario", "Luigi", "Peach", "Bowser", "Yoshi" };
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
