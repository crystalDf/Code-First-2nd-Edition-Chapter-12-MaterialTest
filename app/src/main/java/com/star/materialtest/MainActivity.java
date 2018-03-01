package com.star.materialtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setCheckedItem(R.id.nav_call);
        mNavigationView.setNavigationItemSelectedListener(item -> {
            mDrawerLayout.closeDrawers();
            return true;
        });

        mFloatingActionButton = findViewById(R.id.floating_action_button);
        mFloatingActionButton.setOnClickListener(v ->
                Snackbar.make(v, "Data deleted", Snackbar.LENGTH_LONG)
                        .setAction("Undo", v1 ->
                                Toast.makeText(this, "Data restored",
                                        Toast.LENGTH_LONG).show())
                        .show()
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(this, "You clicked Backup",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "You clicked Delete",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings",
                        Toast.LENGTH_LONG).show();
                break;
            default:
        }

        return true;
    }
}
