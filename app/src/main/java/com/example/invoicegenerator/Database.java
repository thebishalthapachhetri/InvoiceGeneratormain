package com.example.invoicegenerator;

public class Database {
    public static final String DATABASE_NAME = "Invoice Generator";
    public static final int DATABASE_VERSION = 1;

    public static final String C_TABLE_NAME = "CUSTOMER_DETAILS";
    public static final String C_ID = "id";
    public static final String C_NAME = "name";
    public static final String C_EMAIL = "email";
    public static final String C_COMPANYNAME = "companyname";


    public static final String I_TABLE_NAME = "INVOICE";
    public static final String I_INVOICE_NO = "invoice_no";//Auto Increment
    public static final String I_NAME = "name";
    public static final String I_EMAIL = "email";
    public static final String I_COMPANYNAME = "companyname";
    public static final String I_ITEM_NAME = "item_name";
    public static final String I_DESCRIPTION = "description";
    public static final String I_PRICE = "price";
    public static final String I_QTY = "qty";
    public static final String I_SUBTOTAL = "subtotal";
    public static final String I_TAX_AMOUNT = "tax_amount";
    public static final String I_TOTAL = "total";
    public static final String I_PAYMENT_DATE = "payment_date";
    public static final String I_DISCOUNT = "discount";
    public static final String I_AMOUNT_PAID = "amount_paid";
    public static final String I_REMARK = "remark";
    public static final String I_C_ID = "c_id";




    public static final String U_TABLE_NAME = "USER";
    public static final String U_FULL_NAME = "full_name";
    public static final String U_EMAIL = "u_email";
    public static final String U_PASSWORD = "password";
    public static final String U_CONFIRM_PASSWORD = "confirm_password";
    public static final String U_COMPANY = "company";
    public static final String U_COUNTRY = "country";






}