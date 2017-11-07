package sooftrema.mysmashcouch.util;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import sooftrema.mysmashcouch.MainActivity;
import sooftrema.mysmashcouch.Mapas;
import sooftrema.mysmashcouch.R;
import sooftrema.mysmashcouch.Sofa;
import sooftrema.mysmashcouch.Torneo;

/**
 * Created by cya on 11/7/17.
 */
public class CustomNavigationListener implements BottomNavigationView.OnNavigationItemSelectedListener {

    private MainActivity context;
    private CharSequence tabActualTitle;

    public CustomNavigationListener(MainActivity context) {
        this.context = context;
        tabActualTitle = "";
    }

    /**
     * Metodo encargado de la navegacion. Usa item.getTitle para manejar el caso de intentar
     * navegar hacia la tab en la que ya estamos
     * @param item
     * @return true si se marca la tab, false si no
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment newFragment = null;
        if(!(tabActualTitle == item.getTitle())){
            tabActualTitle = item.getTitle();
            switch (item.getItemId()) {
                case R.id.action_sofa:
                    newFragment = Sofa.newInstance();
                    break;
                case R.id.action_torneo:
                    newFragment = Torneo.newInstance();
                    break;
                case R.id.action_mapas:
                    newFragment = Mapas.newInstance();
                    break;
            }
            FragmentTransaction transaction = context.getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
            return true;
        }else{
            return false;
        }
    }
}
