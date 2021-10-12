package com.gerasimov.net.servlet;

import com.gerasimov.net.dto.UserDTO;
import com.gerasimov.net.helper.PasswordHelper;
import com.gerasimov.net.service.UserService;
import com.gerasimov.net.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserDTO user = userService.get(login);
        if(user!=null) {
            LOGGER.info("пришел юзер {} с паролем {}", user.getLogin(), user.getPassword());
//        пароль с энкриптингом
            LOGGER.info("user password before encrypt [ {}]  after [ {}] ", password, PasswordHelper.encrypt(password));
        if (user.getLogin().equals(login) && Objects.equals(user.getPassword()
                ,PasswordHelper.encrypt(password))) {
            //пароль без энкриптинга
//            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                LOGGER.info("User with username = {} logged in", login);
                HttpSession session = req.getSession();
                session.setAttribute("username", login);
                session.setMaxInactiveInterval(60 * 60);

                Cookie userCookie = new Cookie("username", login);
                userCookie.setMaxAge(24 * 60);
                resp.addCookie(userCookie);

                req.setAttribute("user", user);
                req.getRequestDispatcher("Profile.ftl").forward(req, resp);
            } else {
                LOGGER.info("Incorrect login or password");
                resp.sendRedirect("/login");
            }
        } else {
            resp.sendRedirect("/login");
        }

    }
}
