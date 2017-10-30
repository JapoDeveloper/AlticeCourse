package co.japo.notificationandservicesexample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyCounterService.MyCounterListener{

    private boolean running;
    private Button myButton;
    private TextView myCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCounter =(TextView) findViewById(R.id.myCounter);
       myButton = (Button) findViewById(R.id.myButton);
        myButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, MyCounterService.class);
                if(!running) {
                    intent.setAction("START");
                }else{
                    intent.setAction("STOP");
                }
                startService(intent);
            }
        });

        Intent intent = new Intent(this, MyCounterService.class);
        bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        unbindService(mServiceConnection);
        super.onDestroy();
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if(iBinder instanceof MyCounterService.MyCounterBinder){
                ((MyCounterService.MyCounterBinder) iBinder)
                        .getMyCounterService()
                        .setMyCounterListener(MainActivity.this);
                ((MyCounterService.MyCounterBinder) iBinder).getMyCounterService().requestStatus();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    public void counterChanged(int counter) {
        myCounter.setText(String.format("Counter value : %d",counter));
    }

    @Override
    public void isRunning() {
        myButton.setText("Stop");
        running = true;
    }

    @Override
    public void isStopped() {
        myButton.setText("Start");
        running = false;
    }
}
