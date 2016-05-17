package pq.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import pq.domain.Patient;
import pq.domain.User;

public class PatientDAO extends DAO {

	public Patient getById(int patientId) {

		String query = "select patientid, firstname, lastname, gender, dob, organizationid  from patients where patientid=?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		Patient patient = jdbcTemplate.queryForObject(query, new Object[] { patientId }, new RowMapper<Patient>() {

			public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
				Patient patient = new Patient(rs.getString("firstname"), rs.getString("lastname"), rs.getDate("dob"),
						rs.getString("gender"), rs.getInt("patientid"), rs.getInt("organizationId"));

				return patient;
			}
		});

		return patient;
	}

}