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

@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();
    PostDao postDao = new PostDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = null;
        List<Category> categoryList = null;
        List<Post> postList = null;
        List<Post> listPostByCateGory = null;
        List<Post> listLimitNewPost = null;
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            category = categoryDao.findById(id);
            postList = postDao.selectAll();
            listPostByCateGory = postDao.listPostByIdCategory(id);
            listLimitNewPost = postDao.limit_new_post();
            categoryList = categoryDao.selectAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("listCategory",categoryList);
        request.setAttribute("listNewPost",listLimitNewPost);
        request.setAttribute("postListByCategory",listPostByCateGory);
        request.setAttribute("postLists", postList);
        request.setAttribute("categoryPost",category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homeBlog/category.jsp");
        dispatcher.forward(request,response);
    }
}
