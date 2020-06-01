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

    DBHelper db;
    EditText full_name;
    EditText email;
    EditText password;
    EditText confirm_password;
    EditText country;
    EditText company;
    Button register;
    TextView tvlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DBHelper(this);
        full_name = (EditText) findViewById(R.id.txtfullname);
        email = (EditText) findViewById(R.id.txtlemail);
        password = (EditText) findViewById(R.id.txtlpassword);
        confirm_password = (EditText) findViewById(R.id.txtconfirmpassword);
        country = (EditText) findViewById(R.id.txtcountry);
        company = (EditText) findViewById(R.id.txtcompany);
        register = (Button) findViewById(R.id.btnlogin);
        tvlogin = (TextView) findViewById(R.id.txtviewlogin);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = full_name.getText().toString().trim();
                String user = email.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                String cnf_pwd = confirm_password.getText().toString().trim();
                String cntry = country.getText().toString().trim();
                String cmpny = company.getText().toString().trim();


                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd);
                    if(val > 0){
                        Toast.makeText(RegisterActivity.this,"You have registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Registeration Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(RegisterActivity.this,"Password is not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
