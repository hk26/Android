***Shared Preference in Android are used to save data based on key-value pair. If we go deep into understanding of word: shared means to distribute data within and preference means something important or preferable, so SharedPreferences data is shared and preferred data.***

**Strings.xml :**

    <resources>
        <string name="app_name">SharedPreference</string>
        <string name="enter_name">Enter Name</string>
        <string name="enter_email">Enter Email</string>
        <string name="enter_phone">Enter Phone</string>
        <string name="store">STORE</string>
        <string name="fetch">FETCH</string>
        <string name="clear">CLEAR</string>
    </resources>

**Create ' activity_main ' layout file:**

    <RelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="20dp"
        android:orientation="vertical">


        <EditText
            android:id="@+id/etName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignParentStart="true"
            android:layout_alignParentTop="true"
            android:layout_marginTop="42dp"
            android:hint="@string/enter_name"
            android:inputType="textPersonName" />

        <EditText
            android:id="@+id/etEmail"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignParentStart="true"
            android:layout_below="@+id/etName"
            android:hint="@string/enter_email"
            android:inputType="textEmailAddress" />


        <EditText
            android:id="@+id/etPhone"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignParentStart="true"
            android:layout_below="@+id/etEmail"
            android:hint="@string/enter_phone"
            android:inputType="phone"
            android:maxLength="10" />


        <Button
            android:id="@+id/btnStore"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_alignParentStart="true"
            android:layout_marginBottom="148dp"
            android:layout_marginStart="29dp"
            android:background="#29b6f6"
            android:onClick="Store"
            android:text="@string/store"
            android:textColor="#fafafa" />

        <Button
            android:id="@+id/btnFetch"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignTop="@+id/btnStore"
            android:layout_centerHorizontal="true"
            android:background="#29b6f6"
            android:onClick="Fetch"
            android:text="@string/fetch"
            android:textColor="#fafafa" />

        <Button
            android:id="@+id/btnClear"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentEnd="true"
            android:layout_alignTop="@+id/btnStore"
            android:layout_marginEnd="31dp"
            android:background="#29b6f6"
            android:onClick="clear"
            android:text="@string/clear"
            android:textColor="#fafafa" />

        </RelativeLayout>

**Your MainActivity.java file :**

    package sharedpreference.developer.aero;

    import android.app.Activity;
    import android.content.Context;
    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.EditText;
    import android.widget.Toast;

    public class MainActivity extends Activity {
        private static final String mypreference = "mypref";
        private static final String Name = "person_name";
        private static final String Email = "email_add";
        private static final String Phone = "phone_no";
        private SharedPreferences sharedpreferences;
        private EditText et_name;
        private EditText et_email;
        private EditText et_phone;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            et_name = findViewById(R.id.etName);
            et_email = findViewById(R.id.etEmail);
            et_phone = findViewById(R.id.etPhone);
            sharedpreferences = getSharedPreferences(mypreference,
                    Context.MODE_PRIVATE);

            //Show data in EditTexts when app is launched, if data is there in Android Shared Preferences
            if (sharedpreferences.contains(Name))
                et_name.setText(sharedpreferences.getString(Name, ""));
            if (sharedpreferences.contains(Email))
                et_email.setText(sharedpreferences.getString(Email, ""));
            if (sharedpreferences.contains(Phone))
                et_phone.setText(sharedpreferences.getString(Phone, ""));
        }


        public void Store(@SuppressWarnings("unused") View view) {
            String n = et_name.getText().toString();
            String e = et_email.getText().toString();
            String p = et_phone.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(Name, n);
            editor.putString(Email, e);
            editor.putString(Phone, p);
            editor.apply();
            Toast.makeText(getApplicationContext(), "Data Stored Successfuly!", Toast.LENGTH_SHORT).show();
        }

        public void clear(@SuppressWarnings("unused") View view) {
            et_name = findViewById(R.id.etName);
            et_email = findViewById(R.id.etEmail);
            et_phone = findViewById(R.id.etPhone);
            et_name.setText("");
            et_email.setText("");
            et_phone.setText("");
            Toast.makeText(getApplicationContext(), "Data Cleared Successfuly!", Toast.LENGTH_SHORT).show();
        }

        public void Fetch(@SuppressWarnings("unused") View view) {
            et_name = findViewById(R.id.etName);
            et_email = findViewById(R.id.etEmail);
            et_phone = findViewById(R.id.etPhone);
            sharedpreferences = getSharedPreferences(mypreference,
                    Context.MODE_PRIVATE);

            if (sharedpreferences.contains(Name))
                et_name.setText(sharedpreferences.getString(Name, ""));
            if (sharedpreferences.contains(Email))
                et_email.setText(sharedpreferences.getString(Email, ""));
            if (sharedpreferences.contains(Phone))
                et_phone.setText(sharedpreferences.getString(Phone, ""));
            Toast.makeText(getApplicationContext(), "Data Displayed Successfuly!", Toast.LENGTH_SHORT).show();
        }
    }        
    
**Manifest.xml :**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="sharedpreference.developer.aero">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme">
            <activity android:name=".MainActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>

    </manifest>    