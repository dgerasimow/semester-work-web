package com.gerasimov.net.service.impl;

import com.gerasimov.net.dao.impl.SubscriptionDaoImpl;

import com.gerasimov.net.dto.SubscriptionDTO;
import com.gerasimov.net.model.Subscription;
import com.gerasimov.net.service.SubscriptionService;

import java.util.List;
import java.util.stream.Collectors;

public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionDaoImpl dao = new SubscriptionDaoImpl();
    @Override
    public SubscriptionDTO get(int id) {
        Subscription subscription = dao.get(id);
        return new SubscriptionDTO(
                subscription.getSubscriberId(),
                subscription.getCreatorId()
        );
    }

    @Override
    public List<SubscriptionDTO> getAllBySubId(int subscriberId) {
        List<Subscription> subs = dao.getAllBySubscriberId(subscriberId);
        return subs.stream()
                .map(u -> new SubscriptionDTO(
                        u.getSubscriberId(),
                        u.getCreatorId()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<SubscriptionDTO> getAllPosts() {

        return null;
    }

    public SubscriptionDTO getSubsBySubscriberIdAndCreatorId (int subId, int creatorId) {
        Subscription sub = dao.getSubsBySubscriberIdAndCreatorId(subId, creatorId);
        if (sub == null) {
            return null;
        } else {

            return new SubscriptionDTO(
                    sub.getSubscriberId(),
                    sub.getCreatorId()
            );
        }
    }

    @Override
    public void save(SubscriptionDTO sub) {
        dao.save(new Subscription(
                sub.getSubscriberId(),
                sub.getCreatorId()
        ));
    }

    public void delete(SubscriptionDTO sub) {
        dao.delete(new Subscription(
                sub.getSubscriberId(),
                sub.getCreatorId()
        ));
    }
}
