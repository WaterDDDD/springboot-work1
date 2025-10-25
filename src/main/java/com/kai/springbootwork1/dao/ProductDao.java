package com.kai.springbootwork1.dao;

import com.kai.springbootwork1.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProduct(String keyword);
}
