***We all know the good old SQLite when times are asking for an internal storage. But times are changing and here it comes Realm which is on a great way to replace SQLite. So let's start the tutorial :***

**This is your build.gradle(Module:app) file :**

    apply plugin: 'com.android.application'

    android {
        compileSdkVersion 27
        defaultConfig {
            applicationId "realm.developer.aero"
            minSdkVersion 17
            targetSdkVersion 27
            versionCode 1
            versionName "1.0"
        }

        packagingOptions {
            exclude 'META-INF/services/javax.annotation.processing.Processor'
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
        androidTestImplementation 'com.android.support.test:runner:1.0.2'
        androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'

        // App Compact
        implementation 'com.android.support:appcompat-v7:27.1.1'

        // Support
        implementation 'com.android.support:support-v4:27.1.1'

        // Design
        implementation 'com.android.support:design:27.1.1'

        // Glide
        //noinspection GradleDependency
        implementation 'com.github.bumptech.glide:glide:3.7.0'

        // Realm
        annotationProcessor 'io.realm:realm-android:0.82.1'
        implementation 'io.realm:realm-android:0.82.1'

        // RecyclerView
        implementation 'com.android.support:recyclerview-v7:27.1.1'

        // CardView
        implementation 'com.android.support:cardview-v7:27.1.1'

        //Constraint Layout
        implementation 'com.android.support.constraint:constraint-layout:1.1.0'
    }
    
**This is Strings.xml file :**

    <resources>
        <string name="app_name">Realm</string>
        <string name="title">Title</string>
        <string name="author">Author</string>
        <string name="image">Image</string>
    </resources>
    
** Dimens.xml :**

    <resources>
        <!-- Default screen margins, per the Android Design guidelines. -->
        <dimen name="activity_horizontal_margin">16dp</dimen>
        <dimen name="activity_vertical_margin">16dp</dimen>
        <dimen name="margin_normal">8dp</dimen>
        <dimen name="margin_large">16dp</dimen>
        <dimen name="text_size_large">16sp</dimen>
        <dimen name="margin_small">0dp</dimen>
        <dimen name="text_size_normal">13sp</dimen>
        <dimen name="imge_book_detail">80dp</dimen>
    </resources>
    
**Now we will create layout files. create ' activity_main.xml ' layout file in res -> layout -> activity_main.xml :**

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.design.widget.CoordinatorLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <android.support.design.widget.AppBarLayout
            android:id="@+id/appbar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar">

            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                app:contentScrim="?attr/colorPrimary"
                app:layout_scrollFlags="enterAlways" />

        </android.support.design.widget.AppBarLayout>

        <include layout="@layout/content_main" />

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="16dp"
            android:src="@mipmap/ic_add_white_24dp"
            app:backgroundTint="@color/colorPrimary"
            app:elevation="4dp"
            app:layout_anchor="@+id/recycler"
            app:layout_anchorGravity="bottom|right|end" />

    </android.support.design.widget.CoordinatorLayout>
    
** content_main.xml layout file :**

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.v7.widget.RecyclerView
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/recycler"
        android:layout_width="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior"
        android:layout_height="match_parent" />  

**edit_item.xml  layout file :**

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <EditText
        android:id="@+id/title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="@dimen/activity_horizontal_margin"
        android:hint="@string/title"
        android:inputType="text" />

        <EditText
            android:id="@+id/author"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="@dimen/activity_horizontal_margin"
            android:hint="@string/author"
            android:inputType="text" />

        <EditText
            android:id="@+id/thumbnail"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="@dimen/activity_horizontal_margin"
            android:hint="@string/image"
            android:inputType="text" />

    </LinearLayout> 

** item_books.xml layout file :**

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.v7.widget.CardView
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/card_books"
        style="@style/AppTheme.Card.Margins"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <ImageView
                android:id="@+id/image_background"
                android:layout_width="130dp"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical|start"
                android:contentDescription="@string/app_name" />

            <LinearLayout
                android:id="@+id/layout_partner"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:paddingBottom="@dimen/margin_normal">

                <TextView
                    android:id="@+id/text_books_title"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginBottom="@dimen/margin_small"
                    android:paddingBottom="@dimen/margin_normal"
                    android:paddingLeft="@dimen/margin_large"
                    android:paddingRight="@dimen/margin_large"
                    android:paddingTop="@dimen/margin_large"
                    android:textSize="@dimen/text_size_large"
                    android:textColor="#555555"
                    android:textStyle="bold" />

                <TextView
                    android:id="@+id/text_books_author"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:paddingLeft="@dimen/margin_large"
                    android:paddingRight="@dimen/margin_large"
                    android:textSize="@dimen/text_size_normal"
                    android:textStyle="italic" />

                <TextView
                    android:id="@+id/text_books_description"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginBottom="@dimen/margin_small"
                    android:maxLines="2"
                    android:paddingBottom="@dimen/margin_normal"
                    android:paddingLeft="@dimen/margin_large"
                    android:paddingRight="@dimen/margin_large"
                    android:paddingTop="@dimen/margin_small"
                    android:textSize="@dimen/text_size_normal" />

            </LinearLayout>
        </LinearLayout>
    </android.support.v7.widget.CardView>
    
***Now after creating layout files. we will create java files for our app. below is the screenshot given about how our package will look :***

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Realm/art/Capture.PNG)

**Create a ' activity ' directory in package and in activity directory create MainActivity.java file     

    package realm.developer.aero.activity;

    import android.annotation.SuppressLint;
    import android.content.DialogInterface;
    import android.os.Bundle;
    import android.support.design.widget.FloatingActionButton;
    import android.support.v7.app.AlertDialog;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.LinearLayoutManager;
    import android.support.v7.widget.RecyclerView;
    import android.support.v7.widget.Toolbar;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.widget.EditText;
    import android.widget.Toast;
    import java.util.ArrayList;
    import io.realm.Realm;
    import io.realm.RealmResults;
    import realm.developer.aero.R;
    import realm.developer.aero.adapters.BooksAdapter;
    import realm.developer.aero.adapters.RealmBooksAdapter;
    import realm.developer.aero.app.Prefs;
    import realm.developer.aero.model.Book;
    import realm.developer.aero.realm.RealmController;

    public class MainActivity extends AppCompatActivity {

        private BooksAdapter adapter;
        private Realm realm;
        private LayoutInflater inflater;
        private RecyclerView recycler;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            FloatingActionButton fab = findViewById(R.id.fab);
            recycler = findViewById(R.id.recycler);

            //get realm instance
            this.realm = RealmController.with(this).getRealm();

            //set toolbar
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            setupRecycler();

            if (!Prefs.with(this).getPreLoad()) {
                setRealmData();
            }

            // refresh the realm instance
            RealmController.with(this).refresh();
            // get all persisted objects
            // create the helper adapter and notify data set changes
            // changes will be reflected automatically
            setRealmAdapter(RealmController.with(this).getBooks());

            Toast.makeText(this, "Press card item for edit, long press to remove item", Toast.LENGTH_LONG).show();

            //add new item
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    inflater = MainActivity.this.getLayoutInflater();
                    @SuppressLint("InflateParams") View content = inflater.inflate(R.layout.edit_item, null);
                    final EditText editTitle = content.findViewById(R.id.title);
                    final EditText editAuthor = content.findViewById(R.id.author);
                    final EditText editThumbnail = content.findViewById(R.id.thumbnail);

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setView(content)
                            .setTitle("Add book")
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Book book = new Book();
                                    //book.setId(RealmController.getInstance().getBooks().size() + 1);
                                    book.setId(RealmController.getInstance().getBooks().size() + System.currentTimeMillis());
                                    book.setTitle(editTitle.getText().toString());
                                    book.setAuthor(editAuthor.getText().toString());
                                    book.setImageUrl(editThumbnail.getText().toString());

                                    if (editTitle.getText() == null || editTitle.getText().toString().equals("") || editTitle.getText().toString().equals(" ")) {
                                        Toast.makeText(MainActivity.this, "Entry not saved, missing title", Toast.LENGTH_SHORT).show();
                                    } else {
                                        // Persist your data easily
                                        realm.beginTransaction();
                                        realm.copyToRealm(book);
                                        realm.commitTransaction();

                                        adapter.notifyDataSetChanged();

                                        // scroll the recycler view to bottom
                                        recycler.scrollToPosition(RealmController.getInstance().getBooks().size() - 1);
                                    }
                                }
                            })
                            .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        }

        private void setRealmAdapter(RealmResults<Book> books) {

            RealmBooksAdapter realmAdapter = new RealmBooksAdapter(this.getApplicationContext(), books, true);
            // Set the data and tell the RecyclerView to draw
            adapter.setRealmAdapter(realmAdapter);
            adapter.notifyDataSetChanged();
        }

        private void setupRecycler() {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            recycler.setHasFixedSize(true);

            // use a linear layout manager since the cards are vertically scrollable
            final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recycler.setLayoutManager(layoutManager);

            // create an empty adapter and add it to the recycler view
            adapter = new BooksAdapter(this);
            recycler.setAdapter(adapter);
        }

        private void setRealmData() {

            ArrayList<Book> books = new ArrayList<>();

            Book book = new Book();
            book.setId(1 + System.currentTimeMillis());
            book.setAuthor("Akshuandroid");
            book.setTitle("Android App Development");
            book.setImageUrl("https://img1.wsimg.com/isteam/ip/0f03fc0f-5c03-4469-88dc-b6da2519b66b/logo/40f567cd-c8d5-42d1-9eae-5063f4e8abd4.png");
            books.add(book);

            for (Book b : books) {
                // Persist your data easily
                realm.beginTransaction();
                realm.copyToRealm(b);
                realm.commitTransaction();
            }

            Prefs.with(this).setPreLoad(true);

        }
    }
    
** Now create a adapters directory and in adapters directory we will create 4 java files. So firstly create ' RealmBooksAdapter.java ' file in adapters directory :**    

    package realm.developer.aero.adapters;

    import android.content.Context;
    import io.realm.RealmResults;
    import realm.developer.aero.model.Book;

    public class RealmBooksAdapter extends RealmModelAdapter<Book> {

        public RealmBooksAdapter(Context context, RealmResults<Book> realmResults, boolean automaticUpdate) {

            super(context, realmResults, automaticUpdate);
        }
    }
    
** Create ' RealmModelAdapter.java ' in adapters directory :**    

    package realm.developer.aero.adapters;

    import android.content.Context;
    import android.view.View;
    import android.view.ViewGroup;
    import io.realm.RealmBaseAdapter;
    import io.realm.RealmObject;
    import io.realm.RealmResults;

    class RealmModelAdapter<T extends RealmObject> extends RealmBaseAdapter<T> {

        RealmModelAdapter(Context context, RealmResults<T> realmResults, boolean automaticUpdate) {

            super(context, realmResults, automaticUpdate);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            return null;
        }
    }
 
** Create ' RealmRecyclerViewAdapter.java ' in adapters directory :**  

    package realm.developer.aero.adapters;

    import android.support.v7.widget.RecyclerView;
    import io.realm.RealmBaseAdapter;
    import io.realm.RealmObject;

    public abstract class RealmRecyclerViewAdapter<T extends RealmObject> extends RecyclerView.Adapter {

        private RealmBaseAdapter<T> realmBaseAdapter;

        T getItem(int position) {

            return realmBaseAdapter.getItem(position);
        }

        RealmBaseAdapter<T> getRealmAdapter() {

            return realmBaseAdapter;
        }

        public void setRealmAdapter(RealmBaseAdapter<T> realmAdapter) {

            realmBaseAdapter = realmAdapter;
        }
    }
    
** Create ' BooksAdapter.java ' in adapters directory :**      

    package realm.developer.aero.adapters;

    import android.annotation.SuppressLint;
    import android.content.Context;
    import android.content.DialogInterface;
    import android.support.annotation.NonNull;
    import android.support.v7.app.AlertDialog;
    import android.support.v7.widget.CardView;
    import android.support.v7.widget.RecyclerView;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.EditText;
    import android.widget.ImageView;
    import android.widget.TextView;
    import android.widget.Toast;
    import com.bumptech.glide.Glide;
    import io.realm.Realm;
    import io.realm.RealmResults;
    import realm.developer.aero.R;
    import realm.developer.aero.app.Prefs;
    import realm.developer.aero.model.Book;
    import realm.developer.aero.realm.RealmController;

    public class BooksAdapter extends RealmRecyclerViewAdapter<Book> {

        private final Context context;
        private Realm realm;
        private LayoutInflater inflater;

        public BooksAdapter(Context context) {

            this.context = context;
        }

        // create new views (invoked by the layout manager)
        @NonNull
        @Override
        public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // inflate a new card view
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_books, parent, false);
            return new CardViewHolder(view);
        }

        // replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {

            realm = RealmController.getInstance().getRealm();

            // get the article
            final Book book = getItem(position);
            // cast the generic view holder to our specific one
            final CardViewHolder holder = (CardViewHolder) viewHolder;

            // set the title and the snippet
            holder.textTitle.setText(book.getTitle());
            holder.textAuthor.setText(book.getAuthor());
            holder.textDescription.setText(book.getDescription());

            // load the background image
            if (book.getImageUrl() != null) {
                Glide.with(context)
                        .load(book.getImageUrl().replace("https", "http"))
                        .asBitmap()
                        .fitCenter()
                        .into(holder.imageBackground);
            }

            //remove single match from realm
            holder.card.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    RealmResults<Book> results = realm.where(Book.class).findAll();

                    // Get the book title to show it in toast message
                    Book b = results.get(position);
                    String title = b.getTitle();

                    // All changes to data must happen in a transaction
                    realm.beginTransaction();

                    // remove single match
                    results.remove(position);
                    realm.commitTransaction();

                    if (results.size() == 0) {
                        Prefs.with(context).setPreLoad(false);
                    }

                    notifyDataSetChanged();

                    Toast.makeText(context, title + " is removed from Realm", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });

            //update single match from realm
            holder.card.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    assert inflater != null;
                    @SuppressLint("InflateParams") View content = inflater.inflate(R.layout.edit_item, null);
                    final EditText editTitle = content.findViewById(R.id.title);
                    final EditText editAuthor = content.findViewById(R.id.author);
                    final EditText editThumbnail = content.findViewById(R.id.thumbnail);

                    editTitle.setText(book.getTitle());
                    editAuthor.setText(book.getAuthor());
                    editThumbnail.setText(book.getImageUrl());

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setView(content)
                            .setTitle("Edit Book")
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    RealmResults<Book> results = realm.where(Book.class).findAll();

                                    realm.beginTransaction();
                                    results.get(position).setAuthor(editAuthor.getText().toString());
                                    results.get(position).setTitle(editTitle.getText().toString());
                                    results.get(position).setImageUrl(editThumbnail.getText().toString());

                                    realm.commitTransaction();

                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        }

        // return the size of your data set (invoked by the layout manager)
        public int getItemCount() {

            if (getRealmAdapter() != null) {
                return getRealmAdapter().getCount();
            }
            return 0;
        }

        public static class CardViewHolder extends RecyclerView.ViewHolder {

            final CardView card;
            final TextView textTitle;
            final TextView textAuthor;
            final TextView textDescription;
            final ImageView imageBackground;

            CardViewHolder(View itemView) {
                // standard view holder pattern with Butterknife view injection
                super(itemView);

                card = itemView.findViewById(R.id.card_books);
                textTitle = itemView.findViewById(R.id.text_books_title);
                textAuthor = itemView.findViewById(R.id.text_books_author);
                textDescription = itemView.findViewById(R.id.text_books_description);
                imageBackground = itemView.findViewById(R.id.image_background);
            }
        }
    }
    
**Now create ' app ' named directory in your package and in app directory their will be 2 java files. So firstly create MyApplication.java file :**   

    package realm.developer.aero.app;

    import android.app.Application;
    import io.realm.Realm;
    import io.realm.RealmConfiguration;

    public class MyApplication extends Application {

        @Override
        public void onCreate() {

            super.onCreate();
            RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                    .name(Realm.DEFAULT_REALM_NAME)
                    .schemaVersion(0)
                    .deleteRealmIfMigrationNeeded()
                    .build();
            Realm.setDefaultConfiguration(realmConfiguration);

        }
    }
    
**Create Prefs.java file in app directory :**

    package realm.developer.aero.app;

    import android.content.Context;
    import android.content.SharedPreferences;

    public class Prefs {

        private static final String PRE_LOAD = "preLoad";
        private static final String PREFS_NAME = "prefs";
        private static Prefs instance;
        private final SharedPreferences sharedPreferences;

        private Prefs(Context context) {

            sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        }

        public static Prefs with(Context context) {

            if (instance == null) {
                instance = new Prefs(context);
            }
            return instance;
        }

        public void setPreLoad(boolean totalTime) {

            sharedPreferences
                    .edit()
                    .putBoolean(PRE_LOAD, totalTime)
                    .apply();
        }

        public boolean getPreLoad(){
            return sharedPreferences.getBoolean(PRE_LOAD, false);
       }

    }
    
**Now create a model directory in your package and in model directory create Book.java file :**

    package realm.developer.aero.model;

    import io.realm.RealmObject;
    import io.realm.annotations.PrimaryKey;

    public class Book extends RealmObject {

        @PrimaryKey
        private long id;

        private String title;

        private String description;

        private String author;

        private String imageUrl;

        // Standard getters & setters generated by your IDE…
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
 
**Now create a realm directory in your package and in realm directory create RealmController.java file :** 

    package realm.developer.aero.realm;

    import android.app.Activity;
    import android.app.Application;
    import android.os.Build;
    import android.support.v4.app.Fragment;

    import java.util.Objects;

    import io.realm.Realm;
    import io.realm.RealmResults;
    import realm.developer.aero.model.Book;

    public class RealmController {

        private static RealmController instance;
        private final Realm realm;

        private RealmController(@SuppressWarnings("unused") Application application) {
            realm = Realm.getDefaultInstance();
        }

        @SuppressWarnings("unused")
        public static RealmController with(Fragment fragment) {

            if (instance == null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    instance = new RealmController(Objects.requireNonNull(fragment.getActivity()).getApplication());
                }
            }
            return instance;
        }

        public static RealmController with(Activity activity) {

            if (instance == null) {
                instance = new RealmController(activity.getApplication());
            }
            return instance;
        }

        @SuppressWarnings("unused")
        public static RealmController with(Application application) {

            if (instance == null) {
                instance = new RealmController(application);
            }
            return instance;
        }

        public static RealmController getInstance() {

            return instance;
        }

        public Realm getRealm() {

            return realm;
        }

        public void refresh() {

            realm.refresh();
        }

        @SuppressWarnings("unused")
        public void clearAll() {

            realm.beginTransaction();
            realm.clear(Book.class);
            realm.commitTransaction();
        }

        public RealmResults<Book> getBooks() {

            return realm.where(Book.class).findAll();
        }

        @SuppressWarnings("unused")
        public Book getBook(String id) {

            return realm.where(Book.class).equalTo("id", id).findFirst();
        }

        @SuppressWarnings("unused")
        public boolean hasBooks() {

            return !realm.allObjects(Book.class).isEmpty();
        }

        //query example
        @SuppressWarnings("unused")
        public RealmResults<Book> queryedBooks() {

            return realm.where(Book.class)
                    .contains("author", "Author 0")
                    .or()
                    .contains("title", "Realm")
                    .findAll();

        }
    }
    
**And lastly this will be your manifest file :**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="realm.developer.aero">

        <uses-permission android:name="android.permission.INTERNET"/>

        <application
            android:name=".app.MyApplication"
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme">
            <activity android:name=".activity.MainActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>

    </manifest>  

**Output :**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Realm/art/realm.png)
