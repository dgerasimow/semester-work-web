package com.gerasimov.net.dto;

import java.sql.Timestamp;

public class PostWithCreatorNameDTO {
    private int id;
    private int creatorId;
    private String postText;
    private Timestamp creationTime;
    private String creatorName;

    public PostWithCreatorNameDTO(int creatorId, String postText, Timestamp creationTime, String creatorName) {
        this.creatorId = creatorId;
        this.postText = postText;
        this.creationTime = creationTime;
        this.creatorName = creatorName;
    }

    public PostWithCreatorNameDTO(int id, int creatorId, String postText, Timestamp creationTime, String creatorName) {
        this.id = id;
        this.creatorId = creatorId;
        this.postText = postText;
        this.creationTime = creationTime;
        this.creatorName = creatorName;
    }

    public int getId() {
        return id;
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

    public String getCreatorName() {
        return creatorName;
    }
}
