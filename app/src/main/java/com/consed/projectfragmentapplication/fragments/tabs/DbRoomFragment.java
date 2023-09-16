package com.consed.projectfragmentapplication.fragments.tabs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.consed.projectfragmentapplication.R;
import com.consed.projectfragmentapplication.databinding.FragmentRoomBinding;
import com.consed.projectfragmentapplication.databinding.FragmentSqlBinding;
import com.consed.projectfragmentapplication.fragments.dialog.DialogFragmentCustom;
import com.consed.projectfragmentapplication.room.AdapterDataBase;
import com.consed.projectfragmentapplication.room.DialogFragments;
import com.consed.projectfragmentapplication.room.OpDU;
import com.consed.projectfragmentapplication.room.OpRoom;
import com.consed.projectfragmentapplication.room.Personal;
import com.consed.projectfragmentapplication.room.ViewModelPersonal;
import com.consed.projectfragmentapplication.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class DbRoomFragment extends Fragment {
   private FragmentRoomBinding binding;
   private ViewModelPersonal model;
    private AdapterDataBase adapter;
    private OpRoom listener2;




    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        model = new ViewModelProvider(getActivity()).get(ViewModelPersonal.class);
    }

    public DbRoomFragment() {
        // Required empty public constructor
    }

    public static DbRoomFragment newInstance() {
        DbRoomFragment fragment = new DbRoomFragment();
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


        binding = FragmentRoomBinding.inflate(inflater,container,false);

        All();
        return binding.getRoot();

    }

    private void All() {
        Adapter();
        addData();
        GetData();
    }


    private void Adapter() {
        adapter = new AdapterDataBase(new ArrayList<>(), new OpDU() {
            @Override
            public void onUpdateListener(int rowsAffected, Personal personal) {

                DialogFragments dialogFragmentAll = DialogFragments.newInstance( personal.getId(),personal.getName(),personal.getAge());
                dialogFragmentAll.show(getChildFragmentManager(), "nul");
            }

            @Override
            public void onDeleteListener(int rowsAffected, Personal personal) {
                model.DeletePersonal(personal, listener2);
            }
        });


    }

    private void GetData() {


        model.getData().observe(getViewLifecycleOwner(), new Observer<List<Personal>>() {
            @Override
            public void onChanged(List<Personal> personals) {

                adapter.setList(personals);
                binding.rv.setAdapter(adapter);
                binding.rv.setHasFixedSize(true);
                binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        });
    }

    private void addData() {


        binding.button.setOnClickListener(v -> {

            String name = binding.editTextName.getText().toString().trim();
            int age = Integer.parseInt(binding.editTextAge.getText().toString());

            Personal personal = new Personal(name, age);
            model.InsertPersonal(personal, new OpRoom() {
                @Override
                public void insert() {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });

                }

                @Override
                public void Update(Personal personal) {

                }

                @Override
                public void Delete(Personal personal) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            model.DeletePersonal(personal, listener2);
                        }
                    });
                }
            });

        });
    }
}