package com.consed.projectfragmentapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.consed.projectfragmentapplication.R;
import com.consed.projectfragmentapplication.databinding.ActivityRoomBinding;
import com.consed.projectfragmentapplication.room.AdapterDataBase;
import com.consed.projectfragmentapplication.room.OpRoom;
import com.consed.projectfragmentapplication.room.Personal;
import com.consed.projectfragmentapplication.room.ViewModelPersonal;

import java.util.List;

public class RoomActivity extends AppCompatActivity {
ActivityRoomBinding  binding;
    private ViewModelPersonal model;
    private AdapterDataBase adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        model = new ViewModelProvider(RoomActivity.this).get(ViewModelPersonal.class);
        addData();



    }

    private void GetData() {


        model.getData().observe(RoomActivity.this, new Observer<List<Personal>>() {
            @Override
            public void onChanged(List<Personal> personals) {

                adapter.setList(personals);
                binding.rv.setAdapter(adapter);
                binding.rv.setHasFixedSize(true);
                binding.rv.setLayoutManager(new LinearLayoutManager(RoomActivity.this));
            }
        });
    }



    private void addData() {


        binding.add.setOnClickListener(v -> {

            String name = binding.editTextName.getText().toString().trim();
            int age = Integer.parseInt(binding.editTextAge.getText().toString());


            Personal entity = new Personal(name, age);
            model.InsertPersonal(entity, new OpRoom() {
                @Override
                public void insert() {
//                    Toast.makeText(RoomActivity.this, "save", Toast.LENGTH_SHORT).show();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            GetData();
                        }
                    });
                }

                @Override
                public void Update(Personal personal) {

                }

                @Override
                public void Delete(Personal personal) {

                }
            });

        });
    }

}