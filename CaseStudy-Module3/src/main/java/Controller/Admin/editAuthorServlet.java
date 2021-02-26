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

@WebServlet(name = "editAuthorServlet", urlPatterns = "/editAuthor")
public class editAuthorServlet extends HttpServlet {
    AuthorDao authorDao = new AuthorDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Author author = new Author(id,name);
            authorDao.update(author);
            request.setAttribute("mess","Update author is success");
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/editAuthor.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            response.sendRedirect("/errerroPost?code=01");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        Author author = null;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            author = authorDao.findById(id);
            request.setAttribute("listAuthor", author);

            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/editAuthor.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            response.sendRedirect("/errerroPost?code=01");
        }

    }
}
