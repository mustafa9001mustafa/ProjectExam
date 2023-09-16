package com.consed.projectfragmentapplication.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.consed.projectfragmentapplication.fragments.tabs.DbRoomFragment;
import com.consed.projectfragmentapplication.fragments.tabs.DbSqlFragment;


public class ViewPagerCategoryAdapter extends FragmentStateAdapter {
    public ViewPagerCategoryAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return switch (position) {
            case 1 -> new DbRoomFragment();
            default -> new DbSqlFragment();
        };
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
