package pq.data;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO {
	
	protected DataSource dataSource;

	public DAO(){
		  try {
			Context ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/infectiondb");
		  } catch (NamingException e) {
			e.printStackTrace();
		  }
		}

}
