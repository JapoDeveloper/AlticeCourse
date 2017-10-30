package co.japo.personaldataproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by japodeveloper on 9/30/17.
 */

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Bundle userData = getIntent().getBundleExtra("userData");

        ((TextView) findViewById(R.id.user_first_name)).setText(userData.getString("firstName"));
        ((TextView) findViewById(R.id.user_last_name)).setText(userData.getString("lastName"));
        ((TextView) findViewById(R.id.user_age)).setText(userData.getInt("age")+"");

    }
}
