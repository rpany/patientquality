package pq.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import pq.domain.User;

public class UserDAO extends DAO {

	public User getByUsernamePassword(String username, String password) {

		String query = "select userid, firstname, lastname, email, organizationid from users where email = ? and password = ?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		User usr = jdbcTemplate.queryForObject(query, new Object[] { username, password }, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User usr = new User();
				usr.setUserId(rs.getInt("userid"));
				usr.setFirstName(rs.getString("firstname"));
				usr.setLastName(rs.getString("lastname"));
				usr.setEmail(rs.getString("email"));
				usr.setOrganizationId(rs.getInt("organizationid"));

				return usr;
			}
		});

		return usr;
	}

	public User getByUserId(int userId) {

		String query = "select userid, firstname, lastname, email, organizationid from users where userId = ?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		User usr = jdbcTemplate.queryForObject(query, new Object[] { userId}, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User usr = new User();
				usr.setUserId(rs.getInt("userid"));
				usr.setFirstName(rs.getString("firstname"));
				usr.setLastName(rs.getString("lastname"));
				usr.setEmail(rs.getString("email"));
				usr.setOrganizationId(rs.getInt("organizationid"));

				return usr;
			}
		});

		return usr;
	}

}
