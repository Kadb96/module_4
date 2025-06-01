package com.codegym.springformtutorial.repository;

import com.codegym.springformtutorial.model.Employee;
import com.codegym.springformtutorial.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeRepository implements IEmployeeRepository {
    private final String ADD = "INSERT INTO employee(id, name, contact_number) values (?, ?, ?, ?);";

    @Override
    public boolean add(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);
            preparedStatement.setString(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getContactNumber());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
