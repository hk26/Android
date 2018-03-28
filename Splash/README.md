***As you have seen in many apps they have splash activity when the app start it shows the company or developer logo to you. So in this tutorial we learn to create a SplashActivity for our app.***

**Strings.xml**

    <resources>
        <string name="app_name">Splash</string>
    </resources>

**Colors.xml**

    <?xml version="1.0" encoding="utf-8"?>
    <resources>
        <color name="colorPrimary">#3F51B5</color>
        <color name="colorPrimaryDark">#303F9F</color>
        <color name="colorAccent">#FF4081</color>

        <color name="splash_background">#ffffff</color>
    </resources>

**Styles.xml**

    <resources>

        <!-- Base application theme. -->
        <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
            <!-- Customize your theme here. -->
            <item name="colorPrimary">@color/colorPrimary</item>
            <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
            <item name="colorAccent">@color/colorAccent</item>
        </style>

        <style name="SplashTheme" parent="Theme.AppCompat.NoActionBar">
            <item name="android:windowBackground">@drawable/background_splash</item>
        </style>

    </resources>

**Now we will create a background_splash file in res -> drawable -> background_splash**

    <?xml version="1.0" encoding="utf-8"?>
    <layer-list xmlns:android="http://schemas.android.com/apk/res/android">

        <item
            android:drawable="@color/splash_background"/>

        <item>
            <bitmap
                android:gravity="center"
                android:src="@mipmap/splash_icon"/>
        </item>

    </layer-list>

**Create a activity_main file in res -> layout -> activity_main**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerHorizontal="true"
            android:layout_centerVertical="true"
            app:srcCompat="@mipmap/splash_icon"
            android:contentDescription="@string/app_name" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@+id/imageView"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="70dp"
            android:text="@string/aero_developer"
            android:textSize="25sp" />
    </RelativeLayout>
    
    
***After creating layout files and all. Now we will write the java files for our app. See the below screenshot how the package will look***

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Splash/art/Capture.PNG)

**Create a App.java file in splash.developer.aero -> App.java**
	
    package splash.developer.aero;

    import android.app.Application;
    import android.os.SystemClock;
    import java.util.concurrent.TimeUnit;

    public class App extends Application {

        @Override
        public void onCreate() {
            super.onCreate();

            // Don't do this! This is just so cold launches take some time
            SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
        }
    }

**Create a MainActivity.java file in splash.developer.aero -> MainActivity.java**

    package splash.developer.aero;

    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }

**Create a SplashActivity.java file in splash.developer.aero -> SplashActivity.java**

    package splash.developer.aero;

    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;

    public class SplashActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

**And lastly write down this in manifest file:**

    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="splash.developer.aero">

        <application
            android:name="splash.developer.aero.App"
            android:label="@string/app_name"
            android:icon="@mipmap/ic_launcher"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme">

            <activity
                android:name="splash.developer.aero.SplashActivity"
                android:label="@string/app_name"
                android:theme="@style/SplashTheme">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>

            <activity
                android:name="splash.developer.aero.MainActivity"
                android:theme="@style/AppTheme">
            </activity>

        </application>
    </manifest>
