package com.consed.projectfragmentapplication.fragments.tabs2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.consed.projectfragmentapplication.adapter.CourseAdapterInternet;
import com.consed.projectfragmentapplication.adapter.ExampleAdapter;
import com.consed.projectfragmentapplication.databinding.FragmentGetData2Binding;
import com.consed.projectfragmentapplication.databinding.FragmentGetData3Binding;
import com.consed.projectfragmentapplication.databinding.FragmentGetDataBinding;
import com.consed.projectfragmentapplication.model.CourseModal;
import com.consed.projectfragmentapplication.model.CourseModalInternet;
import com.consed.projectfragmentapplication.model.Example;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetData3Fragment extends Fragment {

    private ExampleAdapter adapter;
    private FragmentGetData3Binding binding;
    private ArrayList<Example> courseModalArrayList;
        String url = "https://jsonplaceholder.typicode.com/albums/1/photos";
    RequestQueue requestQueue;

    public GetData3Fragment() {
        // Required empty public constructor
    }


    public static GetData3Fragment newInstance() {
        GetData3Fragment fragment = new GetData3Fragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGetData3Binding.inflate(inflater,container,false);
        All();
        return binding.getRoot();
    }



    private void All() {
        courseModalArrayList = new ArrayList<>();



        GetData();
    }


    private void GetData() {

        requestQueue = Volley.newRequestQueue(getContext());

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
                            int albumId = responseObj.getInt("albumId");
                            int id = responseObj.getInt("id");
                            String title = responseObj.getString("title");
                            String url = responseObj.getString("url");
                            String thumbnailUrl = responseObj.getString("thumbnailUrl");
                            courseModalArrayList.add(new Example(albumId, id, title, url,thumbnailUrl));
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
        requestQueue.add(obreq);

    }

    private void buildRecyclerView() {

        adapter = new ExampleAdapter(courseModalArrayList, getActivity());
        binding.idRVCourses.setHasFixedSize(true);
        binding.idRVCourses.setLayoutManager( new LinearLayoutManager(getActivity()));
        binding.idRVCourses.setAdapter(adapter);



    }
}