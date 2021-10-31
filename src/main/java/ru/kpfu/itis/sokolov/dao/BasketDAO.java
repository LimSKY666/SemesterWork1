package ru.kpfu.itis.sokolov.dao;

import ru.kpfu.itis.sokolov.model.Product;

import java.sql.SQLException;
import java.util.LinkedList;

public interface BasketDAO {
    public boolean saveProductToBasket(String username, int productId);
    public LinkedList<Product> getListOfProductsInBasketByUsername(String username) throws SQLException;
    public boolean deleteProductFromBasket(int productId) throws SQLException;
    public boolean cleanBasketForUser(String username) throws SQLException;
}
