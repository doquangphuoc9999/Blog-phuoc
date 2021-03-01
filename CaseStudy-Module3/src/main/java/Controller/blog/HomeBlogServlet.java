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

@WebServlet(name = "HomeBlogServlet",urlPatterns = "/homeBlog")
public class HomeBlogServlet extends HttpServlet {
    PostDao postDao = new PostDao();
    CategoryDao categoryDao = new CategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> postList = null;
        List<Post> listLimit = null;
        List<Post> randomList = null;
        List<Category> categoryList = null;

        try {
            postList = postDao.selectAll();
            listLimit = postDao.limit_new_post();
            randomList = postDao.random_list_post();
            categoryList = categoryDao.selectAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//      lấy data từ list category
        request.setAttribute("listCategory",categoryList);

//      lấy dữ liệu limit 3 bài post mới nhất
        request.setAttribute("limitList",listLimit);

//      lấy dữ liệu các bài post ngẫu nhiên
        request.setAttribute("listRanDom", randomList);

//      lấy dữ liệu của list post
        request.setAttribute("listPost", postList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeBlog/homeBlog.jsp");
        requestDispatcher.forward(request,response);
    }
}
