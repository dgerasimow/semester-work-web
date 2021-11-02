package com.gerasimov.net.service;

import com.gerasimov.net.dto.PostDTO;
import com.gerasimov.net.dto.SubscriptionDTO;
import com.gerasimov.net.model.Subscription;

import java.util.List;

public interface SubscriptionService {
    SubscriptionDTO get(int id);
    List<SubscriptionDTO> getAllBySubId(int subscriberId);

    List<SubscriptionDTO> getAllPosts();

    SubscriptionDTO getSubsBySubscriberIdAndCreatorId (int subId, int creatorId);

    void save(SubscriptionDTO sub);

    void delete(SubscriptionDTO sub);
}
