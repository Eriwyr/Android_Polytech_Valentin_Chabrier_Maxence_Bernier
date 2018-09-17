package com.adeneo.tp_android.app_film.contracts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.adeneo.tp_android.app_film.activities.CategoriesActivity;

public abstract class ObjectAdapterAbstract extends RecyclerView.Adapter {

    protected IRecyclerView manager;

    @NonNull
    @Override
    public abstract RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position);


    public int getItemCount() {
        return manager.getCountItem();
    }

    public void setManager(IRecyclerView manager) {
        this.manager = manager;
    }
}
