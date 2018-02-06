package com.pawelfilipiak.cdu;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;

    ViewPager viewPager2;
    ViewPagerAdapter adapter2;

    private ArrayList<String> images = new ArrayList<String>();
    private ArrayList<String> images2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add images from database
        images.add("https://cdn.pixabay.com/photo/2016/03/28/12/35/cat-1285634_960_720.png");
        images.add("https://cdn.pixabay.com/photo/2017/01/06/19/15/soap-bubble-1958650_960_720.jpg");
        images2 = images;

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setOnPageChangeListener();
        adapter = new ViewPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(adapter);

        viewPager2 = (ViewPager)findViewById(R.id.viewPager2);
        adapter2 = new ViewPagerAdapter(MainActivity.this,images);
        viewPager2.setAdapter(adapter2);
    }

    public void dodajGore(View view){
        adapter.notifyDataSetChanged();
        images.add("https://www.w3schools.com/w3css/img_fjords.jpg");

        adapter = new ViewPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(adapter);

    }

    public void dodajDol(View view){

    }
}
