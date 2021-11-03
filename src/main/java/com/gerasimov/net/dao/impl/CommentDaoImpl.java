package com.gerasimov.net.dao.impl;

import com.gerasimov.net.dao.Dao;
import com.gerasimov.net.helper.PostgresConnectionHelper;
import com.gerasimov.net.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements Dao<Comment> {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();
    @Override
    public Comment get(int id) {
        return null;
    }

    public List<Comment> getCommentsByPost (int postId) {
        String sql = "select * from comments where post_id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, postId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Comment> comments = new ArrayList<>();
            if (resultSet.next()) {
                comments.add(new Comment(
                        resultSet.getInt("post_id"),
                        resultSet.getString("post_text"),
                        resultSet.getInt("user_id")
                ));
            }
            return comments;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed get comments by post", throwables);
        }
        return null;
    }

    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public void save(Comment comment) {

    }
}
