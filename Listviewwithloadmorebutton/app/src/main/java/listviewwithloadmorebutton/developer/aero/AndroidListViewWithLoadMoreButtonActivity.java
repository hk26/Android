package listviewwithloadmorebutton.developer.aero;

import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class AndroidListViewWithLoadMoreButtonActivity extends Activity {
	
	// All variables
	private XMLParser parser;
	private Document doc;
	private String xml;
	private ListView lv;
	private ListViewAdapter adapter;
	private ArrayList<HashMap<String, String>> menuItems;
	private ProgressDialog pDialog;
	
	private String URL = "http://api.androidhive.info/list_paging/?page=1";

	// XML node keys
	private static final String KEY_ITEM = "item"; // parent node
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";

	// Flag for current page
	private int current_page = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		if (android.os.Build.VERSION.SDK_INT > 17) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

		lv = findViewById(R.id.list);

		menuItems = new ArrayList<>();

		parser = new XMLParser();
		xml = parser.getXmlFromUrl(URL); // getting XML
		doc = parser.getDomElement(xml); // getting DOM element

		NodeList nl = doc.getElementsByTagName(KEY_ITEM);
		// looping through all item nodes <item>
		for (int i = 0; i < nl.getLength(); i++) {
			// creating new HashMap
			HashMap<String, String> map = new HashMap<>();
			Element e = (Element) nl.item(i);
			// adding each child node to HashMap key => value
			map.put(KEY_ID, parser.getValue(e, KEY_ID)); // id not using any where
			map.put(KEY_NAME, parser.getValue(e, KEY_NAME));

			// adding HashList to ArrayList
			menuItems.add(map);
		}

		// LoadMore button
		Button btnLoadMore = new Button(this);
		btnLoadMore.setText(R.string.load_more);

		// Adding Load More button to lisview at bottom
		lv.addFooterView(btnLoadMore);
		
		// Getting adapter
		adapter = new ListViewAdapter(this, menuItems);
		lv.setAdapter(adapter);

		btnLoadMore.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Starting a new async task
				new loadMoreListView().execute();
			}
		});

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				String name = ((TextView) view.findViewById(R.id.name))
						.getText().toString();

				// Starting new intent
				Intent in = new Intent(getApplicationContext(),
						SingleMenuItemActivity.class);
				in.putExtra(KEY_NAME, name);
				startActivity(in);
			}
		});
	}

	@SuppressLint("StaticFieldLeak")
	private class loadMoreListView extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			// Showing progress dialog before sending http request
			pDialog = new ProgressDialog(
					AndroidListViewWithLoadMoreButtonActivity.this);
			pDialog.setMessage("Please wait..");
			pDialog.setIndeterminate(true);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		protected Void doInBackground(Void... unused) {
			runOnUiThread(new Runnable() {
				public void run() {
					// increment current page
					current_page += 1;
					
					// Next page request
					URL = "http://api.androidhive.info/list_paging/?page=" + current_page;

					xml = parser.getXmlFromUrl(URL); // getting XML
					doc = parser.getDomElement(xml); // getting DOM element

					NodeList nl = doc.getElementsByTagName(KEY_ITEM);
					// looping through all item nodes <item>
					for (int i = 0; i < nl.getLength(); i++) {
						// creating new HashMap
						HashMap<String, String> map = new HashMap<>();
						Element e = (Element) nl.item(i);
						
						// adding each child node to HashMap key => value
						map.put(KEY_ID, parser.getValue(e, KEY_ID));
						map.put(KEY_NAME, parser.getValue(e, KEY_NAME));

						// adding HashList to ArrayList
						menuItems.add(map);
					}
					
					// get listview current position - used to maintain scroll position
					int currentPosition = lv.getFirstVisiblePosition();
					
					// Appending new data to menuItems ArrayList
					adapter = new ListViewAdapter(
							AndroidListViewWithLoadMoreButtonActivity.this,
							menuItems);
					lv.setAdapter(adapter);
					
					// Setting new scroll position
					lv.setSelectionFromTop(currentPosition + 1, 0);

				}
			});

			return (null);
		}
		
		
		protected void onPostExecute(Void unused) {
			// closing progress dialog
			pDialog.dismiss();
		}
	}
}