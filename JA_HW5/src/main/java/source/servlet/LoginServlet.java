package source.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.domain.User;
import source.service.UserService;
import source.service.impl.UserServiceImpl;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
        request.getRequestDispatcher("login.jsp").forward(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email);
        
        User user = userService.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            request.setAttribute("email", email);
            request.getRequestDispatcher("cabinet.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}
