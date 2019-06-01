package javaspringexamples.springJDBC.namedParameter;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setUserName(rs.getString("user_name"));
		user.setAccessTime(rs.getTimestamp("access_time"));
		user.setLocked(rs.getBoolean("locked"));
		return user;
	}

}
