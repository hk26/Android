***In this tutorial we will learn to add facebook comment in app. Facebook comment plugin gives you to add comment in your app . So let's start with the tutorial :***

**This will be your Strings.xml :**

    <resources>
        <string name="app_name">Facebook Comments</string>
        <string name="title_activity_comments">Comments</string>
        <string name="action_comment">Comment</string>
        <string name="action_refresh">Reload</string>
    </resources>

**And now create a layout file in res -> layout -> activity_main.xml :**

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/main_content"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@android:color/white"
        android:fitsSystemWindows="true">

        <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            app:layout_collapseMode="pin"
            app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />

        <WebView
            android:id="@+id/web_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_gravity="center_horizontal"
            app:layout_behavior="@string/appbar_scrolling_view_behavior" />

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom|end"
            android:layout_margin="@dimen/fab_margin"
            android:src="@drawable/ic_insert_comment_white_24dp" />

    </android.support.design.widget.CoordinatorLayout> 

**Now create activity_fb_comments.xml layout file :**

    <android.support.design.widget.CoordinatorLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true"
        tools:context=".FbCommentsActivity">

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

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            app:layout_behavior="@string/appbar_scrolling_view_behavior">

            <FrameLayout
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:id="@+id/webview_frame"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:ignore="UselessParent">

                <WebView
                    android:id="@+id/commentsView"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_gravity="center_horizontal" />

                <ProgressBar
                    android:id="@+id/progressBar"
                    android:layout_width="30dp"
                    android:layout_height="30dp"
                    android:layout_gravity="center"
                    android:layout_marginBottom="10dp"
                    android:indeterminateTint="@color/colorPrimary"
                    android:indeterminateTintMode="src_atop"
                    tools:targetApi="lollipop" />

            </FrameLayout>
        </LinearLayout>

    </android.support.design.widget.CoordinatorLayout>
    
**Now we will create Java files in our package . Create MainActivity.java file :**

    package facebook.developer.aero;

    import android.content.Intent;
    import android.os.Bundle;
    import android.support.design.widget.FloatingActionButton;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.webkit.WebView;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            WebView webView = findViewById(R.id.web_view);

            FloatingActionButton fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // launching facebook comments activity
                    Intent intent = new Intent(MainActivity.this, FbCommentsActivity.class);

                    // passing the article url
                    intent.putExtra("url", "http://akshuandroid.info");
                    startActivity(intent);
                }
            });

            // loading web page
            String url = "http://akshuandroid.info";
            webView.loadUrl(url);
        }
    }
    
**Create Another java file named. FbCommentsActivity.java file :**

    package facebook.developer.aero;

    import android.annotation.SuppressLint;
    import android.net.Uri;
    import android.net.http.SslError;
    import android.os.Build;
    import android.os.Bundle;
    import android.os.Handler;
    import android.os.Message;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.text.TextUtils;
    import android.util.Log;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.view.ViewGroup;
    import android.webkit.ConsoleMessage;
    import android.webkit.CookieManager;
    import android.webkit.SslErrorHandler;
    import android.webkit.WebChromeClient;
    import android.webkit.WebSettings;
    import android.webkit.WebView;
    import android.webkit.WebViewClient;
    import android.widget.FrameLayout;
    import android.widget.ProgressBar;
    import android.widget.Toast;

    import java.util.Objects;

    public class FbCommentsActivity extends AppCompatActivity {
        private static String TAG = FbCommentsActivity.class.getSimpleName();
        private WebView mWebViewComments;
        private FrameLayout mContainer;
        private ProgressBar progressBar;
        boolean isLoading;
        private WebView mWebviewPop;
        private String postUrl;

        // the default number of comments should be visible
        // on page load.
        private static final int NUMBER_OF_COMMENTS = 5;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fb_comments);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            }

            mWebViewComments = findViewById(R.id.commentsView);
            mContainer = findViewById(R.id.webview_frame);
            progressBar = findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);

            postUrl = getIntent().getStringExtra("url");

            // finish the activity in case of empty url
            if (TextUtils.isEmpty(postUrl)) {
                Toast.makeText(getApplicationContext(), "The web url shouldn't be empty", Toast.LENGTH_LONG).show();
                finish();
                return;
            }

            setLoading(true);
            loadComments();
        }

        @SuppressLint("SetJavaScriptEnabled")
        private void loadComments() {
            mWebViewComments.setWebViewClient(new UriWebViewClient());
            mWebViewComments.setWebChromeClient(new UriChromeClient());
            mWebViewComments.getSettings().setJavaScriptEnabled(true);
            mWebViewComments.getSettings().setAppCacheEnabled(true);
            mWebViewComments.getSettings().setDomStorageEnabled(true);
            mWebViewComments.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            mWebViewComments.getSettings().setSupportMultipleWindows(true);
            mWebViewComments.getSettings().setSupportZoom(false);
            mWebViewComments.getSettings().setBuiltInZoomControls(false);
            CookieManager.getInstance().setAcceptCookie(true);
            if (Build.VERSION.SDK_INT >= 21) {
                mWebViewComments.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
                CookieManager.getInstance().setAcceptThirdPartyCookies(mWebViewComments, true);
            }

            // facebook comment widget including the article url
            String html = "<!doctype html> <html lang=\"en\"> <head></head> <body> " +
                    "<div id=\"fb-root\"></div> <script>(function(d, s, id) { var js, fjs = d.getElementsByTagName(s)[0]; if (d.getElementById(id)) return; js = d.createElement(s); js.id = id; js.src = \"//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.6\"; fjs.parentNode.insertBefore(js, fjs); }(document, 'script', 'facebook-jssdk'));</script> " +
                    "<div class=\"fb-comments\" data-href=\"" + postUrl + "\" " +
                    "data-numposts=\"" + NUMBER_OF_COMMENTS + "\" data-order-by=\"reverse_time\">" +
                    "</div> </body> </html>";

            mWebViewComments.loadDataWithBaseURL("http://akshuandroid.info", html, "text/html", "UTF-8", null);
            mWebViewComments.setMinimumHeight(200);
        }

        private void setLoading(boolean isLoading) {
            this.isLoading = isLoading;

            if (isLoading)
                progressBar.setVisibility(View.VISIBLE);
            else
                progressBar.setVisibility(View.GONE);

            invalidateOptionsMenu();
        }

        private class UriWebViewClient extends WebViewClient {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                String host = Uri.parse(url).getHost();

                return !host.equals("m.facebook.com");

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //noinspection unused
                String host = Uri.parse(url).getHost();
                setLoading(false);
                if (url.contains("/plugins/close_popup.php?reload")) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Do something after 100ms
                            mContainer.removeView(mWebviewPop);
                            loadComments();
                        }
                    }, 600);
                }
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler,
                                           SslError error) {
                setLoading(false);
            }
        }

        class UriChromeClient extends WebChromeClient {

            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog,
                                          boolean isUserGesture, Message resultMsg) {
                mWebviewPop = new WebView(getApplicationContext());
                mWebviewPop.setVerticalScrollBarEnabled(false);
                mWebviewPop.setHorizontalScrollBarEnabled(false);
                mWebviewPop.setWebViewClient(new UriWebViewClient());
                mWebviewPop.setWebChromeClient(this);
                mWebviewPop.getSettings().setJavaScriptEnabled(true);
                mWebviewPop.getSettings().setDomStorageEnabled(true);
                mWebviewPop.getSettings().setSupportZoom(false);
                mWebviewPop.getSettings().setBuiltInZoomControls(false);
                mWebviewPop.getSettings().setSupportMultipleWindows(true);
                mWebviewPop.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                mContainer.addView(mWebviewPop);
                WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
                transport.setWebView(mWebviewPop);
                resultMsg.sendToTarget();

                return true;
            }

            @Override
            public boolean onConsoleMessage(ConsoleMessage cm) {
                Log.i(TAG, "onConsoleMessage: " + cm.message());
                return true;
            }

            @Override
            public void onCloseWindow(WebView window) {
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            if (!isLoading) {
                getMenuInflater().inflate(R.menu.fb_comments, menu);
            }

            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == android.R.id.home) {
                onBackPressed();
                return true;
            }

            if (item.getItemId() == R.id.action_refresh) {
                mWebViewComments.reload();
            }

            return super.onOptionsItemSelected(item);
        }
    }
    
**And this will be your Manifest.xml file :

    <manifest
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        package="facebook.developer.aero">

        <uses-permission android:name="android.permission.INTERNET"/>

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme"
            android:fullBackupContent="@xml/backup_descriptor"
            tools:ignore="GoogleAppIndexingWarning">
            <activity android:name=".MainActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
            <activity
                android:name=".FbCommentsActivity"
                android:label="@string/title_activity_comments"
                android:theme="@style/AppTheme.NoActionBar" />
        </application>

    </manifest>
    
**Output :**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Facebookcommentwidget/art/device-2018-04-23-122409.png)    

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Facebookcommentwidget/art/device-2018-04-23-122340.png)
