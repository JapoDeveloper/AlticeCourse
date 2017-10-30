package co.japo.mytest;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View nombreCompleto = findViewById(R.id.nombre_completo);
        View nombreInstitucion = findViewById(R.id.nombre_institucion);
        View frase = findViewById(R.id.frase);

        if(nombreCompleto instanceof TextView){
            ((TextView) nombreCompleto).setText(R.string.label_owner_name);
        }

        if(nombreInstitucion instanceof TextView){
            ((TextView) nombreInstitucion).setText(R.string.label_owner_institution);
        }

        if(frase instanceof TextView){
            ((TextView) frase).setText(R.string.label_owner_quote);
        }
    }
}
