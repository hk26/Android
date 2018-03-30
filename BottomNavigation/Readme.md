***Bottom navigation bars make it easy to explore and switch between top-level views in a single tap. Tapping on a bottom navigation icon takes you directly to the associated view or refreshes the currently active view.***

**Strings:**

		<resources>
			<string name="app_name">Bottom Navigation</string>
			<string name="title_shop">Shop</string>
			<string name="title_gifts">Gifts</string>
			<string name="title_cart">Cart</string>
			<string name="title_profile">Profile</string>
			<string name="cart">My Cart</string>
			<string name="gifts">My Gifts</string>
			<string name="profile">My Profile</string>
			<string name="store">My Store</string>
		</resources>

**Colors:**

		<?xml version="1.0" encoding="utf-8"?>
		<resources>
			<color name="colorPrimary">#4bc9ff</color>
			<color name="colorPrimaryDark">#43b1e1</color>
			<color name="colorAccent">#9c40ff</color>
			<color name="bgBottomNavigation">#7c33ca</color>
		</resources>

**Styles:**

		<resources>

			<!-- Base application theme. -->
			<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
				<!-- Customize your theme here. -->
				<item name="colorPrimary">@color/colorPrimary</item>
				<item name="colorPrimaryDark">@color/colorPrimaryDark</item>
				<item name="colorAccent">@color/colorAccent</item>
			</style>

		</resources>


**Dimens:**

		<resources>
			<!-- Default screen margins, per the Android Design guidelines. -->
			<dimen name="activity_horizontal_margin">16dp</dimen>


			<dimen name="card_margin">5dp</dimen>
			<dimen name="card_album_radius">0dp</dimen>
			<dimen name="card_cover_height">130dp</dimen>
			<dimen name="card_title_padding">10dp</dimen>
			<dimen name="card_price_padding_bottom">5dp</dimen>
		</resources>

**Now we will create activity_main layout file**

		<?xml version="1.0" encoding="utf-8"?>
		<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			android:id="@+id/container"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			tools:context=".MainActivity">

			<FrameLayout
				android:id="@+id/frame_container"
				android:layout_width="match_parent"
				android:layout_height="match_parent"
				app:layout_behavior="@string/appbar_scrolling_view_behavior" />

			<android.support.design.widget.BottomNavigationView
				android:id="@+id/navigation"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:layout_gravity="bottom"
				android:background="?android:attr/windowBackground"
				app:itemBackground="@color/bgBottomNavigation"
				android:foreground="?attr/selectableItemBackground"
				app:itemIconTint="@android:color/white"
				app:itemTextColor="@android:color/white"
				app:menu="@menu/navigation" />

		</android.support.design.widget.CoordinatorLayout>


**create fragment_cart layout file:**

		<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			tools:context=".fragment.CartFragment">

			<TextView
				android:layout_width="match_parent"
				android:layout_height="match_parent"
				android:gravity="center"
				android:text="@string/cart"
				android:textSize="22sp" />

		</FrameLayout>
		
**create fragment_gifts layout file:**

		<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			tools:context=".fragment.GiftsFragment">

			<TextView
				android:layout_width="match_parent"
				android:layout_height="match_parent"
				android:text="@string/gifts"
				android:gravity="center"
				android:textSize="22sp" />

		</FrameLayout>

**create fragment_profile layout file:**

		<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			tools:context=".fragment.ProfileFragment">

			<TextView
				android:layout_width="match_parent"
				android:layout_height="match_parent"
				android:gravity="center"
				android:text="@string/profile"
				android:textSize="22sp" />

		</FrameLayout>
	
**create fragment_store layout file:**

		<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			tools:context=".fragment.CartFragment">

			<TextView
				android:layout_width="match_parent"
				android:layout_height="match_parent"
				android:gravity="center"
				android:text="@string/store"
				android:textSize="22sp" />

		</FrameLayout>

**create store_item_row layout file:**

		<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:card_view="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="wrap_content">

			<android.support.v7.widget.CardView
				android:id="@+id/card_view"
				android:layout_width="match_parent"
				android:layout_height="match_parent"
				android:layout_gravity="center"
				android:layout_margin="@dimen/card_margin"
				android:clickable="true"
				android:elevation="3dp"
				android:foreground="?attr/selectableItemBackground"
				card_view:cardCornerRadius="@dimen/card_album_radius"
				android:focusable="true"
				tools:targetApi="lollipop">

				<RelativeLayout
					android:layout_width="match_parent"
					android:layout_height="match_parent">

					<ImageView
						android:id="@+id/thumbnail"
						android:layout_width="match_parent"
						android:layout_height="@dimen/card_cover_height"
						android:background="?attr/selectableItemBackgroundBorderless"
						android:clickable="true"
						android:scaleType="fitXY"
						android:contentDescription="@string/app_name"
						android:focusable="true" />

					<TextView
						android:id="@+id/title"
						android:layout_width="match_parent"
						android:layout_height="wrap_content"
						android:layout_below="@id/thumbnail"
						android:lines="2"
						android:paddingLeft="@dimen/card_title_padding"
						android:paddingRight="@dimen/card_title_padding"
						android:paddingTop="@dimen/card_title_padding"
						android:textColor="#111"
						android:textSize="12sp"/>

					<TextView
						android:id="@+id/price"
						android:layout_width="match_parent"
						android:layout_height="wrap_content"
						android:layout_below="@id/title"
						android:layout_marginEnd="10dp"
						android:gravity="right"
						android:paddingBottom="@dimen/card_price_padding_bottom"
						android:textColor="@color/colorAccent"
						android:textSize="12sp"
						tools:ignore="RtlHardcoded" />

				</RelativeLayout>

			</android.support.v7.widget.CardView>

		</LinearLayout>		

		
***Now we will write java files. we will make 2 folders under your package	'fragment' and 'helper'. Now we will write java files under fragment folder. I have given below screenshot how the package will look:***

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/BottomNavigation/art/androidstudio.PNG)

***Now we will write all files under fragment directory:*** 

**Create ProfileFragment.java**

		package bottomnavigation.developer.aero.fragment;

		import android.os.Bundle;
		import android.support.annotation.NonNull;
		import android.support.v4.app.Fragment;
		import android.view.LayoutInflater;
		import android.view.View;
		import android.view.ViewGroup;

		import bottomnavigation.developer.aero.R;

		public class ProfileFragment extends Fragment {

			public ProfileFragment() {
				// Required empty public constructor
			}

			@SuppressWarnings("unused")
			public static ProfileFragment newInstance(String param1, String param2) {
				ProfileFragment fragment = new ProfileFragment();
				Bundle args = new Bundle();
				fragment.setArguments(args);
				return fragment;
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
				return inflater.inflate(R.layout.fragment_profile, container, false);
			}
		}

**create StoreFragment.java**

		package bottomnavigation.developer.aero.fragment;

		import android.os.Bundle;
		import android.support.annotation.NonNull;
		import android.support.v4.app.Fragment;
		import android.view.LayoutInflater;
		import android.view.View;
		import android.view.ViewGroup;
		import bottomnavigation.developer.aero.R;

		public class StoreFragment extends Fragment {

			private static final String TAG = StoreFragment.class.getSimpleName();

			@SuppressWarnings("unused")
			public static CartFragment newInstance(String param1, String param2) {
				CartFragment fragment = new CartFragment();
				Bundle args = new Bundle();
				fragment.setArguments(args);
				return fragment;
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
				return inflater.inflate(R.layout.fragment_store, container, false);
			}
		}

**create CastFragment.java**

		package bottomnavigation.developer.aero.fragment;

		import android.os.Bundle;
		import android.support.annotation.NonNull;
		import android.support.v4.app.Fragment;
		import android.view.LayoutInflater;
		import android.view.View;
		import android.view.ViewGroup;
		import bottomnavigation.developer.aero.R;

		public class CartFragment extends Fragment {

			public CartFragment() {
				// Required empty public constructor
			}

			@SuppressWarnings("unused")
			public static CartFragment newInstance(String param1, String param2) {
				CartFragment fragment = new CartFragment();
				Bundle args = new Bundle();
				fragment.setArguments(args);
				return fragment;
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
				return inflater.inflate(R.layout.fragment_cart, container, false);
			}
		}

**create GiftsFragment.java**

		package bottomnavigation.developer.aero.fragment;

		import android.os.Bundle;
		import android.support.annotation.NonNull;
		import android.support.v4.app.Fragment;
		import android.view.LayoutInflater;
		import android.view.View;
		import android.view.ViewGroup;
		import bottomnavigation.developer.aero.R;

		public class GiftsFragment extends Fragment {

			public GiftsFragment() {
				// Required empty public constructor
			}

			@SuppressWarnings("unused")
			public static GiftsFragment newInstance(String param1, String param2) {
				GiftsFragment fragment = new GiftsFragment();
				Bundle args = new Bundle();
				fragment.setArguments(args);
				return fragment;
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
				return inflater.inflate(R.layout.fragment_gifts, container, false);
			}

		}

Now we will create another folder named 'helper' under your package:

**Under helper folder write BottomNavigationBehavior.java**

		package bottomnavigation.developer.aero.helper;

		import android.content.Context;
		import android.support.annotation.NonNull;
		import android.support.design.widget.BottomNavigationView;
		import android.support.design.widget.CoordinatorLayout;
		import android.support.v4.view.ViewCompat;
		import android.util.AttributeSet;
		import android.view.View;
		import android.widget.FrameLayout;

		public class BottomNavigationBehavior extends CoordinatorLayout.Behavior<BottomNavigationView> {

			public BottomNavigationBehavior() {
				super();
			}

			@SuppressWarnings("unused")
			public BottomNavigationBehavior(Context context, AttributeSet attrs) {
				super(context, attrs);
			}

			@Override
			public boolean layoutDependsOn(CoordinatorLayout parent, BottomNavigationView child, View dependency) {
				return dependency instanceof FrameLayout;
			}

			@SuppressWarnings("deprecation")
			@Override
			public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomNavigationView child, @NonNull View directTargetChild, @NonNull View target, int nestedScrollAxes) {
				return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
			}

			@SuppressWarnings("deprecation")
			@Override
			public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomNavigationView child, @NonNull View target, int dx, int dy, @NonNull int[] consumed) {
				if (dy < 0) {
					showBottomNavigationView(child);
				} else if (dy > 0) {
					hideBottomNavigationView(child);
				}
			}

			private void hideBottomNavigationView(BottomNavigationView view) {
				view.animate().translationY(view.getHeight());
			}

			private void showBottomNavigationView(BottomNavigationView view) {
				view.animate().translationY(0);
			}
		}


**And now we will write MainActivity.java file this file must be created under your package not in any other directory:**

**Now create MainActivity.java:**

		package bottomnavigation.developer.aero;

		import android.os.Bundle;
		import android.support.annotation.NonNull;
		import android.support.design.widget.BottomNavigationView;
		import android.support.design.widget.CoordinatorLayout;
		import android.support.v4.app.Fragment;
		import android.support.v4.app.FragmentTransaction;
		import android.support.v7.app.ActionBar;
		import android.support.v7.app.AppCompatActivity;
		import android.view.MenuItem;
		import bottomnavigation.developer.aero.fragment.CartFragment;
		import bottomnavigation.developer.aero.fragment.GiftsFragment;
		import bottomnavigation.developer.aero.fragment.ProfileFragment;
		import bottomnavigation.developer.aero.fragment.StoreFragment;
		import bottomnavigation.developer.aero.helper.BottomNavigationBehavior;

		public class MainActivity extends AppCompatActivity {

			private ActionBar toolbar;

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);

				toolbar = getSupportActionBar();

				BottomNavigationView navigation = findViewById(R.id.navigation);
				navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

				// attaching bottom sheet behaviour - hide / show on scroll
				CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
				layoutParams.setBehavior(new BottomNavigationBehavior());

				// load the store fragment by default
				toolbar.setTitle("Shop");
				loadFragment(new StoreFragment());
			}

			private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
					= new BottomNavigationView.OnNavigationItemSelectedListener() {

				@Override
				public boolean onNavigationItemSelected(@NonNull MenuItem item) {
					Fragment fragment;
					switch (item.getItemId()) {
						case R.id.navigation_shop:
							toolbar.setTitle("Shop");
							fragment = new StoreFragment();
							loadFragment(fragment);
							return true;
						case R.id.navigation_gifts:
							toolbar.setTitle("My Gifts");
							fragment = new GiftsFragment();
							loadFragment(fragment);
							return true;
						case R.id.navigation_cart:
							toolbar.setTitle("Cart");
							fragment = new CartFragment();
							loadFragment(fragment);
							return true;
						case R.id.navigation_profile:
							toolbar.setTitle("Profile");
							fragment = new ProfileFragment();
							loadFragment(fragment);
							return true;
					}

					return false;
				}
			};

			/**
			 * loading fragment into FrameLayout
			 *
			 * @param fragment
			 */
			@SuppressWarnings("JavaDoc")
			private void loadFragment(Fragment fragment) {
				// load fragment
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.replace(R.id.frame_container, fragment);
				transaction.addToBackStack(null);
				transaction.commit();
			}

		}

**create MyApplication.java**

		package bottomnavigation.developer.aero;

		import android.app.Application;
		import android.text.TextUtils;

		import com.android.volley.Request;
		import com.android.volley.RequestQueue;
		import com.android.volley.toolbox.Volley;

		public class MyApplication extends Application {

			private static final String TAG = MyApplication.class.getSimpleName();

			private RequestQueue mRequestQueue;

			private static MyApplication mInstance;

			@Override
			public void onCreate() {
				super.onCreate();
				mInstance = this;
			}

			public static synchronized MyApplication getInstance() {
				return mInstance;
			}

			public RequestQueue getRequestQueue() {
				if (mRequestQueue == null) {
					mRequestQueue = Volley.newRequestQueue(getApplicationContext());
				}

				return mRequestQueue;
			}

			@SuppressWarnings("unused")
			public <T> void addToRequestQueue(Request<T> req, String tag) {
				// set the default tag if tag is empty
				req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
				getRequestQueue().add(req);
			}

			public <T> void addToRequestQueue(Request<T> req) {
				req.setTag(TAG);
				getRequestQueue().add(req);
			}

			@SuppressWarnings("unused")
			public void cancelPendingRequests(Object tag) {
				if (mRequestQueue != null) {
					mRequestQueue.cancelAll(tag);
				}
			}
		}

**And lastly this will be your manifest file:**

		<?xml version="1.0" encoding="utf-8"?>
		<manifest xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			package="bottomnavigation.developer.aero">

			<uses-permission android:name="android.permission.INTERNET"/>

			<application
				android:name=".MyApplication"
				android:allowBackup="true"
				android:icon="@mipmap/ic_launcher"
				android:label="@string/app_name"
				android:supportsRtl="true"
				android:theme="@style/AppTheme"
				android:fullBackupContent="@xml/backup_descriptor"
				tools:ignore="GoogleAppIndexingWarning">
				<activity
					android:name=".MainActivity"
					android:label="@string/app_name">
					<intent-filter>
						<action android:name="android.intent.action.MAIN" />

						<category android:name="android.intent.category.LAUNCHER" />
					</intent-filter>
				</activity>
			</application>

		</manifest>

Output:

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/BottomNavigation/art/bottomnavigation.png)
