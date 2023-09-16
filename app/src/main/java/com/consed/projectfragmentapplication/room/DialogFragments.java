package com.consed.projectfragmentapplication.room;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.consed.projectfragmentapplication.R;
import com.consed.projectfragmentapplication.databinding.FragmentDialog2Binding;

import java.util.Objects;


public class DialogFragments extends DialogFragment {


    private static final String ARG_ID = "id";
    private static final String ARG_PARAMNAME = "param1";
    private static final String ARG_PARAMAGE = "param2";

    private String Name;
    private int Age;
    private int Id;
    private ViewModelPersonal model;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        model = new ViewModelProvider(getActivity()).get(ViewModelPersonal.class);

    }

    public DialogFragments() {
        // Required empty public constructor
    }


    public static DialogFragments newInstance(int id,String name, int age) {
        DialogFragments fragment = new DialogFragments();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, id);
        args.putString(ARG_PARAMNAME, name);
        args.putInt(ARG_PARAMAGE, age);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MyDialog);

            Name = getArguments().getString(ARG_PARAMNAME);
            Age = getArguments().getInt(ARG_PARAMAGE);
            Id = getArguments().getInt(ARG_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDialog2Binding binding = FragmentDialog2Binding.inflate(inflater,container,false);

        binding.editTextName.setText(Name);
        binding.editTextAge.setText(String.valueOf(Age));

        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.editTextAge.getText().toString().isEmpty()&& !binding.editTextAge.getText().toString().isEmpty()){
                    String name = binding.editTextName.getText().toString().trim();
                    int age = Integer.parseInt(binding.editTextAge.getText().toString());

                    Personal personal = new Personal(name, age);
                    personal.setId(Id);

                    dismiss();
                    model.UpdatePersonal(personal, new OpRoom() {
                        @Override
                        public void insert() {

                        }

                        @Override
                        public void Update(Personal personal) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    dismiss();
                                }
                            });
                        }

                        @Override
                        public void Delete(Personal personal) {

                        }
                    });


                }else {
                    Toast.makeText(getContext(), "قم بتعبة البيانات", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        WindowManager.LayoutParams params = Objects.requireNonNull(getDialog()).getWindow().getAttributes();
        params.width = 900;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes(params);
    }
}