package co.japo.layoutsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        setTitle(R.string.label_list_view);

        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter = new WebSiteAdapter(this, WebSiteRepository.webs,"listView");

        listView.setAdapter(adapter);
    }
}
