package com.gerasimov.net.dao.impl;

import com.gerasimov.net.dao.Dao;
import com.gerasimov.net.helper.PostgresConnectionHelper;
import com.gerasimov.net.model.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDaoImpl implements Dao<Subscription> {
    public static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionDaoImpl.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();
    @Override
    public Subscription get(int id) {
        String sql = "select * from subscriptions_to_user_posts where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Subscription(
                        resultSet.getInt("id"),
                        resultSet.getInt("subscriber_user_id"),
                        resultSet.getInt("creator_id")
                );
            }
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get by id", throwables);
        }
        return null;
    }
    public List<Subscription> getAllBySubscriberId(int subscriberId) {
        String sql = "select * from subscriptions_to_user_posts where subscriber_user_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,subscriberId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Subscription> subs = new ArrayList<>();
            while (resultSet.next()) {
                subs.add(new Subscription(
                        resultSet.getInt("id"),
                        resultSet.getInt("subscriber_user_id"),
                        resultSet.getInt("creator_id")
                ));

            }
            LOGGER.info("Создан список сабсов {}", subs);

            return subs;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get all subs by subscriberId", throwables);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Subscription> getAll() {
        return null;
    }

    @Override
    public void save(Subscription subscription) {

    }
}
