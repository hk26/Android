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
