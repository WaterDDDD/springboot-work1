package com.kai.springbootwork1.dao.Impl;

import com.kai.springbootwork1.constant.ProductCategory;
import com.kai.springbootwork1.dao.ProductDao;
import com.kai.springbootwork1.model.Product;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/work?serverTimezone=Asia/Taipei&characterEncoding=utf-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "springboot";


    @Override
    public List<Product> getProduct(String keyword) {

        List<Product> products = new ArrayList<>();
        String sql = "SELECT product_name, category, price, stock FROM commodity " +
                "WHERE product_name LIKE ? OR category LIKE ?";


        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            String keyname = "%" + keyword + "%";
            preparedStatement.setString(1, keyname);
            preparedStatement.setString(2, keyname);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Product p = new Product();
                    p.setProductName(resultSet.getString("product_name"));
                    p.setCategory(ProductCategory.valueOf(resultSet.getString("category").toUpperCase()));
                    p.setPrice(resultSet.getInt("price"));
                    p.setStock(resultSet.getInt("stock"));

                    products.add(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;

    }
}
