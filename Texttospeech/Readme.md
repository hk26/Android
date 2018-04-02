***As you known about Text to speech out it is used in our phones to read the text that we write. So in this tutorial you will learn to make simple text to speech out app:***

**Now Create MainActivity.java file in your package:**

		package texttospeech.developer.aero;

		import android.app.Activity;
		import android.os.Bundle;
		import android.speech.tts.TextToSpeech;
		import android.view.View;
		import android.widget.Button;
		import android.widget.EditText;
		import java.util.Locale;
		import android.widget.Toast;

		public class MainActivity extends Activity {
			private TextToSpeech t1;
			private EditText ed1;

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				ed1= findViewById(R.id.editText);
				Button b1 = findViewById(R.id.button);

				t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
					@Override
					public void onInit(int status) {
						if(status != TextToSpeech.ERROR) {
							t1.setLanguage(Locale.UK);
						}
					}
				});

				b1.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						String toSpeak = ed1.getText().toString();
						Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
						t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
					}
				});
			}

			public void onPause(){
				if(t1 !=null){
					t1.stop();
					t1.shutdown();
				}
				super.onPause();
			}
		}

**Now we will create a layout file for our app. So create ' activity_main ' file in res\layout\activity_main**

		<?xml version="1.0" encoding="utf-8"?>
		<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			tools:context=".MainActivity"
			android:transitionGroup="true"
			tools:targetApi="lollipop">

			<TextView
				android:id="@+id/textview"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:layout_below="@+id/imageView"
				android:layout_centerHorizontal="true"
				android:layout_marginTop="74dp"
				android:text="@string/text"
				android:textSize="35sp" />

			<ImageView
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:id="@+id/imageView"
				android:layout_centerHorizontal="true"
				android:theme="@style/Base.TextAppearance.AppCompat"
				android:contentDescription="@string/app_name" />

			<EditText
				android:id="@+id/editText"
				android:hint="@string/enter"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:layout_alignParentEnd="true"
				android:layout_alignParentStart="true"
				android:layout_centerVertical="true"
				android:textColor="#000000"
				android:textColorHint="#919191"
				tools:ignore="LabelFor"
				android:inputType="text" />

			<Button
				android:id="@+id/button"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:layout_alignParentBottom="true"
				android:layout_centerHorizontal="true"
				android:layout_marginBottom="97dp"
				android:text="@string/text" />

			<TextView
				android:id="@+id/textView"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:layout_below="@+id/textview"
				android:layout_centerHorizontal="true"
				android:layout_marginTop="41dp"
				android:text="@string/entertext" />

		</RelativeLayout>

**Now write Strings.xml.**

		<resources>
			<string name="app_name">Texttospeech</string>
			<string name="text">Text to Speech</string>
			<string name="enter">Enter Some Text Here</string>
			<string name="entertext">Enter some text in textbox and click on the button below.</string>
		</resources>


**And finally this will be your AndroidManifest.xml**

		<?xml version="1.0" encoding="utf-8"?>
		<manifest xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			package="texttospeech.developer.aero">

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

**Output:**

![alt text]()
