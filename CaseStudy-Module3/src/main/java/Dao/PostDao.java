package Dao;

import Model.Author;
import Model.Category;
import Model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostDao extends DBDAO implements IBDAO<Post> {
    private final String SELECT_ALL_POST = "SELECT post.*,category.nameCategory,author.name from (post left join category ON post.idCategory = category.id) left join author on post.idAuthor =  author.id";
    private final String ADD_POST = "INSERT INTO post(title, fullContent, shortContent, image, idCategory, idAuthor) VALUES (?, ?, ?, ?, ?, ?)";
    private final String UPDATE_POST = "update post set title = ?, fullContent = ?, shortContent = ?, image = ?,idCategory=?,idAuthor=?  where id = ?";
    private final String FIND_BY_ID_POST = "SELECT post.*,category.nameCategory,author.name from (post left join category ON post.idCategory = category.id) left join author on post.idAuthor =  author.id WHERE post.id = ?";
    private final String LIMIT_NEW_POST = "select post.*,  nameCategory, name from(post left join category on post.idCategory = category.id) left join author on post.idAuthor =author.id order by post.id desc limit 3";
    private final String DELETE_POST = "DELETE FROM post WHERE id = ?";
    private final String RANDOM_LIST_POST = "select post.*,  nameCategory, name from(post left join category on post.idCategory = category.id) left join author on post.idAuthor =author.id order by rand() limit 3";
    private final String SELECT_BYID_CATEGORY = "select post.*,  nameCategory, name from(post left join category on post.idCategory = category.id) left join author on post.idAuthor =author.id where post.idCategory = ?";
    private final String SEARCH_TITLE_POST = "SELECT post.*,category.nameCategory,author.name from (post left join category ON post.idCategory = category.id) left join author on post.idAuthor =  author.id WHERE post.title like concat('%',?,'%')";

    public List<Post> searchTitlePost(String titles){
        List<Post> list = new ArrayList<>();
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_TITLE_POST);
                )
        {
            preparedStatement.setString(1,titles);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idPost = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String fullContent = resultSet.getString("fullContent");
                String shortContent = resultSet.getString("shortContent");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, name);
                int idAuthor = resultSet.getInt("idAuthor");
                String authorName = resultSet.getString("name");
                Author author = new Author(idAuthor,authorName);
                Post post = new Post(idPost,title,fullContent,shortContent,dateTime,image,author,category);
                list.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    public List<Post> listPostByIdCategory(int id){
        List<Post> list = new ArrayList<>();
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BYID_CATEGORY);
                )
        {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idPost = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String fullContent = resultSet.getString("fullContent");
                String shortContent = resultSet.getString("shortContent");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, name);
                int idAuthor = resultSet.getInt("idAuthor");
                String authorName = resultSet.getString("name");
                Author author = new Author(idAuthor,authorName);
                Post post = new Post(idPost,title,fullContent,shortContent,dateTime,image,author,category);
                list.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }



    public List<Post> random_list_post(){
        List<Post> list = new ArrayList<>();
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(RANDOM_LIST_POST);
                        ResultSet resultSet = preparedStatement.executeQuery();
                )
        {
            while (resultSet.next()){
                int idPost = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String fullContent = resultSet.getString("fullContent");
                String shortContent = resultSet.getString("shortContent");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, name);
                int idAuthor = resultSet.getInt("idAuthor");
                String authorName = resultSet.getString("name");
                Author author = new Author(idAuthor,authorName);
                Post post = new Post(idPost,title,fullContent,shortContent,dateTime,image,author,category);
                list.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    public List<Post> limit_new_post(){
        List<Post> list = new ArrayList<>();
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(LIMIT_NEW_POST);
                        ResultSet resultSet = preparedStatement.executeQuery();
                )
        {
            while (resultSet.next()){
                int idPost = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String fullContent = resultSet.getString("fullContent");
                String shortContent = resultSet.getString("shortContent");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, name);
                int idAuthor = resultSet.getInt("idAuthor");
                String authorName = resultSet.getString("name");
                Author author = new Author(idAuthor,authorName);
                Post post = new Post(idPost,title,fullContent,shortContent,dateTime,image,author,category);
                list.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Post> selectAll() throws SQLException{
        List<Post> postList = new ArrayList<>();
        try
        (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POST);
                ResultSet resultSet = preparedStatement.executeQuery();
        )
        {
            while (resultSet.next()){
                int idPost = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String fullContent = resultSet.getString("fullContent");
                String shortContent = resultSet.getString("shortContent");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, name);
                int idAuthor = resultSet.getInt("idAuthor");
                String authorName = resultSet.getString("name");
                Author author = new Author(idAuthor,authorName);
                Post post = new Post(idPost,title,fullContent,shortContent,dateTime,image,author,category);
                postList.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }

    @Override
    public void insert(Post object) throws SQLException{
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(ADD_POST);

                        )
        {
            preparedStatement.setString(1,object.getTitle());
            preparedStatement.setString(2,object.getFullContent());
            preparedStatement.setString(3,object.getShortContent());
            preparedStatement.setString(4,object.getImage());
            preparedStatement.setInt(5,object.getCategory().getId());
            preparedStatement.setInt(6,object.getAuthor().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Save(Post object) throws SQLException {

    }

    @Override
    public Post findById(int id) throws SQLException{
        Post post = null;
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_POST)
                        )
        {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String title = resultSet.getString("title");
                String fullContent = resultSet.getString("fullContent");
                String shortContent = resultSet.getString("shortContent");
                String str = resultSet.getString("publisht");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, name);
                int idAuthor = resultSet.getInt("idAuthor");
                String authorName = resultSet.getString("name");
                Author author = new Author(idAuthor,authorName);
                post = new Post(id,title,fullContent,shortContent,dateTime,image,author,category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return post;
    }

    @Override
    public boolean delete(int id) throws SQLException{
        boolean rowDelete = false;
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_POST);
                        )
        {
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() >0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }
    @Override
    public boolean update(Post object) throws SQLException{
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement statement = connection.prepareStatement(UPDATE_POST);
                        )
        {
            statement.setString(1,object.getTitle());
            statement.setString(2,object.getFullContent());
            statement.setString(3,object.getShortContent());
            statement.setString(4,object.getImage());
            statement.setInt(5,object.getCategory().getId());
            statement.setInt(6,object.getAuthor().getId());
            statement.setInt(7,object.getIdPost());
            statement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
