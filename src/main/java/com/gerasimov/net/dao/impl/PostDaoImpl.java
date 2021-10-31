package com.gerasimov.net.dao.impl;

import com.gerasimov.net.dao.Dao;
import com.gerasimov.net.helper.PostgresConnectionHelper;
import com.gerasimov.net.model.Post;
import com.gerasimov.net.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl implements Dao<Post> {
    public static final Logger LOGGER = LoggerFactory.getLogger(PostDaoImpl.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();
    @Override
    public Post get(int id) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Post(
                        resultSet.getInt("id"),
                        resultSet.getInt("creator_id"),
                        resultSet.getString("post_text"),
                        resultSet.getTimestamp("creation_time")
                );
            }

        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get post by id", throwables);
        }
        return null;
    }

    public List<Post> getAllPostsFromSpecificUser(int id) {
        String sql = "select p.*, u.login user_name from posts p join users u on u.id = p.creator_id where u.id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Post> postsFromSpecificUser = new ArrayList<>();
            while (resultSet.next()) {
                postsFromSpecificUser.add(new Post(resultSet.getInt("id"),
                        resultSet.getInt("creator_id"),
                        resultSet.getString("post_text"),
                        resultSet.getTimestamp("creation_time"),
                        resultSet.getString("user_name")));
            }
            return postsFromSpecificUser;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get all posts from specific user", throwables);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Post> getAll() {
        return null;
    }

    @Override
    public void save(Post post) {

    }
}
