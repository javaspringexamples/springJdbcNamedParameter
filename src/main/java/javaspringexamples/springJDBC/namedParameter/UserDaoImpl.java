package javaspringexamples.springJDBC.namedParameter;

import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private UserRowMapper userRowMapper = new UserRowMapper();

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	}

	public User findById(long userId) {
		return jdbcTemplate.queryForObject("SELECT id, name, user_name, access_time, locked FROM USER WHERE id = ?",
				userRowMapper, userId);
	}

	public List<User> findByUserName(String userName) {
		return namedParameterJdbcTemplate.query(
				"SELECT id, name, user_name, access_time, locked FROM USER WHERE user_name = :userName",
				Collections.singletonMap("userName", userName), userRowMapper);
	}

	public List<User> findLocked(boolean locked) {
		return namedParameterJdbcTemplate.query(
				"SELECT id, name, user_name, access_time, locked FROM USER WHERE locked = :locked",
				Collections.singletonMap("locked", locked), userRowMapper);
	}
}
