package com.gerasimov.net.servlet;

import com.gerasimov.net.dto.PostWithCreatorNameDTO;
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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(ProfileServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService postService = new PostServiceImpl();
        UserService userService = new UserServiceImpl();
        SubscriptionService subscriptionService = new SubscriptionServiceImpl();

        UserDTO currentUser = (UserDTO) req.getSession().getAttribute("user");
        UserDTO user = userService.get(Integer.parseInt(req.getParameter("id")));
        List<PostWithCreatorNameDTO> userPosts = postService.getAllPostsFromSpecificUser(Integer.parseInt(req.getParameter("id")));
        Collections.reverse(userPosts);

        req.setAttribute("user", user);
        req.setAttribute("userPosts", userPosts);
        req.setAttribute("currentUserId", currentUser.getId());
        if (currentUser.getId() == Integer.parseInt(req.getParameter("id"))) {
            req.getRequestDispatcher("profileWithHTML.ftl").forward(req,resp);
        } else if (subscriptionService.getSubsBySubscriberIdAndCreatorId(currentUser.getId(), user.getId()) == null) {
            req.getRequestDispatcher("someoneProfile.ftl").forward(req,resp);
        } else {
            req.getRequestDispatcher("someoneSubscribedProfile.ftl").forward(req,resp);
        }
    }
}
