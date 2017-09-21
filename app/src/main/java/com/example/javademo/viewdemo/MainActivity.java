package com.example.javademo.viewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btnCir,btnChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
    }

    private void init() {
        btnCir=(Button)findViewById(R.id.toCir);
        btnChat=(Button)findViewById(R.id.toChat);
        btnCir.setOnClickListener(this);
        btnChat.setOnClickListener(this);
   }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toChat :
                    startActivity(new Intent(this,ChatActivity.class));
                break;

            case R.id.toCir :
                startActivity(new Intent(this,CircleActivity.class));
                break;
        }
    }
}
