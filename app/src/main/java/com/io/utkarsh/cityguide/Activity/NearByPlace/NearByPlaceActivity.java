package com.io.utkarsh.cityguide.Activity.NearByPlace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.io.utkarsh.cityguide.Activity.Home.MainActivity;
import com.io.utkarsh.cityguide.Adapter.NnearByPlacesAdapter;
import com.io.utkarsh.cityguide.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Utkarsh on 23/12/2018.
 */

public class NearByPlaceActivity extends AppCompatActivity {
    Activity activity;
    ArrayList<String> places;
    ArrayList<Integer> placesIcon;
    GridView placeView;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_temple);
        init();
        StartWorking();
    }

    private void StartWorking() {
        addPlacesName();
        addPlacesIcon();
        setLayoutToGridView();
    }

    private void setLayoutToGridView() {
        NnearByPlacesAdapter nearbyplacesadapter = new NnearByPlacesAdapter(activity,places,placesIcon);
        placeView.setAdapter(nearbyplacesadapter);
    }

    private void addPlacesIcon() {
        places.add("Airport");
        places.add("Atm");
        places.add("Bank");
        places.add("Bar");
        places.add("Church");
        places.add("Grocery Store");
        places.add("Gym");
        places.add("Hospital");
        places.add("Hotel");
        places.add("Medical Store");
        places.add("Mosque");
        places.add("Museum");
        places.add("Park");
        places.add("Parking");
        places.add("Petrol Pump");
        places.add("Police Station");
        places.add("Train Depot");
        places.add("Temple");
        places.add("Wine Shop");
        places.add("Resturant");
        places.add("Metro Station");
        places.add("College");
        places.add("School");
    }

    private void addPlacesName() {
        placesIcon.add(R.drawable.air_port);
        placesIcon.add(R.drawable.atm);
        placesIcon.add(R.drawable.bank);
        placesIcon.add(R.drawable.bear_bar);
        placesIcon.add(R.drawable.church);
        placesIcon.add(R.drawable.grocery_store);
        placesIcon.add(R.drawable.gym);
        placesIcon.add(R.drawable.hospital);
        placesIcon.add(R.drawable.hotel);
        placesIcon.add(R.drawable.medical_store);
        placesIcon.add(R.drawable.mosque);
        placesIcon.add(R.drawable.museum);
        placesIcon.add(R.drawable.park);
        placesIcon.add(R.drawable.parking);
        placesIcon.add(R.drawable.petrol_pump);
        placesIcon.add(R.drawable.police_station);
        placesIcon.add(R.drawable.railway);
        placesIcon.add(R.drawable.temple);
        placesIcon.add(R.drawable.wine_shop);
        placesIcon.add(R.drawable.hotel);
        placesIcon.add(R.drawable.railway);
        placesIcon.add(R.drawable.college);
        placesIcon.add(R.drawable.school);
    }

    private void init() {
        activity = NearByPlaceActivity.this;
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_close_toolbar_24dp);
        }
        tvTitle.setText("Search Near By Places");
        places = new ArrayList<String>();
        placesIcon = new ArrayList<Integer>();
        placeView = (GridView)findViewById(R.id.place);
        placeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Place = places.get(i);
                Intent intent = new Intent(NearByPlaceActivity.this,MainActivity.class);
                intent.putExtra("place",places);
                startActivity(intent);
                Toast.makeText(NearByPlaceActivity.this,Place,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
