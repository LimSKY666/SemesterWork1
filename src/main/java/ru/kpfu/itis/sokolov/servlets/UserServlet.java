package ru.kpfu.itis.sokolov.servlets;



import ru.kpfu.itis.sokolov.dto.UserDTO;
import ru.kpfu.itis.sokolov.service.UserService;
import ru.kpfu.itis.sokolov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "usersServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDTO> users = userService.getAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("users.ftl").forward(req, resp);
    }
}
