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
