package com.consed.projectfragmentapplication.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.consed.projectfragmentapplication.fragments.tabs2.GetData1Fragment;
import com.consed.projectfragmentapplication.fragments.tabs2.GetData2Fragment;
import com.consed.projectfragmentapplication.fragments.tabs2.GetData3Fragment;

public class ViewPagerHomeAdapter extends FragmentStateAdapter {
    public ViewPagerHomeAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return switch (position) {
            case 1 -> new GetData2Fragment();
            case 2 -> new GetData3Fragment();
            default -> new GetData1Fragment();
        };
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
