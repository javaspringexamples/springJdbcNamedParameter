package javaspringexamples.springJDBC.namedParameter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class Main {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Conf.class);

		UserDao userDao = applicationContext.getBean(UserDao.class);

		List<User> users = new ArrayList<>();
		users.addAll(userDao.findByUserName("jsmith"));
		users.addAll(userDao.findLocked(false));
		users.add(userDao.findById(65L));

		for (User user : users)
			System.out.println(user.toString());
	}
}