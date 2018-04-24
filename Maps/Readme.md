***So in this tutorial you will learn to integrate Google Maps in your app. This is just a simple demo of the app.***

**This will be your Strings.xml :**

    <resources>
        <string name="app_name">Maps</string>
        <string name="title_activity_maps">Map</string>
         <!--Please put your api key instead of using this..-->
        <string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">AIzaSyBkB35JpamrPRWWUuaHR7Miv5uCFfwPefU</string>
    </resources>
    
**Create a ' activity_maps ' layout file in res -> layout -> activity_maps.xml :**

    <fragment
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/map"
        android:name="com.google.android.gms.maps.SupportMapFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MapsActivity" />
        
**And now create MapsActivity.java file in your package :**

    package maps.developer.aero;

    import android.support.v4.app.FragmentActivity;
    import android.os.Bundle;

    import com.google.android.gms.maps.CameraUpdateFactory;
    import com.google.android.gms.maps.GoogleMap;
    import com.google.android.gms.maps.OnMapReadyCallback;
    import com.google.android.gms.maps.SupportMapFragment;
    import com.google.android.gms.maps.model.LatLng;
    import com.google.android.gms.maps.model.MarkerOptions;

    public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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
            // Add a marker in Sydney and move the camera
            LatLng akshuandroid = new LatLng(21, 57);
            googleMap.addMarker(new
                    MarkerOptions().position(akshuandroid).title("akshuandroid.info"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(akshuandroid));
        }
    } 

**And this will be your Mainfest.xml :**    

    <?xml version="1.0" encoding="utf-8"?>
    <manifest
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        package="maps.developer.aero">

        <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
        <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
        <uses-permission android:name="android.permission.INTERNET" />

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme"
            android:fullBackupContent="@xml/backup_descriptor"
            tools:ignore="GoogleAppIndexingWarning">
            <meta-data
                android:name="com.google.android.geo.API_KEY"
                android:value="@string/google_maps_key" />

            <activity
                android:name=".MapsActivity"
                android:label="@string/title_activity_maps">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>

    </manifest>
    
**Output :**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Maps/art/maps.png)
