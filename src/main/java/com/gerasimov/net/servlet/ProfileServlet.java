package com.gerasimov.net.servlet;

import com.gerasimov.net.dto.CommentDTO;
import com.gerasimov.net.dto.PostWithCreatorNameDTO;
import com.gerasimov.net.dto.UserDTO;
import com.gerasimov.net.service.CommentService;
import com.gerasimov.net.service.PostService;
import com.gerasimov.net.service.SubscriptionService;
import com.gerasimov.net.service.UserService;
import com.gerasimov.net.service.impl.CommentServiceImpl;
import com.gerasimov.net.service.impl.PostServiceImpl;
import com.gerasimov.net.service.impl.SubscriptionServiceImpl;
import com.gerasimov.net.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(ProfileServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            PostService postService = new PostServiceImpl();
            UserService userService = new UserServiceImpl();
            SubscriptionService subscriptionService = new SubscriptionServiceImpl();
            CommentService commentService = new CommentServiceImpl();

            UserDTO currentUser = (UserDTO) req.getSession().getAttribute("user");
            UserDTO user = userService.get(Integer.parseInt(req.getParameter("id")));
            List<PostWithCreatorNameDTO> userPosts = postService.getAllPostsFromSpecificUser(Integer.parseInt(req.getParameter("id")));
            Collections.reverse(userPosts);
            HashMap<PostWithCreatorNameDTO, List<CommentDTO>> postAndCommentMap = new HashMap<>();
            for (PostWithCreatorNameDTO p : userPosts) {
                List<CommentDTO> comment = commentService.getCommentsByPost(p.getId());
                if (comment != null) {
                    postAndCommentMap.put(p, comment);
                }
            }

            req.setAttribute("user", user);
            req.setAttribute("userPosts", postAndCommentMap);
            req.setAttribute("currentUserId", currentUser.getId());
            if (currentUser.getId() == Integer.parseInt(req.getParameter("id"))) {
                req.getRequestDispatcher("profileWithHTML.ftl").forward(req, resp);
            } else if (subscriptionService.getSubsBySubscriberIdAndCreatorId(currentUser.getId(), user.getId()) == null) {
                req.getRequestDispatcher("someoneProfile.ftl").forward(req, resp);
            } else {
                req.getRequestDispatcher("someoneSubscribedProfile.ftl").forward(req, resp);
            }
        } else {
            resp.sendRedirect("/login");
        }
    }
}
