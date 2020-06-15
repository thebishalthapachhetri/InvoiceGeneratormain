package com.example.invoicegenerator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.invoicegenerator.R;
import com.example.invoicegenerator.invoicemodel;

import java.util.ArrayList;

public class invoiceadaptor extends BaseAdapter {


    Context context;
    ArrayList<invoicemodel> arrayList;

    public invoiceadaptor(Context context, ArrayList<invoicemodel> arrayList)
    {
        this.context = context;
        this.arrayList= arrayList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custominvoiceview,null);
        TextView ivname = (TextView)convertView.findViewById(R.id.showcustomername);
        TextView ivemail = (TextView)convertView.findViewById(R.id.showcustomeremail);
        TextView ivcompany = (TextView)convertView.findViewById(R.id.showcompanyname);
        TextView ivitem = (TextView)convertView.findViewById(R.id.showcustomeritemname);
        TextView ivqty = (TextView)convertView.findViewById(R.id.showcustomerqty);
        TextView ivprice = (TextView)convertView.findViewById(R.id.showcustomerprice);
        TextView ivsubtotal = (TextView)convertView.findViewById(R.id.showcustomersubtotal);
        TextView ivdiscount = (TextView)convertView.findViewById(R.id.showcustomerdiscount);
        TextView ivtaxamount = (TextView)convertView.findViewById(R.id.showcustomertaxamount);
        TextView ivamountpaid = (TextView)convertView.findViewById(R.id.showcustomeramountpaid);
        TextView ivremark = (TextView)convertView.findViewById(R.id.showcustomerremark);

        invoicemodel iv = arrayList.get(position);

        ivname.setText(iv.getIname());
        ivemail.setText(iv.getIemail());
        ivcompany.setText(iv.getIcompany());
        ivitem.setText(iv.getIitemname());
        ivqty.setText(iv.getIqty());
        ivprice.setText(iv.getIprice());
        ivsubtotal.setText(iv.getIsubtotal());
        ivdiscount.setText(iv.getIdiscount());
        ivtaxamount.setText(iv.getItaxamount());
        ivamountpaid.setText(iv.getIamountpaid());
        ivremark.setText(iv.getIremark());


        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}
