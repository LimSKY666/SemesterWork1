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

@WebServlet(name = "profileServlet", urlPatterns = "/prof")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        UserDaoImpl users = new UserDaoImpl();
        User user = users.getUserByName(username);
        String registrationTimestamp = user.getRegistrationTimestamp().toString();
        String email = user.getEmail();

        req.setAttribute("registrationTimestamp", registrationTimestamp);
        if (email == null) {
            req.setAttribute("email", "-");
        } else {
            req.setAttribute("email", email);
        }
        req.getServletContext().getRequestDispatcher("/profilepage.jsp").forward(req, resp);
    }


}
