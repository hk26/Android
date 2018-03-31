***Many apps support Notification service. It is very useful when your app want to display a importatnt notification to user. So this is a simple tutorial in you will learn to display notification.***
  
**Strings:**
    <resources>
        <string name="app_name">Notification</string>
        <string name="click_me">Click me to show notification</string>
    </resources>

**Now we will write layout files. So create activity_main.xml layout file in res folder:**

    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <TextView
            android:id="@+id/textView1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_above="@+id/button"
            android:layout_centerHorizontal="true"
            android:layout_marginBottom="70dp"
            android:text="@string/app_name"
            android:textSize="30sp" />

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerHorizontal="true"
            android:layout_centerVertical="true"
            android:text="@string/click_me" />

    </RelativeLayout> 
    
**Now create notification.xml in res folder:**

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="vertical"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent" >

        <TextView
            android:layout_width="fill_parent"
            android:layout_height="400dp"
            android:text="@string/app_name" />
    </LinearLayout> 

**After creating layout files. Now let's start with creating java files. So create MainActivity.java file:**

    package notification.developer.aero;

    import android.app.Activity;
    import android.app.NotificationManager;
    import android.app.PendingIntent;
    import android.content.Context;
    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v4.app.NotificationCompat;
    import android.view.View;
    import android.widget.Button;

    public class MainActivity extends Activity {

        Button b1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            b1 = findViewById(R.id.button);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addNotification();
                }
            });
        }

        private void addNotification() {
            //noinspection deprecation
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("Notifications Example")
                            .setContentText("This is a test notification");

            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(contentIntent);

            // Add as notification
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            assert manager != null;
            manager.notify(0, builder.build());
        }
    }
    
**And now create NotificationView.java file:**

    package notification.developer.aero;

    import android.os.Bundle;
    import android.app.Activity;

    public class NotificationView extends Activity{
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.notification);
        }
    }

**And lastly this will be your manifest file:**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        package="notification.developer.aero">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme"
            tools:ignore="GoogleAppIndexingWarning"
            android:fullBackupContent="true">
            <activity android:name=".MainActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>

            <activity android:name=".NotificationView"
                android:label="@string/app_name"
                android:parentActivityName=".MainActivity">
                <meta-data
                    android:name="android.support.PARENT_ACTIVITY"
                    android:value=".MainActivity"/>
            </activity>

        </application>

    </manifest>
 
**Output:**

![alt text]()