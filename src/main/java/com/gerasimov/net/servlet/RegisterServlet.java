package com.gerasimov.net.servlet;

import com.gerasimov.net.dto.UserDTO;
import com.gerasimov.net.helper.PasswordHelper;
import com.gerasimov.net.service.UserService;
import com.gerasimov.net.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(RegisterServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        LOGGER.info("password is [ {} ]", req.getParameter("password"));
        UserDTO userDTO = new UserDTO(
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                req.getParameter("login"),
                PasswordHelper.encrypt(req.getParameter("password"))
        );
        userService.save(userDTO);
        resp.sendRedirect("/login");
    }
}
