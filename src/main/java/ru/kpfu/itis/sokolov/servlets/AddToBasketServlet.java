package ru.kpfu.itis.sokolov.servlets;

import ru.kpfu.itis.sokolov.model.basket.BasketDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addToBasket")
public class AddToBasketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        int id = Integer.parseInt(req.getParameter("vinilId"));
        String username = (String) session.getAttribute("username");

        BasketDaoImpl basketDB = new BasketDaoImpl();
        basketDB.saveProductToBasket(username, id);

        resp.sendRedirect("/basketpage");
    }
}
