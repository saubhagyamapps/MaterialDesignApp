package com.example.android.materialdesignapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RelativeLayout;

public class ScrollingActivity extends AppCompatActivity {
    private static final String TAG = "ScrollingActivity";
    CollapsingToolbarLayout collapsingToolbar;
    DrawerLayout drawerLayout;
    RecyclerView pastorder_recycler;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);


        pastorder_recycler = findViewById(R.id.rd);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pastorder_recycler.setLayoutManager(layoutManager);
        PastOrdersAdapter pastOrdersAdapter = new PastOrdersAdapter(getApplicationContext());
        pastorder_recycler.setAdapter(pastOrdersAdapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {


                Log.e(TAG, "onOffsetChanged: ");
                if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0) {
                    Log.e(TAG, "onOffsetChanged:2");
                    relativeLayout.post(new Runnable() {
                        @Override
                        public void run() {
                            final DrawerLayout.LayoutParams layoutparams = (DrawerLayout.LayoutParams) relativeLayout.getLayoutParams();
                            layoutparams.setMargins(0, 0, 0, 0);
                            relativeLayout.setLayoutParams(layoutparams);
                            collapsingToolbar.setTitle("Mcdonalds");
                        }
                    });

                } else {
                    relativeLayout.post(new Runnable() {
                        @Override
                        public void run() {
                            final DrawerLayout.LayoutParams layoutparams = (DrawerLayout.LayoutParams) relativeLayout.getLayoutParams();
                            layoutparams.setMargins(0, 210, 0, 0);
                            relativeLayout.setLayoutParams(layoutparams);
                            collapsingToolbar.setTitle(" ");
                        }
                    });


                    Log.e(TAG, "onOffsetChanged:3");
                }
            }
        });

    }
}
