package com.example.pctruong.lession_23;

import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Internal_Activity extends AppCompatActivity implements View.OnClickListener {
    View btnsave_it , btnread_it;
    EditText edt;
    final String fileName="android.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);
        btnread_it=findViewById(R.id.btn_read_it);
        btnsave_it=findViewById(R.id.btn_save_it);
        edt= (EditText) findViewById(R.id.edit_it);
        btnsave_it.setOnClickListener(this);
        btnread_it.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_read_it :
                readfile();
                break;
            case R.id.btn_save_it :
                savefile();
                break;
        }
    }
    private void readfile() {
        ContextWrapper wp=new ContextWrapper(Internal_Activity.this);
        File myfile=new File(wp.getFilesDir(),fileName);

        String content="";
        try {
            FileInputStream in=new FileInputStream(myfile);
            BufferedReader rd=new BufferedReader(new InputStreamReader(in));
            String line=rd.readLine();
            while (line!=null){
                content+=line;
                line=rd.readLine();
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

        ContextWrapper wp=new ContextWrapper(Internal_Activity.this);
        File file=new File(wp.getFilesDir(),fileName);
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
