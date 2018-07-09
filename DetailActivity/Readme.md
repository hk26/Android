***In this tutorial we will create a DetailActivity in which when a user will click on an item it will show information about that item.So le'ts start the tutorial***

**This is your build.gradle(Module:app) file.**

    apply plugin: 'com.android.application'

    android {
        compileSdkVersion 27
        defaultConfig {
            applicationId "detailactivity.developer.aero"
            minSdkVersion 15
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
        implementation 'com.android.support:support-v4:27.1.1'
        implementation 'com.android.support:recyclerview-v7:27.1.1'
        implementation 'com.android.support:design:27.1.1'
        testImplementation 'junit:junit:4.12'
        androidTestImplementation 'com.android.support.test:runner:1.0.2'
        androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'
    }
    
**Now we will edit our Strings and dimens file.**

**Strings**

    <resources>
        <string name="app_name">Detail Activity</string>
        <string name="title_item_detail">Item Detail</string>
    </resources>
    
**Dimens**

    <?xml version="1.0" encoding="utf-8"?>
    <resources>
          <dimen name="fab_margin">16dp</dimen>
        <dimen name="app_bar_height">200dp</dimen>
        <dimen name="item_width">200dp</dimen>
        <dimen name="text_margin">16dp</dimen>
    </resources>
    
**Now we will create layout file for our app.**

**So create a ' activity_item_detail ' named layout file in res -> layout -> activity_item_detail**

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true"
        tools:context=".ItemDetailActivity"
        tools:ignore="MergeRootFrame">

        <android.support.design.widget.AppBarLayout
            android:id="@+id/app_bar"
            android:layout_width="match_parent"
            android:layout_height="@dimen/app_bar_height"
            android:fitsSystemWindows="true"
            android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar">

            <android.support.design.widget.CollapsingToolbarLayout
                android:id="@+id/toolbar_layout"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:fitsSystemWindows="true"
                app:contentScrim="?attr/colorPrimary"
                app:layout_scrollFlags="scroll|exitUntilCollapsed"
                app:toolbarId="@+id/toolbar">

                <android.support.v7.widget.Toolbar
                    android:id="@+id/detail_toolbar"
                    android:layout_width="match_parent"
                    android:layout_height="?attr/actionBarSize"
                    app:layout_collapseMode="pin"
                    app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />

            </android.support.design.widget.CollapsingToolbarLayout>

        </android.support.design.widget.AppBarLayout>

        <android.support.v4.widget.NestedScrollView
            android:id="@+id/item_detail_container"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_behavior="@string/appbar_scrolling_view_behavior" />

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_vertical|start"
            android:layout_margin="@dimen/fab_margin"
            app:srcCompat="@android:drawable/stat_notify_chat"
            app:layout_anchor="@+id/item_detail_container"
            app:layout_anchorGravity="top|end" />

    </android.support.design.widget.CoordinatorLayout>    
    
**Create ' activity_item_list ' layout file.**

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true"
        tools:context=".ItemListActivity">

        <android.support.design.widget.AppBarLayout
            android:id="@+id/app_bar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:theme="@style/AppTheme.AppBarOverlay">

            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                app:popupTheme="@style/AppTheme.PopupOverlay" />

        </android.support.design.widget.AppBarLayout>

        <FrameLayout
            android:id="@+id/frameLayout"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_behavior="@string/appbar_scrolling_view_behavior">

            <include layout="@layout/item_list" />
        </FrameLayout>

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom|end"
            android:layout_margin="@dimen/fab_margin"
            app:srcCompat="@android:drawable/ic_dialog_email" />


    </android.support.design.widget.CoordinatorLayout> 

**Create ' item_detail ' layout file.**

    <?xml version="1.0" encoding="utf-8"?>
    <TextView xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/item_detail"
        style="?android:attr/textAppearanceLarge"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="16dp"
        android:textIsSelectable="true"
        tools:context=".ItemDetailFragment" />  

**Create ' item_list ' layout file.**

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.v7.widget.RecyclerView xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/item_list"
        android:name="detailactivity.developer.aero.ItemListFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginLeft="16dp"
        android:layout_marginRight="16dp"
        app:layoutManager="LinearLayoutManager"
        tools:context=".ItemListActivity"
        tools:listitem="@layout/item_list_content" />   

**Create ' item_list_content ' layout file.**

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/id_text"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="@dimen/text_margin"
            android:textAppearance="?attr/textAppearanceListItem"/>

        <TextView
            android:id="@+id/content"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="@dimen/text_margin"
            android:textAppearance="?attr/textAppearanceListItem"/>
    </LinearLayout> 

**Now after creating layout files and all we will create java files for our app.**

**Firstly create a directory in your package named as ' dummy ' and in dummy directory create a java file named as ' DummyContent.java ' file.**

    package detailactivity.developer.aero.dummy;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    /**
     * Helper class for providing sample content for user interfaces created by
     * Android template wizards.
     * <p>
     * TODO: Replace all uses of this class before publishing your app.
     */
    public class DummyContent {

        /**
         * An array of sample (dummy) items.
         */
        public static final List<DummyItem> ITEMS = new ArrayList<>();

        /**
         * A map of sample (dummy) items, by ID.
         */
        public static final Map<String, DummyItem> ITEM_MAP = new HashMap<>();

        private static final int COUNT = 25;

        static {
            // Add some sample items.
            for (int i = 1; i <= COUNT; i++) {
                addItem(createDummyItem(i));
            }
        }

        private static void addItem(DummyItem item) {
            ITEMS.add(item);
            ITEM_MAP.put(item.id, item);
        }

        private static DummyItem createDummyItem(int position) {
            return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
        }

        private static String makeDetails(int position) {
            StringBuilder builder = new StringBuilder();
            builder.append("Details about Item: ").append(position);
            for (int i = 0; i < position; i++) {
                builder.append("\nMore details information here.");
            }
            return builder.toString();
        }

        /**
         * A dummy item representing a piece of content.
         */
        public static class DummyItem {
            public final String id;
            public final String content;
            public final String details;

            DummyItem(String id, String content, String details) {
                this.id = id;
                this.content = content;
                this.details = details;
            }

            @Override
            public String toString() {
                return content;
            }
        }
    }
    
**Now we will create other three java files but not in dummy directory we will create outside of dummy directory. Means in package.**

**Create ' ItemDetailActivity.java ' file in detailactivity.developer.aero -> ItemDetailActivity.**

    package detailactivity.developer.aero;

    import android.content.Intent;
    import android.os.Bundle;
    import android.support.design.widget.FloatingActionButton;
    import android.support.design.widget.Snackbar;
    import android.support.v7.widget.Toolbar;
    import android.view.View;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.app.ActionBar;
    import android.support.v4.app.NavUtils;
    import android.view.MenuItem;

    /**
     * An activity representing a single Item detail screen. This
     * activity is only used on narrow width devices. On tablet-size devices,
     * item details are presented side-by-side with a list of items
     * in a {@link ItemListActivity}.
     */
    public class ItemDetailActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_item_detail);
            Toolbar toolbar = findViewById(R.id.detail_toolbar);
            setSupportActionBar(toolbar);

            FloatingActionButton fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

            // Show the Up button in the action bar.
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }

            // savedInstanceState is non-null when there is fragment state
            // saved from previous configurations of this activity
            // (e.g. when rotating the screen from portrait to landscape).
            // In this case, the fragment will automatically be re-added
            // to its container so we don't need to manually add it.
            // For more information, see the Fragments API guide at:
            //
            // http://developer.android.com/guide/components/fragments.html
            //
            if (savedInstanceState == null) {
                // Create the detail fragment and add it to the activity
                // using a fragment transaction.
                Bundle arguments = new Bundle();
                arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
                        getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
                ItemDetailFragment fragment = new ItemDetailFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.item_detail_container, fragment)
                        .commit();
            }
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == android.R.id.home) {
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                NavUtils.navigateUpTo(this, new Intent(this, ItemListActivity.class));
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }
    
**Create ' ItemDetailFragment.java ' file in detailactivity.developer.aero -> ItemDetailFragment.**    

    package detailactivity.developer.aero;

    import android.app.Activity;
    import android.support.annotation.NonNull;
    import android.support.design.widget.CollapsingToolbarLayout;
    import android.os.Bundle;
    import android.support.v4.app.Fragment;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.TextView;
    import detailactivity.developer.aero.dummy.DummyContent;

    /**
     * A fragment representing a single Item detail screen.
     * This fragment is either contained in a {@link ItemListActivity}
     * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
     * on handsets.
     */
    public class ItemDetailFragment extends Fragment {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        public static final String ARG_ITEM_ID = "item_id";

        /**
         * The dummy content this fragment is presenting.
         */
        private DummyContent.DummyItem mItem;

        /**
         * Mandatory empty constructor for the fragment manager to instantiate the
         * fragment (e.g. upon screen orientation changes).
         */
        public ItemDetailFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            assert getArguments() != null;
            if (getArguments().containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

                Activity activity = this.getActivity();
                assert activity != null;
                CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
                if (appBarLayout != null) {
                    appBarLayout.setTitle(mItem.content);
                }
            }
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.item_detail, container, false);

            // Show the dummy content as text in a TextView.
            if (mItem != null) {
                ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.details);
            }

            return rootView;
        }
    }
    
**Create ' ItemListActivity.java ' file in detailactivity.developer.aero -> ItemListActivity.**    

    package detailactivity.developer.aero;

    import android.content.Context;
    import android.content.Intent;
    import android.os.Bundle;
    import android.support.annotation.NonNull;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.RecyclerView;
    import android.support.v7.widget.Toolbar;
    import android.support.design.widget.FloatingActionButton;
    import android.support.design.widget.Snackbar;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.TextView;

    import detailactivity.developer.aero.dummy.DummyContent;

    import java.util.List;

    /**
     * An activity representing a list of Items. This activity
     * has different presentations for handset and tablet-size devices. On
     * handsets, the activity presents a list of items, which when touched,
     * lead to a {@link ItemDetailActivity} representing
     * item details. On tablets, the activity presents the list of items and
     * item details side-by-side using two vertical panes.
     */
    public class ItemListActivity extends AppCompatActivity {

        /**
         * Whether or not the activity is in two-pane mode, i.e. running on a tablet
         * device.
         */
        private boolean mTwoPane;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_item_list);

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            toolbar.setTitle(getTitle());

            FloatingActionButton fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

            if (findViewById(R.id.item_detail_container) != null) {
                // The detail container view will be present only in the
                // large-screen layouts (res/values-w900dp).
                // If this view is present, then the
                // activity should be in two-pane mode.
                mTwoPane = true;
            }

            View recyclerView = findViewById(R.id.item_list);
            assert recyclerView != null;
            setupRecyclerView((RecyclerView) recyclerView);
        }

        private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
            recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, mTwoPane));
        }

        public static class SimpleItemRecyclerViewAdapter
                extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

            private final ItemListActivity mParentActivity;
            private final List<DummyContent.DummyItem> mValues;
            private final boolean mTwoPane;
            private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DummyContent.DummyItem item = (DummyContent.DummyItem) view.getTag();
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(ItemDetailFragment.ARG_ITEM_ID, item.id);
                        ItemDetailFragment fragment = new ItemDetailFragment();
                        fragment.setArguments(arguments);
                        mParentActivity.getSupportFragmentManager().beginTransaction()
                                .replace(R.id.item_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = view.getContext();
                        Intent intent = new Intent(context, ItemDetailActivity.class);
                        intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id);

                        context.startActivity(intent);
                    }
                }
            };

            SimpleItemRecyclerViewAdapter(ItemListActivity parent,
                                          boolean twoPane) {
                mValues = DummyContent.ITEMS;
                mParentActivity = parent;
                mTwoPane = twoPane;
            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_list_content, parent, false);
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
                holder.mIdView.setText(mValues.get(position).id);
                holder.mContentView.setText(mValues.get(position).content);

                holder.itemView.setTag(mValues.get(position));
                holder.itemView.setOnClickListener(mOnClickListener);
            }

            @Override
            public int getItemCount() {
                return mValues.size();
            }

            class ViewHolder extends RecyclerView.ViewHolder {
                final TextView mIdView;
                final TextView mContentView;

                ViewHolder(View view) {
                    super(view);
                    mIdView = view.findViewById(R.id.id_text);
                    mContentView = view.findViewById(R.id.content);
                }
            }
        }
    }
    
**And lastly this will be your manifest file**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="detailactivity.developer.aero" >

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme" >
            <activity
                android:name=".ItemListActivity"
                android:label="@string/app_name"
                android:theme="@style/AppTheme.NoActionBar" >
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
            <activity
                android:name=".ItemDetailActivity"
                android:label="@string/title_item_detail"
                android:parentActivityName=".ItemListActivity"
                android:theme="@style/AppTheme.NoActionBar" >
                <meta-data
                    android:name="android.support.PARENT_ACTIVITY"
                    android:value="detailactivity.developer.aero.ItemListActivity" />
            </activity>
        </application>

    </manifest>

**Output**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/DetailActivity/art/detailactivity1.png)

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/DetailActivity/art/detailactivity2.png)
