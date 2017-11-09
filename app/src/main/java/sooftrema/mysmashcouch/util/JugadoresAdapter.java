package sooftrema.mysmashcouch.util;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sooftrema.mysmashcouch.R;
import sooftrema.mysmashcouch.core.Jugador;

/**
 * Created by cya on 11/7/17.
 */

public class JugadoresAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Jugador> jugadores;

    public JugadoresAdapter(Context context){
        this.context = context;
        this.jugadores = SharedData.getInstance().jugadores;
    }

    public JugadoresAdapter(Context context, ArrayList<Jugador> jugadores){
        this.context = context;
        this.jugadores = jugadores;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void addJugador(Jugador nuevo){
        this.jugadores.add(nuevo);
        this.notifyDataSetChanged();
    }

    public void removeJugadorAt(int position){
        this.jugadores.remove(position);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return jugadores.size();
    }

    @Override
    public Object getItem(int position) {
        return jugadores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            v = LayoutInflater.from(this.context).inflate(R.layout.jugador_cell,null);
        }
        Jugador jugadorActual = jugadores.get(position);
        ((TextView)v.findViewById(R.id.JCnombreJugador)).setText(jugadorActual.getNombre());
        if(jugadorActual.getMain() != null){
            ((ImageView)v.findViewById(R.id.JCmainImage)).setImageResource(
                    ImageGetter.GetFromNombre(jugadorActual.getMain().getNombre()));
        }
        return v;
    }

    @Override
    public boolean isEmpty() {
        return jugadores.isEmpty();
    }
}
