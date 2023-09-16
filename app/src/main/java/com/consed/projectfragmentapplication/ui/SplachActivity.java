package com.consed.projectfragmentapplication.ui;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.consed.projectfragmentapplication.adapter.CourseAdapter;
import com.consed.projectfragmentapplication.databinding.ActivitySplachBinding;
import com.consed.projectfragmentapplication.model.CourseModalInternet;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SplachActivity extends AppCompatActivity {

    ActivitySplachBinding binding;

    private CourseAdapter adapter;
    private ArrayList<CourseModalInternet> courseModalArrayList;

//        String url = "https://jsonkeeper.com/b/WO6S";
        String url = "https://jsonplaceholder.typicode.com/posts";
   private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplachBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        // below line we are creating a new array list
        courseModalArrayList = new ArrayList<>();
        getData();

        buildRecyclerView();
    }

    private void getData() {
        queue = Volley.newRequestQueue(SplachActivity.this);


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {

            Toast.makeText(this, "data", Toast.LENGTH_SHORT).show();
            Log.e("VolleyResponse", "Response: " + response.toString());

            binding.idPB.setVisibility(View.GONE);
            binding.idRVCourses.setVisibility(View.VISIBLE);

            Log.e("VolleyResponse", "Response: " + response.toString());


            for (int i = 0; i < response.length(); i++) {
                Log.e("VolleyResponse", "Response: " + response.toString());

                try {
                    // we are getting each json object.
                    JSONObject responseObj = response.getJSONObject(i);
                    String courseName = responseObj.getString("userId");
                    String courseTracks = responseObj.getString("id");
                    String courseMode = responseObj.getString("title");
                    String courseImageURL = responseObj.getString("body");
                    courseModalArrayList.add(new CourseModalInternet(courseName, courseImageURL, courseMode, courseTracks));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("VolleyResponse", "Response: " + response.toString());

                }

            }
            buildRecyclerView();

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SplachActivity.this, ""+error, Toast.LENGTH_SHORT).show();
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());
                Log.e("VolleyError", "Error: " + error.toString());


            }
        });
        queue.add(jsonArrayRequest);
    }

     private void add(){


        // العنوان الذي سنقوم بالارسال إليه
        String url = "https://jsonplaceholder.typicode.com/posts";

        // إعداد البيانات المراد إرسالها
        JSONObject postData = new JSONObject();
        try {
            postData.put("title", "foo");
            postData.put("body", "bar");
            postData.put("userId", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // إعداد طلب Volley
        RequestQueue requestQueue = Volley.newRequestQueue(SplachActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "Response: " + response.toString());
                        // يمكنك هنا التعامل مع الاستجابة كما تشاء
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Error: " + error.toString());
                        Toast.makeText(SplachActivity.this, "Failed to make a request", Toast.LENGTH_SHORT).show();
                    }
                });

        // إضافة الطلب إلى قائمة الانتظار
        requestQueue.add(jsonObjectRequest);
    }


    private void buildRecyclerView() {

        adapter = new CourseAdapter(courseModalArrayList, SplachActivity.this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.idRVCourses.setHasFixedSize(true);

        binding.idRVCourses.setLayoutManager(manager);

        binding.idRVCourses.setAdapter(adapter);
    }
}
