package com.gerasimov.net.dto;

import java.sql.Timestamp;

public class PostDTO {
    private int creatorId;
    private String postText;
    private Timestamp creationTime;

    public PostDTO(int creatorId, String postText, Timestamp creationTime) {
        this.creatorId = creatorId;
        this.postText = postText;
        this.creationTime = creationTime;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public String getPostText() {
        return postText;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }
}
