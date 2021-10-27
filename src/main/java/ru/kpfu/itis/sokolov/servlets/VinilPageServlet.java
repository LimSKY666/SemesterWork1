package ru.kpfu.itis.sokolov.servlets;

import ru.kpfu.itis.sokolov.model.music.Product;
import ru.kpfu.itis.sokolov.model.music.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vinilpage")
public class VinilPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ProductDaoImpl productDB = new ProductDaoImpl();
        Product product = productDB.getProductByID(id);
        req.setAttribute("vinil", product);

        req.getServletContext().getRequestDispatcher("/vinilpage.ftl").forward(req, resp);
    }
}
