package ru.kpfu.itis.sokolov.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "logout", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                resp.addCookie(c);
            }
        }

        HttpSession session = req.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        resp.sendRedirect("login.html");
    }
}
