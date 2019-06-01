package javaspringexamples.springJDBC.namedParameter;

import java.util.List;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public interface UserDao {
	public User findById(long usertId);
	public List<User> findByUserName(String userName);
	public List<User> findLocked(boolean locked);
}