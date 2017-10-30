package co.japo.fragmentexample;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements BlueFragment.OnFragmentInteractionListener,
        GreenFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.myGreenButton).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.myFrameLayout,
                                GreenFragment.newInstance("",""))
                        .addToBackStack("Green")
                        .commit();
            }
        });

        findViewById(R.id.myBlueButton).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.myFrameLayout,
                                BlueFragment.newInstance("",""))
                        .addToBackStack("Blue")
                        .commit();
            }
        });
    }

    @Override
    public void onBlueFragmentInteraction(Uri uri) {

    }

    @Override
    public void onGreenFragmentInteraction(Uri uri) {

    }
}
