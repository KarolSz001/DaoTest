package model;


import enums.Roles;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRoleDao {

    private Connection connection;
    private final String databaseName = "people";
    private final String tableName = "roles";
    private final String user = "root";
    private final String password = "admin";

    public UserRoleDao() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<UserRole> getAllUserRoles() {
        List<UserRole> userRoles = new LinkedList<UserRole>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = " select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("role");
                userRoles.add(new UserRole(id, Roles.valueOf(name)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userRoles;
    }

    public UserRole getUserRoleById(Integer id) {
        Statement statement = null;
        try {
            String query = "select * from " + tableName + " where id = '" + id + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String role = resultSet.getString("role");
                Roles roles = Roles.valueOf(role);
                return new UserRole(id, roles);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Integer getRoleIdByName(String roleName) {
        Statement statement = null;
        try {
            String query = "select * from " + tableName + " where role = '" + roleName + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                return id;
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}

