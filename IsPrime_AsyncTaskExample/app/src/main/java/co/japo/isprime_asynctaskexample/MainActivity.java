package co.japo.isprime_asynctaskexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView progress;
    private ProgressBar progressBar;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (TextView) findViewById(R.id.progress);
        progressBar = (ProgressBar) findViewById(R.id.barProgress);
        result = (TextView) findViewById(R.id.result);

    }

    @Override
    protected void onPause(){
        if(asyncTask != null){
            asyncTask.cancel(true);
        }
    }
    private AsyncTask<Long,Integer,String> asyncTask;

    public void start(View view){
        if(asyncTask != null){
            asyncTask.cancel(true);
        }
        String num = ((TextView) findViewById(R.id.enterNum)).getText().toString();
        progress.setText("");
        result.setText("");
        progressBar.setMax(Integer.parseInt(num));
        try{
            asyncTask = new AsyncTask<Long, Integer, String>() {
                @Override
                protected String doInBackground(Long... nums) {
                    boolean result = false;

                    for(int i = 1; i <= nums[0]; i++){
                        publishProgress(i);
                        try {
                            Thread.sleep(25);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    result =  isPrime(nums[0]);
                    return result ? "Is Prime" : "Not Prime";
                }

                @Override
                protected void onPostExecute(String s) {
                    result.setText(s);
                }

                @Override
                protected void onProgressUpdate(Integer... values) {
                    progress.setText("Progress: "+values[0]);
                    progressBar.setProgress(values[0]);
                }
            };

            asyncTask.execute(Long.parseLong(num));
        }catch(Exception ex){
            Toast.makeText(MainActivity.this,"Only numbers are acceptable",Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private boolean isPrime(Long num){
        if(num == 2) return true;
        if(num %2 == 0) return false;
        for(int i = 3; i*i <= num; i+=2){
            if(num % i == 0) return false;
        }
        return true;
    }
}
