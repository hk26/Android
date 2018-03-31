***As of API 23 (Marshmallow), the permission model for Android has changed. Now, rather than all being setup at install-time, certain dangerous permissions must be checked and activated at runtime instead. So let's start with tutorial***

**Firstly write this dependencies in your build.gradle(Module:app) file:**

		 // dexter runtime permissions
		 implementation 'com.karumi:dexter:4.2.0'

**Now Create a MainActivity.java file:**

		package dexterpermissions.developer.aero;

		import android.Manifest;
		import android.content.DialogInterface;
		import android.content.Intent;
		import android.net.Uri;
		import android.os.Bundle;
		import android.provider.MediaStore;
		import android.provider.Settings;
		import android.support.v7.app.AlertDialog;
		import android.support.v7.app.AppCompatActivity;
		import android.support.v7.widget.Toolbar;
		import android.view.View;
		import android.widget.Button;
		import android.widget.Toast;
		import com.karumi.dexter.Dexter;
		import com.karumi.dexter.MultiplePermissionsReport;
		import com.karumi.dexter.PermissionToken;
		import com.karumi.dexter.listener.DexterError;
		import com.karumi.dexter.listener.PermissionDeniedResponse;
		import com.karumi.dexter.listener.PermissionGrantedResponse;
		import com.karumi.dexter.listener.PermissionRequest;
		import com.karumi.dexter.listener.PermissionRequestErrorListener;
		import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
		import com.karumi.dexter.listener.single.PermissionListener;

		import java.util.List;

		public class MainActivity extends AppCompatActivity {

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				Toolbar toolbar = findViewById(R.id.toolbar);
				setSupportActionBar(toolbar);

				Button btnCamera = findViewById(R.id.btn_camera);
				Button btnStorage = findViewById(R.id.btn_storage);

				btnCamera.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						requestCameraPermission();
					}
				});

				btnStorage.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						requestStoragePermission();
					}
				});
			}

			/**
			 * Requesting multiple permissions (storage and location) at once
			 * This uses multiple permission model from dexter
			 * On permanent denial opens settings dialog
			 */
			private void requestStoragePermission() {
				Dexter.withActivity(this)
						.withPermissions(
								Manifest.permission.READ_EXTERNAL_STORAGE,
								Manifest.permission.WRITE_EXTERNAL_STORAGE,
				Manifest.permission.ACCESS_FINE_LOCATION)
			.withListener(new MultiplePermissionsListener() {
			@Override
			public void onPermissionsChecked(MultiplePermissionsReport report) {
				// check if all permissions are granted
				if (report.areAllPermissionsGranted()) {
				Toast.makeText(getApplicationContext(), "All permissions are granted!", Toast.LENGTH_SHORT).show();
								}

								// check for permanent denial of any permission
								if (report.isAnyPermissionPermanentlyDenied()) {
									// show alert dialog navigating to Settings
									showSettingsDialog();
								}
							}

							@Override
							public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
								token.continuePermissionRequest();
							}
						}).
						withErrorListener(new PermissionRequestErrorListener() {
							@Override
							public void onError(DexterError error) {
								Toast.makeText(getApplicationContext(), "Error occurred! " + error.toString(), Toast.LENGTH_SHORT).show();
							}
						})
						.onSameThread()
						.check();
			}

			/**
			 * Requesting camera permission
			 * This uses single permission model from dexter
			 * Once the permission granted, opens the camera
			 * On permanent denial opens settings dialog
			 */
			private void requestCameraPermission() {
				Dexter.withActivity(this)
						.withPermission(Manifest.permission.CAMERA)
						.withListener(new PermissionListener() {
							@Override
							public void onPermissionGranted(PermissionGrantedResponse response) {
								// permission is granted
								openCamera();
							}

							@Override
							public void onPermissionDenied(PermissionDeniedResponse response) {
								// check for permanent denial of permission
								if (response.isPermanentlyDenied()) {
									showSettingsDialog();
								}
							}

							@Override
							public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
								token.continuePermissionRequest();
							}
						}).check();
			}

			/**
			 * Showing Alert Dialog with Settings option
			 * Navigates user to app settings
			 * NOTE: Keep proper title and message depending on your app
			 */
			private void showSettingsDialog() {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("Need Permissions");
				builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.");
				builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
						openSettings();
					}
				});
				builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
				builder.show();

			}

			// navigating user to app settings
			private void openSettings() {
				Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
				Uri uri = Uri.fromParts("package", getPackageName(), null);
				intent.setData(uri);
				startActivityForResult(intent, 101);
			}

			private void openCamera() {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, 100);
			}
		}

**Now we will create layout file. Create activity_main layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			tools:context=".MainActivity">

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

			<include layout="@layout/content_main" />

		</android.support.design.widget.CoordinatorLayout>
		
**Create content_main layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			app:layout_behavior="@string/appbar_scrolling_view_behavior"
			tools:context=".MainActivity"
			tools:showIn="@layout/activity_main">

			<TextView
				android:id="@+id/lbl_counter"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content" />

			<LinearLayout
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:layout_marginTop="100dp"
				android:orientation="vertical"
				android:layout_centerHorizontal="true"
				android:paddingLeft="16dp"
				android:paddingRight="16dp">

				<Button
					android:id="@+id/btn_camera"
					android:layout_width="match_parent"
					android:layout_height="wrap_content"
					android:layout_marginBottom="16dp"
					android:text="@string/camera" />

				<Button
					android:id="@+id/btn_storage"
					android:layout_width="match_parent"
					android:layout_height="wrap_content"
					android:text="@string/multiple" />

			</LinearLayout>

		</RelativeLayout>
		
**Create a menu_main file in menu directory:**

		<menu xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			tools:context="info.androidhive.dexterpermissions.MainActivity">
			<item
				android:id="@+id/action_settings"
				android:orderInCategory="100"
				android:title="@string/action_settings"
				app:showAsAction="never" />
		</menu>
		
**Write this in your Strings file:**

		<resources>
			<string name="app_name">Dexter Permissions</string>
			<string name="action_settings">Settings</string>
			<string name="camera">Camera Permission</string>
			<string name="multiple">Multiple Permission</string>
		</resources>

**And Lastly this will be your Manifest file:**

		<?xml version="1.0" encoding="utf-8"?>
		<manifest xmlns:android="http://schemas.android.com/apk/res/android"
			package="dexterpermissions.developer.aero">

			<uses-permission android:name="android.permission.CAMERA" />

			<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />

			<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

			<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>


			<application
				android:allowBackup="true"
				android:icon="@mipmap/ic_launcher"
				android:label="@string/app_name"
				android:roundIcon="@mipmap/ic_launcher_round"
				android:supportsRtl="true"
				android:theme="@style/AppTheme">
				<activity
					android:name=".MainActivity"
					android:label="@string/app_name"
					android:theme="@style/AppTheme.NoActionBar">
					<intent-filter>
						<action android:name="android.intent.action.MAIN" />

						<category android:name="android.intent.category.LAUNCHER" />
					</intent-filter>
				</activity>
			</application>

		</manifest>		
		
**Output:**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/DexterPermissions/art/dexterpermissions.png)
