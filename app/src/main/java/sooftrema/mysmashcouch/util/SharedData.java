package sooftrema.mysmashcouch.util;

import java.util.ArrayList;

import sooftrema.mysmashcouch.core.Jugador;

/**
 * Created by cya on 11/7/17.
 */

public class SharedData {
    public ArrayList<Jugador> jugadores;
    private static SharedData instance = null;
    protected SharedData() {
        // Exists only to defeat instantiation.
    }
    public static SharedData getInstance() {
        if(instance == null) {
            instance = new SharedData();
            instance.jugadores = new ArrayList<>();
        }
        return instance;
    }
}
