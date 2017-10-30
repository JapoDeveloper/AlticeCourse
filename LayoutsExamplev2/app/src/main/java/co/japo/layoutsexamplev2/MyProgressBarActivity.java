package co.japo.layoutsexamplev2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MyProgressBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_progress_bar);

        final ProgressBar progressBarDet = (ProgressBar) findViewById(R.id.my_progress_bar_det);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while(i <= 10){
                    progressBarDet.setProgress(i*10);
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
