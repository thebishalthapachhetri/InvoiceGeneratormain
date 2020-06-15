package com.example.invoicegenerator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.graphics.ColorSpace;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {





    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";

    public static final String COLUMN_CID = "COLUMN_ID";
    public static final String COLUMN_CNAME = "COLUMN_NAME";
    public static final String COLUMN_CEMAIL = "COLUMN_EMAIL";
    public static final String COLUMN_CCOMPANY = "COLUMN_COMPANY";



    public static final String INVOICE_TABLE = "INVOICE_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_COMPANY = "COMPANY";
    public static final String COLUMN_ITEMNAME = "ITEMNAME";
    public static final String COLUMN_DESCRIPTION = "DESCRIPTION";
    public static final String COLUMN_PRICE = "PRICE";
    public static final String COLUMN_QTY = "QTY";
    public static final String COLUMN_TOTAL = "TOTAL";
    public static final String COLUMN_SUBTOTAL = "SUBTOTAL";
    public static final String COLUMN_TAXAMOUNT = "TAXAMOUNT";
    public static final String COLUMN_PAYMENTDATE = "PAYMENTDATE";
    public static final String COLUMN_AMOUNTPAID = "AMOUNTPAID";
    public static final String COLUMN_DISCOUNT = "DISCOUNT";
    public static final String COLUMN_REMARK = "REMARK";




    //private Object insert;






    public DatabaseHelper(@Nullable Context context) {
        super(context, "invoice.db", null, 1);
    }

    //there should be code for table
    @Override
    public void onCreate(SQLiteDatabase db) {

        //  db.execSQL("DROP TABLE IF EXISTS " + INVOICE_TABLE);
        String createcustomerTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (" + COLUMN_CID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CNAME + " TEXT, " + COLUMN_CEMAIL + " TEXT, " + COLUMN_CCOMPANY + " TEXT )";
        db.execSQL(createcustomerTableStatement);


        String createinvoiceTableStatement = "CREATE TABLE " + INVOICE_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_EMAIL + " TEXT, " + COLUMN_COMPANY + " TEXT, " + COLUMN_ITEMNAME + " TEXT, " + COLUMN_DESCRIPTION + " TEXT, " + COLUMN_PRICE + " TEXT, " + COLUMN_QTY + " TEXT, " + COLUMN_SUBTOTAL + " TEXT, " + COLUMN_TAXAMOUNT + " TEXT, " + COLUMN_TOTAL + " TEXT, " + COLUMN_PAYMENTDATE + " TEXT, " + COLUMN_DISCOUNT + " TEXT, " + COLUMN_AMOUNTPAID + " TEXT, " + COLUMN_REMARK + " TEXT )";
        db.execSQL(createinvoiceTableStatement);
    }


    // it gives the version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(model Model) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();



        cv.put(COLUMN_CNAME, Model.getCname());
        cv.put(COLUMN_CEMAIL, Model.getCemail());
        cv.put(COLUMN_CCOMPANY, Model.getCcompany());

        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }


        // public List<model> getCustomer(){}


    }

    public boolean addOne(invoicemodel Invoicemodel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, Invoicemodel.getIname());
        cv.put(COLUMN_EMAIL, Invoicemodel.getIemail());
        cv.put(COLUMN_COMPANY, Invoicemodel.getIcompany());
        cv.put(COLUMN_ITEMNAME, Invoicemodel.getIitemname());
        cv.put(COLUMN_DESCRIPTION, Invoicemodel.getIdescription());
        cv.put(COLUMN_PRICE, Invoicemodel.getIprice());
        cv.put(COLUMN_QTY, Invoicemodel.getIqty());
        cv.put(COLUMN_SUBTOTAL, Invoicemodel.getIsubtotal());
        cv.put(COLUMN_TAXAMOUNT, Invoicemodel.getItaxamount());
        cv.put(COLUMN_TOTAL, Invoicemodel.getItotal());
        cv.put(COLUMN_PAYMENTDATE, Invoicemodel.getIpaymentdate());
        cv.put(COLUMN_DISCOUNT, Invoicemodel.getIdiscount());
        cv.put(COLUMN_AMOUNTPAID, Invoicemodel.getIamountpaid());
        cv.put(COLUMN_REMARK, Invoicemodel.getIremark());

        long insert = db.insert(INVOICE_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        else{
            return true;
        }

        // public List<model> getCustomer(){}

    }

    public List<model> getCustomer() {

        List<model> returnlist = new ArrayList<>();

        String queryString = "SELECT * FROM " + CUSTOMER_TABLE ;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // loop through the results  and create new customer object for each row
            do {
                int CustomerID = cursor.getInt(0);
                String CustomerName = cursor.getString(1);
                String CustomerEmail = cursor.getString(2);
                String CustomerCompany = cursor.getString(3);

                model newModel = new model(CustomerID, CustomerName, CustomerEmail, CustomerCompany);
                returnlist.add(newModel);
            } while (cursor.moveToNext());

        } else {
            //falure do not add anything
        }
        cursor.close();
        db.close();
        return returnlist;
    }


    public List<invoicemodel> getInvoice() {

        List<invoicemodel> invoicereturnlist = new ArrayList<>();


        String iqueryString = "SELECT * FROM " + INVOICE_TABLE;

        SQLiteDatabase idb = this.getWritableDatabase();


        final Cursor cursor = idb.rawQuery(iqueryString,null);
        //Cursor icursor = idb.rawQuery(iqueryString, null);

        if (cursor.moveToNext()) {
            // loop through the results  and create new customer object for each row
            do {
                int InvoiceID = cursor.getInt(0);
                String Name = cursor.getString(1);
                String Email = cursor.getString(2);
                String Company = cursor.getString(3);
                String ItemView = cursor.getString(4);
                String Description = cursor.getString(5);
                String Price = cursor.getString(6);
                String Qty = cursor.getString(7);
                String Subtotal = cursor.getString(8);
                String Taxamount = cursor.getString(9);
                String Total = cursor.getString(10);
                String PaymentDate = cursor.getString(11);
                String Discount = cursor.getString(12);
                String AmountPaid = cursor.getString(13);
                String Remark = cursor.getString(14);



                invoicemodel newInvoicemodel = new invoicemodel(InvoiceID, Name, Email, Company, ItemView, Description, Price, Qty, Subtotal, Taxamount, Total, PaymentDate, Discount, AmountPaid, Remark);
                invoicereturnlist.add(newInvoicemodel);
            } while (cursor.moveToNext());

        } else {
            //failure do not add anything
        }

        cursor.close();
        idb.close();
        return invoicereturnlist;

    }



    public ArrayList<invoicemodel> getAllData()
    {
        ArrayList<invoicemodel> arrayList = new ArrayList<>();
        SQLiteDatabase gdb = this.getReadableDatabase();

        String gqueryString = "SELECT * FROM " + INVOICE_TABLE;
        Cursor cursor = gdb.rawQuery( gqueryString,null);

        while(cursor.moveToNext())
        {

            int InvoiceID = cursor.getInt(0);
            String Name = cursor.getString(1);
            String Email = cursor.getString(2);
            String Company = cursor.getString(3);
            String ItemView = cursor.getString(4);
            String Description = cursor.getString(5);
            String Price = cursor.getString(6);
            String Qty = cursor.getString(7);
            String Subtotal = cursor.getString(8);
            String Taxamount = cursor.getString(9);
            String Total = cursor.getString(10);
            String PaymentDate = cursor.getString(11);
            String Discount = cursor.getString(12);
            String AmountPaid = cursor.getString(13);
            String Remark = cursor.getString(14);

            invoicemodel ginvoicemodel = new invoicemodel(InvoiceID, Name, Email, Company, ItemView, Description, Price, Qty, Subtotal, Taxamount, Total, PaymentDate, Discount, AmountPaid, Remark);

            arrayList.add(ginvoicemodel);
        }

        return arrayList;


    }

   /* public List<invoicemodel> getmaininvoice() {




        List<invoicemodel> invoicereturnlist = new ArrayList<>();



        String iqueryString = "SELECT * FROM " + INVOICE_TABLE;

        SQLiteDatabase idb = this.getWritableDatabase();


        final Cursor cursor = idb.rawQuery(iqueryString, null  );
        //Cursor icursor = idb.rawQuery(iqueryString, null);

        if (cursor.moveToNext()) {
            // loop through the results  and create new customer object for each row
            do {
                int InvoiceID = cursor.getInt(0);
                String Name = cursor.getString(1);
                String Email = cursor.getString(2);
                String Company = cursor.getString(3);
                String ItemView = cursor.getString(4);
                String Description = cursor.getString(5);
                String Price = cursor.getString(6);
                String Qty = cursor.getString(7);
                String Subtotal = cursor.getString(8);
                String Taxamount = cursor.getString(9);
                String Total = cursor.getString(10);
                String PaymentDate = cursor.getString(11);
                String Discount = cursor.getString(12);
                String AmountPaid = cursor.getString(13);
                String Remark = cursor.getString(14);



                invoicemodel newInvoicemodel = new invoicemodel(InvoiceID, Name, Email, Company, ItemView, Description, Price, Qty, Subtotal, Taxamount, Total, PaymentDate, Discount, AmountPaid, Remark);
                invoicereturnlist.add(newInvoicemodel);
            } while (cursor.moveToNext());

        } else {
            //failure do not add anything
        }

        cursor.close();
        idb.close();
        return invoicereturnlist;

    }*/






}
