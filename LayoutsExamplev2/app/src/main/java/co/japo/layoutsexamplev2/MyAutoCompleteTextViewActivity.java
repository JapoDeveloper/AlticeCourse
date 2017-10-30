package co.japo.layoutsexamplev2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MyAutoCompleteTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_auto_complete_text_view);

        String[] data = {"Cat","Dog","Mouse","Elephant","Eagle"};

        AutoCompleteTextView autoCompleteTextView = ((AutoCompleteTextView) findViewById(R.id.my_auto_complete_text_view));
        autoCompleteTextView.setAdapter(
                new ArrayAdapter<>(this,android.R.layout.select_dialog_item,data)
        );
        autoCompleteTextView.setThreshold(1);

        if(getIntent().hasExtra("bundleVal"))
            autoCompleteTextView.setHint(getIntent().getBundleExtra("bundleVal").getString("hintReal"));
        
        if(getIntent().hasExtra("activityName"))
            getSupportActionBar().setTitle(getIntent().getStringExtra("activityName"));

    }
}
