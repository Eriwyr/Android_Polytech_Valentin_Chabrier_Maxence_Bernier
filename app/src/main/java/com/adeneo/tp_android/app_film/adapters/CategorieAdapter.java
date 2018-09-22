package com.adeneo.tp_android.app_film.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.contracts.ObjectAdapterAbstract;
import com.adeneo.tp_android.app_film.list_cells.Categorie;
import com.adeneo.tp_android.app_film.viewHolders.CategorieViewHolder;

public class CategorieAdapter extends ObjectAdapterAbstract {


    public CategorieAdapter() {
        super();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View categorieView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_categorie, parent, false);


        CategorieViewHolder categorieViewHolder = new CategorieViewHolder(categorieView);

        return categorieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Categorie currentCategorie = (Categorie) manager.getItems().get(position);
        if (holder instanceof CategorieViewHolder && currentCategorie != null) {
            CategorieViewHolder viewHolder = (CategorieViewHolder) holder;
            viewHolder.layoutForObject(currentCategorie);
        }
    }


    /*@Override
    public int getItemCount() {
        return manager.getCountItem();
    }

    public void setManager(CategoriesActivity manager) {
        this.manager = manager;
    }*/
}
