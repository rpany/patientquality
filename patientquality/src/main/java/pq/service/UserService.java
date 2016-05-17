package pq.service;

import pq.data.TokenDAO;
import pq.data.UserDAO;
import pq.domain.Token;
import pq.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Repository
public class UserService {

	
	public boolean validateToken(String token){
		TokenDAO tokendao = new TokenDAO();
		Token tk = tokendao.getToken(token);
		
		if(tk.getTokenId().equalsIgnoreCase(token)){
			return true;
		} else{
			return false;
		}
	}
	
	
	public User getUser(String username, String password, String token){
		UserDAO userdao = new UserDAO();
		User user = userdao.getByUsernamePassword(username, password);
		user.setToken(token);
		TokenDAO tokendao = new TokenDAO();
		tokendao.saveToken(user, token);
		return user;
	}


}