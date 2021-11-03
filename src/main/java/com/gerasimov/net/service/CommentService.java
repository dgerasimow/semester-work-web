package com.gerasimov.net.service;

import com.gerasimov.net.dto.CommentDTO;


import java.util.List;

public interface CommentService {
    List<CommentDTO> getCommentsByPost(int postId);

    void save(CommentDTO comment);
}
