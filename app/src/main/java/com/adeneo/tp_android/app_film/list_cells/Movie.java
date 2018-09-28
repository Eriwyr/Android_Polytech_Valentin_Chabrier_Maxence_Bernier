package com.adeneo.tp_android.app_film.list_cells;

public class Movie {

    private int id;
    private int indexInLetterSubdivision;
    private String title;
    private String originalTitle;
    private String description;
    private String keyWords;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Movie(int id, String title, String description) {
        indexInLetterSubdivision = 0;
        this.id = id;
        this.title = title;
        this.description = description;

    }


    public Movie(int id, String title, String originalTitle, String description, String keyWords) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.description = description;
        this.keyWords = keyWords;
    }

    public int getIndexInLetterSubdivision() {
        return indexInLetterSubdivision;
    }

    public void setIndexInLetterSubdivision(int indexInLetterSubdivision) {
        this.indexInLetterSubdivision = indexInLetterSubdivision;
    }

    public void upCounter(int previuous) {
        if (indexInLetterSubdivision == 0)
            this.indexInLetterSubdivision = previuous + 1;

    }

    public void resetCounter() {
        if (indexInLetterSubdivision == 0)
            this.indexInLetterSubdivision = 1;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public int getId() {
        return id;
    }
}
