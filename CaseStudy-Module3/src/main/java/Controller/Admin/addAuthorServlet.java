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

@WebServlet(name = "addAuthorServlet",urlPatterns = "/addAuthor")
public class addAuthorServlet extends HttpServlet {
    AuthorDao authorDao = new AuthorDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String name = request.getParameter("nameAuthor");
            Author author = new Author(name);
            authorDao.insert(author);
            request.setAttribute("mess","Add name author is success");
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/addAuthor.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException throwables) {
            response.sendRedirect("/errerroPost?code=01");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/addAuthor.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            response.sendRedirect("/errerroPost?code=01");
        }
    }
}
