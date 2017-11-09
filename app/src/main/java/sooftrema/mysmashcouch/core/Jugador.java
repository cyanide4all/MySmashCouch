package sooftrema.mysmashcouch.core;

/**
 * Created by cya on 11/7/17.
 */

public class Jugador {
    private String nombre;
    private Personaje main;

    public Jugador(String nombre, Personaje personaje){
        this.nombre = nombre;
        this.main = personaje;
    }

    public void setPersonaje(Personaje personaje){
        this.main = personaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Personaje getMain() {
        return main;
    }

    public void setMain(Personaje main) {
        this.main = main;
    }
}
