package com.example.ashiagrawal.loginscreen;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ScrollActivity extends AppCompatActivity {

    ArrayList<Meme> popularMemes = new ArrayList<Meme>();
    MemeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        ListView lvMemes = (ListView) findViewById(R.id.lvMemes);
        adapter = new MemeAdapter(this, popularMemes);
        if (lvMemes != null){
            lvMemes.setAdapter(adapter);
        }
        this.getPopularMemes();
    }

    private void getPopularMemes() {
        AsyncHttpClient client = new AsyncHttpClient();
        JsonHttpResponseHandler translate = new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    popularMemes.addAll(Meme.fromJsonList(response));
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                Log.d("onfailure", "this has failed");
            }
        };
        client.get(Meme.MEME_DATABASE_URL, null, translate);
    }
}