package com.gerasimov.net.servlet;

import com.gerasimov.net.dto.UserDTO;
import com.gerasimov.net.helper.PasswordHelper;
import com.gerasimov.net.service.UserService;
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
        HashMap<String, Object> validationResultMap = registerValidation(
                req.getParameter("firstName"),
                req.getParameter("secondName"),
                req.getParameter("login"),
                req.getParameter("password"));
        if ((boolean) validationResultMap.get("success")) {
            UserDTO userDTO = new UserDTO(
                    req.getParameter("firstName"),
                    req.getParameter("secondName"),
                    req.getParameter("login"),
                    req.getParameter("password")
            );
            userService.save(userDTO);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write((String) validationResultMap.get("json"));
//        resp.sendRedirect("/login");
    }
    private HashMap<String, Object> registerValidation(String firstName, String secondName, String login, String password) {
        HashMap<String, String> errors = new HashMap<>();
        errors.put("loginEmpty", "Логин не может быть пустым");
        errors.put("firstNameEmpty", "Имя не может быть пустым");
        errors.put("secondNameEmpty", "Фамилия не может быть пустым");
        errors.put("passwordEmpty", "Пароль не может быть пустым");
        errors.put("passwordRegexp", "Пароль должен быть не менее 6 символов, содержать одно число, спецсимвол, нижний и верхний регистр");

        HashMap<String, Object> responseData = new HashMap<>();
        HashMap<String, String> errorsToResponseData = new HashMap<>();
        LOGGER.info("LOGIN IS {}", login);
        LOGGER.info("PASS IS {}", password);
        HashMap<String,Object> mapResponseData = new HashMap<>();
        if (login.isEmpty()) {
            errorsToResponseData.put("loginEmpty", errors.get("loginEmpty"));
            LOGGER.info("LOGIN EMPTY");
        }
        if (password.isEmpty()) {
            errorsToResponseData.put("passwordEmpty", errors.get("passwordEmpty"));
        }
        if (!password.matches("(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}")) {
            errorsToResponseData.put("passwordRegexp", errors.get("passwordRegexp"));
        }
        if (firstName.isEmpty()) {
            errorsToResponseData.put("firstNameEmpty", errors.get("firstNameEmpty"));
        }
        if (secondName.isEmpty()) {
            errorsToResponseData.put("secondNameEmpty", errors.get("secondNameEmpty"));
        }
        if (!errorsToResponseData.isEmpty()) {
            responseData.put("errors", errorsToResponseData);
            responseData.put("success", false);
            mapResponseData.put("success", false);
        } else {
            LOGGER.info("SUCCESS");
            responseData.put("success", true);
            mapResponseData.put("success", true);
        }
        Gson gson = new Gson();
        LOGGER.info(gson.toJson(responseData));
        mapResponseData.put("json",gson.toJson(responseData));
        return mapResponseData;
    }

}
