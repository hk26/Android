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