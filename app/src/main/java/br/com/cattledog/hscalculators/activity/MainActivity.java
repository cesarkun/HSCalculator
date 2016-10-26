package br.com.cattledog.hscalculators.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;

import java.util.HashMap;

import br.com.cattledog.hscalculators.R;
import br.com.cattledog.hscalculators.fragment.AnyfinFragment;
import br.com.cattledog.hscalculators.fragment.FreezeFragment;
import br.com.cattledog.hscalculators.fragment.MillFragment;

/**
 * Created by Cesar A. dos Santos on 19/10/2016.
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final int FREEZE_FRAGMENT = 0;
    public static final int MILL_FRAGMENT = 1;
    public static final int ANYFIN_FRAGMENT = 2;
    public static final int TOTEM_FRAGMENT = 3;
    public static final int ROAR_FRAGMENT = 4;

    private HashMap<Integer, Fragment> hashFragment;
    private int currentFragmentIndex;
    private static final String CURRENT_FRAGMENT = "current_fragment_index_flag";
    private Toolbar toolbar;

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {
                View v = MainActivity.this.getCurrentFocus();
                if (v != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });


        hashFragment = new HashMap<>();

        hashFragment.put(FREEZE_FRAGMENT, new FreezeFragment());
        hashFragment.put(MILL_FRAGMENT, new MillFragment());
        hashFragment.put(ANYFIN_FRAGMENT, new AnyfinFragment());
        if(savedInstanceState != null){
            currentFragmentIndex = savedInstanceState.getInt(CURRENT_FRAGMENT);
            fragmentTransaction(currentFragmentIndex);
        } else {
            fragmentTransaction(FREEZE_FRAGMENT);
        }

    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        setToolBarTitle(currentFragmentIndex);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_freeze) {
            fragmentTransaction(FREEZE_FRAGMENT);
        } else if (id == R.id.nav_mill) {
            fragmentTransaction(MILL_FRAGMENT);
        } else if(id == R.id.nav_anyfin){
            fragmentTransaction(ANYFIN_FRAGMENT);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void fragmentTransaction(int id) {

        try {
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.container, hashFragment.get(id))
                    .commit();
            currentFragmentIndex = id;


            setToolBarTitle(id);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Em Desenvolvimento... :D", Toast.LENGTH_LONG).show();
        }
    }

    private void setToolBarTitle(int id){
        switch (id){
            case FREEZE_FRAGMENT:
                toolbar.setTitle(getString(R.string.menu_item_title1));
                break;
            case MILL_FRAGMENT:
                toolbar.setTitle(getString(R.string.menu_item_title2));
                break;
            case ANYFIN_FRAGMENT:
                toolbar.setTitle(getString(R.string.menu_item_title3));
                break;
            case TOTEM_FRAGMENT:
                toolbar.setTitle(getString(R.string.menu_item_title4));
                break;
            case ROAR_FRAGMENT:
                toolbar.setTitle(getString(R.string.menu_item_title5));
                break;
            default:
                toolbar.setTitle(getString(R.string.app_name));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(CURRENT_FRAGMENT, currentFragmentIndex);

    }
}
