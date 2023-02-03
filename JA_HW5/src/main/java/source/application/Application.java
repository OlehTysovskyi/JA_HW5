package source.application;

import java.sql.SQLException;

import source.domain.User;
import source.service.impl.UserServiceImpl;

public class Application {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.create(new User("oleg.tisovsky228@gmail.com", "Oleh", "Tysovskiy", "admin", "12345678"));
	}

}
