package ru.kpfu.itis.sokolov.model.music;

import ru.kpfu.itis.sokolov.helper.PostgresConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDAO {

    private final Connection connection = PostgresConnectionHelper.getConnection();

    private static final String SQL_SELECT_PRODUCT_BY_ID
            = "SELECT id, name, description, composer, image, price, count_of_marks, rating FROM products JOIN product_rating ON product_id = id WHERE id = ?";

    private static final String SQL_CHANGE_RATING_BY_PRODUCT_ID = "UPDATE product_rating SET count_of_marks = ?, rating = ? WHERE product_id = ?";

    public Product getProductByID(int id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PRODUCT_BY_ID)){
            preparedStatement.setInt(1, id);
            return getProductFromDB(preparedStatement);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private Product getProductFromDB(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        Product product = null;

        if (resultSet.next()){
            product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setImage(resultSet.getString("image"));
            product.setComposer(resultSet.getString("composer"));
            product.setPrice(resultSet.getDouble("price"));
            product.setCountOfMark(resultSet.getInt("count_of_marks"));
            product.setRating(resultSet.getDouble("rating"));
        }

        return product;
    }

    public boolean setMark(int mark, int productId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1, productId);
            Product product = getProductFromDB(preparedStatement);
            double currentRating = product.getRating();
            int currentCountOfMark = product.getCountOfMark();
            try (PreparedStatement preparedStatementForRating = connection.prepareStatement(SQL_CHANGE_RATING_BY_PRODUCT_ID)) {
                preparedStatementForRating.setInt(1, currentCountOfMark + 1);
                preparedStatementForRating.setDouble(2, (currentRating*currentCountOfMark + mark)/(currentCountOfMark + 1));
                preparedStatementForRating.setInt(3, productId);
                preparedStatementForRating.executeUpdate();
            }
            return true;
        }
    }
}

