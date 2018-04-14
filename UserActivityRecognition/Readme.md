***In this tutorial we will create a simple app of User Activity Recognition like when when walking or running it will show in your app. So let's start the tutorial :***

**This is your build.gradle(Module:app) file :**

    apply plugin: 'com.android.application'

    android {
        compileSdkVersion 27
        defaultConfig {
            applicationId "useractivityrecognition.developer.aero"
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

    dependencies {
        implementation fileTree(dir: 'libs', include: ['*.jar'])
        implementation 'com.android.support:appcompat-v7:27.1.1'
        implementation 'com.android.support.constraint:constraint-layout:1.0.2'
        implementation 'com.android.support:design:27.1.1'
        testImplementation 'junit:junit:4.12'
        androidTestImplementation 'com.android.support.test:runner:1.0.1'
        androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'

        implementation 'com.google.android.gms:play-services-location:12.0.1'
    }
    
**Strings.xml :**

    <resources>
        <string name="app_name">Activity Recognition</string>
        <string name="activity_in_vehicle">In Vehicle</string>
        <string name="activity_on_bicycle">On Bicycle</string>
        <string name="activity_on_foot">On Foot</string>
        <string name="activity_running">Running</string>
        <string name="activity_still">Still</string>
        <string name="activity_tilting">Tilting</string>
        <string name="activity_walking">walking</string>
        <string name="activity_unknown">Unknown</string>
        <string name="start_tracking">Start Tracking</string>
        <string name="stop_tracking">Stop Tracking</string>
    </resources> 

***I have not given the drawable folder images. So i prefer to download the source code :****    
    
**Now we will create layout file for our app. Create ' activity_main ' in res -> layout -> activity_main :**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="16dp"
        tools:context=".MainActivity">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerHorizontal="true"
            android:orientation="vertical">

            <ImageView
                android:id="@+id/img_activity"
                android:layout_width="wrap_content"
                android:layout_height="200dp"
                android:tint="#606060"
                android:contentDescription="@string/app_name" />

            <TextView
                android:id="@+id/txt_activity"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_horizontal"
                android:textAllCaps="true"
                android:textColor="@color/colorPrimary"
                android:textSize="18sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/txt_confidence"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_horizontal"
                android:layout_marginTop="10dp"
                android:textAllCaps="true"
                android:textSize="14sp" />

        </LinearLayout>

        <Button
            android:id="@+id/btn_start_tracking"
            style="@style/Widget.AppCompat.Button.Borderless"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_alignParentStart="true"
            android:text="@string/start_tracking" />

        <Button
            android:id="@+id/btn_stop_tracking"
            style="@style/Widget.AppCompat.Button.Borderless"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_alignParentEnd="true"
            android:text="@string/stop_tracking"
            tools:ignore="RelativeOverlap" />
    </RelativeLayout>

**Now we will create java files for our. So create MainActivity.java file :**

    package useractivityrecognition.developer.aero;

    import android.annotation.SuppressLint;
    import android.content.BroadcastReceiver;
    import android.content.Context;
    import android.content.Intent;
    import android.content.IntentFilter;
    import android.os.Build;
    import android.support.v4.content.LocalBroadcastManager;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.TextView;

    import com.google.android.gms.location.DetectedActivity;

    import java.util.Objects;

    public class MainActivity extends AppCompatActivity {

        private final String TAG = MainActivity.class.getSimpleName();
        private BroadcastReceiver broadcastReceiver;

        private TextView txtActivity, txtConfidence;
        private ImageView imgActivity;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            txtActivity = findViewById(R.id.txt_activity);
            txtConfidence = findViewById(R.id.txt_confidence);
            imgActivity = findViewById(R.id.img_activity);
            Button btnStartTrcking = findViewById(R.id.btn_start_tracking);
            Button btnStopTracking = findViewById(R.id.btn_stop_tracking);

            btnStartTrcking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startTracking();
                }
            });

            btnStopTracking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    stopTracking();
                }
            });

            broadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        if (Objects.requireNonNull(intent.getAction()).equals(Constants.BROADCAST_DETECTED_ACTIVITY)) {
                            int type = intent.getIntExtra("type", -1);
                            int confidence = intent.getIntExtra("confidence", 0);
                            handleUserActivity(type, confidence);
                        }
                    }
                }
            };

            startTracking();
        }

        @SuppressLint("SetTextI18n")
        private void handleUserActivity(int type, int confidence) {
            String label = getString(R.string.activity_unknown);
            int icon = R.drawable.ic_still;

            switch (type) {
                case DetectedActivity.IN_VEHICLE: {
                    label = getString(R.string.activity_in_vehicle);
                    icon = R.drawable.ic_driving;
                    break;
                }
                case DetectedActivity.ON_BICYCLE: {
                    label = getString(R.string.activity_on_bicycle);
                    icon = R.drawable.ic_on_bicycle;
                    break;
                }
                case DetectedActivity.ON_FOOT: {
                    label = getString(R.string.activity_on_foot);
                    icon = R.drawable.ic_walking;
                    break;
                }
                case DetectedActivity.RUNNING: {
                    label = getString(R.string.activity_running);
                    icon = R.drawable.ic_running;
                    break;
                }
                case DetectedActivity.STILL: {
                    label = getString(R.string.activity_still);
                    break;
                }
                case DetectedActivity.TILTING: {
                    label = getString(R.string.activity_tilting);
                    icon = R.drawable.ic_tilting;
                    break;
                }
                case DetectedActivity.WALKING: {
                    label = getString(R.string.activity_walking);
                    icon = R.drawable.ic_walking;
                    break;
                }
                case DetectedActivity.UNKNOWN: {
                    label = getString(R.string.activity_unknown);
                    break;
                }
            }

            Log.e(TAG, "User activity: " + label + ", Confidence: " + confidence);

            if (confidence > Constants.CONFIDENCE) {
                txtActivity.setText(label);
                txtConfidence.setText("Confidence: " + confidence);
                imgActivity.setImageResource(icon);
            }
        }

        @Override
        protected void onResume() {
            super.onResume();

            LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,
                    new IntentFilter(Constants.BROADCAST_DETECTED_ACTIVITY));
        }

        @Override
        protected void onPause() {
            super.onPause();

            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }

        private void startTracking() {
            Intent intent = new Intent(MainActivity.this, BackgroundDetectedActivitiesService.class);
            startService(intent);
        }

        private void stopTracking() {
            Intent intent = new Intent(MainActivity.this, BackgroundDetectedActivitiesService.class);
            stopService(intent);
        }
    }


**Create  DetectedActivitiesIntentService.java file :**

    package useractivityrecognition.developer.aero;

    import android.app.IntentService;
    import android.content.Intent;
    import android.support.v4.content.LocalBroadcastManager;
    import android.util.Log;
    import com.google.android.gms.location.ActivityRecognitionResult;
    import com.google.android.gms.location.DetectedActivity;
    import java.util.ArrayList;

    public class DetectedActivitiesIntentService  extends IntentService {

        private static final String TAG = DetectedActivitiesIntentService.class.getSimpleName();

        public DetectedActivitiesIntentService() {
            // Use the TAG to name the worker thread.
            super(TAG);
        }

        @SuppressWarnings("EmptyMethod")
        @Override
        public void onCreate() {
            super.onCreate();
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void onHandleIntent(Intent intent) {
            ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);

            // Get the list of the probable activities associated with the current state of the
            // device. Each activity is associated with a confidence level, which is an int between
            // 0 and 100.
            ArrayList<DetectedActivity> detectedActivities = (ArrayList) result.getProbableActivities();

            for (DetectedActivity activity : detectedActivities) {
                Log.i(TAG, "Detected activity: " + activity.getType() + ", " + activity.getConfidence());
                broadcastActivity(activity);
            }
        }

        private void broadcastActivity(DetectedActivity activity) {
            Intent intent = new Intent(Constants.BROADCAST_DETECTED_ACTIVITY);
            intent.putExtra("type", activity.getType());
            intent.putExtra("confidence", activity.getConfidence());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }
   
**Create Constants.java file :**

    package useractivityrecognition.developer.aero;

    public class Constants {

        public static final String BROADCAST_DETECTED_ACTIVITY = "activity_intent";

        static final long DETECTION_INTERVAL_IN_MILLISECONDS = 5 * 1000;

        public static final int CONFIDENCE = 70;
    }

**Create BackgroundDetectedActivitiesService.java file :**

    package useractivityrecognition.developer.aero;

    import android.annotation.SuppressLint;
    import android.app.PendingIntent;
    import android.app.Service;
    import android.content.Intent;
    import android.os.Binder;
    import android.os.IBinder;
    import android.support.annotation.NonNull;
    import android.support.annotation.Nullable;
    import android.widget.Toast;
    import com.google.android.gms.location.ActivityRecognitionClient;
    import com.google.android.gms.tasks.OnFailureListener;
    import com.google.android.gms.tasks.OnSuccessListener;
    import com.google.android.gms.tasks.Task;

    public class BackgroundDetectedActivitiesService extends Service {
        @SuppressWarnings("unused")
        private static final String TAG = BackgroundDetectedActivitiesService.class.getSimpleName();

        private PendingIntent mPendingIntent;
        private ActivityRecognitionClient mActivityRecognitionClient;

        private final IBinder mBinder = new BackgroundDetectedActivitiesService.LocalBinder();

        public class LocalBinder extends Binder {
            @SuppressWarnings("unused")
            public BackgroundDetectedActivitiesService getServerInstance() {
                return BackgroundDetectedActivitiesService.this;
            }
        }

        public BackgroundDetectedActivitiesService() {

        }

        @SuppressLint("RestrictedApi")
        @Override
        public void onCreate() {
            super.onCreate();
            mActivityRecognitionClient = new ActivityRecognitionClient(this);
            Intent mIntentService = new Intent(this, DetectedActivitiesIntentService.class);
            mPendingIntent = PendingIntent.getService(this, 1, mIntentService, PendingIntent.FLAG_UPDATE_CURRENT);
            requestActivityUpdatesButtonHandler();
        }

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return mBinder;
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            super.onStartCommand(intent, flags, startId);
            return START_STICKY;
        }

        private void requestActivityUpdatesButtonHandler() {
            Task<Void> task = mActivityRecognitionClient.requestActivityUpdates(
                    Constants.DETECTION_INTERVAL_IN_MILLISECONDS,
                    mPendingIntent);

            task.addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void result) {
                    Toast.makeText(getApplicationContext(),
                            "Successfully requested activity updates",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            });

            task.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "Requesting activity updates failed to start",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }

        private void removeActivityUpdatesButtonHandler() {
            Task<Void> task = mActivityRecognitionClient.removeActivityUpdates(
                    mPendingIntent);
            task.addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void result) {
                    Toast.makeText(getApplicationContext(),
                            "Removed activity updates successfully!",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            });

            task.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Failed to remove activity updates!",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            removeActivityUpdatesButtonHandler();
        }
    }
 
**And lastly this will be your Manifest file :**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="useractivityrecognition.developer.aero">

        <uses-permission android:name="com.google.android.gms.permission.ACTIVITY_RECOGNITION" />

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

            <!-- Service that provides activity recognition data. Setting the android:exported attribute
            to "false" stops other apps from starting this service, even when using an explicit
            intent. -->
            <service
                android:name=".DetectedActivitiesIntentService"
                android:exported="false" />

            <service android:name=".BackgroundDetectedActivitiesService">

            </service>
        </application>

    </manifest> 

**Output :**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/UserActivityRecognition/art/activityrecognition.png)    
    
