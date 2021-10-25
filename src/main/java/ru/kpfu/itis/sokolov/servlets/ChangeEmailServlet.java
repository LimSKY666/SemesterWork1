package ru.kpfu.itis.sokolov.servlets;

import ru.kpfu.itis.sokolov.model.user.User;
import ru.kpfu.itis.sokolov.model.user.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "changeEmailServlet", urlPatterns = "/changeEmail")
public class ChangeEmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDaoImpl userDd = new UserDaoImpl();
        HttpSession session = req.getSession();

        String email = (String) req.getParameter("email");
        String username = (String) session.getAttribute("username");

        User user = userDd.getUserByName(username);

        resp.sendRedirect("/profilepage.ftl");
    }
}