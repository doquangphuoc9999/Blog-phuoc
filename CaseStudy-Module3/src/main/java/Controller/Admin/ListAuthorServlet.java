package Controller.Admin;

import Dao.AuthorDao;
import Model.Author;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ListAuthorServlet", urlPatterns = "/manageAuthor")
public class ListAuthorServlet extends HttpServlet {
    AuthorDao authorDao = new AuthorDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Author> list = null;
        try {
            list = authorDao.selectAll();
            request.setAttribute("listAuthor",list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/listAuthor.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            response.sendRedirect("/errerroPost?code=01");
        }

    }
}
