***Android drag/drop framework allows your users to move data from one View to another View in the current layout using a graphical drag and drop gesture. 
By using your own idea you can use this feature to move Fab button also.So let,s start with the tutorial.***

**Write this on your Strings File:**

    <resources>
        <string name="app_name">Draganddrop</string>
        <string name="longclick">Long click on image to move</string>
    </resources>

**Now we will create a MainActivity.java file under our package.**

    package draganddrop.developer.aero;

    import android.app.Activity;
    import android.content.ClipData;
    import android.content.ClipDescription;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.DragEvent;
    import android.view.MotionEvent;
    import android.view.View;
    import android.widget.ImageView;
    import android.widget.RelativeLayout;

    public class MainActivity extends Activity {
        ImageView img;
        String msg;
        private android.widget.RelativeLayout.LayoutParams layoutParams;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            img= findViewById(R.id.imageView);

            img.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
                    String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                    ClipData dragData = new ClipData(v.getTag().toString(),mimeTypes, item);
                    View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img);

                    v.startDrag(dragData,myShadow,null,0);
                    return true;
                }
            });

            img.setOnDragListener(new View.OnDragListener() {
                @Override
                public boolean onDrag(View v, DragEvent event) {
                    switch(event.getAction()) {
                        case DragEvent.ACTION_DRAG_STARTED:
                            layoutParams = (RelativeLayout.LayoutParams)v.getLayoutParams();
                            Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");

                            // Do nothing
                            break;

                        case DragEvent.ACTION_DRAG_ENTERED:
                            Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
                            //noinspection UnusedAssignment
                            int x_cord = (int) event.getX();
                            //noinspection UnusedAssignment
                            int y_cord = (int) event.getY();
                            break;

                        case DragEvent.ACTION_DRAG_EXITED :
                            Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
                            x_cord = (int) event.getX();
                            y_cord = (int) event.getY();
                            layoutParams.leftMargin = x_cord;
                            layoutParams.topMargin = y_cord;
                            v.setLayoutParams(layoutParams);
                            break;

                        case DragEvent.ACTION_DRAG_LOCATION  :
                            Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
                            //noinspection UnusedAssignment
                            x_cord = (int) event.getX();
                            //noinspection UnusedAssignment
                            y_cord = (int) event.getY();
                            break;

                        case DragEvent.ACTION_DRAG_ENDED   :
                            Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");

                            // Do nothing
                            break;

                        case DragEvent.ACTION_DROP:
                            Log.d(msg, "ACTION_DROP event");

                            // Do nothing
                            break;
                        default: break;
                    }
                    return true;
                }
            });

            img.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        ClipData data = ClipData.newPlainText("", "");
                        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img);

                        img.startDrag(data, shadowBuilder, img, 0);
                        img.setVisibility(View.INVISIBLE);
                        return true;
                    } else {
                        return false;
                    }
                }

            });
        }
    }

***I have not given you Drawable Folder Image You should apply your own.***
    
**After creating java file we will create activity_main in res/layout/activity_main**

    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <TextView

            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/longclick"
            android:layout_alignParentTop="true"
            android:layout_centerHorizontal="true"
            android:textSize="25sp" />


        <ImageView
            android:id="@+id/imageView"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:layout_below="@+id/textView"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="34dp"
            android:contentDescription="@string/app_name"
            android:src="@drawable/ic_android" />

    </RelativeLayout>

**And lastly this will be your manifest file:**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="draganddrop.developer.aero">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
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
 
