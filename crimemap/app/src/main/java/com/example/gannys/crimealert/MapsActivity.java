//package com.example.gannys.crimealert;
//
//import android.graphics.Bitmap;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.drawable.Drawable;
//import android.support.annotation.DrawableRes;
//import android.support.v4.app.FragmentActivity;
//import android.os.Bundle;
//import android.support.v4.content.ContextCompat;
//import android.util.Log;
//import android.content.res.Resources;
//
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptor;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MapStyleOptions;
//import com.google.android.gms.maps.model.Marker;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.maps.model.Polygon;
//import com.google.android.gms.maps.model.PolygonOptions;
//
//import android.content.Context;
//
//import java.util.Map;
//
//import static com.example.gannys.crimealert.R.mipmap.faceicon;
//
//public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
//
//    private GoogleMap mMap;
//
//    private static final String TAG = MapsActivity.class.getSimpleName();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_maps);
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//    }
//
//
//
//    private BitmapDescriptor bitmapDescriptorFromVector(Context context, @DrawableRes int vectorDrawableResourceId) {
//        Drawable background = ContextCompat.getDrawable(context, vectorDrawableResourceId);
//        background.setBounds(0, 0, background.getIntrinsicWidth(), background.getIntrinsicHeight());
//        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorDrawableResourceId);
//        vectorDrawable.setBounds(40, 20, vectorDrawable.getIntrinsicWidth() + 40, vectorDrawable.getIntrinsicHeight() + 20);
//        Bitmap bitmap = Bitmap.createBitmap(background.getIntrinsicWidth(), background.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        background.draw(canvas);
//        vectorDrawable.draw(canvas);
//        return BitmapDescriptorFactory.fromBitmap(bitmap);
//    }
//
//
//    /**
//     * Manipulates the map once available.
//     * This callback is triggered when the map is ready to be used.
//     * This is where we can add markers or lines, add listeners or move the camera. In this case,
//     * we just add a marker near Sydney, Australia.
//     * If Google Play services is not installed on the device, the user will be prompted to install
//     * it inside the SupportMapFragment. This method will only be triggered once the user has
//     * installed Google Play services and returned to the app.
//     */
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        try {
//            // Customise the styling of the base map using a JSON object defined
//            // in a raw resource file.
//            boolean success = googleMap.setMapStyle(
//                    MapStyleOptions.loadRawResourceStyle(
//                            this, R.raw.mapstyle));
//
//            if (!success) {
//                Log.e(TAG, "Style parsing failed.");
//            }
//        } catch (Resources.NotFoundException e) {
//            Log.e(TAG, "Can't find style. Error: ", e);
//        }
//
//        mMap = googleMap;
//
//        LatLng USC = new LatLng(34.0283057, -118.2869446);
//
//        mMap.addMarker(new MarkerOptions()
//                        .position(USC)
//                        .title("Near USC")
////                        .icon(bitmapDescriptorFromVector(this, R.drawable.smile_face))
//                );
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(USC));
//
//
//        Polygon p1 = mMap.addPolygon(new PolygonOptions()
//                .add(new LatLng(34.0287574, -118.2893644)
//                        , new LatLng(34.0293860, -118.2840201)
//                        , new LatLng(34.0283099, -118.2847591)
//                    )
//                .strokeColor(Color.RED)
//                .strokeWidth(2)
//                .fillColor(Color.argb(128, 239, 208, 136)))
//        ;
//
//        Polygon p2 = mMap.addPolygon(new PolygonOptions()
//                .add(new LatLng(34.0283865, -118.2914706)
//                        , new LatLng(34.0283979, -118.2902140)
//                        , new LatLng(34.0274451, -118.2901517)
//                        , new LatLng(34.0274384, -118.2914981)
//                    )
//                .strokeColor(Color.RED)
//                .strokeWidth(2)
//                .fillColor(Color.argb(128, 239, 208, 136)))
//        ;
////        googleMap.pol
//
//
//        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
//
//
//    }
//}
package com.example.gannys.crimealert;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.CountDownTimer;
import android.support.annotation.DrawableRes;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
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
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import android.content.Context;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import static com.example.gannys.crimealert.MyNotificationManager.createNotificationChannel;
import static com.example.gannys.crimealert.R.mipmap.faceicon;
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private static final String TAG = MapsActivity.class.getSimpleName();
    private Location location;
    private ArrayList<ArrayList<LatLng>> crimeZones = new ArrayList<>();
    private boolean wasInCrimeZone = false;
    private FireBaseDB database;

    MyNotificationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        createNotificationChannel(notificationManager);
        nm = new MyNotificationManager();
        nm.setNotificationBuilder(new NotificationCompat.Builder(this, "channel"));
        refresh();

        // initialize FireBaseDB
        database = new FireBaseDB();
    }
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, @DrawableRes int vectorDrawableResourceId) {
        Drawable background = ContextCompat.getDrawable(context, vectorDrawableResourceId);
        background.setBounds(0, 0, background.getIntrinsicWidth(), background.getIntrinsicHeight());
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorDrawableResourceId);
        vectorDrawable.setBounds(40, 20, vectorDrawable.getIntrinsicWidth() + 40, vectorDrawable.getIntrinsicHeight() + 20);
        Bitmap bitmap = Bitmap.createBitmap(background.getIntrinsicWidth(), background.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        background.draw(canvas);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
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
        LatLng USC = new LatLng(34.0283057, -118.2869446);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(USC));
        try{
            mMap.setMyLocationEnabled(true);
        }catch(SecurityException e){
        }
        ArrayList<LatLng> vertices1 = new ArrayList<>();
        vertices1.add(new LatLng(34.0284074, -118.2893644));
        vertices1.add(new LatLng(34.0293860, -118.2840201));
        vertices1.add(new LatLng(34.0283099, -118.2840201));
        Polygon p1 = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(34.0284574, -118.2893644)
                        , new LatLng(34.0293860, -118.2840201)
                        , new LatLng(34.0284574, -118.2840201)
                )
                .strokeColor(Color.RED)
                .strokeWidth(2)
                .fillColor(Color.argb(128, 239, 208, 136)));
        crimeZones.add(vertices1);
        ArrayList<LatLng> vertices2 = new ArrayList<>();
        vertices2.add(new LatLng(34.0283865, -118.2914706));
        vertices2.add(new LatLng(34.0283979, -118.2902140));
        vertices2.add(new LatLng(34.0274451, -118.2902140));
        vertices2.add(new LatLng(34.0274384, -118.2914706));
        Polygon p2 = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(34.0283865, -118.2914706)
                        , new LatLng(34.0283979, -118.2902140)
                        , new LatLng(34.0274451, -118.2902140)
                        , new LatLng(34.0274384, -118.2914706)
                )
                .strokeColor(Color.RED)
                .strokeWidth(2)
                .fillColor(Color.argb(128, 239, 208, 136)))
                ;
        crimeZones.add(vertices2);
        ArrayList<LatLng> vertices3 = new ArrayList<>();
        vertices3.add(new LatLng(34.0253, -118.295));
        vertices3.add(new LatLng(34.0253, -118.2919));
        vertices3.add(new LatLng(34.0185, -118.295));
        vertices3.add(new LatLng(34.0185, -118.2919));
        Polygon p3 = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(34.0253, -118.295),
                        new LatLng(34.0253, -118.2919),
                        new LatLng(34.0185, -118.2919),
                        new LatLng(34.0185, -118.295))
                .strokeColor(Color.RED)
                .strokeWidth(2)
                .fillColor(Color.argb(128,239,208,136))
        );
        crimeZones.add(vertices3);
//    googleMap.pol
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
    }
    private Location getDeviceLocation() {
        return mMap.getMyLocation();
    }
    public void refresh(){
        new CountDownTimer(3600000, 5000){
            public void onTick(long millisUntilFinished){
                location = getDeviceLocation();
                if(location != null){
                    LatLng coords = new LatLng(location.getLatitude(),location.getLongitude());

                    boolean inCrimeZone = false;
                    for (ArrayList<LatLng> polygon : crimeZones) {
                        if (isPointInPolygon(coords, polygon)) {
                            //entered crime zone
                            Log.d(TAG, "In crime zone");
                            inCrimeZone = true;
                        }
                    }
                    if(!inCrimeZone){
                        //not in crime zone
                        Log.d(TAG, "not in crime zone");
                    }
                    if(wasInCrimeZone && !inCrimeZone){
                        //send notification exited
                        nm.sendNotification("Exited");
                        wasInCrimeZone = false;
                    }else if(!wasInCrimeZone && inCrimeZone) {
                        nm.sendNotification("Entered");
                        wasInCrimeZone = true;
                    }
                    database.updateLoc(location.getLatitude(), location.getLongitude());
                }
            }
            public void onFinish(){
            }
        }.start();
    }
    private boolean isPointInPolygon(LatLng pt, ArrayList<LatLng> vertices) {
        int intersectCount = 0;
        for (int j = 0; j < vertices.size() - 1; j++) {
            if (rayCastIntersect(pt, vertices.get(j), vertices.get(j + 1))) {
                intersectCount++;
            }
        }
        return ((intersectCount % 2) == 1); // odd = inside, even = outside;
    }
    private boolean rayCastIntersect(LatLng tap, LatLng vertA, LatLng vertB) {
        double aY = vertA.latitude;
        double bY = vertB.latitude;
        double aX = vertA.longitude;
        double bX = vertB.longitude;
        double pY = tap.latitude;
        double pX = tap.longitude;
        if ((aY > pY && bY > pY) || (aY < pY && bY < pY)
                || (aX < pX && bX < pX)) {
            return false; // a and b can't both be above or below pt.y, and a or
            // b must be east of pt.x
        }
        double m = (aY - bY) / (aX - bX); // Rise over run
        double bee = (-aX) * m + aY; // y = mx + b
        double x = (pY - bee) / m; // algebra is neat!
        return x > pX;
    }
}