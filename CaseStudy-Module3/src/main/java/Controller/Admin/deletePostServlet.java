package Controller.Admin;

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
import java.util.List;

@WebServlet(name = "deletePostServlet",urlPatterns = "/deletePost")
public class deletePostServlet extends HttpServlet {
    PostDao postDao = new PostDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> postList = null;
        try {
            int id = Integer.parseInt(request.getParameter("idPost"));
            postDao.delete(id);
            postList = postDao.selectAll();
            request.setAttribute("listPost",postList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/listPost.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            response.sendRedirect("/errerroPost?code=01");
        }

    }
}
