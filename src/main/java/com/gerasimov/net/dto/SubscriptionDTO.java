package com.gerasimov.net.dto;

public class SubscriptionDTO {
    private int subscriberId;
    private int creatorId;

    public SubscriptionDTO(int subscriberId, int creatorId) {
        this.subscriberId = subscriberId;
        this.creatorId = creatorId;
    }

    public int getSubscriberId() {
        return subscriberId;
    }

    public int getCreatorId() {
        return creatorId;
    }
}
