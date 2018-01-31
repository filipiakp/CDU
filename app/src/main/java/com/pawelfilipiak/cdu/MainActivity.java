package com.pawelfilipiak.cdu;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;

    private String[] images = {
        "https://cdn.pixabay.com/photo/2016/03/28/12/35/cat-1285634_960_720.png",
        "https://cdn.pixabay.com/photo/2017/01/06/19/15/soap-bubble-1958650_960_720.jpg"
    };

    //https://www.youtube.com/watch?v=SX8l9vv-N_4
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(MainActivity.this,images);
        viewPager.setAdapter(adapter);
    }
}
