package com.example.invoicegenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    //variables

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ListView lv_main;
    DatabaseHelper databaseHelper;
    ArrayList<invoicemodel> arrayList;
    invoiceadaptor INVOICEADAPTER;
    ArrayList<invoicemodel> newarrayList;

   // DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  db = new DBHelper(this);




        //---------------------hooks---------------------
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        lv_main = findViewById(R.id.listviewmain);
        databaseHelper = new DatabaseHelper(this);
        arrayList = new ArrayList<>();


        //--------------------toolbar--------------------
        setSupportActionBar(toolbar);



        //--------------------navigation drawer menu---------------------

        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_listofinvoice);

        //-----------------------------------------------------------------
        loadDataInListView();


    }


    private void loadDataInListView()
    {
        arrayList= databaseHelper.getAllData();
        INVOICEADAPTER = new invoiceadaptor(this,arrayList);
        lv_main.setAdapter(INVOICEADAPTER);
        INVOICEADAPTER.notifyDataSetChanged();
        newarrayList= databaseHelper.getAllData();
        //INVOICEADAPTER.

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected (@NonNull MenuItem menuItem) {

         switch (menuItem.getItemId()){

             case R.id.nav_listofinvoice:
                 Intent intent6 = new Intent(MainActivity.this, MainActivity.class);
                 startActivity(intent6);


                 break;
             case R.id.nav_addcustomer:
                 Intent intent  = new Intent(MainActivity.this, CustomerActivity.class);
                 startActivity(intent);
                 break;
             case R.id.nav_createinvoice:
                 Intent intent1 = new Intent(MainActivity.this, AddinvoiceActivity.class);
                 startActivity(intent1);
                 break;

             case R.id.nav_logout:
                 Intent intent2 = new Intent(MainActivity.this, LoginActivity.class);
                 startActivity(intent2);
                 break;

             case R.id.nav_customer:
                 Intent intent3 = new Intent(MainActivity.this, ShowcustomerActivity.class);
                 startActivity(intent3);
                 break;





        }
         drawerLayout.closeDrawer(GravityCompat.START);
        return true;




    }
}
