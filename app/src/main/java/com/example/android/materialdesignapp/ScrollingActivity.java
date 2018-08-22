package com.example.android.materialdesignapp;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ScrollingActivity extends AppCompatActivity {
    private static final String TAG = "ScrollingActivity";
    CollapsingToolbarLayout collapsingToolbar;
    TextView txtName;
    CardView card_view;
    View view;
    FloatingActionButton fab;
    AppBarLayout linearLayout;
    CircleImageView profile_image;
    HorizontalScrollView scrollView;
    LinearLayout layout;
    Toolbar toolbar3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        card_view = (CardView) findViewById(R.id.toolbar3);
        layout = (LinearLayout) findViewById(R.id.linearLayout);
        setSupportActionBar(toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        scrollView = (HorizontalScrollView) findViewById(R.id.horizontalScroll1);

        RecyclerView pastorder_recycler = findViewById(R.id.rd);
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


                    card_view.post(new Runnable() {
                        @Override
                        public void run() {
                            collapsingToolbar.setTitle("Mcdonalds");
                            card_view.setVisibility(View.GONE);
                        }
                    });
                } else {

                    card_view.post(new Runnable() {
                        @Override
                        public void run() {
                            card_view.setVisibility(View.VISIBLE);
                            collapsingToolbar.setTitle(" ");

                        }
                    });

                    Log.e(TAG, "onOffsetChanged:3");
                }
            }
        });

    }
}
