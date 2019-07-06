package ir.mohamadalirahimi.bookreader;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import ir.mohamadalirahimi.bookreader.Adapters.BookAdapters;
import ir.mohamadalirahimi.bookreader.Classes.book;

public class SearchbooksActivity extends AppCompatActivity {
    View btnback;
    Activity context = this;

    EditText search;
    ArrayList<book> books = new ArrayList<book>();
    RecyclerView recyclerView;
    BookAdapters adapters;
    ImageView searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchbooks);


        searchBtn = findViewById(R.id.searchBtn);

        recyclerView = findViewById(R.id.recycler);
        adapters = new BookAdapters(context, books);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapters);

        searchBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchAction();
                    }
                }
        );
        search = findViewById(R.id.search);

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    searchAction();
                    return true;
                }

                return false;

            }
        });
        btnback = findViewById(R.id.back);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    public void searchAction() {
        books.clear();
        String value = search.getText().toString();

        try {
            new JsonTask().execute("http://192.168.43.120/server/public/api/books/search?q=" +  URLEncoder.encode(value,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();


        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                Log.e("ss" , params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONArray jsa = new JSONArray(result);
                for (int i = 0; i < jsa.length(); i++) {
                    books.add(new book(jsa.getJSONObject(i)));
                    adapters.notifyDataSetChanged();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.e("Tag", result);
        }
    }

}
