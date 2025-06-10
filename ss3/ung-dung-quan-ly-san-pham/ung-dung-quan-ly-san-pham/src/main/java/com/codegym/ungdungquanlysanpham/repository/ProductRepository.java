package com.codegym.ungdungquanlysanpham.repository;

import com.codegym.ungdungquanlysanpham.model.Product;
import com.codegym.ungdungquanlysanpham.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    //    cac cau query duoc su dung
    private final String SHOW_ALL = "SELECT * FROM product";
    private final String SHOW_BY_ID = "SELECT * FROM product WHERE id = ?";
    private final String SAVE = "INSERT INTO product(id, name, price, description, producer) " +
            "VALUES(?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE product " +
            "SET name = ?, price = ?, description = ?, producer = ? " +
            "WHERE id = ?;";
    private final String DELETE_BY_ID = "DELETE FROM product WHERE id = ?;";


    @Override
    public List<Product> findAll() {
        List<Product> customers = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                long price = resultSet.getLong("price");
                String description = resultSet.getString("description");
                String producer = resultSet.getString("producer");
                Product product = new Product(id, name, price, description, producer);
                customers.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public Product findById(String id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                long price = resultSet.getLong("price");
                String description = resultSet.getString("description");
                String producer = resultSet.getString("producer");
                Product product = new Product(id, name, price, description, producer);
                return product;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean save(Product product) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setString(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setLong(3, product.getPrice());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getProducer());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Product product) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getProducer());
            preparedStatement.setString(5, product.getId());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
