***SQLite is a open source SQL database that stores data to a text file on a device. Android comes in with built in SQLite database implementation.So in this tutorial you will learn to create a simple SQLite App.***

**Write this in your Strings file:**

		<?xml version="1.0" encoding="utf-8"?>
		<resources>
			<string name="app_name">Contact</string>
			<string name="action_settings">Settings</string>
			<string name="Add_New">Add New</string>
			<string name="edit">Edit Contact</string>
			<string name="delete">Delete Contact</string>
			<string name="title_activity_display_contact">DisplayContact</string>
			<string name="name">Name</string>
			<string name="phone">Phone</string>
			<string name="save">Save Contact</string>
			<string name="deleteContact">Are you sure, you want to delete it.</string>
			<string name="yes">Yes</string>
			<string name="no">No</string>
		</resources>
		

***Now create a menu directory in res-> menu.And under menu directory create ' menu_main ' and ' display_contact ' menu file:***

**menu_main file:**

		<?xml version="1.0" encoding="utf-8"?>
		<menu xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:android="http://schemas.android.com/apk/res/android" >

			<item
				android:id="@+id/item1"
				android:icon="@drawable/ic_add"
				android:title="@string/Add_New"
				app:showAsAction="always">
			</item>

		</menu>	

**display_contact file:**

		<?xml version="1.0" encoding="utf-8"?>
		<menu xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:android="http://schemas.android.com/apk/res/android" >
			<item
				android:id="@+id/Edit_Contact"
				android:icon="@drawable/ic_edit"
				android:orderInCategory="100"
				android:title="@string/edit"
				app:showAsAction="always" />

			<item
				android:id="@+id/Delete_Contact"
				android:icon="@drawable/ic_delete"
				android:orderInCategory="100"
				app:showAsAction="ifRoom"
				android:title="@string/delete"/>

		</menu>	

**Now let's create layout file for our app. So create activity_main layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			tools:context=".MainActivity">

			<ListView
				android:id="@+id/listView1"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:layout_centerHorizontal="true">
			</ListView>
		</RelativeLayout>

**Now create activity_display_contact layout file:**

		<?xml version="1.0" encoding="utf-8"?>
		<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			android:id="@+id/view1"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			tools:context=".DisplayContact" >

			<EditText
				android:id="@+id/editTextName"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:layout_above="@+id/editTextPhone"
				android:layout_centerHorizontal="true"
				android:layout_marginBottom="31dp"
				android:ems="10"
				android:inputType="text"
				android:hint="@string/name"
				tools:ignore="LabelFor">

			</EditText>


			<EditText
				android:id="@+id/editTextPhone"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:layout_centerHorizontal="true"
				android:layout_centerVertical="true"
				android:ems="10"
				android:hint="@string/phone"
				android:inputType="phone|text"
				tools:ignore="LabelFor" />

			<Button
				android:id="@+id/button1"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:layout_alignParentBottom="true"
				android:layout_centerHorizontal="true"
				android:layout_marginBottom="125dp"
				android:onClick="run"
				android:text="@string/save" />
		</RelativeLayout>	

**Now we will java file's for our app. So firstly create MainActivity.java file:**

		package sql.developer.aero;

		import android.content.Intent;
		import android.os.Bundle;
		import android.support.annotation.Nullable;
		import android.support.v7.app.AppCompatActivity;
		import android.support.v7.widget.Toolbar;
		import android.view.KeyEvent;
		import android.view.Menu;
		import android.view.MenuItem;
		import android.view.View;
		import android.widget.AdapterView;
		import android.widget.ArrayAdapter;
		import android.widget.AdapterView.OnItemClickListener;
		import android.widget.ListView;
		import java.util.ArrayList;

		public class MainActivity extends AppCompatActivity {
			@SuppressWarnings("unused")
			public final static String EXTRA_MESSAGE = "MESSAGE";

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);

				setContentView(R.layout.activity_main);

				DBHelper mydb = new DBHelper(this);
				ArrayList array_list = mydb.getAllCotacts();
				//noinspection unchecked
				ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);

				ListView obj = findViewById(R.id.listView1);
				obj.setAdapter(arrayAdapter);
				obj.setOnItemClickListener(new OnItemClickListener(){
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {

						int id_To_Search = arg2 + 1;

						Bundle dataBundle = new Bundle();
						dataBundle.putInt("id", id_To_Search);

						Intent intent = new Intent(getApplicationContext(),DisplayContact.class);

						intent.putExtras(dataBundle);
						startActivity(intent);
					}
				});
			}

			@Override
			public boolean onCreateOptionsMenu(Menu menu) {
				// Inflate the menu; this adds items to the action bar if it is present.
				getMenuInflater().inflate(R.menu.menu_main, menu);
				return true;
			}

			@Override
			public boolean onOptionsItemSelected(MenuItem item){
				super.onOptionsItemSelected(item);

				switch(item.getItemId()) {
					case R.id.item1:Bundle dataBundle = new Bundle();
						dataBundle.putInt("id", 0);

						Intent intent = new Intent(getApplicationContext(),DisplayContact.class);
						intent.putExtras(dataBundle);

						startActivity(intent);
						return true;
					default:
						return super.onOptionsItemSelected(item);
				}
			}

			public boolean onKeyDown(int keycode, KeyEvent event) {
				if (keycode == KeyEvent.KEYCODE_BACK) {
					moveTaskToBack(true);
				}
				return super.onKeyDown(keycode, event);
			}
		}	

**Now Create DisplayContact.java file:**

		package sql.developer.aero;

		import android.os.Bundle;
		import android.app.Activity;
		import android.app.AlertDialog;
		import android.content.DialogInterface;
		import android.content.Intent;
		import android.database.Cursor;
		import android.support.v7.app.AppCompatActivity;
		import android.view.Menu;
		import android.view.MenuItem;
		import android.view.View;
		import android.widget.Button;
		import android.widget.TextView;
		import android.widget.Toast;

		public class DisplayContact extends AppCompatActivity {
			@SuppressWarnings("unused")
			int from_Where_I_Am_Coming = 0;
			private DBHelper mydb ;

			private TextView name ;
			private TextView phone;

			private int id_To_Update = 0;

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_display_contact);
				name = findViewById(R.id.editTextName);
				phone = findViewById(R.id.editTextPhone);


				mydb = new DBHelper(this);

				Bundle extras = getIntent().getExtras();
				if(extras !=null) {
					int Value = extras.getInt("id");

					if(Value>0){
						//means this is the view part not the add contact part.
						Cursor rs = mydb.getData(Value);
						id_To_Update = Value;
						rs.moveToFirst();

						String nam = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_NAME));
						String phon = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_PHONE));


						if (!rs.isClosed())  {
							rs.close();
						}
						Button b = findViewById(R.id.button1);
						b.setVisibility(View.INVISIBLE);

						name.setText(nam);
						name.setFocusable(false);
						name.setClickable(false);

						phone.setText(phon);
						phone.setFocusable(false);
						phone.setClickable(false);


					}
				}
			}

			@Override
			public boolean onCreateOptionsMenu(Menu menu) {
				// Inflate the menu; this adds items to the action bar if it is present.
				Bundle extras = getIntent().getExtras();

				if(extras !=null) {
					int Value = extras.getInt("id");
					if(Value>0){
						getMenuInflater().inflate(R.menu.display_contact, menu);
					} else{
						getMenuInflater().inflate(R.menu.menu_main, menu);
					}
				}
				return true;
			}

			public boolean onOptionsItemSelected(MenuItem item) {
				super.onOptionsItemSelected(item);
				switch(item.getItemId()) {
					case R.id.Edit_Contact:
						Button b = findViewById(R.id.button1);
						b.setVisibility(View.VISIBLE);
						name.setEnabled(true);
						name.setFocusableInTouchMode(true);
						name.setClickable(true);

						phone.setEnabled(true);
						phone.setFocusableInTouchMode(true);
						phone.setClickable(true);



						return true;
					case R.id.Delete_Contact:

						AlertDialog.Builder builder = new AlertDialog.Builder(this);
						builder.setMessage(R.string.deleteContact)
								.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int id) {
										mydb.deleteContact(id_To_Update);
										Toast.makeText(getApplicationContext(), "Deleted Successfully",
												Toast.LENGTH_SHORT).show();
										Intent intent = new Intent(getApplicationContext(),MainActivity.class);
										startActivity(intent);
									}
								})
								.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int id) {
										// User cancelled the dialog
									}
								});

						AlertDialog d = builder.create();
						d.setTitle("Are you sure");
						d.show();

						return true;
					default:
						return super.onOptionsItemSelected(item);

				}
			}

			@SuppressWarnings("unused")
			public void run(View view) {
				Bundle extras = getIntent().getExtras();
				if(extras !=null) {
					int Value = extras.getInt("id");
					if(Value>0){
						if(mydb.updateContact(id_To_Update,name.getText().toString(), phone.getText().toString())){
							Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
							Intent intent = new Intent(getApplicationContext(),MainActivity.class);
							startActivity(intent);
						} else{
							Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
						}
					} else{
						if(mydb.insertContact(name.getText().toString(), phone.getText().toString())){
							Toast.makeText(getApplicationContext(), "done",
									Toast.LENGTH_SHORT).show();
						} else{
							Toast.makeText(getApplicationContext(), "not done",
									Toast.LENGTH_SHORT).show();
						}
						Intent intent = new Intent(getApplicationContext(),MainActivity.class);
						startActivity(intent);
					}
				}
			}
		}	

**Now create DBHelper.java file:**

		package sql.developer.aero;

		import java.util.ArrayList;
		import java.util.HashMap;

		import android.annotation.SuppressLint;
		import android.content.ContentValues;
		import android.content.Context;
		import android.database.Cursor;
		import android.database.DatabaseUtils;
		import android.database.sqlite.SQLiteOpenHelper;
		import android.database.sqlite.SQLiteDatabase;

		public class DBHelper extends SQLiteOpenHelper {

			private static final String DATABASE_NAME = "MyDBName.db";
			private static final String CONTACTS_TABLE_NAME = "contacts";
			@SuppressWarnings("unused")
			public static final String CONTACTS_COLUMN_ID = "id";
			static final String CONTACTS_COLUMN_NAME = "name";

			static final String CONTACTS_COLUMN_PHONE = "phone";
			@SuppressWarnings("unused")
			private HashMap hp;

			DBHelper(Context context) {
				super(context, DATABASE_NAME , null, 1);
			}

			@Override
			public void onCreate(SQLiteDatabase db) {
				db.execSQL(
						"create table contacts " +
								"(id integer primary key, name text,phone text,email text, street text,place text)"
				);
			}

			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
				db.execSQL("DROP TABLE IF EXISTS contacts");
				onCreate(db);
			}

			@SuppressWarnings("SameReturnValue")
			boolean insertContact(String name, String phone) {
				SQLiteDatabase db = this.getWritableDatabase();
				ContentValues contentValues = new ContentValues();
				contentValues.put("name", name);
				contentValues.put("phone", phone);

				db.insert("contacts", null, contentValues);
				return true;
			}

			Cursor getData(int id) {
				SQLiteDatabase db = this.getReadableDatabase();
				return db.rawQuery( "select * from contacts where id="+id+"", null );
			}

			@SuppressWarnings("unused")
			public int numberOfRows(){
				SQLiteDatabase db = this.getReadableDatabase();
				return (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
			}

			@SuppressWarnings("SameReturnValue")
			boolean updateContact(Integer id, String name, String phone) {
				SQLiteDatabase db = this.getWritableDatabase();
				ContentValues contentValues = new ContentValues();
				contentValues.put("name", name);
				contentValues.put("phone", phone);

				db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
				return true;
			}

			void deleteContact(Integer id) {
				SQLiteDatabase db = this.getWritableDatabase();
				db.delete("contacts",
						"id = ? ",
						new String[]{Integer.toString(id)});
			}

			ArrayList<String> getAllCotacts() {
				ArrayList<String> array_list = new ArrayList<>();

				//hp = new HashMap();
				SQLiteDatabase db = this.getReadableDatabase();
				@SuppressLint("Recycle") Cursor res =  db.rawQuery( "select * from contacts", null );
				res.moveToFirst();

				while(!res.isAfterLast()){
					array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
					res.moveToNext();
				}
				return array_list;
			}
		}	

**Now lastly this will be your manifest file:**

		<?xml version="1.0" encoding="utf-8"?>
		<manifest xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			package="sql.developer.aero">

			<application
				android:label="@string/app_name"
				android:icon="@mipmap/ic_launcher"
				android:theme="@style/AppTheme"
				android:allowBackup="true"
				android:fullBackupContent="true"
				tools:ignore="GoogleAppIndexingWarning">

			<activity
				android:name=".MainActivity"
				android:theme="@style/AppTheme"
				android:label="@string/app_name" >

				<intent-filter>
					<action android:name="android.intent.action.MAIN" />
					<category android:name="android.intent.category.LAUNCHER" />
				</intent-filter>

			</activity>

			<activity
				android:name=".DisplayContact"
				android:theme="@style/AppTheme"/>

			</application>
		</manifest>	

Output:

![alt text]()
		