***Using data binding, you create a link between the presentation layer (the app UI) and the underlying data model that holds the information you want to show. The UI widgets content like TextView, EditText and so on are somehow bound to the data stored in java class. Every time the data changes the UI widget bound to it is updated, so that you don’t have to worry anymore to update the UI by yourself.***

**Strings.xml :**

    <resources>
        <string name="app_name">Data Binding</string>
        <string name="action_settings">Settings</string>
        <string name="toolbar_profile">Profile</string>
        <string name="posts">POSTS</string>
        <string name="followers">FOLLOWERS</string>
        <string name="following">FOLLOWING</string>
    </resources>

**Dimens :**

    <resources>
        <dimen name="fab_margin">16dp</dimen>
        <dimen name="activity_margin">16dp</dimen>
        <dimen name="dimen_8dp">8dp</dimen>
        <dimen name="profile_image">100dp</dimen>
        <dimen name="fab_profile">30dp</dimen>
        <dimen name="profile_name">15sp</dimen>
        <dimen name="profile_about">13sp</dimen>
        <dimen name="profile_meta">24sp</dimen>
        <dimen name="profile_meta_label">10sp</dimen>
    </resources>
 
**Colors :**

    <?xml version="1.0" encoding="utf-8"?>
    <resources>
        <color name="colorPrimary">#222222</color>
        <color name="colorPrimaryDark">#111111</color>
        <color name="colorAccent">#fecb2f</color>
        <color name="profile_meta">#333</color>
    </resources>

**Styles :**

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
 
**Now create a ' menu_main ' file in res -> menu -> menu_main :** 

    <menu xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        tools:context="databinding.developer.aero.view.MainActivity">
        <item
            android:id="@+id/action_settings"
            android:orderInCategory="100"
            android:title="@string/action_settings"
            app:showAsAction="never" />
    </menu>

**Now we will create layout files. So create ' activity_main ' in res -> layout -> activity_main :**

    <?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:bind="http://schemas.android.com/apk/res/android">
        <data>
            <variable
                name="user"
                type="databinding.developer.aero.model.User" />
        </data>

        <android.support.design.widget.CoordinatorLayout
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:tools="http://schemas.android.com/tools"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            tools:context=".view.MainActivity">

            <android.support.design.widget.AppBarLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:elevation="0dp"
                android:theme="@style/AppTheme.AppBarOverlay">

                <android.support.v7.widget.Toolbar
                    android:id="@+id/toolbar"
                    android:layout_width="match_parent"
                    android:layout_height="?attr/actionBarSize"
                    android:background="?attr/colorPrimary"
                    app:popupTheme="@style/AppTheme.PopupOverlay" />

            </android.support.design.widget.AppBarLayout>

            <!--suppress AndroidUnknownAttribute -->
            <include
                android:id="@+id/content"
                layout="@layout/content_main"
                bind:user="@{user}" />

        </android.support.design.widget.CoordinatorLayout>
    </layout> 

**Create ' post_row_item ' layout file in res -> layout -> post_row_item :**

    <?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:bind="http://schemas.android.com/apk/res/android">

        <data>

            <variable
                name="post"
                type="databinding.developer.aero.model.Post" />
        </data>

        <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

            <!--suppress AndroidUnknownAttribute -->
            <ImageView
                android:id="@+id/thumbnail"
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:scaleType="centerCrop"
                bind:imageUrl="@{post.imageUrl}"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintDimensionRatio="H,1:1"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintRight_toRightOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                android:contentDescription="@string/app_name" />

        </android.support.constraint.ConstraintLayout>
    </layout> 

**Create ' content_main ' layout file in res -> layout -> content_main :**

    <?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:bind="http://schemas.android.com/apk/res/android">

        <data>

            <import type="databinding.developer.aero.utils.BindingUtils" />

            <variable
                name="user"
                type="databinding.developer.aero.model.User" />

            <variable
                name="handlers"
                type="databinding.developer.aero.view.MainActivity.MyClickHandlers" />
        </data>

        <android.support.v4.widget.NestedScrollView xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:tools="http://schemas.android.com/tools"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_behavior="@string/appbar_scrolling_view_behavior">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:focusableInTouchMode="true"
                android:orientation="vertical"
                tools:context=".view.MainActivity"
                tools:showIn="@layout/activity_main">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:background="@color/colorPrimary"
                    android:orientation="vertical"
                    android:paddingBottom="@dimen/activity_margin"
                    android:paddingTop="@dimen/activity_margin">

                    <RelativeLayout
                        android:layout_width="@dimen/profile_image"
                        android:layout_height="@dimen/profile_image"
                        android:layout_gravity="center_horizontal">

                        <ImageView
                            android:id="@+id/profile_image"
                            android:layout_width="@dimen/profile_image"
                            android:layout_height="@dimen/profile_image"
                            android:layout_centerHorizontal="true"
                            android:onLongClick="@{handlers::onProfileImageLongPressed}"
                            bind:profileImage="@{user.profileImage}" />

                        <android.support.design.widget.FloatingActionButton
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_alignParentBottom="true"
                            android:layout_alignParentRight="true"
                            android:onClick="@{handlers::onProfileFabClicked}"
                            android:src="@drawable/ic_add_white_24dp"
                            app:fabCustomSize="@dimen/fab_profile" />

                    </RelativeLayout>


                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_gravity="center_horizontal"
                        android:layout_marginTop="@dimen/dimen_8dp"
                        android:fontFamily="sans-serif"
                        android:letterSpacing="0.1"
                        android:text="@{user.name}"
                        android:textColor="@android:color/white"
                        android:textSize="@dimen/profile_name"
                        android:textStyle="bold" />

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_gravity="center_horizontal"
                        android:fontFamily="sans-serif"
                        android:letterSpacing="0.1"
                        android:text="@{user.about}"
                        android:textColor="@android:color/white"
                        android:textSize="@dimen/profile_about" />

                </LinearLayout>

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginBottom="@dimen/activity_margin"
                    android:layout_marginTop="@dimen/fab_margin"
                    android:orientation="horizontal"
                    android:weightSum="3">

                    <LinearLayout
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_weight="1"
                        android:gravity="center_horizontal"
                        android:onClick="@{handlers::onPostsClicked}"
                        android:orientation="vertical">

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:fontFamily="sans-serif-condensed"
                            android:text="@{BindingUtils.convertToSuffix(user.numberOfPosts)}"
                            android:textColor="@color/profile_meta"
                            android:textSize="24dp"
                            android:textStyle="normal" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:text="@string/posts"
                            android:textSize="@dimen/profile_meta_label" />

                    </LinearLayout>

                    <LinearLayout
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_weight="1"
                        android:gravity="center_horizontal"
                        android:onClick="@{handlers::onFollowersClicked}"
                        android:orientation="vertical">

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:fontFamily="sans-serif-condensed"
                            android:text="@{BindingUtils.convertToSuffix(user.numberOfFollowers)}"
                            android:textColor="@color/profile_meta"
                            android:textSize="24dp" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:text="@string/followers"
                            android:textSize="@dimen/profile_meta_label" />

                    </LinearLayout>

                    <LinearLayout
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_weight="1"
                        android:gravity="center_horizontal"
                        android:onClick="@{handlers::onFollowingClicked}"
                        android:orientation="vertical">

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:fontFamily="sans-serif-condensed"
                            android:text="@{BindingUtils.convertToSuffix(user.numberOfFollowing)}"
                            android:textColor="@color/profile_meta"
                            android:textSize="@dimen/profile_meta" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:text="@string/following"
                            android:textSize="@dimen/profile_meta_label" />

                    </LinearLayout>
                </LinearLayout>

                <android.support.v7.widget.RecyclerView
                    android:id="@+id/recycler_view"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent" />
            </LinearLayout>

        </android.support.v4.widget.NestedScrollView>
    </layout>

***Now after creating layout files. We will create java files for our app. Now their will 3 directories in our package named as ' model ' ' utils ' and ' view ' .I have given the below screenshot how the package will look :***  

--screenshot--

**Now create ' Post.java ' in ' model ' directory :**  

    package databinding.developer.aero.model;

    import android.databinding.BindingAdapter;
    import android.widget.ImageView;

    import com.bumptech.glide.Glide;

    public class Post {
        private String imageUrl;

        @BindingAdapter("imageUrl")
        public static void loadImage(ImageView view, String imageUrl) {
            Glide.with(view.getContext())
                    .load(imageUrl)
                    .into(view);
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

**Now create ' User.java ' in ' model ' directory :**

    package databinding.developer.aero.model;

    import android.databinding.BaseObservable;
    import android.databinding.Bindable;
    import android.databinding.BindingAdapter;
    import android.databinding.ObservableField;
    import android.widget.ImageView;

    import com.bumptech.glide.Glide;
    import com.bumptech.glide.request.RequestOptions;

    import databinding.developer.aero.BR;

    public class User extends BaseObservable {
        private String name;
        private String email;
        private String profileImage;
        private String about;


        // profile meta fields are ObservableField, will update the UI
        // whenever a new value is set
        public final ObservableField<Long> numberOfFollowers = new ObservableField<>();
        public final ObservableField<Long> numberOfPosts = new ObservableField<>();
        public final ObservableField<Long> numberOfFollowing = new ObservableField<>();

        public User() {
        }

        @Bindable
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
            notifyPropertyChanged(BR.name);
        }

        @Bindable
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
            notifyPropertyChanged(BR.email);
        }

        @BindingAdapter({"profileImage"})
        public static void loadImage(ImageView view, String imageUrl) {
            Glide.with(view.getContext())
                    .load(imageUrl)
                    .apply(RequestOptions.circleCropTransform())
                    .into(view);

            // If you consider Picasso, follow the below
            // Picasso.with(view.getContext()).load(imageUrl).placeholder(R.drawable.placeholder).into(view);
        }

        @Bindable
        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
            notifyPropertyChanged(BR.profileImage);
        }

        @Bindable
        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
            notifyPropertyChanged(BR.about);
        }

        public ObservableField<Long> getNumberOfFollowers() {
            return numberOfFollowers;
        }

        public ObservableField<Long> getNumberOfPosts() {
            return numberOfPosts;
        }

        public ObservableField<Long> getNumberOfFollowing() {
            return numberOfFollowing;
        }
    }

**Now create ' BindingUtils.java ' in ' utils ' directory :**    

    package databinding.developer.aero.utils;

    import android.annotation.SuppressLint;

    public class BindingUtils {
        @SuppressLint("DefaultLocale")
        public static String convertToSuffix(long count) {
            if (count < 1000) return "" + count;
            int exp = (int) (Math.log(count) / Math.log(1000));
            return String.format("%.1f%c",
                    count / Math.pow(1000, exp),
                    "kmgtpe".charAt(exp - 1));
        }
    }
    
**Now create ' GridSpacingItemDecoration.java ' in ' utils ' directory :**     

    package databinding.developer.aero.utils;

    import android.graphics.Rect;
    import android.support.v7.widget.RecyclerView;
    import android.view.View;

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private final int spanCount;
        private final int spacing;
        private final boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount) {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing;
                }
            }
        }
    }

**Now create ' MainActivity.java ' in ' view ' directory :**      

    package databinding.developer.aero.view;

    import android.content.Context;
    import android.content.res.Resources;
    import android.databinding.DataBindingUtil;
    import android.os.Build;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.DefaultItemAnimator;
    import android.support.v7.widget.GridLayoutManager;
    import android.support.v7.widget.RecyclerView;
    import android.support.v7.widget.Toolbar;
    import android.util.TypedValue;
    import android.view.View;
    import android.widget.Toast;

    import java.util.ArrayList;
    import java.util.Objects;

    import databinding.developer.aero.R;
    import databinding.developer.aero.databinding.ActivityMainBinding;
    import databinding.developer.aero.model.Post;
    import databinding.developer.aero.model.User;
    import databinding.developer.aero.utils.GridSpacingItemDecoration;

    public class MainActivity extends AppCompatActivity implements PostsAdapter.PostsAdapterListener {

        private MyClickHandlers handlers;
        private ActivityMainBinding binding;
        private User user;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

            Toolbar toolbar = binding.toolbar;
            setSupportActionBar(toolbar);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.toolbar_profile);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            }

            handlers = new MyClickHandlers(this);

            initRecyclerView();

            renderProfile();
        }

        /**
         * Renders RecyclerView with Grid Images in 3 columns
         */
        private void initRecyclerView() {
            RecyclerView recyclerView = binding.content.recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(), true));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(false);
            PostsAdapter mAdapter = new PostsAdapter(getPosts(), this);
            recyclerView.setAdapter(mAdapter);
        }

        /**
         * Renders user profile data
         */
        private void renderProfile() {
            user = new User();
            user.setName("Akshay");
            user.setEmail("akshaysunilmasram@yahoo.com");
            user.setProfileImage("https://img1.wsimg.com/isteam/ip/0f03fc0f-5c03-4469-88dc-b6da2519b66b/logo/c13694bd-2374-4e02-81d8-2a5bf7a8a229.png");
            user.setAbout("Android Developer");

            // ObservableField doesn't have setter method, instead will
            // be called using set() method
            user.numberOfPosts.set(5L);
            user.numberOfFollowers.set(30L);
            user.numberOfFollowing.set(15L);


            // display user
            binding.setUser(user);

            // assign click handlers
            binding.content.setHandlers(handlers);
        }

        private ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Post post = new Post();
            //TODO Change this URL so that images can shown as post
            post.setImageUrl("https://akshuandroid.info/api/" + i + ".png");

            posts.add(post);
        }

        return posts;
        }

        @Override
        public void onPostClicked(Post post) {
            Toast.makeText(getApplicationContext(), "Post clicked! " + post.getImageUrl(), Toast.LENGTH_SHORT).show();
        }

        public class MyClickHandlers {

            final Context context;

            MyClickHandlers(Context context) {
                this.context = context;
            }

            /**
             * Demonstrating updating bind data
             * Profile name, number of posts and profile image
             * will be updated on Fab click
             */
            public void onProfileFabClicked(@SuppressWarnings("unused") View view) {
                user.setName("Akshay");
                user.setProfileImage("https://img1.wsimg.com/isteam/ip/0f03fc0f-5c03-4469-88dc-b6da2519b66b/logo/c13694bd-2374-4e02-81d8-2a5bf7a8a229.png");

                // updating ObservableField
                user.numberOfPosts.set(5L);
                user.numberOfFollowers.set(50L);
                user.numberOfFollowing.set(18L);
            }

            @SuppressWarnings("SameReturnValue")
            public boolean onProfileImageLongPressed(@SuppressWarnings("unused") View view) {
                Toast.makeText(getApplicationContext(), "Profile image long pressed!", Toast.LENGTH_LONG).show();
                return false;
            }


            public void onFollowersClicked(@SuppressWarnings("unused") View view) {
                Toast.makeText(context, "Followers is clicked!", Toast.LENGTH_SHORT).show();
            }

            public void onFollowingClicked(@SuppressWarnings("unused") View view) {
                Toast.makeText(context, "Following is clicked!", Toast.LENGTH_SHORT).show();
            }

            public void onPostsClicked(@SuppressWarnings("unused") View view) {
                Toast.makeText(context, "Posts is clicked!", Toast.LENGTH_SHORT).show();
            }
        }

        /**
         * Converting dp to pixel
         */
        private int dpToPx() {
            Resources r = getResources();
            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, r.getDisplayMetrics()));
        }
    }

**Now create ' PostsAdapter.java ' in ' view ' directory :**     

    package databinding.developer.aero.view;

    import android.annotation.SuppressLint;
    import android.databinding.DataBindingUtil;
    import android.support.annotation.NonNull;
    import android.support.v7.widget.RecyclerView;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;

    import java.util.List;

    import databinding.developer.aero.R;
    import databinding.developer.aero.databinding.PostRowItemBinding;
    import databinding.developer.aero.model.Post;

    public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {

        private final List<Post> postList;
        private LayoutInflater layoutInflater;
        private final PostsAdapterListener listener;

        class MyViewHolder extends RecyclerView.ViewHolder {

            private final PostRowItemBinding binding;

            MyViewHolder(final PostRowItemBinding itemBinding) {
                super(itemBinding.getRoot());
                this.binding = itemBinding;
            }
        }


        PostsAdapter(List<Post> postList, PostsAdapterListener listener) {
            this.postList = postList;
            this.listener = listener;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(parent.getContext());
            }
            PostRowItemBinding binding =
                    DataBindingUtil.inflate(layoutInflater, R.layout.post_row_item, parent, false);
            return new MyViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            holder.binding.setPost(postList.get(position));
            holder.binding.thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onPostClicked(postList.get(position));
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return postList.size();
        }

        public interface PostsAdapterListener {
            void onPostClicked(Post post);
        }
    }
    
**And Finally this will be your Manifest.xml file :**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="databinding.developer.aero">

        <uses-permission android:name="android.permission.INTERNET" />

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme">
            <activity android:name=".view.MainActivity"
                android:label="@string/app_name"
                android:theme="@style/AppTheme.NoActionBar">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>

    </manifest>    

**Output :**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/DataBinding/art/databinding.png)
