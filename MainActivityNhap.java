package com.example.pctruong.lession_23;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.pctruong.lession_23.MainActivityDangKi.sharedPreferences;

public class MainActivityNhap extends AppCompatActivity {
EditText edtten,edtmatkhau;
Button btndangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dangnhap);
        edtmatkhau= (EditText) findViewById(R.id.edtmatkhaudn);
        edtten= (EditText) findViewById(R.id.edttendn);
        btndangnhap= (Button) findViewById(R.id.btnldangnhap);
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String tendn , matkhaudn ,ten ,matkhau;
               tendn=edtten.getText().toString();
               matkhaudn=edtmatkhau.getText().toString();
               ten=sharedPreferences.getString("ten","") ;
               matkhau=sharedPreferences.getString("matkhau","") ;
               if(tendn.equalsIgnoreCase(ten)&&matkhaudn.equalsIgnoreCase(matkhau)) {
                   Intent intent=new Intent(MainActivityNhap.this,MainActivity.class);
                   startActivity(intent);
                   finish();
               }
                else {
                   Toast.makeText(MainActivityNhap.this, "Nhập sai", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    public void DangKi(View view) {
        Intent intent=new Intent(MainActivityNhap.this,MainActivityDangKi.class);
        startActivity(intent);
    }
}
