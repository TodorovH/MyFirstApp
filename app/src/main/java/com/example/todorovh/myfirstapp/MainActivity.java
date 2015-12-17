package com.example.todorovh.myfirstapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private Toolbar toolbar;
    private ImageButton falseDrawerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        falseDrawerButton = (ImageButton) findViewById(R.id.false_drawer_button);
        final Animation animRotateClockWise = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise);
        final Animation animRotateClockWiseRev = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise_reverse);

        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById( R.id.drawer_layout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.drawer_opened,
                R.string.drawer_closed
        ){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle( R.string.drawer_opened );
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle( R.string.drawer_closed );
            }
        };

        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        falseDrawerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    mDrawerLayout.closeDrawer(Gravity.RIGHT);
                    v.startAnimation(animRotateClockWise);
                } else {
                    mDrawerLayout.openDrawer(Gravity.RIGHT);
                    v.startAnimation(animRotateClockWiseRev);
                }
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mActionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}