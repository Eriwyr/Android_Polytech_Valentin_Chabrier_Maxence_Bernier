package com.adeneo.tp_android.app_film.list_cells;

public class Comment {

    private String userName;
    private String content;
    private int userId;

    public Comment(String userName, String content, int userId) {

        this.userName = userName;
        this.content = content;
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }

    public int getUserId() {
        return userId;
    }
}
