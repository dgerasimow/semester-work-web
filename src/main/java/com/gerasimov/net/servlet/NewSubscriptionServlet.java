package com.gerasimov.net.servlet;

import com.gerasimov.net.dto.SubscriptionDTO;
import com.gerasimov.net.dto.UserDTO;
import com.gerasimov.net.service.SubscriptionService;
import com.gerasimov.net.service.impl.SubscriptionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="newSubscriptionServlet", urlPatterns = "/subscribe")
public class NewSubscriptionServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(NewSubscriptionServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubscriptionService subscriptionService = new SubscriptionServiceImpl();

        Integer userId = Integer.parseInt(req.getParameter("user"));
        int currentUserId = (Integer.parseInt(req.getParameter("currentUserId")));
        LOGGER.info("curr user id {}", currentUserId);
        LOGGER.info("creator user id {}", userId);
        subscriptionService.save(new SubscriptionDTO(
                currentUserId,
                userId
        ));
        resp.sendRedirect("/profile?id=" + userId);
    }
}
