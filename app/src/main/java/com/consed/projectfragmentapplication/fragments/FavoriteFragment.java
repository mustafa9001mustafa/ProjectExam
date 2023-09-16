package com.consed.projectfragmentapplication.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.consed.projectfragmentapplication.R;
import com.consed.projectfragmentapplication.databinding.FragmentFavoriteBinding;
import com.consed.projectfragmentapplication.fragments.dialog.DialogFragmentCustom;

import java.util.Locale;


public class FavoriteFragment extends Fragment {
    private FragmentFavoriteBinding binding;
    private CountDownTimer countDownTimer;
    private boolean Finish = true;
    private int Timer,lastTimer;
    public FavoriteFragment() {
        // Required empty public constructor
    }

    public static FavoriteFragment newInstance() {
        FavoriteFragment fragment = new FavoriteFragment();
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
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        lastTimer = 15000;
        binding.fStart.setOnClickListener(view -> {
            if (Finish) {
                ProgressTimer(lastTimer);
            }else{
                countDownTimer.cancel();
                countDownTimer.onFinish();
                int handelLastTimer = lastTimer /1000;
                if (handelLastTimer >10)
                binding.textTimer.setText("الوقت المتبقي هو "+String.valueOf(handelLastTimer) + " ثانية ");
                else if (handelLastTimer ==1)
                    binding.textTimer.setText("الوقت المتبقي هو "+String.valueOf(handelLastTimer) + " ثانية ");

                else
                    binding.textTimer.setText("الوقت المتبقي هو "+String.valueOf(handelLastTimer) + " ثواني ");

                binding.progressBar.setProgress(handelLastTimer);
            }

        });

        binding.fRestart.setOnClickListener(view -> {
            countDownTimer.onFinish();
            countDownTimer.cancel();
            ProgressTimer(15000);

        });

        ProgressClick();
        return binding.getRoot();
    }



    @SuppressLint("ClickableViewAccessibility")
    private void ProgressClick(){
        binding.progressBar.setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                int totalWidth = view.getWidth();
                float clickX = event.getX();
                int maxProgress = binding.progressBar.getMax();

                // حساب القيمة المحددة بناءً على الموقع
                int progress = maxProgress - (int) ((clickX / totalWidth) * maxProgress);

                // تحديث قيمة ProgressBar
                binding.progressBar.setProgress(progress);
            }
            return true;
        });

    }
    private void ProgressTimer(int Timer) {
        countDownTimer = new CountDownTimer(Timer, 999) {
            @Override
            public void onTick(long l) {
                long hour = (l / 3600000);
                long min = (l / 60000);
                long sec = (l / 1000) % 60;
                final String x = String.format(Locale.getDefault(), "%02d:%02d:%02d", hour, min, sec);
                binding.textTimer.setText(x);
                int xd = (int) sec;
                binding.progressBar.setProgress(xd);

                lastTimer = xd * 1000;
                Finish = false;
                binding.fStart.setText("Resume");

            }

            @Override
            public void onFinish() {
                // TODO: 1/1/2023
                try {
                    binding.textTimer.setText("00:00:00");
                    Finish = true;
                    binding.fStart.setText("Start");

                } catch (Exception e) {
                    Log.e("TAG", "onFinish: " + e);
                }


            }
        }.start();
    }
}