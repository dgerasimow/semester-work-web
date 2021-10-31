package com.gerasimov.net.service;

import com.gerasimov.net.dto.PostDTO;
import com.gerasimov.net.dto.PostWithCreatorNameDTO;

import java.util.List;

public interface PostService {
    PostDTO get(int id);
    List<PostWithCreatorNameDTO> getAllPostsFromSpecificUser(int creatorId);

    List<PostDTO> getAllPosts();

    void createPost(PostDTO post);
}
