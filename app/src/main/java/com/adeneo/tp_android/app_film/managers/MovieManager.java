package com.adeneo.tp_android.app_film.managers;

import com.adeneo.tp_android.app_film.list_cells.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieManager {

    private static volatile MovieManager instance;
    private static Object mutex = new Object();
    private ArrayList<Movie> movies;

    private MovieManager() {

        movies = new ArrayList<>();

        Collections.sort(movies,
                new Comparator<Movie>() {
                    public int compare(Movie f1, Movie f2) {
                        return f1.getTitle().toString().compareTo(f2.getTitle().toString());
                    }
                });
        movies.add(new Movie(1, "A Movie 1", "1985, Marty Mac Fly a regagné la paisible bourgade de Hill Valley, après son voyage mouvementé à travers le temps. Il savoure la quiétude avec sa petite amie Jennifer"));
        movies.add(new Movie(2, "A Movie 2", "je suis le deuxième film A"));
        movies.add(new Movie(3, "A Movie 3", "je suis le troisième film A"));
        movies.add(new Movie(4, "B Movie 1", "je suis le premier film B"));
        movies.add(new Movie(5, "C Movie 1", "je suis le premier film C"));
        movies.add(new Movie(6, "C Movie 2", "je suis le deuxième film C"));
        movies.add(new Movie(7, "C Movie 3", "1985, Marty Mac Fly a regagné la paisible bourgade de Hill Valley, après son voyage mouvementé à travers le temps. Il savoure la quiétude avec sa petite amie Jennifer"));
        movies.add(new Movie(8, "C Movie 4", "je suis le quatrième film C"));
        movies.add(new Movie(9, "C Movie 5", "je suis le cinquième film C"));
        movies.add(new Movie(10, "C Movie 6", "je suis le sixième film C"));
        movies.add(new Movie(11, "D Movie 1", "je suis le premier film D"));
        movies.add(new Movie(12, "D Movie 2", "je suis le deuxième film D"));
    }

    public static MovieManager getInstance() {
        MovieManager result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new MovieManager();
            }
        }
        return result;
    }

    public Movie getMoviesById(int id) {

        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public int getCountItem() {
        if (movies != null) {
            return movies.size();
        }
        return 0;
    }

    public List<Movie> getItems() {
        return movies;
    }
}


//On back press