package Controller.SignUp;

import Dao.UserDao;
import Model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SignUpServlet", urlPatterns = "/SignUp")
public class SignUpServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Users> userList = null;
        Users user=null;
        String fullName = request.getParameter("name");
        String userName = request.getParameter("email");
        String pass = request.getParameter("pass");

         user = new Users(userName,fullName,pass);
        try {
            userList = userDao.selectAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Users users1 : userList){
            if (user.getUserName().equals(users1.getUserName())){
//                user=new Users();
                request.setAttribute("mess","Username already exists !!!");
                response.sendRedirect("/SignUp");
                return;
            }
        }
        userDao.createUser(user);
        request.setAttribute("mess","Sign Up Success !!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SignUp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("signUp/SignUp.jsp");
        dispatcher.forward(request,response);
    }
}
