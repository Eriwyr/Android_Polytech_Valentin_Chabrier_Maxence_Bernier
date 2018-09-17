package com.adeneo.tp_android.app_film.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.adapters.CategorieAdapter;
import com.adeneo.tp_android.app_film.contracts.IRecyclerView;
import com.adeneo.tp_android.app_film.list_cells.Categorie;

import java.util.ArrayList;
import java.util.List;


public class CategoriesActivity extends AppCompatActivity implements IRecyclerView {
    private RecyclerView categoriesRecyclerView;
    private List<Categorie> categories;


    protected void onCreate(Bundle savedInstanceState){

        categories = new ArrayList<Categorie>();
        categories.add(new Categorie("Humour",1));
        categories.add(new Categorie("Comédie",2));
        categories.add(new Categorie("Action",3));
        categories.add(new Categorie("Drame",4));


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_categories);

        this.categoriesRecyclerView = findViewById(R.id.categorie_recycler_view);
        CategorieAdapter adapter = new CategorieAdapter();
        adapter.setManager(this);

        this.categoriesRecyclerView.setAdapter(adapter);
        this.categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public int getCountItem() {
        if (categories != null) return categories.size();
        return 0;
    }

    @Override
    public List<Categorie> getItems() {
        return categories;
    }
}
