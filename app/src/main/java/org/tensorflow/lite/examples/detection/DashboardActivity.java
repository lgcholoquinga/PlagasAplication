package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import org.tensorflow.lite.examples.detection.fragments.ControlPlagasFragment;
import org.tensorflow.lite.examples.detection.fragments.HomeFragment;
import org.tensorflow.lite.examples.detection.fragments.InformacionFragment;
import org.tensorflow.lite.examples.detection.fragments.ProcesoDiagnosticoFragment;
import org.tensorflow.lite.examples.detection.interfaces.IComunicaFragments;

public class DashboardActivity extends AppCompatActivity implements IComunicaFragments,  NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        //barra de app
        mDrawerlayout = (DrawerLayout) findViewById(R.id.mydrawer);
        mToggle = new ActionBarDrawerToggle(DashboardActivity.this,mDrawerlayout,toolbar,R.string.open,R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        //iniciando el navigation view
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //fragment por default
        navigationView.setCheckedItem(R.id.navhome);
        Fragment fragment = new HomeFragment();
        displaySelectedFragment(fragment);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerlayout.isDrawerOpen(GravityCompat.START))
        {
            mDrawerlayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();
        Fragment fragment = null;
        if(id==R.id.navhome)
        {
            fragment = new HomeFragment();
            displaySelectedFragment(fragment);
        }
        else if (id == R.id.navinformacion)
        {
            fragment = new InformacionFragment();
            displaySelectedFragment(fragment);
        }
        else if(id == R.id.navtratamiento)
        {
            fragment = new ControlPlagasFragment();
            displaySelectedFragment(fragment);
        }
        else  if (id == R.id.navdiagnostico)
        {
            Intent intent = new Intent(DashboardActivity.this,DetectorActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.navproceso)
        {
            fragment = new ProcesoDiagnosticoFragment();
            displaySelectedFragment(fragment);
        }
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.mydrawer);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void displaySelectedFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerfragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void ciclominador() {
        Intent pm=new Intent(this,CicloVidaMinador.class);
        startActivity(pm);
    }

    @Override
    public void ciclopm() {
        Intent pm=new Intent(this,CicloVidapm.class);
        startActivity(pm);
    }
}
