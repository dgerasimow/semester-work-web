package com.gerasimov.net.service.impl;

import com.gerasimov.net.dao.impl.PostDaoImpl;
import com.gerasimov.net.dto.PostDTO;
import com.gerasimov.net.dto.PostWithCreatorNameDTO;
import com.gerasimov.net.model.Post;
import com.gerasimov.net.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {
    private final PostDaoImpl dao = new PostDaoImpl();
    @Override
    public PostDTO get(int id) {
        Post post = dao.get(id);
        return new PostDTO(
                post.getCreatorId(),
                post.getPostText(),
                post.getCreationTime()
        );
    }

    @Override
    public List<PostWithCreatorNameDTO> getAllPostsFromSpecificUser(int creatorId) {
        List<Post> posts = dao.getAllPostsFromSpecificUser(creatorId);
        return posts.stream()
                .map(p -> new PostWithCreatorNameDTO(p.getId() ,p.getCreatorId(), p.getPostText(), p.getCreationTime(), p.getCreatorName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return null;
    }

    @Override
    public void createPost(PostDTO post) {
        dao.save(new Post(
                post.getCreatorId(),
                post.getPostText(),
                post.getCreationTime()
                )
        );
    }
}
