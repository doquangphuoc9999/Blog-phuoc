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

@WebServlet(name = "editCategoryServlet", urlPatterns = "/editCategory")
public class editCategoryServlet extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nameCategory = request.getParameter("nameCategory");
            Category category = new Category(id,nameCategory);
            categoryDao.update(category);
            request.setAttribute("mess", "Update category is success");
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/editCategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            response.sendRedirect("/errerroPost?code=01");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            Category category = null;
            int id = Integer.parseInt(request.getParameter("id"));
            category = categoryDao.findById(id);
            request.setAttribute("categorys", category);
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/editCategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            response.sendRedirect("/errerroPost?code=01");
        }

    }
}
