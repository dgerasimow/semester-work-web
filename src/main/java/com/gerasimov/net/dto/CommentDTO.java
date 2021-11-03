package com.gerasimov.net.dto;

public class CommentDTO {
    private int postId;
    private String comment_text;
    private int user_id;
    private String userFirstName;

    public CommentDTO(int postId, String comment_text, int user_id) {
        this.postId = postId;
        this.comment_text = comment_text;
        this.user_id = user_id;
    }

    public CommentDTO(int postId, String comment_text, int user_id, String userFirstName) {
        this.postId = postId;
        this.comment_text = comment_text;
        this.user_id = user_id;
        this.userFirstName = userFirstName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public int getPostId() {
        return postId;
    }

    public String getComment_text() {
        return comment_text;
    }

    public int getUser_id() {
        return user_id;
    }
}
