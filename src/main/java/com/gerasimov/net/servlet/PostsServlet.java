package com.gerasimov.net.servlet;


import com.gerasimov.net.dto.*;
import com.gerasimov.net.service.CommentService;
import com.gerasimov.net.service.PostService;
import com.gerasimov.net.service.SubscriptionService;
import com.gerasimov.net.service.UserService;
import com.gerasimov.net.service.impl.CommentServiceImpl;
import com.gerasimov.net.service.impl.PostServiceImpl;
import com.gerasimov.net.service.impl.SubscriptionServiceImpl;
import com.gerasimov.net.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "postsServlet", urlPatterns = "/posts")
public class PostsServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(PostsServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubscriptionService subService = new SubscriptionServiceImpl();
        PostService postService = new PostServiceImpl();
        CommentService commentService = new CommentServiceImpl();

        HttpSession session = req.getSession(false);

        if (session != null) {
            UserDTO currentUser = (UserDTO) session.getAttribute("user");
            LOGGER.info("Текущий пользователь: id {}", currentUser.getId());
            List<SubscriptionDTO> subs = subService.getAllBySubId(currentUser.getId());
            List<PostWithCreatorNameDTO> posts = new ArrayList<>();
            for (SubscriptionDTO s : subs) {
                posts.addAll(postService.getAllPostsFromSpecificUser(s.getCreatorId()));
            }
            HashMap<PostWithCreatorNameDTO, List<CommentDTO>> postAndCommentMap = new HashMap<>();

            for (PostWithCreatorNameDTO p : posts) {
                List<CommentDTO> comment = commentService.getCommentsByPost(p.getId());
                if (comment != null) {
                    postAndCommentMap.put(p, comment);
                }
            }

            LOGGER.info("Подписки текущего пользователя {}", subs);
            LOGGER.info("Отображаемые посты пользователя {}", posts);
            Collections.reverse(posts);
            req.setAttribute("user", currentUser);
            req.setAttribute("posts", postAndCommentMap);
            req.setAttribute("currentUserId", currentUser.getId());

            req.getRequestDispatcher("postsWithHTML.ftl").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService postService = new PostServiceImpl();
        LOGGER.info("Entering POST PostsServlet");
        HttpSession session = req.getSession();
        UserDTO currentUser = (UserDTO) session.getAttribute("user");
        LOGGER.info("TEXT FROM TEXTAREA {}",req.getParameter("post-textarea"));
        PostDTO newPost = new PostDTO(
                currentUser.getId(),
                req.getParameter("postText"),
                new Timestamp(System.currentTimeMillis())
        );
        postService.createPost(newPost);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(makeNewPostJson(currentUser.getFirstName(), currentUser.getSecondName(),
                req.getParameter("postText"),new Timestamp(System.currentTimeMillis())));
//        resp.sendRedirect("/profile?id=" + currentUser.getId());
    }

    private String makeNewPostJson(String creatorFirstName, String creatorSecondName, String postText, Timestamp creationTime) {
        HashMap<String, Object> responseDataMap = new HashMap<>();
        responseDataMap.put("success", true);
        responseDataMap.put("first_name", creatorFirstName);
        responseDataMap.put("second_name", creatorSecondName);
        responseDataMap.put("post_text", postText);
        responseDataMap.put("creation_time", creationTime);
        LOGGER.info("postText {}",postText);
        Gson gson = new Gson();
        return gson.toJson(responseDataMap);
    }
}
