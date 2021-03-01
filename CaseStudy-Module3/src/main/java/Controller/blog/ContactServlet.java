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

@WebServlet(name = "ContactServlet", urlPatterns = "/contact")
public class ContactServlet extends HttpServlet {
    PostDao postDao = new PostDao();
    CategoryDao categoryDao = new CategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> list = null;
        List<Post> RandomNewPost = null;
        List<Category> listCategory = null;
        list = postDao.limit_new_post();
        try {
            listCategory = categoryDao.selectAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("listNewPost",list);
        RandomNewPost = postDao.random_list_post();
        request.setAttribute("randDomList", RandomNewPost);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homeBlog/contact.jsp");
        dispatcher.forward(request,response);
    }
}
