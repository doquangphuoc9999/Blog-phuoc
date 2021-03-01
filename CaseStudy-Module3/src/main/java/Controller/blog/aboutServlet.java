package Controller.blog;

import Dao.CategoryDao;
import Dao.PostDao;
import Model.Category;
import Model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "aboutServlet", urlPatterns = "/aboutBlog")
public class aboutServlet extends HttpServlet {
    PostDao postDao = new PostDao();
    CategoryDao categoryDao = new CategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> list = null;
        List<Post> listNewPost = null;
        List<Post> random = null;
        List<Category> categoryList = null;
        try {
            list = postDao.selectAll();
            listNewPost = postDao.limit_new_post();
            random = postDao.random_list_post();
            categoryList = categoryDao.selectAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("listCategory", categoryList);
        request.setAttribute("randomList",random);
        request.setAttribute("newPost",listNewPost);
        request.setAttribute("listAll",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homeBlog/about.jsp");
        dispatcher.forward(request,response);
    }
}
