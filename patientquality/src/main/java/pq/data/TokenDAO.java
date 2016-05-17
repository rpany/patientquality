package pq.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import pq.domain.Token;
import pq.domain.User;

public class TokenDAO extends DAO {

	public int saveToken(User user, String token) {
		String insert = "INSERT into usertokens (tokenid, userid, insertdts, updatedts) VALUES(?,?, now(), now())";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		return jdbcTemplate.update(insert, token, user.getUserId());

	}

	public Token getToken(String token) {
		String query = "select tokenid, userid, updatedts, insertdts from usertokens where tokenid = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		Token tk = jdbcTemplate.queryForObject(query, new Object[] { token }, new RowMapper<Token>() {
			public Token mapRow(ResultSet rs, int rowNum) throws SQLException {
				Token tk = new Token(rs.getString("tokenid"), rs.getDate("insertdts"), rs.getDate("updatedts"),
						rs.getInt("userid"));
				return tk;
			}
		});
		return tk;
	}

	public int updateToken(String token) {
		String update = "UPDATE usertokens SET (updatedts=now()) WHERE tokenid = ?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		return jdbcTemplate.update(update, token);

	}

}
