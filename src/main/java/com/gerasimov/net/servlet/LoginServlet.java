package com.gerasimov.net.servlet;

import com.gerasimov.net.dto.PostWithCreatorNameDTO;
import com.gerasimov.net.dto.SubscriptionDTO;
import com.gerasimov.net.dto.UserDTO;
import com.gerasimov.net.helper.PasswordHelper;
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
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getSession().isNew()){
            req.getRequestDispatcher("profileWithHTML.ftl").forward(req, resp);
        } else {
            resp.sendRedirect("loginWITHWERSTKA.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        PostService postService = new PostServiceImpl();
        SubscriptionService subService = new SubscriptionServiceImpl();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserDTO user = userService.get(login);
        if(user!=null) {
            LOGGER.info("пришел юзер {} с паролем {}", user.getLogin(), user.getPassword());
//        пароль с энкриптингом
            LOGGER.info("user password before encrypt [ {}]  after [ {}] ", password, PasswordHelper.encrypt("password"));
        if (user.getLogin().equals(login) && Objects.equals(user.getPassword()
                ,PasswordHelper.encrypt(password))) {
            //пароль без энкриптинга
//            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                LOGGER.info("User with username = {} logged in", login);
                HttpSession session = req.getSession();
                session.setMaxInactiveInterval(60 * 60);

//                Cookie userCookie = new Cookie("username", login);
//                userCookie.setMaxAge(24 * 60);
//
//                resp.addCookie(userCookie);
                List<SubscriptionDTO> subs = subService.getAllBySubId(user.getId());
                List<PostWithCreatorNameDTO> posts = new ArrayList<>();
                for (SubscriptionDTO sub:subs) {
                    posts.addAll(postService.getAllPostsFromSpecificUser(sub.getCreatorId()));
                }


                session.setAttribute("user", user);
                session.setAttribute("posts", posts);
                resp.sendRedirect("/profileч");
        } else {
                LOGGER.info("Incorrect login or password");
                resp.sendRedirect("/login");
            }
        } else {
            resp.sendRedirect("/login");
        }

    }
}
