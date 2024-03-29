package com.example.servicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
       private  MyService.DownloadBinder downloadBinder;
       private ServiceConnection connection=new ServiceConnection() {

           @Override
           public void onServiceDisconnected(ComponentName componentName) {
           }
           @Override
           public  void  onServiceConnected(ComponentName name, IBinder service){
               downloadBinder=(MyService.DownloadBinder) service;
               downloadBinder.startDownload();
               downloadBinder.getProgress();
           }
       };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startService=(Button) findViewById(R.id.start_service);
        Button stopService=(Button) findViewById(R.id.stop_service);
        Button bindService=(Button) findViewById(R.id.bind_service);
        Button unbindService=(Button) findViewById(R.id.unbind_service);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_service:
                Intent startIntent =new Intent (this,MyService.class);
                startService(startIntent);
                break;
            case R.id.stop_service:
                Intent stopIntent =new Intent(this,MyService.class);
                stopService(stopIntent);
            case  R.id.bind_service:
                Intent bindIntent=new Intent(this,MyService.class);
                bindService(bindIntent,connection,BIND_ABOVE_CLIENT);

                break;
                default:
                    break;
        }
    }
}
