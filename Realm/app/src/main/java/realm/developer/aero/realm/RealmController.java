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
