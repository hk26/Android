***In this tutorial we will learn to add menu in toolbar. Adding Menu to app is very important when we want to add settings and other options to our app. So let's start the tutorial :***

**This is your Styles.xml file :**

    <resources>

        <!-- Base application theme. -->
        <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
            <!-- Customize your theme here. -->
            <item name="colorPrimary">@color/colorPrimary</item>
            <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
            <item name="colorAccent">@color/colorAccent</item>
        </style>

    </resources>
    
**This is your Strings.xml file :**

    <resources>
        <string name="app_name">Menu</string>
        <string name="bookmark">Bookmark</string>
        <string name="save">Save</string>
        <string name="search">Search</string>
        <string name="share">Share</string>
        <string name="delete">Delete</string>
        <string name="preferences">Preferences</string>
        <string name="click_on_menu_to_show_menu_items">Click on Menu to show Menu Items</string>
    </resources>
    
**Now create a menu folder in res -> menu and in menu folder create menu_main file :**    

    <?xml version="1.0" encoding="utf-8"?>
    <menu
        xmlns:android="http://schemas.android.com/apk/res/android">

        <item 
        android:id="@+id/menu_bookmark"
        android:title="@string/bookmark" />

        <item 
        android:id="@+id/menu_save"
        android:title="@string/save" />

        <item 
        android:id="@+id/menu_search"
        android:title="@string/search" />

        <item 
        android:id="@+id/menu_share"
        android:title="@string/share" />

        <item 
        android:id="@+id/menu_delete"
        android:title="@string/delete" />

        <item 
        android:id="@+id/menu_preferences"
        android:title="@string/preferences" />
    </menu>
    
**Now create a layout file named ' main ' in res -> layout -> main :**

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="vertical"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent">

        <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="?attr/colorPrimary"
            android:minHeight="?attr/actionBarSize"
            android:theme="?attr/actionBarTheme" />

        <TextView
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:text="@string/click_on_menu_to_show_menu_items"
        android:textSize="20sp"
        android:textStyle="bold"
        android:layout_margin="20dip" />

    </LinearLayout>

**And now create java file in your package named as ' MainActivity.java ' :**

    package menu.developer.aero;

    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.view.Menu;
    import android.view.MenuInflater;
    import android.view.MenuItem;
    import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            //noinspection ConstantConditions
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setTitle(getString(R.string.app_name));
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu)
        {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu_main, menu);
            return true;
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item)
        {

            switch (item.getItemId())
            {
                case R.id.menu_bookmark:
                    // Single menu_main item is selected do something
                    // Ex: launching new activity/screen or show alert message
                    Toast.makeText(MainActivity.this, "Bookmark is Selected", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.menu_save:
                    Toast.makeText(MainActivity.this, "Save is Selected", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.menu_search:
                    Toast.makeText(MainActivity.this, "Search is Selected", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.menu_share:
                    Toast.makeText(MainActivity.this, "Share is Selected", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.menu_delete:
                    Toast.makeText(MainActivity.this, "Delete is Selected", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.menu_preferences:
                    Toast.makeText(MainActivity.this, "Preferences is Selected", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }
    }  

**And lastly this will be your Manifest.xml file :**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest
        xmlns:android="http://schemas.android.com/apk/res/android"
        package="menu.developer.aero">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme">
            <activity
                android:name=".MainActivity"
                android:theme="@style/AppTheme">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>

    </manifest>

**Output :**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Menu/art/menu.png)
