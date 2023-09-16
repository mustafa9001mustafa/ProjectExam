package com.consed.projectfragmentapplication.servies.e2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.consed.projectfragmentapplication.databinding.ActivityMainServiceBinding;


public class MainActivityService extends AppCompatActivity {
    ActivityMainServiceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}