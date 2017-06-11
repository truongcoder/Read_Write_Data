package com.example.pctruong.lession_23;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Extenal(View view) {
        Intent intent=new Intent(MainActivity.this,Exteral_Activity.class);
        startActivity(intent);
    }

    public void Internal(View view) {
        Intent intent=new Intent(MainActivity.this,Internal_Activity.class);
        startActivity(intent);
    }

    public void SharedPreferences(View view) {

    }
}
