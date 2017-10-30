package co.japo.layoutsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        setTitle(R.string.label_grid_view);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        ArrayAdapter adapter = new WebSiteAdapter(this, WebSiteRepository.webs,"gridView");

        gridView.setAdapter(adapter);
    }
}
