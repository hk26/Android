***Many knowns about the listview in android apps. but when items in the listview are much more then it is good idea too add a Load More button in listview. So in this tutorial you will learn to add Load More button in listview.***

**Firstly put this in your build.gradle(Module:app) file :**

    apply plugin: 'com.android.application'

    android {
        compileSdkVersion 27
        defaultConfig {
            applicationId "listviewwithloadmorebutton.developer.aero"
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
        implementation 'com.android.support:appcompat-v7:27.0.2'
        implementation 'com.android.support.constraint:constraint-layout:1.0.2'
        testImplementation 'junit:junit:4.12'
        androidTestImplementation 'com.android.support.test:runner:1.0.1'
        androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'

        // https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient
        compile group: 'org.apache.httpcomponents', name: 'httpclient', version: '4.1'
    }
    
**This will be your Strings.xml file :**

    <resources>
        <string name="app_name">Listviewwithloadmorebutton</string>
        <string name="load_more">Load More</string>
    </resources>
    
**Now we create layout files for our app. So create ' main ' layout file in res -> layout -> main :**

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:orientation="vertical">
        
        <ListView
            android:id="@+id/list"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"/>

    </LinearLayout>   

**Create ' single_list_item ' layout file :**

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout
      xmlns:android="http://schemas.android.com/apk/res/android"
      android:orientation="vertical"
      android:layout_width="match_parent"
      android:layout_height="match_parent">
      <!-- Name Label -->
      <TextView android:id="@+id/name_label"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:textSize="25sp"
                android:textStyle="bold"
                android:paddingTop="10dip"
                android:paddingBottom="10dip"
                android:textColor="#dc6800"/>
      <!-- Description Label -->
      <TextView android:id="@+id/description_label"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:textColor="#acacac"/>
      <!-- Price Label -->
      <TextView android:id="@+id/cost_label"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:textStyle="bold"/>
    </LinearLayout> 

**Create ' list_item ' layout file :**

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">  
        
            <!-- List item name -->
            <TextView
                android:id="@+id/name"
                android:layout_width="fill_parent"
                android:layout_height="wrap_content"
                android:textColor="#acacac" 
                android:textStyle="bold"
                android:gravity="start"
                android:padding="10dip"
                android:textSize="16sp">
            </TextView>
    </LinearLayout>   
    
**Now after creating layout files. We will now create java files for our app. So create ' AndroidListViewWithLoadMoreButtonActivity.java '  file in your package :**

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
    
**Create ListViewAdapter.java file :**

    package listviewwithloadmorebutton.developer.aero;

    import java.util.ArrayList;
    import java.util.HashMap;

    import android.annotation.SuppressLint;
    import android.app.Activity;
    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.BaseAdapter;
    import android.widget.TextView;

    public class ListViewAdapter extends BaseAdapter {

        private final ArrayList<HashMap<String, String>> data;
        private static LayoutInflater inflater=null;
        
        ListViewAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
            data=d;
            inflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount() {
            return data.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }
        
        @SuppressLint("InflateParams")
        public View getView(int position, View convertView, ViewGroup parent) {
            View vi=convertView;
            if(convertView==null)
                vi = inflater.inflate(R.layout.list_item, null);

            TextView name = vi.findViewById(R.id.name); // title
            
            HashMap<String, String> item;
            item = data.get(position);
            
            //Setting all values in listview
            name.setText(item.get("name"));
            return vi;
        }
    }    
    
**Create SingleMenuItemActivity.java file :**

    package listviewwithloadmorebutton.developer.aero;

    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.TextView;

    public class SingleMenuItemActivity  extends Activity {
        
        // XML node keys
        private static final String KEY_NAME = "name";
        private static final String KEY_COST = "cost";
        private static final String KEY_DESC = "description";
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.single_list_item);
            
            // getting intent data
            Intent in = getIntent();
            
            // Get XML values from previous intent
            String name = in.getStringExtra(KEY_NAME);
            String cost = in.getStringExtra(KEY_COST);
            String description = in.getStringExtra(KEY_DESC);
            
            // Displaying all values on the screen
            TextView lblName = findViewById(R.id.name_label);
            TextView lblCost = findViewById(R.id.cost_label);
            TextView lblDesc = findViewById(R.id.description_label);
            
            lblName.setText(name);
            lblCost.setText(cost);
            lblDesc.setText(description);
        }
    }
    
**Create XMLParser.java file :**

    package listviewwithloadmorebutton.developer.aero;

    import java.io.IOException;
    import java.io.StringReader;
    import java.io.UnsupportedEncodingException;
    import javax.xml.parsers.DocumentBuilder;
    import javax.xml.parsers.DocumentBuilderFactory;
    import javax.xml.parsers.ParserConfigurationException;
    import org.apache.http.HttpEntity;
    import org.apache.http.HttpResponse;
    import org.apache.http.client.ClientProtocolException;
    import org.apache.http.client.methods.HttpPost;
    import org.apache.http.impl.client.DefaultHttpClient;
    import org.apache.http.util.EntityUtils;
    import org.w3c.dom.Document;
    import org.w3c.dom.Element;
    import org.w3c.dom.Node;
    import org.w3c.dom.NodeList;
    import org.xml.sax.InputSource;
    import org.xml.sax.SAXException;
    import android.util.Log;

    public class XMLParser {

        // constructor
        XMLParser() {

        }

        /**
         * Getting XML from URL making HTTP request
         * @param url string
         * */
        public String getXmlFromUrl(String url) {
            String xml = null;

            try {
                // defaultHttpClient
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);

                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                xml = EntityUtils.toString(httpEntity);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // return XML
            return xml;
        }

        public Document getDomElement(String xml){
            Document doc;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            try {

                DocumentBuilder db = dbf.newDocumentBuilder();

                InputSource is = new InputSource();
                    is.setCharacterStream(new StringReader(xml));
                    doc = db.parse(is); 

                } catch (ParserConfigurationException e) {
                    Log.e("Error: ", e.getMessage());
                    return null;
                } catch (SAXException e) {
                    Log.e("Error: ", e.getMessage());
                    return null;
                } catch (IOException e) {
                    Log.e("Error: ", e.getMessage());
                    return null;
                }

                return doc;
        }
        
        /** Getting node value
          * @param elem element
          */
         private String getElementValue(Node elem) {
             Node child;
             if( elem != null){
                 if (elem.hasChildNodes()){
                     for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
                         if( child.getNodeType() == Node.TEXT_NODE  ){
                             return child.getNodeValue();
                         }
                     }
                 }
             }
             return "";
         }

         public String getValue(Element item, String str) {		
                NodeList n = item.getElementsByTagName(str);		
                return this.getElementValue(n.item(0));
            }
    }
    
**And lasltly this will be Manifest file :**

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="listviewwithloadmorebutton.developer.aero">

        <uses-permission android:name="android.permission.INTERNET" />

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme">
            <activity
                android:name=".AndroidListViewWithLoadMoreButtonActivity"
                android:label="@string/app_name" >
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>

            <!-- Single List Item View -->
            <activity
                android:label="Single Menu Item"
                android:name=".SingleMenuItemActivity" >
            </activity>
        </application>

    </manifest>    
    
**Ouptut :**

![alt text](https://github.com/akshaysunilmasram/Android/blob/master/Listviewwithloadmorebutton/art/listviewwithloadmorebutton.png)
