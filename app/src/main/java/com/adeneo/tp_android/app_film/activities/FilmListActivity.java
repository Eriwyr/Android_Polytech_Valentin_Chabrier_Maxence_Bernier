package com.adeneo.tp_android.app_film.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.adapters.FilmListAdapter;
import com.adeneo.tp_android.app_film.contracts.IRecyclerView;
import com.adeneo.tp_android.app_film.list_cells.Film;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilmListActivity extends AppCompatActivity implements IRecyclerView {

    private List<Film> films;
    private RecyclerView filmRecyclerView;
    private Button closeButton;
    private Button backButton;

    protected void onCreate(Bundle savedInstanceState) {
        films = new ArrayList<Film>();
        films.add(new Film("A Film 1", "1985, Marty Mac Fly a regagné la paisible bourgade de Hill Valley, après son voyage mouvementé à travers le temps. Il savoure la quiétude avec sa petite amie Jennifer"));
        films.add(new Film("A Film 2", "je suis le deuxième film A"));
        films.add(new Film("A Film 3", "je suis le troisième film A"));
        films.add(new Film("B Film 1", "je suis le premier film B"));
        films.add(new Film("C Film 1", "je suis le premier film C"));
        films.add(new Film("C Film 2", "je suis le deuxième film C"));
        films.add(new Film("C Film 3", "1985, Marty Mac Fly a regagné la paisible bourgade de Hill Valley, après son voyage mouvementé à travers le temps. Il savoure la quiétude avec sa petite amie Jennifer"));
        films.add(new Film("C Film 4", "je suis le quatrième film C"));
        films.add(new Film("C Film 5", "je suis le cinquième film C"));
        films.add(new Film("C Film 6", "je suis le sixième film C"));
        films.add(new Film("D Film 1", "je suis le premier film D"));
        films.add(new Film("D Film 2", "je suis le deuxième film D"));
        Collections.sort(films,
                new Comparator<Film>() {
                    public int compare(Film f1, Film f2) {
                        return f1.getTitle().toString().compareTo(f2.getTitle().toString());
                    }
                });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        this.filmRecyclerView = findViewById(R.id.film_recycler_view);
        FilmListAdapter adapter = new FilmListAdapter();
        adapter.setManager(this);

        this.filmRecyclerView.setAdapter(adapter);
        this.filmRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.closeButton = findViewById(R.id.appbar_layout_closeButton);
        closeButton.setOnClickListener(buttonListener);
        this.backButton = findViewById(R.id.appbar_layout_backButton);
        backButton.setOnClickListener(buttonListener);

    }

    @Override
    public int getCountItem() {
        if (films != null) {
            return films.size();
        }
        return 0;
    }

    @Override
    public List getItems() {
        return films;
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
}
