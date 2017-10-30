package co.japo.layoutsexamplev2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MyRadioButtonActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton mMyRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_radio_button);

        mMyRadioButton = (RadioButton) findViewById(R.id.my_radio_button);
        findViewById(R.id.my_clear_radio_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(MyRadioButtonActivity.this,"RadioButton was "
                +(mMyRadioButton.isChecked() ? "checked" : "not checked"),Toast.LENGTH_SHORT).show();
        mMyRadioButton.setChecked(false);
    }
}
