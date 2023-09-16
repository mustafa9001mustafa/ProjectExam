package com.consed.projectfragmentapplication.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.consed.projectfragmentapplication.fragments.CategoryFragment;
import com.consed.projectfragmentapplication.fragments.FavoriteFragment;
import com.consed.projectfragmentapplication.fragments.HomeFragment;
import com.consed.projectfragmentapplication.fragments.PersonalFragment;
public class ViewPagerBottomNavAdapter extends FragmentStateAdapter {
    public ViewPagerBottomNavAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return switch (position) {
            case 0 -> new HomeFragment();
            case 1 -> new FavoriteFragment();
            case 2 -> new CategoryFragment();
            case 3 -> new PersonalFragment();
            default -> new HomeFragment();
        };
    }

    @Override
    public int  getItemCount() {
        return 4;
    }
}
