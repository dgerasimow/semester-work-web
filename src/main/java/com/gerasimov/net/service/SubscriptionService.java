package com.gerasimov.net.service;

import com.gerasimov.net.dto.PostDTO;
import com.gerasimov.net.dto.SubscriptionDTO;

import java.util.List;

public interface SubscriptionService {
    SubscriptionDTO get(int id);
    List<SubscriptionDTO> getAllBySubId(int subscriberId);

    List<SubscriptionDTO> getAllPosts();

    void createPost(PostDTO post);
}
