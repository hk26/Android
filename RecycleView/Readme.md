***So in this tutorial we will learn to create a recyclerView like gmail app.we will fetch the data from JSON and display to the app.***

**Your build.gradle(Module:app) file:**

		apply plugin: 'com.android.application'

		android {
			compileSdkVersion 27
			defaultConfig {
			applicationId "recycleview.developer.aero"
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
				testImplementation 'junit:junit:4.12'
				androidTestImplementation 'com.android.support.test:runner:1.0.1'
				androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'


				implementation 'com.android.support:appcompat-v7:27.0.2'
				implementation 'com.android.support:recyclerview-v7:27.0.2'
				implementation 'com.android.support:design:27.0.2'
				implementation 'com.android.support.constraint:constraint-layout:1.0.2'

				implementation 'com.github.bumptech.glide:glide:3.7.0'
				implementation 'com.android.volley:volley:1.0.0'
				implementation 'com.google.code.gson:gson:2.8.2'
			}

**Strings:**

		<resources>
			<string name="app_name">Recycler Swipe</string>
			<string name="action_settings">Settings</string>
			<string name="my_cart">My Cart</string>
			<string name="delete">DELETE</string>
		</resources>

**Colors:**

		<?xml version="1.0" encoding="utf-8"?>
		<resources>
			<color name="colorPrimary">#4eb961</color>
			<color name="colorPrimaryDark">#409950</color>
			<color name="colorAccent">#ea3732</color>
			<color name="bg_row_background">#fa315b</color>
			<color name="item_name">#535353</color>
			<color name="description">#a9a9a9</color>
		</resources>
		
**Styles:**

		<resources>

			<!-- Base application theme. -->
			<style name="AppTheme" parent="Theme.AppCompat.Light">
				<!-- Customize your theme here. -->
				<item name="colorPrimary">@color/colorPrimary</item>
				<item name="colorPrimaryDark">@color/colorPrimaryDark</item>
				<item name="colorAccent">@color/colorAccent</item>
			</style>

			<style name="AppTheme.NoActionBar">
				<item name="windowActionBar">false</item>
				<item name="windowNoTitle">true</item>
			</style>

			<style name="AppTheme.AppBarOverlay" parent="ThemeOverlay.AppCompat.Light" />

			<style name="AppTheme.PopupOverlay" parent="ThemeOverlay.AppCompat.Light" />

		</resources>

**Dimens:**

		<resources>
			<dimen name="activity_padding_horizontal">16dp</dimen>
			<dimen name="padd_10">10dp</dimen>
			<dimen name="ic_delete">30dp</dimen>
			<dimen name="thumbnail">90dp</dimen>
		</resources>		

**Create activity_main layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			android:id="@+id/coordinator_layout"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			tools:context="recycleview.developer.aero.MainActivity">

			<android.support.design.widget.AppBarLayout
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:theme="@style/AppTheme.AppBarOverlay">

				<android.support.v7.widget.Toolbar
					android:id="@+id/toolbar"
					android:layout_width="match_parent"
					android:layout_height="?attr/actionBarSize"
					android:background="@color/colorPrimary"
					app:popupTheme="@style/AppTheme.PopupOverlay" />

			</android.support.design.widget.AppBarLayout>

			<include layout="@layout/content_main" />

		</android.support.design.widget.CoordinatorLayout>

**Create content_main layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			app:layout_behavior="@string/appbar_scrolling_view_behavior"
			tools:context="recycleview.developer.aero.MainActivity"
			tools:showIn="@layout/activity_main">

			<android.support.v7.widget.RecyclerView
				android:id="@+id/recycler_view"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:scrollbars="vertical" />
			
		</android.support.constraint.ConstraintLayout>

**Create cart_list_item layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
			android:layout_width="match_parent"
			android:layout_height="wrap_content"
			android:orientation="vertical">

			<RelativeLayout
				android:id="@+id/view_background"
				android:layout_width="match_parent"
				android:layout_height="match_parent"
				android:background="@color/bg_row_background">

				<ImageView
					android:id="@+id/delete_icon"
					android:layout_width="@dimen/ic_delete"
					android:layout_height="@dimen/ic_delete"
					android:layout_alignParentEnd="true"
					android:layout_centerVertical="true"
					android:layout_marginEnd="@dimen/padd_10"
					android:src="@drawable/ic_delete_white_24dp"
					android:contentDescription="@string/app_name" />

				<TextView
					android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:layout_centerVertical="true"
					android:layout_marginEnd="@dimen/padd_10"
					android:layout_toStartOf="@id/delete_icon"
					android:text="@string/delete"
					android:textColor="#fff"
					android:textSize="13sp" />

			</RelativeLayout>

			<RelativeLayout
				android:id="@+id/view_foreground"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:background="@android:color/white"
				android:padding="@dimen/padd_10">

				<ImageView
					android:id="@+id/thumbnail"
					android:layout_width="@dimen/thumbnail"
					android:layout_height="@dimen/thumbnail"
					android:layout_marginEnd="@dimen/activity_padding_horizontal"
					android:scaleType="centerCrop"
					android:contentDescription="@string/app_name" />

				<TextView
					android:id="@+id/name"
					android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:layout_toEndOf="@id/thumbnail"
					android:ellipsize="end"
					android:fontFamily="sans-serif-medium"
					android:maxLines="1"
					android:textColor="@color/item_name"
					android:textSize="17sp" />

				<TextView
					android:id="@+id/description"
					android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:layout_below="@id/name"
					android:layout_marginTop="5dp"
					android:layout_toEndOf="@id/thumbnail"
					android:textColor="@color/description"
					android:textSize="12sp" />

				<TextView
					android:id="@+id/price"
					android:layout_width="wrap_content"
					android:layout_height="wrap_content"
					android:layout_alignParentBottom="true"
					android:layout_toEndOf="@id/thumbnail"
					android:textColor="@color/colorAccent"
					android:textStyle="bold" />

			</RelativeLayout>

		</FrameLayout>

**Now we will create menu_main file in menu directory:**

		<menu xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			tools:context="info.androidhive.recyclerviewswipe.MainActivity">
			<item
				android:id="@+id/action_settings"
				android:orderInCategory="100"
				android:title="@string/action_settings"
				app:showAsAction="never" />
		</menu>

**After creating layout file and all. Now we will write java files. So Create MainActivity.java file:**

			package recycleview.developer.aero;

			import android.graphics.Canvas;
			import android.graphics.Color;
			import android.os.Bundle;
			import android.support.design.widget.CoordinatorLayout;
			import android.support.design.widget.Snackbar;
			import android.support.v7.app.AppCompatActivity;
			import android.support.v7.widget.DefaultItemAnimator;
			import android.support.v7.widget.DividerItemDecoration;
			import android.support.v7.widget.LinearLayoutManager;
			import android.support.v7.widget.RecyclerView;
			import android.support.v7.widget.Toolbar;
			import android.support.v7.widget.helper.ItemTouchHelper;
			import android.util.Log;
			import android.view.Menu;
			import android.view.View;
			import android.widget.Toast;

			import com.android.volley.Response;
			import com.android.volley.VolleyError;
			import com.android.volley.toolbox.JsonArrayRequest;
			import com.google.gson.Gson;
			import com.google.gson.reflect.TypeToken;

			import org.json.JSONArray;

			import java.util.ArrayList;
			import java.util.List;

			public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

				private static final String TAG = MainActivity.class.getSimpleName();
				private List<Item> cartList;
				private CartListAdapter mAdapter;
				private CoordinatorLayout coordinatorLayout;

				// url to fetch menu json
				private static final String URL = "https://api.androidhive.info/json/menu.json";

				@Override
				protected void onCreate(Bundle savedInstanceState) {
					super.onCreate(savedInstanceState);
					setContentView(R.layout.activity_main);
					Toolbar toolbar = findViewById(R.id.toolbar);
					setSupportActionBar(toolbar);
					//noinspection ConstantConditions
					getSupportActionBar().setTitle(getString(R.string.my_cart));
					getSupportActionBar().setDisplayHomeAsUpEnabled(false);

					RecyclerView recyclerView = findViewById(R.id.recycler_view);
					Toast.makeText(this, "Fetching Data...", Toast.LENGTH_SHORT).show();
					coordinatorLayout = findViewById(R.id.coordinator_layout);
					cartList = new ArrayList<>();
					mAdapter = new CartListAdapter(this, cartList);

					RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
					recyclerView.setLayoutManager(mLayoutManager);
					recyclerView.setItemAnimator(new DefaultItemAnimator());
					recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
					recyclerView.setAdapter(mAdapter);

					// adding item touch helper
					// only ItemTouchHelper.LEFT added to detect Right to Left swipe
					// if you want both Right -> Left and Left -> Right
					// add pass ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT as param
					ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
					new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);


					// making http call and fetching menu json
					prepareCart();

					ItemTouchHelper.SimpleCallback itemTouchHelperCallback1 = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP) {
						@Override
						public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
							return false;
						}

						@Override
						public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
							// Row is swiped from recycler view
							// remove it from adapter
						}

						@SuppressWarnings("EmptyMethod")
						@Override
						public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
							super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
						}
					};

					// attaching the touch helper to recycler view
					new ItemTouchHelper(itemTouchHelperCallback1).attachToRecyclerView(recyclerView);
				}

				/**
				 * method make volley network call and parses json
				 */
				private void prepareCart() {
					JsonArrayRequest request = new JsonArrayRequest(URL,
							new Response.Listener<JSONArray>() {
								@Override
								public void onResponse(JSONArray response) {
									if (response == null) {
										Toast.makeText(getApplicationContext(), "Couldn't fetch the menu! Pleas try again.", Toast.LENGTH_LONG).show();
										return;
									}

									List<Item> items = new Gson().fromJson(response.toString(), new TypeToken<List<Item>>() {
									}.getType());

									// adding items to cart list
									cartList.clear();
									cartList.addAll(items);

									// refreshing recycler view
									mAdapter.notifyDataSetChanged();
								}
							}, new Response.ErrorListener() {
						@Override
						public void onErrorResponse(VolleyError error) {
							// error in getting json
							Log.d(TAG, "Error: " + error.getMessage());
							Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
						}
					});

					MyApplication.getInstance().addToRequestQueue(request);
				}

				/**
				 * callback when recycler view is swiped
				 * item will be removed on swiped
				 * undo option will be provided in snackbar to restore the item
				 */
				@Override
				public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
					if (viewHolder instanceof CartListAdapter.MyViewHolder) {
						// get the removed item name to display it in snack bar
						String name = cartList.get(viewHolder.getAdapterPosition()).getName();

						// backup of removed item for undo purpose
						final Item deletedItem = cartList.get(viewHolder.getAdapterPosition());
						final int deletedIndex = viewHolder.getAdapterPosition();

						// remove the item from recycler view
						mAdapter.removeItem(viewHolder.getAdapterPosition());

						// showing snack bar with Undo option
						Snackbar snackbar = Snackbar
								.make(coordinatorLayout, name + " removed from cart!", Snackbar.LENGTH_LONG);
						snackbar.setAction("UNDO", new View.OnClickListener() {
							@Override
							public void onClick(View view) {

								// undo is selected, restore the deleted item
								mAdapter.restoreItem(deletedItem, deletedIndex);
							}
						});
						snackbar.setActionTextColor(Color.YELLOW);
						snackbar.show();
					}
				}

				@Override
				public boolean onCreateOptionsMenu(Menu menu) {
					// Inflate the menu; this adds cartList to the action bar if it is present.
					getMenuInflater().inflate(R.menu.menu_main, menu);
					return true;
				}
			}

**Create CartListAdapter.java file:**

			package recycleview.developer.aero;

			import android.annotation.SuppressLint;
			import android.content.Context;
			import android.support.v7.widget.RecyclerView;
			import android.view.LayoutInflater;
			import android.view.View;
			import android.view.ViewGroup;
			import android.widget.ImageView;
			import android.widget.RelativeLayout;
			import android.widget.TextView;

			import com.bumptech.glide.Glide;

			import java.util.List;

			public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.MyViewHolder> {
				private final Context context;
				private final List<Item> cartList;

				class MyViewHolder extends RecyclerView.ViewHolder {
					final TextView name;
					final TextView description;
					final TextView price;
					final ImageView thumbnail;
					@SuppressWarnings("unused")
					final RelativeLayout viewBackground;
					final RelativeLayout viewForeground;

					MyViewHolder(View view) {
						super(view);
						name = view.findViewById(R.id.name);
						description = view.findViewById(R.id.description);
						price = view.findViewById(R.id.price);
						thumbnail = view.findViewById(R.id.thumbnail);
						viewBackground = view.findViewById(R.id.view_background);
						viewForeground = view.findViewById(R.id.view_foreground);
					}
				}


				CartListAdapter(Context context, List<Item> cartList) {
					this.context = context;
					this.cartList = cartList;
				}

				@Override
				public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
					View itemView = LayoutInflater.from(parent.getContext())
							.inflate(R.layout.cart_list_item, parent, false);

					return new MyViewHolder(itemView);
				}

				@SuppressLint("SetTextI18n")
				@Override
				public void onBindViewHolder(MyViewHolder holder, final int position) {
					final Item item = cartList.get(position);
					holder.name.setText(item.getName());
					holder.description.setText(item.getDescription());
					holder.price.setText("₹" + item.getPrice());

					Glide.with(context)
							.load(item.getThumbnail())
							.into(holder.thumbnail);
				}

				@Override
				public int getItemCount() {
					return cartList.size();
				}

				void removeItem(int position) {
					cartList.remove(position);
					// notify the item removed by position
					// to perform recycler view delete animations
					// NOTE: don't call notifyDataSetChanged()
					notifyItemRemoved(position);
				}

				void restoreItem(Item item, int position) {
					cartList.add(position, item);
					// notify item added by position
					notifyItemInserted(position);
				}
			}

**Create Item.java file:**

		package recycleview.developer.aero;

		@SuppressWarnings("unused")
		public class Item {
			private int id;
			private String name;
			private String description;
			private double price;
			private String thumbnail;

			public Item() {
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			double getPrice() {
				return price;
			}

			public void setPrice(double price) {
				this.price = price;
			}

			String getThumbnail() {
				return thumbnail;
			}

			public void setThumbnail(String thumbnail) {
				this.thumbnail = thumbnail;
			}
		}

**Create MyApplication.java file:**

		package recycleview.developer.aero;

		import android.app.Application;
		import android.text.TextUtils;

		import com.android.volley.Request;
		import com.android.volley.RequestQueue;
		import com.android.volley.toolbox.Volley;

		public class MyApplication extends Application {

			private static final String TAG = MyApplication.class
					.getSimpleName();

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

**Create RecyclerItemTouchHelper.java file:**

		package recycleview.developer.aero;

		import android.graphics.Canvas;
		import android.support.v7.widget.RecyclerView;
		import android.support.v7.widget.helper.ItemTouchHelper;
		import android.view.View;

		public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback {
			private final RecyclerItemTouchHelperListener listener;

			RecyclerItemTouchHelper(int dragDirs, int swipeDirs, RecyclerItemTouchHelperListener listener) {
				super(dragDirs, swipeDirs);
				this.listener = listener;
			}

			@Override
			public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
				return true;
			}

			@Override
			public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
				if (viewHolder != null) {
					final View foregroundView = ((CartListAdapter.MyViewHolder) viewHolder).viewForeground;

					getDefaultUIUtil().onSelected(foregroundView);
				}
			}

			@Override
			public void onChildDrawOver(Canvas c, RecyclerView recyclerView,
										RecyclerView.ViewHolder viewHolder, float dX, float dY,
										int actionState, boolean isCurrentlyActive) {
				final View foregroundView = ((CartListAdapter.MyViewHolder) viewHolder).viewForeground;
				getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX, dY,
						actionState, isCurrentlyActive);
			}

			@Override
			public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
				final View foregroundView = ((CartListAdapter.MyViewHolder) viewHolder).viewForeground;
				getDefaultUIUtil().clearView(foregroundView);
			}

			@Override
			public void onChildDraw(Canvas c, RecyclerView recyclerView,
									RecyclerView.ViewHolder viewHolder, float dX, float dY,
									int actionState, boolean isCurrentlyActive) {
				final View foregroundView = ((CartListAdapter.MyViewHolder) viewHolder).viewForeground;

				getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY,
						actionState, isCurrentlyActive);
			}

			@Override
			public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
				listener.onSwiped(viewHolder, direction, viewHolder.getAdapterPosition());
			}

			@SuppressWarnings("EmptyMethod")
			@Override
			public int convertToAbsoluteDirection(int flags, int layoutDirection) {
				return super.convertToAbsoluteDirection(flags, layoutDirection);
			}

			public interface RecyclerItemTouchHelperListener {
				void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);
			}
		}

**Now lastly we will write manifest file. This will be your manifest file:**

		<?xml version="1.0" encoding="utf-8"?>
		<manifest xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			package="recycleview.developer.aero">

			<uses-permission android:name="android.permission.INTERNET" />

			<application
				android:name=".MyApplication"
				android:allowBackup="true"
				android:icon="@mipmap/ic_launcher"
				android:label="@string/app_name"
				android:roundIcon="@mipmap/ic_launcher_round"
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

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/RecycleView/art/recycleview1.png)

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/RecycleView/art/recycleview2.png)	
