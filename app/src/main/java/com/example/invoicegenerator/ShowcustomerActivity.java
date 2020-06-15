package com.example.invoicegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ShowcustomerActivity extends AppCompatActivity {


   // Button btn_showcustomer;
    ListView lv_customer;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcustomer);

        //btn_showcustomer = findViewById(R.id.btnshowcustomer);
        lv_customer =findViewById(R.id.lvcustomer);

        databaseHelper = new DatabaseHelper(ShowcustomerActivity.this);
        ShowCustomerOnListView();

       // btn_showcustomer.setOnClickListener(new View.OnClickListener() {
      //      @Override
       //     public void onClick(View v) {






                // Toast.makeText(showcustomer.this, Customer.toString(), Toast.LENGTH_SHORT).show();
       //     }
       // });



    }

    private void ShowCustomerOnListView() {
        ArrayAdapter customerArrayAdapter = new ArrayAdapter<model>(ShowcustomerActivity.this,android.R.layout.simple_selectable_list_item,databaseHelper.getCustomer());
        lv_customer.setAdapter(customerArrayAdapter);
    }

}