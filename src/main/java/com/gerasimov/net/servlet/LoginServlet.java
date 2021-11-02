package com.gerasimov.net.servlet;

import com.gerasimov.net.dto.UserDTO;
import com.gerasimov.net.helper.PasswordHelper;
import com.gerasimov.net.service.PostService;
import com.gerasimov.net.service.SubscriptionService;
import com.gerasimov.net.service.UserService;
import com.gerasimov.net.service.impl.PostServiceImpl;
import com.gerasimov.net.service.impl.SubscriptionServiceImpl;
import com.gerasimov.net.service.impl.UserServiceImpl;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import java.util.HashMap;
import java.util.Objects;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession();

        if (cookies != null && req.getSession(false).getAttribute("isAuth") == null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("userId")){
                    LOGGER.info("Нашел куку с именем {} и значением {}", c.getName(), c.getValue());
                    session.setMaxInactiveInterval(60 * 60);
                    UserDTO currentUser = userService.get(Integer.parseInt(c.getValue()));
                    session.setAttribute("user", currentUser);
                    session.setAttribute("isAuth", true);
                }
            }
        }

        if (req.getSession(false) != null && req.getSession().getAttribute("isAuth") != null) {
            LOGGER.info("Redirecting to profile endpoint");
            UserDTO currentUser = (UserDTO) session.getAttribute("user");
            resp.sendRedirect("/profile?id=" + currentUser.getId());
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
        if (user != null) {
            LOGGER.info("пришел юзер {} с паролем {}", user.getLogin(), user.getPassword());
            if (user.getLogin().equals(login) && Objects.equals(user.getPassword()
                    , PasswordHelper.encrypt(password))) {

                LOGGER.info("User with username = {} logged in", login);
                HttpSession session = req.getSession();
                session.setMaxInactiveInterval(60 * 60);
                session.setAttribute("isAuth", true);
                if (req.getParameter("remember-me-checkbox") != null) {
                    Cookie userCookie = new Cookie("userId", Integer.toString(user.getId()));
                    userCookie.setMaxAge(24 * 60);
                    resp.addCookie(userCookie);
                    LOGGER.info("создал куку с именем {} и значением {}",userCookie.getName(), userCookie.getValue());
                }
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(loginFormValidate(login, password, user.getId()));

                session.setAttribute("user", user);
//                resp.sendRedirect("/profile?id=" + user.getId());
            } else {
                LOGGER.info("Incorrect login or password");
                req.getSession().setAttribute("isAuth", false);

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(loginFormValidate(login, password,0));

            }
        } else {
            LOGGER.info("WHAT?");
            req.getSession().setAttribute("isAuth", false);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(loginFormValidate(login, password,0));
        }

    }

    private String loginFormValidate(String login, String password, int loggedUserId) {
        HashMap<String, String> errors = new HashMap<>();
        errors.put("loginEmpty", "Логин не может быть пустым");
        errors.put("passwordEmpty", "Пароль не может быть пустым");
        errors.put("passwordTooShort", "Пароль должен быть не менее 6 символов!");

        HashMap<String, Object> responseData = new HashMap<>();
        HashMap<String, String> errorsToResponseData = new HashMap<>();
        LOGGER.info("LOGIN IS {}", login);
        LOGGER.info("PASS IS {}", password);
        if (login.isEmpty()) {
            errorsToResponseData.put("loginEmpty", errors.get("loginEmpty"));
            LOGGER.info("LOGIN EMPTY");
        }
        if (password.isEmpty()) {
            errorsToResponseData.put("passwordEmpty", errors.get("passwordEmpty"));
        }
        if (password.length() < 6) {
            errorsToResponseData.put("passwordTooShort", errors.get("passwordTooShort"));
        }
        if (!errorsToResponseData.isEmpty()) {
            responseData.put("errors", errorsToResponseData);
            responseData.put("success", false);
        } else {
            LOGGER.info("SUCCESS");
            responseData.put("success", true);
            responseData.put("loggedUserId", loggedUserId);
        }
        Gson gson = new Gson();
        LOGGER.info(gson.toJson(responseData));
        return gson.toJson(responseData);
    }
}
