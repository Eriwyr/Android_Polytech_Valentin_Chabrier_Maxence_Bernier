package com.adeneo.tp_android.app_film.list_cells;

public class Film {
    private int indexInLetterSubdivision;
    //static int count;
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Film(String title, String description) {
        indexInLetterSubdivision = 0;
        this.title = title;
        this.description = description;

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
}
