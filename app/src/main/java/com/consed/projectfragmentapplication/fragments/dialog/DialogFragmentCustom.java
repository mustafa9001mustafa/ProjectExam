package com.consed.projectfragmentapplication.fragments.dialog;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.consed.projectfragmentapplication.R;
import com.consed.projectfragmentapplication.databinding.FragmentDialogBinding;

import java.util.Objects;


public class DialogFragmentCustom extends DialogFragment {


    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public DialogFragmentCustom() {
        // Required empty public constructor
    }

    public static DialogFragmentCustom newInstance(String param1) {
        DialogFragmentCustom fragment = new DialogFragmentCustom();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MyDialog);

            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDialogBinding binding = FragmentDialogBinding.inflate(inflater, container, false);
        binding.out.setOnClickListener(view -> {
            dismiss();
        });
        binding.notImport.setText(mParam1);
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