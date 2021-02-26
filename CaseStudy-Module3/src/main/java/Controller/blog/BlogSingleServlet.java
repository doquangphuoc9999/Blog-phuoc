package Controller.blog;

import Dao.PostDao;
import Model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Blog-Single-Servlet", urlPatterns = "/blogSingle")
public class BlogSingleServlet extends HttpServlet {
    PostDao postDao = new PostDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Post postList = null;
        List<Post> listRandom = new ArrayList<Post>();
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            postList = postDao.findById(id);
            listRandom = postDao.limit_new_post();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("list",listRandom);
        request.setAttribute("postListPageSingle",postList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homeBlog/blogSingle.jsp");
        dispatcher.forward(request,response);
    }
}
