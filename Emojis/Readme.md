***Everyone known about emojis that are integrate in our keyboard many apps like Whatsapp and Hike use their own custom made emojis to make texting more interesting. So this will be the simple tutorial in which you will learn to integrate emojis in your keyboard.***

**Your build.gradle(Module:app) file:**

    apply plugin: 'com.android.application'

    android {
        compileSdkVersion 27
        defaultConfig {
            applicationId "emojis.developer.aero"
            minSdkVersion 17
            targetSdkVersion 27
            versionCode 1
            versionName "1.0"
            testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
        }
        buildTypes {
            release {
                minifyEnabled false
                proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
            }
        }
    }

    repositories {
        maven { url "https://dl.bintray.com/hani-momanii/maven"}
    }

    dependencies {
        compile fileTree(dir: 'libs', include: ['*.jar'])
        androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
            exclude group: 'com.android.support', module: 'support-annotations'
        })
        compile 'com.android.support:appcompat-v7:27.0.2'
        testCompile 'junit:junit:4.12'

        // Supernova Emoji
        compile 'hani.momanii.supernova_emoji_library:supernova-emoji-library:0.0.2'
    }

**Strings.xml:**

    <resources>
        <string name="app_name">Emojis</string>
        <string name="system">Use System Default</string>
        <string name="emojis">Emojis</string>
    </resources>

**Dimens.xml:**

    <resources>
        <!-- Default screen margins, per the Android Design guidelines. -->
        <dimen name="activity_horizontal_margin">16dp</dimen>
        <dimen name="activity_vertical_margin">16dp</dimen>
    </resources>

***I have not given you the drawable folder images.So i prefer to download the source code from github.com:***

**Now create a layout file named ' activity_main ' in res -> layout:**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:emojicon="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/root_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingBottom="@dimen/activity_vertical_margin"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        tools:context=".MainActivity">

        <ImageView
            android:id="@+id/emoji_btn"
            android:layout_width="40dp"
            android:layout_height="40dp"
            android:layout_alignParentBottom="true"
            android:layout_alignParentStart="true"
            android:padding="4dp"
            android:src="@drawable/ic_insert_emoticon_black_24dp"
            android:contentDescription="@string/app_name" />

        <ImageView
            android:id="@+id/submit_btn"
            android:layout_width="40dp"
            android:layout_height="40dp"
            android:layout_alignParentBottom="true"
            android:layout_alignParentEnd="true"
            android:padding="4dp"
            android:src="@android:drawable/ic_menu_send"
            android:contentDescription="@string/app_name" />

        <hani.momanii.supernova_emoji_library.Helper.EmojiconEditText
            android:id="@+id/emojicon_edit_text"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_toStartOf="@id/submit_btn"
            android:layout_toEndOf="@id/emoji_btn"
            emojicon:emojiconSize="28sp" />


        <CheckBox
            android:id="@+id/use_system_default"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@+id/textView"
            android:layout_centerHorizontal="true"
            android:checked="false"
            android:text="@string/system" />

        <hani.momanii.supernova_emoji_library.Helper.EmojiconTextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerHorizontal="true"
            android:layout_centerVertical="true"
            android:layout_marginTop="26dp"
            android:text="@string/emojis"
            android:textAppearance="@style/TextAppearance.AppCompat.Large"
            android:textColor="#000000"
            emojicon:emojiconSize="45sp"
            emojicon:emojiconUseSystemDefault="true" />
    </RelativeLayout>

**Your MainActivity.java file:**

    package emojis.developer.aero;

    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.util.Log;
    import android.view.View;
    import android.widget.CheckBox;
    import android.widget.CompoundButton;
    import android.widget.ImageView;

    import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
    import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;
    import hani.momanii.supernova_emoji_library.Helper.EmojiconTextView;

    public class MainActivity extends AppCompatActivity {

        private static final String TAG = MainActivity.class.getSimpleName();
        private EmojiconEditText emojiconEditText;
        private EmojiconTextView textView;
        private EmojIconActions emojIcon;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            View rootView = findViewById(R.id.root_view);
            ImageView emojiImageView = findViewById(R.id.emoji_btn);
            ImageView submitButton = findViewById(R.id.submit_btn);
            CheckBox mCheckBox = findViewById(R.id.use_system_default);
            emojiconEditText = findViewById(R.id.emojicon_edit_text);
            textView = findViewById(R.id.textView);
            emojIcon = new EmojIconActions(this, rootView, emojiconEditText, emojiImageView);
            emojIcon.ShowEmojIcon();
            emojIcon.setIconsIds(R.drawable.ic_action_keyboard, R.drawable.smiley);
            emojIcon.setKeyboardListener(new EmojIconActions.KeyboardListener() {
                @Override
                public void onKeyboardOpen() {
                    Log.e(TAG, "Keyboard opened!");
                }

                @Override
                public void onKeyboardClose() {
                    Log.e(TAG, "Keyboard closed");
                }
            });

            mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    emojIcon.setUseSystemEmoji(b);
                    textView.setUseSystemDefault(b);

                }
            });


            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newText = emojiconEditText.getText().toString();
                    textView.setText(newText);
                }
            });
        }
    }

**Manifest.xml:**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="emojis.developer.aero">

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