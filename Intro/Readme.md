***As you known many apps have a Intro activity when they are launched for first time use in your phone. Intro activity in your app is a great way of showing the major features of your app.***

**This is your build.gradle(Module:app) file:**

    apply plugin: 'com.android.application'

    android {
        compileSdkVersion 27
        defaultConfig {
            applicationId "intro.developer.aero"
            minSdkVersion 16
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
        testImplementation 'junit:junit:4.12'
        androidTestImplementation 'com.android.support.test:runner:1.0.1'
        androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'

        implementation 'com.android.support:appcompat-v7:27.0.2'
        implementation 'com.android.support:design:27.0.2'
    }

**Strings:**

    <resources>
        <string name="app_name">Intro</string>
        <string name="title_activity_welcome">Home Screen</string>
        <string name="next">NEXT</string>
        <string name="skip">SKIP</string>
        <string name="start">GOT IT</string>

        <string name="slide_1_title">Hello Food!</string>
        <string name="slide_1_desc">The easiest way to order food from your favourite restaurant!</string>

        <string name="slide_2_title">Movie Tickets</string>
        <string name="slide_2_desc">Book movie tickets for your family and friends!</string>

        <string name="slide_3_title">Great Discounts</string>
        <string name="slide_3_desc">Best discounts on every single service we offer!</string>

        <string name="slide_4_title">World Travel</string>
        <string name="slide_4_desc">Book tickets of any transportation and travel the world!</string>

        <string name="play_again_desc">To see the welcome slider again, goto Settings -> apps -> welcome slider -> clear data</string>
        <string name="play_again">Play Again</string>
    </resources>

**Colors:**

    <?xml version="1.0" encoding="utf-8"?>
    <resources>
        <color name="colorPrimary">#3F51B5</color>
        <color name="colorPrimaryDark">#303F9F</color>
        <color name="colorAccent">#FF4081</color>

        <!-- Screens background color-->
        <color name="bgscreen1">#f64c73</color>
        <color name="bg_screen2">#20d2bb</color>
        <color name="bg_screen3">#3395ff</color>
        <color name="bg_screen4">#c873f4</color>

        <!-- dots inactive colors -->
        <color name="dot_dark_screen1">#d1395c</color>
        <color name="dot_dark_screen2">#14a895</color>
        <color name="dot_dark_screen3">#2278d4</color>
        <color name="dot_dark_screen4">#a854d4</color>

        <!-- dots active colors -->
        <color name="dot_light_screen1">#f98da5</color>
        <color name="dot_light_screen2">#8cf9eb</color>
        <color name="dot_light_screen3">#93c6fd</color>
        <color name="dot_light_screen4">#e4b5fc</color>

        <array name="array_dot_active">
            <item>@color/dot_light_screen1</item>
            <item>@color/dot_light_screen2</item>
            <item>@color/dot_light_screen3</item>
            <item>@color/dot_light_screen4</item>
        </array>

        <array name="array_dot_inactive">
            <item>@color/dot_dark_screen1</item>
            <item>@color/dot_dark_screen2</item>
            <item>@color/dot_dark_screen3</item>
            <item>@color/dot_dark_screen4</item>
        </array>
    </resources>

**Dimens:**

    <resources xmlns:tools="http://schemas.android.com/tools">
        <!-- Default screen margins, per the Android Design guidelines. -->
        <dimen name="activity_horizontal_margin" tools:ignore="UnusedResources">16dp</dimen>
        <dimen name="activity_vertical_margin">16dp</dimen>
        <dimen name="fab_margin" tools:ignore="UnusedResources">16dp</dimen>
        <dimen name="dots_height">30dp</dimen>
        <dimen name="dots_margin_bottom">20dp</dimen>
        <dimen name="img_width_height">120dp</dimen>
        <dimen name="slide_title">30sp</dimen>
        <dimen name="slide_desc">16sp</dimen>
        <dimen name="desc_padding">40dp</dimen>
    </resources>

**Create a drawable folder in res and download this images given below link and put it in your drawable directory**
(https://github.com/akshaysunilmasram/Android/blob/master/Intro/app/src/main/res/drawable-hdpi/ic_food.png)

(https://github.com/akshaysunilmasram/Android/blob/master/Intro/app/src/main/res/drawable-hdpi/ic_movie.png)

(https://github.com/akshaysunilmasram/Android/blob/master/Intro/app/src/main/res/drawable-hdpi/ic_travel.png)

(https://github.com/akshaysunilmasram/Android/blob/master/Intro/app/src/main/res/drawable-hdpi/ic_discount.png)

**Create a activity_main file  in res-> layout -> activity_main**

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true"
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

        <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:tools="http://schemas.android.com/tools"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:padding="@dimen/activity_vertical_margin"
            app:layout_behavior="@string/appbar_scrolling_view_behavior">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/play_again_desc" />

            <Button
                android:id="@+id/btn_play_again"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:text="@string/play_again" />
        </LinearLayout>

    </android.support.design.widget.CoordinatorLayout>

**Create a activity_welcome file  in res-> layout -> activity_welcome**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:showIn="@layout/activity_welcome">

        <android.support.v4.view.ViewPager
            android:id="@+id/view_pager"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

        <LinearLayout
            android:id="@+id/layoutDots"
            android:layout_width="match_parent"
            android:layout_height="@dimen/dots_height"
            android:layout_alignParentBottom="true"
            android:layout_marginBottom="@dimen/dots_margin_bottom"
            android:gravity="center"
            android:orientation="horizontal">

        </LinearLayout>

        <View
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:alpha=".5"
            android:layout_above="@id/layoutDots"
            android:background="@android:color/white" />

        <Button
            android:id="@+id/btn_next"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_alignParentRight="true"
            android:background="@null"
            android:text="@string/next"
            android:textColor="@android:color/white"
            tools:ignore="RelativeOverlap,RtlHardcoded" />

        <Button
            android:id="@+id/btn_skip"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_alignParentLeft="true"
            android:background="@null"
            android:text="@string/skip"
            android:textColor="@android:color/white"
            tools:ignore="RtlHardcoded" />

    </RelativeLayout>

**Create a welcome_slide1 file  in res-> layout -> welcome_slide1**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/bgscreen1"
        tools:ignore="Overdraw">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:gravity="center_horizontal"
            android:orientation="vertical"
            tools:ignore="UselessParent">

            <ImageView
                android:layout_width="@dimen/img_width_height"
                android:layout_height="@dimen/img_width_height"
                android:src="@drawable/ic_food"
                android:contentDescription="@string/app_name" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/slide_1_title"
                android:textColor="@android:color/white"
                android:textSize="@dimen/slide_title"
                android:textStyle="bold" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="20dp"
                android:paddingLeft="@dimen/desc_padding"
                android:paddingRight="@dimen/desc_padding"
                android:text="@string/slide_1_desc"
                android:textAlignment="center"
                android:textColor="@android:color/white"
                android:textSize="@dimen/slide_desc" />

        </LinearLayout>


    </RelativeLayout>

**Create a welcome_slide2 file  in res-> layout -> welcome_slide2**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/bg_screen2"
        tools:ignore="Overdraw">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:gravity="center_horizontal"
            android:orientation="vertical"
            tools:ignore="UselessParent">

            <ImageView
                android:layout_width="@dimen/img_width_height"
                android:layout_height="@dimen/img_width_height"
                android:src="@drawable/ic_movie"
                android:contentDescription="@string/app_name" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/slide_2_title"
                android:textColor="@android:color/white"
                android:textSize="@dimen/slide_title"
                android:textStyle="bold" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="20dp"
                android:paddingLeft="@dimen/desc_padding"
                android:paddingRight="@dimen/desc_padding"
                android:text="@string/slide_2_desc"
                android:textAlignment="center"
                android:textColor="@android:color/white"
                android:textSize="@dimen/slide_desc" />

        </LinearLayout>


    </RelativeLayout>

**Create a welcome_slide3 file  in res-> layout -> welcome_slide3**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/bg_screen3"
        tools:ignore="Overdraw">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:gravity="center_horizontal"
            android:orientation="vertical"
            tools:ignore="UselessParent">

            <ImageView
                android:layout_width="@dimen/img_width_height"
                android:layout_height="@dimen/img_width_height"
                android:src="@drawable/ic_discount"
                android:contentDescription="@string/app_name" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/slide_3_title"
                android:textColor="@android:color/white"
                android:textSize="@dimen/slide_title"
                android:textStyle="bold" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="20dp"
                android:paddingLeft="@dimen/desc_padding"
                android:paddingRight="@dimen/desc_padding"
                android:text="@string/slide_3_desc"
                android:textAlignment="center"
                android:textColor="@android:color/white"
                android:textSize="@dimen/slide_desc" />

        </LinearLayout>

    </RelativeLayout>

**Create a welcome_slide4 file  in res-> layout -> welcome_slide4**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/bg_screen4"
        tools:ignore="Overdraw">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:gravity="center_horizontal"
            android:orientation="vertical"
            tools:ignore="UselessParent">

            <ImageView
                android:layout_width="@dimen/img_width_height"
                android:layout_height="@dimen/img_width_height"
                android:src="@drawable/ic_travel"
                android:contentDescription="@string/app_name" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/slide_4_title"
                android:textColor="@android:color/white"
                android:textSize="@dimen/slide_title"
                android:textStyle="bold" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="20dp"
                android:paddingLeft="@dimen/desc_padding"
                android:paddingRight="@dimen/desc_padding"
                android:text="@string/slide_4_desc"
                android:textAlignment="center"
                android:textColor="@android:color/white"
                android:textSize="@dimen/slide_desc" />

        </LinearLayout>

    </RelativeLayout>

***After cretaing layout fiels and all now we will write Java files in our package. Below given screenshot will help you how the package will look:***

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Intro/art/Capture.PNG)

**Create a MainActivity.java file:**

    package intro.developer.aero;

    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.view.View;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            findViewById(R.id.btn_play_again).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // We normally won't show the welcome slider again in real app
                    // but this is for testing
                    PrefManager prefManager = new PrefManager(getApplicationContext());

                    // make first time launch TRUE
                    prefManager.setFirstTimeLaunch(true);

                    startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                    finish();
                }
            });
        }
    }

**Create a PrefManager.java file:**

    package intro.developer.aero;

    import android.annotation.SuppressLint;
    import android.content.Context;
    import android.content.SharedPreferences;

    @SuppressWarnings("WeakerAccess")
    public class PrefManager {
        private final SharedPreferences pref;
        private final SharedPreferences.Editor editor;

        // Shared preferences file name
        private static final String PREF_NAME = "androidhive-welcome";

        private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

        @SuppressLint("CommitPrefEdits")
        public PrefManager(Context context) {
            int PRIVATE_MODE = 0;
            pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
            editor = pref.edit();
        }

        public void setFirstTimeLaunch(boolean isFirstTime) {
            editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
            editor.commit();
        }

        public boolean isFirstTimeLaunch() {
            return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
        }
    }

**Create a welcomeactivity.java file:**

    package intro.developer.aero;

    import android.content.Context;
    import android.content.Intent;
    import android.graphics.Color;
    import android.os.Build;
    import android.os.Bundle;
    import android.support.annotation.NonNull;
    import android.support.v4.view.PagerAdapter;
    import android.support.v4.view.ViewPager;
    import android.support.v7.app.AppCompatActivity;
    import android.text.Html;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.view.Window;
    import android.view.WindowManager;
    import android.widget.Button;
    import android.widget.LinearLayout;
    import android.widget.TextView;

    public class WelcomeActivity extends AppCompatActivity {

        private ViewPager viewPager;
        private LinearLayout dotsLayout;
        private int[] layouts;
        private Button btnSkip, btnNext;
        private PrefManager prefManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Checking for first time launch - before calling setContentView()
            prefManager = new PrefManager(this);
            if (!prefManager.isFirstTimeLaunch()) {
                launchHomeScreen();
                finish();
            }

            // Making notification bar transparent
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }

            setContentView(R.layout.activity_welcome);

            viewPager = findViewById(R.id.view_pager);
            dotsLayout = findViewById(R.id.layoutDots);
            btnSkip = findViewById(R.id.btn_skip);
            btnNext = findViewById(R.id.btn_next);


            // layouts of all welcome sliders
            // add few more layouts if you want
            layouts = new int[]{
                    R.layout.welcome_slide1,
                    R.layout.welcome_slide2,
                    R.layout.welcome_slide3,
                    R.layout.welcome_slide4};

            // adding bottom dots
            addBottomDots(0);

            // making notification bar transparent
            changeStatusBarColor();

            MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter();
            viewPager.setAdapter(myViewPagerAdapter);
            viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

            btnSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchHomeScreen();
                }
            });

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // checking for last page
                    // if last page home screen will be launched
                    int current = getItem(+1);
                    if (current < layouts.length) {
                        // move to next screen
                        viewPager.setCurrentItem(current);
                    } else {
                        launchHomeScreen();
                    }
                }
            });
        }

        private void addBottomDots(int currentPage) {
            TextView[] dots = new TextView[layouts.length];

            int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
            int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

            dotsLayout.removeAllViews();
            for (int i = 0; i < dots.length; i++) {
                dots[i] = new TextView(this);
                dots[i].setText(Html.fromHtml("&#8226;"));
                dots[i].setTextSize(35);
                dots[i].setTextColor(colorsInactive[currentPage]);
                dotsLayout.addView(dots[i]);
            }

            if (dots.length > 0)
                dots[currentPage].setTextColor(colorsActive[currentPage]);
        }

        private int getItem(int i) {
            return viewPager.getCurrentItem() + i;
        }

        private void launchHomeScreen() {
            prefManager.setFirstTimeLaunch(false);
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }

        //	viewpager change listener
        private final ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);

                // changing the next button text 'NEXT' / 'GOT IT'
                if (position == layouts.length - 1) {
                    // last page. make button text to GOT IT
                    btnNext.setText(getString(R.string.start));
                    btnSkip.setVisibility(View.GONE);
                } else {
                    // still pages are left
                    btnNext.setText(getString(R.string.next));
                    btnSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        };

        /**
         * Making notification bar transparent
         */
        private void changeStatusBarColor() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
        }

        /**
         * View pager adapter
         */
        public class MyViewPagerAdapter extends PagerAdapter {
            private LayoutInflater layoutInflater;

            @SuppressWarnings("WeakerAccess")
            public MyViewPagerAdapter() {
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                assert layoutInflater != null;
                View view = layoutInflater.inflate(layouts[position], container, false);
                container.addView(view);

                return view;
            }

            @Override
            public int getCount() {
                return layouts.length;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
                return view == obj;
            }


            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                View view = (View) object;
                container.removeView(view);
            }
        }
    }

**Lastly This will be your manifest file:**

    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        package="intro.developer.aero">

        <application
            android:label="@string/app_name"
            android:icon="@mipmap/ic_launcher"
            android:theme="@style/AppTheme"
            android:fullBackupContent="true"
            android:allowBackup="true"
            tools:ignore="GoogleAppIndexingWarning">

            <activity android:name=".WelcomeActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
            <activity
                android:name=".MainActivity"
                android:label="@string/title_activity_welcome"
                android:theme="@style/AppTheme.NoActionBar">
            </activity>
        </application>
    </manifest>
    
    **Output:**
    
    ![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Intro/art/IntroActivity.png)
