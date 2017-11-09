package sooftrema.mysmashcouch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import sooftrema.mysmashcouch.core.Mapa;
import sooftrema.mysmashcouch.util.MapSetAdapter;
import sooftrema.mysmashcouch.util.SharedData;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link Mapas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Mapas extends Fragment {

    public Mapas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment Mapas.
     */
    // TODO: Rename and change types and number of parameters
    public static Mapas newInstance() {
        Mapas fragment = new Mapas();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mapas, container, false);
        GridView mapsetGridView = (GridView)view.findViewById(R.id.MapSetGridView);
        MapSetAdapter msAdapter = new MapSetAdapter(mapsetGridView.getContext());
        mapsetGridView.setAdapter(msAdapter);
        mapsetGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intento = new Intent(getActivity(), RandomMapSelector.class);
                ArrayList<Mapa> mapasForRandom = SharedData.getInstance().mapSets.get(position).getListaMapas();
                int randomNum = ThreadLocalRandom.current().nextInt(0, mapasForRandom.size());
                intento.putExtra("mapName", mapasForRandom.get(randomNum).getNombre());
                startActivity(intento);
            }
        });
        return view;
    }
}
