package com.hybird.navbarwithhamburger;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavigationView objectNavigationView;
    private DrawerLayout objectDrawerLayout;

    private Toolbar objectToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectJAVAToXML();
    }

    private void connectJAVAToXML()
    {
        try
        {
            objectNavigationView=findViewById(R.id.navigationView);
            objectDrawerLayout=findViewById(R.id.drawerLayout);

            objectToolbar=findViewById(R.id.toolBar);
            objectNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if(item.getItemId()==R.id.item_home)
                    {
                        Toast.makeText(MainActivity.this, "Home is clicked", Toast.LENGTH_SHORT).show();
                        closeMyDrawer();
                        return true;
                    }
                    else if(item.getItemId()==R.id.item_favorite)
                    {
                        Toast.makeText(MainActivity.this, "Favorite is clicked", Toast.LENGTH_SHORT).show();
                        closeMyDrawer();
                        return true;
                    }
                    return false;
                }
            });

            setUpHamBurgerIcon();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "connectJAVAToXML:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void closeMyDrawer()
    {
        objectDrawerLayout.closeDrawer(GravityCompat.START);
    }

    private void setUpHamBurgerIcon()
    {
        try
        {
            //Step 1 you will create object of ACTION BAR DRAWER TOGGLE
            //with 5 parameters
            ActionBarDrawerToggle objectActionBarDrawerToggle=
                    new ActionBarDrawerToggle(
                            this,
                            objectDrawerLayout,
                            objectToolbar,
                            R.string.open,
                            R.string.close
                    );

            //Step 2: set color for ham burger icon
            objectActionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorWhite));

            //Step 3:
            objectActionBarDrawerToggle.syncState();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "setUpHamBurgerIcon:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
