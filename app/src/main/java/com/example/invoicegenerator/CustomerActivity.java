package com.example.invoicegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerActivity extends AppCompatActivity {
    Button btn_createcustomer;
   // Button btn_view;
    EditText tv_customername;
    EditText tv_customeremail;
    EditText tv_customercompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        btn_createcustomer = findViewById(R.id.btncreatecustomer);
       // btn_view = findViewById(R.id.btnview);
        tv_customername = findViewById(R.id.txtaddcustomername);
        tv_customeremail = findViewById(R.id.txtaddcustomeremail);
        tv_customercompany = findViewById(R.id.txtaddcustomercompany);

        // button listner
      /*  btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openintent = new Intent(CustomerActivity.this, ShowcustomerActivity.class);
                startActivity(openintent);
            }
        });*/

        btn_createcustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(tv_customername.getText()) || TextUtils.isEmpty(tv_customeremail.getText()) ){

                    Toast.makeText(CustomerActivity.this, "Customer name and email is required", Toast.LENGTH_SHORT).show();
                    tv_customername.setError( null);
                    tv_customeremail.setError(null);


                }else {


                    model Model = new model(-1, tv_customername.getText().toString(), tv_customeremail.getText().toString(), tv_customercompany.getText().toString());
                    //Toast.makeText(CustomerActivity.this, "Customer Added", Toast.LENGTH_SHORT).show();


                    DatabaseHelper databaseHelper = new DatabaseHelper(CustomerActivity.this);

                    boolean sucess = databaseHelper.addOne(Model);

                    Toast.makeText(CustomerActivity.this, "Customer Added " + sucess, Toast.LENGTH_SHORT).show();
                }

            }




        });

    }
}