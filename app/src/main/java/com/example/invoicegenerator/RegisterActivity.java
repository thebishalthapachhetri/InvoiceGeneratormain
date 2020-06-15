package com.example.invoicegenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

        TextView backtologin;
        TextView fullname;
        TextView email;
        TextView password;
        TextView confirmpassword;
        TextView company;
        TextView country;
        Button register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        backtologin = findViewById(R.id.txtviewlogin);
        fullname = findViewById(R.id.txtfullname);
        email = findViewById(R.id.txtlemail);
        password = findViewById(R.id.txtlpassword);
        confirmpassword = findViewById(R.id.txtconfirmpassword);
        company = findViewById(R.id.txtcompany);
        country = findViewById(R.id.txtcountry);
        register = findViewById(R.id.button3);




        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent backtologinintent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(backtologinintent);

            }


        });


      register.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent mainactivity = new Intent(RegisterActivity.this, MainActivity.class);
              startActivity(mainactivity);


              Toast.makeText(RegisterActivity.this, "You have sucessfully registered", Toast.LENGTH_SHORT).show();
          }
      });



    }
}

