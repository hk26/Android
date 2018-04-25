package suggestions.developer.aero;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SpellCheckerSession.SpellCheckerSessionListener {
    Button b1;
    TextView tv1;
    EditText ed1;
    private SpellCheckerSession mScs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= findViewById(R.id.button);
        tv1= findViewById(R.id.textView3);

        ed1= findViewById(R.id.editText);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        ed1.getText().toString(), Toast.LENGTH_SHORT).show();
                //noinspection deprecation
                mScs.getSuggestions(new TextInfo(ed1.getText().toString()), 3);
            }
        });
    }

    public void onResume() {
        super.onResume();
        final TextServicesManager tsm = (TextServicesManager)
                getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        assert tsm != null;
        mScs = tsm.newSpellCheckerSession(null, null, this, true);
    }

    public void onPause() {
        super.onPause();
        if (mScs != null) {
            mScs.close();
        }
    }

    public void onGetSuggestions(final SuggestionsInfo[] arg0) {
        final StringBuilder sb = new StringBuilder();

        for (SuggestionsInfo anArg0 : arg0) {
            // Returned suggestions are contained in SuggestionsInfo
            final int len = anArg0.getSuggestionsCount();
            sb.append('\n');

            for (int j = 0; j < len; ++j) {
                sb.append(",").append(anArg0.getSuggestionAt(j));
            }

            sb.append(" (").append(len).append(")");
        }

        runOnUiThread(new Runnable() {
            public void run() {
                tv1.append(sb.toString());
            }
        });
    }

    @Override
    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] arg0) {
        // TODO Auto-generated method stub
    }
}
