***WebView is a view that display web pages inside your application. You can also specify HTML string and can show it inside your application using WebView. WebView makes turns your application to a web application.***

**Strings:**

    <resources>
        <string name="app_name">Webview</string>

        <string name="url">Enter URL</string>
        <string name="go">Go</string>
    </resources>

**Create layout file named activity_main:**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true"
        tools:context=".MainActivity">

        <Button
            android:id="@+id/go_search"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentEnd="true"
            android:layout_alignParentTop="true"
            android:text="@string/go" />

        <EditText
            android:id="@+id/textinput"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentStart="true"
            android:layout_alignParentTop="true"
            android:layout_toStartOf="@+id/go_search"
            android:focusable="true"
            android:hint="@string/url" />

        <WebView
            android:id="@+id/webView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_alignParentEnd="true"
            android:layout_alignParentStart="true"
            android:layout_below="@+id/go_search">
        </WebView>

    </RelativeLayout>

**Now we will create MainActivity.java file.**

    package webview.developer.aero;

    import android.annotation.SuppressLint;
    import android.app.Activity;
    import android.os.Bundle;
    import android.view.View;
    import android.webkit.WebView;
    import android.webkit.WebViewClient;
    import android.widget.Button;
    import android.widget.EditText;

    public class MainActivity extends Activity {
        private EditText ed1;
        private WebView webview;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button go = findViewById(R.id.go_search);
            ed1= findViewById(R.id.textinput);

            webview= findViewById(R.id.webView);
            webview.setWebViewClient(new MyBrowser());

            go.setOnClickListener(new View.OnClickListener() {

                @SuppressLint("SetJavaScriptEnabled")
                @Override
                public void onClick(View v) {
                    String url = ed1.getText().toString();
                    webview.getSettings().setLoadsImagesAutomatically(true);
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                    webview.loadUrl(url);
                }
            });
        }

        private class MyBrowser extends WebViewClient {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }
    }

**Now lastly this will be your manifest file:**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        package="webview.developer.aero">

        <uses-permission android:name="android.permission.INTERNET"/>

        <application
            android:label="@string/app_name"
            android:icon="@mipmap/ic_launcher"
            android:supportsRtl="true"
            android:theme="@style/AppTheme"
            android:allowBackup="true"
            android:fullBackupContent="@xml/backup_descriptor"
            tools:ignore="GoogleAppIndexingWarning">

            <activity
                android:name="webview.developer.aero.MainActivity"
                android:theme="@style/AppTheme">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>

    </manifest>

**Output:**    

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Webview/art/webview.png)
