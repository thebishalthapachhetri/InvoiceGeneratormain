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
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    //Button  txt
    //variables

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //---------------------hooks---------------------
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);


        //--------------------toolbar--------------------
        setSupportActionBar(toolbar);


        //--------------------navigation drawer menu---------------------

        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_listofinvoice);


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
                 break;
             case R.id.nav_addcustomer:
                 Intent intent  = new Intent(MainActivity.this, CustomerActivity.class);
                 startActivity(intent);
                 break;
             case R.id.nav_createinvoice:
                 Intent intent1 = new Intent(MainActivity.this, AddinvoiceActivity.class);
                 startActivity(intent1);
                 break;





        }
         drawerLayout.closeDrawer(GravityCompat.START);
        return true;




    }
}
