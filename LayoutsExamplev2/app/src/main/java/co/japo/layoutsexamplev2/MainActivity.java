package co.japo.layoutsexamplev2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.my_text_view_button).setOnClickListener(this);
        findViewById(R.id.my_image_view_button).setOnClickListener(this);
        findViewById(R.id.my_edit_text_button).setOnClickListener(this);
        findViewById(R.id.my_auto_complete_text_view_button).setOnClickListener(this);
        findViewById(R.id.my_button_view_button).setOnClickListener(this);
        findViewById(R.id.my_image_button_view_button).setOnClickListener(this);
        findViewById(R.id.my_checkbox_view_button).setOnClickListener(this);
        findViewById(R.id.my_toggle_button_view_button).setOnClickListener(this);
        findViewById(R.id.my_radio_button_view_button).setOnClickListener(this);
        findViewById(R.id.my_radio_group_view_button).setOnClickListener(this);
        findViewById(R.id.my_progress_bar_view_button).setOnClickListener(this);
        findViewById(R.id.my_spinner_view_button).setOnClickListener(this);
        findViewById(R.id.my_time_picker_view_button).setOnClickListener(this);
        findViewById(R.id.my_date_picker_view_button).setOnClickListener(this);
        findViewById(R.id.my_datetime_picker_view_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch(view.getId()){
            case R.id.my_text_view_button:
                intent = new Intent(MainActivity.this,MyTextViewActivity.class);
                break;
            case R.id.my_image_view_button:
                intent = new Intent(MainActivity.this,MyImageViewActivity.class);
                break;
            case R.id.my_edit_text_button:
                intent = new Intent(MainActivity.this,MyEditTextActivity.class);
                break;
            case R.id.my_auto_complete_text_view_button:
                intent = new Intent(MainActivity.this,MyAutoCompleteTextViewActivity.class);
                intent.putExtra("boolVal",false);
                intent.putExtra("stringVal","este es el nuevo hint");
                intent.putExtra("activityName","Auto Complete Activity");
                Bundle b = new Bundle();
                b.putString("name","texto");
                b.putString("surname","Nombre");
                b.putString("hintReal","Este deberia ser el hint");

                intent.putExtra("bundleVal",b);
                break;
            case R.id.my_button_view_button:
                intent = new Intent(MainActivity.this,MyButtonActivity.class);
                break;
            case R.id.my_image_button_view_button:
                intent = new Intent(MainActivity.this,MyImageButtonActivity.class);
                break;
            case R.id.my_checkbox_view_button:
                intent= new Intent(MainActivity.this,MyCheckboxActivity.class);
                break;
            case R.id.my_toggle_button_view_button:
                intent = new Intent(MainActivity.this,MyToggleButtonActivity.class);
                break;
            case R.id.my_radio_button_view_button:
                intent = new Intent(MainActivity.this,MyRadioButtonActivity.class);
                break;
            case R.id.my_radio_group_view_button:
                intent = new Intent(MainActivity.this,MyRadioGroupActivity.class);
                break;
            case R.id.my_progress_bar_view_button:
                intent = new Intent(MainActivity.this,MyProgressBarActivity.class);
                break;
            case R.id.my_spinner_view_button:
                intent = new Intent(MainActivity.this,MySpinnerActivity.class);
                break;
            case R.id.my_time_picker_view_button:
                intent = new Intent(MainActivity.this,MyTimePickerActivity.class);
                break;
            case R.id.my_date_picker_view_button:
                intent = new Intent(MainActivity.this,MyDatePickerActivity.class);
                break;
            case R.id.my_datetime_picker_view_button:
                intent = new Intent(MainActivity.this,MyDateTimePickerActivity.class);
                break;
        }
        if(intent != null)
            startActivity(intent);
    }
}
