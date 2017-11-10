package sooftrema.mysmashcouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import sooftrema.mysmashcouch.util.ImageGetter;

public class RandomMapSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Prepara la vista y establece la accion del boton
        setContentView(R.layout.activity_random_map_selector);
        String nombreMapa = getIntent().getStringExtra("mapName");
        ((ImageView)findViewById(R.id.MapSelectorMapImage))
                .setImageResource(ImageGetter.GetFromNombre(nombreMapa));
        ((TextView)findViewById(R.id.MapSelectorMapName)).setText(nombreMapa);
        ((Button)findViewById(R.id.MapSelectorVolverBtn))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });
    }
}
