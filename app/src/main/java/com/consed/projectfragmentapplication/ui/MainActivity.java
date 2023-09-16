package com.consed.projectfragmentapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.consed.projectfragmentapplication.R;
import com.consed.projectfragmentapplication.adapter.ViewPagerBottomNavAdapter;
import com.consed.projectfragmentapplication.adapter.ViewPagerCategoryAdapter;
import com.consed.projectfragmentapplication.databinding.ActivityMainBinding;
import com.consed.projectfragmentapplication.fragments.CategoryFragment;
import com.consed.projectfragmentapplication.fragments.FavoriteFragment;
import com.consed.projectfragmentapplication.fragments.HomeFragment;
import com.consed.projectfragmentapplication.fragments.PersonalFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.bottomNav.setSelectedItemId(R.id.nav_home);

        binding.bottomNav.setOnItemSelectedListener(item -> {


            if (item.getItemId() == R.id.nav_home) {
                binding.viewPager2.setCurrentItem(0);

            } else if (item.getItemId() == R.id.nav_favorite) {
                binding.viewPager2.setCurrentItem(1);


            } else if (item.getItemId() == R.id.nav_Category) {
                binding.viewPager2.setCurrentItem(2);


            } else if (item.getItemId() == R.id.nav_personal) {
                binding.viewPager2.setCurrentItem(3);

            }

            return true;
        });


        ViewPagerBottomNavAdapter adapter = new ViewPagerBottomNavAdapter(this);
        binding.viewPager2.setAdapter(adapter);

        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);


                switch (position) {
                    case 0:
                        binding.bottomNav.setSelectedItemId(R.id.nav_home);
                        break;
                    case 1:
                        binding.bottomNav.setSelectedItemId(R.id.nav_favorite);
                        break;
                    case 2:
                        binding.bottomNav.setSelectedItemId(R.id.nav_Category);
                        break;
                    case 3:
                        binding.bottomNav.setSelectedItemId(R.id.nav_personal);
                        break;
                }
            }
        });
    }
}