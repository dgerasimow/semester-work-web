package com.gerasimov.net.service.impl;

import com.gerasimov.net.dao.impl.CommentDaoImpl;
import com.gerasimov.net.dto.CommentDTO;
import com.gerasimov.net.dto.PostWithCreatorNameDTO;
import com.gerasimov.net.model.Comment;
import com.gerasimov.net.service.CommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommentServiceImpl implements CommentService {
    private final CommentDaoImpl dao = new CommentDaoImpl();
    @Override
    public List<CommentDTO> getCommentsByPost(int postId) {
        List<Comment> comments = dao.getCommentsByPost(postId);
        return comments.stream()
                .map(c -> new CommentDTO(c.getPost_id(), c.getComment_text(), c.getUser_id()))
                .collect(Collectors.toList());
    }
}
