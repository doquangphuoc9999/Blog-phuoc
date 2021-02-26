package Dao;

import Model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends DBDAO implements IBDAO<Category> {
    private final String SELECT_ALL_CATEGORY = "SELECT * FROM category";
    private final String ADD_CATEGORY = "INSERT INTO category(nameCategory) VALUES (?)";
    private final String FIND_BY_ID_CATEGORY = "select * from category WHERE id = ?";
    private final String UPDATE_CATEGORY = "UPDATE category SET nameCategory = ? WHERE id = ?";
    private final String DELETE_CATEGORY = "DELETE FROM category WHERE id = ?";
    public final String DELET_POST = "DELETE from post where idCategory = ?";
    @Override
    public List<Category> selectAll() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
       try(
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
        ResultSet resultSet = preparedStatement.executeQuery();
       )
       {
           while (resultSet.next()){
               int id = resultSet.getInt("id");
               String nameCategory = resultSet.getString("nameCategory");
               Category category = new Category(id,nameCategory);
               categoryList.add(category);
           }
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       return categoryList;
    }

    @Override
    public void insert(Category object) throws SQLException{
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(ADD_CATEGORY);
                )
        {
            preparedStatement.setString(1,object.getNameCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Save(Category object) throws SQLException {

    }

    @Override
    public Category findById(int id) throws SQLException{
        Category category = null;
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_CATEGORY);
                        )

        {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int idCategory = resultSet.getInt("id");
                String nameCategory = resultSet.getString("nameCategory");
                category = new Category(idCategory,nameCategory);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean delete = false;
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(DELET_POST);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(DELETE_CATEGORY);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
            return delete;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            connection.rollback();
            connection.close();
        }
        return delete = true;
    }

    @Override
    public boolean update(Category object) throws SQLException {
        boolean list = false;
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY);
                        )
        {
            preparedStatement.setString(1,object.getNameCategory());
            preparedStatement.setInt(2,object.getId());
            list = preparedStatement.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
