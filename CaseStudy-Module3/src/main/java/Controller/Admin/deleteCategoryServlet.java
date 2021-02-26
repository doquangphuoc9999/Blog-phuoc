package Controller.Admin;

import Dao.CategoryDao;
import Model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "deleteCategoryServlet", urlPatterns = "/deleteCategory")
public class deleteCategoryServlet extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = null;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            categoryDao.delete(id);
            list = categoryDao.selectAll();
            request.setAttribute("listCategory", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/listCategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            response.sendRedirect("/errerroPost?code=01");
        }




    }
}
