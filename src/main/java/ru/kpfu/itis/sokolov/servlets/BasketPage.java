package ru.kpfu.itis.sokolov.servlets;

import ru.kpfu.itis.sokolov.model.basket.BasketDaoImpl;
import ru.kpfu.itis.sokolov.model.music.Product;
import ru.kpfu.itis.sokolov.model.purchases.PurchasesDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/basketpage")
public class BasketPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        BasketDaoImpl basketDao = new BasketDaoImpl();

        List<Product> products = null;
        try {
            products = basketDao.getListOfProductsInBasketByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("products", products);

        req.getServletContext().getRequestDispatcher("/basketpage.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        BasketDaoImpl basketDB = new BasketDaoImpl();
        PurchasesDB purchasesDB = new PurchasesDB();

        List<Product> products = new ArrayList<>();
        try {
            products = basketDB.getListOfProductsInBasketByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            purchasesDB.insertProductsIntoDB(username, products);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("products", products);
        try {
            basketDB.cleanBasketForUser(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/buypage");
    }
}