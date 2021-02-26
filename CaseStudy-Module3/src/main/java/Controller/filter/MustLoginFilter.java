package Controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MustLoginFilter", urlPatterns = {"/list", "/addAuthor", "/addCategory", "/addPost", "/deleteAuthor", "/deleteCategory", "/deletePost", "/editAuthor","/editCategory", "/editPost","/errerroPost", "/manageAuthor","/manageCategory"})
public class MustLoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        // loi session ve
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        // kiem tra thuoc tinh user trong session
        if (user == null) {
            // k co -> chua dang nhap -> day ve trang login
            response.sendRedirect("/login");
        } else {
            // co roi -> cho qua
            chain.doFilter(req, resp);
        }
    }

}
