***We have seen the Settings screen in many android apps through which you can configure the app preferences on your choice. For example you want to change the ringtone of your phone or other things.***

**I have not given you drawable resource file so you have to put your own.**

**Styles:**

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

**Colors:**

		<?xml version="1.0" encoding="utf-8"?>
		<resources>
			<color name="colorPrimary">#4b7eff</color>
			<color name="colorPrimaryDark">#4573e6</color>
			<color name="colorAccent">#d9ca29</color>
		</resources>

**Strings:**

		<resources xmlns:tools="http://schemas.android.com/tools">
			<string name="app_name">Preferences</string>
			<string name="action_settings">Settings</string>
			<string name="title_activity_settings">Settings</string>

			<string name="pref_title_ringtone">Ringtone</string>
			<string name="pref_ringtone_silent">Silent</string>

			<string name="setings_preference">Settings Preferences</string>
			<string name="overflow">Click on overflow icon to launch settings!</string>

			<string name="default_gallery_storage">My Videos</string>
			<string name="title_auto_upload">Auto upload</string>
			<string name="summary_upload_over_wifi">Upload the videos when wifi is available</string>
			<string name="title_upload_quality">Upload Quality</string>
			<string name="summary_upload_video_quality">Specify video quality for uploads</string>
			<string name="pref_title_notifications">Notifications</string>
			<string name="summary_choose_ringtone">Choose notification sound</string>
			<string name="pref_header_about">About</string>
			<string name="summary_about">We are a team of like-minded people, specialized in development of Android App Development creating new trends across the app space. Glad to Help in anyway!</string>
			<string name="app_version">1.0</string>
			<string name="summary_support">Got any queries? We are happy to help!</string>
			<string name="title_send_feedback">Send Feedback</string>
			<string name="title_faq">FAQ</string>
			<string name="summary_faq">View frequently asked questions</string>
			<string name="url_faq">http://www.androidhive.info/privacy-policy/</string>
			<string name="privacy_policy">Privacy Policy</string>
			<string name="url_privacy">http://www.androidhive.info/privacy-policy/</string>
			<string name="title_terms">Terms &amp; Conditions</string>
			<string name="url_terms">http://www.androidhive.info/terms-of-service/</string>
			<string name="title_version">Version</string>
			<string name="choose_email_client">Choose email client</string>
			<string name="title_gallery_storage">Default Storage</string>
			<string name="title_new_notification_sound">New message notification</string>
			<string name="title_vibrate">Vibrate</string>
			<string name="summary_vibrate">Vibrate on new notification</string>
			<string name="key_upload_over_wifi">key_upload_over_wifi</string>
			<string name="key_gallery_name">key_gallery_name</string>
			<string name="key_upload_quality">key_upload_quality</string>
			<string name="notifications_new_message">notifications_new_message</string>
			<string name="key_notifications_new_message_ringtone">key_notifications_new_message_ringtone</string>
			<string name="key_vibrate">key_vibrate</string>
			<string name="key_send_feedback">key_send_feedback</string>

			<!-- Strings related to Settings -->

			<!-- Example General settings -->
			<string name="pref_header_general">General</string>

			<string name="pref_title_social_recommendations">Enable social recommendations</string>
			<string name="pref_description_social_recommendations">Recommendations for people to contact
				based on your message history
			</string>

			<string name="pref_title_display_name">Display name</string>
			<string name="pref_default_display_name">John Smith</string>

			<string name="pref_title_add_friends_to_messages">Add friends to messages</string>
			<string-array name="pref_example_list_titles">
				<item>Always</item>
				<item>When possible</item>
				<item>Never</item>
			</string-array>
			<string-array name="pref_example_list_values">
				<item>1</item>
				<item>0</item>
				<item>-1</item>
			</string-array>

			<!-- Example settings for Data & Sync -->
			<string name="pref_header_data_sync">Data &amp; sync</string>

			<string name="pref_title_sync_frequency">Sync frequency</string>
			<string-array name="pref_sync_frequency_titles">
				<item>15 minutes</item>
				<item>30 minutes</item>
				<item>1 hour</item>
				<item>3 hours</item>
				<item>6 hours</item>
				<item>Never</item>
			</string-array>
			<string-array name="pref_sync_frequency_values">
				<item>15</item>
				<item>30</item>
				<item>60</item>
				<item>180</item>
				<item>360</item>
				<item>-1</item>
			</string-array>

			<string-array name="list_preference_entries" tools:ignore="UnusedResources">
				<item>Entry 1</item>
				<item>Entry 2</item>
				<item>Entry 3</item>
			</string-array>

			<string-array name="list_preference_entry_values" tools:ignore="UnusedResources">
				<item>1</item>
				<item>2</item>
				<item>3</item>
			</string-array>

			<string-array name="multi_select_list_preference_default_value" tools:ignore="UnusedResources" />

			<string name="pref_title_system_sync_settings">System sync settings</string>

			<!-- Example settings for Notifications -->
			<string name="pref_header_notifications">Notifications</string>

			<string name="pref_title_new_message_notifications">New message notifications</string>

			<string name="pref_title_vibrate">Vibrate</string>
			<string name="action_settings_headers">Settings with Headers</string>
		</resources>

		
**Arrays:**

		<?xml version="1.0" encoding="utf-8"?>
		<resources>
			<string-array name="pref_upload_quality_entries">
				<item>360p</item>
				<item>480p</item>
				<item>720p</item>
				<item>1080p</item>
				<item>Original</item>
			</string-array>
			<string-array name="pref_upload_quality_values">
				<item>0</item>
				<item>1</item>
				<item>2</item>
				<item>3</item>
				<item>4</item>
			</string-array>
		</resources>
		
	
**Now we will write xml folder files so create xml directory in res-> xml and create pref_general.xml in xml resource folder:**

		<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">

			<SwitchPreference
				android:defaultValue="true"
				android:key="example_switch"
				android:summary="@string/pref_description_social_recommendations"
				android:title="@string/pref_title_social_recommendations" />

			<!-- NOTE: EditTextPreference accepts EditText attributes. -->
			<!-- NOTE: EditTextPreference's summary should be set to its value by the activity code. -->
			<EditTextPreference
				android:capitalize="words"
				android:defaultValue="@string/pref_default_display_name"
				android:inputType="textCapWords"
				android:key="example_text"
				android:maxLines="1"
				android:selectAllOnFocus="true"
				android:singleLine="true"
				android:title="@string/pref_title_display_name" />

			<!-- NOTE: Hide buttons to simplify the UI. Users can touch outside the dialog to
				 dismiss it. -->
			<!-- NOTE: ListPreference's summary should be set to its value by the activity code. -->
			<ListPreference
				android:defaultValue="-1"
				android:entries="@array/pref_example_list_titles"
				android:entryValues="@array/pref_example_list_values"
				android:key="example_list"
				android:negativeButtonText="@null"
				android:positiveButtonText="@null"
				android:title="@string/pref_title_add_friends_to_messages" />

		</PreferenceScreen>

**create pref_headers.xml**

		<preference-headers xmlns:android="http://schemas.android.com/apk/res/android">

			<!-- These settings headers are only used on tablets. -->

			<header
				android:fragment="settings.developer.aero.SettingsHeadersActivity$GeneralPreferenceFragment"
				android:icon="@drawable/ic_info_black_24dp"
				android:title="@string/pref_header_general" />

			<header
				android:fragment="settings.developer.aero.SettingsHeadersActivity$NotificationPreferenceFragment"
				android:icon="@drawable/ic_notifications_black_24dp"
				android:title="@string/pref_header_notifications" />

			<header
				android:fragment="settings.developer.aero.SettingsHeadersActivity$DataSyncPreferenceFragment"
				android:icon="@drawable/ic_sync_black_24dp"
				android:title="@string/pref_header_data_sync" />

		</preference-headers>

**Create pref_main.xml**

		<?xml version="1.0" encoding="utf-8"?>
		<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">
			<PreferenceCategory android:title="General">
				<EditTextPreference
					android:defaultValue="@string/default_gallery_storage"
					android:key="@string/key_gallery_name"
					android:summary="@string/default_gallery_storage"
					android:title="@string/title_gallery_storage" />

				<CheckBoxPreference
					android:defaultValue="true"
					android:key="@string/key_upload_over_wifi"
					android:summary="@string/summary_upload_over_wifi"
					android:title="@string/title_auto_upload" />

				<ListPreference
					android:defaultValue="3"
					android:dialogTitle="@string/title_upload_quality"
					android:entries="@array/pref_upload_quality_entries"
					android:entryValues="@array/pref_upload_quality_values"
					android:key="@string/key_upload_quality"
					android:summary="@string/summary_upload_video_quality"
					android:title="@string/title_upload_quality" />

			</PreferenceCategory>

			<PreferenceCategory android:title="@string/pref_title_notifications">

				<SwitchPreference
					android:defaultValue="true"
					android:key="@string/notifications_new_message"
					android:title="@string/title_new_notification_sound" />

				<RingtonePreference
					android:defaultValue="content://settings/system/notification_sound"
					android:dependency="notifications_new_message"
					android:key="@string/key_notifications_new_message_ringtone"
					android:ringtoneType="notification"
					android:summary="@string/summary_choose_ringtone"
					android:title="@string/pref_title_ringtone" />

				<SwitchPreference
					android:defaultValue="true"
					android:key="@string/key_vibrate"
					android:summary="@string/summary_vibrate"
					android:title="@string/title_vibrate" />
			</PreferenceCategory>

			<PreferenceCategory android:title="@string/pref_header_about">



				<Preference
					android:summary="@string/app_version"
					android:title="@string/title_version" />

				<Preference
					android:key="@string/key_send_feedback"
					android:summary="@string/summary_support"
					android:title="@string/title_send_feedback" />




			</PreferenceCategory>

		</PreferenceScreen>

**Create pref_notification.xml**

		<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">

			<!-- A 'parent' preference, which enables/disables child preferences (below)
				 when checked/unchecked. -->
			<SwitchPreference
				android:defaultValue="true"
				android:key="notifications_new_message"
				android:title="@string/pref_title_new_message_notifications" />

			<!-- Allows the user to choose a ringtone in the 'notification' category. -->
			<!-- NOTE: This preference will be enabled only when the checkbox above is checked. -->
			<!-- NOTE: RingtonePreference's summary should be set to its value by the activity code. -->
			<RingtonePreference
				android:defaultValue="content://settings/system/notification_sound"
				android:dependency="notifications_new_message"
				android:key="notifications_new_message_ringtone"
				android:ringtoneType="notification"
				android:title="@string/pref_title_ringtone" />

			<!-- NOTE: This preference will be enabled only when the checkbox above is checked. -->
			<SwitchPreference
				android:defaultValue="true"
				android:dependency="notifications_new_message"
				android:key="notifications_new_message_vibrate"
				android:title="@string/pref_title_vibrate" />

		</PreferenceScreen>
		
**Create pref_data_sync.xml**

		<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">

			<!-- NOTE: Hide buttons to simplify the UI. Users can touch outside the dialog to
				 dismiss it. -->
			<!-- NOTE: ListPreference's summary should be set to its value by the activity code. -->
			<ListPreference
				android:defaultValue="180"
				android:entries="@array/pref_sync_frequency_titles"
				android:entryValues="@array/pref_sync_frequency_values"
				android:key="sync_frequency"
				android:negativeButtonText="@null"
				android:positiveButtonText="@null"
				android:title="@string/pref_title_sync_frequency" />

			<!-- This preference simply launches an intent when selected. Use this UI sparingly, per
				 design guidelines. -->
			<Preference android:title="@string/pref_title_system_sync_settings">
				<intent android:action="android.settings.SYNC_SETTINGS" />
			</Preference>

		</PreferenceScreen>

**Now we will create menu_main file in menu folder:**

		<menu xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			tools:context="info.androidhive.settings.MainActivity">

			<item
				android:id="@+id/action_settings"
				android:orderInCategory="100"
				android:title="@string/action_settings"
				app:showAsAction="never" />

			<item
				android:id="@+id/action_settings_headers"
				android:orderInCategory="101"
				android:title="@string/action_settings_headers"
				app:showAsAction="never" />
		</menu>

**Now we will create layout files. Create activity_main layout file:**

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

			<LinearLayout
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:layout_marginTop="100dp"
				android:gravity="center_horizontal"
				android:orientation="vertical"
				tools:ignore="UselessParent">

				<TextView
					android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:layout_marginTop="20dp"
					android:text="@string/setings_preference"
					android:textSize="30sp"
					android:textStyle="bold" />

				<TextView
					android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:layout_marginTop="20dp"
					android:text="@string/overflow"
					android:textColor="#b1b1b1" />
			</LinearLayout>
		</RelativeLayout>

**After creating layout files we will create Java files.So create MainActivity.java file:**

		package settings.developer.aero;

		import android.content.Intent;
		import android.os.Bundle;
		import android.support.v7.app.AppCompatActivity;
		import android.support.v7.widget.Toolbar;
		import android.view.Menu;
		import android.view.MenuItem;

		public class MainActivity extends AppCompatActivity {

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				Toolbar toolbar = findViewById(R.id.toolbar);
				setSupportActionBar(toolbar);
			}

			@Override
			public boolean onCreateOptionsMenu(Menu menu) {
				getMenuInflater().inflate(R.menu.menu_main, menu);
				return true;
			}

			@Override
			public boolean onOptionsItemSelected(MenuItem item) {
				int id = item.getItemId();

				if (id == R.id.action_settings) {
					// launch settings activity
					startActivity(new Intent(MainActivity.this, SettingsActivity.class));
					return true;
				}

				if (id == R.id.action_settings_headers) {
					// launch settings activity
					startActivity(new Intent(MainActivity.this, SettingsHeadersActivity.class));
					return true;
				}

				return super.onOptionsItemSelected(item);
			}
		}

**create AppCompatPreferenceActivity.java**

		package settings.developer.aero;

		import android.content.res.Configuration;
		import android.os.Bundle;
		import android.preference.PreferenceActivity;
		import android.support.annotation.LayoutRes;
		import android.support.annotation.NonNull;
		import android.support.annotation.Nullable;
		import android.support.v7.app.ActionBar;
		import android.support.v7.app.AppCompatDelegate;
		import android.support.v7.widget.Toolbar;
		import android.view.MenuInflater;
		import android.view.View;
		import android.view.ViewGroup;

		public abstract class AppCompatPreferenceActivity extends PreferenceActivity {

			private AppCompatDelegate mDelegate;

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				getDelegate().installViewFactory();
				getDelegate().onCreate(savedInstanceState);
				super.onCreate(savedInstanceState);
			}

			@Override
			protected void onPostCreate(Bundle savedInstanceState) {
				super.onPostCreate(savedInstanceState);
				getDelegate().onPostCreate(savedInstanceState);
			}

			ActionBar getSupportActionBar() {
				return getDelegate().getSupportActionBar();
			}

			@SuppressWarnings("unused")
			public void setSupportActionBar(@Nullable Toolbar toolbar) {
				getDelegate().setSupportActionBar(toolbar);
			}

			@NonNull
			@Override
			public MenuInflater getMenuInflater() {
				return getDelegate().getMenuInflater();
			}

			@Override
			public void setContentView(@LayoutRes int layoutResID) {
				getDelegate().setContentView(layoutResID);
			}

			@Override
			public void setContentView(View view) {
				getDelegate().setContentView(view);
			}

			@Override
			public void setContentView(View view, ViewGroup.LayoutParams params) {
				getDelegate().setContentView(view, params);
			}

			@Override
			public void addContentView(View view, ViewGroup.LayoutParams params) {
				getDelegate().addContentView(view, params);
			}

			@Override
			protected void onPostResume() {
				super.onPostResume();
				getDelegate().onPostResume();
			}

			@Override
			protected void onTitleChanged(CharSequence title, int color) {
				super.onTitleChanged(title, color);
				getDelegate().setTitle(title);
			}

			@Override
			public void onConfigurationChanged(Configuration newConfig) {
				super.onConfigurationChanged(newConfig);
				getDelegate().onConfigurationChanged(newConfig);
			}

			@Override
			protected void onStop() {
				super.onStop();
				getDelegate().onStop();
			}

			@Override
			protected void onDestroy() {
				super.onDestroy();
				getDelegate().onDestroy();
			}

			public void invalidateOptionsMenu() {
				getDelegate().invalidateOptionsMenu();
			}

			private AppCompatDelegate getDelegate() {
				if (mDelegate == null) {
					mDelegate = AppCompatDelegate.create(this, null);
				}
				return mDelegate;
			}
		}

**create SettingsActivity.java**

		package settings.developer.aero;

		import android.content.Context;
		import android.content.Intent;
		import android.content.pm.PackageManager;
		import android.media.Ringtone;
		import android.media.RingtoneManager;
		import android.net.Uri;
		import android.os.Build;
		import android.os.Bundle;
		import android.preference.EditTextPreference;
		import android.preference.ListPreference;
		import android.preference.Preference;
		import android.preference.PreferenceFragment;
		import android.preference.PreferenceManager;
		import android.preference.RingtonePreference;
		import android.text.TextUtils;
		import android.view.MenuItem;

		public class SettingsActivity extends AppCompatPreferenceActivity {

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				getSupportActionBar().setDisplayHomeAsUpEnabled(true);

				// load settings fragment
				getFragmentManager().beginTransaction().replace(android.R.id.content, new MainPreferenceFragment()).commit();
			}

			public static class MainPreferenceFragment extends PreferenceFragment {
				@Override
				public void onCreate(final Bundle savedInstanceState) {
					super.onCreate(savedInstanceState);
					addPreferencesFromResource(R.xml.pref_main);

					// gallery EditText change listener
					bindPreferenceSummaryToValue(findPreference(getString(R.string.key_gallery_name)));

					// notification preference change listener
					bindPreferenceSummaryToValue(findPreference(getString(R.string.key_notifications_new_message_ringtone)));

					// feedback preference click listener
					Preference myPref = findPreference(getString(R.string.key_send_feedback));
					myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
						public boolean onPreferenceClick(Preference preference) {
							sendFeedback(getActivity());
							return true;
						}
					});
				}
			}

			@Override
			public boolean onOptionsItemSelected(MenuItem item) {
				if (item.getItemId() == android.R.id.home) {
					onBackPressed();
				}
				return super.onOptionsItemSelected(item);
			}

			private static void bindPreferenceSummaryToValue(Preference preference) {
				preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

				sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
						PreferenceManager
								.getDefaultSharedPreferences(preference.getContext())
								.getString(preference.getKey(), ""));
			}

			/**
			 * A preference value change listener that updates the preference's summary
			 * to reflect its new value.
			 */
			private static final Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
				@Override
				public boolean onPreferenceChange(Preference preference, Object newValue) {
					String stringValue = newValue.toString();

					if (preference instanceof ListPreference) {
						// For list preferences, look up the correct display value in
						// the preference's 'entries' list.
						ListPreference listPreference = (ListPreference) preference;
						int index = listPreference.findIndexOfValue(stringValue);

						// Set the summary to reflect the new value.
						preference.setSummary(
								index >= 0
										? listPreference.getEntries()[index]
										: null);

					} else if (preference instanceof RingtonePreference) {
						// For ringtone preferences, look up the correct display value
						// using RingtoneManager.
						if (TextUtils.isEmpty(stringValue)) {
							// Empty values correspond to 'silent' (no ringtone).
							preference.setSummary(R.string.pref_ringtone_silent);

						} else {
							Ringtone ringtone = RingtoneManager.getRingtone(
									preference.getContext(), Uri.parse(stringValue));

							if (ringtone == null) {
								// Clear the summary if there was a lookup error.
								preference.setSummary(R.string.summary_choose_ringtone);
							} else {
								// Set the summary to reflect the new ringtone display
								// name.
								String name = ringtone.getTitle(preference.getContext());
								preference.setSummary(name);
							}
						}

					} else if (preference instanceof EditTextPreference) {
						if (preference.getKey().equals("key_gallery_name")) {
							// update the changed gallery name to summary filed
							preference.setSummary(stringValue);
						}
					} else {
						preference.setSummary(stringValue);
					}
					return true;
				}
			};

			/**
			 * Email client intent to send support mail
			 * Appends the necessary device information to email body
			 * useful when providing support
			 */
			private static void sendFeedback(Context context) {
				String body = null;
				//noinspection EmptyCatchBlock
				try {
					body = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
					body = "\n\n-----------------------------\nPlease don't remove this information\n Device OS: Android \n Device OS version: " +
							Build.VERSION.RELEASE + "\n App Version: " + body + "\n Device Brand: " + Build.BRAND +
							"\n Device Model: " + Build.MODEL + "\n Device Manufacturer: " + Build.MANUFACTURER;
				} catch (PackageManager.NameNotFoundException e) {
				}
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("message/rfc822");
				intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"tmasram1@gmail.com"});
				intent.putExtra(Intent.EXTRA_SUBJECT, "Query from android app");
				intent.putExtra(Intent.EXTRA_TEXT, body);
				context.startActivity(Intent.createChooser(intent, context.getString(R.string.choose_email_client)));
			}
		}


**create SettingsHeadersActivity.java**

		package settings.developer.aero;

		import android.annotation.TargetApi;
		import android.content.Context;
		import android.content.Intent;
		import android.content.res.Configuration;
		import android.media.Ringtone;
		import android.media.RingtoneManager;
		import android.net.Uri;
		import android.os.Build;
		import android.os.Bundle;
		import android.preference.ListPreference;
		import android.preference.Preference;
		import android.support.v7.app.ActionBar;
		import android.preference.PreferenceFragment;
		import android.preference.PreferenceManager;
		import android.preference.RingtonePreference;
		import android.text.TextUtils;
		import android.view.MenuItem;

		import java.util.List;

		public class SettingsHeadersActivity extends AppCompatPreferenceActivity {
			/**
			 * A preference value change listener that updates the preference's summary
			 * to reflect its new value.
			 */
			private static final Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
				@Override
				public boolean onPreferenceChange(Preference preference, Object value) {
					String stringValue = value.toString();

					if (preference instanceof ListPreference) {
						// For list preferences, look up the correct display value in
						// the preference's 'entries' list.
						ListPreference listPreference = (ListPreference) preference;
						int index = listPreference.findIndexOfValue(stringValue);

						// Set the summary to reflect the new value.
						preference.setSummary(
								index >= 0
										? listPreference.getEntries()[index]
										: null);

					} else if (preference instanceof RingtonePreference) {
						// For ringtone preferences, look up the correct display value
						// using RingtoneManager.
						if (TextUtils.isEmpty(stringValue)) {
							// Empty values correspond to 'silent' (no ringtone).
							preference.setSummary(R.string.pref_ringtone_silent);

						} else {
							Ringtone ringtone = RingtoneManager.getRingtone(
									preference.getContext(), Uri.parse(stringValue));

							if (ringtone == null) {
								// Clear the summary if there was a lookup error.
								preference.setSummary(null);
							} else {
								// Set the summary to reflect the new ringtone display
								// name.
								String name = ringtone.getTitle(preference.getContext());
								preference.setSummary(name);
							}
						}

					} else {
						// For all other preferences, set the summary to the value's
						// simple string representation.
						preference.setSummary(stringValue);
					}
					return true;
				}
			};

			/**
			 * Helper method to determine if the device has an extra-large screen. For
			 * example, 10" tablets are extra-large.
			 */
			private static boolean isXLargeTablet(Context context) {
				return (context.getResources().getConfiguration().screenLayout
						& Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
			}

			/**
			 * Binds a preference's summary to its value. More specifically, when the
			 * preference's value is changed, its summary (line of text below the
			 * preference title) is updated to reflect the value. The summary is also
			 * immediately updated upon calling this method. The exact display format is
			 * dependent on the type of preference.
			 *
			 * @see #sBindPreferenceSummaryToValueListener
			 */
			private static void bindPreferenceSummaryToValue(Preference preference) {
				// Set the listener to watch for value changes.
				preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

				// Trigger the listener immediately with the preference's
				// current value.
				sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
						PreferenceManager
								.getDefaultSharedPreferences(preference.getContext())
								.getString(preference.getKey(), ""));
			}

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setupActionBar();
			}

			/**
			 * Set up the {@link android.app.ActionBar}, if the API is available.
			 */
			private void setupActionBar() {
				ActionBar actionBar = getSupportActionBar();
				if (actionBar != null) {
					// Show the Up button in the action bar.
					actionBar.setDisplayHomeAsUpEnabled(true);
				}
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean onIsMultiPane() {
				return isXLargeTablet(this);
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			public void onBuildHeaders(List<Header> target) {
				loadHeadersFromResource(R.xml.pref_headers, target);
			}

			/**
			 * This method stops fragment injection in malicious applications.
			 * Make sure to deny any unknown fragments here.
			 */
			protected boolean isValidFragment(String fragmentName) {
				return PreferenceFragment.class.getName().equals(fragmentName)
						|| GeneralPreferenceFragment.class.getName().equals(fragmentName)
						|| DataSyncPreferenceFragment.class.getName().equals(fragmentName)
						|| NotificationPreferenceFragment.class.getName().equals(fragmentName);
			}

			/**
			 * This fragment shows general preferences only. It is used when the
			 * activity is showing a two-pane settings UI.
			 */
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			public static class GeneralPreferenceFragment extends PreferenceFragment {
				@Override
				public void onCreate(Bundle savedInstanceState) {
					super.onCreate(savedInstanceState);
					addPreferencesFromResource(R.xml.pref_general);
					setHasOptionsMenu(true);

					// Bind the summaries of EditText/List/Dialog/Ringtone preferences
					// to their values. When their values change, their summaries are
					// updated to reflect the new value, per the Android Design
					// guidelines.
					bindPreferenceSummaryToValue(findPreference("example_text"));
					bindPreferenceSummaryToValue(findPreference("example_list"));
				}

				@Override
				public boolean onOptionsItemSelected(MenuItem item) {
					int id = item.getItemId();
					if (id == android.R.id.home) {
						startActivity(new Intent(getActivity(), SettingsHeadersActivity.class));
						return true;
					}
					return super.onOptionsItemSelected(item);
				}
			}

			/**
			 * This fragment shows notification preferences only. It is used when the
			 * activity is showing a two-pane settings UI.
			 */
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			public static class NotificationPreferenceFragment extends PreferenceFragment {
				@Override
				public void onCreate(Bundle savedInstanceState) {
					super.onCreate(savedInstanceState);
					addPreferencesFromResource(R.xml.pref_notification);
					setHasOptionsMenu(true);

					// Bind the summaries of EditText/List/Dialog/Ringtone preferences
					// to their values. When their values change, their summaries are
					// updated to reflect the new value, per the Android Design
					// guidelines.
					bindPreferenceSummaryToValue(findPreference("notifications_new_message_ringtone"));
				}

				@Override
				public boolean onOptionsItemSelected(MenuItem item) {
					int id = item.getItemId();
					if (id == android.R.id.home) {
						startActivity(new Intent(getActivity(), SettingsHeadersActivity.class));
						return true;
					}
					return super.onOptionsItemSelected(item);
				}
			}

			/**
			 * This fragment shows data and sync preferences only. It is used when the
			 * activity is showing a two-pane settings UI.
			 */
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			public static class DataSyncPreferenceFragment extends PreferenceFragment {
				@Override
				public void onCreate(Bundle savedInstanceState) {
					super.onCreate(savedInstanceState);
					addPreferencesFromResource(R.xml.pref_data_sync);
					setHasOptionsMenu(true);

					// Bind the summaries of EditText/List/Dialog/Ringtone preferences
					// to their values. When their values change, their summaries are
					// updated to reflect the new value, per the Android Design
					// guidelines.
					bindPreferenceSummaryToValue(findPreference("sync_frequency"));
				}

				@Override
				public boolean onOptionsItemSelected(MenuItem item) {
					int id = item.getItemId();
					if (id == android.R.id.home) {
						startActivity(new Intent(getActivity(), SettingsHeadersActivity.class));
						return true;
					}
					return super.onOptionsItemSelected(item);
				}
			}
		}

**Now lastly this will be your maifest file:**

		<?xml version="1.0" encoding="utf-8"?>
		<manifest xmlns:android="http://schemas.android.com/apk/res/android"
			package="info.androidhive.settings">

			<application
				android:allowBackup="true"
				android:icon="@mipmap/ic_launcher"
				android:label="@string/app_name"
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
				<activity
					android:name=".SettingsHeadersActivity"
					android:label="@string/title_activity_settings" />
				<activity
					android:name=".SettingsActivity"
					android:label="@string/title_activity_settings" />
			</application>

		</manifest>

**Output:**

![alt text]()