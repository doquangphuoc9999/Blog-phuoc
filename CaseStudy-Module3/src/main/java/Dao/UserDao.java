package Dao;

import Model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends DBDAO implements IUSER<Users> {

    private final String SELECT_ALL_USER = "SELECT * FROM Users";
    private final String FIND_ID_USER = "SELECT * FROM Users WHERE id = ?";
    private final String FIND_BY_UP = "SELECT * FROM Users WHERE userName = ? AND passwordUser = ? ";
    private final String SAVE_USER = "INSERT INTO Users(userName, passwordUser,fullName) VALUES(?,?,?)";
    private final String UPDATE_USER = "UPDATE Users SET userName = ?, fullName = ? WHERE id = ?";
    private final String DELETE_USER = "DELETE FROM Users WHERE id = ?";
    private final String CREATE_USER = "INSERT INTO Users(userName, passwordUser, fullName, statusUser) VALUES (?, ?,?, 0)";


    public void createUser(Users object){
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
                )
        {
            preparedStatement.setString(1,object.getUserName());
            preparedStatement.setString(2,object.getPasswordUser());
            preparedStatement.setString(3,object.getFullName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public List<Users> selectAll() throws SQLException {
        List<Users> list = new ArrayList<>();
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(this.SELECT_ALL_USER);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        )
        {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String fullName = resultSet.getString("fullName");

                Users users = new Users(id,userName,fullName);
                list.add(users);


            }
        }
        return list;
    }

    @Override
    public void insert(Users object) throws SQLException {

    }

    @Override
    public void Save(Users object) throws SQLException {
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER);
                )
        {
           preparedStatement.setString(1,object.getUserName());
           preparedStatement.setString(2,object.getPasswordUser());
           preparedStatement.setString(3, object.getFullName());
           preparedStatement.executeUpdate();
        }
    }

    @Override
    public Users findById(int id) throws SQLException {
        Users users = null;
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_USER);
                )
        {
                        preparedStatement.setInt(1,id);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()){
                            String userName = resultSet.getString("userName");
                            String fullName = resultSet.getString("fullName");

                           users = new Users(id,userName,fullName);
                        }
        }
        return users;
    }

    @Override
    public Users finByUserNamePassword(String userName, String password) {
        Users users = null;
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_UP);
                )
        {
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String fullName = resultSet.getString("fullName");
                int status = resultSet.getInt("statusUser");
                int id = resultSet.getInt("id");
                users = new Users(id,userName,fullName,status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean delete = false;

        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(this.DELETE_USER);
                        )
        {
            preparedStatement.setInt(1,id);
            delete = preparedStatement.executeUpdate() > 0;

        }
        return delete;
    }

    @Override
    public boolean update(Users object) throws SQLException {
        boolean update = false;
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(this.UPDATE_USER);
                )
        {
            preparedStatement.setString(1,object.getUserName());
            preparedStatement.setString(2,object.getFullName());
            preparedStatement.setInt(3,object.getId());
            update = preparedStatement.executeUpdate() > 0;
        }
        return update;
    }
}
