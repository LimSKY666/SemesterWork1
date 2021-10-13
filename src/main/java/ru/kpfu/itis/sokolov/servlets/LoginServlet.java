package ru.kpfu.itis.sokolov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.sokolov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.sokolov.helper.PasswordHelper;
import ru.kpfu.itis.sokolov.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;


@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    private static final UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userDaoImpl.get(login);
        if (user != null && Objects.equals(PasswordHelper.encrypt(password), user.getPassword())) {
            System.out.println(user.getPassword());
            logger.info("User with username = {} logged in", login);
            HttpSession session = req.getSession();
            session.setAttribute("login", user.getLogin());
            session.setMaxInactiveInterval(60 * 60);

            Cookie userFirstName = new Cookie("firstName", user.getFirstName());
            Cookie userLastName = new Cookie("lastName", user.getLastName());
            Cookie userLogin = new Cookie("login", user.getLogin());

            userFirstName.setMaxAge(24 * 60 * 60);
            userLastName.setMaxAge(24 * 60 * 60);
            userLogin.setMaxAge(24 * 60 * 60);

            resp.addCookie(userFirstName);
            resp.addCookie(userLogin);
            resp.addCookie(userLastName);
            resp.sendRedirect("Main.jsp");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
