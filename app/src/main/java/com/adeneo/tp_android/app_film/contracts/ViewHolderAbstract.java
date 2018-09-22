package com.adeneo.tp_android.app_film.contracts;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class ViewHolderAbstract extends RecyclerView.ViewHolder {

    public ViewHolderAbstract(View itemView) {
        super(itemView);

    }

    public abstract void layoutForObject(Object object);

}
