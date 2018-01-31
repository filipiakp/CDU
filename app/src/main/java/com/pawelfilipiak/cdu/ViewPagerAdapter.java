package com.pawelfilipiak.cdu;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Pawel on 31-01-2018.
 */

public class ViewPagerAdapter extends PagerAdapter {

    Activity activity;
    ArrayList<String> images;
    LayoutInflater inflater;

    public ViewPagerAdapter(Activity activity, ArrayList<String> images){
        this.activity = activity;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    ViewGroup container;
    public Object instantiateItem(View container, int position) {
        inflater = (LayoutInflater)container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.view_pager_item,container, false);

        ImageView image;
        image = (ImageView)itemView.findViewById(R.id.slide);

        try{
            Picasso.with(activity.getApplicationContext())
                    .load(images.get(position))
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(image);
        }catch (Exception ex){
            System.err.println("No kurde nie dziala");
        }
        this.container = container;
        container.addView(itemView);
        return itemView;
    }
}
