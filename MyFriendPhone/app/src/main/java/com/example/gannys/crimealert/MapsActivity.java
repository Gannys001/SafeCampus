package com.example.gannys.crimealert;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.annotation.DrawableRes;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.content.res.Resources;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Context;
import android.widget.Toast;

import java.util.Map;

import static com.example.gannys.crimealert.R.mipmap.faceicon;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final String TAG = MapsActivity.class.getSimpleName();


    private DatabaseReference mPostReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.mapstyle));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }

        mMap = googleMap;

//        LatLng iniLoc = new LatLng(34.0283057, -118.2869446);

        updateMap(34.0283057, -118.2869446);


        Polygon p1 = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(34.0287574, -118.2893644)
                        , new LatLng(34.0293860, -118.2840201)
                        , new LatLng(34.0283099, -118.2847591)
                    )
                .strokeColor(Color.RED)
                .strokeWidth(2)
                .fillColor(Color.argb(128, 239, 208, 136)))
        ;

        Polygon p2 = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(34.0283865, -118.2914706)
                        , new LatLng(34.0283979, -118.2902140)
                        , new LatLng(34.0274451, -118.2901517)
                        , new LatLng(34.0274384, -118.2914981)
                    )
                .strokeColor(Color.RED)
                .strokeWidth(2)
                .fillColor(Color.argb(128, 239, 208, 136)))
        ;

        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
//        testUpdate();

    }

    @Override
    protected void onStart() {
        super.onStart();


        // Get post key from intent
        String mPostKey = "-LXkFxiBD9HG_ph0SWZt";

        // Initialize Database
        mPostReference = FirebaseDatabase.getInstance().getReference().child("CrimeAlert").child(mPostKey);

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                LocationInfo loc = dataSnapshot.getValue(LocationInfo.class);
                updateMap(loc.latitude, loc.longitude);
                Log.e("value changed --- ", loc.latitude + " --- " + loc.longitude);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // [START_EXCLUDE]
                Toast.makeText(MapsActivity.this, "Failed to load post.",
                        Toast.LENGTH_SHORT).show();
                // [END_EXCLUDE]
            }
        };
        mPostReference.addValueEventListener(postListener);

    }

    public void testUpdate(){
        new CountDownTimer(3000000, 1000){
            double x = 34.0283057, y = -118.2869446;
            @Override
            public void onTick(long millisUntilFinished) {
                updateMap(x, y);
                x += 0.0001;
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }

    public void updateMap(double lat, double lng){
        LatLng ll = new LatLng(lat, lng);
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(ll));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));

        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
    }

}
