package model;

import exception.MyUncheckedException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserDao {

    private Connection connection;
    private final String databaseName = "people";
    private final String tableName = "employees";
    private final String user = "root";
    private final String password = "admin";

    public UserDao() {
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

    public List<User> getAllUsers() {
        List<User> users = new LinkedList<User>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                Integer age = resultSet.getInt("age");
                Integer id  = resultSet.getInt("id");
                User user = new User(id, name, lastname, age);
                users.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void createUser(User user) {
        PreparedStatement statement;
        try {
            String query = "insert into " + tableName + " (name, lastname, age) values(?, ?, ?)";
            statement = connection.prepareStatement(query);

            statement.setString(1, user.getName());
            statement.setString(2, user.getLastname());
            statement.setInt(3, user.getAge());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void upDateUser(User user){
        PreparedStatement statement;

        try {

            String query = "update " + tableName + " set name = ?, lastname = ?, age = ? where id =?";


            statement = connection.prepareStatement(query);

            statement.setString(1, user.getName());
            statement.setString(2, user.getLastname());
            statement.setInt(3, user.getAge());
            statement.setInt(4, user.getId());

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void deleteUser (String lastname){
        if( lastname == null || lastname == ""){
            throw new MyUncheckedException(" Bad input data");
        }

        List<User> userList = getAllUsers();
        Optional<User> optionalUser =  userList.stream().filter(f->f.getLastname().equals(lastname)).findFirst();
        if(optionalUser.isPresent()){
            PreparedStatement statement;
            try {

                String query = "delete from " + tableName + " where lastname=?";
                statement = connection.prepareStatement(query);

                statement.setString(1, lastname);

                statement.execute();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else{
            throw new MyUncheckedException(" there is no User with " + lastname + " in database");
        }

    }

    public void updateUser(User user){
        PreparedStatement statement;
        try{
            String query = "update" + tableName + "set name = ?, lastname = ?, age = ? where id=?";
            statement = connection.prepareStatement(query);
            statement.setString(1,user.getName());
            statement.setString(2,user.getName());
            statement.setString(3,user.getName());
            statement.setString(4,user.getName());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
