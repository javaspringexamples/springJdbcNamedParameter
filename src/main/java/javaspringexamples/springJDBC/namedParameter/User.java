package javaspringexamples.springJDBC.namedParameter;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
@Data
public class User {
	private long id;
	private String name;
	private String userName;
	@ToString.Exclude
	private Date accessTime;
	private boolean locked;
}