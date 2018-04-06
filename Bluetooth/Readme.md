***In this tutorial you will learn to create a simple bluetooth app which will show you the paired devices. So let's start with tutorial:***

**Strings.xml**

    <resources>
        <string name="app_name">Bluetooth</string>
        <string name="turn_on">Turn on</string>
        <string name="turn_off">Turn off</string>
        <string name="get_visible">Get Visible</string>
        <string name="list_devices">List Devices</string>
        <string name="paired_devices">Paired Devices will show here:</string>
    </resources>
    
**Create layout file named ' activity_main ' in res -> layout -> activity_main :**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <Button
            android:id="@+id/turnon"
            style="@style/Widget.AppCompat.Button.Borderless"
            android:layout_width="76dp"
            android:layout_height="wrap_content"
            android:layout_alignParentStart="true"
            android:layout_alignParentTop="true"
            android:clickable="true"
            android:focusable="true"
            android:onClick="on"
            android:text="@string/turn_on" />

        <Button
            android:id="@+id/getvisible"
            style="@style/Widget.AppCompat.Button.Borderless"
            android:layout_width="80dp"
            android:layout_height="wrap_content"
            android:layout_alignParentEnd="true"
            android:layout_alignParentTop="true"
            android:onClick="visible"
            android:text="@string/get_visible" />

        <Button
            android:id="@+id/listdevices"
            style="@style/Widget.AppCompat.Button.Borderless"
            android:layout_width="80dp"
            android:layout_height="wrap_content"
            android:layout_alignParentTop="true"
            android:layout_toStartOf="@+id/getvisible"
            android:onClick="list"
            android:text="@string/list_devices" />

        <Button
            android:id="@+id/turnoff"
            style="@style/Widget.AppCompat.Button.Borderless"
            android:layout_width="76dp"
            android:layout_height="wrap_content"
            android:layout_alignParentTop="true"
            android:layout_toEndOf="@+id/turnon"
            android:onClick="off"
            android:text="@string/turn_off" />

        <ListView
            android:id="@+id/listView"
            android:layout_width="wrap_content"
            android:layout_height="422dp"
            android:layout_alignParentBottom="true"
            android:layout_alignParentStart="true" />

        <TextView
            android:id="@+id/textView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@+id/turnon"
            android:layout_centerHorizontal="true"
            android:text="@string/paired_devices"
            android:textSize="25sp" />
    </RelativeLayout>
    
**This will be your MainActivity.java file :**

    package bluetooth.developer.aero;

    import android.app.Activity;
    import android.bluetooth.BluetoothAdapter;
    import android.bluetooth.BluetoothDevice;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.ListView;
    import android.widget.Toast;
    import java.util.ArrayList;
    import java.util.Set;

    public class MainActivity extends Activity {
        Button b1,b2,b3,b4;
        private BluetoothAdapter BA;
        ListView lv;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            b1 = findViewById(R.id.turnon);
            b2= findViewById(R.id.getvisible);
            b3= findViewById(R.id.listdevices);
            b4= findViewById(R.id.turnoff);
            BA = BluetoothAdapter.getDefaultAdapter();
            lv = findViewById(R.id.listView);
        }

        public void on(View v){
            if (!BA.isEnabled()) {
                Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(turnOn, 0);
                Toast.makeText(getApplicationContext(), "Turned on",Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Already on", Toast.LENGTH_LONG).show();
            }
        }

        public void off(View v){
            BA.disable();
            Toast.makeText(getApplicationContext(), "Turned off" ,Toast.LENGTH_LONG).show();
        }


        public  void visible(View v){
            Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            startActivityForResult(getVisible, 0);
        }


        public void list(View v){
            Set<BluetoothDevice> pairedDevices = BA.getBondedDevices();

            ArrayList list = new ArrayList();

            for(BluetoothDevice bt : pairedDevices) //noinspection unchecked
                list.add(bt.getName());
            Toast.makeText(getApplicationContext(), "Showing Paired Devices",Toast.LENGTH_SHORT).show();

            //noinspection unchecked
            final ArrayAdapter adapter = new  ArrayAdapter(this,android.R.layout.simple_list_item_1, list);

            lv.setAdapter(adapter);
        }
    }    

**Manifest.xml :**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="bluetooth.developer.aero">

        <uses-permission android:name="android.permission.BLUETOOTH" />
        <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />

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

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Bluetooth/art/bluetooth.png)    
    
