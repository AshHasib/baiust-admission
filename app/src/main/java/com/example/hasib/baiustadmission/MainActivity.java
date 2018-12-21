package com.example.hasib.baiustadmission;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;
    NavigationView navigationView;
    private DrawerLayout mDrawerLayout;
    private CardView admin,admission,cardGallery,departments,cardClubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * NavigationDrawer codes
         * */
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
        navigationView=findViewById(R.id.nav_view);



        /**
         * Listeners to navigation drawer items will be set here!
         * */
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        if(menuItem.getItemId()==R.id.visitSite){
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baiust.edu.bd"));
                            startActivity(browserIntent);
                        }

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });




        /**
         * Toolbar As ActionBar
         * */
        toolbar=findViewById(R.id.dashToolBar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        actionBar=getSupportActionBar();
        actionBar.setTitle("Dashboard");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);





        /**
         * Setting CardView OnClickListeners
         * */
        admin=findViewById(R.id.admin);
        admin.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,AdminActivity.class));
        });

        admission=findViewById(R.id.admission);
        admission.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,Admission.class));
        });

        cardGallery=findViewById(R.id.gallery);
        cardGallery.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,GalleryActivity.class));
        });

        departments=findViewById(R.id.cardDepartments);
        departments.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,Departments.class));
        });

        cardClubs=findViewById(R.id.cardClubs);
        cardClubs.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,ClubActivity.class));
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_contacts_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:{
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
