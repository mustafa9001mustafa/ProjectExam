package com.consed.projectfragmentapplication.fragments;


import android.app.Dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.consed.projectfragmentapplication.databinding.FragmentPersonalBinding;
import com.consed.projectfragmentapplication.fragments.dialog.DialogFragmentCustom;


public class PersonalFragment extends Fragment {
    FragmentPersonalBinding binding;
    Dialog dialog;


    public PersonalFragment() {

    }

    public static PersonalFragment newInstance() {
        PersonalFragment fragment = new PersonalFragment();
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
        binding = FragmentPersonalBinding.inflate(inflater, container, false);

        binding.fDialog.setOnClickListener(view -> {


            DialogFragmentCustom dialogFragmentAll = DialogFragmentCustom.newInstance( "ديالوج واجهة الملف الشخصي");
            dialogFragmentAll.show(getChildFragmentManager(), "nul");
        });
        return binding.getRoot();
    }

}