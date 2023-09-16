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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.consed.projectfragmentapplication.R;
import com.consed.projectfragmentapplication.adapter.CourseAdapterInternet;
import com.consed.projectfragmentapplication.databinding.FragmentGetDataBinding;
import com.consed.projectfragmentapplication.model.CourseModal;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetData1Fragment extends Fragment {

    private CourseAdapterInternet adapter;
   private FragmentGetDataBinding binding;
    private ArrayList<CourseModal> courseModalArrayList;
    //    String url = "https://jsonkeeper.com/b/WO6S";
    String JsonURL = "https://raw.githubusercontent.com/ianbar20/JSON-Volley-Tutorial/master/Example-JSON-Files/Example-Object.JSON";
    RequestQueue requestQueue;

    public GetData1Fragment() {
        // Required empty public constructor
    }


    public static GetData1Fragment newInstance() {
        GetData1Fragment fragment = new GetData1Fragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGetDataBinding.inflate(inflater,container,false);


        All();
        return binding.getRoot();
    }

    private void All() {
        courseModalArrayList = new ArrayList<>();



        GetData();
    }


    private void GetData() {

        requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.GET, JsonURL,null,
                new Response.Listener<JSONObject>() {

                    // Takes the response from the JSON request
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            binding.idRVCourses.setVisibility(View.VISIBLE);
                            binding.idPB.setVisibility(View.INVISIBLE);
                            JSONObject obj = response.getJSONObject("colorObject");

                            for (int ob = 0; ob < obj.length(); ob++) {
                                String color = obj.getString("colorName");
                                String desc = obj.getString("description");
                                courseModalArrayList.add(new CourseModal(color, desc));
                                buildRecyclerView();
                            }
                            // Retrieves the string labeled "colorName" and "description" from
                            //the response JSON Object
                            //and converts them into javascript objects
//                            String color = obj.getString("colorName");
//                            String desc = obj.getString("description");

//                            binding.fDialog.setText(color+desc);
//                            courseModalArrayList.add(new CourseModal(color, desc));
//                            buildRecyclerView();





                            // Adds strings from object to the "data" string
//                            data += "Color Name: " + color +
//                                    "nDescription : " + desc;

                            // Adds the data string to the TextView "results"
//                            results.setText(data);
                        }
                        // Try and catch are included to handle any errors due to JSON
                        catch (JSONException e) {
                            // If an error occurs, this prints the error to the log
                            e.printStackTrace();
                        }
                    }
                },
                // The final parameter overrides the method onErrorResponse() and passes VolleyError
                //as a parameter
                new Response.ErrorListener() {
                    @Override
                    // Handles errors that occur due to Volley
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "+"+error, Toast.LENGTH_SHORT).show();

                        Log.e("Volley", "Error");
                    }
                }
        );
        // Adds the JSON object request "obreq" to the request queue
        requestQueue.add(obreq);

    }

    private void buildRecyclerView() {

        adapter = new CourseAdapterInternet(courseModalArrayList, getActivity());
        binding.idRVCourses.setHasFixedSize(true);
        binding.idRVCourses.setLayoutManager( new LinearLayoutManager(getActivity()));
        binding.idRVCourses.setAdapter(adapter);



    }
}