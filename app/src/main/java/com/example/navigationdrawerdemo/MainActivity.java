package com.example.navigationdrawerdemo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayoutEss;
    NavigationView navigationViewEss;

    Toolbar toolbarEss;

    ActionBarDrawerToggle toggleEss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // ess version

        drawerLayoutEss = findViewById(R.id.drawer_layout_ess);

        navigationViewEss = findViewById(R.id.navigationViewEss);

        toolbarEss = findViewById(R.id.toolbarEss);

        setSupportActionBar(toolbarEss);

        toggleEss = new ActionBarDrawerToggle(
                this,
                drawerLayoutEss,
                toolbarEss,
                R.string.open,
                R.string.close
        );

        drawerLayoutEss.addDrawerListener(toggleEss);

        toggleEss.syncState();

        navigationViewEss.setNavigationItemSelectedListener(this);

        // Fragment par défaut

        getSupportFragmentManager()
                .beginTransaction()
                .replace(
                        R.id.frameContainerEss,
                        new HomeSectionFragment()
                )
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment currentFragment = null;

        int selectedId = item.getItemId();

        if (selectedId == R.id.menu_home) {

            currentFragment = new HomeSectionFragment();

        } else if (selectedId == R.id.menu_profile) {

            currentFragment = new ProfileSectionFragment();

        } else if (selectedId == R.id.menu_data) {

            currentFragment = new DataListFragmentEss();
        }

        if (currentFragment != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.frameContainerEss,
                            currentFragment
                    )
                    .commit();
        }

        drawerLayoutEss.closeDrawer(GravityCompat.START);

        return true;
    }
}