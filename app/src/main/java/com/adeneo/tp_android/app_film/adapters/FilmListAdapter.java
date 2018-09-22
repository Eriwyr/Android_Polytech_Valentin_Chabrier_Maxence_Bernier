package com.adeneo.tp_android.app_film.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.contracts.ObjectAdapterAbstract;
import com.adeneo.tp_android.app_film.list_cells.Film;
import com.adeneo.tp_android.app_film.viewHolders.FilmViewHolder;
import com.adeneo.tp_android.app_film.viewHolders.MovieAndFooterViewHolder;
import com.adeneo.tp_android.app_film.viewHolders.MovieAndHeaderAndFooterViewHolder;
import com.adeneo.tp_android.app_film.viewHolders.MovieAndHeaderViewHolder;

public class FilmListAdapter extends ObjectAdapterAbstract {

    private static char lastLetter;
    int FILM_ONLY = 0;
    int FILM_AND_LETTER = 1;
    int FILM_AND_LETTER_AND_COUNTER = 2;
    int FILM_AND_COUNTER = 3;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View filmView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_movie, parent, false);
                FilmViewHolder filmViewHolder = new FilmViewHolder(filmView);
                return filmViewHolder;
            case 1:
                View letterView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_movier_and_header, parent, false);
                MovieAndHeaderViewHolder movieAndHeaderViewHolder = new MovieAndHeaderViewHolder(letterView);
                return movieAndHeaderViewHolder;
            case 2:
                View letterCounterView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_movie_and_header_and_footer, parent, false);
                MovieAndHeaderAndFooterViewHolder letterCounterViewHolder = new MovieAndHeaderAndFooterViewHolder(letterCounterView);
                return letterCounterViewHolder;

            case 3:
                View counterView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_movie_and_footer, parent, false);
                MovieAndFooterViewHolder movieAndFooterViewHolder = new MovieAndFooterViewHolder(counterView);
                return movieAndFooterViewHolder;
            default:
                return null;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                Film currentFilm = (Film) manager.getItems().get(position);

                if (holder instanceof FilmViewHolder && currentFilm != null) {
                    FilmViewHolder viewHolder = (FilmViewHolder) holder;
                    viewHolder.layoutForObject(currentFilm);
                }
                break;
            case 1:
                Film currentFilmWithLetter = (Film) manager.getItems().get(position);

                if (holder instanceof MovieAndHeaderViewHolder && currentFilmWithLetter != null) {
                    MovieAndHeaderViewHolder movieAndHeaderViewHolder = (MovieAndHeaderViewHolder) holder;
                    movieAndHeaderViewHolder.layoutForObject(currentFilmWithLetter);
                }

                break;
            case 2:
                Film currentFilmWithLetterAndCounter = (Film) manager.getItems().get(position);

                if (holder instanceof MovieAndHeaderAndFooterViewHolder && currentFilmWithLetterAndCounter != null) {
                    MovieAndHeaderAndFooterViewHolder movieAndHeaderAndFooterViewHolder = (MovieAndHeaderAndFooterViewHolder) holder;
                    movieAndHeaderAndFooterViewHolder.layoutForObject(currentFilmWithLetterAndCounter);
                }

                break;
            case 3:
                Film currentFilmWithCounter = (Film) manager.getItems().get(position);

                if (holder instanceof MovieAndFooterViewHolder && currentFilmWithCounter != null) {
                    MovieAndFooterViewHolder movieAndFooterViewHolder = (MovieAndFooterViewHolder) holder;
                    movieAndFooterViewHolder.layoutForObject(currentFilmWithCounter);
                }

            default:
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        Film currentFilm = (Film) manager.getItems().get(position);

        Film previous = null;
        try {
            previous = (Film) manager.getItems().get(position - 1);
        } catch (Exception e) {


        }

        Film nextFilm = null;
        try {
            nextFilm = (Film) manager.getItems().get(position + 1);
        } catch (Exception e) {

        }

        if (previous != null) {
            if (nextFilm != null) {
                if (currentFilm.getTitle().charAt(0) == previous.getTitle().charAt(0)) {
                    if (currentFilm.getTitle().charAt(0) == nextFilm.getTitle().charAt(0)) {

                        currentFilm.upCounter(previous.getIndexInLetterSubdivision());
                        return FILM_ONLY;
                    } else {

                        currentFilm.upCounter(previous.getIndexInLetterSubdivision());
                        return FILM_AND_COUNTER;
                    }
                } else {
                    if (currentFilm.getTitle().charAt(0) == nextFilm.getTitle().charAt(0)) {
                        currentFilm.resetCounter();
                        return FILM_AND_LETTER;
                    } else {


                        currentFilm.resetCounter();
                        return FILM_AND_LETTER_AND_COUNTER;
                    }
                }

            } else {
                if (currentFilm.getTitle().charAt(0) == previous.getTitle().charAt(0)) {


                    currentFilm.upCounter(previous.getIndexInLetterSubdivision());
                    return FILM_AND_COUNTER;
                } else {


                    currentFilm.resetCounter();
                    return FILM_AND_LETTER_AND_COUNTER;
                }
            }
        } else {
            if (nextFilm != null) {
                if (currentFilm.getTitle().charAt(0) == nextFilm.getTitle().charAt(0)) {


                    currentFilm.resetCounter();
                    return FILM_AND_LETTER;
                } else {


                    currentFilm.resetCounter();
                    return FILM_AND_LETTER_AND_COUNTER;
                }

            } else {


                currentFilm.resetCounter();
                return FILM_AND_LETTER_AND_COUNTER;
            }
        }

    }


}
