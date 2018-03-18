package com.pawelfilipiak.cdu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;

    ViewPager viewPager2;
    ViewPagerAdapter adapter2;

    private ArrayList<String> images = new ArrayList<>();
    private ArrayList<String> images2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add images from database
        images.add("https://cdn.pixabay.com/photo/2016/03/28/12/35/cat-1285634_960_720.png");
        //images2 = images;
        images2.add("https://cdn.pixabay.com/photo/2016/03/28/12/35/cat-1285634_960_720.png");


        viewPager = (ViewPager)findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(adapter);

        viewPager2 = (ViewPager)findViewById(R.id.viewPager2);
        adapter2 = new ViewPagerAdapter(MainActivity.this,images2);
        viewPager2.setAdapter(adapter2);
    }

    public void dodajGore(View view){

        //images.add("https://www.w3schools.com/w3css/img_fjords.jpg");
        //adapter.notifyDataSetChanged();

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".
        intent.setType("image/*");
        int a =42;
        startActivityForResult(intent, a );

    }

    public void dodajDol(View view){
        //images2.add("https://www.w3schools.com/w3css/img_fjords.jpg");
        //adapter2.notifyDataSetChanged();

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        int a =40;
        startActivityForResult(intent, a );
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == 42 && resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                images.add(uri.toString());
                adapter.notifyDataSetChanged();
            }
        }

        if (requestCode == 40 && resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                images2.add(uri.toString());
                adapter2.notifyDataSetChanged();
            }
        }
    }
}
