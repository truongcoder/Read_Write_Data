package com.example.pctruong.lession_23;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityDangKi extends AppCompatActivity {
 static   SharedPreferences sharedPreferences;
   EditText editten,editmatkhau;
    Button btndk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dangki);
         sharedPreferences=getSharedPreferences("taikhoan",MODE_PRIVATE);
         editmatkhau= (EditText) findViewById(R.id.edtmatkhaudk);
         editten= (EditText) findViewById(R.id.edtmatkhaudk);
         btndk= (Button) findViewById(R.id.btndk);
         btndk.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                if(editten.length()>0&&editmatkhau.length()>0) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("ten",editten.getText().toString());
                editor.putString("matkhau",editmatkhau.getText().toString()) ;
                editor.commit();
                finish();
                }
                else{
                    Toast.makeText(MainActivityDangKi.this, "Xem lại tên hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
             }
         });
    }
}
