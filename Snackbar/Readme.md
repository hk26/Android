**Snackbars provide lightweight feedback about an operation. They show a brief message at the bottom of the screen on mobile and lower left on larger devices. Snackbars appear above all other elements on screen and only one can be displayed at a time.***

**Strings.xml:**

    <resources>
        <string name="app_name">Snackbar</string>

        <string name="hello_world">Hello world!</string>
        <string name="action_settings">Settings</string>

        <string name="message1">Simple Snackbar</string>
        <string name="message2">With Action Callback</string>
        <string name="message3">Custom Color</string>
    </resources>

**Colors.xml:**

    <?xml version="1.0" encoding="utf-8"?>
    <resources>
        <color name="colorPrimary">#125688</color>
        <color name="colorPrimaryDark">#125688</color>
        <color name="textColorPrimary">#FFFFFF</color>
        <color name="windowBackground">#FFFFFF</color>
        <color name="navigationBarColor">#000000</color>
        <color name="colorAccent">#ee5350</color>
    </resources>

**Styles.xml:**

    <resources>

        <style name="MyMaterialTheme" parent="MyMaterialTheme.Base">

        </style>

        <style name="MyMaterialTheme.Base" parent="Theme.AppCompat.Light.DarkActionBar">
            <item name="windowNoTitle">true</item>
            <item name="windowActionBar">false</item>
            <item name="colorPrimary">@color/colorPrimary</item>
            <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
            <item name="colorAccent">@color/colorAccent</item>
        </style>

    </resources>

**Dimens.xml:**

    <resources>
        <!-- Default screen margins, per the Android Design guidelines. -->
        <dimen name="activity_horizontal_margin">16dp</dimen>
        <dimen name="activity_vertical_margin">16dp</dimen>
    </resources>

**Now we will create layout file create layout file in res -> layout -> activity_main:**

    <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/coordinatorLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <android.support.design.widget.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar">

            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                android:background="?attr/colorPrimary"
                app:layout_scrollFlags="scroll|enterAlways"
                app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />
        </android.support.design.widget.AppBarLayout>

        <LinearLayout
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:paddingLeft="20dp"
            android:paddingRight="20dp"
            app:layout_behavior="@string/appbar_scrolling_view_behavior">

            <Button
                android:id="@+id/btnSimpleSnackbar"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="30dp"
                android:text="@string/message1" />

            <Button
                android:id="@+id/btnActionCallback"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:text="@string/message2" />

            <Button
                android:id="@+id/btnCustomSnackbar"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:text="@string/message3" />

        </LinearLayout>

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="end|bottom"
            android:layout_margin="16dp"
            android:src="@android:drawable/ic_dialog_email" />

    </android.support.design.widget.CoordinatorLayout>

**Now create MainActivity.java file:**

    package snackbar.developer.aero;

    import android.graphics.Color;
    import android.support.design.widget.CoordinatorLayout;
    import android.support.design.widget.FloatingActionButton;
    import android.support.design.widget.Snackbar;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.support.v7.widget.Toolbar;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

        private CoordinatorLayout coordinatorLayout;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            coordinatorLayout = findViewById(R.id
                    .coordinatorLayout);

            //noinspection unused
            FloatingActionButton fab = findViewById(R.id.fab);

            Toolbar mToolbar = findViewById(R.id.toolbar);

            setSupportActionBar(mToolbar);

            Button btnSimpleSnackbar = findViewById(R.id.btnSimpleSnackbar);
            Button btnActionCallback = findViewById(R.id.btnActionCallback);
            Button btnCustomView = findViewById(R.id.btnCustomSnackbar);

            btnSimpleSnackbar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, "Welcome to aerodeveloper.info", Snackbar.LENGTH_LONG);

                    snackbar.show();
                }
            });

            btnActionCallback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, "Message is deleted", Snackbar.LENGTH_LONG)
                            .setAction("UNDO", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Message is restored!", Snackbar.LENGTH_SHORT);
                                    snackbar1.show();
                                }
                            });

                    snackbar.show();
                }
            });

            btnCustomView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                            .setAction("RETRY", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });

                    // Changing message text color
                    snackbar.setActionTextColor(Color.RED);

                    // Changing action button text color
                    View sbView = snackbar.getView();
                    TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);

                    snackbar.show();
                }
            });
        }
    }

**And finally this will be your manifest file:**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        package="snackbar.developer.aero">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:theme="@style/MyMaterialTheme"
            tools:ignore="GoogleAppIndexingWarning"
            android:fullBackupContent="@xml/backup_descriptor">
            <activity
                android:name=".MainActivity"
                android:label="@string/app_name" >
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>

    </manifest>

**Output:**

![alt text]()
