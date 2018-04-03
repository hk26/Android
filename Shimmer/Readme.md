***Shimmer is an Android library that provides an easy way to add a shimmer effect to any view in your Android app. It is useful as an unobtrusive loading indicator that was originally developed for Facebook Home***

**build.gradle(Module:app) file write this dependencies:**

    apply plugin: 'com.android.application'

    android {
        compileSdkVersion 27
        defaultConfig {
            applicationId "shimmer.developer.aero"
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
        //noinspection GradleCompatible
        androidTestImplementation 'com.android.support.test:runner:1.0.1'
        androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'

        implementation 'com.android.support:appcompat-v7:27.0.2'
        implementation 'com.android.support:recyclerview-v7:27.0.2'
        implementation 'com.android.support.constraint:constraint-layout:1.0.2'

        // Shimmer
        implementation 'com.facebook.shimmer:shimmer:0.1.0@aar'

        // glide image library
        implementation 'com.github.bumptech.glide:glide:3.7.0'

        // volley http library
        implementation 'com.android.volley:volley:1.0.0'
        implementation 'com.google.code.gson:gson:2.8.2'
    }

***Now we will write strings,colors,styles,dimens file:***

**Strings:**

    <resources>
        <string name="app_name">Shimmer</string>
        <string name="action_profile">Profile</string>
    </resources>

**Colors:**

    <?xml version="1.0" encoding="utf-8"?>
    <resources>
        <color name="colorPrimary">#d91248</color>
        <color name="colorPrimaryDark">#d91248</color>
        <color name="colorAccent">#3ad23e</color>
        <color name="placeholder_bg">#dddddd</color>
        <color name="item_name">#0c0c0c</color>
        <color name="description">#1a1a1a</color>
        <color name="chef">#777</color>
        <color name="timestamp">#777</color>
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

    <?xml version="1.0" encoding="utf-8"?>
    <resources>
        <dimen name="activity_padding">16dp</dimen>
        <dimen name="placeholder_image">50dp</dimen>
        <dimen name="placeholder_text_height">8dp</dimen>
        <dimen name="activity_padding_horizontal">16dp</dimen>
        <dimen name="padding_10">10dp</dimen>
        <dimen name="name">15sp</dimen>
        <dimen name="chef">12dp</dimen>
        <dimen name="timestamp">11dp</dimen>
        <dimen name="description">15dp</dimen>
        <dimen name="price">13dp</dimen>
    </resources>

**Now we will write layout files create activity_main layout file:**

    <?xml version="1.0" encoding="utf-8"?>
    <!--suppress ALL -->
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:shimmer="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@android:color/white"
        tools:context=".MainActivity"
        tools:ignore="Overdraw">

        <com.facebook.shimmer.ShimmerFrameLayout
            android:id="@+id/shimmer_view_container"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:orientation="vertical"
            shimmer:duration="800">

            <!-- Adding 3 rows of placeholders -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical">

                <include layout="@layout/recipe_placeholder_item" />

                <include layout="@layout/recipe_placeholder_item" />

                <include layout="@layout/recipe_placeholder_item" />

            </LinearLayout>

        </com.facebook.shimmer.ShimmerFrameLayout>

        <android.support.v7.widget.RecyclerView
            android:id="@+id/recycler_view"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:scrollbars="vertical" />

    </android.support.constraint.ConstraintLayout>

**create action_profile layout file:**

    <?xml version="1.0" encoding="utf-8"?>
    <!--suppress ALL -->
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".ProfileActivity">


    <com.facebook.shimmer.ShimmerFrameLayout
        android:id="@+id/shimmer_view_container"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical">

                <View
                    android:layout_width="100dp"
                    android:layout_height="100dp"
                    android:layout_gravity="center_horizontal"
                    android:layout_marginTop="50dp"
                    android:background="@color/placeholder_bg" />

                <View
                    android:layout_width="200dp"
                    android:layout_height="@dimen/placeholder_text_height"
                    android:layout_gravity="center_horizontal"
                    android:layout_marginTop="@dimen/activity_padding_horizontal"
                    android:background="@color/placeholder_bg" />

                <View
                    android:layout_width="250dp"
                    android:layout_height="@dimen/placeholder_text_height"
                    android:layout_gravity="center_horizontal"
                    android:layout_marginTop="@dimen/activity_padding_horizontal"
                    android:background="@color/placeholder_bg" />

            </LinearLayout>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="30dp"
                android:orientation="horizontal"
                android:paddingLeft="@dimen/activity_padding_horizontal"
                android:paddingRight="@dimen/activity_padding_horizontal"
                android:weightSum="3">

                <View
                    android:layout_width="0dp"
                    android:layout_height="100dp"
                    android:layout_weight="1"
                    android:background="@color/placeholder_bg" />

                <View
                    android:layout_width="0dp"
                    android:layout_height="100dp"
                    android:layout_marginLeft="@dimen/activity_padding_horizontal"
                    android:layout_marginRight="@dimen/activity_padding_horizontal"
                    android:layout_weight="1"
                    android:background="@color/placeholder_bg" />

                <View
                    android:layout_width="0dp"
                    android:layout_height="100dp"
                    android:layout_weight="1"
                    android:background="@color/placeholder_bg" />
            </LinearLayout>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="@dimen/activity_padding_horizontal"
                android:orientation="horizontal"
                android:paddingLeft="@dimen/activity_padding_horizontal"
                android:paddingRight="@dimen/activity_padding_horizontal"
                android:weightSum="3">

                <View
                    android:layout_width="0dp"
                    android:layout_height="100dp"
                    android:layout_weight="1"
                    android:background="@color/placeholder_bg" />

                <View
                    android:layout_width="0dp"
                    android:layout_height="100dp"
                    android:layout_marginLeft="@dimen/activity_padding_horizontal"
                    android:layout_marginRight="@dimen/activity_padding_horizontal"
                    android:layout_weight="1"
                    android:background="@color/placeholder_bg" />

                <View
                    android:layout_width="0dp"
                    android:layout_height="100dp"
                    android:layout_weight="1"
                    android:background="@color/placeholder_bg" />
            </LinearLayout>

        </LinearLayout>

    </com.facebook.shimmer.ShimmerFrameLayout>

    </android.support.constraint.ConstraintLayout>

**create recipe_list_item layout file:**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@android:color/white"
        android:clickable="true"
        android:foreground="?attr/selectableItemBackground"
        android:padding="@dimen/activity_padding_horizontal"
        android:focusable="true">

        <ImageView
            android:id="@+id/thumbnail"
            android:layout_width="@dimen/placeholder_image"
            android:layout_height="@dimen/placeholder_image"
            android:layout_marginRight="@dimen/padding_10"
            android:scaleType="centerCrop"
            tools:ignore="ContentDescription,RtlHardcoded" />

        <TextView
            android:id="@+id/name"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_toRightOf="@id/thumbnail"
            android:ellipsize="end"
            android:fontFamily="sans-serif-medium"
            android:maxLines="1"
            android:textColor="@color/item_name"
            android:textSize="@dimen/name"
            tools:ignore="RtlHardcoded" />

        <TextView
            android:id="@+id/chef"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/name"
            android:layout_toRightOf="@id/thumbnail"
            android:maxLines="1"
            android:textColor="@color/chef"
            android:textSize="@dimen/chef"
            tools:ignore="RtlHardcoded,SpUsage" />

        <TextView
            android:id="@+id/timestamp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/chef"
            android:layout_toRightOf="@id/thumbnail"
            android:maxLines="1"
            android:text="2 min ago"
            android:textColor="@color/timestamp"
            android:textSize="@dimen/timestamp"
            tools:ignore="HardcodedText,RtlHardcoded,SpUsage" />

        <TextView
            android:id="@+id/description"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/thumbnail"
            android:layout_marginTop="@dimen/activity_padding_horizontal"
            android:ellipsize="end"
            android:maxLines="3"
            android:textColor="@color/description"
            android:textSize="@dimen/description"
            tools:ignore="SpUsage" />

        <TextView
            android:id="@+id/price"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/description"
            android:layout_marginTop="@dimen/padding_10"
            android:textColor="@color/colorPrimary"
            android:textSize="@dimen/price"
            android:textStyle="bold"
            tools:ignore="SpUsage" />

    </RelativeLayout>

**create recipe_placeholder_item layout file:**

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="@dimen/activity_padding">

        <View
            android:id="@+id/thumbnail"
            android:layout_width="@dimen/placeholder_image"
            android:layout_height="@dimen/placeholder_image"
            android:layout_marginRight="@dimen/activity_padding"
            android:background="@color/placeholder_bg"
            tools:ignore="RtlHardcoded" />

        <View
            android:id="@+id/name"
            android:layout_width="150dp"
            android:layout_height="10dp"
            android:layout_marginBottom="10dp"
            android:layout_toRightOf="@id/thumbnail"
            android:background="@color/placeholder_bg"
            tools:ignore="RtlHardcoded" />

        <View
            android:layout_width="100dp"
            android:layout_height="@dimen/placeholder_text_height"
            android:layout_below="@id/name"
            android:layout_toRightOf="@id/thumbnail"
            android:background="@color/placeholder_bg"
            tools:ignore="RtlHardcoded" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_below="@id/thumbnail"
            android:layout_marginBottom="40dp"
            android:layout_marginTop="20dp"
            android:orientation="vertical">

            <View
                android:layout_width="match_parent"
                android:layout_height="@dimen/placeholder_text_height"
                android:layout_marginRight="100dp"
                android:background="@color/placeholder_bg"
                tools:ignore="RtlHardcoded" />

            <View
                android:layout_width="match_parent"
                android:layout_height="@dimen/placeholder_text_height"
                android:layout_marginRight="50dp"
                android:layout_marginTop="10dp"
                android:background="@color/placeholder_bg"
                tools:ignore="RtlHardcoded" />

            <View
                android:layout_width="match_parent"
                android:layout_height="@dimen/placeholder_text_height"
                android:layout_marginRight="160dp"
                android:layout_marginTop="10dp"
                android:background="@color/placeholder_bg"
                tools:ignore="RtlHardcoded" />

        </LinearLayout>

    </RelativeLayout>

**And now create menu_main file in menu directory:**

    <?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">

        <item
            android:id="@+id/action_profile"
            android:title="@string/action_profile"
            app:showAsAction="never" />


    </menu>

***And now we will write Java files and complete the program:***

**create MainActivity.java file:**

    package shimmer.developer.aero;

    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.support.v7.widget.DefaultItemAnimator;
    import android.support.v7.widget.LinearLayoutManager;
    import android.support.v7.widget.RecyclerView;
    import android.util.Log;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Toast;

    import com.android.volley.Response;
    import com.android.volley.VolleyError;
    import com.android.volley.toolbox.JsonArrayRequest;
    import com.facebook.shimmer.ShimmerFrameLayout;
    import com.google.gson.Gson;
    import com.google.gson.reflect.TypeToken;

    import org.json.JSONArray;

    import java.util.ArrayList;
    import java.util.List;

    public class MainActivity extends AppCompatActivity {

        private static final String TAG = MainActivity.class.getSimpleName();
        private List<Recipe> cartList;
        private RecipeListAdapter mAdapter;

        private ShimmerFrameLayout mShimmerViewContainer;

        // URL to fetch menu json
        // this endpoint takes 2 sec before giving the response to add
        // some delay to test the Shimmer effect
        private static final String URL = "https://api.androidhive.info/json/shimmer/menu.php";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mShimmerViewContainer = findViewById(R.id.shimmer_view_container);

            RecyclerView recyclerView = findViewById(R.id.recycler_view);
            cartList = new ArrayList<>();
            mAdapter = new RecipeListAdapter(this, cartList);

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new MyDividerItemDecoration(this));
            recyclerView.setAdapter(mAdapter);

            // making http call and fetching menu json
            fetchRecipes();
        }

        /**
         * method make volley network call and parses json
         */
        private void fetchRecipes() {
            JsonArrayRequest request = new JsonArrayRequest(URL,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            if (response == null) {
                                Toast.makeText(getApplicationContext(), "Couldn't fetch the menu! Pleas try again.", Toast.LENGTH_LONG).show();
                                return;
                            }

                            List<Recipe> recipes = new Gson().fromJson(response.toString(), new TypeToken<List<Recipe>>() {
                            }.getType());

                            // adding recipes to cart list
                            cartList.clear();
                            cartList.addAll(recipes);

                            // refreshing recycler view
                            mAdapter.notifyDataSetChanged();

                            // stop animating Shimmer and hide the layout
                            mShimmerViewContainer.stopShimmerAnimation();
                            mShimmerViewContainer.setVisibility(View.GONE);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // error in getting json
                    Log.e(TAG, "Error: " + error.getMessage());
                    Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            MyApplication.getInstance().addToRequestQueue(request);
        }

        @Override
        public void onResume() {
            super.onResume();
            mShimmerViewContainer.startShimmerAnimation();
        }

        @Override
        public void onPause() {
            mShimmerViewContainer.stopShimmerAnimation();
            super.onPause();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds cartList to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == R.id.action_profile) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }

**create MyApplication.java file:**

    package shimmer.developer.aero;

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

        private RequestQueue getRequestQueue() {
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

**create MyDividerItemDecoration.java file:**

    package shimmer.developer.aero;

    import android.content.Context;
    import android.content.res.Resources;
    import android.content.res.TypedArray;
    import android.graphics.Canvas;
    import android.graphics.Rect;
    import android.graphics.drawable.Drawable;
    import android.support.v7.widget.LinearLayoutManager;
    import android.support.v7.widget.RecyclerView;
    import android.util.TypedValue;
    import android.view.View;

    class MyDividerItemDecoration  extends RecyclerView.ItemDecoration {

        private static final int[] ATTRS = new int[]{
                android.R.attr.listDivider
        };

        private static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;

        private static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

        private final Drawable mDivider;
        private int mOrientation;
        private final Context context;
        private final int margin;

        MyDividerItemDecoration(Context context) {
            this.context = context;
            this.margin = 16;
            final TypedArray a = context.obtainStyledAttributes(ATTRS);
            mDivider = a.getDrawable(0);
            a.recycle();
            setOrientation();
        }

        private void setOrientation() {
            if (LinearLayoutManager.VERTICAL != HORIZONTAL_LIST && LinearLayoutManager.VERTICAL != VERTICAL_LIST) {
                throw new IllegalArgumentException("invalid orientation");
            }
            mOrientation = LinearLayoutManager.VERTICAL;
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            if (mOrientation == VERTICAL_LIST) {
                drawVertical(c, parent);
            } else {
                drawHorizontal(c, parent);
            }
        }

        private void drawVertical(Canvas c, RecyclerView parent) {
            final int left = parent.getPaddingLeft();
            final int right = parent.getWidth() - parent.getPaddingRight();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left + dpToPx(margin), top, right - dpToPx(margin), bottom);
                mDivider.draw(c);
            }
        }

        private void drawHorizontal(Canvas c, RecyclerView parent) {
            final int top = parent.getPaddingTop();
            final int bottom = parent.getHeight() - parent.getPaddingBottom();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int left = child.getRight() + params.rightMargin;
                final int right = left + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top + dpToPx(margin), right, bottom - dpToPx(margin));
                mDivider.draw(c);
            }
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            if (mOrientation == VERTICAL_LIST) {
                outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
            } else {
                outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
            }
        }

        private int dpToPx(int dp) {
            Resources r = context.getResources();
            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
        }
    }

**create ProfileActivity.java file:**

    package shimmer.developer.aero;

    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.MenuItem;

    import com.facebook.shimmer.ShimmerFrameLayout;

    public class ProfileActivity extends AppCompatActivity {

        private ShimmerFrameLayout mShimmerViewContainer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);

            //noinspection ConstantConditions
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        }

        @Override
        public void onResume() {
            super.onResume();
            mShimmerViewContainer.startShimmerAnimation();
        }

        @Override
        public void onPause() {
            mShimmerViewContainer.stopShimmerAnimation();
            super.onPause();
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if(item.getItemId() == android.R.id.home){
                finish();
            }

            return super.onOptionsItemSelected(item);
        }
    }

**create Recipe.java file:**

    package shimmer.developer.aero;

    @SuppressWarnings("unused")
    public class Recipe {
        private int id;
        private String name;
        private String description;
        private double price;
        private String thumbnail;
        private String chef;
        private String timestamp;

        public Recipe() {
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        String getDescription() {
            return description;
        }

        double getPrice() {
            return price;
        }

        String getThumbnail() {
            return thumbnail;
        }

        String getChef() {
            return chef;
        }

        String getTimestamp() {
            return timestamp;
        }
    }

**create RecipeListAdapter.java file:**

    package shimmer.developer.aero;

    import android.annotation.SuppressLint;
    import android.content.Context;
    import android.support.v7.widget.RecyclerView;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageView;
    import android.widget.TextView;
    import com.bumptech.glide.Glide;
    import java.util.List;

    public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.MyViewHolder> {
        private final Context context;
        private final List<Recipe> cartList;

        class MyViewHolder extends RecyclerView.ViewHolder {
            final TextView name;
            final TextView description;
            final TextView price;
            final TextView chef;
            final TextView timestamp;
            final ImageView thumbnail;

            MyViewHolder(View view) {
                super(view);
                name = view.findViewById(R.id.name);
                chef = view.findViewById(R.id.chef);
                description = view.findViewById(R.id.description);
                price = view.findViewById(R.id.price);
                thumbnail = view.findViewById(R.id.thumbnail);
                timestamp = view.findViewById(R.id.timestamp);
            }
        }


        RecipeListAdapter(Context context, List<Recipe> cartList) {
            this.context = context;
            this.cartList = cartList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recipe_list_item, parent, false);

            return new MyViewHolder(itemView);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            final Recipe recipe = cartList.get(position);
            holder.name.setText(recipe.getName());
            holder.chef.setText("By " + recipe.getChef());
            holder.description.setText(recipe.getDescription());
            holder.price.setText("Price: ₹" + recipe.getPrice());
            holder.timestamp.setText(recipe.getTimestamp());

            Glide.with(context)
                    .load(recipe.getThumbnail())
                    .into(holder.thumbnail);
        }
        // recipe
        @Override
        public int getItemCount() {
            return cartList.size();
        }
    }
 
**And Lastly this will be your manifest file:**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        package="shimmer.developer.aero">

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
            <activity android:name=".MainActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
            <activity
                android:name=".ProfileActivity"
                android:label="@string/action_profile">

            </activity>
        </application>

    </manifest>
    
**Output:**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Shimmer/art/shimmer.png)    
