package com.io.utkarsh.cityguide.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.io.utkarsh.cityguide.R;

import java.util.ArrayList;

/**
 * Created by NEXTGN001 on 03/04/2018.
 */

public class NnearByPlacesAdapter extends BaseAdapter {
    ArrayList<String> places;
    ArrayList<Integer> placesIcon;
    Activity activity;
    LayoutInflater layoutInflater;
    View PlaceView;
    public NnearByPlacesAdapter(Activity activity, ArrayList<String> places, ArrayList<Integer> placesIcon) {
        this.activity = activity;
        this.places = places;
        this.placesIcon = placesIcon;
        layoutInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int i) {
        return places.size();
    }

    @Override
    public long getItemId(int i) {
        return places.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
       PlaceView = layoutInflater.inflate(R.layout.near_by_places,null);
       holder.placeName = (TextView)PlaceView.findViewById(R.id.place_name);
       holder.placeImage = (ImageView)PlaceView.findViewById(R.id.place_image);
       holder.placeName.setText(places.get(i));
       holder.placeImage.setImageResource(placesIcon.get(i));
        return PlaceView;
    }
    public class Holder {
        public TextView placeName;
        public ImageView placeImage;
    }
}
