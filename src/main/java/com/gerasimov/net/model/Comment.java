package com.gerasimov.net.model;

public class Comment {
    private int id;
    private int post_id;
    private String comment_text;
    private int user_id;
    private String userFirstName;
    private String userLastName;

    public Comment(int id, int post_id, String comment_text, int user_id) {
        this.id = id;
        this.post_id = post_id;
        this.comment_text = comment_text;
        this.user_id = user_id;
    }

    public Comment(int post_id, String comment_text, int user_id) {
        this.post_id = post_id;
        this.comment_text = comment_text;
        this.user_id = user_id;
    }

    public Comment(int id, int post_id, String comment_text, int user_id, String userFirstName, String userLastName) {
        this.id = id;
        this.post_id = post_id;
        this.comment_text = comment_text;
        this.user_id = user_id;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public int getId() {
        return id;
    }

    public int getPost_id() {
        return post_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public int getUser_id() {
        return user_id;
    }
}
