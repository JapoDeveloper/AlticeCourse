package co.japo.layoutsexamplev2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MyToggleButtonActivity extends AppCompatActivity implements View.OnClickListener {

    private ToggleButton mMyToggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_toggle_button);
        mMyToggleButton = (ToggleButton) findViewById(R.id.my_toggle_button);
        findViewById(R.id.my_toggle_status_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_toggle_status_button:
                Toast.makeText(MyToggleButtonActivity.this,
                        mMyToggleButton.isChecked() ? mMyToggleButton.getTextOn() : mMyToggleButton.getTextOff(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
