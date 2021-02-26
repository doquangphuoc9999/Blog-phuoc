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

@WebServlet(name = "addCategoryServlet", urlPatterns = "/addCategory")
public class addCategoryServlet extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String nameCategory = request.getParameter("nameCategory");
            Category category = new Category(nameCategory);
            categoryDao.insert(category);
            request.setAttribute("mess","Add category is success");
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/addcategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception throwables) {
            response.sendRedirect("/errerroPost?code=01");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/addcategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            response.sendRedirect("/errerroPost?code=01");
        }
    }
}
