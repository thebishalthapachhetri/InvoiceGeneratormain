package com.example.invoicegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    // ViewGroup progressView;
    //protected boolean isProgressShowing = false;

    TextView tv_register;
    Button    btn_login;
    TextView  lemail, lpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_register = findViewById(R.id.txtviewsignup);
        btn_login = findViewById(R.id.btnlogin);
        lemail = findViewById(R.id.txtlemail);
        lpassword = findViewById(R.id.txtlpassword);




        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent registerintent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerintent);




            }



        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent login   = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(login);
                    }
                });

            }
        });





    }


    private void validate (String username, String password){

        if( username == "bishal" && (password == "bishal")  )
        {
            Intent login   = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(login);
        }
        else
        {
            Toast.makeText(LoginActivity.this, "Invalid username and password please check attached txt file", Toast.LENGTH_LONG ).show();
        }


    }


}


