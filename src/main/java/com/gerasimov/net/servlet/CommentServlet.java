package com.gerasimov.net.servlet;

import com.gerasimov.net.dto.CommentDTO;
import com.gerasimov.net.dto.UserDTO;
import com.gerasimov.net.service.CommentService;
import com.gerasimov.net.service.UserService;
import com.gerasimov.net.service.impl.CommentServiceImpl;
import com.gerasimov.net.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(urlPatterns = "/comment")
public class CommentServlet extends HttpServlet {
    public static final Logger LOGGER = LoggerFactory.getLogger(CommentServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentService commentService = new CommentServiceImpl();
        UserService userService = new UserServiceImpl();
        UserDTO user = (UserDTO) req.getSession().getAttribute("user");
        commentService.save(new CommentDTO(
                Integer.parseInt(req.getParameter("post_id")),
                req.getParameter("comment_text"),
                user.getId())
        );
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(makeNewComment(user.getFirstName(),Integer.parseInt(req.getParameter("post_id")),
                req.getParameter("comment_text"),
                user.getId()));
    }

    private String makeNewComment(String firstName,int postId, String commentText, int userId) {
        HashMap<String, Object> responseDataMap = new HashMap<>();
        responseDataMap.put("success", true);
        responseDataMap.put("postId", postId);
        responseDataMap.put("commentText", commentText);
        responseDataMap.put("userId", userId);
        responseDataMap.put("firstName", firstName);

        Gson gson = new Gson();
        return gson.toJson(responseDataMap);
    }
}
