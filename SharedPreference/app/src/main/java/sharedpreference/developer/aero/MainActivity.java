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