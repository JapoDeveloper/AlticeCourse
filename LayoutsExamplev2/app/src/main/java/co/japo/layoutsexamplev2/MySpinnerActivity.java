package co.japo.layoutsexamplev2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MySpinnerActivity extends AppCompatActivity implements View.OnClickListener{

    private Spinner mMySpinner;
    private String [] data = {"Cat","Dog","Fish"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_spinner);

        mMySpinner = (Spinner) findViewById(R.id.my_spinner);
        findViewById(R.id.my_show_spinner).setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMySpinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(MySpinnerActivity.this,mMySpinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
    }
}

