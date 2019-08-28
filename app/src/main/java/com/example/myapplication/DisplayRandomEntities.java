package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayRandomEntities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_random_entities);
        getData();
    }


    private void getData(){
        final TextView textView = findViewById(R.id.textview_entities);
        // Request a string response from the provided URL.
        String url = "https://jsonplaceholder.typicode.com/posts";

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        displayPosts(response, textView);
                                            }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequest);
    }

    public void displayPosts(JSONArray posts, TextView textView){
        try{
            for(int i=0;i<posts.length();i++){
                JSONObject post = posts.getJSONObject(i);
                textView.append(post.getString("body"));
                textView.append("\n\n");

            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
