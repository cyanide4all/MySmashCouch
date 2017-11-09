package sooftrema.mysmashcouch;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import sooftrema.mysmashcouch.core.Jugador;
import sooftrema.mysmashcouch.core.Personaje;
import sooftrema.mysmashcouch.util.JugadoresAdapter;
import sooftrema.mysmashcouch.util.PersonajesAdapter;
import sooftrema.mysmashcouch.util.SharedData;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link Sofa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sofa extends Fragment {

    private ListView listaJugadores;

    public Sofa() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Sofa.
     */
    // TODO: Rename and change types and number of parameters
    public static Sofa newInstance() {
        Sofa fragment = new Sofa();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Cosas importantes que se necesiten para prox ejecucion
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sofa, container, false);

        //Le colocamos el adapter a la lista
        listaJugadores = (ListView) view.findViewById(R.id.JugadoresList);
        listaJugadores.setAdapter(new JugadoresAdapter(this.getContext()));
        FloatingActionButton masUnoBtn = (FloatingActionButton) view.findViewById(R.id.MasUnJugadorBtn);

        //Le ponemos funcion al boton de +1
        masUnoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Instantiate an AlertDialog.Builder with its constructor
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final View dialogView = inflater.inflate(R.layout.crear_jugador, null);
                final GridView gridPersonajes = (GridView)dialogView.findViewById(R.id.CJGrid);
                gridPersonajes.setAdapter(new PersonajesAdapter(gridPersonajes.getContext()));
                gridPersonajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ((PersonajesAdapter)gridPersonajes.getAdapter()).setSelectedPosition(position);
                    }
                });
                builder
                        .setTitle("Nuevo Jugador")
                        .setView(dialogView)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String inputText = ((EditText)dialogView.findViewById(R.id.CJNombreJugadorInput)).getText().toString();
                                if(!inputText.equals("")){
                                    ((JugadoresAdapter)listaJugadores.getAdapter())
                                            .addJugador(new Jugador(inputText,
                                                    ((PersonajesAdapter)gridPersonajes.getAdapter())
                                                            .getSelectedPersonaje()));
                                }else {
                                    Toast.makeText(getActivity(), "No puede haber jugadores sin nombre", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("Cancelar",null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        //Ponemos la funcion de delete
        listaJugadores.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder
                        .setTitle("Eliminar Jugador")
                        .setMessage("Seguro? Esto es irreversible")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                JugadoresAdapter adapter = (JugadoresAdapter)listaJugadores.getAdapter();
                                Toast.makeText(getActivity(), "A la puta cocina a por birra, " + adapter.getJugadores()
                                        .get(position).getNombre(), Toast.LENGTH_SHORT).show();
                                adapter.removeJugadorAt(position);
                            }
                        })
                        .setNegativeButton("Cancelar",null);
                AlertDialog dialog = builder.create();
                dialog.show();
                return false;
            }
        });

        //Y la funcion de modificado
        listaJugadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final View dialogView = inflater.inflate(R.layout.crear_jugador, null);
                final GridView gridPersonajes = (GridView)dialogView.findViewById(R.id.CJGrid);
                ((EditText)dialogView.findViewById(R.id.CJNombreJugadorInput))
                        .setText(
                                ((JugadoresAdapter)listaJugadores.getAdapter())
                                        .getJugadores().get(position).getNombre()
                                , TextView.BufferType.EDITABLE
                        );
                gridPersonajes.setAdapter(new PersonajesAdapter(gridPersonajes.getContext()));
                gridPersonajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ((PersonajesAdapter)gridPersonajes.getAdapter()).setSelectedPosition(position);
                    }
                });
                builder
                        .setTitle("Modificar Jugador")
                        .setView(dialogView)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                PersonajesAdapter adapterPersonajes = ((PersonajesAdapter)gridPersonajes.getAdapter());
                                JugadoresAdapter adapterJugadores = (JugadoresAdapter)listaJugadores.getAdapter();
                                EditText input = (EditText)dialogView.findViewById(R.id.CJNombreJugadorInput);
                                Jugador jugadorModificable = ((JugadoresAdapter)listaJugadores
                                        .getAdapter()).getJugadores().get(position);
                                String inputText = input.getText().toString();
                                if(!inputText.equals("")){
                                    jugadorModificable.setNombre(inputText);
                                    jugadorModificable.setMain(adapterPersonajes.getSelectedPersonaje());
                                    adapterJugadores.notifyDataSetChanged();
                                }else {
                                    Toast.makeText(getActivity(), "No puede haber jugadores sin nombre", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("Cancelar",null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        return view;
    }

    /**
     * Metemos datos en memoria antes de salir
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        SharedData.getInstance().jugadores = ((JugadoresAdapter)listaJugadores.getAdapter()).getJugadores();
    }
}
