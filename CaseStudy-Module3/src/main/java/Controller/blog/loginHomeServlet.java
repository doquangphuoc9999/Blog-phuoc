package Controller.blog;

import Dao.UserDao;
import Model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginHomeServlet", urlPatterns = "/login")
public class loginHomeServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        Users users = userDao.finByUserNamePassword(email,pass);

//      Đăng nhập thành công
        if (users != null){
            HttpSession session = request.getSession();
            session.setAttribute("userName", users.getFullName());
            session.setAttribute("user",users);
            response.sendRedirect("/homeBlog");
        }else {
//           Đăng nhập thất bại
            HttpSession session = request.getSession();
            session.setAttribute("message","   Wrong!!!!, Please try again");
            response.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("loginBlog/Login_v2/login.jsp");
        dispatcher.forward(request,response);
    }
}
