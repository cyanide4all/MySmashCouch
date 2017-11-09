package sooftrema.mysmashcouch.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import sooftrema.mysmashcouch.R;
import sooftrema.mysmashcouch.core.Personaje;

/**
 * Created by cya on 11/7/17.
 */

public class PersonajesAdapter extends BaseAdapter {

    private int selectedPosition;
    private ArrayList<Personaje> personajes;
    private Context context;

    public PersonajesAdapter(Context context){
        this.context = context;
        personajes = SharedData.getInstance().personajes;
        selectedPosition = -1;
    }

    public void setSelectedPosition(int position){
        this.selectedPosition = position;
        this.notifyDataSetChanged();
    }

    public Personaje getSelectedPersonaje(){
        if(selectedPosition > -1){
            return personajes.get(selectedPosition);
        }
        else return null;
    }

    @Override
    public int getCount() {
        return personajes.size();
    }

    @Override
    public Object getItem(int position) {
        return personajes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return personajes.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(this.context);
            //imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(ImageGetter.GetFromNombre(personajes.get(position).getNombre()));
        if(position == selectedPosition){
            imageView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
        }else{
            imageView.setBackgroundColor(Color.TRANSPARENT);
        }
        return imageView;
    }
}
