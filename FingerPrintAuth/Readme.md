***Android 6.0 saw the introduction of fingerprint authentication, a new security feature that allows users to confirm their identify with a single touch. While this new security feature is most commonly used to secure the user’s lockscreen, fingerprint authentication can also be a useful addition to your apps, allowing you to secure sensitive features such as in-app payments, or replace password-and-username screens with a much more convenient single-touch sign in.***

**build.gradle(Module:app) file:**

		apply plugin: 'com.android.application'

		android {
			compileSdkVersion 27
			defaultConfig {
				applicationId "bottomnavigation.developer.aero"
				minSdkVersion 23
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

		dependencies {
			implementation fileTree(dir: 'libs', include: ['*.jar'])
			testImplementation 'junit:junit:4.12'
			androidTestImplementation 'com.android.support.test:runner:1.0.1'
			androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'


			implementation 'com.android.support:appcompat-v7:27.0.2'
			implementation 'com.android.support:design:27.0.2'
		}
		
***I have not given you drawable folder images so you can put your own image...***

**Strings:**

		<resources>
			<string name="app_name">Fingerprint</string>
			<string name="title_activity_main">MainActivity</string>
			<string name="title_fingerprint">One-touch Sign In</string>
			<string name="desc_fingerprint">Please place your fingertip on the scanner to verify your identity</string>
			<string name="note">(Fingerprint sign in makes your app login much faster. Your device should have at least one fingerprint registered in device settings)</string>
			<string name="title_activity_home">Fingerprint</string>
			<string name="welcome">Welcome</string>
			<string name="activity_home_desc">You have successfully logged in with fingerprint authentication</string>
			<string name="activity_home_note">Close and re-open the app to see the fingerprint auth screen again</string>
		</resources>

**Dimens:**

		<resources>
			<!-- Default screen margins, per the Android Design guidelines. -->
			<dimen name="activity_horizontal_margin">16dp</dimen>
			<dimen name="activity_vertical_margin">16dp</dimen>
			<dimen name="fab_margin">16dp</dimen>
		</resources>

**Colors:**

		<?xml version="1.0" encoding="utf-8"?>
		<resources>
			<color name="colorPrimary">#41c7ff</color>
			<color name="colorPrimaryDark">#38aada</color>
			<color name="colorAccent">#1e282d</color>
			<color name="textPrimary">#f5f5f5</color>
			<color name="textPrimaryDark">#95aab4</color>
			<color name="errorText">#ff7878</color>
		</resources>
		
**Styles:**

		<resources>

			<!-- Base application theme. -->
			<style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
				<!-- Customize your theme here. -->
				<item name="colorPrimary">@color/colorPrimary</item>
				<item name="colorPrimaryDark">@color/colorPrimaryDark</item>
				<item name="colorAccent">@color/colorAccent</item>
			</style>

			<style name="AppTheme.AppBarOverlay" parent="ThemeOverlay.AppCompat.Dark.ActionBar" />

			<style name="AppTheme.PopupOverlay" parent="ThemeOverlay.AppCompat.Light" />

		</resources>
		
**Now we will create a gradient file. and later we will use this in layout file as a background:

**So create gradient.xml file in drawable folder:**

		<?xml version="1.0" encoding="utf-8"?>
		<shape xmlns:android="http://schemas.android.com/apk/res/android">

			<gradient
				android:angle="90"
				android:startColor="@color/errorText"
				android:endColor="@color/colorPrimary">

			</gradient>

		</shape>

**Create activity_fingerprint layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			android:id="@+id/activity_fingerprint"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:background="@drawable/gradient"
			tools:context=".FingerprintActivity">

			<LinearLayout
				android:layout_width="match_parent"
				android:id="@+id/headerLayout"
				android:orientation="vertical"
				android:gravity="center"
				android:layout_marginTop="100dp"
				android:layout_height="wrap_content">

				<ImageView
					android:layout_width="70dp"
					android:layout_height="70dp"
					android:src="@drawable/ic_action_fingerprint"
					android:id="@+id/icon"
					android:paddingTop="2dp"
					android:layout_marginBottom="30dp"/>

				<TextView
					android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:textColor="@color/textPrimary"
					android:textSize="24sp"
					android:text="@string/title_fingerprint"
					android:layout_marginLeft="5dp"
					android:layout_marginRight="5dp"
					android:layout_marginTop="20dp"
					android:layout_marginBottom="10dp"/>


				<TextView
					android:layout_width="match_parent"
					android:layout_height="wrap_content"
					android:textColor="@color/textPrimary"
					android:textSize="16sp"
					android:textAlignment="center"
					android:gravity="center"
					android:id="@+id/desc"
					android:text="@string/desc_fingerprint"
					android:layout_margin="16dp"
					android:paddingEnd="30dp"
					android:paddingStart="30dp"/>

				<TextView
					android:layout_width="match_parent"
					android:layout_height="wrap_content"
					android:textColor="@color/errorText"
					android:textSize="14sp"
					android:textAlignment="center"
					android:id="@+id/errorText"
					android:paddingEnd="30dp"
					android:paddingStart="30dp"
					android:layout_marginTop="30dp"
					android:gravity="center"/>

			</LinearLayout>


			<TextView
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:textColor="@color/colorAccent"
				android:textSize="14sp"
				android:text="@string/note"
				android:layout_marginLeft="16dp"
				android:textAlignment="center"
				android:layout_marginRight="16dp"
				android:layout_marginBottom="26dp"
				android:layout_alignParentBottom="true"/>

		</RelativeLayout>

**Create activity_home layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:fitsSystemWindows="true"
			tools:context=".HomeActivity">

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

			<include layout="@layout/content_home" />

		</android.support.design.widget.CoordinatorLayout>

**Create content_home layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			android:id="@+id/content_home"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:paddingBottom="@dimen/activity_vertical_margin"
			android:paddingLeft="@dimen/activity_horizontal_margin"
			android:paddingRight="@dimen/activity_horizontal_margin"
			android:paddingTop="@dimen/activity_vertical_margin"
			app:layout_behavior="@string/appbar_scrolling_view_behavior"
			tools:context=".HomeActivity"
			tools:showIn="@layout/activity_home">

			<TextView
				android:layout_width="match_parent"
				android:text="@string/activity_home_desc"
				android:layout_centerVertical="true"
				android:textSize="24sp"
				android:textAlignment="center"
				android:textColor="@color/colorPrimary"
				android:layout_height="wrap_content"
				android:id="@+id/textView" />

			<TextView
				android:layout_width="match_parent"
				android:text="@string/activity_home_note"
				android:layout_alignParentBottom="true"
				android:textSize="14sp"
				android:textAlignment="center"
				android:textColor="@color/colorPrimary"
				android:layout_height="wrap_content"
				android:layout_marginBottom="24dp"/>

			<TextView
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:layout_alignParentStart="true"
				android:layout_alignParentTop="true"
				android:layout_marginTop="97dp"
				android:text="@string/welcome"
				android:textAlignment="center"
				android:textColor="@color/colorPrimary"
				android:textSize="35sp" />

		</RelativeLayout>

**Create HomeActivity.java file**

		package bottomnavigation.developer.aero;

		import android.os.Bundle;
		import android.support.v7.app.AppCompatActivity;
		import android.support.v7.widget.Toolbar;

		public class HomeActivity extends AppCompatActivity {

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_home);
				Toolbar toolbar = findViewById(R.id.toolbar);
				setSupportActionBar(toolbar);

			}

		}

**Create FingerprintActivity.java file:**

		package bottomnavigation.developer.aero;

		import android.Manifest;
		import android.annotation.SuppressLint;
		import android.annotation.TargetApi;
		import android.app.KeyguardManager;
		import android.content.pm.PackageManager;
		import android.hardware.fingerprint.FingerprintManager;
		import android.os.Build;
		import android.security.keystore.KeyGenParameterSpec;
		import android.security.keystore.KeyPermanentlyInvalidatedException;
		import android.security.keystore.KeyProperties;
		import android.support.v4.app.ActivityCompat;
		import android.support.v7.app.AppCompatActivity;
		import android.os.Bundle;
		import android.widget.TextView;
		import java.io.IOException;
		import java.security.InvalidAlgorithmParameterException;
		import java.security.InvalidKeyException;
		import java.security.KeyStore;
		import java.security.KeyStoreException;
		import java.security.NoSuchAlgorithmException;
		import java.security.NoSuchProviderException;
		import java.security.UnrecoverableKeyException;
		import java.security.cert.CertificateException;
		import javax.crypto.Cipher;
		import javax.crypto.KeyGenerator;
		import javax.crypto.NoSuchPaddingException;
		import javax.crypto.SecretKey;

		public class FingerprintActivity extends AppCompatActivity {

			private KeyStore keyStore;
			// Variable used for storing the key in the Android Keystore container
			private static final String KEY_NAME = "aerodeveloper";
			private Cipher cipher;

			@SuppressLint("SetTextI18n")
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_fingerprint);

				// Initializing both Android Keyguard Manager and Fingerprint Manager
				KeyguardManager keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
				FingerprintManager fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);

				TextView textView = findViewById(R.id.errorText);

				// Check whether the device has a Fingerprint sensor.
				assert fingerprintManager != null;
				if(!fingerprintManager.isHardwareDetected()){
					/*
					 ** An error message will be displayed if the device does not contain the fingerprint hardware.
					 * However if you plan to implement a default authentication method,
					 * you can redirect the user to a default authentication activity from here.
					 * Example:
					 * Intent intent = new Intent(this, DefaultAuthenticationActivity.class);
					 * startActivity(intent);
					 */
					textView.setText("Your Device does not have a Fingerprint Sensor");
				}else {
					// Checks whether fingerprint permission is set on manifest
					if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
						textView.setText("Fingerprint authentication permission not enabled");
					}else{
						// Check whether at least one fingerprint is registered
						if (!fingerprintManager.hasEnrolledFingerprints()) {
							textView.setText("Register at least one fingerprint in Settings");
						}else{
							// Checks whether lock screen security is enabled or not
							assert keyguardManager != null;
							if (!keyguardManager.isKeyguardSecure()) {
								textView.setText("Lock screen security not enabled in Settings");
							}else{
								generateKey();

								if (cipherInit()) {
									FingerprintManager.CryptoObject cryptoObject = new FingerprintManager.CryptoObject(cipher);
									FingerprintHandler helper = new FingerprintHandler(this);
									helper.startAuth(fingerprintManager, cryptoObject);
								}
							}
						}
					}
				}
			}

			@TargetApi(Build.VERSION_CODES.M)
			private void generateKey() {
				try {
					keyStore = KeyStore.getInstance("AndroidKeyStore");
				} catch (Exception e) {
					e.printStackTrace();
				}

				KeyGenerator keyGenerator;
				try {
					keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
				} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
					throw new RuntimeException("Failed to get KeyGenerator instance", e);
				}

				try {
					keyStore.load(null);
					keyGenerator.init(new
							KeyGenParameterSpec.Builder(KEY_NAME,
							KeyProperties.PURPOSE_ENCRYPT |
									KeyProperties.PURPOSE_DECRYPT)
							.setBlockModes(KeyProperties.BLOCK_MODE_CBC)
							.setUserAuthenticationRequired(true)
							.setEncryptionPaddings(
									KeyProperties.ENCRYPTION_PADDING_PKCS7)
							.build());
					keyGenerator.generateKey();
				} catch (NoSuchAlgorithmException |
						InvalidAlgorithmParameterException
						| CertificateException | IOException e) {
					throw new RuntimeException(e);
				}
			}

			@TargetApi(Build.VERSION_CODES.M)
			private boolean cipherInit() {
				try {
					cipher = Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES + "/" + KeyProperties.BLOCK_MODE_CBC + "/" + KeyProperties.ENCRYPTION_PADDING_PKCS7);
				} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
					throw new RuntimeException("Failed to get Cipher", e);
				}

				try {
					keyStore.load(null);
					SecretKey key = (SecretKey) keyStore.getKey(KEY_NAME,
							null);
					cipher.init(Cipher.ENCRYPT_MODE, key);
					return true;
				} catch (KeyPermanentlyInvalidatedException e) {
					return false;
				} catch (KeyStoreException | CertificateException | UnrecoverableKeyException | IOException | NoSuchAlgorithmException | InvalidKeyException e) {
					throw new RuntimeException("Failed to init Cipher", e);
				}
			}
		}		

**Create FingerprintHandler.java file:**

		package bottomnavigation.developer.aero;

		import android.Manifest;
		import android.app.Activity;
		import android.content.Context;
		import android.content.Intent;
		import android.content.pm.PackageManager;
		import android.hardware.fingerprint.FingerprintManager;
		import android.os.CancellationSignal;
		import android.support.v4.app.ActivityCompat;
		import android.widget.TextView;

		class FingerprintHandler extends FingerprintManager.AuthenticationCallback {

			private final Context context;

			// Constructor
			FingerprintHandler(Context mContext) {
				context = mContext;
			}

			void startAuth(FingerprintManager manager, FingerprintManager.CryptoObject cryptoObject) {
				CancellationSignal cancellationSignal = new CancellationSignal();
				if (ActivityCompat.checkSelfPermission(context, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
					return;
				}
				manager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
			}

			@Override
			public void onAuthenticationError(int errMsgId, CharSequence errString) {
				this.update("Fingerprint Authentication error\n" + errString);
			}

			@Override
			public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
				this.update("Fingerprint Authentication help\n" + helpString);
			}

			@Override
			public void onAuthenticationFailed() {
				this.update("Fingerprint Authentication failed.");
			}

			@Override
			public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
				((Activity) context).finish();
				Intent intent = new Intent(context, HomeActivity.class);
				context.startActivity(intent);
			}

			private void update(String e){
				TextView textView = ((Activity)context).findViewById(R.id.errorText);
				textView.setText(e);
			}

		}

**Now lastly we will write manifest file:**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        package="bottomnavigation.developer.aero">

        <uses-permission android:name="android.permission.USE_FINGERPRINT" />

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:supportsRtl="true"
            android:theme="@style/AppTheme"
            android:fullBackupContent="@xml/backup_descriptor"
            tools:ignore="GoogleAppIndexingWarning">
            <activity android:name=".FingerprintActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
            <activity
                android:name=".HomeActivity"
                android:label="@string/title_activity_home"
                android:theme="@style/AppTheme">
            </activity>
        </application>

    </manifest>

**Output:**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/FingerPrintAuth/art/fingerprint.png)
