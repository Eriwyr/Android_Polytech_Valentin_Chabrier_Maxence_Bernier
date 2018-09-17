package com.adeneo.tp_android.app_film.contracts;

import com.adeneo.tp_android.app_film.list_cells.Categorie;

import java.util.List;

public interface IRecyclerView {
    int getCountItem();
    List<Categorie> getItems();


}
