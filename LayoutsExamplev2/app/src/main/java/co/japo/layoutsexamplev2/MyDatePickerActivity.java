package co.japo.layoutsexamplev2;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MyDatePickerActivity extends AppCompatActivity implements View.OnClickListener{

    private DatePicker mMyDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_date_picker);

        mMyDatePicker = (DatePicker) findViewById(R.id.my_date_picker);
        findViewById(R.id.my_show_date).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append(mMyDatePicker.getDayOfMonth());
        sb.append("/");
        sb.append(mMyDatePicker.getMonth()+1);
        sb.append("/");
        sb.append(mMyDatePicker.getYear());
        Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
    }
}
