package com.consed.projectfragmentapplication.fragments.tabs2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.consed.projectfragmentapplication.adapter.CourseAdapter;
import com.consed.projectfragmentapplication.adapter.CourseAdapterInternet;
import com.consed.projectfragmentapplication.databinding.FragmentGetData2Binding;
import com.consed.projectfragmentapplication.databinding.FragmentGetDataBinding;
import com.consed.projectfragmentapplication.model.CourseModal;
import com.consed.projectfragmentapplication.model.CourseModalInternet;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetData2Fragment extends Fragment {

    private FragmentGetData2Binding binding;
    private CourseAdapter adapter;
    private ArrayList<CourseModalInternet> courseModalArrayList;

    String url = "https://jsonplaceholder.typicode.com/posts";
    private RequestQueue queue;

    public GetData2Fragment() {
        // Required empty public constructor
    }


    public static GetData2Fragment newInstance() {
        GetData2Fragment fragment = new GetData2Fragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         binding = FragmentGetData2Binding.inflate(inflater,container,false);
        All();
        return binding.getRoot();
    }


    private void All() {
        courseModalArrayList = new ArrayList<>();
        GetData();
    }


    private void GetData() {

        queue = Volley.newRequestQueue(getContext());

        JsonArrayRequest obreq = new JsonArrayRequest(Request.Method.GET, url,null,
                response -> {
                    binding.idRVCourses.setVisibility(View.VISIBLE);
                    binding.idPB.setVisibility(View.INVISIBLE);

//                        JSONObject obj = response.getJSONObject("colorObject");

                    for (int i = 0; i < response.length(); i++) {
                        Log.e("VolleyResponse", "Response: " + response.toString());

                        try {
                            // we are getting each json object.
                            JSONObject responseObj = response.getJSONObject(i);
                            String id = responseObj.getString("id");
                            String userId = responseObj.getString("userId");
                            String title = responseObj.getString("title");
                            String body = responseObj.getString("body");
                            courseModalArrayList.add(new CourseModalInternet(userId, id, title, body));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("VolleyResponse", "Response: " + response.toString());

                        }

                    }
                    buildRecyclerView();
                },

                error -> {
                    Toast.makeText(getContext(), "+"+error, Toast.LENGTH_SHORT).show();
                    Log.e("Volley", "Error");
                }
        );
        // Adds the JSON object request "obreq" to the request queue
        queue.add(obreq);

    }

    private void buildRecyclerView() {

        adapter = new CourseAdapter(courseModalArrayList, getActivity());
        binding.idRVCourses.setHasFixedSize(true);
        binding.idRVCourses.setLayoutManager( new LinearLayoutManager(getActivity()));
        binding.idRVCourses.setAdapter(adapter);



    }
}