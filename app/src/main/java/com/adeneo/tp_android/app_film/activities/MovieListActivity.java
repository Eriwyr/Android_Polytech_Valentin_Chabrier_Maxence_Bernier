package com.adeneo.tp_android.app_film.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.adapters.FilmListAdapter;
import com.adeneo.tp_android.app_film.contracts.IItemOnClickManager;
import com.adeneo.tp_android.app_film.contracts.IRecyclerView;
import com.adeneo.tp_android.app_film.list_cells.Movie;
import com.adeneo.tp_android.app_film.managers.MovieManager;

import java.util.List;

public class MovieListActivity extends AppCompatActivity implements IRecyclerView, IItemOnClickManager {

    private RecyclerView filmRecyclerView;
    private Button closeButton;
    private Button backButton;
    private Button navigationToCategoriesButton;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        this.filmRecyclerView = findViewById(R.id.film_recycler_view);
        FilmListAdapter adapter = new FilmListAdapter();

        adapter.setManager(this);
        adapter.setOnClickManager(this);

        this.filmRecyclerView.setAdapter(adapter);
        this.filmRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.closeButton = findViewById(R.id.appbar_layout_closeButton);
        closeButton.setOnClickListener(buttonListener);
        this.backButton = findViewById(R.id.appbar_layout_backButton);
        backButton.setOnClickListener(buttonListener);
        this.navigationToCategoriesButton = findViewById(R.id.navigation_to_categories_button);
        navigationToCategoriesButton.setOnClickListener(buttonListener);
    }

    @Override
    public int getCountItem() {
        return MovieManager.getInstance().getCountItem();
    }

    @Override
    public List getItems() {
        return MovieManager.getInstance().getItems();
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
                case R.id.navigation_to_categories_button:
                    Intent i = new Intent(MovieListActivity.this, CategoriesActivity.class);
                    startActivity(i);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onClickListItem(Object object) {
        Movie movie = (Movie) object;
        startActivity(MovieActivity.newActivity(this, movie.getId()));
    }
}
