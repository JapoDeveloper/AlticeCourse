package co.japo.layoutsexamplev2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyEditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_edit_text);

        ((Button) findViewById(R.id.my_button)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.my_edit_text);
                Toast.makeText(MyEditTextActivity.this,
                        editText.getText().toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
