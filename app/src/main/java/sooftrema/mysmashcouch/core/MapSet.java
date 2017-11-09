package sooftrema.mysmashcouch.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cya on 11/9/17.
 */

public class MapSet {

    private ArrayList<Mapa> listaMapas;
    private String nombre;
    public MapSet(String nombre, ArrayList<Mapa> listaMapas){
        this.listaMapas = listaMapas;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Mapa> getListaMapas() {
        return listaMapas;
    }
}
