package com.adeneo.tp_android.app_film.contracts;

import java.util.List;

public interface IRecyclerView<T> {
    int getCountItem();

    List<T> getItems();


}
