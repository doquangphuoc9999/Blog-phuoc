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

@WebServlet(name = "searchTitleServlet", urlPatterns = "/searchTitle")
public class searchTitleServlet extends HttpServlet {
    PostDao postDao = new PostDao();
    CategoryDao categoryDao = new CategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> listPostByTitle = null;
        List<Category> categoryList = null;
        List<Post> listLimit = null;
        String title = request.getParameter("title");

        listPostByTitle = postDao.searchTitlePost(title);
        if (listPostByTitle.size() < 1){
            request.setAttribute("messs","No post not found");
        }
        try {
            categoryList = categoryDao.selectAll();
            listLimit = postDao.limit_new_post();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("listNew",listLimit);
        request.setAttribute("listCategory",categoryList);
        request.setAttribute("ListPostByTitle", listPostByTitle);

        RequestDispatcher dispatcher = request.getRequestDispatcher("homeBlog/search.jsp");
        dispatcher.forward(request,response);
    }
}
