package com.consed.projectfragmentapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.consed.projectfragmentapplication.databinding.ItemDataCuorsBinding;
import com.consed.projectfragmentapplication.databinding.ItemDataExBinding;
import com.consed.projectfragmentapplication.model.CourseModalInternet;
import com.consed.projectfragmentapplication.model.Example;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ViewHolder> {

    // creating a variable for array list and context.
    private final ArrayList<Example> courseModalArrayList;

    public ExampleAdapter(ArrayList<Example> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
    }

    @NonNull
    @Override
    public ExampleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemDataExBinding binding =ItemDataExBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleAdapter.ViewHolder holder, int position) {
        // setting data to our views of recycler view.
        Example modal = courseModalArrayList.get(position);
        holder.binding.idBlam.setText(String.valueOf(modal.getAlbumId()));
        holder.binding.id.setText(String.valueOf(modal.getId()));
        holder.binding.title.setText(modal.getTitle());
        Picasso.get().load(modal.getUrl()).into(holder.binding.image1);
        Picasso.get().load(modal.getThumbnailUrl()).into(holder.binding.image2);
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return courseModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
     ItemDataExBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemDataExBinding.bind(itemView);

        }
    }
}
