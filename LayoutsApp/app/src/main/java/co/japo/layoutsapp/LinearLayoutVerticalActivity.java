package co.japo.layoutsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LinearLayoutVerticalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_vertical);
        setTitle(R.string.label_linear_layout_vertical);
    }
}
