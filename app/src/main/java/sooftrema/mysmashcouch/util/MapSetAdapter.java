package sooftrema.mysmashcouch.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sooftrema.mysmashcouch.R;
import sooftrema.mysmashcouch.core.Jugador;
import sooftrema.mysmashcouch.core.MapSet;
import sooftrema.mysmashcouch.core.Mapa;

/**
 * Created by cya on 11/9/17.
 */

public class MapSetAdapter extends BaseAdapter {

    private Context context;
    private List<MapSet> listaMapSets;

    public MapSetAdapter(Context context){
        this.context = context;
        this.listaMapSets = SharedData.getInstance().mapSets;
    }

    @Override
    public int getCount() {
        return listaMapSets.size();
    }

    @Override
    public Object getItem(int position) {
        return listaMapSets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaMapSets.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            v = LayoutInflater.from(this.context).inflate(R.layout.mapset_cell, null);
        }
        ((TextView)v.findViewById(R.id.MapSetName)).setText(listaMapSets.get(position).getNombre());
        return v;
    }

}
