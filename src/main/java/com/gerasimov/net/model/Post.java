package com.gerasimov.net.model;

import java.sql.Timestamp;

public class Post {
    private int id;
    private int creatorId;
    private String postText;
    private Timestamp creationTime;
    private String creatorName;
    private String creatorFirstName;
    private String creatorLastName;

    public Post(int id, int creatorId, String postText, Timestamp creationTime, String creatorName, String creatorFirstName, String creatorLastName) {
        this.id = id;
        this.creatorId = creatorId;
        this.postText = postText;
        this.creationTime = creationTime;
        this.creatorName = creatorName;
        this.creatorFirstName = creatorFirstName;
        this.creatorLastName = creatorLastName;
    }

    public Post(int id, int creatorId, String postText, Timestamp creationTime, String creatorName) {
        this.id = id;
        this.creatorId = creatorId;
        this.postText = postText;
        this.creationTime = creationTime;
        this.creatorName = creatorName;
    }

    public Post(int id, int creatorId, String postText, Timestamp creationTime) {
        this.id = id;
        this.creatorId = creatorId;
        this.postText = postText;
        this.creationTime = creationTime;
    }

    public Post(int creatorId, String postText, Timestamp creationTime) {
        this.creatorId = creatorId;
        this.postText = postText;
        this.creationTime = creationTime;
    }

    public String getCreatorFirstName() {
        return creatorFirstName;
    }

    public String getCreatorLastName() {
        return creatorLastName;
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
