package source.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.domain.User;
import source.domain.UserRole;
import source.service.UserService;
import source.service.impl.UserServiceImpl;

@WebServlet(name = "registration", value = "/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");

		if (!email.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty()) {
			try {
				userService.create(new User(email, firstName, lastName, UserRole.USER.toString(), password));
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("email", email);
		request.getRequestDispatcher("cabinet.jsp").forward(request, response);
	}

}