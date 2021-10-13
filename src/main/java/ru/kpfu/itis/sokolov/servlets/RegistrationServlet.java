package ru.kpfu.itis.sokolov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.sokolov.model.User;
import ru.kpfu.itis.sokolov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registrationServlet", urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    private static final UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("registration.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String secondName = req.getParameter("last_name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        userServiceImpl.save(new User(firstName,secondName,login,password));
        resp.sendRedirect("login.html");
    }
}
