package co.japo.personaldataproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.TimeUnit;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Calendar mCalendar;
    private DatePickerDialog mDatePicker;
    private SimpleDateFormat mDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalendar = Calendar.getInstance();
        mDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        mDatePicker = new DatePickerDialog(this,mDatePickerListener,
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DATE));
        findViewById(R.id.send_button).setOnClickListener(this);
        findViewById(R.id.select_date_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.send_button:
                //Recover user data
                String firstName = "", lastName = "";
                Date birthDate = null;

                firstName = ((TextView) findViewById(R.id.first_name)).getText().toString();
                lastName = ((TextView) findViewById(R.id.last_name)).getText().toString();
                birthDate = mCalendar.getTime();

                long userAge = new GregorianCalendar().getTime().getTime() - mCalendar.getTime().getTime();

                Intent intent = new Intent(MainActivity.this,UserDetailsActivity.class);

                Bundle userData = new Bundle();
                userData.putString("firstName", firstName);
                userData.putString("lastName", lastName);
                userData.putInt("age", (int) (userAge / DateUtils.YEAR_IN_MILLIS));

                intent.putExtra("userData",userData);
                startActivity(intent);
                break;
            case R.id.select_date_button:
                mDatePicker.show();
                break;
        }

    }

    private DatePickerDialog.OnDateSetListener mDatePickerListener = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int date){
            mCalendar.set(Calendar.YEAR,year);
            mCalendar.set(Calendar.MONTH,month);
            mCalendar.set(Calendar.DATE,date);
            ((TextView) findViewById(R.id.birth_date_display)).setText(mDateFormat.format(mCalendar.getTime()));
        }
    };
}
