package com.example.helloworldactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hello2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello2_layout);
        Button hello1=(Button) findViewById(R.id.hello1);
        final Button hello2=(Button) findViewById(R.id.hello2);
       hello2.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               Intent intent=new Intent(hello2.this,hello2.class);
               startActivity(intent);
           }});
        hello1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(hello2.this,hello1.class);
                startActivity(intent);
            }});
    }
}
