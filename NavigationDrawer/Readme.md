***As you have seen in some apps like Gmail and Google Maps apps they used a Navigation drawer in their app. Navigation drawer slides in from the left and contains the navigation destinations for your app. Navigation drawer is used when your app contains more 6 destinations then it is recommended to use navigation drawer.***

**This will be your build.gradle(Module:app) file :**

apply plugin: 'com.android.application'

    android {
        compileSdkVersion 27
        defaultConfig {
            applicationId "navigationdrawer.developer.aero"
            minSdkVersion 15
            targetSdkVersion 27
            versionCode 1
            versionName "1.0"
            testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
        }
        buildTypes {
            release {
                minifyEnabled false
                proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
            }
        }
    }

    dependencies {
        implementation fileTree(dir: 'libs', include: ['*.jar'])
        implementation 'com.android.support:appcompat-v7:27.1.1'
        implementation 'com.android.support:design:27.1.1'
        implementation 'com.android.support.constraint:constraint-layout:1.1.0'
        testImplementation 'junit:junit:4.12'
        androidTestImplementation 'com.android.support.test:runner:1.0.2'
        androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    }
    
***I have not given drawable folder and mipmap folder images. So i prefer to download the source code from my website or you can put your images also where it is needed :***    

**Create a Dimens named file res -> values -> dimens :**

    <resources>
        <!-- Default screen margins, per the Android Design guidelines. -->
        <dimen name="activity_horizontal_margin">16dp</dimen>
        <dimen name="activity_vertical_margin">16dp</dimen>
        <dimen name="nav_header_vertical_spacing">8dp</dimen>
        <dimen name="nav_header_height">176dp</dimen>
        <dimen name="fab_margin">16dp</dimen>
    </resources>
    
**Now open your strings file and put this :**

    <resources>
        <string name="app_name">NavigationDrawer</string>
        <string name="navigation_drawer_open">Open navigation drawer</string>
        <string name="navigation_drawer_close">Close navigation drawer</string>
        <string name="nav_header_title">Akshuandroid</string>
        <string name="nav_header_subtitle">akshaysunilmasram@yahoo.com</string>
        <string name="nav_header_desc">Navigation header</string>
        <string name="action_settings">Settings</string>
        <string name="import1">Import</string>
        <string name="gallery">Gallery</string>
        <string name="slideshow">Slideshow</string>
        <string name="tools">Tools</string>
        <string name="communicate">Communicate</string>
        <string name="send">Send</string>
        <string name="share">Share</string>
    </resources>
    
**Create a drawables named file in res -> values -> drawables :**


    <resources xmlns:android="http://schemas.android.com/apk/res/android">
        <item name="ic_menu_camera" type="drawable">@android:drawable/ic_menu_camera</item>
        <item name="ic_menu_gallery" type="drawable">@android:drawable/ic_menu_gallery</item>
        <item name="ic_menu_slideshow" type="drawable">@android:drawable/ic_menu_slideshow</item>
        <item name="ic_menu_manage" type="drawable">@android:drawable/ic_menu_manage</item>
        <item name="ic_menu_share" type="drawable">@android:drawable/ic_menu_share</item>
        <item name="ic_menu_send" type="drawable">@android:drawable/ic_menu_send</item>
    </resources>
    
**Now create a  side_nav_bar named file in res -> drawable -> side_nav_bar :**

    <shape xmlns:android="http://schemas.android.com/apk/res/android"
        android:shape="rectangle">
        <gradient
            android:angle="135"
            android:centerColor="#00964b"
            android:endColor="#006919"
            android:startColor="#4db667"
            android:type="linear" />
    </shape> 
    
**Create a menu directory in res and in menu directory create ' activity_main_drawer ' and ' main ' named file in menu directory . Please note i have not given images so you should download this code or apply for your own**

**This is activity_main_drawer file :**

    <?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        tools:showIn="navigation_view">

        <group android:checkableBehavior="single">
            <item
                android:id="@+id/nav_camera"
                android:icon="@drawable/ic_menu_camera"
                android:title="@string/import1" />
            <item
                android:id="@+id/nav_gallery"
                android:icon="@drawable/ic_menu_gallery"
                android:title="@string/gallery" />
            <item
                android:id="@+id/nav_slideshow"
                android:icon="@drawable/ic_menu_slideshow"
                android:title="@string/slideshow" />
            <item
                android:id="@+id/nav_manage"
                android:icon="@drawable/ic_menu_manage"
                android:title="@string/tools" />
        </group>

        <item android:title="@string/communicate">
            <menu>
                <item
                    android:id="@+id/nav_share"
                    android:icon="@drawable/ic_menu_share"
                    android:title="@string/share"/>
                <item
                    android:id="@+id/nav_send"
                    android:icon="@drawable/ic_menu_send"
                    android:title="@string/send" />
            </menu>
        </item>

    </menu>
    
**This main file :**

    <?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">
        <item
            android:id="@+id/action_settings"
            android:orderInCategory="100"
            android:title="@string/action_settings"
            app:showAsAction="never" />
    </menu>
    
**Now we will create layout files for our app. Their will be total 4 layout files named as ' activity_main ' , ' app_bar_main ' , ' content_main ' , ' nav_header_main '.So let's create this layout file :**

**Create activity_main layout file :**

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/drawer_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true"
        tools:openDrawer="start">

        <include
            layout="@layout/app_bar_main"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

        <android.support.design.widget.NavigationView
            android:id="@+id/nav_view"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:layout_gravity="start"
            android:fitsSystemWindows="true"
            app:headerLayout="@layout/nav_header_main"
            app:menu="@menu/activity_main_drawer" />

    </android.support.v4.widget.DrawerLayout>
    
**Create app_bar_main layout file :** 

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <android.support.design.widget.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:theme="@style/AppTheme.AppBarOverlay">

            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                android:background="?attr/colorPrimary"
                app:popupTheme="@style/AppTheme.PopupOverlay" />

        </android.support.design.widget.AppBarLayout>

        <include layout="@layout/content_main" />

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom|end"
            android:layout_margin="@dimen/fab_margin"
            app:srcCompat="@android:drawable/ic_dialog_email" />

    </android.support.design.widget.CoordinatorLayout>  

**Create content_main layout file :**   

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.constraint.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior"
        tools:context=".MainActivity"
        tools:showIn="@layout/app_bar_main">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello World!"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

    </android.support.constraint.ConstraintLayout> 

**Create nav_header_main layout file :**      

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="@dimen/nav_header_height"
        android:background="@drawable/side_nav_bar"
        android:gravity="bottom"
        android:orientation="vertical"
        android:paddingBottom="@dimen/activity_vertical_margin"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        android:theme="@style/ThemeOverlay.AppCompat.Dark">

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="69dp"
            android:layout_height="71dp"
            android:contentDescription="@string/nav_header_desc"
            android:paddingTop="@dimen/nav_header_vertical_spacing"
            app:srcCompat="@mipmap/android" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:paddingTop="@dimen/nav_header_vertical_spacing"
            android:text="@string/nav_header_title"
            android:textAppearance="@style/TextAppearance.AppCompat.Body1" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/nav_header_subtitle" />

    </LinearLayout>
    
**Now finally after creating layout file. Create a MainActivity.java file in your package :**

    package navigationdrawer.developer.aero;

    import android.os.Bundle;
    import android.support.annotation.NonNull;
    import android.support.design.widget.FloatingActionButton;
    import android.support.design.widget.Snackbar;
    import android.view.View;
    import android.support.design.widget.NavigationView;
    import android.support.v4.view.GravityCompat;
    import android.support.v4.widget.DrawerLayout;
    import android.support.v7.app.ActionBarDrawerToggle;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.view.Menu;
    import android.view.MenuItem;

    public class MainActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            FloatingActionButton fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own code", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
        }

        @Override
        public void onBackPressed() {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            switch (id) {
                case R.id.nav_camera:
                    //TODO Put your Intent code here to start another activity of your app
                    // Here you can put your intent code to start another activity on click.
                    break;
                case R.id.nav_gallery:

                    break;
                case R.id.nav_slideshow:

                    break;
                case R.id.nav_manage:

                    break;
                case R.id.nav_share:

                    break;
                case R.id.nav_send:

                    break;
            }

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }
    
**And lastly this will be your Manifest file :**

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="navigationdrawer.developer.aero">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".MainActivity"
            android:label="@string/app_name"
            android:theme="@style/AppTheme.NoActionBar">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

**Output :**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/NavigationDrawer/mockup/navigationdrawer.png)
