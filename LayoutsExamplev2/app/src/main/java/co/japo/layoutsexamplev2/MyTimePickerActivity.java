package co.japo.layoutsexamplev2;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MyTimePickerActivity extends AppCompatActivity implements View.OnClickListener{

    private TimePicker mMyTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_time_picker);

        mMyTimePicker = (TimePicker) findViewById(R.id.my_time_picker);
        findViewById(R.id.my_show_time).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        StringBuilder sb = new StringBuilder();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            sb.append(mMyTimePicker.getHour());
        }else{
            //noinspection deprecation
            sb.append(mMyTimePicker.getCurrentHour());
        }
        sb.append(":");
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            sb.append(mMyTimePicker.getMinute());
        }else{
            //noinspection deprecation
            sb.append(mMyTimePicker.getCurrentMinute());
        }
        Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
    }
}
