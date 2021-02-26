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
import java.util.List;

@WebServlet(name = "AddServlet", urlPatterns = "/addPost")
public class AddServlet extends HttpServlet {
    PostDao postDao = new PostDao();
    AuthorDao authorDao = new AuthorDao();
    CategoryDao categoryDao = new CategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String title = request.getParameter("title");
            String fullContent = request.getParameter("fullContent");
            String shortContent = request.getParameter("shortContent");
            String image = request.getParameter("image");

            int id = Integer.parseInt(request.getParameter("category"));
            Category category = new Category(id);

            int idAuthor = Integer.parseInt(request.getParameter("author"));
            Author author = new Author(idAuthor);

            Post post = new Post(title,fullContent,shortContent,image, author, category);

            postDao.insert(post);
            request.setAttribute("mess","Add post is success");
            List<Post> list = null;
            List<Category> listCategory = null;
            List<Author> authorList = null;
            list = postDao.selectAll();
            request.setAttribute("list", list);

            listCategory = categoryDao.selectAll();
            request.setAttribute("listCategory",listCategory);

            authorList = authorDao.selectAll();
            request.setAttribute("listAuthor",authorList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/addPost.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            response.sendRedirect("/errerroPost?code=01");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            List<Post> list = null;
            List<Category> listCategory = null;
            List<Author> authorList = null;
            list = postDao.selectAll();
            request.setAttribute("list", list);

            listCategory = categoryDao.selectAll();
            request.setAttribute("listCategory",listCategory);

            authorList = authorDao.selectAll();
            request.setAttribute("listAuthor",authorList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("startbootstrap/dist/addPost.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            response.sendRedirect("/errerroPost?code=01");
        }


    }
}
