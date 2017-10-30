package co.japo.layoutsapp;

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

        findViewById(R.id.linearLayoutVertical).setOnClickListener(this);
        findViewById(R.id.linearLayoutHorizontal).setOnClickListener(this);
        findViewById(R.id.relativeLayout).setOnClickListener(this);
        findViewById(R.id.tableLayout).setOnClickListener(this);
        findViewById(R.id.frameLayout).setOnClickListener(this);
        findViewById(R.id.listView).setOnClickListener(this);
        findViewById(R.id.gridView).setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        Intent intent = null;

        switch(view.getId()){
            case R.id.linearLayoutVertical:
                intent = new Intent(MainActivity.this,LinearLayoutVerticalActivity.class);
                break;
            case R.id.linearLayoutHorizontal:
                intent = new Intent(MainActivity.this,LinearLayoutHorizontalActivity.class);
                break;
            case R.id.relativeLayout:
                intent = new Intent(MainActivity.this,RelativeLayoutActivity.class);
                break;
            case R.id.tableLayout:
                intent = new Intent(MainActivity.this,TableLayoutActivity.class);
                break;
            case R.id.frameLayout:
                intent = new Intent(MainActivity.this,FrameLayoutActivity.class);
                break;
            case R.id.listView:
                intent = new Intent(MainActivity.this,ListViewActivity.class);
                break;
            case R.id.gridView:
                intent = new Intent(MainActivity.this,GridViewActivity.class);
                break;
        }

        if(intent != null)
            startActivity(intent);
    }
}
