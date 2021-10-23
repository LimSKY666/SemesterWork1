package ru.kpfu.itis.sokolov.servlets;

import ru.kpfu.itis.sokolov.helper.CookieHelper;
import ru.kpfu.itis.sokolov.model.user.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getServletContext().getRequestDispatcher("/login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String cookieCheck = req.getParameter("remember");

        HttpSession session = req.getSession();

        UserDaoImpl users = new UserDaoImpl();
        if(username.equals("") || password.equals("")) {
            resp.sendRedirect("/errorlogin");
        } else {
            if (users.userIsExist(username, password)) {
                CookieHelper.cookieCheck(resp, username, cookieCheck, session);
            } else {
                resp.sendRedirect("/errorlogin");
            }
        }
    }
}
