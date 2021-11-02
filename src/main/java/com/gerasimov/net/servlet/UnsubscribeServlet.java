package com.gerasimov.net.servlet;

import com.gerasimov.net.dto.SubscriptionDTO;
import com.gerasimov.net.service.SubscriptionService;
import com.gerasimov.net.service.impl.SubscriptionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="unsubscribeServlet", urlPatterns = "/unsubscribe")
public class UnsubscribeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubscriptionService subscriptionService = new SubscriptionServiceImpl();
        Integer userId = Integer.parseInt(req.getParameter("user"));
        int currentUserId = (Integer.parseInt(req.getParameter("currentUserId")));
        subscriptionService.delete(new SubscriptionDTO(
                currentUserId,
                userId
        ));
        resp.sendRedirect("/profile?id=" + userId);
    }
}
