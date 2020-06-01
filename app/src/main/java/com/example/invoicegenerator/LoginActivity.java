package com.example.invoicegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {



    EditText email;
    EditText password;
    Button login;
    TextView register;
    DBHelper db;
   // ViewGroup progressView;
    protected boolean isProgressShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


     /*  Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        View v = this.getLayoutInflater().inflate(R.layout.progressbar, null);
        dialog.setContentView(v);
        dialog.show();*/

        db = new DBHelper(this);
        email = (EditText) findViewById(R.id.txtlemail);
        password = (EditText) findViewById(R.id.txtlpassword);
        login = (Button) findViewById(R.id.btnlogin);
        register = (TextView) findViewById(R.id.txtviewsignup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = email.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if (res == true) {
                    Intent HomePage = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(HomePage);
                } else {
                    Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

  /*  public void showProgressingView() {

        if (!isProgressShowing) {
            View view=findViewById(R.id.progressBar1);
            view.bringToFront();
        }
    }

    public void hideProgressingView() {
        View v = this.findViewById(android.R.id.content).getRootView();
        ViewGroup viewGroup = (ViewGroup) v;
        viewGroup.removeView(progressView);
        isProgressShowing = false;
    }*/

}
