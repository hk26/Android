***You have seen in some apps that they have a Bottom Sheet Activity when you proceed to payment gateway or many other things. So in this tutorial you will learn to create BottomSheet Activity.***

**Download the drawable folder images and put it in your res -> drawable. I have given you the links for download:**

**Strings.xml**

		<resources>
			<string name="app_name">Bottom Sheet</string>
			<string name="action_settings">Settings</string>

			<string name="order_details">Order Details</string>
			<string name="price">₹435.00</string>
			<string name="fried">Chicken Fried Rice 1x1</string>
			<string name="tikka">Paneer Tikka 1x2</string>
			<string name="address">Delivery Address</string>
			<string name="address1">Flat No 8, Amrapali Apartments</string>
			<string name="payment">Proceed Payment</string>

			<string name="show_bottom_sheet">Show Bottom Sheet</string>
			<string name="show_bottom_sheet_dialog">Show Bottom Sheet Dialog</string>
			<string name="show_bottom_sheet_dialog_fragment">Show Bottom Sheet Dialog Fragment</string>

			<string name="preview">Preview</string>
			<string name="share">Share</string>
			<string name="get_link">Get link</string>
			<string name="make_a_copy">Make a Copy</string>
			<string name="eamil_a_copy">Email a Copy</string>
			<!-- TODO: Remove or change this placeholder text -->
			<string name="hello_blank_fragment">Hello blank fragment</string>
		</resources>

**Color.xml**

		<?xml version="1.0" encoding="utf-8"?>
		<resources>
			<color name="colorPrimary">#e9e154</color>
			<color name="colorPrimaryDark">#ccc549</color>
			<color name="colorAccent">#FF4081</color>
		</resources>


**Styles.xml**

		<resources>

			<!-- Base application theme. -->
			<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
				<!-- Customize your theme here. -->
				<item name="colorPrimary">@color/colorPrimary</item>
				<item name="colorPrimaryDark">@color/colorPrimaryDark</item>
				<item name="colorAccent">@color/colorAccent</item>
			</style>

			<style name="AppTheme.NoActionBar">
				<item name="windowActionBar">false</item>
				<item name="windowNoTitle">true</item>
			</style>

			<style name="AppTheme.AppBarOverlay" parent="ThemeOverlay.AppCompat.Dark.ActionBar" />

			<style name="AppTheme.PopupOverlay" parent="ThemeOverlay.AppCompat.Light" />

		</resources>

**Dimens.xml**

		<resources>
			<dimen name="fab_margin">16dp</dimen>
			<dimen name="activity_margin">16dp</dimen>
		</resources>

**Now we will create layout files. So create activity_main layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:background="#efefef"
			tools:context=".MainActivity"
			tools:ignore="Overdraw">

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

			<!-- Adding bottom sheet after main content -->
			<include layout="@layout/bottom_sheet" />

		</android.support.design.widget.CoordinatorLayout>		

**Now create bottom_sheet layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			android:id="@+id/bottom_sheet"
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:background="#fff"
			android:orientation="vertical"
			android:padding="@dimen/activity_margin"
			app:behavior_hideable="true"
			app:behavior_peekHeight="56dp"
			app:layout_behavior="android.support.design.widget.BottomSheetBehavior"
			tools:ignore="Overdraw">

			<LinearLayout
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:orientation="horizontal"
				android:layout_gravity="center_vertical"
				android:weightSum="3">

				<TextView
					android:layout_width="0dp"
					android:layout_height="wrap_content"
					android:layout_marginBottom="@dimen/activity_margin"
					android:layout_weight="2"
					android:text="@string/order_details"
					android:textColor="#444"
					android:textSize="18sp"
					android:textStyle="bold" />

				<TextView
					android:layout_width="0dp"
					android:gravity="end"
					android:layout_height="wrap_content"
					android:layout_weight="1"
					android:textStyle="bold"
					android:textSize="15sp"
					android:text="@string/price">

				</TextView>
			</LinearLayout>


			<TextView
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:text="@string/fried" />

			<TextView
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:text="@string/tikka" />

			<TextView
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:layout_marginTop="@dimen/activity_margin"
				android:text="@string/address"
				android:textColor="#444"
				android:textStyle="bold" />

			<TextView
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:text="@string/address1" />

			<Button
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:layout_marginTop="30dp"
				android:background="#000"
				android:foreground="?attr/selectableItemBackground"
				android:text="@string/payment"
				android:textColor="#fff" />

		</LinearLayout>	

**Now create content_main layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:orientation="vertical"
			app:layout_behavior="@string/appbar_scrolling_view_behavior"
			tools:context=".MainActivity"
			tools:showIn="@layout/activity_main">

			<Button
				android:id="@+id/btn_bottom_sheet"
				android:layout_width="wrap_content"
				android:layout_marginTop="@dimen/activity_margin"
				android:layout_gravity="center_horizontal"
				android:layout_height="wrap_content"
				android:text="@string/show_bottom_sheet" />

			<Button
				android:id="@+id/btn_bottom_sheet_dialog"
				android:layout_width="wrap_content"
				android:layout_marginTop="@dimen/activity_margin"
				android:layout_gravity="center_horizontal"
				android:layout_height="wrap_content"
				android:text="@string/show_bottom_sheet_dialog" />

			<Button
				android:id="@+id/btn_bottom_sheet_dialog_fragment"
				android:layout_width="wrap_content"
				android:layout_gravity="center_horizontal"
				android:layout_marginTop="@dimen/activity_margin"
				android:layout_height="wrap_content"
				android:text="@string/show_bottom_sheet_dialog_fragment" />

		</LinearLayout>

**Now create fragment_bottom_sheet_dialog layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:orientation="vertical"
			android:paddingBottom="8dp"
			android:paddingTop="8dp">

			<!-- NOTE: This list should be displayed in a list
			instead of nested layouts -->

			<LinearLayout
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:clickable="true"
				android:foreground="?attr/selectableItemBackground"
				android:orientation="horizontal"
				android:paddingBottom="8dp"
				android:paddingLeft="@dimen/activity_margin"
				android:paddingRight="@dimen/activity_margin"
				android:paddingTop="8dp"
				android:focusable="true"
				tools:ignore="UseCompoundDrawables">

				<ImageView
					android:layout_width="24dp"
					android:layout_height="24dp"
					android:layout_marginEnd="32dp"
					android:src="@drawable/ic_remove_red_eye_black_24dp"
					android:tint="#737373"
					android:contentDescription="@string/app_name" />

				<TextView
					android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:layout_gravity="center_vertical"
					android:text="@string/preview"
					android:textColor="#737373"
					android:textSize="16sp" />

			</LinearLayout>

			<LinearLayout
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:clickable="true"
				android:foreground="?attr/selectableItemBackground"
				android:orientation="horizontal"
				android:paddingBottom="8dp"
				android:paddingLeft="@dimen/activity_margin"
				android:paddingRight="@dimen/activity_margin"
				android:paddingTop="8dp"
				tools:ignore="UseCompoundDrawables"
				android:focusable="true">

				<ImageView
					android:layout_width="24dp"
					android:layout_height="24dp"
					android:layout_marginEnd="32dp"
					android:src="@drawable/ic_share_black_24dp"
					android:tint="#737373"
					android:contentDescription="@string/app_name" />

				<TextView
					android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:layout_gravity="center_vertical"
					android:text="@string/share"
					android:textColor="#737373"
					android:textSize="16sp" />

			</LinearLayout>

			<LinearLayout
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:clickable="true"
				android:foreground="?attr/selectableItemBackground"
				android:orientation="horizontal"
				android:paddingBottom="8dp"
				android:paddingLeft="@dimen/activity_margin"
				android:paddingRight="@dimen/activity_margin"
				android:paddingTop="8dp"
				tools:ignore="UseCompoundDrawables"
				android:focusable="true">

				<ImageView
					android:layout_width="24dp"
					android:layout_height="24dp"
					android:layout_marginEnd="32dp"
					android:src="@drawable/ic_link_black_24dp"
					android:tint="#737373"
					android:contentDescription="@string/app_name" />

				<TextView
					android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:layout_gravity="center_vertical"
					android:text="@string/get_link"
					android:textColor="#737373"
					android:textSize="16sp" />

			</LinearLayout>

			<LinearLayout
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:clickable="true"
				android:foreground="?attr/selectableItemBackground"
				android:orientation="horizontal"
				android:paddingBottom="8dp"
				android:paddingLeft="@dimen/activity_margin"
				android:paddingRight="@dimen/activity_margin"
				android:paddingTop="8dp"
				tools:ignore="UseCompoundDrawables"
				android:focusable="true">

				<ImageView
					android:layout_width="24dp"
					android:layout_height="24dp"
					android:layout_marginEnd="32dp"
					android:src="@drawable/ic_content_copy_black_24dp"
					android:tint="#737373"
					android:contentDescription="@string/app_name" />

				<TextView
					android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:layout_gravity="center_vertical"
					android:text="@string/make_a_copy"
					android:textColor="#737373"
					android:textSize="16sp" />

			</LinearLayout>

			<LinearLayout
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:clickable="true"
				android:foreground="?attr/selectableItemBackground"
				android:orientation="horizontal"
				android:paddingBottom="8dp"
				android:paddingLeft="@dimen/activity_margin"
				android:paddingRight="@dimen/activity_margin"
				android:paddingTop="8dp"
				tools:ignore="UseCompoundDrawables"
				android:focusable="true">

				<ImageView
					android:layout_width="24dp"
					android:layout_height="24dp"
					android:layout_marginEnd="32dp"
					android:src="@drawable/ic_email_black_24dp"
					android:tint="#737373"
					android:contentDescription="@string/app_name" />

				<TextView
					android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:layout_gravity="center_vertical"
					android:text="@string/eamil_a_copy"
					android:textColor="#737373"
					android:textSize="16sp" />

			</LinearLayout>

		</LinearLayout>

**Now we will create menu_main file in res/menu/menu_main:**

		<menu xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			tools:context="info.androidhive.bottomsheet.MainActivity">
			<item
				android:id="@+id/action_settings"
				android:orderInCategory="100"
				android:title="@string/action_settings"
				app:showAsAction="never" />
		</menu>

**Now we will create java files for our app. So create MainActivity.java file in your package:**		

		package bottomsheet.developer.aero;

		import android.annotation.SuppressLint;
		import android.os.Bundle;
		import android.support.annotation.NonNull;
		import android.support.design.widget.BottomSheetBehavior;
		import android.support.design.widget.BottomSheetDialog;
		import android.support.v7.app.AppCompatActivity;
		import android.support.v7.widget.Toolbar;
		import android.view.View;
		import android.widget.Button;
		import android.widget.LinearLayout;
		import butterknife.BindView;
		import butterknife.ButterKnife;
		import butterknife.OnClick;

		public class MainActivity extends AppCompatActivity {

			@BindView(R.id.btn_bottom_sheet)
			Button btnBottomSheet;

			@BindView(R.id.bottom_sheet)
			LinearLayout layoutBottomSheet;
			private BottomSheetBehavior sheetBehavior;

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				ButterKnife.bind(this);

				Toolbar toolbar = findViewById(R.id.toolbar);
				setSupportActionBar(toolbar);

				sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);

				sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
					@SuppressLint("SetTextI18n")
					@Override
					public void onStateChanged(@NonNull View bottomSheet, int newState) {
						switch (newState) {
							case BottomSheetBehavior.STATE_HIDDEN:
								break;
							case BottomSheetBehavior.STATE_EXPANDED: {
								btnBottomSheet.setText("Close Sheet");
							}
							break;
							case BottomSheetBehavior.STATE_COLLAPSED: {
								btnBottomSheet.setText("Expand Sheet");
							}
							break;
							case BottomSheetBehavior.STATE_DRAGGING:
								break;
							case BottomSheetBehavior.STATE_SETTLING:
								break;
						}
					}

					@Override
					public void onSlide(@NonNull View bottomSheet, float slideOffset) {

					}
				});
			}

			/**
			 * manually opening / closing bottom sheet on button click
			 */
			@SuppressWarnings("unused")
			@SuppressLint("SetTextI18n")
			@OnClick(R.id.btn_bottom_sheet)
			public void toggleBottomSheet() {
				if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
					sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
					btnBottomSheet.setText("Close sheet");
				} else {
					sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
					btnBottomSheet.setText("Expand sheet");
				}
			}

			/**
			 * showing bottom sheet dialog
			 */
			@SuppressWarnings("unused")
			@OnClick(R.id.btn_bottom_sheet_dialog)
			public void showBottomSheetDialog() {
				@SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.fragment_bottom_sheet_dialog, null);

				BottomSheetDialog dialog = new BottomSheetDialog(this);
				dialog.setContentView(view);
				dialog.show();
			}


			/**
			 * showing bottom sheet dialog fragment
			 * same layout is used in both dialog and dialog fragment
			 */
			@SuppressWarnings("unused")
			@OnClick(R.id.btn_bottom_sheet_dialog_fragment)
			public void showBottomSheetDialogFragment() {
				BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
				bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
			}
		}

**Now create BottomSheetFragment.java file:**

		package bottomsheet.developer.aero;

		import android.os.Bundle;
		import android.support.annotation.NonNull;
		import android.support.design.widget.BottomSheetDialogFragment;
		import android.view.LayoutInflater;
		import android.view.View;
		import android.view.ViewGroup;

		public class BottomSheetFragment extends BottomSheetDialogFragment {
			public BottomSheetFragment() {
				// Required empty public constructor
			}

			@SuppressWarnings("EmptyMethod")
			@Override
			public void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
			}

			@Override
			public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
									 Bundle savedInstanceState) {
				// Inflate the layout for this fragment
				return inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false);
			}
		}

**And finally this will be your Manifest file:**

		<?xml version="1.0" encoding="utf-8"?>
		<manifest xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			package="bottomsheet.developer.aero">

			<application
				android:allowBackup="true"
				android:icon="@mipmap/ic_launcher"
				android:label="@string/app_name"
				android:supportsRtl="true"
				android:theme="@style/AppTheme"
				android:fullBackupContent="@xml/backup_descriptor"
				tools:ignore="GoogleAppIndexingWarning">
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

Output:		

![alt text]()