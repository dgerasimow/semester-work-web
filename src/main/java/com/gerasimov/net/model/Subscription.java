package com.gerasimov.net.model;

public class Subscription {
    private int id;
    private int subscriberId;
    private int creatorId;

    public Subscription(int id, int subscriberId, int creatorId) {
        this.id = id;
        this.subscriberId = subscriberId;
        this.creatorId = creatorId;
    }

    public int getId() {
        return id;
    }

    public int getSubscriberId() {
        return subscriberId;
    }

    public int getCreatorId() {
        return creatorId;
    }
}
