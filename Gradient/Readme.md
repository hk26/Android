***Gradient Effect has come with Android 5.0 and Above versions. It helps you to give material design to your app. So let's create gradient toolbar:***

**Create a gradient file in res -> drawable -> gradient:**

    <?xml version="1.0" encoding="utf-8"?>
    <shape xmlns:android="http://schemas.android.com/apk/res/android">
        <gradient android:angle="135"
            android:startColor="#92d44b"
            android:endColor="#fa9f46"/>
    </shape>

**Styles.xml:**

    <resources>

        <!-- Base application theme. -->
        <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
            <!-- Customize your theme here. -->
            <item name="colorPrimary">@color/colorPrimary</item>
            <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
            <item name="colorAccent">@color/colorAccent</item>
        </style>

    </resources>

**Strings.xml:**

    <resources>
        <string name="app_name">Gradient</string>

        <string name="aero">Aero Developer</string>
    </resources>

**Create layout file named activity_main in res -> layout -> activity_main:**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#fff"
        tools:context=".MainActivity">

        <!--RePresent Toolbar-->
        <android.support.v7.widget.Toolbar
            android:layout_width="match_parent"
            android:layout_height="90dp"
            android:background="@drawable/gradient"
            android:orientation="horizontal">


            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical"
                android:gravity="center_horizontal"
                android:text="@string/aero"
                android:textColor="#fff"
                android:textSize="25sp" />

        </android.support.v7.widget.Toolbar>

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerHorizontal="true"
            android:layout_centerVertical="true"
            android:text="@string/app_name" />

    </RelativeLayout>

**Create MainActivity.java file. we will use FLAG_LAYOUT_NO_LIMITS and FLAG_TRANSLUCENT_NAVIGATION for transparent status bar:**

    package gradient.developer.aero;

    import android.os.Build;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.Window;
    import android.view.WindowManager;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window w = getWindow();
                w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
                w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }

**And lastly this will be your manifest file:**

    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        package="gradient.developer.aero">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:supportsRtl="true"
            android:theme="@style/AppTheme"
            android:fullBackupContent="@xml/backup_descriptor"
            tools:ignore="GoogleAppIndexingWarning">
            <activity
                android:name=".MainActivity"
                android:label="@string/app_name">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>

    </manifest>

**Output:**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Gradient/art/gradient.png)
