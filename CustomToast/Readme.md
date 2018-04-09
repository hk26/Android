***As you known about the Toast in android app. Toast gives you a message to user when their is no internet connection or whatever you want to display. But you can customized the toast preview as you want. So in this tutorial you will learn to create Custom Toast for android app.***

**Strings.xml :**

    <resources>
        <string name="app_name">CustomToast</string>
    </resources>
    
***Now we will create layout files for our app :***

**Create ' activity_main ' layout file:

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <Button
            android:id="@+id/buttonToast"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentTop="true"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="47dp"
            android:text="@string/app_name" />
    </RelativeLayout>    
    
**Now create ' custom_toast ' layout file :**

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/custom_toast_layout_id"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:background="#FFF"
        android:orientation="horizontal"
        android:padding="5dp" >

        <ImageView
            android:id="@+id/image"
            android:src="@mipmap/ic_launcher"
            android:contentDescription="@string/app_name"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:layout_marginEnd="5dp" />

        <TextView
            android:id="@+id/text"
            android:text="@string/app_name"
            android:layout_width="wrap_content"
            android:layout_height="fill_parent"
            android:textColor="#000" />

    </LinearLayout> 

**Create ' MainActivity.java ' file in your package :**

    package customtoast.developer.aero;

    import android.annotation.SuppressLint;
    import android.app.Activity;
    import android.os.Bundle;
    import android.view.Gravity;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.TextView;
    import android.widget.Toast;

    public class MainActivity extends Activity {

        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button button = findViewById(R.id.buttonToast);

            button.setOnClickListener(new OnClickListener() {

                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View arg0) {

                    // get your custom_toast.xml ayout
                    LayoutInflater inflater = getLayoutInflater();

                    View layout = inflater.inflate(R.layout.custom_toast,
                            (ViewGroup) findViewById(R.id.custom_toast_layout_id));

                    // set a dummy image
                    ImageView image = layout.findViewById(R.id.image);
                    image.setImageResource(R.mipmap.ic_launcher);

                    // set a message
                    TextView text = layout.findViewById(R.id.text);
                    text.setText("Button is clicked!");

                    // Toast...
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                }
            });
        }
    }

**Manifest.xml :**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="customtoast.developer.aero">

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

![alt text]()    