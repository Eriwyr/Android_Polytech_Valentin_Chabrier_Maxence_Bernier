package com.adeneo.tp_android.app_film.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.adapters.CategorieAdapter;
import com.adeneo.tp_android.app_film.contracts.IItemOnClickManager;
import com.adeneo.tp_android.app_film.contracts.IRecyclerView;
import com.adeneo.tp_android.app_film.list_cells.Categorie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class CategoriesActivity extends AppCompatActivity implements IRecyclerView, IItemOnClickManager {
    private RecyclerView categoriesRecyclerView;
    private List<Categorie> categories;

    private Button closeButton;
    private Button backButton;


    protected void onCreate(Bundle savedInstanceState) {

        categories = new ArrayList<Categorie>();
        categories.add(new Categorie("Humour", 1));
        categories.add(new Categorie("Comédie", 2));
        categories.add(new Categorie("Action", 3));
        categories.add(new Categorie("Drame", 4));
        Collections.sort(categories,
                new Comparator<Categorie>() {
                    public int compare(Categorie c1, Categorie c2) {
                        return c1.getName().toString().compareTo(c2.getName().toString());
                    }
                });
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_categories);

        this.categoriesRecyclerView = findViewById(R.id.categorie_recycler_view);
        CategorieAdapter adapter = new CategorieAdapter();
        adapter.setManager(this);
        adapter.setOnClickManager(this);

        this.categoriesRecyclerView.setAdapter(adapter);
        this.categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.categoriesRecyclerView.setNestedScrollingEnabled(false);

        this.closeButton = findViewById(R.id.appbar_layout_closeButton);
        closeButton.setOnClickListener(buttonListener);
        this.backButton = findViewById(R.id.appbar_layout_backButton);
        backButton.setOnClickListener(buttonListener);

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

    private View.OnClickListener buttonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.appbar_layout_closeButton:
                    finish();
                    break;
                case R.id.appbar_layout_backButton:
                    finish();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onClickListItem(Object obj) {
        finish();
    }
}
