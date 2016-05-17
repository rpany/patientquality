package pq.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import pq.domain.Procedure;
import pq.rest.PatientsRestService;

public class ProcedureDAO extends DAO {
	private static final Logger log = Logger.getLogger(ProcedureDAO.class);

	public List<Procedure> getProceduresByOrganizationId(int organizationId) {

		String sql = "SELECT * from procedures where organizationid =?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Procedure> rows = jdbcTemplate.query(sql, new Object[] { organizationId }, new RowMapper<Procedure>() {
			public Procedure mapRow(ResultSet rs, int rowNum) throws SQLException {
				Timestamp startTime = rs.getTimestamp("startTime");
				Timestamp endTime = rs.getTimestamp("endTime");
				
			//	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
				
				Procedure p = new Procedure(rs.getInt("procedureid"), rs.getInt("patientid"),
						rs.getString("procedureName"), rs.getInt("locationid"), startTime, endTime);
			//	log.debug(formatter.format(startTime) + "  " + formatter.format(endTime));
				return p;
			}

		});
		return rows;
	}

}
