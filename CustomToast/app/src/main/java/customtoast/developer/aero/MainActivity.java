package customtoast.developer.aero;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonToast);

        button.setOnClickListener(new OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View arg0) {

                // get your custom_toast.xml ayout
                LayoutInflater inflater = getLayoutInflater();

                View layout = inflater.inflate(R.layout.custom_toast,
                        (ViewGroup) findViewById(R.id.custom_toast_layout_id));

                // set a dummy image
                ImageView image = layout.findViewById(R.id.image);
                image.setImageResource(R.mipmap.ic_launcher);

                // set a message
                TextView text = layout.findViewById(R.id.text);
                text.setText("Button is clicked!");

                // Toast...
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });
    }
}
