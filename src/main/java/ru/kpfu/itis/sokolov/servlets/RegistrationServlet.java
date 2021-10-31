package ru.kpfu.itis.sokolov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.sokolov.helper.CookieHelper;
import ru.kpfu.itis.sokolov.dao.impl.UserDaoImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/registration.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String cookieCheck = req.getParameter("remember");
        HttpSession session = req.getSession();

        UserDaoImpl users = new UserDaoImpl();
        if (users.userIsExist(username, password)) {
            resp.sendRedirect("/registration");
        } else {
            if (users.saveUser(username, password)) {
                CookieHelper.cookieCheck(resp, username, cookieCheck, session);
            }
        }
    }
}
