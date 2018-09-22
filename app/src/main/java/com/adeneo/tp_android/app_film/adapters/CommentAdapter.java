package com.adeneo.tp_android.app_film.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.contracts.ObjectAdapterAbstract;
import com.adeneo.tp_android.app_film.list_cells.Comment;
import com.adeneo.tp_android.app_film.viewHolders.CommentViewHolder;

public class CommentAdapter extends ObjectAdapterAbstract {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View commentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_comment, parent, false);
        CommentViewHolder categorieViewHolder = new CommentViewHolder(commentView);
        return categorieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Comment currentComment = (Comment) manager.getItems().get(position);
        if (holder instanceof CommentViewHolder && currentComment != null) {
            CommentViewHolder viewHolder = (CommentViewHolder) holder;
            viewHolder.layoutForObject(currentComment);
        }
    }
}
