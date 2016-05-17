package pq.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.springframework.util.SystemPropertyUtils;

import pq.domain.Procedure;
import pq.response.PatientProcedureResult;
import pq.service.PatientService;
import pq.service.UserService;

@Path("/patients")
public class PatientsRestService {
	private static final Logger log = Logger.getLogger(PatientsRestService.class);

	
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProcedures(@HeaderParam("authToken") String authToken) {
		log.debug("Into the patient service with token " + authToken);
		PatientService patient = new PatientService();
		UserService user = new UserService();
		
		
		try {
			
			if (!user.validateToken(authToken)) {
				return Response.status(Response.Status.UNAUTHORIZED).build();
			} 
			
		
			

			// Authenticate the user using the credentials provided
			
			
			List<PatientProcedureResult> outputs = patient.getAllQualityIssuesForOrganization(authToken);
			
		
			// Issue a token for the user

			// Return the token on the response
			ResponseBuilder res = Response.ok(outputs);
			return res.build();

		} catch (Exception e) {
			System.out.println(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		
		
		

	}

}
