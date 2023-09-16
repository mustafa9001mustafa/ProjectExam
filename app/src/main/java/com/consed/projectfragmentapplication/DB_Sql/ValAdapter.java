package com.consed.projectfragmentapplication.DB_Sql;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.consed.projectfragmentapplication.databinding.ItemViewBinding;
import com.consed.projectfragmentapplication.interfaces.OnClickDelete;

import java.util.ArrayList;

public class ValAdapter extends RecyclerView.Adapter<ValAdapter.MyHolder> {

    OnClickDelete onClickDelete;
    ArrayList<Val> vals;


    public ValAdapter(OnClickDelete onClickDelete, ArrayList<Val> vals) {
        this.onClickDelete = onClickDelete;
        this.vals = vals;
    }

    public ValAdapter(OnClickDelete onClickDelete) {
        this.onClickDelete = onClickDelete;
    }

    public ValAdapter(ArrayList<Val> vals) {
        this.vals = vals;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewBinding binding = ItemViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        int pos = position;
        Val val = vals.get(pos);
        holder.binding.name.setText(val.getName());
        holder.binding.age.setText(String.valueOf(val.getAge()));
        holder.binding.delete.setOnClickListener(view -> onClickDelete.onClick(pos));
    }

    @Override
    public int getItemCount() {
        return vals.size();
    }

    public void removeItem(int position) {
        vals.remove(position);
        notifyItemRemoved(position);
    }


    static class MyHolder extends RecyclerView.ViewHolder {
        ItemViewBinding binding;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemViewBinding.bind(itemView);
        }
    }
}




