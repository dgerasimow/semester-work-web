package com.gerasimov.net.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "someoneProfileServlet", urlPatterns = "/profile/*")
public class SomeoneProfileServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(SomeoneProfileServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
