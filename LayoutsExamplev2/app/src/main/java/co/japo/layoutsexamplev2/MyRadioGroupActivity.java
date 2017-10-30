package co.japo.layoutsexamplev2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MyRadioGroupActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioGroup mMyRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_radio_group);
        mMyRadioGroup = (RadioGroup) findViewById(R.id.my_radio_group);
        findViewById(R.id.my_show_radio_group).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        RadioButton selected = (RadioButton) findViewById(mMyRadioGroup.getCheckedRadioButtonId());
        if(selected != null)
            Toast.makeText(MyRadioGroupActivity.this,"Selected: "+selected.getText(),Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MyRadioGroupActivity.this,"Please select an animal",Toast.LENGTH_SHORT).show();
    }
}
