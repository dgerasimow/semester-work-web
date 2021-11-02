package com.gerasimov.net.servlet;

import com.gerasimov.net.dto.SubscriptionDTO;
import com.gerasimov.net.dto.UserDTO;
import com.gerasimov.net.service.SubscriptionService;
import com.gerasimov.net.service.UserService;
import com.gerasimov.net.service.impl.SubscriptionServiceImpl;
import com.gerasimov.net.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "subsServlet", urlPatterns = "/subs")
public class SubsServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(SubsServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO currentUser = (UserDTO) req.getSession().getAttribute("user");
        SubscriptionService subsService = new SubscriptionServiceImpl();
        UserService userService = new UserServiceImpl();
        List<SubscriptionDTO> subs = subsService.getAllBySubId(currentUser.getId());
        List<UserDTO> subsUsers = new ArrayList<>();
        for (SubscriptionDTO s: subs) {
            subsUsers.add(userService.get(s.getCreatorId()));
        }
        req.setAttribute("subs", subsUsers);
        req.setAttribute("currentUserId", currentUser.getId());
        req.getRequestDispatcher("subsList.ftl").forward(req,resp);
    }
}
