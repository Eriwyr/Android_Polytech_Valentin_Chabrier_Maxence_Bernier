package com.adeneo.tp_android.app_film.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adeneo.tp_android.app_film.R;
import com.adeneo.tp_android.app_film.contracts.IItemOnClickManager;
import com.adeneo.tp_android.app_film.contracts.ObjectAdapterAbstract;
import com.adeneo.tp_android.app_film.list_cells.Movie;
import com.adeneo.tp_android.app_film.viewHolders.MovieAndFooterViewHolder;
import com.adeneo.tp_android.app_film.viewHolders.MovieAndHeaderAndFooterViewHolder;
import com.adeneo.tp_android.app_film.viewHolders.MovieAndHeaderViewHolder;
import com.adeneo.tp_android.app_film.viewHolders.MovieViewHolder;

public class FilmListAdapter extends ObjectAdapterAbstract {

    IItemOnClickManager onClickManager;
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
                MovieViewHolder movieViewHolder = new MovieViewHolder(filmView);
                movieViewHolder.setOnClickManager(onClickManager);
                return movieViewHolder;
            case 1:
                View letterView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_movier_and_header, parent, false);
                MovieAndHeaderViewHolder movieAndHeaderViewHolder = new MovieAndHeaderViewHolder(letterView);
                movieAndHeaderViewHolder.setOnClickManager(onClickManager);
                return movieAndHeaderViewHolder;
            case 2:
                View letterCounterView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_movie_and_header_and_footer, parent, false);
                MovieAndHeaderAndFooterViewHolder letterCounterViewHolder = new MovieAndHeaderAndFooterViewHolder(letterCounterView);
                letterCounterViewHolder.setOnClickManager(onClickManager);
                return letterCounterViewHolder;

            case 3:
                View counterView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_movie_and_footer, parent, false);
                MovieAndFooterViewHolder movieAndFooterViewHolder = new MovieAndFooterViewHolder(counterView);
                movieAndFooterViewHolder.setOnClickManager(onClickManager);
                return movieAndFooterViewHolder;
            default:
                return null;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                Movie currentMovie = (Movie) manager.getItems().get(position);

                if (holder instanceof MovieViewHolder && currentMovie != null) {
                    MovieViewHolder viewHolder = (MovieViewHolder) holder;
                    viewHolder.layoutForObject(currentMovie);
                }
                break;
            case 1:
                Movie currentMovieWithLetter = (Movie) manager.getItems().get(position);

                if (holder instanceof MovieAndHeaderViewHolder && currentMovieWithLetter != null) {
                    MovieAndHeaderViewHolder movieAndHeaderViewHolder = (MovieAndHeaderViewHolder) holder;
                    movieAndHeaderViewHolder.layoutForObject(currentMovieWithLetter);
                }

                break;
            case 2:
                Movie currentMovieWithLetterAndCounter = (Movie) manager.getItems().get(position);

                if (holder instanceof MovieAndHeaderAndFooterViewHolder && currentMovieWithLetterAndCounter != null) {
                    MovieAndHeaderAndFooterViewHolder movieAndHeaderAndFooterViewHolder = (MovieAndHeaderAndFooterViewHolder) holder;
                    movieAndHeaderAndFooterViewHolder.layoutForObject(currentMovieWithLetterAndCounter);
                }

                break;
            case 3:
                Movie currentMovieWithCounter = (Movie) manager.getItems().get(position);

                if (holder instanceof MovieAndFooterViewHolder && currentMovieWithCounter != null) {
                    MovieAndFooterViewHolder movieAndFooterViewHolder = (MovieAndFooterViewHolder) holder;
                    movieAndFooterViewHolder.layoutForObject(currentMovieWithCounter);
                }

            default:
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        Movie currentMovie = (Movie) manager.getItems().get(position);

        Movie previous = null;
        try {
            previous = (Movie) manager.getItems().get(position - 1);
        } catch (Exception e) {


        }

        Movie nextMovie = null;
        try {
            nextMovie = (Movie) manager.getItems().get(position + 1);
        } catch (Exception e) {

        }

        if (previous != null) {
            if (nextMovie != null) {
                if (currentMovie.getTitle().charAt(0) == previous.getTitle().charAt(0)) {
                    if (currentMovie.getTitle().charAt(0) == nextMovie.getTitle().charAt(0)) {

                        currentMovie.upCounter(previous.getIndexInLetterSubdivision());
                        return FILM_ONLY;
                    } else {

                        currentMovie.upCounter(previous.getIndexInLetterSubdivision());
                        return FILM_AND_COUNTER;
                    }
                } else {
                    if (currentMovie.getTitle().charAt(0) == nextMovie.getTitle().charAt(0)) {
                        currentMovie.resetCounter();
                        return FILM_AND_LETTER;
                    } else {


                        currentMovie.resetCounter();
                        return FILM_AND_LETTER_AND_COUNTER;
                    }
                }

            } else {
                if (currentMovie.getTitle().charAt(0) == previous.getTitle().charAt(0)) {


                    currentMovie.upCounter(previous.getIndexInLetterSubdivision());
                    return FILM_AND_COUNTER;
                } else {


                    currentMovie.resetCounter();
                    return FILM_AND_LETTER_AND_COUNTER;
                }
            }
        } else {
            if (nextMovie != null) {
                if (currentMovie.getTitle().charAt(0) == nextMovie.getTitle().charAt(0)) {


                    currentMovie.resetCounter();
                    return FILM_AND_LETTER;
                } else {


                    currentMovie.resetCounter();
                    return FILM_AND_LETTER_AND_COUNTER;
                }

            } else {


                currentMovie.resetCounter();
                return FILM_AND_LETTER_AND_COUNTER;
            }
        }

    }

    public void setOnClickManager(IItemOnClickManager onClickManager) {
        this.onClickManager = onClickManager;
    }
}
