package com.example.pctruong.lession_23;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements OnClickListener {


    // UI references.
    private EditText edtemail;
    private EditText edtpass;
    private View btnlogin ;

    String email="josephtruong200390gmail.com";
    String pass="12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtemail= (EditText) findViewById(R.id.edtemail);
        edtpass= (EditText) findViewById(R.id.edtpassword);
        btnlogin=findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);

        SharedPreferences share=getSharedPreferences("android",MODE_PRIVATE);

        String e=share.getString("email","");
        String p=share.getString("pass","");

        if(e.equalsIgnoreCase(email)&&p.equalsIgnoreCase(pass)){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onClick(View v) {
        if(edtpass.length()==0||edtemail.length()==0){
            Toast.makeText(this, "Xem lại dữ liệu nhập", Toast.LENGTH_SHORT).show();
        }
        else {
            if(edtemail.getText().toString().equalsIgnoreCase(email)&&edtpass.getText().toString().equalsIgnoreCase(pass)){
                SharedPreferences preferences=getSharedPreferences("android",MODE_PRIVATE);
                SharedPreferences.Editor edit=preferences.edit();
                edit.putString("email",edtemail.getText().toString());
                edit.putString("pass",edtpass.getText().toString());
                edit.commit();

                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(this, "Xem lại dữ liệu nhập", Toast.LENGTH_SHORT).show();
            }
        }
    }


}