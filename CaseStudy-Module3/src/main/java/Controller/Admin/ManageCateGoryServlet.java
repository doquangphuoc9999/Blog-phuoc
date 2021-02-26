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

@WebServlet(name = "ManageCateGoryServlet", urlPatterns = "/manageCategory")
public class ManageCateGoryServlet extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategory = null;
        try {
            listCategory = categoryDao.selectAll();
            request.setAttribute("listCategory",listCategory);

            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/listCategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            response.sendRedirect("/errerroPost?code=01");
        }

    }
}
