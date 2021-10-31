package com.gerasimov.net.servlet;


import com.gerasimov.net.dto.PostDTO;
import com.gerasimov.net.dto.PostWithCreatorNameDTO;
import com.gerasimov.net.dto.SubscriptionDTO;
import com.gerasimov.net.dto.UserDTO;
import com.gerasimov.net.service.PostService;
import com.gerasimov.net.service.SubscriptionService;
import com.gerasimov.net.service.UserService;
import com.gerasimov.net.service.impl.PostServiceImpl;
import com.gerasimov.net.service.impl.SubscriptionServiceImpl;
import com.gerasimov.net.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "postsServlet", urlPatterns = "/posts")
public class PostsServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(PostsServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService postService = new PostServiceImpl();
        SubscriptionService subService = new SubscriptionServiceImpl();
        UserService userService = new UserServiceImpl();

        HttpSession session = req.getSession();
        UserDTO currentUser = (UserDTO) session.getAttribute("user");
        LOGGER.info("Текущий пользователь: id {}", currentUser.getId());
        List<SubscriptionDTO> subs = subService.getAllBySubId(currentUser.getId());
        List<PostWithCreatorNameDTO> posts = new ArrayList<>();
        for (SubscriptionDTO sub:subs) {
            posts.addAll(postService.getAllPostsFromSpecificUser(sub.getCreatorId()));
            LOGGER.info("Найдены посты по creatorId {}: {}",sub.getCreatorId(), posts);

        }
        LOGGER.info("Подписки текущего пользователя {}", subs);
        LOGGER.info("Отображаемые посты пользователя {}", posts);
        req.setAttribute("posts", posts);

        req.getRequestDispatcher("postsWithHTML.ftl").forward(req,resp);
    }
}
