package com.example.helloworldactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class hello1 extends AppCompatActivity {
  public  static  String TAG="hello1";
  private static int num=0;
  private int num1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        num++;
        num1=num;
        Log.d(TAG+"_"+num1,"onCreate");
        setContentView(R.layout.hello1_layout);
        Button hello1=(Button) findViewById(R.id.hello1);
        Button hello2=(Button) findViewById(R.id.hello2);
        hello1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hello1.this,hello1.class);
               startActivity(intent);
            }
        });
        hello2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(hello1.this,hello2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG+"_"+num1,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG+"_"+num1,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG+"_"+num1,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG+"_"+num1,"onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG+"_"+num1,"onDestroy");
        num--;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG+"_"+num1,"onRestart");
    }
}
