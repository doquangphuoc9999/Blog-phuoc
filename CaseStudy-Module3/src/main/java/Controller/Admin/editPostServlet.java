package Controller.Admin;

import Dao.AuthorDao;
import Dao.CategoryDao;
import Dao.PostDao;
import Model.Author;
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

@WebServlet(name = "editPostServlet", urlPatterns = "/editPost")
public class editPostServlet extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();
    AuthorDao authorDao = new AuthorDao();
    PostDao postDao = new PostDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String shortContent = request.getParameter("shortContent");
            String fullContent = request.getParameter("fullContent");
            String image = request.getParameter("image");
            int idCategory = Integer.parseInt(request.getParameter("category"));
            Category category = new Category(idCategory);
            int idAuthor = Integer.parseInt(request.getParameter("author"));
            Author author = new Author(idAuthor);
            Post post = new Post(id,title,fullContent,shortContent,image,author,category);

            postDao.update(post);
            request.setAttribute("mess","Update is success");
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/editPost.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            response.sendRedirect("/errerroPost?code=01");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        Post post = null;

        try {
            int id = Integer.parseInt(request.getParameter("idPost"));
            post = postDao.findById(id);
            request.setAttribute("posts",post);

            List<Category> list = null;
            list = categoryDao.selectAll();
            request.setAttribute("listCategory", list);


            List<Author> authorList = null;
            authorList = authorDao.selectAll();
            request.setAttribute("listAuthor",authorList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/editPost.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            response.sendRedirect("/errerroPost?code=01");
        }
    }
}
