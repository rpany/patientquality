package pq.rest;

import org.apache.log4j.Logger;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import pq.domain.User;
import pq.service.UserService;

@Path("/authenticate")
public class AuthenticationRestService {
	private static final Logger log = Logger.getLogger(AuthenticationRestService.class);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password) {
		
		UserService userService = new UserService();

		try {

			// Authenticate the user using the credentials provided
			log.debug("Into the service with credentials " + username + " - " + password);
			String token = issueToken();
			User user = userService.getUser(username, password, token);

			// Issue a token for the user

			// Return the token on the response
			ResponseBuilder res = Response.ok(user);
			return res.build();

		} catch (Exception e) {
			System.out.println(e);
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}

	}

	private String issueToken() {

		String uuid = UUID.randomUUID().toString();

		return uuid;

	}
	

	
	

}