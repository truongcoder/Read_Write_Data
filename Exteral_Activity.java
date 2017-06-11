package com.example.pctruong.lession_23;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exteral_Activity extends AppCompatActivity implements View.OnClickListener {
View btnsave , btnread;
EditText edt;
 final String fileName="android.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exteral);
        btnread=findViewById(R.id.btn_read);
        btnsave=findViewById(R.id.btn_save);
        edt= (EditText) findViewById(R.id.edit_ex);
        btnsave.setOnClickListener(this);
        btnread.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_read :
                readfile();
                break;
            case R.id.btn_save :
                savefile();
                break;
        }
    }

    private void readfile() {
        File myfile=new File(Environment.getExternalStorageDirectory(),fileName);
        String content="";
        try {
            FileInputStream in=new FileInputStream(myfile);
            //đoc từng kí tự
            int character=-1;
            character=in.read();
            while (character!=-1){
                content+=(char)character;
                character=in.read();
            }
            in.close();
            Toast.makeText(this, "Dữ liệu"+content, Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savefile() {


        File file=new File(Environment.getExternalStorageDirectory(),fileName);
        Environment.getExternalStorageDirectory().getAbsolutePath();
        try {
            FileOutputStream os=new FileOutputStream(file);
            //FileOutputStream os=new FileOutputStream(file,true); nối thêm chuỗi
            os.write(edt.getText().toString().getBytes());
            os.close();
            Toast.makeText(this, "Save file thành công", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
