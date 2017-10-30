package co.japo.notificationandservicesexample;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.IntDef;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyCounterService extends Service implements Runnable {

    private int counter;
    private Handler mHandler;
    private boolean running;
    private MyCounterListener myCounterListener;
    private MyCounterBinder mBinder = new MyCounterBinder();

    public MyCounterService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Looper looper = Looper.getMainLooper();
        mHandler = new Handler(looper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent.getAction().equals("START")){
            mHandler.post(this);
            this.running = true;
        }else if(intent.getAction().equals("STOP")){
            mHandler.removeCallbacks(this);
            this.running = false;
            stopForeground(true);
        }

        if(myCounterListener != null){
            if(this.running){
                myCounterListener.isRunning();
            }else{
                myCounterListener.isStopped();
            }
        }
        return START_STICKY;
    }

    @Override
    public void run() {
        counter++;
        Log.d("MyServiceCounter","Counter value: "+counter);
        myCounterListener.counterChanged(counter);
        publishNotification();
        mHandler.postDelayed(this,1000);
    }

    public void publishNotification(){
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Counter")
                .setContentText(String.format("Current val : %d",counter))
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1,notification);
    }

    public void setMyCounterListener(MyCounterListener myCounterListener) {
        this.myCounterListener = myCounterListener;
    }

    public void requestStatus(){
        if(myCounterListener != null){
            if(running)
                myCounterListener.isRunning();
            else
                myCounterListener.isStopped();
            myCounterListener.counterChanged(counter);
        }
    }

    public interface MyCounterListener{
        void counterChanged(int counter);
        void isRunning();
        void isStopped();
    }

    public class MyCounterBinder extends Binder {

        public MyCounterService getMyCounterService(){
            return MyCounterService.this;
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
       return mBinder;
    }
}
