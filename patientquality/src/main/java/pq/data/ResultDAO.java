package pq.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import pq.domain.Result;

public class ResultDAO extends DAO{
	
	public Result getByResultDate(Date resultDate, int patientId) {

		String query = "select * from results where patientId = ? and resultdate > ? ORDER BY resultdate  DESC LIMIT 1";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		Result result = jdbcTemplate.queryForObject(query, new Object[] { patientId, resultDate }, new RowMapper<Result>() {

			public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
				Result result = new Result(rs.getInt("resultid"), rs.getInt("patientid"), rs.getString("bloodculture"), rs.getString("organism"));

				return result;
			}
		});

		return result;
	}

}
