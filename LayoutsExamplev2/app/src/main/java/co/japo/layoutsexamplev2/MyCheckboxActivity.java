package co.japo.layoutsexamplev2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MyCheckboxActivity extends AppCompatActivity implements View.OnClickListener{

    private CheckBox mMyCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_checkbox);
        mMyCheckbox = (CheckBox) findViewById(R.id.my_checkbox);
        findViewById(R.id.my_checkbox_status_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_checkbox_status_button:
                Toast.makeText(MyCheckboxActivity.this,
                        mMyCheckbox.isChecked() ? "Checked" : "Not Checked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
