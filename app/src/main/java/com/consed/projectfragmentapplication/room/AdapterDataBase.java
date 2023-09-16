package com.consed.projectfragmentapplication.room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.consed.projectfragmentapplication.databinding.ItemDataExBinding;
import com.consed.projectfragmentapplication.databinding.ItemViewBinding;

import java.util.ArrayList;
import java.util.List;

public class AdapterDataBase extends RecyclerView.Adapter<AdapterDataBase.ViewHolderData> {

    private List<Personal> list;
    OpDU du;

    public AdapterDataBase(List<Personal> list, OpDU du) {
        this.list = list;
        this.du = du;
    }

    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewBinding binding = ItemViewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolderData(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderData holder, int position) {

        int x = position;
        Personal personal = list.get(x);
        holder.binding.name.setText(personal.getName());
        holder.binding.age.setText(String.valueOf(personal.getAge()));

        holder.binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                du.onDeleteListener(x, personal);
            }
        });
        holder.binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                du.onUpdateListener(x, personal);

            }
        });

    }


    public void setList(List<Personal> list) {
        this.list = list;
        for (int lis = 0; lis <list.size() ; lis++) {

        }
        notifyItemChanged(list.size());
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolderData extends RecyclerView.ViewHolder {
        ItemViewBinding binding;

        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            binding = ItemViewBinding.bind(itemView);
        }
    }


}
