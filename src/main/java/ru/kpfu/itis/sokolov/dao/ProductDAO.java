package ru.kpfu.itis.sokolov.dao;

import ru.kpfu.itis.sokolov.model.Product;

public interface ProductDAO {
    public Product getProductByID(int id);
}
