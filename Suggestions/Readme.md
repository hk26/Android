***In this tutorial you will learn to create a sample app that shows Text Suggestions you type. So let's start the tutorial :***

**Your Strings.xml file :**

    <resources>
        <string name="app_name">Suggestions</string>
        <string name="suggestions">Suggestions</string>
        <string name="enter_text">Enter Text</string>
    </resources>
    
**Now create ' activity_main ' layout file in res -> layout -> activity_main.xml :**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <TextView
            android:id="@+id/textview"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentTop="true"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="106dp"
            android:text="@string/suggestions"
            android:textSize="35sp" />

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_centerHorizontal="true"
            android:layout_marginBottom="73dp"
            android:text="@string/suggestions" />

        <EditText
            android:id="@+id/editText"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_centerHorizontal="true"
            android:layout_marginBottom="165dp"
            android:focusable="true"
            android:hint="@string/enter_text"
            android:inputType="text"
            android:textColorHighlight="#ff7eff15"
            android:textColorHint="#ffff25e6" />


        <TextView
            android:id="@+id/textView3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:text="@string/suggestions"
            android:textSize="25sp" />

    </RelativeLayout>    
    
**And now create java file in your package named as ' MainActivity.java ' :**

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
    
**And lastly this will be your Manifest.xml file :**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        package="suggestions.developer.aero">

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
        </application>

    </manifest>   

**Output :**

![alt text]()    
    
