***All known about Image Button in android apps. Image Button is used in many apps. It helps user to launch an activity. So let's start the tutorial :***

***I have not given Drawable folder images. So i prefer to download source code :***

**Create layout file named as ' activity_main ' in res -> layout -> activity_main :**

    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <ImageButton
            android:id="@+id/simpleImageButtonHome"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:layout_alignParentTop="true"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="117dp"
            android:background="@drawable/custom_image_button"
            android:contentDescription="@string/app_name"
            android:padding="20dp"
            android:src="@drawable/home" />

        <ImageButton
            android:id="@+id/simpleImageButtonYouTube"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:layout_alignParentBottom="true"
            android:layout_centerHorizontal="true"
            android:layout_marginBottom="130dp"
            android:background="#005"
            android:contentDescription="@string/app_name"
            android:padding="20dp"
            android:src="@drawable/youtube" />

    </RelativeLayout>
    
**And Now create MainActivity.java file in your package :**

    package imagebutton.developer.aero;

    import android.app.Activity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ImageButton;
    import android.widget.Toast;

    public class MainActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            // initiate view's
            ImageButton simpleImageButtonHome = findViewById(R.id.simpleImageButtonHome);
            ImageButton simpleImageButtonYouTube = findViewById(R.id.simpleImageButtonYouTube);
            // perform click event on button's
            simpleImageButtonHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"Home Button",Toast.LENGTH_LONG).show();// display the toast on home button click
                }
            });
            simpleImageButtonYouTube.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"YouTube Button",Toast.LENGTH_LONG).show();// display the toast on you tube button click
                }
            });
        }
    }  

**And finally this will be your Manifest.xml file :**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="imagebutton.developer.aero">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme">
            <activity android:name=".MainActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>

    </manifest>   

**Output :**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/ImageButton/art/imagebutton.png)    
