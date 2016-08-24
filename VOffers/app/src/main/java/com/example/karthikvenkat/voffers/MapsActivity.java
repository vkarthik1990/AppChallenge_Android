package com.example.karthikvenkat.voffers;

import android.content.Intent;
import android.hardware.Camera;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }



    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(1.3189573, 103.89453479999997)).title("Collect your 5$ visa offers here"));
        mMap.setMyLocationEnabled(true);
        mMap.setBuildingsEnabled(true);
        // Construct a CameraPosition focusing on Mountain View and animate the camera to that position.
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(1.3189573, 103.89453479999997))      // Sets the center of the map to Mountain View
                .zoom(17)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        onMapReady(mMap);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng Payalebar = new LatLng(1.3189573, 103.89453479999997);
        LatLng Payalebar_2 = new LatLng(1.318106300402714, 103.89280065894127);
        LatLng Payalebar_3 = new LatLng(1.3188953, 103.89257229999998);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Payalebar, 13));

        map.addMarker(new MarkerOptions()
                .title("Payalebar")
                .snippet("Collect your 5$ visa offers here")
                .position(Payalebar));

        map.addMarker(new MarkerOptions()
                .title("Payalebar")
                .snippet("Collect your 10$ visa offers here")
                .position(Payalebar_2));
        map.addMarker(new MarkerOptions()
                .title("Payalebar")
                .snippet("Collect your 2$ visa offers here")
                .position(Payalebar_3));
        map.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener)this);
    }




        @Override
        public boolean onMarkerClick (Marker marker){
            //Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(new Intent("com.Voffers.ARcard.UnityPlayerNativeActivity"));
            //startActivityForResult(intent, 0);
            return false;
        }

    /*private boolean safeCameraOpen(int id) {
        boolean qOpened = false;
        Camera mCamera;

        try {
            mCamera = Camera.open(id);
            qOpened = (mCamera != null);
        } catch (Exception e) {
            Log.e(getString(R.string.app_name), "Failed to open Camera");
            e.printStackTrace();
        }

        return qOpened;
    }*/
}


