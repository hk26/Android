***As you know about the widgets in android. Widget is shortcut of your app instead opening app you can see the app messages and all in widget only like Whatsapp. So in this tutorial you will learn to create very simple widget for app.***

**Strings.xml**

    <resources>
        <string name="app_name">Widget</string>
        <string name="akshuandroid">akshuandroid</string>
        <string name="widget">Click Here to open website</string>
        <string name="add_widget">Go to your Widgets and see this app widget named as widget and add it to your launcher</string>
    </resources>

**Now create a xml directory in res folder and create mywidget.xml in xml directory**    

    <?xml version="1.0" encoding="utf-8"?>
    <appwidget-provider
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:minWidth="146dp"
        android:updatePeriodMillis="0"
        android:minHeight="146dp"
        android:initialLayout="@layout/widget_main">
    </appwidget-provider>
    
**Now we will create layout files for our app. we will create 2 layout file named as ' activity_main ' and ' widget_main ':**

**Your activity_main.xml**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <TextView
            android:id="@+id/textView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentStart="true"
            android:layout_centerVertical="true"
            android:text="@string/add_widget"
            tools:layout_editor_absoluteX="162dp"
            tools:layout_editor_absoluteY="245dp" />
    </RelativeLayout>    
    
**Your widget_main.xml**   

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity"
        android:transitionGroup="true"
        tools:ignore="UnusedAttribute">

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_above="@+id/button"
            android:layout_centerHorizontal="true"
            android:layout_marginBottom="34dp"
            android:text="@string/akshuandroid"
            android:textColor="#9012ff"
            android:textSize="35sp" />

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignStart="@+id/textView"
            android:layout_centerVertical="true"
            android:text="@string/widget" />

    </RelativeLayout> 
    
**And now create App.java file:**

    package widget.developer.aero;

    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;

    public class App extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }

**MainActivity.java file:**

    package widget.developer.aero;

    import android.app.PendingIntent;
    import android.appwidget.AppWidgetManager;
    import android.appwidget.AppWidgetProvider;
    import android.content.Context;
    import android.content.Intent;
    import android.net.Uri;
    import android.widget.RemoteViews;
    import android.widget.Toast;

    public class MainActivity extends AppWidgetProvider {
        public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
            for (int currentWidgetId : appWidgetIds) {
                String url = "https://www.akshuandroid.info";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse(url));

                PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);
                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_main);

                views.setOnClickPendingIntent(R.id.button, pending);
                appWidgetManager.updateAppWidget(currentWidgetId, views);
                Toast.makeText(context, "widget added", Toast.LENGTH_SHORT).show();
            }
        }
    }    

**Manifest.xml**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="widget.developer.aero">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:theme="@style/AppTheme" >
            <activity android:name=".App">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>

            <receiver android:name=".MainActivity">

                <intent-filter>
                    <action android:name="android.appwidget.action.APPWIDGET_UPDATE">
                    </action>
                </intent-filter>

                <meta-data android:name="android.appwidget.provider"
                    android:resource="@xml/mywidget">
                </meta-data>
            </receiver>
        </application>

    </manifest> 

**Output:**

![alt text]()    
    