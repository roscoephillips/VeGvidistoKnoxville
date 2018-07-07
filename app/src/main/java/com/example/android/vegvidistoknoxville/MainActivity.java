package com.example.android.vegvidistoknoxville;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

/**
 * Sources:
 * I used these following links to assist with implementing a navigation drawer and fragmenting:
 * https://developer.android.com/training/implementing-navigation/nav-drawer
 * <p>
 * Was useful for learning how to use fragments
 * https://github.com/codepath/android_guides/wiki/Fragment-Navigation-Drawer
 */

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    public static final int NO_RESOURCE_PROVIDED = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction defaultFragment = getSupportFragmentManager().beginTransaction();
        defaultFragment.replace(R.id.content_frame, new RestaurantsFragment());
        defaultFragment.commit();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        toolbar = (Toolbar) findViewById(R.id.veg_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectDrawerItem(menuItem);
                return true;
            }
        });
    }

    private void selectDrawerItem(MenuItem menuItem) {
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.nav_restaurants:
                fragmentClass = RestaurantsFragment.class;
                break;
            case R.id.nav_food_trucks:
                fragmentClass = FoodTrucksFragment.class;
                break;
            case R.id.nav_resources:
                fragmentClass = ResourcesFragment.class;
                break;
            case R.id.nav_events:
                fragmentClass = EventsFragment.class;
                break;
            default:
                fragmentClass = RestaurantsFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Replaces the existing fragment.
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        //Highlights the current menu item.
        menuItem.setChecked(true);
        //Sets title of menu item.
        setTitle(menuItem.getTitle());
        //Close the nav drawer.
        drawerLayout.closeDrawers();

    }

    //Opens drawer.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
