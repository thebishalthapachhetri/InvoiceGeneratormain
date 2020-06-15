package com.example.invoicegenerator;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class AddinvoiceActivity extends AppCompatActivity {

    Button btn_createinvoice;
    Button btn_cancel;



    EditText tv_icustomername;
    EditText tv_icustomeremail;
    EditText tv_icustomercompany;
    EditText tv_iitemview;
    EditText tv_idescription;
    EditText tv_ipaymentdate;
    EditText tv_iremark;
    EditText tv_idiscount;
    EditText tv_iamountpaid;
    EditText tv_itaxamount;
    EditText tv_iprice;
    EditText tv_itotal;
    EditText tv_iqty;
    EditText tv_isubtotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addinvoice);

        btn_createinvoice = findViewById(R.id.btncreateinvoice);
        btn_cancel = findViewById(R.id.btncancelinvoice);


        tv_icustomername = findViewById(R.id.txtcustomername);
        tv_icustomeremail = findViewById(R.id.txtlemail);
        tv_icustomercompany = findViewById(R.id.txtcompanyname);
        tv_iitemview = findViewById(R.id.txtitemname);
        tv_idescription = findViewById(R.id.txtdescription);
        tv_ipaymentdate = findViewById(R.id.txtpaymentdate);
        tv_iremark = findViewById(R.id.txtremark);
        tv_idiscount = findViewById(R.id.txtdiscount);
        tv_iamountpaid = findViewById(R.id.txtamountpaid);
        tv_itaxamount = findViewById(R.id.txttaxamount);
        tv_iprice = findViewById(R.id.txtprice);
        tv_itotal = findViewById(R.id.txttotal);
        tv_iqty = findViewById(R.id.txtqty);
        tv_isubtotal = findViewById(R.id.txtsubtotal);


        btn_createinvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                invoicemodel Invoicemodel = new invoicemodel(-1, tv_icustomername.getText().toString(), tv_icustomeremail.getText().toString(), tv_icustomercompany.getText().toString(), tv_iitemview.getText().toString(), tv_idescription.getText().toString(), tv_iprice.getText().toString(), tv_iqty.getText().toString(), tv_isubtotal.getText().toString(), tv_itaxamount.getText().toString(), tv_itotal.getText().toString(), tv_ipaymentdate.getText().toString(), tv_idiscount.getText().toString(), tv_iamountpaid.getText().toString(), tv_iremark.getText().toString());



                DatabaseHelper idatabaseHelper = new DatabaseHelper(AddinvoiceActivity.this);

                boolean sucess = idatabaseHelper.addOne(Invoicemodel);

                Toast.makeText(AddinvoiceActivity.this, "sucess " + sucess, Toast.LENGTH_SHORT).show();
            }


        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              DatabaseHelper databaseHelper = new DatabaseHelper(AddinvoiceActivity.this);
               List<invoicemodel> iinvoice = databaseHelper.getInvoice();
               Toast.makeText(AddinvoiceActivity.this, iinvoice.toString(), Toast.LENGTH_SHORT).show();


               //Intent show = new Intent(AddinvoiceActivity.this, invoiceview.class);
                //startActivity(show);
            }
        });

    }
}