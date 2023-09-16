package com.consed.projectfragmentapplication.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.consed.projectfragmentapplication.databinding.ItemDataCuorsBinding;

import com.consed.projectfragmentapplication.model.CourseModalInternet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    // creating a variable for array list and context.
    private final ArrayList<CourseModalInternet> courseModalArrayList;

    public CourseAdapter(ArrayList<CourseModalInternet> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemDataCuorsBinding binding =ItemDataCuorsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        // setting data to our views of recycler view.
        CourseModalInternet modal = courseModalArrayList.get(position);
        holder.binding.userId.setText(modal.getId_BLAM());
        holder.binding.id.setText(modal.getId());
        holder.binding.title.setText(modal.getTitle());
        holder.binding.body.setText(modal.getBody());
//        Picasso.get().load(modal.getImage()).into(holder.binding.image);
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return courseModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
     ItemDataCuorsBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemDataCuorsBinding.bind(itemView);

        }
    }
}
