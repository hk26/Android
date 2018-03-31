***This simple tutorial in which progress bar will be shown when a file is to be downloaded. The downloaded file will be in your internal phone storage. So let's start the tutorial.***

**Strings.xml:**

		<resources>
			<string name="app_name">Progressbar</string>
			<string name="download">Download File</string>
		</resources>

**Now create a layout file activity_main:**

		<?xml version="1.0" encoding="utf-8"?>
		<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
			android:layout_width="fill_parent"
			android:layout_height="fill_parent"
			android:orientation="vertical" >

			<!-- Download Button -->
			<Button android:id="@+id/btnProgressBar"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:text="@string/download"
				android:layout_marginTop="50dip"/>

			<!-- Image view to show image after downloading -->
			<ImageView android:id="@+id/my_image"
				android:layout_width="fill_parent"
				android:layout_height="wrap_content"
				android:contentDescription="@string/app_name" />

		</LinearLayout>

**This will be your MainActivity.java file:**

		package progressbar.developer.aero;

		import java.io.BufferedInputStream;
		import java.io.FileOutputStream;
		import java.io.InputStream;
		import java.io.OutputStream;
		import java.net.URL;
		import java.net.URLConnection;

		import android.annotation.SuppressLint;
		import android.app.Activity;
		import android.app.Dialog;
		import android.app.ProgressDialog;
		import android.graphics.drawable.Drawable;
		import android.os.AsyncTask;
		import android.os.Bundle;
		import android.os.Environment;
		import android.util.Log;
		import android.view.View;
		import android.widget.Button;
		import android.widget.ImageView;

		public class MainActivity extends Activity {

			// Progress Dialog
			private ProgressDialog pDialog;
			private ImageView my_image;
			// Progress dialog type (0 - for Horizontal progress bar)
			private static final int progress_bar_type = 0;

			// File url to download
			private static final String file_url = "https://github.com/AeroDeveloper/AeroProjects/blob/Images/Instagram.png";

			@Override
			public void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);

				// show progress bar button
				Button btnShowProgress = findViewById(R.id.btnProgressBar);
				// Image view to show image after downloading
				my_image = findViewById(R.id.my_image);
				/*
				 * Show Progress bar click event
				 *
				*/
				btnShowProgress.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// starting new Async Task
						new DownloadFileFromURL().execute(file_url);
					}
				});
			}

			/**
			 * Showing Dialog
			 * */


			@SuppressWarnings("deprecation")
			@Override
			protected Dialog onCreateDialog(int id) {
				switch (id) {
					case progress_bar_type:
						pDialog = new ProgressDialog(this);
						pDialog.setMessage("Downloading file. Please wait...");
						pDialog.setIndeterminate(false);
						pDialog.setMax(100);
						pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
						pDialog.setCancelable(true);
						pDialog.show();
						return pDialog;
					default:
						return null;
				}
			}

			/**
			 * Background Async Task to download file
			 * */
			@SuppressLint("StaticFieldLeak")
			class DownloadFileFromURL extends AsyncTask<String, String, String> {

				/**
				 * Before starting background thread
				 * Show Progress Bar Dialog
				 * */
				@Override
				protected void onPreExecute() {
					super.onPreExecute();
					//noinspection deprecation
					showDialog(progress_bar_type);
				}

				/**
				 * Downloading file in background thread
				 * */
				@Override
				protected String doInBackground(String... f_url) {
					int count;
					try {
						URL url = new URL(f_url[0]);
						URLConnection conection = url.openConnection();
						conection.connect();
						// getting file length
						int lenghtOfFile = conection.getContentLength();

						// input stream to read file - with 8k buffer
						InputStream input = new BufferedInputStream(url.openStream(), 8192);

						// Output stream to write file
						@SuppressLint("SdCardPath") OutputStream output = new FileOutputStream("/sdcard/downloadedfile.jpg");

						byte data[] = new byte[1024];

						long total = 0;

						while ((count = input.read(data)) != -1) {
							total += count;
							// publishing the progress....
							// After this onProgressUpdate will be called
							publishProgress(""+(int)((total*100)/lenghtOfFile));

							// writing data to file
							output.write(data, 0, count);
						}

						// flushing output
						output.flush();

						// closing streams
						output.close();
						input.close();

					} catch (Exception e) {
						Log.e("Error: ", e.getMessage());
					}

					return null;
				}

				/**
				 * Updating progress bar
				 * */
				protected void onProgressUpdate(String... progress) {
					// setting progress percentage
					pDialog.setProgress(Integer.parseInt(progress[0]));
				}

				/**
				 * After completing background task
				 * Dismiss the progress dialog
				 * **/
				@Override
				protected void onPostExecute(String file_url) {
					// dismiss the dialog after the file was downloaded
					//noinspection deprecation
					dismissDialog(progress_bar_type);

					// Displaying downloaded image into image view
					// Reading image path from sdcard
					String imagePath = Environment.getExternalStorageDirectory().toString() + "/downloadedfile.jpg";
					// setting downloaded into image view
					my_image.setImageDrawable(Drawable.createFromPath(imagePath));
				}

			}
		}
		
**And Lastly your Manifest file:**

		<?xml version="1.0" encoding="utf-8"?>
		<manifest xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			package="progressbar.developer.aero">

			<!-- Permission: Allow Connect to Internet -->
			<uses-permission android:name="android.permission.INTERNET" />

			<!-- Permission: Writing to SDCard -->
			<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

			<application
				android:allowBackup="true"
				android:icon="@mipmap/ic_launcher"
				android:label="@string/app_name"
				android:roundIcon="@mipmap/ic_launcher_round"
				android:supportsRtl="true"
				android:theme="@style/AppTheme"
				android:fullBackupContent="true"
				tools:ignore="GoogleAppIndexingWarning">
				<activity android:name=".MainActivity">
					<intent-filter>
						<action android:name="android.intent.action.MAIN" />

						<category android:name="android.intent.category.LAUNCHER" />
					</intent-filter>
				</activity>
			</application>

		</manifest>		

Output:

![alt text]()