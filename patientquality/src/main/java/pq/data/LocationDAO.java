package pq.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import pq.domain.Location;
import pq.domain.Patient;

public class LocationDAO extends DAO {

	public Location getById(int locationId) {

		String query = "select *  from locations where locationid=?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		Location location = jdbcTemplate.queryForObject(query, new Object[] { locationId }, new RowMapper<Location>() {

			public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
				Location location = new Location(rs.getInt("locationid"), rs.getInt("organizationid"),
						rs.getString("locationname"), rs.getString("shortname"));
				return location;
			}
		});

		return location;
	}

}
