package com.example.parthvaishnavi.project;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aditya on 18-07-2018.
 */
public class Doctor extends AppCompatActivity{

    EditText user,pass;
    LinearLayout login;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor);

        user=findViewById(R.id.username1);
        pass=(EditText) findViewById(R.id.password1);
        login=findViewById(R.id.lv_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getText().toString().equals("admin") && pass.getText().toString().equals("admin"))
                {
                    Intent intent=new Intent(Doctor.this,DoctorDatabase.class);
                    intent.putExtra("admin",user.getText().toString());
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"INCORRECT USERNAME/PASSWORD",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
