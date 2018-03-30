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
