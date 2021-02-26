package Dao;

import Model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao extends DBDAO implements IBDAO<Author> {
    private final String SELECT_ALL_AUTHOR = "SELECT * FROM author";
    private final String ADD_AUTHOR = "INSERT INTO author(name) VALUES (?)";
    private final String FIND_ID_AUTHOR = "SELECT * FROM author WHERE id = ?";
    private final String UPDATE_AUTHOR = "UPDATE author SET name = ? WHERE id = ?";
    private final String DELET_POST = "DELETE from post where idCategory = ?";
    private final String DELETE_AUTHOR = "DELETE FROM author WHERE id = ?";
    @Override
    public List<Author> selectAll() throws SQLException {
        List<Author> list = new ArrayList<>();

        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHOR);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        )
        {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Author author = new Author(id,name);
                list.add(author);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(Author object) throws SQLException {
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(ADD_AUTHOR)
                )
        {
            preparedStatement.setString(1,object.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Save(Author object) throws SQLException {

    }

    @Override
    public Author findById(int id) throws SQLException{
        Author author = null;
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(FIND_ID_AUTHOR);
                )
        {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idAuthor = resultSet.getInt("id");
                String name = resultSet.getString("name");
                author = new Author(idAuthor,name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return author;
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

            preparedStatement = connection.prepareStatement(DELETE_AUTHOR);
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
    public boolean update(Author object) throws SQLException {
        boolean update = false;
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AUTHOR);
                )
        {
            preparedStatement.setString(1,object.getName());
            preparedStatement.setInt(2,object.getId());
            update = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return update;
    }
}
